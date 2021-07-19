/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 */
package d.c.a.o.m.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import d.c.a.c;
import d.c.a.o.k.o;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.g;
import d.c.a.u.k;

public final class x
implements s,
o {
    private final Resources a;
    private final s b;

    private x(Resources object, s s10) {
        this.a = object = (Resources)k.d(object);
        object = (s)k.d(s10);
        this.b = object;
    }

    public static s d(Resources resources, s s10) {
        if (s10 == null) {
            return null;
        }
        x x10 = new x(resources, s10);
        return x10;
    }

    public static x e(Context object, Bitmap bitmap) {
        Resources resources = object.getResources();
        object = c.d(object).g();
        object = g.d(bitmap, (e)object);
        return (x)x.d(resources, (s)object);
    }

    public static x f(Resources resources, e object, Bitmap bitmap) {
        object = g.d(bitmap, (e)object);
        return (x)x.d(resources, (s)object);
    }

    public void a() {
        Object object = this.b;
        boolean bl2 = object instanceof o;
        if (bl2) {
            object = (o)object;
            object.a();
        }
    }

    public Class b() {
        return BitmapDrawable.class;
    }

    public BitmapDrawable c() {
        Resources resources = this.a;
        Bitmap bitmap = (Bitmap)this.b.get();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
        return bitmapDrawable;
    }

    public int getSize() {
        return this.b.getSize();
    }

    public void recycle() {
        this.b.recycle();
    }
}

