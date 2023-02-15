package me.plugin1.plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class VelocityApi {
    public VelocityApi(Plugin plugin) {
        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
//        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "myChannel");
    }

    public static void RedirectPlayer(Player player, String serverName, Plugin plugin) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);

        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    public static void tesa(Plugin plugin, Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF("hello");

        player.sendPluginMessage(plugin, "myChannel", out.toByteArray());
    }
}
