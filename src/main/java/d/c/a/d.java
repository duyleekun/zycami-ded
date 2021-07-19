/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.c.a;

import android.content.Context;
import androidx.collection.ArrayMap;
import androidx.core.os.BuildCompat;
import d.c.a.c;
import d.c.a.c$a;
import d.c.a.d$a;
import d.c.a.d$b;
import d.c.a.o.k.x.b;
import d.c.a.o.k.x.e;
import d.c.a.o.k.x.j;
import d.c.a.o.k.y.a$a;
import d.c.a.o.k.y.h;
import d.c.a.o.k.y.i;
import d.c.a.o.k.y.l;
import d.c.a.o.k.y.l$a;
import d.c.a.o.k.z.a;
import d.c.a.p.f;
import d.c.a.p.k$b;
import d.c.a.s.g;
import d.c.a.u.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class d {
    private final Map a;
    private d.c.a.o.k.i b;
    private e c;
    private b d;
    private d.c.a.o.k.y.j e;
    private a f;
    private a g;
    private a$a h;
    private l i;
    private d.c.a.p.d j;
    private int k;
    private c$a l;
    private k$b m;
    private a n;
    private boolean o;
    private List p;
    private boolean q;
    private boolean r;

    public d() {
        Object object = new ArrayMap();
        this.a = object;
        this.k = 4;
        this.l = object = new d$a(this);
    }

    public d a(d.c.a.s.f f10) {
        ArrayList arrayList = this.p;
        if (arrayList == null) {
            this.p = arrayList = new ArrayList();
        }
        this.p.add(f10);
        return this;
    }

    public c b(Context context) {
        c c10;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        d.c.a.o.k.y.j j10;
        int n10;
        Object object5;
        d d10 = this;
        Context context2 = context;
        Object object6 = this.f;
        if (object6 == null) {
            object6 = d.c.a.o.k.z.a.j();
            this.f = object6;
        }
        if ((object6 = d10.g) == null) {
            object6 = d.c.a.o.k.z.a.f();
            d10.g = object6;
        }
        if ((object6 = d10.n) == null) {
            d10.n = object6 = d.c.a.o.k.z.a.c();
        }
        if ((object6 = d10.i) == null) {
            object6 = new l$a(context2);
            d10.i = object6 = ((l$a)object6).a();
        }
        if ((object6 = d10.j) == null) {
            d10.j = object6 = new f();
        }
        if ((object6 = d10.c) == null) {
            object6 = d10.i;
            int n11 = ((l)object6).b();
            if (n11 > 0) {
                long l10 = n11;
                d10.c = object5 = new d.c.a.o.k.x.k(l10);
            } else {
                d10.c = object6 = new d.c.a.o.k.x.f();
            }
        }
        if ((object6 = d10.d) == null) {
            object5 = d10.i;
            n10 = ((l)object5).a();
            d10.d = object6 = new j(n10);
        }
        if ((object6 = d10.e) == null) {
            object5 = d10.i;
            n10 = ((l)object5).d();
            long l11 = n10;
            d10.e = object6 = new i(l11);
        }
        if ((object6 = d10.h) == null) {
            d10.h = object6 = new h(context2);
        }
        if ((object6 = d10.b) == null) {
            j10 = d10.e;
            object4 = d10.h;
            object3 = d10.g;
            object2 = d10.f;
            object = d.c.a.o.k.z.a.m();
            a a10 = d10.n;
            boolean bl2 = d10.o;
            object5 = object6;
            d10.b = object6 = new d.c.a.o.k.i(j10, (a$a)object4, (a)object3, (a)object2, (a)object, a10, bl2);
        }
        if ((object6 = d10.p) == null) {
            object6 = Collections.emptyList();
            d10.p = object6;
        } else {
            object6 = Collections.unmodifiableList(object6);
            d10.p = object6;
        }
        object6 = d10.m;
        object2 = new d.c.a.p.k((k$b)object6);
        object5 = d10.b;
        j10 = d10.e;
        object4 = d10.c;
        object3 = d10.d;
        object = d10.j;
        int n12 = d10.k;
        c$a c$a = d10.l;
        Map map = d10.a;
        List list = d10.p;
        boolean bl3 = d10.q;
        boolean bl4 = d10.r;
        object6 = c10;
        context2 = context;
        c10 = new c(context, (d.c.a.o.k.i)object5, j10, (e)object4, (b)object3, (d.c.a.p.k)object2, (d.c.a.p.d)object, n12, c$a, map, list, bl3, bl4);
        return c10;
    }

    public d c(a a10) {
        this.n = a10;
        return this;
    }

    public d d(b b10) {
        this.d = b10;
        return this;
    }

    public d e(e e10) {
        this.c = e10;
        return this;
    }

    public d f(d.c.a.p.d d10) {
        this.j = d10;
        return this;
    }

    public d g(c$a c$a) {
        this.l = c$a = (c$a)d.c.a.u.k.d(c$a);
        return this;
    }

    public d h(g g10) {
        d$b d$b = new d$b(this, g10);
        return this.g(d$b);
    }

    public d i(Class clazz, d.c.a.j j10) {
        this.a.put(clazz, j10);
        return this;
    }

    public d j(a$a a$a) {
        this.h = a$a;
        return this;
    }

    public d k(a a10) {
        this.g = a10;
        return this;
    }

    public d l(d.c.a.o.k.i i10) {
        this.b = i10;
        return this;
    }

    public d m(boolean bl2) {
        boolean bl3 = BuildCompat.isAtLeastQ();
        if (!bl3) {
            return this;
        }
        this.r = bl2;
        return this;
    }

    public d n(boolean bl2) {
        this.o = bl2;
        return this;
    }

    public d o(int n10) {
        int n11 = 2;
        if (n10 >= n11 && n10 <= (n11 = 6)) {
            this.k = n10;
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        throw illegalArgumentException;
    }

    public d p(boolean bl2) {
        this.q = bl2;
        return this;
    }

    public d q(d.c.a.o.k.y.j j10) {
        this.e = j10;
        return this;
    }

    public d r(l$a object) {
        object = ((l$a)object).a();
        return this.s((l)object);
    }

    public d s(l l10) {
        this.i = l10;
        return this;
    }

    public void t(k$b k$b) {
        this.m = k$b;
    }

    public d u(a a10) {
        return this.v(a10);
    }

    public d v(a a10) {
        this.f = a10;
        return this;
    }
}

