/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ArrayMap$1;
import androidx.collection.MapCollections;
import androidx.collection.SimpleArrayMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap
extends SimpleArrayMap
implements Map {
    public MapCollections mCollections;

    public ArrayMap() {
    }

    public ArrayMap(int n10) {
        super(n10);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private MapCollections getCollection() {
        MapCollections mapCollections = this.mCollections;
        if (mapCollections == null) {
            this.mCollections = mapCollections = new ArrayMap$1(this);
        }
        return this.mCollections;
    }

    public boolean containsAll(Collection collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    public Set entrySet() {
        return this.getCollection().getEntrySet();
    }

    public Set keySet() {
        return this.getCollection().getKeySet();
    }

    public void putAll(Map object) {
        int n10 = this.mSize;
        int n11 = object.size();
        this.ensureCapacity(n10 += n11);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            this.put(k10, entry);
        }
    }

    public boolean removeAll(Collection collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    public Collection values() {
        return this.getCollection().getValues();
    }
}

