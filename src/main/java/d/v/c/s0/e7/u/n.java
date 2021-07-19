/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package d.v.c.s0.e7.u;

import android.graphics.Rect;

public class n
implements Comparable {
    private int a;
    private Rect b;
    private Rect c;
    private int d;

    public n(int n10, Rect rect, Rect rect2) {
        this.a = n10;
        this.b = rect;
        this.c = rect2;
        this.d = n10 = this.a(rect2, rect);
    }

    private int a(Rect rect, Rect rect2) {
        int n10 = rect.centerX();
        int n11 = rect.centerY();
        int n12 = rect2.centerX();
        int n13 = rect2.centerY();
        double d10 = n10 - n12;
        double d11 = n11 - n13;
        return (int)Math.round(Math.hypot(d10, d11));
    }

    public int b(n n10) {
        int n11 = this.d;
        int n12 = n10.d();
        return Integer.compare(n11, n12);
    }

    public Rect c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public Rect e() {
        return this.c;
    }

    public int f() {
        return this.a;
    }
}

