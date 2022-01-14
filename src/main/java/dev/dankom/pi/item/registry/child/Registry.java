package dev.dankom.pi.item.registry.child;

import dev.dankom.pi.event.ItemRegisterEvent;
import dev.dankom.pi.item.ItemBase;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Registry {
    protected Map<UUID, Registrable<?>> items = new HashMap<>();

    public void init(ItemRegisterEvent event) {
        event.getItemRegistry().register(this);
    }

    public Registrable<?> getItem(UUID id) {
        return items.get(id);
    }

    public UUID getId(Registrable<?> registrable) {
        for (Map.Entry<UUID, Registrable<?>> rEntry : items.entrySet()) {
            if (rEntry.getValue().get().getClass() == registrable.get().getClass()) {
                return rEntry.getKey();
            }
        }
        return null;
    }

    public void register(Registrable<?> registrable) {
        register(UUID.randomUUID(), registrable);
    }

    protected void register(UUID id, Registrable<?> registrable) {
        items.put(id, registrable);
    }

    public Registrable<?> getBaseForItem(ItemStack stack) {
        return getItem(UUID.fromString(stack.getItemMeta().getPersistentDataContainer().get(ItemBase.ITEM_BASE_ID_KEY, PersistentDataType.STRING)));
    }

    public void update(ItemStack stack) {
        getBaseForItem(stack).get().update(stack);
    }

    public ItemStack create(UUID id) {
        return getItem(id).get().create();
    }

    public Map<UUID, Registrable<?>> map() {
        return items;
    }
}
