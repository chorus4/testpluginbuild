package me.plugin1.plugin;

import me.plugin1.plugin.Events.EventListener;
import me.plugin1.plugin.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getCommand("reloadPlugin").setExecutor(new ReloadCommand(this));
        getCommand("serv").setExecutor(new ServerChoiseCommand());
        getCommand("ender").setExecutor(new EnderStorageCommand());
        getCommand("particles").setExecutor(new ParticleCommand());
        getCommand("armorStand").setExecutor(new ArmorCommand());
        getCommand("repair").setExecutor(new RepairCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("inventory").setExecutor(new SeeInvCommand());
        Bukkit.getPluginManager().registerEvents(new EventListener(this), this);

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            Bukkit.getOnlinePlayers().forEach((player) -> {
                if (player.isOp()) {
                    player.setPlayerListHeader("Ping: " + player.getPing());
                    player.setPlayerListFooter("TPS: " + Double.toString(Math.round(Bukkit.getTPS()[0])));
                }
            });
        }, 0L, 10);

        new VelocityApi(this);

    }

    public static Main getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
