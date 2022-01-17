package dev.dankom.pi.item.data.reforge;

import dev.dankom.pi.profile.stat.Stat;
import dev.dankom.pi.type.Operation;

public enum Reforge {
    SPICY("Spicy", new ReforgeModifier(Stat.STRENGTH, Operation.ADD, 100))
    ;

    private final String name;
    private final ReforgeModifier[] modifiers;

    Reforge(String name, ReforgeModifier... modifiers) {
        this.name = name;
        this.modifiers = modifiers;
    }

    public String getName() {
        return name;
    }

    public ReforgeModifier[] getModifiers() {
        return modifiers;
    }

    public int getID() {
        for (int i = 0; i < values().length; i++) {
            Reforge r = values()[i];
            if (r == this) {
                return i;
            }
        }
        return -1;
    }

    public static Reforge get(int id) {
        return values()[id];
    }
}
