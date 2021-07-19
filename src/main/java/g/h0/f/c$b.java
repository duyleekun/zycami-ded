/*
 * Decompiled with CFR 0.151.
 */
package g.h0.f;

import f.h2.t.f0;
import f.q2.u;
import g.a0;
import g.a0$a;
import g.c0;
import g.c0$a;
import g.d;
import g.h0.f.c;
import g.h0.f.c$a;
import g.s;
import g.s$a;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class c$b {
    private Date a;
    private String b;
    private Date c;
    private String d;
    private Date e;
    private long f;
    private long g;
    private String h;
    private int i;
    private final long j;
    private final a0 k;
    private final c0 l;

    public c$b(long l10, a0 a02, c0 c02) {
        int n10;
        Object object = "request";
        f0.p(a02, (String)object);
        this.j = l10;
        this.k = a02;
        this.l = c02;
        this.i = n10 = -1;
        if (c02 != null) {
            long l11;
            this.f = l11 = c02.M0();
            this.g = l11 = c02.K0();
            s s10 = c02.C0();
            a02 = null;
            int n11 = s10.size();
            for (int i10 = 0; i10 < n11; ++i10) {
                object = s10.h(i10);
                String string2 = s10.n(i10);
                String string3 = "Date";
                boolean bl2 = true;
                boolean bl3 = u.I1((String)object, string3, bl2);
                if (bl3) {
                    this.a = object = g.h0.j.c.a(string2);
                    this.b = string2;
                    continue;
                }
                string3 = "Expires";
                bl3 = u.I1((String)object, string3, bl2);
                if (bl3) {
                    this.e = object = g.h0.j.c.a(string2);
                    continue;
                }
                string3 = "Last-Modified";
                bl3 = u.I1((String)object, string3, bl2);
                if (bl3) {
                    this.c = object = g.h0.j.c.a(string2);
                    this.d = string2;
                    continue;
                }
                string3 = "ETag";
                bl3 = u.I1((String)object, string3, bl2);
                if (bl3) {
                    this.h = string2;
                    continue;
                }
                string3 = "Age";
                int n12 = u.I1((String)object, string3, bl2);
                if (n12 == 0) continue;
                this.i = n12 = g.h0.d.f0(string2, n10);
            }
        }
    }

    private final long a() {
        int n10;
        int n11;
        long l10;
        long l11;
        Date date = this.a;
        long l12 = 0L;
        if (date != null) {
            l11 = this.g;
            l10 = date.getTime();
            l12 = Math.max(l12, l11 -= l10);
        }
        if ((n11 = this.i) != (n10 = -1)) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long l13 = n11;
            l11 = timeUnit.toMillis(l13);
            l12 = Math.max(l12, l11);
        }
        l11 = this.g;
        l10 = this.f;
        l10 = l11 - l10;
        long l14 = this.j - l11;
        return l12 + l10 + l14;
    }

    private final c c() {
        Object object;
        Object object2;
        block13: {
            block17: {
                Object object3;
                block15: {
                    block16: {
                        block14: {
                            long l10;
                            long l11;
                            boolean bl2;
                            long l12;
                            long l13;
                            TimeUnit timeUnit;
                            int n10;
                            boolean bl3;
                            object2 = this.l;
                            object3 = null;
                            if (object2 == null) {
                                a0 a02 = this.k;
                                object2 = new c(a02, null);
                                return object2;
                            }
                            object2 = this.k;
                            boolean n11 = ((a0)object2).l();
                            if (n11 && (object2 = this.l.x0()) == null) {
                                a0 a03 = this.k;
                                object2 = new c(a03, null);
                                return object2;
                            }
                            object2 = g.h0.f.c.c;
                            object = this.l;
                            a0 a02 = this.k;
                            boolean bl4 = ((c$a)object2).a((c0)object, a02);
                            if (!bl4) {
                                object = this.k;
                                object2 = new c((a0)object, null);
                                return object2;
                            }
                            object2 = this.k.g();
                            boolean bl5 = ((d)object2).r();
                            if (bl5 || (bl3 = this.f((a0)(object = this.k)))) break block13;
                            object = this.l.s0();
                            long l14 = this.a();
                            long l15 = this.d();
                            int n12 = ((d)object2).n();
                            if (n12 != (n10 = -1)) {
                                timeUnit = TimeUnit.SECONDS;
                                int n13 = ((d)object2).n();
                                l13 = n13;
                                l13 = timeUnit.toMillis(l13);
                                l15 = Math.min(l15, l13);
                            }
                            n12 = ((d)object2).p();
                            l13 = 0L;
                            if (n12 != n10) {
                                timeUnit = TimeUnit.SECONDS;
                                int n14 = ((d)object2).p();
                                l12 = n14;
                                l12 = timeUnit.toMillis(l12);
                            } else {
                                l12 = l13;
                            }
                            n12 = (int)(((d)object).q() ? 1 : 0);
                            if (n12 == 0 && (n12 = ((d)object2).o()) != n10) {
                                timeUnit = TimeUnit.SECONDS;
                                int n15 = ((d)object2).o();
                                long l16 = n15;
                                l13 = timeUnit.toMillis(l16);
                            }
                            if (!(bl2 = ((d)object).r()) && (l11 = (l10 = (l12 += l14) - (l13 += l15)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0) {
                                boolean bl6;
                                long l17;
                                long l18;
                                long l19;
                                object2 = this.l.G0();
                                long l20 = l12 == l15 ? 0 : (l12 < l15 ? -1 : 1);
                                String string2 = "Warning";
                                if (l20 >= 0) {
                                    object = "110 HttpURLConnection \"Response is stale\"";
                                    ((c0$a)object2).a(string2, (String)object);
                                }
                                if ((l19 = (l18 = l14 - (l17 = 86400000L)) == 0L ? 0 : (l18 < 0L ? -1 : 1)) > 0 && (bl6 = this.g())) {
                                    object = "113 HttpURLConnection \"Heuristic expiration\"";
                                    ((c0$a)object2).a(string2, (String)object);
                                }
                                object2 = ((c0$a)object2).c();
                                object = new c(null, (c0)object2);
                                return object;
                            }
                            object2 = this.h;
                            object = "If-Modified-Since";
                            if (object2 == null) break block14;
                            object = "If-None-Match";
                            break block15;
                        }
                        object2 = this.c;
                        if (object2 == null) break block16;
                        object2 = this.d;
                        break block15;
                    }
                    object2 = this.a;
                    if (object2 == null) break block17;
                    object2 = this.b;
                }
                object3 = this.k.k().j();
                f0.m(object2);
                ((s$a)object3).g((String)object, (String)object2);
                object2 = this.k.n();
                object3 = ((s$a)object3).i();
                object2 = ((a0$a)object2).o((s)object3).b();
                object = this.l;
                object3 = new c((a0)object2, (c0)object);
                return object3;
            }
            object = this.k;
            object2 = new c((a0)object, null);
            return object2;
        }
        object = this.k;
        object2 = new c((a0)object, null);
        return object2;
    }

    private final long d() {
        Object object = this.l;
        f0.m(object);
        object = ((c0)object).s0();
        int n10 = ((d)object).n();
        int n11 = -1;
        if (n10 != n11) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long l10 = ((d)object).n();
            return timeUnit.toMillis(l10);
        }
        object = this.e;
        long l11 = 0L;
        if (object != null) {
            Date date = this.a;
            long l12 = date != null ? date.getTime() : this.g;
            long l13 = ((Date)object).getTime() - l12;
            long l14 = l13 - l11;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 > 0) {
                l11 = l13;
            }
            return l11;
        }
        object = this.c;
        if (object != null && (object = this.l.L0().q().O()) == null) {
            object = this.a;
            long l15 = object != null ? ((Date)object).getTime() : this.f;
            object = this.c;
            f0.m(object);
            long l16 = ((Date)object).getTime();
            long l17 = (l15 -= l16) - l11;
            long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (l18 > 0) {
                l18 = 10;
                long l19 = l18;
                l11 = l15 / l19;
            }
        }
        return l11;
    }

    private final boolean f(a0 object) {
        boolean bl2;
        String string2 = ((a0)object).i("If-Modified-Since");
        if (string2 == null && (object = ((a0)object).i(string2 = "If-None-Match")) == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean g() {
        void var2_5;
        Object object = this.l;
        f0.m(object);
        object = ((c0)object).s0();
        int bl2 = ((d)object).n();
        int n10 = -1;
        if (bl2 == n10 && (object = this.e) == null) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        return (boolean)var2_5;
    }

    public final c b() {
        boolean bl2;
        c c10 = this.c();
        Object object = c10.b();
        if (object != null && (bl2 = ((d)(object = this.k.g())).u())) {
            bl2 = false;
            object = null;
            c10 = new c(null, null);
        }
        return c10;
    }

    public final a0 e() {
        return this.k;
    }
}

