/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.v0.o;
import e.a.w0.e.g.v$a;
import io.reactivex.internal.operators.single.SingleZipArray$ZipCoordinator;
import io.reactivex.internal.operators.single.SingleZipArray$a;

public final class SingleZipArray
extends i0 {
    public final o0[] a;
    public final o b;

    public SingleZipArray(o0[] o0Array, o o10) {
        this.a = o0Array;
        this.b = o10;
    }

    public void e1(l0 object) {
        Object object2 = this.a;
        int n10 = ((o0[])object2).length;
        SingleZipArray$a singleZipArray$a = null;
        int n11 = 1;
        if (n10 == n11) {
            object2 = object2[0];
            singleZipArray$a = new SingleZipArray$a(this);
            v$a v$a = new v$a((l0)object, singleZipArray$a);
            object2.f(v$a);
            return;
        }
        Object object3 = this.b;
        SingleZipArray$ZipCoordinator singleZipArray$ZipCoordinator = new SingleZipArray$ZipCoordinator((l0)object, n10, (o)object3);
        object.onSubscribe(singleZipArray$ZipCoordinator);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = singleZipArray$ZipCoordinator.isDisposed();
            if (bl2) {
                return;
            }
            object = object2[i10];
            if (object == null) {
                object = new NullPointerException("One of the sources is null");
                singleZipArray$ZipCoordinator.innerError((Throwable)object, i10);
                return;
            }
            object3 = singleZipArray$ZipCoordinator.observers[i10];
            object.f((l0)object3);
        }
    }
}

