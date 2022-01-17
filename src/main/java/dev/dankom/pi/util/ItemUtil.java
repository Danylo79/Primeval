package dev.dankom.pi.util;

import dev.dankom.pi.item.base.ItemBase;
import dev.dankom.pi.type.IItemReference;
import org.bukkit.inventory.ItemStack;

public class ItemUtil {
    public static ItemBase getBaseForStack(ItemStack stack) {
        try {
            return IItemReference.createReference(stack).getBase();
        } catch (Exception e) {
            return null;
        }
    }
}
