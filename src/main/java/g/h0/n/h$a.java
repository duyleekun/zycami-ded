/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n;

import f.h2.t.f0;
import f.x1.u;
import g.h0.n.a;
import g.h0.n.b;
import g.h0.n.c;
import g.h0.n.d;
import g.h0.n.e;
import g.h0.n.f;
import g.h0.n.g;
import g.h0.n.h;
import h.m;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Protocol;

public final class h$a {
    private h$a() {
    }

    public /* synthetic */ h$a(f.h2.t.u u10) {
        this();
    }

    public static final /* synthetic */ h a(h$a h$a) {
        return h$a.f();
    }

    private final h d() {
        g.h0.n.i.c.d.b();
        h h10 = a.h.a();
        if (h10 == null) {
            h10 = b.i.a();
            f0.m(h10);
        }
        return h10;
    }

    private final h e() {
        h h10;
        boolean bl2 = this.j();
        if (bl2 && (h10 = d.h.c()) != null) {
            return h10;
        }
        bl2 = this.i();
        if (bl2 && (h10 = c.h.a()) != null) {
            return h10;
        }
        bl2 = this.k();
        if (bl2 && (h10 = g.h.a()) != null) {
            return h10;
        }
        h10 = f.g.a();
        if (h10 != null) {
            return h10;
        }
        h10 = e.k.a();
        if (h10 != null) {
            return h10;
        }
        h10 = new h();
        return h10;
    }

    private final h f() {
        boolean bl2 = this.h();
        h h10 = bl2 ? this.d() : this.e();
        return h10;
    }

    private final boolean i() {
        Object object = Security.getProviders()[0];
        f0.o(object, "Security.getProviders()[0]");
        object = ((Provider)object).getName();
        return f0.g("BC", object);
    }

    private final boolean j() {
        Object object = Security.getProviders()[0];
        f0.o(object, "Security.getProviders()[0]");
        object = ((Provider)object).getName();
        return f0.g("Conscrypt", object);
    }

    private final boolean k() {
        Object object = Security.getProviders()[0];
        f0.o(object, "Security.getProviders()[0]");
        object = ((Provider)object).getName();
        return f0.g("OpenJSSE", object);
    }

    public static /* synthetic */ void m(h$a h$a, h h10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            h10 = h$a.f();
        }
        h$a.l(h10);
    }

    public final List b(List arrayList) {
        Object object;
        int n10;
        f0.p(arrayList, "protocols");
        Object object2 = new ArrayList();
        arrayList = arrayList.iterator();
        while ((n10 = arrayList.hasNext()) != 0) {
            boolean bl2;
            Object object3 = object = arrayList.next();
            object3 = (Protocol)((Object)object);
            Protocol protocol = Protocol.HTTP_1_0;
            if (object3 != protocol) {
                bl2 = true;
            } else {
                bl2 = false;
                object3 = null;
            }
            if (!bl2) continue;
            object2.add(object);
        }
        n10 = u.Y(object2, 10);
        arrayList = new ArrayList(n10);
        object2 = object2.iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object = ((Protocol)((Object)object2.next())).toString();
            arrayList.add(object);
        }
        return arrayList;
    }

    public final byte[] c(List object) {
        boolean bl2;
        f0.p(object, "protocols");
        m m10 = new m();
        object = this.b((List)object).iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            int n10 = string2.length();
            m10.b1(n10);
            m10.p1(string2);
        }
        return m10.T();
    }

    public final h g() {
        return h.a();
    }

    public final boolean h() {
        String string2 = System.getProperty("java.vm.name");
        return f0.g("Dalvik", string2);
    }

    public final void l(h h10) {
        f0.p(h10, "platform");
        h.b(h10);
    }
}

