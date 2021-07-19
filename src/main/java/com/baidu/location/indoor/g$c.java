/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.c.a;
import com.baidu.location.indoor.g;
import java.util.ArrayList;

public class g$c {
    public ArrayList a = null;
    public double[] b = null;
    public final /* synthetic */ g c;
    private float d = -0.18181887f;
    private float e = -0.90904963f;
    private float f = -0.55321634f;
    private float g = -0.05259979f;
    private float h = 24.0f;
    private float i = 8.61f;
    private float j = 4.25f;
    private float k = 60.39f;
    private float l = 15.6f;
    private float m = 68.07f;
    private float n = 11.61f;

    public g$c(g g10) {
        this.c = g10;
    }

    public double a(double d10, double d11, double d12, double d13) {
        double[] dArray = this.a(d11, d12);
        double d14 = dArray[0];
        d13 -= d14;
        d14 = Math.abs(d13);
        int n10 = 1;
        double d15 = dArray[n10];
        double d16 = 2.0;
        double d17 = d14 - (d15 *= d16);
        Object object = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
        if (object > 0) {
            d10 += d14;
        }
        return d10;
    }

    public double[] a(double d10, double d11) {
        return com.baidu.location.c.a.a().a(d10, d11);
    }
}

