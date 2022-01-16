package dev.dankom.pi.profile.stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileStats {
    private Map<Stat, Object> stats = new HashMap<>();

    public ProfileStats() {
        for (Stat s : Stat.values()) {
            stats.put(s, s.getDefault());
        }
    }

    public <T> void put(Stat stat, T flt) {
        stats.put(stat, flt);
    }

    public <T> T get(Stat stat) {
        return (T) stats.get(stat);
    }

    public List<Stat> getAllLoadedStats() {
        List<Stat> out = new ArrayList<>();
        for (Map.Entry<Stat, ?> stat : stats.entrySet()) {
            out.add(stat.getKey());
        }
        return out;
    }
}
