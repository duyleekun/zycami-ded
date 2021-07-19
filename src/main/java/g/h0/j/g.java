/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import g.a0;
import g.c0;
import g.e;
import g.h0.d;
import g.h0.i.c;
import g.i;
import g.t;
import g.u;
import g.u$a;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class g
implements u$a {
    private int a;
    private final g.h0.i.e b;
    private final List c;
    private final int d;
    private final c e;
    private final a0 f;
    private final int g;
    private final int h;
    private final int i;

    public g(g.h0.i.e e10, List list, int n10, c c10, a0 a02, int n11, int n12, int n13) {
        f0.p(e10, "call");
        f0.p(list, "interceptors");
        f0.p(a02, "request");
        this.b = e10;
        this.c = list;
        this.d = n10;
        this.e = c10;
        this.f = a02;
        this.g = n11;
        this.h = n12;
        this.i = n13;
    }

    public static /* synthetic */ g j(g g10, int n10, c object, a0 a02, int n11, int n12, int n13, int n14, Object object2) {
        int n15 = n14 & 1;
        if (n15 != 0) {
            n10 = g10.d;
        }
        if ((n15 = n14 & 2) != 0) {
            object = g10.e;
        }
        object2 = object;
        int n16 = n14 & 4;
        if (n16 != 0) {
            a02 = g10.f;
        }
        a0 a03 = a02;
        n16 = n14 & 8;
        if (n16 != 0) {
            n11 = g10.g;
        }
        int n17 = n11;
        n16 = n14 & 0x10;
        if (n16 != 0) {
            n12 = g10.h;
        }
        int n18 = n12;
        n16 = n14 & 0x20;
        if (n16 != 0) {
            n13 = g10.i;
        }
        int n19 = n13;
        object = g10;
        n13 = n17;
        n14 = n18;
        n15 = n19;
        return g10.i(n10, (c)object2, a03, n17, n18, n19);
    }

    public a0 C() {
        return this.f;
    }

    public int a() {
        return this.h;
    }

    public u$a b(int n10, TimeUnit object) {
        boolean bl2;
        f0.p(object, "unit");
        c c10 = this.e;
        if (c10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        if (bl2) {
            long l10 = n10;
            int n11 = g.h0.d.j("connectTimeout", l10, object);
            return g.h0.j.g.j(this, 0, null, null, n11, 0, 0, 55, null);
        }
        object = "Timeouts can't be adjusted in a network interceptor".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public c0 c(a0 object) {
        Object object2 = "request";
        f0.p(object, (String)object2);
        int n10 = this.d;
        Object object3 = this.c;
        int n11 = object3.size();
        int n12 = 0;
        int n13 = 1;
        if (n10 < n11) {
            n10 = n13;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            Object object4;
            this.a = n10 = this.a + n13;
            object2 = this.e;
            object3 = " must call proceed() exactly once";
            String string2 = "network interceptor ";
            if (object2 != null) {
                n10 = (int)(((g.h0.i.d)(object2 = ((c)object2).j())).g((t)(object4 = ((a0)object).q())) ? 1 : 0);
                if (n10 != 0) {
                    n10 = this.a;
                    if (n10 == n13) {
                        n10 = n13;
                    } else {
                        n10 = 0;
                        object2 = null;
                    }
                    if (n10 == 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string2);
                        object2 = this.c;
                        n12 = this.d - n13;
                        object2 = (u)object2.get(n12);
                        ((StringBuilder)object).append(object2);
                        ((StringBuilder)object).append((String)object3);
                        object = ((StringBuilder)object).toString();
                        object = object.toString();
                        object2 = new IllegalStateException((String)object);
                        throw object2;
                    }
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    object2 = this.c;
                    n11 = this.d - n13;
                    object2 = (u)object2.get(n11);
                    ((StringBuilder)object).append(object2);
                    ((StringBuilder)object).append(" must retain the same host and port");
                    object = ((StringBuilder)object).toString();
                    object = object.toString();
                    object2 = new IllegalStateException((String)object);
                    throw object2;
                }
            }
            n10 = this.d;
            int n14 = n10 + 1;
            int n15 = 0;
            c c10 = null;
            int n16 = 58;
            object4 = this;
            Object object5 = object;
            object = g.h0.j.g.j(this, n14, null, (a0)object, 0, 0, 0, n16, null);
            object2 = this.c;
            int n17 = this.d;
            object2 = (u)object2.get(n17);
            object4 = object2.intercept((u$a)object);
            String string3 = "interceptor ";
            if (object4 != null) {
                c10 = this.e;
                if (c10 != null) {
                    int n18;
                    n15 = this.d + n13;
                    object5 = this.c;
                    int n19 = object5.size();
                    if (n15 < n19 && (n18 = ((g)object).a) != n13) {
                        n18 = 0;
                        object = null;
                    } else {
                        n18 = n13;
                    }
                    if (n18 == 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(object2);
                        ((StringBuilder)object).append((String)object3);
                        object = ((StringBuilder)object).toString();
                        object = object.toString();
                        object2 = new IllegalStateException((String)object);
                        throw object2;
                    }
                }
                if ((object = ((c0)object4).r0()) != null) {
                    n12 = n13;
                }
                if (n12 != 0) {
                    return object4;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(object2);
                ((StringBuilder)object).append(" returned a response with no body");
                object = ((StringBuilder)object).toString();
                object = object.toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append(object2);
            ((StringBuilder)object3).append(" returned null");
            object2 = ((StringBuilder)object3).toString();
            object = new NullPointerException((String)object2);
            throw object;
        }
        object2 = "Check failed.".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public e call() {
        return this.b;
    }

    public u$a d(int n10, TimeUnit object) {
        boolean bl2;
        f0.p(object, "unit");
        c c10 = this.e;
        if (c10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        if (bl2) {
            long l10 = n10;
            int n11 = g.h0.d.j("writeTimeout", l10, object);
            return g.h0.j.g.j(this, 0, null, null, 0, 0, n11, 31, null);
        }
        object = "Timeouts can't be adjusted in a network interceptor".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public int e() {
        return this.i;
    }

    public i f() {
        Object object = this.e;
        object = object != null ? ((c)object).h() : null;
        return object;
    }

    public u$a g(int n10, TimeUnit object) {
        boolean bl2;
        f0.p(object, "unit");
        c c10 = this.e;
        if (c10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        if (bl2) {
            long l10 = n10;
            int n11 = g.h0.d.j("readTimeout", l10, object);
            return g.h0.j.g.j(this, 0, null, null, 0, n11, 0, 47, null);
        }
        object = "Timeouts can't be adjusted in a network interceptor".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public int h() {
        return this.g;
    }

    public final g i(int n10, c c10, a0 a02, int n11, int n12, int n13) {
        f0.p(a02, "request");
        g.h0.i.e e10 = this.b;
        List list = this.c;
        g g10 = new g(e10, list, n10, c10, a02, n11, n12, n13);
        return g10;
    }

    public final g.h0.i.e k() {
        return this.b;
    }

    public final int l() {
        return this.g;
    }

    public final c m() {
        return this.e;
    }

    public final int n() {
        return this.h;
    }

    public final a0 o() {
        return this.f;
    }

    public final int p() {
        return this.i;
    }
}

