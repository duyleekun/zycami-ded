/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutFallbackObserver;
import io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutObserver;

public final class ObservableTimeout
extends a {
    public final e0 b;
    public final o c;
    public final e0 d;

    public ObservableTimeout(z z10, e0 e02, o o10, e0 e03) {
        super(z10);
        this.b = e02;
        this.c = o10;
        this.d = e03;
    }

    public void K5(g0 object) {
        Object object2 = this.d;
        if (object2 == null) {
            o o10 = this.c;
            object2 = new ObservableTimeout$TimeoutObserver((g0)object, o10);
            object.onSubscribe((b)object2);
            object = this.b;
            ((ObservableTimeout$TimeoutObserver)object2).startFirstTimeout((e0)object);
            object = this.a;
            object.subscribe((g0)object2);
        } else {
            o o11 = this.c;
            e0 e02 = this.d;
            object2 = new ObservableTimeout$TimeoutFallbackObserver((g0)object, o11, e02);
            object.onSubscribe((b)object2);
            object = this.b;
            ((ObservableTimeout$TimeoutFallbackObserver)object2).startFirstTimeout((e0)object);
            object = this.a;
            object.subscribe((g0)object2);
        }
    }
}

