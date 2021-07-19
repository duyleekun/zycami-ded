/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.o.b;
import d.c.a.o.j.m;
import d.c.a.o.m.d.v;
import d.c.a.u.k;
import java.io.FileDescriptor;
import java.util.List;

public final class v$b
implements v {
    private final d.c.a.o.k.x.b a;
    private final List b;
    private final m c;

    public v$b(ParcelFileDescriptor parcelFileDescriptor, List object, d.c.a.o.k.x.b b10) {
        this.a = b10 = (d.c.a.o.k.x.b)k.d(b10);
        object = (List)k.d(object);
        this.b = object;
        this.c = object = new m(parcelFileDescriptor);
    }

    public Bitmap a(BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor((FileDescriptor)this.c.d().getFileDescriptor(), null, (BitmapFactory.Options)options);
    }

    public void b() {
    }

    public int c() {
        List list = this.b;
        m m10 = this.c;
        d.c.a.o.k.x.b b10 = this.a;
        return d.c.a.o.b.a(list, m10, b10);
    }

    public ImageHeaderParser$ImageType d() {
        List list = this.b;
        m m10 = this.c;
        d.c.a.o.k.x.b b10 = this.a;
        return d.c.a.o.b.d(list, m10, b10);
    }
}

