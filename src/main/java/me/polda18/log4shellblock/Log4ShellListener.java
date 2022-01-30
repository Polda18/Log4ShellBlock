package me.polda18.log4shellblock;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.logging.Level;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Event listener that listens for chat or commands execution
 */
public class Log4ShellListener implements Listener {
    private Log4ShellBlock plugin;

    /**
     * Constructor: creates this event listener
     * @param plugin Plugin instance for access.
     */
    public Log4ShellListener(Log4ShellBlock plugin) {
        this.plugin = plugin;
    }

    /**
     * Private method to ban the player
     * @param player Player to be banned
     */
    private void ban(Player player) {
        String reason = "Potential Log4Shell attack. Permanently banned";
        plugin.getServer().getBanList(BanList.Type.NAME)
                .addBan(player.getName(), reason, null, "Console");

        player.kickPlayer(reason);
    }

    /**
     * Listens for the chat and detects JNDI lookup in chat message - if found, player is IP banned.
     * @param event Event that contains the chat message and its sender
     */
    @EventHandler
    public void onChat(@NotNull AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if(message.toLowerCase().contains("${jndi:")) {
            event.setCancelled(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> ban(event.getPlayer()));

            plugin.getLogger().log(Level.INFO,
                    "Chat message by "
                            + event.getPlayer().getName()
                            + " blocked for potential Log4Shell attack. Player was IP banned.");
        }
    }

    /**
     * Command listener for searching JNDI lookup and blocking it
     * @param event Event that gets fired when command is executed
     */
    @EventHandler (priority = EventPriority.HIGHEST)
    public void onCommand(@NotNull PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();

        if(message.toLowerCase().contains("${jndi:")) {
            event.setCancelled(true);
            ban(event.getPlayer());

            plugin.getLogger().log(Level.INFO,
                    "Chat message by "
                            + event.getPlayer().getName()
                            + " blocked for potential Log4Shell attack. Player was IP banned.");
        }
    }
}
