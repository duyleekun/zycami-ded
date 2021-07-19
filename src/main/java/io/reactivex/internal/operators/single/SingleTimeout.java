/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.h0;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleTimeout$TimeoutMainObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout
extends i0 {
    public final o0 a;
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final o0 e;

    public SingleTimeout(o0 o02, long l10, TimeUnit timeUnit, h0 h02, o0 o03) {
        this.a = o02;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = o03;
    }

    public void e1(l0 object) {
        SingleTimeout$TimeoutMainObserver singleTimeout$TimeoutMainObserver;
        o0 o02 = this.e;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        Object object2 = singleTimeout$TimeoutMainObserver;
        singleTimeout$TimeoutMainObserver = new SingleTimeout$TimeoutMainObserver((l0)object, o02, l10, timeUnit);
        object.onSubscribe(singleTimeout$TimeoutMainObserver);
        object = singleTimeout$TimeoutMainObserver.task;
        object2 = this.d;
        long l11 = this.b;
        TimeUnit timeUnit2 = this.c;
        object2 = ((h0)object2).f(singleTimeout$TimeoutMainObserver, l11, timeUnit2);
        DisposableHelper.replace((AtomicReference)object, (b)object2);
        this.a.f(singleTimeout$TimeoutMainObserver);
    }
}

