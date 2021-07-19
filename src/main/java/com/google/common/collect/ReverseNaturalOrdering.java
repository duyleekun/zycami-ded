/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

public final class ReverseNaturalOrdering
extends Ordering
implements Serializable {
    public static final ReverseNaturalOrdering INSTANCE;
    private static final long serialVersionUID;

    static {
        ReverseNaturalOrdering reverseNaturalOrdering;
        INSTANCE = reverseNaturalOrdering = new ReverseNaturalOrdering();
    }

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public Comparable max(Comparable comparable, Comparable comparable2) {
        return (Comparable)NaturalOrdering.INSTANCE.min(comparable, comparable2);
    }

    public Comparable max(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable ... comparableArray) {
        return (Comparable)NaturalOrdering.INSTANCE.min(comparable, comparable2, comparable3, comparableArray);
    }

    public Comparable max(Iterable iterable) {
        return (Comparable)NaturalOrdering.INSTANCE.min(iterable);
    }

    public Comparable max(Iterator iterator2) {
        return (Comparable)NaturalOrdering.INSTANCE.min(iterator2);
    }

    public Comparable min(Comparable comparable, Comparable comparable2) {
        return (Comparable)NaturalOrdering.INSTANCE.max(comparable, comparable2);
    }

    public Comparable min(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable ... comparableArray) {
        return (Comparable)NaturalOrdering.INSTANCE.max(comparable, comparable2, comparable3, comparableArray);
    }

    public Comparable min(Iterable iterable) {
        return (Comparable)NaturalOrdering.INSTANCE.max(iterable);
    }

    public Comparable min(Iterator iterator2) {
        return (Comparable)NaturalOrdering.INSTANCE.max(iterator2);
    }

    public Ordering reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}

