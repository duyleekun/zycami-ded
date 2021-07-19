/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

public final class ReverseOrdering
extends Ordering
implements Serializable {
    private static final long serialVersionUID;
    public final Ordering forwardOrder;

    public ReverseOrdering(Ordering ordering) {
        this.forwardOrder = ordering = (Ordering)Preconditions.checkNotNull(ordering);
    }

    public int compare(Object object, Object object2) {
        return this.forwardOrder.compare(object2, object);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof ReverseOrdering;
        if (bl2) {
            object = (ReverseOrdering)object;
            Ordering ordering = this.forwardOrder;
            object = ((ReverseOrdering)object).forwardOrder;
            return ordering.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public Object max(Iterable iterable) {
        return this.forwardOrder.min(iterable);
    }

    public Object max(Object object, Object object2) {
        return this.forwardOrder.min(object, object2);
    }

    public Object max(Object object, Object object2, Object object3, Object ... objectArray) {
        return this.forwardOrder.min(object, object2, object3, objectArray);
    }

    public Object max(Iterator iterator2) {
        return this.forwardOrder.min(iterator2);
    }

    public Object min(Iterable iterable) {
        return this.forwardOrder.max(iterable);
    }

    public Object min(Object object, Object object2) {
        return this.forwardOrder.max(object, object2);
    }

    public Object min(Object object, Object object2, Object object3, Object ... objectArray) {
        return this.forwardOrder.max(object, object2, object3, objectArray);
    }

    public Object min(Iterator iterator2) {
        return this.forwardOrder.max(iterator2);
    }

    public Ordering reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Ordering ordering = this.forwardOrder;
        stringBuilder.append(ordering);
        stringBuilder.append(".reverse()");
        return stringBuilder.toString();
    }
}

