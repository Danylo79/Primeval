package dev.dankom.pi.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            //Player Damage Entity
        } else if (e.getEntity() instanceof Player) {
            //Player Damaged by Entity
        }
    }
}
