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
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class n
extends h {
    private static final int c = 1;
    private static final String d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] e;

    static {
        Charset charset = d.c.a.o.c.b;
        e = d.getBytes(charset);
    }

    public void b(MessageDigest messageDigest) {
        byte[] byArray = e;
        messageDigest.update(byArray);
    }

    public Bitmap c(e e10, Bitmap bitmap, int n10, int n11) {
        return d0.d(e10, bitmap, n10, n11);
    }

    public boolean equals(Object object) {
        return object instanceof n;
    }

    public int hashCode() {
        return 1101716364;
    }
}

