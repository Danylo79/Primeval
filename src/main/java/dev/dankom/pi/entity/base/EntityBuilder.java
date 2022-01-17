package dev.dankom.pi.entity.base;

import org.bukkit.entity.EntityType;

public class EntityBuilder {
    private EntityType type;
    private String name;
    private double health;

    public EntityBuilder setMaterial(EntityType type) {
        this.type = type;
        return this;
    }

    public EntityBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EntityBuilder setHealth(double health) {
        this.health = health;
        return this;
    }

    public EntityBase build() {
        return new EntityBase(type, name, health);
    }
}
