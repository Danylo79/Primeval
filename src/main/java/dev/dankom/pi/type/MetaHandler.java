package dev.dankom.pi.type;

import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface MetaHandler {
    void updateMeta(ItemMeta meta);
    void updateLore(List<String> lore);
}
