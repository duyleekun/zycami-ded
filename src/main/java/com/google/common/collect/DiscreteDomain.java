/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.DiscreteDomain$1;
import com.google.common.collect.DiscreteDomain$BigIntegerDomain;
import com.google.common.collect.DiscreteDomain$IntegerDomain;
import com.google.common.collect.DiscreteDomain$LongDomain;
import java.util.NoSuchElementException;

public abstract class DiscreteDomain {
    public final boolean supportsFastOffset;

    public DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean bl2) {
        this.supportsFastOffset = bl2;
    }

    public /* synthetic */ DiscreteDomain(boolean bl2, DiscreteDomain$1 discreteDomain$1) {
        this(bl2);
    }

    public static DiscreteDomain bigIntegers() {
        return DiscreteDomain$BigIntegerDomain.access$300();
    }

    public static DiscreteDomain integers() {
        return DiscreteDomain$IntegerDomain.access$000();
    }

    public static DiscreteDomain longs() {
        return DiscreteDomain$LongDomain.access$200();
    }

    public abstract long distance(Comparable var1, Comparable var2);

    public Comparable maxValue() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public Comparable minValue() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public abstract Comparable next(Comparable var1);

    public Comparable offset(Comparable comparable, long l10) {
        long l11;
        String string2 = "distance";
        CollectPreconditions.checkNonnegative(l10, string2);
        long l12 = 0L;
        while ((l11 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) < 0) {
            comparable = this.next(comparable);
            long l13 = 1L;
            l12 += l13;
        }
        return comparable;
    }

    public abstract Comparable previous(Comparable var1);
}

