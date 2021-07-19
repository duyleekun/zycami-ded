/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.o.b;
import d.c.a.o.j.k;
import d.c.a.o.m.d.v;
import java.io.InputStream;
import java.util.List;

public final class v$a
implements v {
    private final k a;
    private final d.c.a.o.k.x.b b;
    private final List c;

    public v$a(InputStream inputStream, List object, d.c.a.o.k.x.b b10) {
        d.c.a.o.k.x.b b11;
        this.b = b11 = (d.c.a.o.k.x.b)d.c.a.u.k.d(b10);
        object = (List)d.c.a.u.k.d(object);
        this.c = object;
        this.a = object = new k(inputStream, b10);
    }

    public Bitmap a(BitmapFactory.Options options) {
        return BitmapFactory.decodeStream((InputStream)this.a.d(), null, (BitmapFactory.Options)options);
    }

    public void b() {
        this.a.c();
    }

    public int c() {
        List list = this.c;
        InputStream inputStream = this.a.d();
        d.c.a.o.k.x.b b10 = this.b;
        return d.c.a.o.b.b(list, inputStream, b10);
    }

    public ImageHeaderParser$ImageType d() {
        List list = this.c;
        InputStream inputStream = this.a.d();
        d.c.a.o.k.x.b b10 = this.b;
        return d.c.a.o.b.e(list, inputStream, b10);
    }
}

