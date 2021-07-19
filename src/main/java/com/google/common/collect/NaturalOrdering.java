/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.collect.ReverseNaturalOrdering;
import java.io.Serializable;

public final class NaturalOrdering
extends Ordering
implements Serializable {
    public static final NaturalOrdering INSTANCE;
    private static final long serialVersionUID;
    private transient Ordering nullsFirst;
    private transient Ordering nullsLast;

    static {
        NaturalOrdering naturalOrdering;
        INSTANCE = naturalOrdering = new NaturalOrdering();
    }

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public Ordering nullsFirst() {
        Ordering ordering = this.nullsFirst;
        if (ordering == null) {
            this.nullsFirst = ordering = super.nullsFirst();
        }
        return ordering;
    }

    public Ordering nullsLast() {
        Ordering ordering = this.nullsLast;
        if (ordering == null) {
            this.nullsLast = ordering = super.nullsLast();
        }
        return ordering;
    }

    public Ordering reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}

