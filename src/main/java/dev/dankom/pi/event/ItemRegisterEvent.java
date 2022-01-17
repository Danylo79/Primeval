package dev.dankom.pi.event;

import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.registry.parent.MainRegistry;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ItemRegisterEvent extends Event {
    private static HandlerList handlers = new HandlerList();
    private final MainRegistry itemRegistry;

    public ItemRegisterEvent(MainRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    public void call() {
        PrimevalItems.getInstance().getServer().getPluginManager().callEvent(this);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public MainRegistry getItemRegistry() {
        return itemRegistry;
    }
}
