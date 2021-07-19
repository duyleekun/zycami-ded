/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableBuffer$BufferSkipObserver;
import io.reactivex.internal.operators.observable.ObservableBuffer$a;
import java.util.concurrent.Callable;

public final class ObservableBuffer
extends a {
    public final int b;
    public final int c;
    public final Callable d;

    public ObservableBuffer(e0 e02, int n10, int n11, Callable callable) {
        super(e02);
        this.b = n10;
        this.c = n11;
        this.d = callable;
    }

    public void K5(g0 object) {
        int n10 = this.c;
        int n11 = this.b;
        if (n10 == n11) {
            Callable callable = this.d;
            ObservableBuffer$a observableBuffer$a = new ObservableBuffer$a((g0)object, n11, callable);
            boolean bl2 = observableBuffer$a.a();
            if (bl2) {
                object = this.a;
                object.subscribe(observableBuffer$a);
            }
        } else {
            e0 e02 = this.a;
            int n12 = this.b;
            int n13 = this.c;
            Callable callable = this.d;
            ObservableBuffer$BufferSkipObserver observableBuffer$BufferSkipObserver = new ObservableBuffer$BufferSkipObserver((g0)object, n12, n13, callable);
            e02.subscribe(observableBuffer$BufferSkipObserver);
        }
    }
}

