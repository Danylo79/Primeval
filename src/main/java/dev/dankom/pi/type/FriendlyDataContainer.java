package dev.dankom.pi.type;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class FriendlyDataContainer {
    private PersistentDataContainer container;

    public FriendlyDataContainer(PersistentDataContainer container) {
        this.container = container;
    }

    public <T, Z> void set(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        container.set(key, type, object);
    }

    public <T, Z> void setNoExist(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        if (container.get(key, type) == null) {
            set(key, type, object);
        }
    }

    public <T, Z> Z get(NamespacedKey key, PersistentDataType<T, Z> type) {
        return container.get(key, type);
    }
}
