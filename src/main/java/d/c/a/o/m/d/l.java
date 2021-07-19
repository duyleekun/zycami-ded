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

public class l
extends h {
    private static final String c = "com.bumptech.glide.load.resource.bitmap.CenterCrop";
    private static final byte[] d;

    static {
        Charset charset = d.c.a.o.c.b;
        d = c.getBytes(charset);
    }

    public void b(MessageDigest messageDigest) {
        byte[] byArray = d;
        messageDigest.update(byArray);
    }

    public Bitmap c(e e10, Bitmap bitmap, int n10, int n11) {
        return d0.b(e10, bitmap, n10, n11);
    }

    public boolean equals(Object object) {
        return object instanceof l;
    }

    public int hashCode() {
        return -599754482;
    }
}

