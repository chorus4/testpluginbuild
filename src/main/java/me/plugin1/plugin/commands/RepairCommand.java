package me.plugin1.plugin.commands;

import me.plugin1.plugin.Utils.EventStorage;
import me.plugin1.plugin.Utils.EventStorageArray;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            undo(player);
            return true;
        }
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            undo(player);
        }

        return true;
    }

    public void undo(Player player) {
        EventStorage storage = EventStorageArray.changes.get(EventStorageArray.changes.size() - 1);
        Material material = storage.storage;
        switch (storage.type) {
            case "destroy":
                player.getWorld().getBlockAt(storage.loc).setType(material);
                break;
            case "place":
                player.getWorld().getBlockAt(storage.loc).setType(Material.AIR);
                break;
        }
        EventStorageArray.changes.remove(storage);
    }
}
