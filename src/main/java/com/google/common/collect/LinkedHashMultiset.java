/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;
import com.google.common.collect.ObjectCountLinkedHashMap;

public final class LinkedHashMultiset
extends AbstractMapBasedMultiset {
    public LinkedHashMultiset(int n10) {
        super(n10);
    }

    public static LinkedHashMultiset create() {
        return LinkedHashMultiset.create(3);
    }

    public static LinkedHashMultiset create(int n10) {
        LinkedHashMultiset linkedHashMultiset = new LinkedHashMultiset(n10);
        return linkedHashMultiset;
    }

    public static LinkedHashMultiset create(Iterable iterable) {
        LinkedHashMultiset linkedHashMultiset = LinkedHashMultiset.create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(linkedHashMultiset, iterable);
        return linkedHashMultiset;
    }

    public void init(int n10) {
        ObjectCountLinkedHashMap objectCountLinkedHashMap = new ObjectCountLinkedHashMap(n10);
        this.backingMap = objectCountLinkedHashMap;
    }
}

