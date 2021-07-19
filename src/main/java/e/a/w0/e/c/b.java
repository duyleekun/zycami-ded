/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.a1.a;
import e.a.q;
import e.a.t;
import e.a.w;
import e.a.w0.e.c.b$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
extends q {
    private final w[] a;
    private final Iterable b;

    public b(w[] wArray, Iterable iterable) {
        this.a = wArray;
        this.b = iterable;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void t1(t t10) {
        w[] wArray;
        int n10;
        Object object;
        int n11;
        Object object2;
        w[] wArray2 = this.a;
        boolean bl2 = false;
        String string2 = null;
        if (wArray2 == null) {
            int n12 = 8;
            w[] wArray3 = new w[n12];
            try {
                boolean bl3;
                object2 = this.b;
                object2 = object2.iterator();
                n11 = 0;
                while (bl3 = object2.hasNext()) {
                    void var2_4;
                    object = object2.next();
                    if ((object = (w)object) == null) {
                        string2 = "One of the sources is null";
                        NullPointerException nullPointerException = new NullPointerException(string2);
                        EmptyDisposable.error((Throwable)nullPointerException, t10);
                        return;
                    }
                    n10 = ((void)var2_4).length;
                    if (n11 == n10) {
                        n10 = (n11 >> 2) + n11;
                        wArray = new w[n10];
                        System.arraycopy(var2_4, 0, wArray, 0, n11);
                        w[] wArray4 = wArray;
                    }
                    n10 = n11 + 1;
                    var2_4[n11] = object;
                    n11 = n10;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, t10);
                return;
            }
        } else {
            n11 = wArray2.length;
        }
        object2 = new e.a.s0.a();
        t10.onSubscribe((e.a.s0.b)object2);
        object = new AtomicBoolean();
        n10 = 0;
        wArray = null;
        while (true) {
            void var2_8;
            if (n10 >= n11) {
                if (n11 != 0) return;
                t10.onComplete();
                return;
            }
            void var12_19 = var2_8[n10];
            boolean bl4 = ((e.a.s0.a)object2).isDisposed();
            if (bl4) {
                return;
            }
            if (var12_19 == null) {
                ((e.a.s0.a)object2).dispose();
                object2 = "One of the MaybeSources is null";
                NullPointerException nullPointerException = new NullPointerException((String)object2);
                boolean bl5 = true;
                bl2 = ((AtomicBoolean)object).compareAndSet(false, bl5);
                if (bl2) {
                    t10.onError(nullPointerException);
                    return;
                }
                e.a.a1.a.Y(nullPointerException);
                return;
            }
            b$a b$a = new b$a(t10, (e.a.s0.a)object2, (AtomicBoolean)object);
            var12_19.g(b$a);
            ++n10;
        }
    }
}

