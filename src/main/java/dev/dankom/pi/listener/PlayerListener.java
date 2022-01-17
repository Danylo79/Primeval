package dev.dankom.pi.listener;

import dev.dankom.pi.item.base.ItemBase;
import dev.dankom.pi.item.data.reforge.ReforgeModifier;
import dev.dankom.pi.profile.Profile;
import dev.dankom.pi.profile.stat.Stat;
import dev.dankom.pi.type.IItemReference;
import dev.dankom.pi.util.ItemUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerListener implements Listener {
    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            //Player Damage Entity
        } else if (e.getEntity() instanceof Player) {
            //Player Damaged by Entity
        }
    }

    public Map<Stat, Object> getStats(Player player) {
        Profile profile = new Profile(player);
        Map<Stat, Object> out = profile.getStats().map();
        for (IItemReference ir : getEquippedItems(player)) {
            ItemBase base = ir.getBase();

            if (ir.getReforge() != null) {
                for (ReforgeModifier rm : ir.getReforge().getModifiers()) {
                    out.put(rm.getStat(), rm.modify((Integer) out.get(rm.getStat())));
                }
            }
        }
        return out;
    }

    public List<IItemReference> getEquippedItems(Player player) {
        List<IItemReference> out = new ArrayList<>();
        if (ItemUtil.getBaseForStack(player.getInventory().getItemInMainHand()) != null) {
            out.add(IItemReference.createReference(player.getInventory().getItemInMainHand()));
        } else if (ItemUtil.getBaseForStack(player.getInventory().getItemInOffHand()) != null) {
            out.add(IItemReference.createReference(player.getInventory().getItemInOffHand()));
        }

        for (ItemStack stack : player.getInventory().getArmorContents()) {
            if (ItemUtil.getBaseForStack(stack) != null) {
                out.add(IItemReference.createReference(stack));
            }
        }
        return out;
    }
}
