package dev.dankom.pi.item.type;

import dev.dankom.pi.item.ItemBase;
import dev.dankom.pi.item.registry.ItemRegistry;
import org.bukkit.inventory.ItemStack;

public interface IItemReference<B extends ItemBase> {
    ItemStack getStack();
    B getBase();

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
