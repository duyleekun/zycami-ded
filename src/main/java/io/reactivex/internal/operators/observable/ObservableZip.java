/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableZip$ZipCoordinator;

public final class ObservableZip
extends z {
    public final e0[] a;
    public final Iterable b;
    public final o c;
    public final int d;
    public final boolean e;

    public ObservableZip(e0[] e0Array, Iterable iterable, o o10, int n10, boolean bl2) {
        this.a = e0Array;
        this.b = iterable;
        this.c = o10;
        this.d = n10;
        this.e = bl2;
    }

    public void K5(g0 g02) {
        boolean bl2;
        int n10;
        o o10;
        Object object;
        e0[] e0Array = this.a;
        if (e0Array == null) {
            int n11 = 8;
            e0Array = new e0[n11];
            object = this.b.iterator();
            o10 = null;
            n10 = 0;
            while (bl2 = object.hasNext()) {
                e0 e02 = (e0)object.next();
                int n12 = e0Array.length;
                if (n10 == n12) {
                    n12 = (n10 >> 2) + n10;
                    e0[] e0Array2 = new e0[n12];
                    System.arraycopy(e0Array, 0, e0Array2, 0, n10);
                    e0Array = e0Array2;
                }
                n12 = n10 + 1;
                e0Array[n10] = e02;
                n10 = n12;
            }
        } else {
            n10 = e0Array.length;
        }
        if (n10 == 0) {
            EmptyDisposable.complete(g02);
            return;
        }
        o10 = this.c;
        bl2 = this.e;
        object = new ObservableZip$ZipCoordinator(g02, o10, n10, bl2);
        int n13 = this.d;
        ((ObservableZip$ZipCoordinator)object).subscribe(e0Array, n13);
    }
}

