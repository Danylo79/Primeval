package dev.dankom.pi.profile.stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileStats {
    private Map<Stat, Float> stats = new HashMap<>();

    public void put(Stat stat, Float flt) {
        stats.put(stat, flt);
    }

    public Float get(Stat stat) {
        return stats.get(stat);
    }

    public List<Stat> getAllLoadedStats() {
        List<Stat> out = new ArrayList<>();
        for (Map.Entry<Stat, Float> stat : stats.entrySet()) {
            out.add(stat.getKey());
        }
        return out;
    }
}
