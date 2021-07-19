/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MutabilityOracle;
import java.util.Iterator;

public class MapField$MutatabilityAwareMap$MutatabilityAwareIterator
implements Iterator {
    private final Iterator delegate;
    private final MutabilityOracle mutabilityOracle;

    public MapField$MutatabilityAwareMap$MutatabilityAwareIterator(MutabilityOracle mutabilityOracle, Iterator iterator2) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = iterator2;
    }

    public boolean equals(Object object) {
        return this.delegate.equals(object);
    }

    public boolean hasNext() {
        return this.delegate.hasNext();
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public Object next() {
        return this.delegate.next();
    }

    public void remove() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.remove();
    }

    public String toString() {
        return this.delegate.toString();
    }
}

