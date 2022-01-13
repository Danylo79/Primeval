package dev.dankom.pi.item.type;

import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface MetaHandler {
    void updateMeta(ItemMeta meta);
    void updateLore(List<String> lore);
}
