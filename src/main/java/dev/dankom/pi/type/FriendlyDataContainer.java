package dev.dankom.pi.type;

import dev.dankom.type.returner.Returner;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.function.Consumer;

public interface FriendlyDataContainer {
    Returner<PersistentDataContainer> containerPromise();

    default PersistentDataContainer container() {
        return containerPromise().returned();
    }

    default <T, Z> void set(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        container().set(key, type, object);
    }

    default <T, Z> void setNoExist(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        if (container().get(key, type) == null) {
            set(key, type, object);
        }
    }

    default <T, Z> Z get(NamespacedKey key, PersistentDataType<T, Z> type) {
        return container().get(key, type);
    }

    static FriendlyDataContainer create(ItemStack stack) {
        return () -> () -> stack.getItemMeta().getPersistentDataContainer();
    }
}
