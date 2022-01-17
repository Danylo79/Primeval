package dev.dankom.pi.registry.child;

import dev.dankom.pi.item.base.ItemBase;
import org.bukkit.inventory.ItemStack;

public interface Registrable<T> {
    T get();
}
