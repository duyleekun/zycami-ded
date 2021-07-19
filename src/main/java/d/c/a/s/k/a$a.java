/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 */
package d.c.a.s.k;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import d.c.a.s.k.a;
import d.c.a.s.k.f;
import d.c.a.s.k.f$a;

public final class a$a
implements f {
    private final f a;
    public final /* synthetic */ a b;

    public a$a(a a10, f f10) {
        this.b = a10;
        this.a = f10;
    }

    public boolean a(Object object, f$a f$a) {
        Resources resources = f$a.getView().getResources();
        object = this.b.b(object);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, (Bitmap)object);
        return this.a.a(bitmapDrawable, f$a);
    }
}

