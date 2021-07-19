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

public final class t
extends h {
    private static final String g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";
    private static final byte[] h;
    private final float c;
    private final float d;
    private final float e;
    private final float f;

    static {
        Charset charset = d.c.a.o.c.b;
        h = g.getBytes(charset);
    }

    public t(float f10, float f11, float f12, float f13) {
        this.c = f10;
        this.d = f11;
        this.e = f12;
        this.f = f13;
    }

    public void b(MessageDigest messageDigest) {
        Object object = h;
        messageDigest.update((byte[])object);
        object = ByteBuffer.allocate(16);
        float f10 = this.c;
        object = object.putFloat(f10);
        f10 = this.d;
        object = object.putFloat(f10);
        f10 = this.e;
        object = object.putFloat(f10);
        f10 = this.f;
        object = object.putFloat(f10).array();
        messageDigest.update((byte[])object);
    }

    public Bitmap c(e e10, Bitmap bitmap, int n10, int n11) {
        float f10 = this.c;
        float f11 = this.d;
        float f12 = this.e;
        float f13 = this.f;
        return d0.p(e10, bitmap, f10, f11, f12, f13);
    }

    public boolean equals(Object object) {
        Object object2 = object instanceof t;
        boolean bl2 = false;
        if (object2) {
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            object = (t)object;
            float f15 = this.c;
            float f16 = ((t)object).c;
            float f17 = f15 - f16;
            object2 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
            if (!(object2 || (object2 = (f14 = (f15 = this.d) - (f16 = ((t)object).d)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) || (object2 = (f13 = (f15 = this.e) - (f16 = ((t)object).e)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) || (f12 = (f11 = (f15 = this.f) - (f10 = ((t)object).f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = m.l(this.c);
        n10 = m.o(-2013597734, n10);
        n10 = m.m(this.d, n10);
        n10 = m.m(this.e, n10);
        return m.m(this.f, n10);
    }
}

