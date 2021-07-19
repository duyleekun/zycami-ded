/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 */
package d.c.a.o.m.i;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d.c.a.o.f;
import d.c.a.o.k.s;
import d.c.a.o.m.d.g;
import d.c.a.o.m.i.e;

public final class c
implements e {
    private final d.c.a.o.k.x.e a;
    private final e b;
    private final e c;

    public c(d.c.a.o.k.x.e e10, e e11, e e12) {
        this.a = e10;
        this.b = e11;
        this.c = e12;
    }

    private static s b(s s10) {
        return s10;
    }

    public s a(s object, f f10) {
        Object object2 = (Drawable)object.get();
        boolean bl2 = object2 instanceof BitmapDrawable;
        if (bl2) {
            object = this.b;
            object2 = ((BitmapDrawable)object2).getBitmap();
            d.c.a.o.k.x.e e10 = this.a;
            object2 = g.d((Bitmap)object2, e10);
            return object.a((s)object2, f10);
        }
        boolean bl3 = object2 instanceof d.c.a.o.m.h.c;
        if (bl3) {
            object2 = this.c;
            object = d.c.a.o.m.i.c.b((s)object);
            return object2.a((s)object, f10);
        }
        return null;
    }
}

