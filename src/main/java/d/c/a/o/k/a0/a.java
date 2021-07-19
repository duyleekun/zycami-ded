/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 */
package d.c.a.o.k.a0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import d.c.a.o.k.a0.a$a;
import d.c.a.o.k.a0.a$b;
import d.c.a.o.k.a0.c;
import d.c.a.o.k.a0.d;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.k.y.j;
import d.c.a.o.m.d.g;
import d.c.a.u.m;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class a
implements Runnable {
    public static final String i = "PreFillRunner";
    private static final a$a j;
    public static final long k = 32L;
    public static final long l = 40L;
    public static final int m = 4;
    public static final long n;
    private final e a;
    private final j b;
    private final c c;
    private final a$a d;
    private final Set e;
    private final Handler f;
    private long g;
    private boolean h;

    static {
        a$a a$a;
        j = a$a = new a$a();
        n = TimeUnit.SECONDS.toMillis(1L);
    }

    public a(e e10, j j10, c c10) {
        a$a a$a = j;
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = this;
        this(e10, j10, c10, a$a, handler);
    }

    public a(e e10, j j10, c c10, a$a a$a, Handler handler) {
        HashSet hashSet;
        this.e = hashSet = new HashSet();
        this.g = 40;
        this.a = e10;
        this.b = j10;
        this.c = c10;
        this.d = a$a;
        this.f = handler;
    }

    private long c() {
        long l10 = this.b.e();
        long l11 = this.b.getCurrentSize();
        return l10 - l11;
    }

    private long d() {
        long l10 = this.g;
        long l11 = (long)4 * l10;
        long l12 = n;
        this.g = l11 = Math.min(l11, l12);
        return l10;
    }

    private boolean e(long l10) {
        a$a a$a = this.d;
        long l11 = a$a.a() - l10;
        long l12 = l11 - (l10 = (long)32);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean a() {
        Object object;
        boolean bl2;
        Object object2 = this.d;
        long l10 = ((a$a)object2).a();
        while (!(bl2 = ((c)(object = this.c)).b()) && !(bl2 = this.e(l10))) {
            Object object3;
            Object object4;
            int n10;
            int n11;
            Object object5 = this.e;
            object = this.c.c();
            int n12 = object5.contains(object);
            if (n12 == 0) {
                this.e.add(object);
                object5 = this.a;
                n11 = ((d)object).d();
                n10 = ((d)object).b();
                object4 = ((d)object).a();
                object5 = object5.g(n11, n10, (Bitmap.Config)object4);
            } else {
                n12 = ((d)object).d();
                n11 = ((d)object).b();
                object3 = ((d)object).a();
                object5 = Bitmap.createBitmap((int)n12, (int)n11, (Bitmap.Config)object3);
            }
            n11 = d.c.a.u.m.h((Bitmap)object5);
            long l11 = this.c();
            long l12 = n11;
            n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
            if (n10 >= 0) {
                object3 = new a$b();
                object4 = this.b;
                e e10 = this.a;
                object5 = d.c.a.o.m.d.g.d((Bitmap)object5, e10);
                object4.d((d.c.a.o.c)object3, (s)object5);
            } else {
                object3 = this.a;
                object3.d((Bitmap)object5);
            }
            if ((n12 = (int)(Log.isLoggable((String)(object3 = i), (int)3) ? 1 : 0)) == 0) continue;
            object5 = new StringBuilder();
            ((StringBuilder)object5).append("allocated [");
            int n13 = ((d)object).d();
            ((StringBuilder)object5).append(n13);
            ((StringBuilder)object5).append("x");
            n13 = ((d)object).b();
            ((StringBuilder)object5).append(n13);
            object4 = "] ";
            ((StringBuilder)object5).append((String)object4);
            object = ((d)object).a();
            ((StringBuilder)object5).append(object);
            ((StringBuilder)object5).append(" size: ");
            ((StringBuilder)object5).append(n11);
            object = ((StringBuilder)object5).toString();
            Log.d((String)object3, (String)object);
        }
        boolean bl3 = this.h;
        if (!bl3 && !(bl3 = ((c)(object2 = this.c)).b())) {
            bl3 = true;
        } else {
            bl3 = false;
            object2 = null;
        }
        return bl3;
    }

    public void b() {
        this.h = true;
    }

    public void run() {
        boolean bl2 = this.a();
        if (bl2) {
            Handler handler = this.f;
            long l10 = this.d();
            handler.postDelayed((Runnable)this, l10);
        }
    }
}

