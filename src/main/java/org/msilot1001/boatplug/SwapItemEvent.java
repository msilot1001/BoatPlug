package org.msilot1001.boatplug;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class SwapItemEvent implements Listener {
    @EventHandler
    public void swap(PlayerSwapHandItemsEvent e) {
        Bukkit.getLogger().info("[BoatPlug] Player (" + e.getPlayer().getDisplayName() + ") Swap Item Detected, Item: " + e.getMainHandItem().getItemMeta().getDisplayName());

        BaseComponent[] component = new ComponentBuilder("[BoatPlug] Player (" + e.getPlayer().getDisplayName() + ") Swap Item Detected, Item: " + e.getMainHandItem().getItemMeta().getDisplayName()).color(ChatColor.RED).bold(true).create();

        e.getPlayer().spigot().sendMessage(component);
    }

}
