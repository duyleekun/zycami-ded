/*
 * Decompiled with CFR 0.151.
 */
package e.a.q0.b;

import e.a.h0;
import e.a.v0.o;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class a {
    private static volatile o a;
    private static volatile o b;

    private a() {
        AssertionError assertionError = new AssertionError((Object)"No instances.");
        throw assertionError;
    }

    public static Object a(o o10, Object object) {
        try {
            return o10.apply(object);
        }
        catch (Throwable throwable) {
            throw e.a.t0.a.a(throwable);
        }
    }

    public static h0 b(o object, Callable callable) {
        object = (h0)e.a.q0.b.a.a((o)object, callable);
        Objects.requireNonNull(object, "Scheduler Callable returned null");
        return object;
    }

    public static h0 c(Callable object) {
        try {
            object = object.call();
        }
        catch (Throwable throwable) {
            throw e.a.t0.a.a(throwable);
        }
        object = (h0)object;
        if (object != null) {
            return object;
        }
        String string2 = "Scheduler Callable returned null";
        object = new NullPointerException(string2);
        throw object;
    }

    public static o d() {
        return a;
    }

    public static o e() {
        return b;
    }

    public static h0 f(Callable callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        o o10 = a;
        if (o10 == null) {
            return e.a.q0.b.a.c(callable);
        }
        return e.a.q0.b.a.b(o10, callable);
    }

    public static h0 g(h0 h02) {
        Objects.requireNonNull(h02, "scheduler == null");
        o o10 = b;
        if (o10 == null) {
            return h02;
        }
        return (h0)e.a.q0.b.a.a(o10, h02);
    }

    public static void h() {
        e.a.q0.b.a.i(null);
        e.a.q0.b.a.j(null);
    }

    public static void i(o o10) {
        a = o10;
    }

    public static void j(o o10) {
        b = o10;
    }
}

