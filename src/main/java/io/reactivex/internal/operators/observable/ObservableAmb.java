/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.t0.a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableAmb$a;

public final class ObservableAmb
extends z {
    public final e0[] a;
    public final Iterable b;

    public ObservableAmb(e0[] e0Array, Iterable iterable) {
        this.a = e0Array;
        this.b = iterable;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void K5(g0 g02) {
        void var2_8;
        int n10;
        e0[] e0Array = this.a;
        Object object = null;
        if (e0Array == null) {
            int n11 = 8;
            e0[] e0Array2 = new e0[n11];
            try {
                boolean bl2;
                Object object2 = this.b;
                object2 = object2.iterator();
                n10 = 0;
                while (bl2 = object2.hasNext()) {
                    void var2_4;
                    Object e10 = object2.next();
                    e0 e02 = (e0)e10;
                    if (e02 == null) {
                        object = "One of the sources is null";
                        NullPointerException nullPointerException = new NullPointerException((String)object);
                        EmptyDisposable.error((Throwable)nullPointerException, g02);
                        return;
                    }
                    int n12 = ((void)var2_4).length;
                    if (n10 == n12) {
                        n12 = (n10 >> 2) + n10;
                        e0[] e0Array3 = new e0[n12];
                        System.arraycopy(var2_4, 0, e0Array3, 0, n10);
                        e0[] e0Array4 = e0Array3;
                    }
                    n12 = n10 + 1;
                    var2_4[n10] = e02;
                    n10 = n12;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, g02);
                return;
            }
        } else {
            n10 = e0Array.length;
        }
        if (n10 == 0) {
            EmptyDisposable.complete(g02);
            return;
        }
        int n13 = 1;
        if (n10 == n13) {
            var2_8[0].subscribe(g02);
            return;
        }
        object = new ObservableAmb$a(g02, n10);
        ((ObservableAmb$a)object).a((e0[])var2_8);
    }
}

