/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.q;
import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.e.c.c0$a;
import io.reactivex.internal.operators.maybe.MaybeZipArray$ZipCoordinator;
import io.reactivex.internal.operators.maybe.MaybeZipArray$a;

public final class MaybeZipArray
extends q {
    public final w[] a;
    public final o b;

    public MaybeZipArray(w[] wArray, o o10) {
        this.a = wArray;
        this.b = o10;
    }

    public void t1(t object) {
        Object object2 = this.a;
        int n10 = ((w[])object2).length;
        MaybeZipArray$a maybeZipArray$a = null;
        int n11 = 1;
        if (n10 == n11) {
            object2 = object2[0];
            maybeZipArray$a = new MaybeZipArray$a(this);
            c0$a c0$a = new c0$a((t)object, maybeZipArray$a);
            object2.g(c0$a);
            return;
        }
        Object object3 = this.b;
        MaybeZipArray$ZipCoordinator maybeZipArray$ZipCoordinator = new MaybeZipArray$ZipCoordinator((t)object, n10, (o)object3);
        object.onSubscribe(maybeZipArray$ZipCoordinator);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = maybeZipArray$ZipCoordinator.isDisposed();
            if (bl2) {
                return;
            }
            object = object2[i10];
            if (object == null) {
                object = new NullPointerException("One of the sources is null");
                maybeZipArray$ZipCoordinator.innerError((Throwable)object, i10);
                return;
            }
            object3 = maybeZipArray$ZipCoordinator.observers[i10];
            object.g((t)object3);
        }
    }
}

