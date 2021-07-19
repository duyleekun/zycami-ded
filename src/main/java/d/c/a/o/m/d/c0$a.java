/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.o$b;
import d.c.a.u.d;
import java.io.IOException;

public class c0$a
implements o$b {
    private final RecyclableBufferedInputStream a;
    private final d b;

    public c0$a(RecyclableBufferedInputStream recyclableBufferedInputStream, d d10) {
        this.a = recyclableBufferedInputStream;
        this.b = d10;
    }

    public void a(e e10, Bitmap bitmap) {
        IOException iOException = this.b.h();
        if (iOException != null) {
            if (bitmap != null) {
                e10.d(bitmap);
            }
            throw iOException;
        }
    }

    public void b() {
        this.a.h();
    }
}

