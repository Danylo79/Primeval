package dev.dankom.pi.profile.stat;

public enum Stat {
    HEALTH("health.health", 100D),
    MAX_HEALTH("health.maxHealth", 100D),

    MANA("mana.mana", 50),
    MAX_MANA("mana.maxMana", 50),

    CRIT_CHANCE("crit.critChance", 50),
    CRIT_DAMAGE("crit.critDamage", 25),

    DEFENCE("defence", 10),
    STRENGTH("strength", 80),
    INTELLIGENCE("intelligence", 20),

    SKILL_POINTS("skill_points", 5),
    RESEARCH_POINTS("RESEARCH_points", 2),
    ;

    private final String loc;
    private final Object def;

    <T> Stat(String loc, T def) {
        this.loc = loc;
        this.def = def;
    }

    public <T> T getDefault() {
        return (T) def;
    }

    public String getLoc() {
        return loc;
    }
}
