package dev.dankom.pi.type.attribute;

public class Attribute<T> {
    private AttributeKey key;
    private T obj;

    public Attribute(AttributeKey key) {
        this.key = key;
        this.obj = null;
    }

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}
