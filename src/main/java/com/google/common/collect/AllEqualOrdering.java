/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

public final class AllEqualOrdering
extends Ordering
implements Serializable {
    public static final AllEqualOrdering INSTANCE;
    private static final long serialVersionUID;

    static {
        AllEqualOrdering allEqualOrdering;
        INSTANCE = allEqualOrdering = new AllEqualOrdering();
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(Object object, Object object2) {
        return 0;
    }

    public ImmutableList immutableSortedCopy(Iterable iterable) {
        return ImmutableList.copyOf(iterable);
    }

    public Ordering reverse() {
        return this;
    }

    public List sortedCopy(Iterable iterable) {
        return Lists.newArrayList(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}

