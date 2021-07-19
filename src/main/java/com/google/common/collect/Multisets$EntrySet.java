/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Sets$ImprovedAbstractSet;

public abstract class Multisets$EntrySet
extends Sets$ImprovedAbstractSet {
    public void clear() {
        this.multiset().clear();
    }

    public boolean contains(Object object) {
        int n10 = object instanceof Multiset$Entry;
        boolean bl2 = false;
        if (n10 != 0) {
            int n11;
            Object object2;
            n10 = (object = (Multiset$Entry)object).getCount();
            if (n10 <= 0) {
                return false;
            }
            Multiset multiset = this.multiset();
            n10 = multiset.count(object2 = object.getElement());
            if (n10 == (n11 = object.getCount())) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public abstract Multiset multiset();

    public boolean remove(Object object) {
        boolean bl2 = object instanceof Multiset$Entry;
        if (bl2) {
            object = (Multiset$Entry)object;
            Object object2 = object.getElement();
            int n10 = object.getCount();
            if (n10 != 0) {
                return this.multiset().setCount(object2, n10, 0);
            }
        }
        return false;
    }
}

