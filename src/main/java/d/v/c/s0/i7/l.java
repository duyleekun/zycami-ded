/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package d.v.c.s0.i7;

import android.graphics.Color;

public class l {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public l(int n10, int n11) {
        this.a = n10;
        this.b = n11;
        this.d();
    }

    private void d() {
        int n10;
        this.c = n10 = Color.red((int)this.a);
        this.d = n10 = Color.blue((int)this.a);
        this.e = n10 = Color.green((int)this.a);
        this.f = n10 = Color.red((int)this.b);
        this.g = n10 = Color.blue((int)this.b);
        this.h = n10 = Color.green((int)this.b);
    }

    public int a(float f10) {
        int n10 = this.c;
        double d10 = n10;
        double d11 = (float)(this.f - n10) * f10;
        double d12 = 0.5;
        n10 = (int)(d10 + (d11 += d12));
        int n11 = this.e;
        double d13 = n11;
        double d14 = (double)((float)(this.h - n11) * f10) + d12;
        n11 = (int)(d13 + d14);
        int n12 = this.d;
        d11 = n12;
        d14 = (double)((float)(this.g - n12) * f10) + d12;
        int n13 = (int)(d11 + d14);
        return Color.rgb((int)n10, (int)n11, (int)n13);
    }

    public void b(int n10) {
        this.b = n10;
        this.d();
    }

    public void c(int n10) {
        this.a = n10;
        this.d();
    }
}

