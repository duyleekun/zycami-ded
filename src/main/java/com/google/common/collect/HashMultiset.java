/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;
import com.google.common.collect.ObjectCountHashMap;

public class HashMultiset
extends AbstractMapBasedMultiset {
    private static final long serialVersionUID;

    public HashMultiset(int n10) {
        super(n10);
    }

    public static HashMultiset create() {
        return HashMultiset.create(3);
    }

    public static HashMultiset create(int n10) {
        HashMultiset hashMultiset = new HashMultiset(n10);
        return hashMultiset;
    }

    public static HashMultiset create(Iterable iterable) {
        HashMultiset hashMultiset = HashMultiset.create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(hashMultiset, iterable);
        return hashMultiset;
    }

    public void init(int n10) {
        ObjectCountHashMap objectCountHashMap;
        this.backingMap = objectCountHashMap = new ObjectCountHashMap(n10);
    }
}

