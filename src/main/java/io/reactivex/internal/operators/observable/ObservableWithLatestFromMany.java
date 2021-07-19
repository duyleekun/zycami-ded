/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.w0.e.e.x0;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$WithLatestFromObserver;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$a;
import java.util.Arrays;
import java.util.Iterator;

public final class ObservableWithLatestFromMany
extends a {
    public final e0[] b;
    public final Iterable c;
    public final o d;

    public ObservableWithLatestFromMany(e0 e02, Iterable iterable, o o10) {
        super(e02);
        this.b = null;
        this.c = iterable;
        this.d = o10;
    }

    public ObservableWithLatestFromMany(e0 e02, e0[] e0Array, o o10) {
        super(e02);
        this.b = e0Array;
        this.c = null;
        this.d = o10;
    }

    public void K5(g0 g02) {
        Object object;
        ObservableWithLatestFromMany$a observableWithLatestFromMany$a;
        int n10;
        Iterator iterator2;
        Object object2;
        block13: {
            object2 = this.b;
            if (object2 == null) {
                int n11 = 8;
                object2 = new e0[n11];
                iterator2 = this.c;
                try {
                    iterator2 = iterator2.iterator();
                    n10 = 0;
                    observableWithLatestFromMany$a = null;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptyDisposable.error(throwable, g02);
                    return;
                }
                while (true) {
                    boolean bl2 = iterator2.hasNext();
                    if (!bl2) break block13;
                    break;
                }
                {
                    int n12;
                    block14: {
                        object = iterator2.next();
                        object = (e0)object;
                        n12 = ((Object)object2).length;
                        if (n10 != n12) break block14;
                        n12 = (n10 >> 1) + n10;
                        object2 = Arrays.copyOf(object2, n12);
                        object2 = (e0[])object2;
                    }
                    n12 = n10 + 1;
                    object2[n10] = object;
                    n10 = n12;
                    continue;
                }
            }
            n10 = ((e0[])object2).length;
        }
        if (n10 == 0) {
            iterator2 = this.a;
            observableWithLatestFromMany$a = new ObservableWithLatestFromMany$a(this);
            object2 = new x0((e0)((Object)iterator2), observableWithLatestFromMany$a);
            ((x0)object2).K5(g02);
            return;
        }
        object = this.d;
        iterator2 = new Iterator(g02, (o)object, n10);
        g02.onSubscribe((b)((Object)iterator2));
        ((ObservableWithLatestFromMany$WithLatestFromObserver)((Object)iterator2)).subscribe((e0[])object2, n10);
        this.a.subscribe((g0)((Object)iterator2));
    }
}

