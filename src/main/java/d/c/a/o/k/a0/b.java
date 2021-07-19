/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.os.Looper
 */
package d.c.a.o.k.a0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import d.c.a.o.k.a0.a;
import d.c.a.o.k.a0.c;
import d.c.a.o.k.a0.d;
import d.c.a.o.k.a0.d$a;
import d.c.a.o.k.x.e;
import d.c.a.o.k.y.j;
import d.c.a.u.m;
import java.util.HashMap;

public final class b {
    private final j a;
    private final e b;
    private final DecodeFormat c;
    private final Handler d;
    private a e;

    public b(j j10, e e10, DecodeFormat decodeFormat) {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.d = handler = new Handler(looper);
        this.a = j10;
        this.b = e10;
        this.c = decodeFormat;
    }

    private static int b(d d10) {
        int n10 = d10.d();
        int n11 = d10.b();
        d10 = d10.a();
        return m.g(n10, n11, (Bitmap.Config)d10);
    }

    public c a(d ... object) {
        int n10;
        j j10 = this.a;
        long l10 = j10.e();
        long l11 = this.a.getCurrentSize();
        l10 -= l11;
        e e10 = this.b;
        l11 = e10.e();
        l10 += l11;
        int n11 = ((d[])object).length;
        int n12 = 0;
        d d10 = null;
        int n13 = 0;
        Integer n14 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < n11; ++i10) {
            d d11 = object[i10];
            n10 = d11.c();
            n13 += n10;
        }
        float f11 = l10;
        float f12 = n13;
        f11 /= f12;
        HashMap<d, Integer> hashMap = new HashMap<d, Integer>();
        n11 = ((d[])object).length;
        while (n12 < n11) {
            d10 = object[n12];
            f10 = (float)d10.c() * f11;
            n13 = Math.round(f10);
            n10 = d.c.a.o.k.a0.b.b(d10);
            n14 = n13 /= n10;
            hashMap.put(d10, n14);
            ++n12;
        }
        object = new c(hashMap);
        return object;
    }

    public void c(d$a ... object) {
        Object object2;
        int n10;
        Object object3 = this.e;
        if (object3 != null) {
            object3.b();
        }
        int n11 = ((d$a[])object).length;
        object3 = new d[n11];
        e e10 = null;
        for (int i10 = 0; i10 < (n10 = ((d$a[])object).length); ++i10) {
            object2 = object[i10];
            Object object4 = ((d$a)object2).b();
            if (object4 == null) {
                object4 = this.c;
                DecodeFormat decodeFormat = DecodeFormat.PREFER_ARGB_8888;
                object4 = object4 == decodeFormat ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                ((d$a)object2).c((Bitmap.Config)object4);
            }
            object3[i10] = object2 = ((d$a)object2).a();
        }
        object = this.a((d)object3);
        e10 = this.b;
        object2 = this.a;
        this.e = object3 = new a(e10, (j)object2, (c)object);
        this.d.post((Runnable)object3);
    }
}

