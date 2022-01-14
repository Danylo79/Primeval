package dev.dankom.pi.item.perk.base;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface IAttackPerk extends IPerk {
    void attack(EntityDamageByEntityEvent e);
}
