/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b2.w;

import d.v.c.b2.x.a;

public class i
implements a {
    private static final long[] f;
    private static final float g = 200.0f;
    private static final float h = 1.0f;
    private static final float i = 2.0f;
    private float a;
    private int b;
    private long c;
    private int d;
    private int e;

    static {
        long[] lArray;
        long[] lArray2 = lArray = new long[10];
        long[] lArray3 = lArray;
        lArray2[0] = 64000000L;
        lArray3[1] = 32000000L;
        lArray2[2] = 16000000L;
        lArray3[3] = 8000000L;
        lArray2[4] = 4000000L;
        lArray3[5] = 2000000L;
        lArray2[6] = 1000000L;
        lArray3[7] = 500000L;
        lArray2[8] = 250000L;
        lArray3[9] = 125000L;
        f = lArray;
    }

    public i(float f10, int n10, long l10) {
        int n11;
        this.b = 0;
        this.d = 0;
        this.e = n11 = f.length + -1;
        this.a = f10;
        this.b = n10;
        this.c = l10;
    }

    public i(long l10) {
        int n10 = f.length + -1 + -2;
        this(1.0f, n10, l10);
    }

    private boolean e(int n10) {
        int n11 = this.b;
        int n12 = this.d;
        if ((n10 += n11) < n12 && n10 < n11) {
            return false;
        }
        n12 = this.e;
        if (n10 > n12 && n10 > n11) {
            return false;
        }
        this.b = n10;
        return true;
    }

    private int f(long l10) {
        long[] lArray;
        int n10;
        for (int i10 = 0; i10 < (n10 = (lArray = f).length); ++i10) {
            long l11 = lArray[i10];
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object <= 0) continue;
            return i10;
        }
        return lArray.length + -1;
    }

    public void d(float f10) {
        float f11 = this.a + f10;
        int n10 = 0x40000000;
        f10 = 2.0f;
        float f12 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
        float f13 = 1.0f;
        if (f12 > 0) {
            f12 = (float)this.e(1);
            this.a = f12 != false ? (f11 -= f13) : f10;
        } else {
            n10 = (int)(f11 == f13 ? 0 : (f11 < f13 ? -1 : 1));
            if (n10 < 0) {
                f10 = 0.0f / 0.0f;
                n10 = (int)(this.e(-1) ? 1 : 0);
                this.a = n10 != 0 ? (f11 += f13) : f13;
            } else {
                this.a = f11;
            }
        }
    }

    public float g() {
        return this.a;
    }

    public float getLengthMinimum() {
        float f10 = this.g() * 200.0f;
        float f11 = 100.0f;
        return (float)((int)(f10 * f11) / 5 * 5) / f11;
    }

    public long getTimeMinimum() {
        long[] lArray = f;
        int n10 = this.b;
        return lArray[n10];
    }

    public long getTotalTime() {
        return this.c;
    }

    public void h(long l10) {
        int n10;
        this.d = n10 = this.f(l10 /= (long)4);
    }

    public void i(int n10) {
        this.e = n10;
    }

    public void j(int n10) {
        this.d = n10;
    }

    public void k(long l10) {
        this.c = l10;
    }
}

