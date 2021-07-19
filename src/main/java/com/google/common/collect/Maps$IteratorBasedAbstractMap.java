/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$IteratorBasedAbstractMap$1;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Set;

public abstract class Maps$IteratorBasedAbstractMap
extends AbstractMap {
    public void clear() {
        Iterators.clear(this.entryIterator());
    }

    public abstract Iterator entryIterator();

    public Set entrySet() {
        Maps$IteratorBasedAbstractMap$1 maps$IteratorBasedAbstractMap$1 = new Maps$IteratorBasedAbstractMap$1(this);
        return maps$IteratorBasedAbstractMap$1;
    }

    public abstract int size();
}

