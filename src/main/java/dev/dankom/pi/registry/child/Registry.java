package dev.dankom.pi.registry.child;

import dev.dankom.pi.event.ItemRegisterEvent;
import dev.dankom.pi.item.base.ItemBase;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Registry<T> {
    protected Map<String, Registrable<T>> items = new HashMap<>();

    public void init(ItemRegisterEvent event) {
        event.getItemRegistry().register(this);
    }

    public Registrable<T> getItem(String id) {
        return items.get(id);
    }

    public String getId(Registrable<T> registrable) {
        for (Map.Entry<String, Registrable<T>> rEntry : items.entrySet()) {
            if (rEntry.getValue().get().getClass() == registrable.get().getClass()) {
                return rEntry.getKey();
            }
        }
        return null;
    }

    public void register(String id, Registrable<T> registrable) {
        items.put(id, registrable);
    }

    public Map<String, Registrable<T>> map() {
        return items;
    }
}
