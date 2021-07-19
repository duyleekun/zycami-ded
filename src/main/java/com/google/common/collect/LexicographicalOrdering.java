/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;

public final class LexicographicalOrdering
extends Ordering
implements Serializable {
    private static final long serialVersionUID;
    public final Comparator elementOrder;

    public LexicographicalOrdering(Comparator comparator) {
        this.elementOrder = comparator;
    }

    public int compare(Iterable object, Iterable object2) {
        int n10;
        object = object.iterator();
        object2 = object2.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object e10;
            n10 = object2.hasNext();
            if (n10 == 0) {
                return 1;
            }
            Comparator comparator = this.elementOrder;
            Object e11 = object.next();
            n10 = comparator.compare(e11, e10 = object2.next());
            if (n10 == 0) continue;
            return n10;
        }
        boolean bl2 = object2.hasNext();
        if (bl2) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof LexicographicalOrdering;
        if (bl2) {
            object = (LexicographicalOrdering)object;
            Comparator comparator = this.elementOrder;
            object = ((LexicographicalOrdering)object).elementOrder;
            return comparator.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 0x7BB78CF5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Comparator comparator = this.elementOrder;
        stringBuilder.append(comparator);
        stringBuilder.append(".lexicographical()");
        return stringBuilder.toString();
    }
}

