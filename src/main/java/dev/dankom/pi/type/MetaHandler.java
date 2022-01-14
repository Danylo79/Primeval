package dev.dankom.pi.type;

import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface MetaHandler {
    void updateMeta(ItemMeta meta);
    void updateLore(List<String> lore);

    static MetaHandler createSimpleHandler(int modelData, String... loreLines) {
        return new MetaHandler() {
            @Override
            public void updateMeta(ItemMeta meta) {
                meta.setCustomModelData(modelData);
            }

            @Override
            public void updateLore(List<String> lore) {
                for (String loreLine : loreLines) {
                    lore.add(loreLine);
                }
            }
        };
    }
}
