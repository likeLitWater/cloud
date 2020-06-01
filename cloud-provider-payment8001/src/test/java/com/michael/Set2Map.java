package com.michael;

import java.security.Key;
import java.util.HashSet;

/**
 * @ClassName: Set2Map
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/30 10:02
 * @Version 1.0
 */
public class Set2Map<K,V> extends HashSet<SimpleEntry<K,V>> {
    @Override
    public void clear() {
        super.clear();
    }
    public boolean containsKey(Object key) {
        return super.contains(new SimpleEntry<>(key, null));
    }
    boolean containsValue(Object value) {
        for(SimpleEntry<K,V> se: this) {
            if (se.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
    public V get(Object key) {
        for(SimpleEntry<K,V> se: this) {
            if (se.getKey().equals(key)) {
                return se.getValue();
            }
        }
        return null;
    }
}
