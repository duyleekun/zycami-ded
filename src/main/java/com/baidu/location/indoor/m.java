/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

public class m {
    private static double a = 6378137.0;

    public static double a(double d10, double d11, double d12, double d13) {
        double d14 = d13 - d11;
        double d15 = d12 - d10;
        d10 = Math.toRadians(d10);
        Math.toRadians(d11);
        d11 = Math.toRadians(d12);
        Math.toRadians(d13);
        d12 = Math.toRadians(d14);
        d13 = Math.toRadians(d15);
        d14 = 2.0;
        d15 = Math.sin(d13 /= d14);
        d13 = Math.sin(d13);
        d15 *= d13;
        d10 = Math.cos(d10);
        d11 = Math.cos(d11);
        d10 *= d11;
        d11 = Math.sin(d12 /= d14);
        d10 *= d11;
        d11 = Math.sin(d12);
        d10 = Math.sqrt(d15 += (d10 *= d11));
        d11 = Math.sqrt(1.0 - d15);
        d10 = Math.atan2(d10, d11) * d14;
        d11 = a;
        return d10 * d11;
    }
}

