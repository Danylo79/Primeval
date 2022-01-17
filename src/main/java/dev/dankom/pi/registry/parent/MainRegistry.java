package dev.dankom.pi.registry.parent;

import dev.dankom.pi.registry.child.Registrable;
import dev.dankom.pi.registry.child.Registry;

import java.util.Map;
import java.util.UUID;

public class MainRegistry<T> extends Registry<T> {
    public void register(Registry<T> registry) {
        for (Map.Entry<UUID, Registrable<?>> rEntry : registry.map().entrySet()) {
            register(rEntry.getKey(), rEntry.getValue());
        }
    }
}
