package dev.dankom.pi.item.base;

import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.item.data.Rarity;
import dev.dankom.pi.type.IItemReference;
import dev.dankom.pi.type.MetaHandler;
import dev.dankom.pi.type.attribute.Attribute;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A template for items initialized by {@link ItemBuilder}
 */
public class ItemBase {
    public static final NamespacedKey ITEM_BASE_ID_KEY = createKey("itemBaseID");
    public static final NamespacedKey NAME_KEY = createKey("name");
    public static final NamespacedKey RARITY_ID_KEY = createKey("rarityID");
    public static final NamespacedKey RECOMBOBULATED_KEY = createKey("recombobulated");
    public static final NamespacedKey LAST_UPDATED_KEY = createKey("lastUpdated");

    private final Material material;
    private final String name;
    private final Rarity rarity;
    private final MetaHandler metaHandler;
    private final Attribute[] attributes;

    ItemBase(Material material, String name, Rarity rarity, MetaHandler metaHandler, Attribute... attributes) {
        this.material = material;
        this.name = name;
        this.rarity = rarity;
        this.metaHandler = metaHandler;
        this.attributes = attributes;
    }

    public ItemStack create() {
        return update(new ItemStack(material));
    }

    public ItemStack update(ItemStack stack) {
        IItemReference<ItemBase> ir = IItemReference.createReference(stack);
        ItemMeta meta = ir.getMeta();
        //Set Data
        ir.getDataContainer().setNoExist(ITEM_BASE_ID_KEY, PersistentDataType.STRING, PrimevalItems.ITEMS.getId(() -> this).toString());
        ir.getDataContainer().setNoExist(NAME_KEY, PersistentDataType.STRING, name);
        ir.getDataContainer().setNoExist(RARITY_ID_KEY, PersistentDataType.INTEGER, rarity.getID());
        ir.getDataContainer().setNoExist(RECOMBOBULATED_KEY, PersistentDataType.INTEGER, 0);
        ir.getDataContainer().setNoExist(LAST_UPDATED_KEY, PersistentDataType.LONG, new Date().getTime());

        //Set Meta
        meta.setDisplayName(rarity.getColor() + name);
        metaHandler.updateMeta(meta);

        //Lore
        List<String> temp = new ArrayList<>();
        metaHandler.updateLore(temp);
        temp.add("   ");
        boolean isRecombobulated = ir.isRecombobulated();
        temp.add((isRecombobulated ? "&kW " : "") + rarity.getColoredName() + (isRecombobulated ? " &kW" : ""));

        List<String> lore = new ArrayList<>();
        for (String s : temp) {
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lore);

        ir.setMeta(meta);
        return ir.getStack();
    }

    protected static NamespacedKey createKey(String key) {
        return PrimevalItems.getInstance().createKey(key);
    }
}