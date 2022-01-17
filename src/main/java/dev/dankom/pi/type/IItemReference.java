package dev.dankom.pi.type;

import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.item.base.ItemBase;
import dev.dankom.pi.item.data.reforge.Reforge;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public abstract class IItemReference<B extends ItemBase> {
    private final ItemStack stack;

    IItemReference(ItemStack stack) {
        this.stack = stack;
    }

    public abstract B getBase();

    public abstract FriendlyDataContainer container();

    public ItemMeta getMeta() {
        return stack.getItemMeta();
    }

    public void setMeta(ItemMeta meta) {
        stack.setItemMeta(meta);
    }

    public void recombobulate() {
        set(ItemBase.RECOMBOBULATED_KEY, PersistentDataType.INTEGER, 1);
    }

    public boolean isRecombobulated() {
        return getOrCreate(ItemBase.RECOMBOBULATED_KEY, PersistentDataType.INTEGER, 0) == 1;
    }

    public void reforge(Reforge reforge) {
        set(ItemBase.REFORGE_KEY, PersistentDataType.INTEGER, reforge.getID());
    }

    public Reforge getReforge() {
        try {
            return Reforge.get(get(ItemBase.REFORGE_KEY, PersistentDataType.INTEGER));
        } catch (Exception e) {
            return null;
        }
    }

    public <T, Z> void set(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        container().set(key, type, object);
    }

    public <T, Z> void setNoExist(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        container().setNoExist(key, type, object);
    }

    public <T, Z> Z get(NamespacedKey key, PersistentDataType<T, Z> type) {
        return container().get(key, type);
    }

    public <T, Z> Z getOrCreate(NamespacedKey key, PersistentDataType<T, Z> type, Z object) {
        return container().getOrCreate(key, type, object);
    }

    public ItemStack getStack() {
        return stack;
    }

    public static <B extends ItemBase> IItemReference<B> createReference(ItemStack stack) {
        FriendlyDataContainer container = FriendlyDataContainer.create(stack);

        return new IItemReference<B>(stack) {

            @Override
            public B getBase() {
                return (B) PrimevalItems.ITEMS.getItem(get(ItemBase.ITEM_BASE_ID_KEY, PersistentDataType.STRING));
            }

            @Override
            public FriendlyDataContainer container() {
                return container;
            }
        };
    }
}
