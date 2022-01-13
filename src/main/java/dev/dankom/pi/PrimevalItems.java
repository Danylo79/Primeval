package dev.dankom.pi;

import dev.dankom.pi.item.registry.ItemRegistry;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PrimevalItems extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().addItem(ItemRegistry.TEST.create());
    }

    public NamespacedKey createKey(String key) {
        return new NamespacedKey(this, key);
    }

    public static PrimevalItems getInstance() {
        return getPlugin(PrimevalItems.class);
    }
}
