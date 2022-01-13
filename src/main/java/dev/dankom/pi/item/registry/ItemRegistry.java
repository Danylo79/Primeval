package dev.dankom.pi.item.registry;

import dev.dankom.pi.item.ItemBase;
import dev.dankom.pi.item.data.Rarity;
import dev.dankom.pi.type.MetaHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class ItemRegistry {
    private static Map<UUID, ItemBase> items = new HashMap<>();

    public static final ItemBase TEST = register(new ItemBase(Material.STICK, "Test", Rarity.EXOTIC, new MetaHandler() {
        @Override
        public void updateMeta(ItemMeta meta) {

        }

        @Override
        public void updateLore(List<String> lore) {

        }
    }));

    public static ItemBase getById(UUID id) {
        return items.get(id);
    }

    public static UUID getId(ItemBase base) {
        for (Map.Entry<UUID, ItemBase> entry : items.entrySet()) {
            if (entry.getValue() == base) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void update(ItemStack stack) {
        getBaseForItem(stack).update(stack);
    }

    public static ItemBase getBaseForItem(ItemStack stack) {
        return getById(UUID.fromString(stack.getItemMeta().getPersistentDataContainer().get(ItemBase.ITEM_BASE_ID_KEY, PersistentDataType.STRING)));
    }

    public static ItemBase register(ItemBase base) {
        items.put(UUID.randomUUID(), base);
        return base;
    }
}
