/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;

public final class ComparatorOrdering
extends Ordering
implements Serializable {
    private static final long serialVersionUID;
    public final Comparator comparator;

    public ComparatorOrdering(Comparator comparator) {
        this.comparator = comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    public int compare(Object object, Object object2) {
        return this.comparator.compare(object, object2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof ComparatorOrdering;
        if (bl2) {
            object = (ComparatorOrdering)object;
            Comparator comparator = this.comparator;
            object = ((ComparatorOrdering)object).comparator;
            return comparator.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}

