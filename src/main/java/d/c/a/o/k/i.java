/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.k;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import d.c.a.e;
import d.c.a.o.c;
import d.c.a.o.f;
import d.c.a.o.k.h;
import d.c.a.o.k.i$a;
import d.c.a.o.k.i$b;
import d.c.a.o.k.i$c;
import d.c.a.o.k.i$d;
import d.c.a.o.k.j;
import d.c.a.o.k.k;
import d.c.a.o.k.l;
import d.c.a.o.k.m;
import d.c.a.o.k.n;
import d.c.a.o.k.n$a;
import d.c.a.o.k.p;
import d.c.a.o.k.s;
import d.c.a.o.k.v;
import d.c.a.o.k.y.a$a;
import d.c.a.o.k.y.j$a;
import d.c.a.o.k.z.a;
import d.c.a.u.g;
import java.util.Map;
import java.util.concurrent.Executor;

public class i
implements k,
j$a,
n$a {
    private static final String i = "Engine";
    private static final int j = 150;
    private static final boolean k = Log.isLoggable((String)"Engine", (int)2);
    private final p a;
    private final m b;
    private final d.c.a.o.k.y.j c;
    private final i$b d;
    private final v e;
    private final i$c f;
    private final i$a g;
    private final d.c.a.o.k.a h;

    public i(d.c.a.o.k.y.j j10, a$a a$a, a a10, a a11, a a12, a a13, p p10, m m10, d.c.a.o.k.a a14, i$b i$b, i$a i$a, v v10, boolean bl2) {
        i$b i$b2;
        i$c i$c;
        i i10 = this;
        this.c = j10;
        Object object = a$a;
        this.f = i$c = new i$c(a$a);
        object = a14 == null ? new d.c.a.o.k.a(bl2) : a14;
        i10.h = object;
        ((d.c.a.o.k.a)object).g(this);
        object = m10 == null ? new m() : m10;
        i10.b = object;
        object = p10 == null ? new p() : p10;
        i10.a = object;
        if (i$b == null) {
            object = i$b2;
            i$b2 = new i$b(a10, a11, a12, a13, this, this);
        } else {
            i$b2 = i$b;
        }
        i10.d = i$b2;
        object = i$a == null ? new i$a(i$c) : i$a;
        i10.g = object;
        object = v10 == null ? new v() : v10;
        i10.e = object;
        j10.g(this);
    }

    public i(d.c.a.o.k.y.j j10, a$a a$a, a a10, a a11, a a12, a a13, boolean bl2) {
        this(j10, a$a, a10, a11, a12, a13, null, null, null, null, null, null, bl2);
    }

    private n f(c object) {
        Object object2 = this.c;
        s s10 = object2.f((c)object);
        if (s10 == null) {
            object = null;
        } else {
            boolean bl2 = s10 instanceof n;
            if (bl2) {
                object = s10;
                object = (n)s10;
            } else {
                boolean bl3 = true;
                boolean bl4 = true;
                object = object2 = new n(s10, bl3, bl4, (c)object, this);
            }
        }
        return object;
    }

    private n h(c object) {
        d.c.a.o.k.a a10 = this.h;
        if ((object = a10.e((c)object)) != null) {
            ((n)object).a();
        }
        return object;
    }

    private n i(c c10) {
        n n10 = this.f(c10);
        if (n10 != null) {
            n10.a();
            d.c.a.o.k.a a10 = this.h;
            a10.a(c10, n10);
        }
        return n10;
    }

    private n j(l l10, boolean bl2, long l11) {
        boolean bl3 = false;
        String string2 = null;
        if (!bl2) {
            return null;
        }
        n n10 = this.h(l10);
        if (n10 != null) {
            bl3 = k;
            if (bl3) {
                string2 = "Loaded resource from active resources";
                d.c.a.o.k.i.k(string2, l11, l10);
            }
            return n10;
        }
        n10 = this.i(l10);
        if (n10 != null) {
            bl3 = k;
            if (bl3) {
                string2 = "Loaded resource from cache";
                d.c.a.o.k.i.k(string2, l11, l10);
            }
            return n10;
        }
        return null;
    }

    private static void k(String string2, long l10, c c10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" in ");
        double d10 = d.c.a.u.g.a(l10);
        stringBuilder.append(d10);
        stringBuilder.append("ms, key: ");
        stringBuilder.append(c10);
        string2 = stringBuilder.toString();
        Log.v((String)i, (String)string2);
    }

    private i$d n(e e10, Object object, c c10, int n10, int n11, Class clazz, Class clazz2, Priority priority, h h10, Map map, boolean bl2, boolean bl3, f f10, boolean bl4, boolean bl5, boolean bl6, boolean bl7, d.c.a.s.h h11, Executor executor, l l10, long l11) {
        i i10 = this;
        Object object2 = h11;
        Object object3 = executor;
        Object object4 = this.a.a(l10, bl7);
        if (object4 != null) {
            ((j)object4).a(h11, executor);
            boolean bl8 = k;
            if (bl8) {
                object3 = "Added to existing load";
                d.c.a.o.k.i.k((String)object3, l11, l10);
            }
            object3 = new i$d(i10, (d.c.a.s.h)object2, (j)object4);
            return object3;
        }
        object4 = this.d;
        Object object5 = ((i$b)object4).a(l10, bl4, bl5, bl6, bl7);
        j j10 = object5;
        object4 = this.g;
        Object object6 = object;
        object2 = object5;
        object5 = clazz2;
        object3 = l10;
        object4 = ((i$a)object4).a(e10, object, l10, c10, n10, n11, clazz, clazz2, priority, h10, map, bl2, bl3, bl7, f10, j10);
        this.a.d(l10, j10);
        object6 = j10;
        object2 = h11;
        object3 = executor;
        j10.a(h11, executor);
        j10.t((DecodeJob)object4);
        boolean bl9 = k;
        if (bl9) {
            object3 = "Started new load";
            d.c.a.o.k.i.k((String)object3, l11, l10);
        }
        object3 = new i$d(i10, (d.c.a.s.h)object2, (j)object6);
        return object3;
    }

    public void a(s s10) {
        this.e.a(s10, true);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(j j10, c c10, n object) {
        synchronized (this) {
            void var2_2;
            boolean bl2;
            p p10;
            if (p10 != null && (bl2 = ((n)((Object)p10)).d())) {
                d.c.a.o.k.a a10 = this.h;
                a10.a((c)var2_2, (n)((Object)p10));
            }
            p10 = this.a;
            p10.e((c)var2_2, j10);
            return;
        }
    }

    public void c(j j10, c c10) {
        synchronized (this) {
            p p10 = this.a;
            p10.e(c10, j10);
            return;
        }
    }

    public void d(c object, n n10) {
        Object object2 = this.h;
        ((d.c.a.o.k.a)object2).d((c)object);
        boolean bl2 = n10.d();
        if (bl2) {
            object2 = this.c;
            object2.d((c)object, n10);
        } else {
            object = this.e;
            bl2 = false;
            object2 = null;
            ((v)object).a(n10, false);
        }
    }

    public void e() {
        this.f.a().clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public i$d g(e e10, Object object, c c10, int n10, int n11, Class clazz, Class clazz2, Priority priority, h h10, Map map, boolean bl2, boolean bl3, f f10, boolean bl4, boolean bl5, boolean bl6, boolean bl7, d.c.a.s.h h11, Executor executor) {
        i i10 = this;
        boolean bl8 = k;
        long l10 = bl8 ? d.c.a.u.g.b() : 0L;
        Object object2 = i10.b;
        Object object3 = object;
        object2 = ((m)object2).a(object, c10, n10, n11, map, clazz, clazz2, f10);
        synchronized (this) {
            object3 = i10.j((l)object2, bl4, l10);
            if (object3 == null) {
                object3 = this;
                return this.n(e10, object, c10, n10, n11, clazz, clazz2, priority, h10, map, bl2, bl3, f10, bl4, bl5, bl6, bl7, h11, executor, (l)object2, l10);
            }
        }
        object2 = DataSource.MEMORY_CACHE;
        h11.c((s)object3, (DataSource)((Object)object2));
        return null;
    }

    public void l(s object) {
        boolean bl2 = object instanceof n;
        if (bl2) {
            ((n)object).e();
            return;
        }
        object = new IllegalArgumentException("Cannot release anything but an EngineResource");
        throw object;
    }

    public void m() {
        this.d.b();
        this.f.b();
        this.h.h();
    }
}

