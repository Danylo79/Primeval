package dev.dankom.pi.type;

import dev.dankom.pi.item.ItemBase;
import dev.dankom.pi.item.registry.ItemRegistry;
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
        getDataContainer().set(ItemBase.RECOMBOBULATED_KEY, PersistentDataType.INTEGER, 1);
    }

    default boolean isRecombobulated() {
        return getDataContainer().get(ItemBase.RECOMBOBULATED_KEY, PersistentDataType.INTEGER) == 1;
    }

    static <B extends ItemBase> IItemReference<B> createReference(ItemStack stack) {
        return new IItemReference<B>() {
            @Override
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public B getBase() {
                return (B) ItemRegistry.getBaseForItem(stack);
            }
        };
    }
}
