/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.ImageDecoder$OnHeaderDecodedListener
 *  android.graphics.ImageDecoder$Source
 */
package d.c.a.o.m;

import android.graphics.ImageDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import d.c.a.o.e;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.m.a$a;
import d.c.a.o.m.d.o;
import d.c.a.o.m.d.u;

public abstract class a
implements g {
    private static final String b = "ImageDecoder";
    public final u a;

    public a() {
        u u10;
        this.a = u10 = u.a();
    }

    public abstract s c(ImageDecoder.Source var1, int var2, int var3, ImageDecoder.OnHeaderDecodedListener var4);

    public final s d(ImageDecoder.Source source, int n10, int n11, f object) {
        boolean bl2;
        Object object2 = o.g;
        Object object3 = object2 = ((f)object).c((e)object2);
        object3 = (DecodeFormat)((Object)object2);
        object2 = DownsampleStrategy.h;
        Object object4 = object2 = ((f)object).c((e)object2);
        object4 = (DownsampleStrategy)object2;
        object2 = o.k;
        Object object5 = ((f)object).c((e)object2);
        if (object5 != null && (bl2 = ((Boolean)(object2 = (Boolean)((f)object).c((e)object2))).booleanValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        object2 = o.h;
        Object object6 = object = ((f)object).c((e)object2);
        object6 = (PreferredColorSpace)((Object)object);
        object5 = object;
        object = new a$a(this, n10, n11, bl2, (DecodeFormat)((Object)object3), (DownsampleStrategy)object4, (PreferredColorSpace)((Object)object6));
        return this.c(source, n10, n11, (ImageDecoder.OnHeaderDecodedListener)object);
    }

    public final boolean e(ImageDecoder.Source source, f f10) {
        return true;
    }
}

