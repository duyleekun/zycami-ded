/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Cut$AboveAll;
import com.google.common.collect.Cut$AboveValue;
import com.google.common.collect.Cut$BelowAll;
import com.google.common.collect.Cut$BelowValue;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Booleans;
import java.io.Serializable;

public abstract class Cut
implements Comparable,
Serializable {
    private static final long serialVersionUID;
    public final Comparable endpoint;

    public Cut(Comparable comparable) {
        this.endpoint = comparable;
    }

    public static Cut aboveAll() {
        return Cut$AboveAll.access$100();
    }

    public static Cut aboveValue(Comparable comparable) {
        Cut$AboveValue cut$AboveValue = new Cut$AboveValue(comparable);
        return cut$AboveValue;
    }

    public static Cut belowAll() {
        return Cut$BelowAll.access$000();
    }

    public static Cut belowValue(Comparable comparable) {
        Cut$BelowValue cut$BelowValue = new Cut$BelowValue(comparable);
        return cut$BelowValue;
    }

    public Cut canonical(DiscreteDomain discreteDomain) {
        return this;
    }

    public int compareTo(Cut cut) {
        Comparable comparable = Cut.belowAll();
        if (cut == comparable) {
            return 1;
        }
        comparable = Cut.aboveAll();
        if (cut == comparable) {
            return -1;
        }
        comparable = this.endpoint;
        Comparable comparable2 = cut.endpoint;
        int n10 = Range.compareOrThrow(comparable, comparable2);
        if (n10) {
            return n10;
        }
        n10 = this instanceof Cut$AboveValue;
        boolean bl2 = cut instanceof Cut$AboveValue;
        return Booleans.compare(n10 != 0, bl2);
    }

    public abstract void describeAsLowerBound(StringBuilder var1);

    public abstract void describeAsUpperBound(StringBuilder var1);

    public Comparable endpoint() {
        return this.endpoint;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof Cut;
        boolean bl3 = false;
        if (!bl2) return bl3;
        object = (Cut)object;
        try {
            int n10 = this.compareTo((Cut)object);
            if (n10 != 0) return bl3;
            return true;
        }
        catch (ClassCastException classCastException) {
            return bl3;
        }
    }

    public abstract Comparable greatestValueBelow(DiscreteDomain var1);

    public abstract int hashCode();

    public abstract boolean isLessThan(Comparable var1);

    public abstract Comparable leastValueAbove(DiscreteDomain var1);

    public abstract BoundType typeAsLowerBound();

    public abstract BoundType typeAsUpperBound();

    public abstract Cut withLowerBoundType(BoundType var1, DiscreteDomain var2);

    public abstract Cut withUpperBoundType(BoundType var1, DiscreteDomain var2);
}

