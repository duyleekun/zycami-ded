/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$a;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$b;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$c;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$d;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$e;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$f;
import d.c.a.o.e;

public abstract class DownsampleStrategy {
    public static final DownsampleStrategy a;
    public static final DownsampleStrategy b;
    public static final DownsampleStrategy c;
    public static final DownsampleStrategy d;
    public static final DownsampleStrategy e;
    public static final DownsampleStrategy f;
    public static final DownsampleStrategy g;
    public static final e h;
    public static final boolean i;

    static {
        Object object = new DownsampleStrategy$a();
        a = object;
        object = new DownsampleStrategy$b();
        b = object;
        object = new DownsampleStrategy$e();
        c = object;
        object = new DownsampleStrategy$c();
        d = object;
        object = new DownsampleStrategy$d();
        e = object;
        Object object2 = new DownsampleStrategy$f();
        f = object2;
        g = object;
        object2 = "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy";
        h = object = d.c.a.o.e.g((String)object2, object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        i = n10;
    }

    public abstract DownsampleStrategy$SampleSizeRounding a(int var1, int var2, int var3, int var4);

    public abstract float b(int var1, int var2, int var3, int var4);
}

