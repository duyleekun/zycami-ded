/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.math.Quantiles;
import com.google.common.math.Quantiles$1;
import com.google.common.primitives.Doubles;
import java.math.RoundingMode;
import java.util.Collection;

public final class Quantiles$ScaleAndIndex {
    private final int index;
    private final int scale;

    private Quantiles$ScaleAndIndex(int n10, int n11) {
        Quantiles.access$300(n11, n10);
        this.scale = n10;
        this.index = n11;
    }

    public /* synthetic */ Quantiles$ScaleAndIndex(int n10, int n11, Quantiles$1 quantiles$1) {
        this(n10, n11);
    }

    public double compute(Collection object) {
        object = Doubles.toArray((Collection)object);
        return this.computeInPlace((double[])object);
    }

    public double compute(double ... dArray) {
        dArray = (double[])dArray.clone();
        return this.computeInPlace(dArray);
    }

    public double compute(int ... objectArray) {
        objectArray = Quantiles.access$500(objectArray);
        return this.computeInPlace((double[])objectArray);
    }

    public double compute(long ... objectArray) {
        objectArray = Quantiles.access$400(objectArray);
        return this.computeInPlace((double[])objectArray);
    }

    public double computeInPlace(double ... dArray) {
        RoundingMode roundingMode;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 > 0) {
            n10 = n12;
        } else {
            n10 = 0;
            roundingMode = null;
        }
        String string2 = "Cannot calculate quantiles of an empty dataset";
        Preconditions.checkArgument(n10 != 0, string2);
        n10 = Quantiles.access$600(dArray);
        if (n10 != 0) {
            return 0.0 / 0.0;
        }
        long l10 = this.index;
        long l11 = dArray.length - n12;
        l10 *= l11;
        l11 = this.scale;
        roundingMode = RoundingMode.DOWN;
        n10 = (int)LongMath.divide(l10, l11, roundingMode);
        l11 = n10;
        int n13 = this.scale;
        long l12 = n13;
        int n14 = (int)(l10 -= (l11 *= l12));
        int n15 = dArray.length - n12;
        Quantiles.access$700(n10, dArray, 0, n15);
        if (n14 == 0) {
            return dArray[n10];
        }
        n11 = n10 + 1;
        n15 = dArray.length - n12;
        Quantiles.access$700(n11, dArray, n11, n15);
        double d10 = dArray[n10];
        double d11 = dArray[n11];
        double d12 = n14;
        double d13 = this.scale;
        return Quantiles.access$800(d10, d11, d12, d13);
    }
}

