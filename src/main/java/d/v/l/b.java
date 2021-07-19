/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  d.v.l.d
 */
package d.v.l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import d.c.a.o.c;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.h;
import d.v.l.d;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class b
extends h {
    private static final int e = 1;
    private static final String f = "BlurTransformation.1";
    private static int g = 25;
    private static int h = 1;
    private int c;
    private int d;

    public b() {
        int n10 = g;
        int n11 = h;
        this(n10, n11);
    }

    public b(int n10) {
        int n11 = h;
        this(n10, n11);
    }

    public b(int n10, int n11) {
        this.c = n10;
        this.d = n11;
    }

    public void b(MessageDigest messageDigest) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(f);
        int n10 = this.c;
        ((StringBuilder)object).append(n10);
        n10 = this.d;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Charset charset = d.c.a.o.c.b;
        object = ((String)object).getBytes(charset);
        messageDigest.update((byte[])object);
    }

    public Bitmap c(e e10, Bitmap bitmap, int n10, int n11) {
        n10 = bitmap.getWidth();
        n11 = bitmap.getHeight();
        int n12 = this.d;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        e10 = e10.f(n10 /= n12, n11 /= n12, config);
        Canvas canvas = new Canvas((Bitmap)e10);
        n11 = this.d;
        float f10 = n11;
        float f11 = 1.0f;
        f10 = f11 / f10;
        float f12 = n11;
        canvas.scale(f10, f11 /= f12);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        int n13 = this.c;
        return d.v.l.d.a((Bitmap)e10, (int)n13, (boolean)true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        int n10 = object instanceof b;
        if (n10 == 0) return 0 != 0;
        object = (b)object;
        n10 = ((b)object).c;
        int n11 = this.c;
        if (n10 != n11) return 0 != 0;
        int n12 = ((b)object).d;
        n10 = this.d;
        if (n12 != n10) return 0 != 0;
        return 1 != 0;
    }

    public int hashCode() {
        int n10 = this.c * 1000;
        int n11 = 589067571 + n10;
        n10 = this.d * 10;
        return n11 + n10;
    }
}

