package dev.dankom.pi;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import javax.naming.event.NamespaceChangeListener;

public final class PrimevalItems extends JavaPlugin {
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public NamespacedKey createKey(String key) {
        return new NamespacedKey(this, key);
    }

    public static PrimevalItems getInstance() {
        return getPlugin(PrimevalItems.class);
    }
}
