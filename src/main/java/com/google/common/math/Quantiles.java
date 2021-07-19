/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.math.Quantiles$Scale;
import com.google.common.math.Quantiles$ScaleAndIndex;

public final class Quantiles {
    public static /* synthetic */ void access$300(int n10, int n11) {
        Quantiles.checkIndex(n10, n11);
    }

    public static /* synthetic */ double[] access$400(long[] lArray) {
        return Quantiles.longsToDoubles(lArray);
    }

    public static /* synthetic */ double[] access$500(int[] nArray) {
        return Quantiles.intsToDoubles(nArray);
    }

    public static /* synthetic */ boolean access$600(double[] dArray) {
        return Quantiles.containsNaN(dArray);
    }

    public static /* synthetic */ void access$700(int n10, double[] dArray, int n11, int n12) {
        Quantiles.selectInPlace(n10, dArray, n11, n12);
    }

    public static /* synthetic */ double access$800(double d10, double d11, double d12, double d13) {
        return Quantiles.interpolate(d10, d11, d12, d13);
    }

    public static /* synthetic */ void access$900(int[] nArray, int n10, int n11, double[] dArray, int n12, int n13) {
        Quantiles.selectAllInPlace(nArray, n10, n11, dArray, n12, n13);
    }

    private static void checkIndex(int n10, int n11) {
        if (n10 >= 0 && n10 <= n11) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Quantile indexes must be between 0 and the scale, which is ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private static int chooseNextSelection(int[] nArray, int n10, int n11, int n12, int n13) {
        int n14;
        if (n10 == n11) {
            return n10;
        }
        n12 += n13;
        n13 = n12 >>> 1;
        while (n11 > (n14 = n10 + 1)) {
            n14 = n10 + n11 >>> 1;
            int n15 = nArray[n14];
            if (n15 > n13) {
                n11 = n14;
                continue;
            }
            n10 = nArray[n14];
            if (n10 < n13) {
                n10 = n14;
                continue;
            }
            return n14;
        }
        n13 = nArray[n10];
        n12 -= n13;
        int n16 = nArray[n11];
        if ((n12 -= n16) > 0) {
            return n11;
        }
        return n10;
    }

    private static boolean containsNaN(double ... dArray) {
        for (double d10 : dArray) {
            boolean bl2 = Double.isNaN(d10);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private static double interpolate(double d10, double d11, double d12, double d13) {
        double d14 = -1.0 / 0.0;
        double d15 = d10 == d14 ? 0 : (d10 > d14 ? 1 : -1);
        double d16 = 1.0 / 0.0;
        if (d15 == false) {
            Object object = d11 == d16 ? 0 : (d11 > d16 ? 1 : -1);
            if (object == false) {
                return 0.0 / 0.0;
            }
            return d14;
        }
        Object object = d11 == d16 ? 0 : (d11 > d16 ? 1 : -1);
        if (object == false) {
            return d16;
        }
        d11 = (d11 - d10) * d12 / d13;
        return d10 + d11;
    }

    private static double[] intsToDoubles(int[] nArray) {
        int n10 = nArray.length;
        double[] dArray = new double[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10;
            int n11 = nArray[i10];
            dArray[i10] = d10 = (double)n11;
        }
        return dArray;
    }

    private static double[] longsToDoubles(long[] lArray) {
        int n10 = lArray.length;
        double[] dArray = new double[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10;
            long l10 = lArray[i10];
            dArray[i10] = d10 = (double)l10;
        }
        return dArray;
    }

    public static Quantiles$ScaleAndIndex median() {
        return Quantiles.scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] dArray, int n10, int n11) {
        int n12 = n10 + n11;
        double d10 = dArray[n11];
        int n13 = 1;
        double d11 = dArray[n12 >>>= n13];
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        object = object < 0 ? (Object)n13 : (Object)false;
        d11 = dArray[n12];
        double d13 = dArray[n10];
        double d14 = d11 == d13 ? 0 : (d11 < d13 ? -1 : 1);
        d14 = d14 < 0 ? (double)n13 : 0.0;
        double d15 = dArray[n11];
        double d16 = dArray[n10];
        double d17 = d15 - d16;
        Object object2 = d17 == 0.0 ? 0 : (d17 < 0.0 ? -1 : 1);
        if (object2 >= 0) {
            n13 = 0;
        }
        if (object == d14) {
            Quantiles.swap(dArray, n12, n10);
        } else if (object != n13) {
            Quantiles.swap(dArray, n10, n11);
        }
    }

    private static int partition(double[] dArray, int n10, int n11) {
        Quantiles.movePivotToStartOfSlice(dArray, n10, n11);
        double d10 = dArray[n10];
        int n12 = n11;
        while (n11 > n10) {
            double d11 = dArray[n11];
            double d12 = d11 - d10;
            Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object > 0) {
                Quantiles.swap(dArray, n12, n11);
                n12 += -1;
            }
            n11 += -1;
        }
        Quantiles.swap(dArray, n10, n12);
        return n12;
    }

    public static Quantiles$Scale percentiles() {
        return Quantiles.scale(100);
    }

    public static Quantiles$Scale quartiles() {
        return Quantiles.scale(4);
    }

    public static Quantiles$Scale scale(int n10) {
        Quantiles$Scale quantiles$Scale = new Quantiles$Scale(n10, null);
        return quantiles$Scale;
    }

    private static void selectAllInPlace(int[] nArray, int n10, int n11, double[] dArray, int n12, int n13) {
        int n14;
        int n15;
        int n16;
        int n17 = Quantiles.chooseNextSelection(nArray, n10, n11, n12, n13);
        int n18 = nArray[n17];
        Quantiles.selectInPlace(n18, dArray, n12, n13);
        for (n16 = n15 = n17 + -1; n16 >= n10 && (n15 = nArray[n16]) == n18; n16 += -1) {
        }
        if (n16 >= n10) {
            int n19 = n18 + -1;
            Quantiles.selectAllInPlace(nArray, n10, n16, dArray, n12, n19);
        }
        for (n14 = ++n17; n14 <= n11 && (n10 = nArray[n14]) == n18; ++n14) {
        }
        if (n14 <= n11) {
            int n20 = n18 + 1;
            Quantiles.selectAllInPlace(nArray, n14, n11, dArray, n20, n13);
        }
    }

    private static void selectInPlace(int n10, double[] dArray, int n11, int n12) {
        if (n10 == n11) {
            int n13 = n11;
            for (n10 = n11 + 1; n10 <= n12; ++n10) {
                double d10 = dArray[n13];
                double d11 = dArray[n10];
                double d12 = d10 - d11;
                Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
                if (object <= 0) continue;
                n13 = n10;
            }
            if (n13 != n11) {
                Quantiles.swap(dArray, n13, n11);
            }
            return;
        }
        while (n12 > n11) {
            int n14 = Quantiles.partition(dArray, n11, n12);
            if (n14 >= n10) {
                n12 = n14 + -1;
            }
            if (n14 > n10) continue;
            n11 = ++n14;
        }
    }

    private static void swap(double[] dArray, int n10, int n11) {
        double d10;
        double d11 = dArray[n10];
        dArray[n10] = d10 = dArray[n11];
        dArray[n11] = d11;
    }
}

