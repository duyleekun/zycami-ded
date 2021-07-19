/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1;

public class k {
    private final float[] a;
    private float b;
    private int c;
    private int d;
    private boolean e;

    public k(int n10) {
        float[] fArray = new float[n10];
        this.a = fArray;
        this.f();
    }

    private int c(int n10) {
        float[] fArray = this.a;
        int n11 = fArray.length;
        if (++n10 >= n11) {
            n10 = 0;
        }
        return n10;
    }

    private void d(float f10) {
        float[] fArray;
        int n10;
        for (int i10 = 0; i10 < (n10 = (fArray = this.a).length); ++i10) {
            fArray[i10] = f10;
        }
        this.b = f10;
    }

    public long a() {
        return this.d;
    }

    public float b() {
        return this.b;
    }

    public void e(float f10) {
        int n10;
        float[] fArray;
        int n11 = this.e;
        if (n11 != 0) {
            this.d(f10);
            n11 = 0;
            fArray = null;
            this.e = false;
        }
        this.d = n11 = this.d + 1;
        fArray = this.a;
        int n12 = this.c;
        float f11 = fArray[n12];
        float f12 = this.b;
        f11 = f10 - f11;
        float f13 = fArray.length;
        this.b = f12 += (f11 /= f13);
        fArray[n12] = f10;
        this.c = n10 = this.c(n12);
    }

    public void f() {
        this.d = 0;
        this.e = true;
        this.c = 0;
        this.b = 0.0f;
    }
}

