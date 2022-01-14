package dev.dankom.pi.item.perk.base;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface IDefencePerk extends IPerk {
    void defend(EntityDamageByEntityEvent e);
}
