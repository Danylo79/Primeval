package dev.dankom.pi.item.data;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

public enum Rarity {
    COMMON("&7COMMON", ChatColor.GRAY),
    UNCOMMON("&aUNCOMMON", ChatColor.GREEN),
    RARE("&9RARE", ChatColor.BLUE),
    EPIC("&5EPIC", ChatColor.DARK_PURPLE),
    LEGENDARY("&6LEGENDARY", ChatColor.GOLD),
    MYTHIC("&dMYTHIC", ChatColor.LIGHT_PURPLE),
    EXOTIC(ChatColor.of(new Color(255, 135, 22)) + "EXOTIC", ChatColor.of(new Color(255, 135, 22))),
    ;

    private String coloredName;
    private ChatColor color;

    Rarity(String coloredName, ChatColor color) {
        this.coloredName = coloredName;
        this.color = color;
    }

    public String getColoredName() {
        return coloredName;
    }

    public ChatColor getColor() {
        return color;
    }

    public int getID() {
        for (int i = 0; i < values().length; i++) {
            Rarity r = values()[i];
            if (r == this) {
                return i;
            }
        }
        return -1;
    }
}
