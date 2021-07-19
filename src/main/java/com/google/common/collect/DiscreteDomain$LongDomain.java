/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;

public final class DiscreteDomain$LongDomain
extends DiscreteDomain
implements Serializable {
    private static final DiscreteDomain$LongDomain INSTANCE;
    private static final long serialVersionUID;

    static {
        DiscreteDomain$LongDomain discreteDomain$LongDomain;
        INSTANCE = discreteDomain$LongDomain = new DiscreteDomain$LongDomain();
    }

    public DiscreteDomain$LongDomain() {
        super(true, null);
    }

    public static /* synthetic */ DiscreteDomain$LongDomain access$200() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public long distance(Long l10, Long l11) {
        long l12;
        long l13 = l11;
        long l14 = l10;
        l13 -= l14;
        l14 = l11;
        long l15 = l10;
        long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        long l17 = 0L;
        if (l16 > 0 && (l16 = l13 == l17 ? 0 : (l13 < l17 ? -1 : 1)) < 0) {
            return Long.MAX_VALUE;
        }
        long l18 = l11;
        long l19 = l18 - (l12 = l10.longValue());
        Object object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object < 0 && (object = l13 == l17 ? 0 : (l13 < l17 ? -1 : 1)) > 0) {
            return Long.MIN_VALUE;
        }
        return l13;
    }

    public Long maxValue() {
        return Long.MAX_VALUE;
    }

    public Long minValue() {
        return Long.MIN_VALUE;
    }

    public Long next(Long l10) {
        long l11;
        long l12 = l10;
        long l13 = l12 - (l11 = Long.MAX_VALUE);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            object = 0;
            l10 = null;
        } else {
            l11 = 1L;
            l10 = l12 += l11;
        }
        return l10;
    }

    public Long offset(Long l10, long l11) {
        String string2 = "distance";
        CollectPreconditions.checkNonnegative(l11, string2);
        long l12 = l10 + l11;
        l11 = 0L;
        long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (l13 < 0) {
            long l14 = l10;
            long l15 = l14 - l11;
            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object < 0) {
                object = 1;
            } else {
                object = 0;
                l10 = null;
            }
            String string3 = "overflow";
            Preconditions.checkArgument((boolean)object, string3);
        }
        return l12;
    }

    public Long previous(Long l10) {
        long l11;
        long l12 = l10;
        long l13 = l12 - (l11 = Long.MIN_VALUE);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            object = 0;
            l10 = null;
        } else {
            l11 = 1L;
            l10 = l12 -= l11;
        }
        return l10;
    }

    public String toString() {
        return "DiscreteDomain.longs()";
    }
}

