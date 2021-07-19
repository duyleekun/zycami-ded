/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Collection;
import java.util.Iterator;

public abstract class Multisets$ElementSet
extends Sets$ImprovedAbstractSet {
    public void clear() {
        this.multiset().clear();
    }

    public boolean contains(Object object) {
        return this.multiset().contains(object);
    }

    public boolean containsAll(Collection collection) {
        return this.multiset().containsAll(collection);
    }

    public boolean isEmpty() {
        return this.multiset().isEmpty();
    }

    public abstract Iterator iterator();

    public abstract Multiset multiset();

    public boolean remove(Object object) {
        int n10;
        Multiset multiset = this.multiset();
        int n11 = multiset.remove(object, n10 = -1 >>> 1);
        if (n11 > 0) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public int size() {
        return this.multiset().entrySet().size();
    }
}

