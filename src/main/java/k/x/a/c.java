/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.z;
import io.reactivex.exceptions.CompositeException;
import k.d;
import k.x.a.c$a;

public final class c
extends z {
    private final d a;

    public c(d d10) {
        this.a = d10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void K5(g0 g02) {
        void var2_6;
        Throwable[] throwableArray;
        int n10;
        Object object;
        block9: {
            Object object2 = this.a.clone();
            object = new c$a((d)object2);
            g02.onSubscribe((b)object);
            int n11 = ((c$a)object).isDisposed();
            if (n11 != 0) {
                return;
            }
            n11 = 1;
            try {
                boolean bl2;
                object2 = object2.execute();
                n10 = ((c$a)object).isDisposed();
                if (n10 == 0) {
                    g02.onNext(object2);
                }
                if (bl2 = ((c$a)object).isDisposed()) return;
            }
            catch (Throwable throwable) {
                n10 = 0;
                throwableArray = null;
                break block9;
            }
            try {
                g02.onComplete();
                return;
            }
            catch (Throwable throwable) {
                n10 = n11;
            }
        }
        e.a.t0.a.b((Throwable)var2_6);
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)var2_6);
            return;
        }
        boolean bl3 = ((c$a)object).isDisposed();
        if (bl3) return;
        try {
            g02.onError((Throwable)var2_6);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            n10 = 2;
            throwableArray = new Throwable[n10];
            throwableArray[0] = var2_6;
            throwableArray[n11] = throwable;
            object = new CompositeException(throwableArray);
            e.a.a1.a.Y((Throwable)object);
        }
    }
}

