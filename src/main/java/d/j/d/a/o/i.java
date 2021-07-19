/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package d.j.d.a.o;

import android.os.Looper;
import d.j.d.a.f;
import d.j.d.a.k;
import d.j.d.a.l;
import d.j.d.a.m;
import d.j.d.a.o.e;
import d.j.d.a.o.h;
import d.j.d.a.o.i$a;
import d.j.d.a.o.i$b;
import d.j.d.a.o.i$c;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class i {
    public static k a(Object object) {
        l l10 = new l();
        l10.d(object);
        return l10.b();
    }

    public static k b(Collection collection) {
        k k10 = i.g(collection);
        i$b i$b = new i$b(collection);
        return k10.m(i$b);
    }

    public static Object d(k object) {
        boolean bl2 = ((k)object).v();
        if (bl2) {
            return ((k)object).r();
        }
        object = ((k)object).q();
        ExecutionException executionException = new ExecutionException((Throwable)object);
        throw executionException;
    }

    public static void e(String string2) {
        Looper looper;
        Object object = Looper.myLooper();
        if (object != (looper = Looper.getMainLooper())) {
            return;
        }
        object = new IllegalStateException(string2);
        throw object;
    }

    public static k f(Collection collection) {
        k k10 = i.g(collection);
        i$c i$c = new i$c(collection);
        return k10.m(i$c);
    }

    public static k g(Collection object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3 = object.isEmpty();
        if (bl3) {
            return i.a(null);
        }
        Object object4 = object.iterator();
        while (bl2 = object4.hasNext()) {
            object3 = (k)object4.next();
            object2 = "task can not is null";
            Objects.requireNonNull(object3, (String)object2);
        }
        object4 = new h();
        int n10 = object.size();
        object3 = new e(n10, (h)object4);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (k)object.next();
            Executor executor = m.b();
            ((k)object2).l(executor, (d.j.d.a.i)object3);
            executor = m.b();
            ((k)object2).i(executor, (d.j.d.a.h)object3);
            executor = m.b();
            ((k)object2).c(executor, (f)object3);
        }
        return object4;
    }

    public final k c(Executor executor, Callable callable) {
        l l10 = new l();
        i$a i$a = new i$a(this, l10, callable);
        try {
            executor.execute(i$a);
        }
        catch (Exception exception) {
            l10.c(exception);
        }
        return l10.b();
    }
}

