package dev.dankom.pi.item.registry.parent;

import dev.dankom.pi.item.registry.child.Registrable;
import dev.dankom.pi.item.registry.child.Registry;

import java.util.Map;
import java.util.UUID;

public class FullRegistry extends Registry {
    public void register(Registry registry) {
        for (Map.Entry<UUID, Registrable<?>> rEntry : registry.map().entrySet()) {
            register(rEntry.getKey(), rEntry.getValue());
        }
    }
}
