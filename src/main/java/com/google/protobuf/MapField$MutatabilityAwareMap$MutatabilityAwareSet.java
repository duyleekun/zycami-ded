/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MapField$MutatabilityAwareMap$MutatabilityAwareIterator;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MapField$MutatabilityAwareMap$MutatabilityAwareSet
implements Set {
    private final Set delegate;
    private final MutabilityOracle mutabilityOracle;

    public MapField$MutatabilityAwareMap$MutatabilityAwareSet(MutabilityOracle mutabilityOracle, Set set) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = set;
    }

    public boolean add(Object object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.add(object);
    }

    public boolean addAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.addAll(collection);
    }

    public void clear() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.clear();
    }

    public boolean contains(Object object) {
        return this.delegate.contains(object);
    }

    public boolean containsAll(Collection collection) {
        return this.delegate.containsAll(collection);
    }

    public boolean equals(Object object) {
        return this.delegate.equals(object);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public Iterator iterator() {
        MutabilityOracle mutabilityOracle = this.mutabilityOracle;
        Iterator iterator2 = this.delegate.iterator();
        MapField$MutatabilityAwareMap$MutatabilityAwareIterator mapField$MutatabilityAwareMap$MutatabilityAwareIterator = new MapField$MutatabilityAwareMap$MutatabilityAwareIterator(mutabilityOracle, iterator2);
        return mapField$MutatabilityAwareMap$MutatabilityAwareIterator;
    }

    public boolean remove(Object object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(object);
    }

    public boolean removeAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.retainAll(collection);
    }

    public int size() {
        return this.delegate.size();
    }

    public Object[] toArray() {
        return this.delegate.toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.delegate.toArray(objectArray);
    }

    public String toString() {
        return this.delegate.toString();
    }
}

