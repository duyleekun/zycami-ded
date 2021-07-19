/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import d.c.a.o.k.o;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.u.k;
import d.c.a.u.m;

public class g
implements s,
o {
    private final Bitmap a;
    private final e b;

    public g(Bitmap object, e e10) {
        this.a = object = (Bitmap)k.e(object, "Bitmap must not be null");
        object = (e)k.e(e10, "BitmapPool must not be null");
        this.b = object;
    }

    public static g d(Bitmap bitmap, e e10) {
        if (bitmap == null) {
            return null;
        }
        g g10 = new g(bitmap, e10);
        return g10;
    }

    public void a() {
        this.a.prepareToDraw();
    }

    public Class b() {
        return Bitmap.class;
    }

    public Bitmap c() {
        return this.a;
    }

    public int getSize() {
        return m.h(this.a);
    }

    public void recycle() {
        e e10 = this.b;
        Bitmap bitmap = this.a;
        e10.d(bitmap);
    }
}

