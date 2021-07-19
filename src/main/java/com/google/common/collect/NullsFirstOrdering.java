/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;

public final class NullsFirstOrdering
extends Ordering
implements Serializable {
    private static final long serialVersionUID;
    public final Ordering ordering;

    public NullsFirstOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public int compare(Object object, Object object2) {
        if (object == object2) {
            return 0;
        }
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        return this.ordering.compare(object, object2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof NullsFirstOrdering;
        if (bl2) {
            object = (NullsFirstOrdering)object;
            Ordering ordering = this.ordering;
            object = ((NullsFirstOrdering)object).ordering;
            return ordering.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 0x39153A74;
    }

    public Ordering nullsFirst() {
        return this;
    }

    public Ordering nullsLast() {
        return this.ordering.nullsLast();
    }

    public Ordering reverse() {
        return this.ordering.reverse().nullsLast();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Ordering ordering = this.ordering;
        stringBuilder.append(ordering);
        stringBuilder.append(".nullsFirst()");
        return stringBuilder.toString();
    }
}

