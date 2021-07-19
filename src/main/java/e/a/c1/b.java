/*
 * Decompiled with CFR 0.151.
 */
package e.a.c1;

import e.a.a1.a;
import e.a.c1.b$b;
import e.a.c1.b$c;
import e.a.c1.b$f;
import e.a.c1.b$h;
import e.a.h0;
import e.a.w0.g.j;
import e.a.w0.g.l;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class b {
    public static final h0 a;
    public static final h0 b;
    public static final h0 c;
    public static final h0 d;
    public static final h0 e;

    static {
        Callable callable = new b$h();
        a = e.a.a1.a.J(callable);
        callable = new b$b();
        b = e.a.a1.a.G(callable);
        callable = new b$c();
        c = e.a.a1.a.H(callable);
        d = l.k();
        callable = new b$f();
        e = e.a.a1.a.I(callable);
    }

    private b() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static h0 a() {
        return e.a.a1.a.X(b);
    }

    public static h0 b(Executor executor) {
        ExecutorScheduler executorScheduler = new ExecutorScheduler(executor, false);
        return executorScheduler;
    }

    public static h0 c(Executor executor, boolean bl2) {
        ExecutorScheduler executorScheduler = new ExecutorScheduler(executor, bl2);
        return executorScheduler;
    }

    public static h0 d() {
        return e.a.a1.a.Z(c);
    }

    public static h0 e() {
        return e.a.a1.a.a0(e);
    }

    public static void f() {
        e.a.c1.b.a().h();
        e.a.c1.b.d().h();
        e.a.c1.b.e().h();
        e.a.c1.b.g().h();
        e.a.c1.b.i().h();
        j.d();
    }

    public static h0 g() {
        return e.a.a1.a.c0(a);
    }

    public static void h() {
        e.a.c1.b.a().i();
        e.a.c1.b.d().i();
        e.a.c1.b.e().i();
        e.a.c1.b.g().i();
        e.a.c1.b.i().i();
        j.e();
    }

    public static h0 i() {
        return d;
    }
}

