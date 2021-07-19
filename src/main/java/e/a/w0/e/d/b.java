/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.d;

import e.a.d;
import e.a.g;
import e.a.g0;
import e.a.l0;
import e.a.o0;
import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

public final class b {
    private b() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static boolean a(Object object, o object2, d d10) {
        boolean bl2 = object instanceof Callable;
        if (bl2) {
            boolean bl3;
            Object object3;
            block8: {
                object = (Callable)object;
                bl2 = false;
                object3 = null;
                bl3 = true;
                try {
                    object = object.call();
                    if (object == null) break block8;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptyDisposable.error(throwable, d10);
                    return bl3;
                }
                object = object2.apply(object);
                object2 = "The mapper returned a null CompletableSource";
                object3 = object = a.g(object, (String)object2);
                object3 = (g)object;
            }
            if (object3 == null) {
                EmptyDisposable.complete(d10);
            } else {
                object3.f(d10);
            }
            return bl3;
        }
        return false;
    }

    public static boolean b(Object object, o object2, g0 g02) {
        boolean bl2 = object instanceof Callable;
        if (bl2) {
            boolean bl3;
            Object object3;
            block8: {
                object = (Callable)object;
                bl2 = false;
                object3 = null;
                bl3 = true;
                try {
                    object = object.call();
                    if (object == null) break block8;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptyDisposable.error(throwable, g02);
                    return bl3;
                }
                object = object2.apply(object);
                object2 = "The mapper returned a null MaybeSource";
                object3 = object = a.g(object, (String)object2);
                object3 = (w)object;
            }
            if (object3 == null) {
                EmptyDisposable.complete(g02);
            } else {
                object = MaybeToObservable.h8(g02);
                object3.g((t)object);
            }
            return bl3;
        }
        return false;
    }

    public static boolean c(Object object, o object2, g0 g02) {
        boolean bl2 = object instanceof Callable;
        if (bl2) {
            boolean bl3;
            Object object3;
            block8: {
                object = (Callable)object;
                bl2 = false;
                object3 = null;
                bl3 = true;
                try {
                    object = object.call();
                    if (object == null) break block8;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptyDisposable.error(throwable, g02);
                    return bl3;
                }
                object = object2.apply(object);
                object2 = "The mapper returned a null SingleSource";
                object3 = object = a.g(object, (String)object2);
                object3 = (o0)object;
            }
            if (object3 == null) {
                EmptyDisposable.complete(g02);
            } else {
                object = SingleToObservable.h8(g02);
                object3.f((l0)object);
            }
            return bl3;
        }
        return false;
    }
}

