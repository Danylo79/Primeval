package dev.dankom.pi.profile;

import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.file.yml.YmlSection;
import dev.dankom.pi.profile.stat.ProfileStats;
import dev.dankom.pi.profile.stat.Stat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Profile {
    private final UUID id;
    private static Map<Profile, ProfileStats> cache = new HashMap<>();

    public Profile(String name) {
        this(Bukkit.getPlayer(name));
    }

    public Profile(Player player) {
        this(player.getUniqueId());
    }

    public Profile(UUID id) {
        this.id = id;
    }

    public void load() {
        YmlSection section = section();
        ProfileStats stats = cache.get(this);
        for (Stat stat : stats.getAllLoadedStats()) {
            if (section.get(stat.getLoc()) == null) {
                section.set(stat.getLoc(), stat.getDefault());
            } else {
                section.set(stat.getLoc(), stats.get(stat));
            }
        }

        save();
    }

    public void save() {
        YmlSection section = section();
        ProfileStats stats = cache.get(this);
        for (Stat stat : stats.getAllLoadedStats()) {
            section.set(stat.getLoc(), stats.get(stat));
        }
    }

    protected YmlSection section() {
        return new YmlSection(PrimevalItems.getInstance().getFileManager().profiles, "profiles." + id.toString());
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(id);
    }
}
