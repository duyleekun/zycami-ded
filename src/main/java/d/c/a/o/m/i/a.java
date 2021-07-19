/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 */
package d.c.a.o.m.i;

import android.graphics.Bitmap;
import d.c.a.o.f;
import d.c.a.o.k.s;
import d.c.a.o.m.e.b;
import d.c.a.o.m.i.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class a
implements e {
    private final Bitmap.CompressFormat a;
    private final int b;

    public a() {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        this(compressFormat, 100);
    }

    public a(Bitmap.CompressFormat compressFormat, int n10) {
        this.a = compressFormat;
        this.b = n10;
    }

    public s a(s s10, f object) {
        object = new ByteArrayOutputStream();
        Bitmap bitmap = (Bitmap)s10.get();
        Bitmap.CompressFormat compressFormat = this.a;
        int n10 = this.b;
        bitmap.compress(compressFormat, n10, (OutputStream)object);
        s10.recycle();
        object = ((ByteArrayOutputStream)object).toByteArray();
        s10 = new b((byte[])object);
        return s10;
    }
}

