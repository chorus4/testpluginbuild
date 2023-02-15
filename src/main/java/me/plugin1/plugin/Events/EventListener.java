package me.plugin1.plugin.Events;

import me.plugin1.plugin.Inventories.ServerMenuInventory.ServerMenuInventory;
import me.plugin1.plugin.Inventories.ServerMenuInventory.ServerMenuInventoryHolder;
import me.plugin1.plugin.Utils.EventStorage;
import me.plugin1.plugin.Utils.EventStorageArray;
import me.plugin1.plugin.VelocityApi;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventListener implements Listener {

    public final Plugin plugin;

    public EventListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
//        ArmorStand click = (ArmorStand) e.getEntity();
//        Player player = (Player) click.getLastDamageCause().getEntity();
//
//        if (click.getCustomName() == "clickon") {
//            player.sendMessage("You clicked");
//        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        EventStorage storage = new EventStorage();
        storage.storage = e.getBlock().getType();
        storage.loc = e.getBlock().getLocation();
        storage.type = "place";

        EventStorageArray.changes.add(storage);

    }

    @EventHandler
    public void onDestroy(BlockBreakEvent e) {
        EventStorage storage = new EventStorage();
        storage.storage = e.getBlock().getType();
        storage.loc = e.getBlock().getLocation();
        storage.type = "destroy";

        EventStorageArray.changes.add(storage);
    }

    @EventHandler
    public void OnMove(PlayerMoveEvent e) {
//        Player player = e.getPlayer();

//        player.spawnParticle(Particle.CLOUD, player.getLocation(), 1);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.displayName(Component.text(ChatColor.RED + player.displayName().toString()));

        Inventory inventory = player.getInventory();
        inventory.clear();

        ItemStack navigator = new ItemStack(Material.COMPASS);
        ItemMeta navigatorMeta = navigator.getItemMeta();

        navigatorMeta.displayName(Component.text("Выбор сервера"));
//        navigatorMeta.addEnchant(Enchantment.PIERCING, 1, true);

        List<Component> emptyLore = new ArrayList<>();
        emptyLore.add(Component.text("Нажмите пкм чтобы открыть интерфейс"));
        navigatorMeta.lore(emptyLore);

        navigator.setItemMeta(navigatorMeta);
        inventory.addItem(navigator);

        player.teleport(new Location(player.getWorld(), -141, 77,84, 90, 0));


//        VelocityApi.tesa(plugin, player);
    }

    @EventHandler
    public void onItemRightClick(PlayerInteractEvent e) {
        if (e.hasItem()) {
            if (Objects.requireNonNull(e.getItem()).getType().equals(Material.COMPASS)) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                    e.getPlayer().openInventory(new ServerMenuInventory().inventory);
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof ServerMenuInventoryHolder) {
            Player player = (Player) e.getWhoClicked();

            player.closeInventory();

            if (e.getSlot() == 11) {
                VelocityApi.RedirectPlayer(player, "main", plugin);
            }

            if (e.getSlot() == 15) {
                e.getWhoClicked().sendMessage("15");
            }

            e.setCancelled(true);
        }
    }

//    @EventHandler
//    public void onSpawn(EntitySpawnEvent e) {
//        e.setCancelled(true);
//    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
}
