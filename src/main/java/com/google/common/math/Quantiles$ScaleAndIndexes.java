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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Quantiles$ScaleAndIndexes {
    private final int[] indexes;
    private final int scale;

    private Quantiles$ScaleAndIndexes(int n10, int[] nArray) {
        int n11 = nArray.length;
        boolean bl2 = false;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = nArray[i10];
            Quantiles.access$300(n12, n10);
        }
        n11 = nArray.length;
        if (n11 > 0) {
            bl2 = true;
        }
        Preconditions.checkArgument(bl2, "Indexes must be a non empty array");
        this.scale = n10;
        this.indexes = nArray;
    }

    public /* synthetic */ Quantiles$ScaleAndIndexes(int n10, int[] nArray, Quantiles$1 quantiles$1) {
        this(n10, nArray);
    }

    public Map compute(Collection object) {
        object = Doubles.toArray((Collection)object);
        return this.computeInPlace((double[])object);
    }

    public Map compute(double ... dArray) {
        dArray = (double[])dArray.clone();
        return this.computeInPlace(dArray);
    }

    public Map compute(int ... objectArray) {
        objectArray = Quantiles.access$500(objectArray);
        return this.computeInPlace((double[])objectArray);
    }

    public Map compute(long ... objectArray) {
        objectArray = Quantiles.access$400(objectArray);
        return this.computeInPlace((double[])objectArray);
    }

    public Map computeInPlace(double ... dArray) {
        int n10;
        int[] nArray;
        int n11;
        int n12;
        LinkedHashMap<Integer, Double> linkedHashMap;
        Quantiles$ScaleAndIndexes quantiles$ScaleAndIndexes = this;
        double[] dArray2 = dArray;
        int n13 = dArray.length;
        int n14 = 0;
        int n15 = 1;
        if (n13 > 0) {
            n13 = n15;
        } else {
            n13 = 0;
            linkedHashMap = null;
        }
        Object object = "Cannot calculate quantiles of an empty dataset";
        Preconditions.checkArgument(n13 != 0, object);
        n13 = Quantiles.access$600(dArray);
        if (n13 != 0) {
            linkedHashMap = new LinkedHashMap<Integer, Double>();
            int[] nArray2 = quantiles$ScaleAndIndexes.indexes;
            int n16 = nArray2.length;
            while (n14 < n16) {
                int n17 = nArray2[n14];
                Integer n18 = n17;
                long l10 = 9221120237041090560L;
                double d10 = 0.0 / 0.0;
                Double d11 = d10;
                linkedHashMap.put(n18, d11);
                ++n14;
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
        linkedHashMap = (LinkedHashMap<Integer, Double>)quantiles$ScaleAndIndexes.indexes;
        int[] nArray3 = new int[((Object)linkedHashMap).length];
        int[] nArray4 = new int[((Object)linkedHashMap).length];
        n13 = ((Object)linkedHashMap).length * 2;
        linkedHashMap = (LinkedHashMap<Integer, Double>)new int[n13];
        object = null;
        int n19 = 0;
        double[] dArray3 = null;
        for (n12 = 0; n12 < (n11 = (nArray = quantiles$ScaleAndIndexes.indexes).length); ++n12) {
            long l11 = nArray[n12];
            long l12 = dArray2.length - n15;
            l11 *= l12;
            l12 = quantiles$ScaleAndIndexes.scale;
            RoundingMode roundingMode = RoundingMode.DOWN;
            l12 = LongMath.divide(l11, l12, roundingMode);
            int n20 = (int)l12;
            long l13 = n20;
            int n21 = quantiles$ScaleAndIndexes.scale;
            long l14 = n21;
            n10 = (int)(l11 -= (l13 *= l14));
            nArray3[n12] = n20;
            nArray4[n12] = n10;
            linkedHashMap[n19] = (LinkedHashMap)n20;
            ++n19;
            if (n10 == 0) continue;
            linkedHashMap[n19] = (LinkedHashMap)(++n20);
            ++n19;
        }
        Arrays.sort((int[])linkedHashMap, 0, n19);
        object = null;
        n19 -= n15;
        n10 = 0;
        nArray = null;
        n11 = dArray2.length - n15;
        n15 = 0;
        Object object2 = null;
        n12 = n19;
        dArray3 = dArray;
        Quantiles.access$900((int[])linkedHashMap, 0, n19, dArray, 0, n11);
        linkedHashMap = new LinkedHashMap<Integer, Double>();
        while (n14 < (n12 = ((int[])(object2 = quantiles$ScaleAndIndexes.indexes)).length)) {
            double d12;
            n12 = nArray3[n14];
            n19 = nArray4[n14];
            if (n19 == 0) {
                n15 = object2[n14];
                object2 = n15;
                d12 = dArray2[n12];
                object = d12;
                linkedHashMap.put((Integer)object2, (Double)object);
            } else {
                n15 = object2[n14];
                object2 = n15;
                double d13 = dArray2[n12];
                double d14 = dArray2[++n12];
                d12 = n19;
                n10 = quantiles$ScaleAndIndexes.scale;
                double d15 = n10;
                d12 = Quantiles.access$800(d13, d14, d12, d15);
                object = d12;
                linkedHashMap.put((Integer)object2, (Double)object);
            }
            ++n14;
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}

