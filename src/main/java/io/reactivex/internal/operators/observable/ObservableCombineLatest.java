/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator;

public final class ObservableCombineLatest
extends z {
    public final e0[] a;
    public final Iterable b;
    public final o c;
    public final int d;
    public final boolean e;

    public ObservableCombineLatest(e0[] e0Array, Iterable iterable, o o10, int n10, boolean bl2) {
        this.a = e0Array;
        this.b = iterable;
        this.c = o10;
        this.d = n10;
        this.e = bl2;
    }

    public void K5(g0 g02) {
        ObservableCombineLatest$LatestCoordinator observableCombineLatest$LatestCoordinator;
        int n10;
        int n11;
        o o10;
        int n12;
        Object object;
        e0[] e0Array = this.a;
        if (e0Array == null) {
            int n13 = 8;
            e0Array = new e0[n13];
            object = this.b.iterator();
            n12 = 0;
            o10 = null;
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                e0 e02 = (e0)object.next();
                n10 = e0Array.length;
                if (n12 == n10) {
                    n10 = (n12 >> 2) + n12;
                    e0[] e0Array2 = new e0[n10];
                    System.arraycopy(e0Array, 0, e0Array2, 0, n12);
                    e0Array = e0Array2;
                }
                n10 = n12 + 1;
                e0Array[n12] = e02;
                n12 = n10;
            }
        } else {
            n12 = e0Array.length;
        }
        n11 = n12;
        if (n12 == 0) {
            EmptyDisposable.complete(g02);
            return;
        }
        o10 = this.c;
        n10 = this.d;
        boolean bl2 = this.e;
        object = observableCombineLatest$LatestCoordinator;
        observableCombineLatest$LatestCoordinator = new ObservableCombineLatest$LatestCoordinator(g02, o10, n12, n10, bl2);
        observableCombineLatest$LatestCoordinator.subscribe(e0Array);
    }
}

