/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$InverseEntrySet;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;

public class HashBiMap$Inverse
extends AbstractMap
implements BiMap,
Serializable {
    private final HashBiMap forward;
    private transient Set inverseEntrySet;

    public HashBiMap$Inverse(HashBiMap hashBiMap) {
        this.forward = hashBiMap;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        HashBiMap.access$302(this.forward, this);
    }

    public void clear() {
        this.forward.clear();
    }

    public boolean containsKey(Object object) {
        return this.forward.containsValue(object);
    }

    public boolean containsValue(Object object) {
        return this.forward.containsKey(object);
    }

    public Set entrySet() {
        Set set = this.inverseEntrySet;
        if (set == null) {
            HashBiMap hashBiMap = this.forward;
            this.inverseEntrySet = set = new HashBiMap$InverseEntrySet(hashBiMap);
        }
        return set;
    }

    public Object forcePut(Object object, Object object2) {
        return this.forward.putInverse(object, object2, true);
    }

    public Object get(Object object) {
        return this.forward.getInverse(object);
    }

    public BiMap inverse() {
        return this.forward;
    }

    public Set keySet() {
        return this.forward.values();
    }

    public Object put(Object object, Object object2) {
        return this.forward.putInverse(object, object2, false);
    }

    public Object remove(Object object) {
        return this.forward.removeInverse(object);
    }

    public int size() {
        return this.forward.size;
    }

    public Set values() {
        return this.forward.keySet();
    }
}

