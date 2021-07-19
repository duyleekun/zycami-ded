/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.DiscreteDomain;
import com.google.common.primitives.Ints;
import java.io.Serializable;

public final class DiscreteDomain$IntegerDomain
extends DiscreteDomain
implements Serializable {
    private static final DiscreteDomain$IntegerDomain INSTANCE;
    private static final long serialVersionUID;

    static {
        DiscreteDomain$IntegerDomain discreteDomain$IntegerDomain;
        INSTANCE = discreteDomain$IntegerDomain = new DiscreteDomain$IntegerDomain();
    }

    public DiscreteDomain$IntegerDomain() {
        super(true, null);
    }

    public static /* synthetic */ DiscreteDomain$IntegerDomain access$000() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public long distance(Integer n10, Integer n11) {
        long l10 = n11.intValue();
        long l11 = n10.intValue();
        return l10 - l11;
    }

    public Integer maxValue() {
        return -1 >>> 1;
    }

    public Integer minValue() {
        return -1 << -1;
    }

    public Integer next(Integer n10) {
        int n11;
        int n12 = n10;
        if (n12 == (n11 = -1 >>> 1)) {
            n12 = 0;
            n10 = null;
        } else {
            n10 = ++n12;
        }
        return n10;
    }

    public Integer offset(Integer n10, long l10) {
        CollectPreconditions.checkNonnegative(l10, "distance");
        return Ints.checkedCast(n10.longValue() + l10);
    }

    public Integer previous(Integer n10) {
        int n11;
        int n12 = n10;
        if (n12 == (n11 = -1 << -1)) {
            n12 = 0;
            n10 = null;
        } else {
            n10 = n12 += -1;
        }
        return n10;
    }

    public String toString() {
        return "DiscreteDomain.integers()";
    }
}

