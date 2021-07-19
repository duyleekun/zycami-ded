/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.Quantiles$1;
import com.google.common.math.Quantiles$ScaleAndIndex;
import com.google.common.math.Quantiles$ScaleAndIndexes;
import com.google.common.primitives.Ints;
import java.util.Collection;

public final class Quantiles$Scale {
    private final int scale;

    private Quantiles$Scale(int n10) {
        boolean bl2 = n10 > 0;
        Preconditions.checkArgument(bl2, "Quantile scale must be positive");
        this.scale = n10;
    }

    public /* synthetic */ Quantiles$Scale(int n10, Quantiles$1 quantiles$1) {
        this(n10);
    }

    public Quantiles$ScaleAndIndex index(int n10) {
        int n11 = this.scale;
        Quantiles$ScaleAndIndex quantiles$ScaleAndIndex = new Quantiles$ScaleAndIndex(n11, n10, null);
        return quantiles$ScaleAndIndex;
    }

    public Quantiles$ScaleAndIndexes indexes(Collection object) {
        int n10 = this.scale;
        object = Ints.toArray((Collection)object);
        Quantiles$ScaleAndIndexes quantiles$ScaleAndIndexes = new Quantiles$ScaleAndIndexes(n10, (int[])object, null);
        return quantiles$ScaleAndIndexes;
    }

    public Quantiles$ScaleAndIndexes indexes(int ... nArray) {
        int n10 = this.scale;
        nArray = (int[])nArray.clone();
        Quantiles$ScaleAndIndexes quantiles$ScaleAndIndexes = new Quantiles$ScaleAndIndexes(n10, nArray, null);
        return quantiles$ScaleAndIndexes;
    }
}

