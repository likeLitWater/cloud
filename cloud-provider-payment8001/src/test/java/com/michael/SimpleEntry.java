package com.michael;

import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName: SimpleEntry
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/30 9:54
 * @Version 1.0
 */
public class SimpleEntry<K,V> implements Map.Entry<K, V>, Serializable {
    private final K key;
    private V value;

    public SimpleEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == SimpleEntry.class) {
            SimpleEntry se = (SimpleEntry) obj;
            return se.getKey().equals(getKey());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return key == null ? 0 : key.hashCode();
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
