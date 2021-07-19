/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.m.h;

import android.graphics.Bitmap;
import d.c.a.m.a$a;
import d.c.a.o.k.x.e;

public final class b
implements a$a {
    private final e a;
    private final d.c.a.o.k.x.b b;

    public b(e e10) {
        this(e10, null);
    }

    public b(e e10, d.c.a.o.k.x.b b10) {
        this.a = e10;
        this.b = b10;
    }

    public void a(Bitmap bitmap) {
        this.a.d(bitmap);
    }

    public Bitmap b(int n10, int n11, Bitmap.Config config) {
        return this.a.g(n10, n11, config);
    }

    public byte[] c(int n10) {
        d.c.a.o.k.x.b b10 = this.b;
        if (b10 == null) {
            return new byte[n10];
        }
        return (byte[])b10.c(n10, byte[].class);
    }

    public int[] d(int n10) {
        d.c.a.o.k.x.b b10 = this.b;
        if (b10 == null) {
            return new int[n10];
        }
        return (int[])b10.c(n10, int[].class);
    }

    public void e(byte[] byArray) {
        d.c.a.o.k.x.b b10 = this.b;
        if (b10 == null) {
            return;
        }
        b10.put(byArray);
    }

    public void f(int[] nArray) {
        d.c.a.o.k.x.b b10 = this.b;
        if (b10 == null) {
            return;
        }
        b10.put(nArray);
    }
}

