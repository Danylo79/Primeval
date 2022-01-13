package dev.dankom.pi.item;

import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.item.data.Rarity;
import dev.dankom.pi.item.registry.ItemRegistry;
import dev.dankom.pi.item.type.MetaHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ItemBase {
    public static final NamespacedKey ITEM_BASE_ID_KEY = createKey("itemBaseID");
    public static final NamespacedKey NAME_KEY = createKey("name");
    public static final NamespacedKey RARITY_ID_KEY = createKey("rarityID");

    private final Material material;
    private final String name;
    private final Rarity rarity;
    private MetaHandler metaHandler;

    public ItemBase(Material material, String name, Rarity rarity, MetaHandler metaHandler) {
        this.material = material;
        this.name = name;
        this.rarity = rarity;
        this.metaHandler = metaHandler;
    }

    public ItemStack create() {
        return update(new ItemStack(material));
    }

    public ItemStack update(ItemStack stack) {
        ItemMeta meta = stack.getItemMeta();
        //Set Data
        meta.getPersistentDataContainer().set(ITEM_BASE_ID_KEY, PersistentDataType.STRING, ItemRegistry.getId(this).toString());
        meta.getPersistentDataContainer().set(NAME_KEY, PersistentDataType.STRING, name);
        meta.getPersistentDataContainer().set(RARITY_ID_KEY, PersistentDataType.INTEGER, rarity.getID());

        //Set Meta
        meta.setDisplayName(rarity.getColor() + name);
        metaHandler.updateMeta(meta);

        //Lore
        List<String> temp = new ArrayList<>();
        metaHandler.updateLore(temp);
        temp.add("   ");
        temp.add(rarity.getColoredName());

        List<String> lore = new ArrayList<>();
        for (String s : temp) {
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lore);

        stack.setItemMeta(meta);
        return stack;
    }

    protected static NamespacedKey createKey(String key) {
        return PrimevalItems.getInstance().createKey(key);
    }
}
