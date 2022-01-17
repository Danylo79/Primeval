package dev.dankom.pi.item;

import dev.dankom.pi.item.base.ItemBase;
import dev.dankom.pi.item.base.ItemBuilder;
import dev.dankom.pi.item.data.Rarity;
import dev.dankom.pi.item.perk.base.IAbility;
import dev.dankom.pi.item.perk.base.IPerk;
import dev.dankom.pi.registry.child.Registrable;
import dev.dankom.pi.registry.child.Registry;
import dev.dankom.util.general.DataStructureAdapter;
import org.bukkit.Material;
import org.bukkit.event.block.Action;

import java.util.List;

public class ItemInit {
    public static final Registry<ItemBase> ITEMS = new Registry();

    public static final Registrable<ItemBase> TEST = register(new ItemBuilder()
            .setMaterial(Material.STICK)
            .setName("Bonker")
            .setRarity(Rarity.EXOTIC)
            .addPerk(new IPerk() {
                @Override
                public String getName() {
                    return "Can Bonk";
                }

                @Override
                public List<String> getDescription() {
                    return DataStructureAdapter.arrayToList(
                            "&7This stick is good at",
                            "&7bonking do &c+100% &7damage"
                    );
                }
            })
            .addPerk(new IAbility() {
                @Override
                public Action getAction() {
                    return Action.RIGHT_CLICK_AIR;
                }

                @Override
                public String getName() {
                    return "Bonk";
                }

                @Override
                public List<String> getDescription() {
                    return DataStructureAdapter.arrayToList(
                            "&7Bonk an enemy and do",
                            "&c9999999999 &7damage"
                    );
                }
            })
            .build());

    public static Registrable<ItemBase> register(ItemBase base) {
        Registrable<ItemBase> registrable = () -> base;
        ITEMS.register(registrable);
        return registrable;
    }
}
