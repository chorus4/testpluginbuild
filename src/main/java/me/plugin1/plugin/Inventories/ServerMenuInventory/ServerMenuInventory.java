package me.plugin1.plugin.Inventories.ServerMenuInventory;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ServerMenuInventory {
    public Inventory inventory = Bukkit.createInventory(new ServerMenuInventoryHolder(), 45, "Выбор сервера");

    public ServerMenuInventory() {
        Material modServertype = Material.PLAYER_HEAD;
        ItemStack modServerItem = new ItemStack(modServertype, 1);

        SkullMeta modServerMeta = (SkullMeta) modServerItem.getItemMeta();
        modServerMeta.setOwner("mattijs");

        modServerMeta.displayName(Component.text("Сервера с модами"));

        List<Component> modeServerLore = new ArrayList<>();
        modeServerLore.add(Component.text(ChatColor.RED + "Требуется клиент с установленым Forge!"));
        modServerMeta.lore(modeServerLore);

        modServerItem.setItemMeta(modServerMeta);

        inventory.setItem(11, new ItemStack(Material.BLUE_WOOL));
        inventory.setItem(15, modServerItem);
    }
}
