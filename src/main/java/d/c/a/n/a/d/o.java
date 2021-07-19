/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.SystemClock
 */
package d.c.a.n.a.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy;
import d.c.a.c;
import d.c.a.h;
import d.c.a.i;
import d.c.a.n.a.d.o$a;
import d.c.a.n.a.d.o$b;
import d.c.a.n.a.d.o$c;
import d.c.a.n.a.d.o$d;
import d.c.a.n.a.d.o$e;
import d.c.a.o.k.x.e;
import d.c.a.s.a;
import d.c.a.s.g;
import d.c.a.s.j.p;
import d.c.a.u.k;
import d.c.a.u.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class o {
    public static final d.c.a.o.e q;
    private final d.c.a.n.a.d.i a;
    private final Handler b;
    private final List c;
    public final i d;
    private final e e;
    private boolean f;
    private boolean g;
    private boolean h;
    private h i;
    private o$a j;
    private boolean k;
    private o$a l;
    private Bitmap m;
    private d.c.a.o.i n;
    private o$a o;
    private o$d p;

    static {
        WebpFrameCacheStrategy webpFrameCacheStrategy = WebpFrameCacheStrategy.d;
        q = d.c.a.o.e.g("com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.CacheStrategy", webpFrameCacheStrategy);
    }

    public o(c c10, d.c.a.n.a.d.i i10, int n10, int n11, d.c.a.o.i i11, Bitmap bitmap) {
        e e10 = c10.g();
        i i12 = d.c.a.c.D(c10.i());
        h h10 = d.c.a.n.a.d.o.l(d.c.a.c.D(c10.i()), n10, n11);
        this(e10, i12, i10, null, h10, i11, bitmap);
    }

    public o(e e10, i i10, d.c.a.n.a.d.i i11, Handler handler, h h10, d.c.a.o.i i12, Bitmap bitmap) {
        Object object = new ArrayList();
        this.c = object;
        object = null;
        this.f = false;
        this.g = false;
        this.h = false;
        this.d = i10;
        if (handler == null) {
            i10 = Looper.getMainLooper();
            object = new o$c(this);
            handler = new Handler((Looper)i10, (Handler.Callback)object);
        }
        this.e = e10;
        this.b = handler;
        this.i = h10;
        this.a = i11;
        this.r(i12, bitmap);
    }

    private d.c.a.o.c g(int n10) {
        d.c.a.n.a.d.i i10 = this.a;
        d.c.a.t.e e10 = new d.c.a.t.e(i10);
        o$e o$e = new o$e(e10, n10);
        return o$e;
    }

    private int h() {
        int n10 = this.c().getWidth();
        int n11 = this.c().getHeight();
        Bitmap.Config config = this.c().getConfig();
        return d.c.a.u.m.g(n10, n11, config);
    }

    private static h l(i g10, int n10, int n11) {
        g10 = ((i)g10).u();
        g g11 = d.c.a.s.g.b1(d.c.a.o.k.h.b);
        boolean bl2 = true;
        a a10 = ((g)((g)g11.U0(bl2)).K0(bl2)).z0(n10, n11);
        return ((h)g10).X0(a10);
    }

    private void o() {
        int n10 = this.f;
        if (n10 != 0 && (n10 = this.g) == 0) {
            Object object;
            Object object2;
            n10 = this.h;
            int n11 = 1;
            if (n10 != 0) {
                object2 = this.o;
                if (object2 == null) {
                    n10 = n11;
                } else {
                    n10 = 0;
                    object2 = null;
                }
                object = "Pending target must be null when starting from the first frame";
                d.c.a.u.k.a(n10 != 0, (String)object);
                object2 = this.a;
                ((d.c.a.n.a.d.i)object2).j();
                this.h = false;
            }
            if ((object2 = this.o) != null) {
                this.o = null;
                this.p((o$a)object2);
                return;
            }
            this.g = n11;
            n10 = this.a.i();
            long l10 = SystemClock.uptimeMillis();
            long l11 = n10;
            this.a.b();
            n10 = this.a.l();
            Handler handler = this.b;
            this.l = object = new o$a(handler, n10, l10 += l11);
            Object object3 = this.a.s();
            object2 = d.c.a.s.g.s1(this.g(n10));
            boolean bl2 = ((WebpFrameCacheStrategy)object3).e();
            object2 = (g)((a)object2).K0(bl2);
            object2 = this.i.X0((a)object2);
            object3 = this.a;
            object2 = ((h)object2).u1(object3);
            object3 = this.l;
            ((h)object2).j1((p)object3);
        }
    }

    private void q() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            e e10 = this.e;
            e10.d(bitmap);
            bitmap = null;
            this.m = null;
        }
    }

    private void u() {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        this.f = true;
        this.k = false;
        this.o();
    }

    private void v() {
        this.f = false;
    }

    public void a() {
        i i10;
        this.c.clear();
        this.q();
        this.v();
        o$a o$a = this.j;
        if (o$a != null) {
            i10 = this.d;
            i10.z(o$a);
            this.j = null;
        }
        if ((o$a = this.l) != null) {
            i10 = this.d;
            i10.z(o$a);
            this.l = null;
        }
        if ((o$a = this.o) != null) {
            i10 = this.d;
            i10.z(o$a);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }

    public ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    public Bitmap c() {
        o$a o$a = this.j;
        o$a = o$a != null ? o$a.d() : this.m;
        return o$a;
    }

    public int d() {
        o$a o$a = this.j;
        int n10 = o$a != null ? o$a.e : -1;
        return n10;
    }

    public Bitmap e() {
        return this.m;
    }

    public int f() {
        return this.a.c();
    }

    public d.c.a.o.i i() {
        return this.n;
    }

    public int j() {
        return this.c().getHeight();
    }

    public int k() {
        return this.a.f();
    }

    public int m() {
        int n10 = this.a.o();
        int n11 = this.h();
        return n10 + n11;
    }

    public int n() {
        return this.c().getWidth();
    }

    public void p(o$a object) {
        Object object2 = this.p;
        if (object2 != null) {
            object2.a();
        }
        object2 = null;
        this.g = false;
        boolean bl2 = this.k;
        int n10 = 2;
        if (bl2) {
            this.b.obtainMessage(n10, object).sendToTarget();
            return;
        }
        bl2 = this.f;
        if (!bl2) {
            this.o = object;
            return;
        }
        object2 = ((o$a)object).d();
        if (object2 != null) {
            this.q();
            object2 = this.j;
            this.j = object;
            object = this.c;
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                o$b o$b = (o$b)this.c.get(i10);
                o$b.a();
            }
            if (object2 != null) {
                object = this.b.obtainMessage(n10, object2);
                object.sendToTarget();
            }
        }
        this.o();
    }

    public void r(d.c.a.o.i object, Bitmap object2) {
        Object object3 = (d.c.a.o.i)d.c.a.u.k.d(object);
        this.n = object3;
        object2 = (Bitmap)d.c.a.u.k.d(object2);
        this.m = object2;
        object2 = this.i;
        object3 = new g();
        object = ((a)object3).N0((d.c.a.o.i)object);
        this.i = object = ((h)object2).X0((a)object);
    }

    public void s() {
        boolean bl2 = this.f;
        boolean bl3 = true;
        String string2 = "Can't restart a running animation";
        d.c.a.u.k.a(bl2 ^= bl3, string2);
        this.h = bl3;
        o$a o$a = this.o;
        if (o$a != null) {
            i i10 = this.d;
            i10.z(o$a);
            bl2 = false;
            o$a = null;
            this.o = null;
        }
    }

    public void t(o$d o$d) {
        this.p = o$d;
    }

    public void w(o$b object) {
        boolean bl2 = this.k;
        if (!bl2) {
            List list = this.c;
            bl2 = list.contains(object);
            if (!bl2) {
                list = this.c;
                bl2 = list.isEmpty();
                List list2 = this.c;
                list2.add(object);
                if (bl2) {
                    this.u();
                }
                return;
            }
            object = new IllegalStateException("Cannot subscribe twice in a row");
            throw object;
        }
        object = new IllegalStateException("Cannot subscribe to a cleared frame loader");
        throw object;
    }

    public void x(o$b object) {
        List list = this.c;
        list.remove(object);
        object = this.c;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.v();
        }
    }
}

