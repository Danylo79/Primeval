package dev.dankom.pi;

import dev.dankom.pi.command.Commands;
import dev.dankom.pi.event.ItemRegisterEvent;
import dev.dankom.pi.item.ItemInit;
import dev.dankom.pi.item.registry.parent.FullRegistry;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PrimevalItems extends JavaPlugin implements Listener {
    public static final FullRegistry ITEMS = new FullRegistry();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginCommand("primeval").setExecutor(new Commands());

        getServer().getPluginManager().callEvent(new ItemRegisterEvent(ITEMS));
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().addItem(ItemInit.TEST.create());
    }

    @EventHandler
    public void onRegister(ItemRegisterEvent e) {
        ItemInit.ITEMS.init(e);
    }

    public NamespacedKey createKey(String key) {
        return new NamespacedKey(this, key);
    }

    public static PrimevalItems getInstance() {
        return getPlugin(PrimevalItems.class);
    }
}
