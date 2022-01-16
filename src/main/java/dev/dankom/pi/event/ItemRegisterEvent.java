package dev.dankom.pi.event;

import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.item.registry.parent.FullRegistry;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ItemRegisterEvent extends Event {
    private static HandlerList handlers = new HandlerList();
    private final FullRegistry itemRegistry;

    public ItemRegisterEvent(FullRegistry itemRegistry) {
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

    public FullRegistry getItemRegistry() {
        return itemRegistry;
    }
}
