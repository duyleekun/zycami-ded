/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d.c.a.o.k.o;
import d.c.a.o.k.x.e;
import d.c.a.o.m.f.b;
import d.c.a.u.m;

public class c
extends b
implements o {
    private final e b;

    public c(BitmapDrawable bitmapDrawable, e e10) {
        super((Drawable)bitmapDrawable);
        this.b = e10;
    }

    public void a() {
        ((BitmapDrawable)this.a).getBitmap().prepareToDraw();
    }

    public Class b() {
        return BitmapDrawable.class;
    }

    public int getSize() {
        return m.h(((BitmapDrawable)this.a).getBitmap());
    }

    public void recycle() {
        e e10 = this.b;
        Bitmap bitmap = ((BitmapDrawable)this.a).getBitmap();
        e10.d(bitmap);
    }
}

