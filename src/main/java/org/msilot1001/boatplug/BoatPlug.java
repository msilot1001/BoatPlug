package org.msilot1001.boatplug;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BoatPlug extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[BoatPatch] Boat Patcher Enabled");
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[BoatPatch] Boat Patcher Disabled");
    }
}