/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.h;

import com.baidu.location.h.e;
import com.baidu.location.h.e$a;

public class e$b {
    public e$a a;
    public e$a b;
    public final /* synthetic */ e c;

    public e$b(e e10, e$a e$a, e$a e$a2) {
        this.c = e10;
        this.a = e$a;
        this.b = e$a2;
    }

    public double a(e$a e$a) {
        e$a e$a2;
        e e10 = this.c;
        e$a e$a3 = this.b;
        double d10 = e$a3.a;
        e$a e$a4 = this.a;
        double d11 = e$a4.a;
        d10 -= d11;
        d11 = e$a3.b;
        double d12 = e$a4.b;
        d12 = d11 - d12;
        e$a3 = e$a2;
        e$a2 = new e$a(e10, d10, d12);
        e e11 = this.c;
        double d13 = e$a.a;
        e$a e$a5 = this.a;
        d12 = e$a5.a;
        double d14 = d13 - d12;
        d13 = e$a.b;
        double d15 = e$a5.b;
        double d16 = d13 - d15;
        e$a3 = new e$a(e11, d14, d16);
        d13 = e$a2.a;
        d15 = e$a3.b;
        d13 *= d15;
        d15 = e$a2.b;
        double d17 = e$a3.a;
        return d13 - (d15 *= d17);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean b(e$a e$a) {
        void var17_15;
        e e10 = this.c;
        double d10 = this.a(e$a);
        int n10 = e10.a(d10);
        if (n10 == 0) {
            double d11 = e$a.a;
            e$a e$a2 = this.a;
            double d12 = e$a2.a;
            e$a e$a3 = this.b;
            double d13 = e$a3.a;
            d12 = Math.max(d12, d13);
            d13 = 1.0E-8;
            double d14 = d11 - (d12 += d13);
            n10 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1));
            if (n10 < 0) {
                d11 = e$a.a;
                e$a2 = this.a;
                d12 = e$a2.a;
                e$a e$a4 = this.b;
                double d15 = e$a4.a;
                double d16 = d11 - (d12 = Math.min(d12, d15) - d13);
                n10 = (int)(d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1));
                if (n10 > 0) {
                    d11 = e$a.b;
                    e$a2 = this.a;
                    d12 = e$a2.b;
                    e$a4 = this.b;
                    d15 = e$a4.b;
                    double d17 = d11 - (d12 = Math.max(d12, d15) + d13);
                    n10 = (int)(d17 == 0.0 ? 0 : (d17 < 0.0 ? -1 : 1));
                    if (n10 < 0) {
                        d11 = e$a.b;
                        d12 = this.a.b;
                        e$a = this.b;
                        d15 = e$a.b;
                        double d18 = d11 - (d12 = Math.min(d12, d15) - d13);
                        Object object = d18 == 0.0 ? 0 : (d18 > 0.0 ? 1 : -1);
                        if (object > 0) {
                            return (boolean)var17_15;
                        }
                    }
                }
            }
        }
        boolean bl2 = false;
        return (boolean)var17_15;
    }
}

