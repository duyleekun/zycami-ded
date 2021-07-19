/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.MapField$MutatabilityAwareMap$MutatabilityAwareCollection;
import com.google.protobuf.MapField$MutatabilityAwareMap$MutatabilityAwareSet;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapField$MutatabilityAwareMap
implements Map {
    private final Map delegate;
    private final MutabilityOracle mutabilityOracle;

    public MapField$MutatabilityAwareMap(MutabilityOracle mutabilityOracle, Map map) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = map;
    }

    public void clear() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.clear();
    }

    public boolean containsKey(Object object) {
        return this.delegate.containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.delegate.containsValue(object);
    }

    public Set entrySet() {
        MutabilityOracle mutabilityOracle = this.mutabilityOracle;
        Set set = this.delegate.entrySet();
        MapField$MutatabilityAwareMap$MutatabilityAwareSet mapField$MutatabilityAwareMap$MutatabilityAwareSet = new MapField$MutatabilityAwareMap$MutatabilityAwareSet(mutabilityOracle, set);
        return mapField$MutatabilityAwareMap$MutatabilityAwareSet;
    }

    public boolean equals(Object object) {
        return this.delegate.equals(object);
    }

    public Object get(Object object) {
        return this.delegate.get(object);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public Set keySet() {
        MutabilityOracle mutabilityOracle = this.mutabilityOracle;
        Set set = this.delegate.keySet();
        MapField$MutatabilityAwareMap$MutatabilityAwareSet mapField$MutatabilityAwareMap$MutatabilityAwareSet = new MapField$MutatabilityAwareMap$MutatabilityAwareSet(mutabilityOracle, set);
        return mapField$MutatabilityAwareMap$MutatabilityAwareSet;
    }

    public Object put(Object object, Object object2) {
        this.mutabilityOracle.ensureMutable();
        Internal.checkNotNull(object);
        Internal.checkNotNull(object2);
        return this.delegate.put(object, object2);
    }

    public void putAll(Map map) {
        boolean bl2;
        this.mutabilityOracle.ensureMutable();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Internal.checkNotNull(object);
            object = map.get(object);
            Internal.checkNotNull(object);
        }
        this.delegate.putAll(map);
    }

    public Object remove(Object object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(object);
    }

    public int size() {
        return this.delegate.size();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public Collection values() {
        MutabilityOracle mutabilityOracle = this.mutabilityOracle;
        Collection collection = this.delegate.values();
        MapField$MutatabilityAwareMap$MutatabilityAwareCollection mapField$MutatabilityAwareMap$MutatabilityAwareCollection = new MapField$MutatabilityAwareMap$MutatabilityAwareCollection(mutabilityOracle, collection);
        return mapField$MutatabilityAwareMap$MutatabilityAwareCollection;
    }
}

