## Log4ShellBlock
This plugin is simply just a plug an play. Just install it, restart the server and you're ready to go.
No configuration, just go. What this plugin does it scans messages and commands for JNDI lookups,
which may be potential for harming a victim's computer by Log4Shell exploit. That is an arbitrary
remote code execution and it affected many applications using Log4j library in Java, including Minecraft.
You should give this plugin a try if you want to make your server secure, especially if you are using
an older version (like 1.8) that may not be patched.

This plugin is currently in beta snapshot testing phase, and is currently built for Spigot 1.12 API,
which is the oldest my IDE has offered to me. It may or may not work with older Minecraft versions,
this needs to be properly tested before the plugin can be released.

### How does it work?
It scans the contents of a message or command name, alias, label or arguments and seeks the
beginning of a JNDI lookup (JNDI lookup starts with `${jndi:`). This JNDI lookup has no place
in chat or in user controlled commands. When the plugin automatically detects this event,
the player in question is immediately kicked and permanently banned. There is currently no way
to change this behaviour, and isn't planned. Security of your server should be your highest
priority and players that are jokingly using this exploit to scare or troll should realize
the seriousness of this exploit and face the consequences for trying to do harm to your server
and/or your players. You can always unban these player, plugin doesn't say otherwise. Should
you test this yourself I must warn you. Once you get banned, unless you have access to the console
or know someone that has access to the console, you'll get locked out from the server indefinitely.

The message or command content isn't logged, for server's safety, just the sender name. Players
will never see this message, not even server operators, in game. Log message about player getting
banned for potential Log4Shell attack is going to be visible only in console. But banlist should
display the reason for this ban, so there's nothing that prevents you from seeing who got banned.
The ban isn't IP based, only the player that issued this attack is banned, nobody else. If someone
shows you a screen where it says someone's been permanently banned for Log4Shell attack, you'll
immediately know what happened and decide based on this. It is highly unlikely the player is going
to be banned without knowing what they did. It is highly unlikely this thing is going to be posted
by accident, it's almost always probable that the player in question was doing it intentionally.
As said, the log message doesn't contain the message or command content, just the message or command
sender name, for the sake of preserving your server's safety. Event is cancelled and console user
(usually server admin) is informed about this happening. Ban list includes the ban reason, so don't
worry about not being able to view the information.
