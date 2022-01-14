package dev.dankom.pi.profile.stat;

public enum Stat {
    HEALTH("health.health", 100),
    MAX_HEALTH("health.maxHealth", 100),

    MANA("mana.mana", 50),
    MAX_MANA("mana.maxMana", 50),

    CRIT_CHANCE("crit.critChance", 50),
    CRIT_DAMAGE("crit.critDamage", 25),

    DEFENCE("defence", 10),
    STRENGTH("strength", 80),
    INTELLIGENCE("intelligence", 20);

    private final String loc;
    private final float def;

    Stat(String loc, float def) {
        this.loc = loc;
        this.def = def;
    }

    public float getDefault() {
        return def;
    }

    public String getLoc() {
        return loc;
    }
}
