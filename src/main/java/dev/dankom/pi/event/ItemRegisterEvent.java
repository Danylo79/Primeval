package dev.dankom.pi.event;

import dev.dankom.pi.item.registry.parent.FullRegistry;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ItemRegisterEvent extends Event {
    private final FullRegistry itemRegistry;

    public ItemRegisterEvent(FullRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return new HandlerList();
    }

    public FullRegistry getItemRegistry() {
        return itemRegistry;
    }
}
