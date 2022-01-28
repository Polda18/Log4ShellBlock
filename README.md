# Log4ShellBlock
Minecraft Spigot plugin for detecting Log4Shell attacks in chat. _Coming soon._

## What is this about?
As you might be aware, popular Java library Log4j contained a serious security flaw
that allowed remote arbitrary code execution. This vulnerability caused wreack havoc
on the Internet and affected many Java applications, including Minecraft. Since it
was fixed, Log4Shell no longer poses as much of a threat as before the fix. However,
some applications are yet not patched, and there are number of Minecraft servers that
are running Minecraft version 1.8, which isn't patched (especially PVP servers).
These servers are vulnerable to this attack vendor and therefore have to be protected
somehow. One thing that can be used to advantage: chat is processed by an event handler
that can be used by plugins. This allows for scanning messages and translate chat color
codes (the ones denoted with `&`), allows to use a swear filter, or kick or ban users
based on certain phrases in the chat. Event handler doesn't log the chat message content
by default when it is catched by a plugin, it fully transfers that responsibility to the
plugin itself. The chat message is only logged when it's sent. So what if we could scan
messages by players to see if it contains the dreaded JNDI lookup? Yes, we certainly could.

## Plugin mechanics
What I have envisioned is a simple plugin that detects the JNDI lookup in the message
and bans the player accordingly. I might have a soft depend on popular punishment plugins
that handle this functionality and detect their presence. If present, the plugin will
use their API instead (provided the source code of them is available). Otherwise it will
use vanilla features to ban players.

Plugin will have no configuration, it will be simple install, reboot and use. Since
newest versions of Minecraft have this vulnerability patched, the aim is directed
at the older versions that might have this vulnerability. Notably the most widely used
Minecraft version 1.8. Keep in touch and watch for a first testing release, as this
is a plugin that might keep your server more secure.
