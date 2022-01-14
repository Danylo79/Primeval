package dev.dankom.pi.item.registry.child;

import dev.dankom.pi.item.ItemBase;
import org.bukkit.inventory.ItemStack;

public interface Registrable<T extends ItemBase> {
    T get();

    default ItemStack create() {
        return get().create();
    }

    default void update(ItemStack stack) {
        get().update(stack);
    }
}
