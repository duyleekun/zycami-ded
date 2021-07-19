/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.g;
import e.a.s0.b;
import e.a.w0.e.a.a$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
extends e.a.a {
    private final g[] a;
    private final Iterable b;

    public a(g[] gArray, Iterable iterable) {
        this.a = gArray;
        this.b = iterable;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void L0(d d10) {
        g[] gArray;
        int n10;
        Object object;
        int n11;
        Iterator iterator2;
        g[] gArray2 = this.a;
        String string2 = "One of the sources is null";
        if (gArray2 == null) {
            int n12 = 8;
            g[] gArray3 = new g[n12];
            try {
                boolean bl2;
                iterator2 = this.b;
                iterator2 = iterator2.iterator();
                n11 = 0;
                while (bl2 = iterator2.hasNext()) {
                    void var2_4;
                    object = iterator2.next();
                    if ((object = (g)object) == null) {
                        NullPointerException nullPointerException = new NullPointerException(string2);
                        EmptyDisposable.error((Throwable)nullPointerException, d10);
                        return;
                    }
                    n10 = ((void)var2_4).length;
                    if (n11 == n10) {
                        n10 = (n11 >> 2) + n11;
                        gArray = new g[n10];
                        System.arraycopy(var2_4, 0, gArray, 0, n11);
                        g[] gArray4 = gArray;
                    }
                    n10 = n11 + 1;
                    var2_4[n11] = object;
                    n11 = n10;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, d10);
                return;
            }
        } else {
            n11 = gArray2.length;
        }
        iterator2 = new Iterator();
        d10.onSubscribe((b)((Object)iterator2));
        object = new AtomicBoolean();
        n10 = 0;
        gArray = null;
        while (true) {
            void var2_8;
            if (n10 >= n11) {
                if (n11 != 0) return;
                d10.onComplete();
                return;
            }
            void var11_18 = var2_8[n10];
            boolean bl3 = ((e.a.s0.a)((Object)iterator2)).isDisposed();
            if (bl3) {
                return;
            }
            if (var11_18 == null) {
                NullPointerException nullPointerException = new NullPointerException(string2);
                boolean bl4 = ((AtomicBoolean)object).compareAndSet(false, true);
                if (bl4) {
                    ((e.a.s0.a)((Object)iterator2)).dispose();
                    d10.onError(nullPointerException);
                    return;
                }
                e.a.a1.a.Y(nullPointerException);
                return;
            }
            a$a a$a = new a$a((AtomicBoolean)object, (e.a.s0.a)((Object)iterator2), d10);
            var11_18.f(a$a);
            ++n10;
        }
    }
}

