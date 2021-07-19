/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import d.c.a.o.k.x.e;

public class f
implements e {
    public void a(int n10) {
    }

    public void b() {
    }

    public void c(float f10) {
    }

    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    public long e() {
        return 0L;
    }

    public Bitmap f(int n10, int n11, Bitmap.Config config) {
        return Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
    }

    public Bitmap g(int n10, int n11, Bitmap.Config config) {
        return this.f(n10, n11, config);
    }
}

