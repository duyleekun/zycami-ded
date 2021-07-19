/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.w0.e.g.a$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
extends i0 {
    private final o0[] a;
    private final Iterable b;

    public a(o0[] o0Array, Iterable iterable) {
        this.a = o0Array;
        this.b = iterable;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e1(l0 l02) {
        o0[] o0Array;
        int n10;
        Object object;
        int n11;
        Iterator iterator2;
        o0[] o0Array2 = this.a;
        String string2 = "One of the sources is null";
        if (o0Array2 == null) {
            int n12 = 8;
            o0[] o0Array3 = new o0[n12];
            try {
                boolean bl2;
                iterator2 = this.b;
                iterator2 = iterator2.iterator();
                n11 = 0;
                while (bl2 = iterator2.hasNext()) {
                    void var2_4;
                    object = iterator2.next();
                    if ((object = (o0)object) == null) {
                        NullPointerException nullPointerException = new NullPointerException(string2);
                        EmptyDisposable.error((Throwable)nullPointerException, l02);
                        return;
                    }
                    n10 = ((void)var2_4).length;
                    if (n11 == n10) {
                        n10 = (n11 >> 2) + n11;
                        o0Array = new o0[n10];
                        System.arraycopy(var2_4, 0, o0Array, 0, n11);
                        o0[] o0Array4 = o0Array;
                    }
                    n10 = n11 + 1;
                    var2_4[n11] = object;
                    n11 = n10;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, l02);
                return;
            }
        } else {
            n11 = o0Array2.length;
        }
        iterator2 = new Iterator();
        object = new e.a.s0.a();
        l02.onSubscribe((b)object);
        n10 = 0;
        o0Array = null;
        while (n10 < n11) {
            void var2_8;
            void var11_18 = var2_8[n10];
            boolean bl3 = ((e.a.s0.a)object).isDisposed();
            if (bl3) {
                return;
            }
            if (var11_18 == null) {
                ((e.a.s0.a)object).dispose();
                NullPointerException nullPointerException = new NullPointerException(string2);
                boolean bl4 = ((AtomicBoolean)((Object)iterator2)).compareAndSet(false, true);
                if (bl4) {
                    l02.onError(nullPointerException);
                    return;
                }
                e.a.a1.a.Y(nullPointerException);
                return;
            }
            a$a a$a = new a$a(l02, (e.a.s0.a)object, (AtomicBoolean)((Object)iterator2));
            var11_18.f(a$a);
            ++n10;
        }
    }
}

