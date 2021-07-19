/*
 * Decompiled with CFR 0.151.
 */
package e.a.a1;

import e.a.d;
import e.a.g0;
import e.a.h0;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.q;
import e.a.t;
import e.a.v0.c;
import e.a.v0.e;
import e.a.v0.g;
import e.a.v0.o;
import e.a.w0.g.f;
import e.a.w0.g.k;
import e.a.z;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;

public final class a {
    public static volatile g a;
    public static volatile o b;
    public static volatile o c;
    public static volatile o d;
    public static volatile o e;
    public static volatile o f;
    public static volatile o g;
    public static volatile o h;
    public static volatile o i;
    public static volatile o j;
    public static volatile o k;
    public static volatile o l;
    public static volatile o m;
    public static volatile o n;
    public static volatile o o;
    public static volatile o p;
    public static volatile o q;
    public static volatile o r;
    public static volatile c s;
    public static volatile c t;
    public static volatile c u;
    public static volatile c v;
    public static volatile c w;
    public static volatile e x;
    public static volatile boolean y;
    public static volatile boolean z;

    private a() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static c A() {
        return u;
    }

    public static void A0(c object) {
        boolean bl2 = y;
        if (!bl2) {
            t = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o B() {
        return r;
    }

    public static void B0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            m = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o C() {
        return p;
    }

    public static void C0(c object) {
        boolean bl2 = y;
        if (!bl2) {
            u = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static c D() {
        return v;
    }

    public static void D0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            r = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o E() {
        return b;
    }

    public static void E0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            p = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o F() {
        return h;
    }

    public static void F0(c object) {
        boolean bl2 = y;
        if (!bl2) {
            v = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static h0 G(Callable callable) {
        e.a.w0.b.a.g(callable, "Scheduler Callable can't be null");
        o o10 = c;
        if (o10 == null) {
            return e.a.a1.a.d(callable);
        }
        return e.a.a1.a.c(o10, callable);
    }

    public static void G0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            b = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static h0 H(Callable callable) {
        e.a.w0.b.a.g(callable, "Scheduler Callable can't be null");
        o o10 = e;
        if (o10 == null) {
            return e.a.a1.a.d(callable);
        }
        return e.a.a1.a.c(o10, callable);
    }

    public static void H0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            h = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static h0 I(Callable callable) {
        e.a.w0.b.a.g(callable, "Scheduler Callable can't be null");
        o o10 = f;
        if (o10 == null) {
            return e.a.a1.a.d(callable);
        }
        return e.a.a1.a.c(o10, callable);
    }

    public static void I0(Throwable throwable) {
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, throwable);
    }

    public static h0 J(Callable callable) {
        e.a.w0.b.a.g(callable, "Scheduler Callable can't be null");
        o o10 = d;
        if (o10 == null) {
            return e.a.a1.a.d(callable);
        }
        return e.a.a1.a.c(o10, callable);
    }

    public static void J0() {
        y = false;
    }

    public static boolean K(Throwable throwable) {
        boolean bl2 = throwable instanceof OnErrorNotImplementedException;
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        bl2 = throwable instanceof MissingBackpressureException;
        if (bl2) {
            return bl3;
        }
        bl2 = throwable instanceof IllegalStateException;
        if (bl2) {
            return bl3;
        }
        bl2 = throwable instanceof NullPointerException;
        if (bl2) {
            return bl3;
        }
        bl2 = throwable instanceof IllegalArgumentException;
        if (bl2) {
            return bl3;
        }
        boolean bl4 = throwable instanceof CompositeException;
        if (bl4) {
            return bl3;
        }
        return false;
    }

    public static boolean L() {
        return z;
    }

    public static boolean M() {
        return y;
    }

    public static void N() {
        y = true;
    }

    public static e.a.a O(e.a.a a10) {
        o o10 = q;
        if (o10 != null) {
            a10 = (e.a.a)e.a.a1.a.b(o10, a10);
        }
        return a10;
    }

    public static j P(j j10) {
        o o10 = k;
        if (o10 != null) {
            j10 = (j)e.a.a1.a.b(o10, j10);
        }
        return j10;
    }

    public static q Q(q q10) {
        o o10 = o;
        if (o10 != null) {
            q10 = (q)e.a.a1.a.b(o10, q10);
        }
        return q10;
    }

    public static z R(z z10) {
        o o10 = m;
        if (o10 != null) {
            z10 = (z)e.a.a1.a.b(o10, z10);
        }
        return z10;
    }

    public static i0 S(i0 i02) {
        o o10 = p;
        if (o10 != null) {
            i02 = (i0)e.a.a1.a.b(o10, i02);
        }
        return i02;
    }

    public static e.a.u0.a T(e.a.u0.a a10) {
        o o10 = l;
        if (o10 != null) {
            a10 = (e.a.u0.a)e.a.a1.a.b(o10, a10);
        }
        return a10;
    }

    public static e.a.x0.a U(e.a.x0.a a10) {
        o o10 = n;
        if (o10 != null) {
            a10 = (e.a.x0.a)e.a.a1.a.b(o10, a10);
        }
        return a10;
    }

    public static e.a.z0.a V(e.a.z0.a a10) {
        o o10 = r;
        if (o10 != null) {
            a10 = (e.a.z0.a)e.a.a1.a.b(o10, a10);
        }
        return a10;
    }

    public static boolean W() {
        e e10 = x;
        if (e10 != null) {
            try {
                return e10.getAsBoolean();
            }
            catch (Throwable throwable) {
                throw ExceptionHelper.f(throwable);
            }
        }
        return false;
    }

    public static h0 X(h0 h02) {
        o o10 = g;
        if (o10 == null) {
            return h02;
        }
        return (h0)e.a.a1.a.b(o10, h02);
    }

    public static void Y(Throwable throwable) {
        g g10 = a;
        if (throwable == null) {
            String string2 = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
            throwable = new NullPointerException(string2);
        } else {
            boolean bl2 = e.a.a1.a.K(throwable);
            if (!bl2) {
                UndeliverableException undeliverableException = new UndeliverableException(throwable);
                throwable = undeliverableException;
            }
        }
        if (g10 != null) {
            try {
                g10.accept(throwable);
                return;
            }
            catch (Throwable throwable2) {
                throwable2.printStackTrace();
                e.a.a1.a.I0(throwable2);
            }
        }
        throwable.printStackTrace();
        e.a.a1.a.I0(throwable);
    }

    public static h0 Z(h0 h02) {
        o o10 = i;
        if (o10 == null) {
            return h02;
        }
        return (h0)e.a.a1.a.b(o10, h02);
    }

    public static Object a(c c10, Object object, Object object2) {
        try {
            return c10.apply(object, object2);
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.f(throwable);
        }
    }

    public static h0 a0(h0 h02) {
        o o10 = j;
        if (o10 == null) {
            return h02;
        }
        return (h0)e.a.a1.a.b(o10, h02);
    }

    public static Object b(o o10, Object object) {
        try {
            return o10.apply(object);
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.f(throwable);
        }
    }

    public static Runnable b0(Runnable runnable) {
        e.a.w0.b.a.g(runnable, "run is null");
        o o10 = b;
        if (o10 == null) {
            return runnable;
        }
        return (Runnable)e.a.a1.a.b(o10, runnable);
    }

    public static h0 c(o o10, Callable callable) {
        return (h0)e.a.w0.b.a.g(e.a.a1.a.b(o10, callable), "Scheduler Callable result can't be null");
    }

    public static h0 c0(h0 h02) {
        o o10 = h;
        if (o10 == null) {
            return h02;
        }
        return (h0)e.a.a1.a.b(o10, h02);
    }

    public static h0 d(Callable object) {
        String string2;
        try {
            object = object.call();
            string2 = "Scheduler Callable result can't be null";
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.f(throwable);
        }
        object = e.a.w0.b.a.g(object, string2);
        return (h0)object;
    }

    public static d d0(e.a.a a10, d d10) {
        c c10 = w;
        if (c10 != null) {
            return (d)e.a.a1.a.a(c10, a10, d10);
        }
        return d10;
    }

    public static h0 e(ThreadFactory threadFactory) {
        threadFactory = (ThreadFactory)e.a.w0.b.a.g(threadFactory, "threadFactory is null");
        e.a.w0.g.a a10 = new e.a.w0.g.a(threadFactory);
        return a10;
    }

    public static t e0(q q10, t t10) {
        c c10 = t;
        if (c10 != null) {
            return (t)e.a.a1.a.a(c10, q10, t10);
        }
        return t10;
    }

    public static h0 f(ThreadFactory threadFactory) {
        threadFactory = (ThreadFactory)e.a.w0.b.a.g(threadFactory, "threadFactory is null");
        e.a.w0.g.e e10 = new e.a.w0.g.e(threadFactory);
        return e10;
    }

    public static g0 f0(z z10, g0 g02) {
        c c10 = u;
        if (c10 != null) {
            return (g0)e.a.a1.a.a(c10, z10, g02);
        }
        return g02;
    }

    public static h0 g(ThreadFactory threadFactory) {
        threadFactory = (ThreadFactory)e.a.w0.b.a.g(threadFactory, "threadFactory is null");
        f f10 = new f(threadFactory);
        return f10;
    }

    public static l0 g0(i0 i02, l0 l02) {
        c c10 = v;
        if (c10 != null) {
            return (l0)e.a.a1.a.a(c10, i02, l02);
        }
        return l02;
    }

    public static h0 h(ThreadFactory threadFactory) {
        threadFactory = (ThreadFactory)e.a.w0.b.a.g(threadFactory, "threadFactory is null");
        k k10 = new k(threadFactory);
        return k10;
    }

    public static i.g.d h0(j j10, i.g.d d10) {
        c c10 = s;
        if (c10 != null) {
            return (i.g.d)e.a.a1.a.a(c10, j10, d10);
        }
        return d10;
    }

    public static o i() {
        return g;
    }

    public static void i0() {
        e.a.a1.a.k0(null);
        e.a.a1.a.G0(null);
        e.a.a1.a.j0(null);
        e.a.a1.a.m0(null);
        e.a.a1.a.q0(null);
        e.a.a1.a.n0(null);
        e.a.a1.a.H0(null);
        e.a.a1.a.p0(null);
        e.a.a1.a.r0(null);
        e.a.a1.a.o0(null);
        e.a.a1.a.x0(null);
        e.a.a1.a.y0(null);
        e.a.a1.a.B0(null);
        e.a.a1.a.C0(null);
        e.a.a1.a.E0(null);
        e.a.a1.a.F0(null);
        e.a.a1.a.t0(null);
        e.a.a1.a.u0(null);
        e.a.a1.a.v0(null);
        e.a.a1.a.w0(null);
        e.a.a1.a.z0(null);
        e.a.a1.a.A0(null);
        e.a.a1.a.D0(null);
        e.a.a1.a.l0(false);
        e.a.a1.a.s0(null);
    }

    public static g j() {
        return a;
    }

    public static void j0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            g = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o k() {
        return c;
    }

    public static void k0(g object) {
        boolean bl2 = y;
        if (!bl2) {
            a = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o l() {
        return e;
    }

    public static void l0(boolean bl2) {
        boolean bl3 = y;
        if (!bl3) {
            z = bl2;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Plugins can't be changed anymore");
        throw illegalStateException;
    }

    public static o m() {
        return f;
    }

    public static void m0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            c = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o n() {
        return d;
    }

    public static void n0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            e = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o o() {
        return i;
    }

    public static void o0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            f = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o p() {
        return j;
    }

    public static void p0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            d = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static e q() {
        return x;
    }

    public static void q0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            i = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o r() {
        return q;
    }

    public static void r0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            j = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static c s() {
        return w;
    }

    public static void s0(e object) {
        boolean bl2 = y;
        if (!bl2) {
            x = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o t() {
        return l;
    }

    public static void t0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            q = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o u() {
        return n;
    }

    public static void u0(c object) {
        boolean bl2 = y;
        if (!bl2) {
            w = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o v() {
        return k;
    }

    public static void v0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            l = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static c w() {
        return s;
    }

    public static void w0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            n = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o x() {
        return o;
    }

    public static void x0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            k = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static c y() {
        return t;
    }

    public static void y0(c object) {
        boolean bl2 = y;
        if (!bl2) {
            s = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }

    public static o z() {
        return m;
    }

    public static void z0(o object) {
        boolean bl2 = y;
        if (!bl2) {
            o = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }
}

