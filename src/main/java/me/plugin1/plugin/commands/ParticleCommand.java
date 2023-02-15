package me.plugin1.plugin.commands;

import me.plugin1.plugin.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class ParticleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player playerTarget = (Player) sender;
//        Location location = player.getEyeLocation();
//
//        int radius = 1;
//
//        final double[] y = {0};
//
//        new BukkitRunnable() {
//            @Override
//            public void run() {
//                double x = radius * Math.cos(y[0]);
//                double z = radius * Math.sin(y[0]);
//
//                player.spawnParticle(Particle.REDSTONE, location.add(x, y[0], z), 50, new Particle.DustOptions(Color.AQUA, 5.0F));
//                y[0] = y[0] + 0.1;
//            }
//        }.runTaskTimerAsynchronously(Main.getPlugin(), 0, 10);

        final float[] i = {0};

        new BukkitRunnable() {
            @Override
            public void run() {
                double z = Math.sin(i[0]);
                double x = Math.cos(i[0]);
                double y = Math.abs(Math.sin(i[0] / 2) * 2);

//                player.sendMessage(Double.toString(z));
//                player.sendMessage(Double.toString(x));
//                player.sendMessage("\n");
//                player.spawnParticle(Particle.REDSTONE, location.add(x, 1, z), 3, new Particle.DustOptions(Color.AQUA, 1.0F));
//
//                location = player.getLocation();
//
//                player.spawnParticle(Particle.REDSTONE, location.add(-x, 1, -z), 3, new Particle.DustOptions(Color.FUCHSIA, 1.0F));
//                if (Bukkit.getOnlinePlayers().toArray().length == 1) {
                    Location location = playerTarget.getLocation();

                    playerTarget.spawnParticle(Particle.REDSTONE, location.add(x, y, z), 3, new Particle.DustOptions(Color.AQUA, 1.0F));

                    location = playerTarget.getLocation();

                    playerTarget.spawnParticle(Particle.REDSTONE, location.add(-x, y, -z), 3, new Particle.DustOptions(Color.FUCHSIA, 1.0F));
//                    return;
//                }

//                for (Player player: Bukkit.getOnlinePlayers()) {
//                    Location location = playerTarget.getLocation();
//
//                    player.spawnParticle(Particle.REDSTONE, location.add(x, 1, z), 3, new Particle.DustOptions(Color.AQUA, 1.0F));
//
//                    location = playerTarget.getLocation();
//
//                    player.spawnParticle(Particle.REDSTONE, location.add(-x, 1, -z), 3, new Particle.DustOptions(Color.FUCHSIA, 1.0F));
//                }

                i[0] += 0.1;
            }
        }.runTaskTimerAsynchronously(Main.getPlugin(), 0, 1);

        return true;
    }
}
