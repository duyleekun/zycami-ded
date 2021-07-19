/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.s.l;
import f.h2.t.c0;
import f.q1;
import h.f0$a;
import h.k0;
import h.m;
import h.m0;
import h.o0;
import h.o0$b;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class f0 {
    private final m a;
    private boolean b;
    private boolean c;
    private boolean d;
    private k0 e;
    private final k0 f;
    private final m0 g;
    private final long h;

    public f0(long l10) {
        this.h = l10;
        Object object = new m();
        this.a = object;
        long l11 = 1L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            l12 = 1;
        } else {
            l12 = 0;
            object = null;
        }
        if (l12 != false) {
            Closeable closeable = new f0$a(this);
            this.f = closeable;
            super(this);
            this.g = closeable;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("maxBufferSize < 1: ");
        ((StringBuilder)object).append(l10);
        String string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static final /* synthetic */ void c(f0 f02, k0 k02, l l10) {
        f02.f(k02, l10);
    }

    private final void f(k0 k02, l object) {
        block11: {
            int n10;
            boolean bl2;
            TimeUnit timeUnit;
            long l10;
            long l11;
            o0 o02;
            o0 o03;
            block10: {
                o03 = k02.timeout();
                o02 = this.q().timeout();
                l11 = o03.j();
                o0$b o0$b = o0.e;
                long l12 = o02.j();
                l10 = o03.j();
                long l13 = o0$b.a(l12, l10);
                timeUnit = TimeUnit.NANOSECONDS;
                o03.i(l13, timeUnit);
                bl2 = o03.f();
                n10 = 1;
                if (!bl2) break block10;
                l10 = o03.d();
                bl2 = o02.f();
                if (bl2) {
                    long l14 = o03.d();
                    long l15 = o02.d();
                    l14 = Math.min(l14, l15);
                    o03.e(l14);
                }
                try {
                    object.invoke(k02);
                }
                catch (Throwable throwable) {
                    c0.d(n10);
                    object = TimeUnit.NANOSECONDS;
                    o03.i(l11, (TimeUnit)((Object)object));
                    boolean bl3 = o02.f();
                    if (bl3) {
                        o03.e(l10);
                    }
                    c0.c(n10);
                    throw throwable;
                }
                c0.d(n10);
                o03.i(l11, timeUnit);
                boolean bl4 = o02.f();
                if (bl4) {
                    o03.e(l10);
                }
                c0.c(n10);
                break block11;
            }
            bl2 = o02.f();
            if (bl2) {
                l10 = o02.d();
                o03.e(l10);
            }
            try {
                object.invoke(k02);
            }
            catch (Throwable throwable) {
                c0.d(n10);
                object = TimeUnit.NANOSECONDS;
                o03.i(l11, (TimeUnit)((Object)object));
                boolean bl5 = o02.f();
                if (bl5) {
                    o03.a();
                }
                c0.c(n10);
                throw throwable;
            }
            c0.d(n10);
            o03.i(l11, timeUnit);
            boolean bl6 = o02.f();
            if (bl6) {
                o03.a();
            }
            c0.c(n10);
        }
    }

    public final k0 a() {
        return this.f;
    }

    public final m0 b() {
        return this.g;
    }

    public final void d() {
        m m10 = this.a;
        synchronized (m10) {
            Object object;
            block8: {
                boolean bl2 = true;
                this.b = bl2;
                object = this.a;
                ((m)object).B();
                object = this.a;
                if (object == null) break block8;
                object.notifyAll();
                object = q1.a;
                return;
            }
            String string2 = "null cannot be cast to non-null type java.lang.Object";
            object = new NullPointerException(string2);
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void e(k0 object) {
        Object object2 = "sink";
        f.h2.t.f0.p(object, (String)object2);
        while (true) {
            m m10;
            boolean bl2;
            boolean bl3;
            Object object3;
            object2 = this.a;
            synchronized (object2) {
                object3 = this.e;
                bl3 = true;
                if (object3 == null) {
                    bl2 = bl3;
                } else {
                    bl2 = false;
                    object3 = null;
                }
                if (!bl2) {
                    object = "sink already folded";
                    object = object.toString();
                    object3 = new IllegalStateException((String)object);
                    throw object3;
                }
                bl2 = this.b;
                if (bl2) {
                    this.e = object;
                    object3 = "canceled";
                    object = new IOException((String)object3);
                    throw object;
                }
                object3 = this.a;
                bl2 = ((m)object3).V();
                if (bl2) {
                    this.d = bl3;
                    this.e = object;
                    return;
                }
                bl2 = this.c;
                m10 = new m();
                Object object4 = this.a;
                long l10 = ((m)object4).S0();
                m10.t((m)object4, l10);
                object4 = this.a;
                if (object4 == null) {
                    object3 = "null cannot be cast to non-null type java.lang.Object";
                    object = new NullPointerException((String)object3);
                    throw object;
                }
                object4.notifyAll();
                object4 = q1.a;
            }
            try {
                long l11 = m10.S0();
                object.t(m10, l11);
                if (bl2) {
                    object.close();
                    continue;
                }
                object.flush();
            }
            catch (Throwable throwable) {
                object2 = this.a;
                synchronized (object2) {
                    this.d = bl3;
                    object3 = this.a;
                    if (object3 == null) {
                        object3 = "null cannot be cast to non-null type java.lang.Object";
                        NullPointerException nullPointerException = new NullPointerException((String)object3);
                        throw nullPointerException;
                    }
                    object3.notifyAll();
                    object3 = q1.a;
                    throw throwable;
                }
            }
        }
    }

    public final m g() {
        return this.a;
    }

    public final boolean h() {
        return this.b;
    }

    public final k0 i() {
        return this.e;
    }

    public final long j() {
        return this.h;
    }

    public final boolean k() {
        return this.c;
    }

    public final boolean l() {
        return this.d;
    }

    public final void m(boolean bl2) {
        this.b = bl2;
    }

    public final void n(k0 k02) {
        this.e = k02;
    }

    public final void o(boolean bl2) {
        this.c = bl2;
    }

    public final void p(boolean bl2) {
        this.d = bl2;
    }

    public final k0 q() {
        return this.f;
    }

    public final m0 r() {
        return this.g;
    }
}

