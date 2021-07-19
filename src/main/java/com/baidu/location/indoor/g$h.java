/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.indoor.g;

public class g$h {
    public int a;
    public double b;
    public double c;
    public int d = 1;
    public double e;
    public final /* synthetic */ g f;

    public g$h(g g10, int n10, double d10, double d11, double d12) {
        this.f = g10;
        this.a = n10;
        this.b = d10;
        this.c = d11;
        this.e = d12;
    }

    public String toString() {
        double d10 = this.c;
        double d11 = this.e;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        int n10 = 3;
        int n11 = 2;
        int n12 = 1;
        Double d13 = null;
        if (d12 == false) {
            Object[] objectArray = new Object[n10];
            Number number = this.d;
            objectArray[0] = number;
            number = this.c;
            objectArray[n12] = number;
            number = this.b;
            objectArray[n11] = number;
            return String.format("%d:%.1f:%.2f", objectArray);
        }
        Object[] objectArray = new Object[4];
        Integer n13 = this.d;
        objectArray[0] = n13;
        d13 = this.c;
        objectArray[n12] = d13;
        Double d14 = this.b;
        objectArray[n11] = d14;
        Double d15 = this.e;
        objectArray[n10] = d15;
        return String.format("%d:%.1f:%.2f:%.1f", objectArray);
    }
}

