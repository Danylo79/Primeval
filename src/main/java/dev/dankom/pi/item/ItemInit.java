package dev.dankom.pi.item;

import dev.dankom.pi.item.base.ItemBase;
import dev.dankom.pi.item.base.ItemBuilder;
import dev.dankom.pi.item.data.Rarity;
import dev.dankom.pi.item.registry.child.Registrable;
import dev.dankom.pi.item.registry.child.Registry;
import org.bukkit.Material;

public class ItemInit {
    public static final Registry ITEMS = new Registry();

    public static final Registrable<ItemBase> TEST = register(new ItemBuilder()
            .setMaterial(Material.STICK)
            .setName("Bonker")
            .setRarity(Rarity.EXOTIC)
            .build());

    public static Registrable<ItemBase> register(ItemBase base) {
        Registrable<ItemBase> registrable = () -> base;
        ITEMS.register(registrable);
        return registrable;
    }
}
