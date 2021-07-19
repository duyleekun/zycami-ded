/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a;

import d.j.d.a.k;
import d.j.d.a.l;
import d.j.d.a.m;
import d.j.d.a.o.h;
import d.j.d.a.o.i;
import d.j.d.a.o.i$d;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class n {
    private static i a;

    static {
        i i10;
        a = i10 = new i();
    }

    public static k a(Collection collection) {
        return i.b(collection);
    }

    public static k b(k ... kArray) {
        return i.b(Arrays.asList(kArray));
    }

    public static Object c(k k10) {
        Object object = "await must not be called on the UI thread";
        i.e((String)object);
        boolean bl2 = k10.u();
        if (bl2) {
            return i.d(k10);
        }
        object = new i$d();
        k10.k((d.j.d.a.i)object).h((d.j.d.a.h)object);
        ((i$d)object).a.await();
        return i.d(k10);
    }

    public static Object d(k object, long l10, TimeUnit timeUnit) {
        Object object2 = "await must not be called on the UI thread";
        i.e((String)object2);
        boolean bl2 = ((k)object).u();
        if (!bl2) {
            object2 = new i$d();
            k k10 = ((k)object).k((d.j.d.a.i)object2);
            k10.h((d.j.d.a.h)object2);
            object2 = ((i$d)object2).a;
            boolean bl3 = ((CountDownLatch)object2).await(l10, timeUnit);
            if (!bl3) {
                object = new TimeoutException("Timed out waiting for Task");
                throw object;
            }
        }
        return i.d((k)object);
    }

    public static k e(Callable callable) {
        i i10 = a;
        Executor executor = m.b();
        return i10.c(executor, callable);
    }

    public static k f(Callable callable) {
        i i10 = a;
        ExecutorService executorService = m.a();
        return i10.c(executorService, callable);
    }

    public static k g(Executor executor, Callable callable) {
        return a.c(executor, callable);
    }

    public static k h() {
        h h10 = new h();
        h10.B();
        return h10;
    }

    public static k i(Exception exception) {
        l l10 = new l();
        l10.c(exception);
        return l10.b();
    }

    public static k j(Object object) {
        return i.a(object);
    }

    public static k k(Collection collection) {
        return i.g(collection);
    }

    public static k l(k ... kArray) {
        return i.g(Arrays.asList(kArray));
    }

    public static k m(Collection collection) {
        return i.f(collection);
    }

    public static k n(k ... kArray) {
        return i.f(Arrays.asList(kArray));
    }
}

