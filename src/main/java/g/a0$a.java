/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.q2.u;
import f.x1.t0;
import g.a0;
import g.b0;
import g.d;
import g.h0.j.f;
import g.s;
import g.s$a;
import g.t;
import g.t$b;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class a0$a {
    private t a;
    private String b;
    private s$a c;
    private b0 d;
    private Map e;

    public a0$a() {
        Object object = new LinkedHashMap();
        this.e = object;
        this.b = "GET";
        this.c = object = new s$a();
    }

    public a0$a(a0 object) {
        f0.p(object, "request");
        Map map = new Map();
        this.e = map;
        map = ((a0)object).q();
        this.a = map;
        map = ((a0)object).m();
        this.b = map;
        map = ((a0)object).f();
        this.d = map;
        map = ((a0)object).h();
        boolean bl2 = map.isEmpty();
        map = bl2 ? new Map() : t0.J0(((a0)object).h());
        this.e = map;
        this.c = object = ((a0)object).k().j();
    }

    public static /* synthetic */ a0$a f(a0$a object, b0 b02, int n10, Object object2) {
        if (object2 == null) {
            if ((n10 &= 1) != 0) {
                b02 = g.h0.d.d;
            }
            return ((a0$a)object).e(b02);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        throw object;
    }

    public a0$a A(Object object) {
        return this.z(Object.class, object);
    }

    public a0$a B(String object) {
        f0.p(object, "url");
        CharSequence charSequence = "ws:";
        int n10 = 1;
        boolean bl2 = u.o2((String)object, (String)charSequence, n10 != 0);
        String string2 = "(this as java.lang.String).substring(startIndex)";
        if (bl2) {
            charSequence = new StringBuilder();
            String string3 = "http:";
            ((StringBuilder)charSequence).append(string3);
            n10 = 3;
            object = ((String)object).substring(n10);
            f0.o(object, string2);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "wss:";
            bl2 = u.o2((String)object, (String)charSequence, n10 != 0);
            if (bl2) {
                charSequence = new StringBuilder();
                String string4 = "https:";
                ((StringBuilder)charSequence).append(string4);
                n10 = 4;
                object = ((String)object).substring(n10);
                f0.o(object, string2);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
            }
        }
        object = t.w.h((String)object);
        return this.D((t)object);
    }

    public a0$a C(URL object) {
        f0.p(object, "url");
        t$b t$b = t.w;
        object = ((URL)object).toString();
        f0.o(object, "url.toString()");
        object = t$b.h((String)object);
        return this.D((t)object);
    }

    public a0$a D(t t10) {
        f0.p(t10, "url");
        this.a = t10;
        return this;
    }

    public a0$a a(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        this.c.b(string2, string3);
        return this;
    }

    public a0 b() {
        Object object = this.a;
        if (object != null) {
            a0 a02;
            String string2 = this.b;
            s s10 = this.c.i();
            b0 b02 = this.d;
            Map map = g.h0.d.d0(this.e);
            a0 a03 = a02;
            a02 = new a0((t)object, string2, s10, b02, map);
            return a02;
        }
        object = "url == null".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public a0$a c(d object) {
        String string2 = "cacheControl";
        f0.p(object, string2);
        object = ((d)object).toString();
        int n10 = object.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        String string3 = "Cache-Control";
        object = n10 != 0 ? this.t(string3) : this.n(string3, (String)object);
        return object;
    }

    public final a0$a d() {
        return a0$a.f(this, null, 1, null);
    }

    public a0$a e(b0 b02) {
        return this.p("DELETE", b02);
    }

    public a0$a g() {
        return this.p("GET", null);
    }

    public final b0 h() {
        return this.d;
    }

    public final s$a i() {
        return this.c;
    }

    public final String j() {
        return this.b;
    }

    public final Map k() {
        return this.e;
    }

    public final t l() {
        return this.a;
    }

    public a0$a m() {
        return this.p("HEAD", null);
    }

    public a0$a n(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        this.c.m(string2, string3);
        return this;
    }

    public a0$a o(s object) {
        f0.p(object, "headers");
        this.c = object = ((s)object).j();
        return this;
    }

    public a0$a p(String object, b0 object2) {
        block7: {
            String string2;
            block10: {
                block9: {
                    int n10;
                    block8: {
                        string2 = "method";
                        f0.p(object, string2);
                        int n11 = object.length();
                        n10 = 1;
                        if (n11 > 0) {
                            n11 = n10;
                        } else {
                            n11 = 0;
                            string2 = null;
                        }
                        if (n11 == 0) break block7;
                        string2 = "method ";
                        if (object2 != null) break block8;
                        int n12 = (int)(f.e((String)object) ? 1 : 0);
                        if ((n10 ^= n12) == 0) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append(string2);
                            ((StringBuilder)object2).append((String)object);
                            ((StringBuilder)object2).append(" must have a request body.");
                            object = ((StringBuilder)object2).toString();
                            object = object.toString();
                            object2 = new IllegalArgumentException((String)object);
                            throw object2;
                        }
                        break block9;
                    }
                    n10 = (int)(f.b((String)object) ? 1 : 0);
                    if (n10 == 0) break block10;
                }
                this.b = object;
                this.d = object2;
                return this;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" must not have a request body.");
            object = ((StringBuilder)object2).toString();
            object = object.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object2 = "method.isEmpty() == true".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public a0$a q(b0 b02) {
        f0.p(b02, "body");
        return this.p("PATCH", b02);
    }

    public a0$a r(b0 b02) {
        f0.p(b02, "body");
        return this.p("POST", b02);
    }

    public a0$a s(b0 b02) {
        f0.p(b02, "body");
        return this.p("PUT", b02);
    }

    public a0$a t(String string2) {
        f0.p(string2, "name");
        this.c.l(string2);
        return this;
    }

    public final void u(b0 b02) {
        this.d = b02;
    }

    public final void v(s$a s$a) {
        f0.p(s$a, "<set-?>");
        this.c = s$a;
    }

    public final void w(String string2) {
        f0.p(string2, "<set-?>");
        this.b = string2;
    }

    public final void x(Map map) {
        f0.p(map, "<set-?>");
        this.e = map;
    }

    public final void y(t t10) {
        this.a = t10;
    }

    public a0$a z(Class clazz, Object object) {
        Map<Class<Object>, Object> map = "type";
        f0.p(clazz, (String)((Object)map));
        if (object == null) {
            object = this.e;
            object.remove(clazz);
        } else {
            map = this.e;
            boolean bl2 = map.isEmpty();
            if (bl2) {
                this.e = map = new Map<Class<Object>, Object>();
            }
            map = this.e;
            object = clazz.cast(object);
            f0.m(object);
            map.put(clazz, object);
        }
        return this;
    }
}

