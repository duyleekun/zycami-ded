/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import d.c.a.o.k.s;
import d.c.a.u.m;

public final class e0$a
implements s {
    private final Bitmap a;

    public e0$a(Bitmap bitmap) {
        this.a = bitmap;
    }

    public Bitmap a() {
        return this.a;
    }

    public Class b() {
        return Bitmap.class;
    }

    public int getSize() {
        return m.h(this.a);
    }

    public void recycle() {
    }
}

