package dev.dankom.pi;

import dev.dankom.pi.command.Commands;
import dev.dankom.pi.event.ItemRegisterEvent;
import dev.dankom.pi.file.FileManager;
import dev.dankom.pi.item.ItemInit;
import dev.dankom.pi.item.base.ItemBase;
import dev.dankom.pi.registry.parent.MainRegistry;
import dev.dankom.pi.listener.PlayerListener;
import dev.dankom.pi.profile.Profile;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PrimevalItems extends JavaPlugin implements Listener {
    public static final MainRegistry<ItemBase> ITEMS = new MainRegistry();
    public static final MainRegistry<EntityBase> ENTITIES = new MainRegistry();

    private FileManager fileManager;

    @Override
    public void onEnable() {
        this.fileManager = new FileManager();

        Bukkit.getPluginCommand("primeval").setExecutor(new Commands());

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);

        new ItemRegisterEvent(ITEMS).call();

        for (Player p : Bukkit.getOnlinePlayers()) {
            new Profile(p).load();
        }
    }

    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            new Profile(p).save();
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new Profile(e.getPlayer()).save();

        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().addItem(ItemInit.TEST.get().create());
    }

    @EventHandler
    public void onRegister(ItemRegisterEvent e) {
        ItemInit.ITEMS.init(e);
    }

    public NamespacedKey createKey(String key) {
        return new NamespacedKey(this, key);
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public static PrimevalItems getInstance() {
        return getPlugin(PrimevalItems.class);
    }
}
