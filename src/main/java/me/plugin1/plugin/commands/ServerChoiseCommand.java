package me.plugin1.plugin.commands;

import me.plugin1.plugin.Inventories.ServerMenuInventory.ServerMenuInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ServerChoiseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        player.openInventory(new ServerMenuInventory().inventory);
        return true;
    }
}
