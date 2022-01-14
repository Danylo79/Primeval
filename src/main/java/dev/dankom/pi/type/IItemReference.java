package dev.dankom.pi.type;

import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.item.base.ItemBase;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public interface IItemReference<B extends ItemBase> {
    ItemStack getStack();
    B getBase();

    default ItemMeta getMeta() {
        return getStack().getItemMeta();
    }

    default void setMeta(ItemMeta meta) {
        getStack().setItemMeta(meta);
    }

    default FriendlyDataContainer getDataContainer() {
        return new FriendlyDataContainer(getStack().getItemMeta().getPersistentDataContainer());
    }

    default void recombobulate() {
        set(ItemBase.RECOMBOBULATED_KEY, PersistentDataType.INTEGER, 1);
    }

    default boolean isRecombobulated() {
        return get(ItemBase.RECOMBOBULATED_KEY, PersistentDataType.INTEGER) == 1;
    }

    default <T, Z> void set(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        getDataContainer().set(key, type, object);
    }

    default <T, Z> Z get(NamespacedKey key, PersistentDataType<T, Z> type) {
        return getDataContainer().get(key, type);
    }

    static <B extends ItemBase> IItemReference<B> createReference(ItemStack stack) {
        return new IItemReference<B>() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public B getBase() {
                return (B) PrimevalItems.ITEMS.getBaseForItem(stack);
            }
        };
    }
}
