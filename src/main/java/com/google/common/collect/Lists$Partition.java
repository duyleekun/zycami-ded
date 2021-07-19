/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

public class Lists$Partition
extends AbstractList {
    public final List list;
    public final int size;

    public Lists$Partition(List list, int n10) {
        this.list = list;
        this.size = n10;
    }

    public List get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        n11 = this.size;
        n10 *= n11;
        n11 += n10;
        int n12 = this.list.size();
        n11 = Math.min(n11, n12);
        return this.list.subList(n10, n11);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        int n10 = this.list.size();
        int n11 = this.size;
        RoundingMode roundingMode = RoundingMode.CEILING;
        return IntMath.divide(n10, n11, roundingMode);
    }
}

