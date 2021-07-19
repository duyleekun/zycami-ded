/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSet;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public abstract class ForwardingSortedSet
extends ForwardingSet
implements SortedSet {
    private int unsafeCompare(Object object, Object object2) {
        int n10;
        Comparator comparator = this.comparator();
        if (comparator == null) {
            object = (Comparable)object;
            n10 = object.compareTo(object2);
        } else {
            n10 = comparator.compare(object, object2);
        }
        return n10;
    }

    public Comparator comparator() {
        return this.delegate().comparator();
    }

    public abstract SortedSet delegate();

    public Object first() {
        return this.delegate().first();
    }

    public SortedSet headSet(Object object) {
        return this.delegate().headSet(object);
    }

    public Object last() {
        return this.delegate().last();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean standardContains(Object object) {
        boolean bl2 = false;
        Object object2 = this.tailSet(object);
        object2 = object2.first();
        try {
            int n10 = this.unsafeCompare(object2, object);
            if (n10 != 0) return bl2;
            return true;
        }
        catch (ClassCastException | NullPointerException | NoSuchElementException runtimeException) {
            return bl2;
        }
    }

    public boolean standardRemove(Object object) {
        block7: {
            Object object2 = this.tailSet(object);
            object2 = object2.iterator();
            boolean bl2 = object2.hasNext();
            if (!bl2) break block7;
            Object e10 = object2.next();
            int n10 = this.unsafeCompare(e10, object);
            if (n10 != 0) break block7;
            try {
                object2.remove();
                return true;
            }
            catch (ClassCastException | NullPointerException runtimeException) {}
        }
        return false;
    }

    public SortedSet standardSubSet(Object object, Object object2) {
        return this.tailSet(object).headSet(object2);
    }

    public SortedSet subSet(Object object, Object object2) {
        return this.delegate().subSet(object, object2);
    }

    public SortedSet tailSet(Object object) {
        return this.delegate().tailSet(object);
    }
}

