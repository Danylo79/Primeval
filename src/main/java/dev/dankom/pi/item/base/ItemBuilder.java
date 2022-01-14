package dev.dankom.pi.item.base;

import dev.dankom.pi.item.data.Rarity;
import dev.dankom.pi.type.MetaHandler;
import dev.dankom.pi.type.attribute.Attribute;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private Material material = Material.BARRIER;
    private String name = "Unnamed Item";
    private Rarity rarity = Rarity.COMMON;
    private List<String> lore = new ArrayList<>();
    private List<Attribute> attributes = new ArrayList<>();

    public ItemBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setRarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public ItemBuilder addLore(String line) {
        lore.add(line);
        return this;
    }

    public ItemBuilder addAttribute(Attribute attribute) {
        attributes.add(attribute);
        return this;
    }

    public ItemBase build() {
        return new ItemBase(material, name, rarity, new MetaHandler() {
            @Override
            public void updateMeta(ItemMeta meta) {

            }

            @Override
            public void updateLore(List<String> lore) {

            }
        }, attributes.toArray(new Attribute[]{}));
    }
}
