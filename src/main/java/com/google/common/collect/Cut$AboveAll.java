/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;

public final class Cut$AboveAll
extends Cut {
    private static final Cut$AboveAll INSTANCE;
    private static final long serialVersionUID;

    static {
        Cut$AboveAll cut$AboveAll;
        INSTANCE = cut$AboveAll = new Cut$AboveAll();
    }

    private Cut$AboveAll() {
        super(null);
    }

    public static /* synthetic */ Cut$AboveAll access$100() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public int compareTo(Cut cut) {
        int n10;
        if (cut == this) {
            n10 = 0;
            cut = null;
        } else {
            n10 = 1;
        }
        return n10;
    }

    public void describeAsLowerBound(StringBuilder object) {
        object = new AssertionError();
        throw object;
    }

    public void describeAsUpperBound(StringBuilder stringBuilder) {
        stringBuilder.append("+\u221e)");
    }

    public Comparable endpoint() {
        IllegalStateException illegalStateException = new IllegalStateException("range unbounded on this side");
        throw illegalStateException;
    }

    public Comparable greatestValueBelow(DiscreteDomain discreteDomain) {
        return discreteDomain.maxValue();
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public boolean isLessThan(Comparable comparable) {
        return false;
    }

    public Comparable leastValueAbove(DiscreteDomain object) {
        object = new AssertionError();
        throw object;
    }

    public String toString() {
        return "+\u221e";
    }

    public BoundType typeAsLowerBound() {
        AssertionError assertionError = new AssertionError((Object)"this statement should be unreachable");
        throw assertionError;
    }

    public BoundType typeAsUpperBound() {
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public Cut withLowerBoundType(BoundType object, DiscreteDomain discreteDomain) {
        object = new AssertionError((Object)"this statement should be unreachable");
        throw object;
    }

    public Cut withUpperBoundType(BoundType object, DiscreteDomain discreteDomain) {
        object = new IllegalStateException();
        throw object;
    }
}

