package me.polda18.log4shellblock;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Plugin's wrapper for core function
 */
public final class Log4ShellBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Log4ShellListener(this), this);
        getLogger().log(Level.INFO, "Plugin loaded and enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "Plugin disabled and unloaded");
    }
}
