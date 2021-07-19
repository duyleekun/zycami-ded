/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver;
import java.util.concurrent.Callable;

public final class ObservableBufferBoundary
extends a {
    public final Callable b;
    public final e0 c;
    public final o d;

    public ObservableBufferBoundary(e0 e02, e0 e03, o o10, Callable callable) {
        super(e02);
        this.c = e03;
        this.d = o10;
        this.b = callable;
    }

    public void K5(g0 g02) {
        e0 e02 = this.c;
        o o10 = this.d;
        Callable callable = this.b;
        ObservableBufferBoundary$BufferBoundaryObserver observableBufferBoundary$BufferBoundaryObserver = new ObservableBufferBoundary$BufferBoundaryObserver(g02, e02, o10, callable);
        g02.onSubscribe(observableBufferBoundary$BufferBoundaryObserver);
        this.a.subscribe(observableBufferBoundary$BufferBoundaryObserver);
    }
}

