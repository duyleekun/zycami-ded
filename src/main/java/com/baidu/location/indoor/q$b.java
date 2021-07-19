/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.indoor.q;

public class q$b {
    public double a;
    public double b;
    public final /* synthetic */ q c;

    public q$b(q q10) {
        double d10;
        this.c = q10;
        this.a = d10 = 0.0;
        this.b = d10;
    }

    public q$b(q q10, double d10, double d11) {
        this.c = q10;
        this.a = d10;
        this.b = d11;
    }

    public q$b(q q10, q$b q$b) {
        double d10;
        double d11;
        this.c = q10;
        this.a = d11 = q$b.a;
        this.b = d10 = q$b.b;
    }

    public q$b a(double d10) {
        q q10 = this.c;
        double d11 = this.a * d10;
        double d12 = this.b * d10;
        q$b q$b = new q$b(q10, d11, d12);
        return q$b;
    }

    public q$b a(q$b q$b) {
        q q10 = this.c;
        double d10 = this.a;
        double d11 = q$b.a;
        d10 -= d11;
        d11 = this.b;
        double d12 = q$b.b;
        q$b q$b2 = new q$b(q10, d10, d11 -= d12);
        return q$b2;
    }

    public q$b b(q$b q$b) {
        q q10 = this.c;
        double d10 = this.a;
        double d11 = q$b.a;
        d10 += d11;
        d11 = this.b;
        double d12 = q$b.b;
        q$b q$b2 = new q$b(q10, d10, d11 += d12);
        return q$b2;
    }

    public boolean b(double d10) {
        int n10;
        double d11;
        double d12 = Math.abs(this.a);
        double d13 = Math.abs(this.b);
        double d14 = 0.0;
        double d15 = d12 - d14;
        Object object = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
        n10 = object > 0 && (d11 = d12 == d10 ? 0 : (d12 < d10 ? -1 : 1)) < 0 && (d11 = d13 == d14 ? 0 : (d13 > d14 ? 1 : -1)) > 0 && (n10 = d13 == d10 ? 0 : (d13 < d10 ? -1 : 1)) < 0 ? 1 : 0;
        return n10 != 0;
    }
}

