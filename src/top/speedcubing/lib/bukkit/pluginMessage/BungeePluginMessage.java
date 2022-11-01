package top.speedcubing.lib.bukkit.pluginMessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import top.speedcubing.lib.speedcubingLibBukkit;
import top.speedcubing.lib.utils.ByteArrayDataBuilder;

public class BungeePluginMessage {

    public static void switchServer(Player player, String server) {
        sendPluginMessage(player, "BungeeCord", new ByteArrayDataBuilder().writeUTF("Connect", server).toByteArray());
    }

    public static void sendPluginMessage(Player player, String channel, byte[] out) {
        if (player == null)
            Bukkit.getServer().sendPluginMessage(speedcubingLibBukkit.getPlugin(speedcubingLibBukkit.class), channel, out);
        else
            player.sendPluginMessage(speedcubingLibBukkit.getPlugin(speedcubingLibBukkit.class), channel, out);
    }
}
