/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import d.c.a.o.c;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.d0;
import d.c.a.o.m.d.h;
import d.c.a.u.m;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class a0
extends h {
    private static final String d = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] e;
    private final int c;

    static {
        Charset charset = d.c.a.o.c.b;
        e = d.getBytes(charset);
    }

    public a0(int n10) {
        this.c = n10;
    }

    public void b(MessageDigest messageDigest) {
        Object object = e;
        messageDigest.update((byte[])object);
        object = ByteBuffer.allocate(4);
        int n10 = this.c;
        object = object.putInt(n10).array();
        messageDigest.update((byte[])object);
    }

    public Bitmap c(e e10, Bitmap bitmap, int n10, int n11) {
        int n12 = this.c;
        return d0.n(bitmap, n12);
    }

    public boolean equals(Object object) {
        int n10 = object instanceof a0;
        boolean bl2 = false;
        if (n10 != 0) {
            object = (a0)object;
            n10 = this.c;
            int n11 = ((a0)object).c;
            if (n10 == n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = m.n(this.c);
        return m.o(-950519196, n10);
    }
}

