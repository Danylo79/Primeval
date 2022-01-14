package dev.dankom.pi.item;

import dev.dankom.pi.item.data.Rarity;
import dev.dankom.pi.item.registry.child.Registrable;
import dev.dankom.pi.item.registry.child.Registry;
import dev.dankom.pi.type.MetaHandler;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemInit {
    public static final Registry ITEMS = new Registry();

    public static final Registrable<ItemBase> TEST = register(new ItemBase(Material.STICK, "Test", Rarity.EXOTIC, new MetaHandler() {
        @Override
        public void updateMeta(ItemMeta meta) {

        }

        @Override
        public void updateLore(List<String> lore) {

        }
    }));

    public static Registrable<ItemBase> register(ItemBase base) {
        return register(base);
    }
}
