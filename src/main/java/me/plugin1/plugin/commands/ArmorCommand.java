package me.plugin1.plugin.commands;

import me.plugin1.plugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class ArmorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        ArmorStand clickale = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 1, 0), EntityType.ARMOR_STAND);

        armorStand.setVisible(false);
//        armorStand.setHelmet(new ItemStack(Material.BLUE_WOOL));
        armorStand.setCustomName("Hello from armorStand this is hd");
        armorStand.setCustomNameVisible(true);
        armorStand.setSmall(true);
        armorStand.setGravity(false);

        clickale.setVisible(false);
        clickale.setCustomName("clickon");
        clickale.setGravity(false);

        new BukkitRunnable() {

            @Override
            public void run() {
                armorStand.remove();
                clickale.remove();
            }
        }.runTaskTimerAsynchronously(Main.getPlugin(), 300L, 0);

        player.sendMessage("Hello");


        return true;
    }
}
