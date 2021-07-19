/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.h0;

import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleNotStartedException;
import d.q.a.h0.a;
import d.q.a.h0.b;
import d.q.a.h0.c;
import d.q.a.h0.e;
import d.q.a.h0.f;
import d.q.a.n;
import e.a.v0.r;
import e.a.z;
import java.util.Comparator;

public final class g {
    private static final Comparator a = d.q.a.h0.a.a;

    private g() {
        InstantiationError instantiationError = new InstantiationError();
        throw instantiationError;
    }

    public static /* synthetic */ boolean a(Comparator comparator, Object object, Object object2) {
        int n10 = comparator.compare(object2, object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            comparator = null;
        }
        return n10 != 0;
    }

    public static /* synthetic */ boolean b(Object object, Object object2) {
        return object2.equals(object);
    }

    public static e.a.g c(f f10) {
        return g.d(f10, true);
    }

    public static e.a.g d(f object, boolean bl2) {
        Object object2 = object.c();
        e e10 = object.d();
        if (object2 != null) {
            Object object3;
            try {
                object3 = e10.apply(object2);
            }
            catch (Exception exception) {
                if (bl2 && (bl2 = exception instanceof LifecycleEndedException)) {
                    e.a.v0.g g10 = n.c();
                    if (g10 != null) {
                        LifecycleEndedException lifecycleEndedException;
                        try {
                            lifecycleEndedException = (LifecycleEndedException)exception;
                        }
                        catch (Exception exception2) {
                            return e.a.a.V(exception2);
                        }
                        g10.accept(lifecycleEndedException);
                        return e.a.a.y();
                    }
                    throw (Throwable)exception;
                }
                return e.a.a.V(exception);
            }
            return g.e(object.b(), object3);
        }
        object = new LifecycleNotStartedException();
        throw object;
    }

    public static e.a.g e(z z10, Object object) {
        Comparator comparator;
        boolean bl2 = object instanceof Comparable;
        if (bl2) {
            comparator = a;
        } else {
            bl2 = false;
            comparator = null;
        }
        return g.f(z10, object, comparator);
    }

    public static e.a.g f(z z10, Object object, Comparator comparator) {
        r r10 = comparator != null ? new b(comparator, object) : new c(object);
        return z10.t5(1L).o6(r10).k3();
    }
}

