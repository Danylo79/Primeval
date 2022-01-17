package dev.dankom.pi.entity.base;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class EntityBase<T extends Entity> {
    private final EntityType type;
    private final String name;
    private final double health;

    EntityBase(EntityType type, String name, double health) {
        this.type = type;
        this.name = name;
        this.health = health;
    }

    public T spawn(Location location) {
        T entity = (T) location.getWorld().spawnEntity(location, type);
        ((LivingEntity)entity).getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier("set_health", health, AttributeModifier.Operation.ADD_NUMBER));
        return update(entity);
    }

    public T update(T to) {
        T entity = to;

        entity.setCustomName(name);
        entity.setCustomNameVisible(true);

        return entity;
    }
}
