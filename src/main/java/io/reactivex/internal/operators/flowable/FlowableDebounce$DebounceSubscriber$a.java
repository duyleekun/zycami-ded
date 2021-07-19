/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.e1.b;
import io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FlowableDebounce$DebounceSubscriber$a
extends b {
    public final FlowableDebounce$DebounceSubscriber b;
    public final long c;
    public final Object d;
    public boolean e;
    public final AtomicBoolean f;

    public FlowableDebounce$DebounceSubscriber$a(FlowableDebounce$DebounceSubscriber flowableDebounce$DebounceSubscriber, long l10, Object object) {
        AtomicBoolean atomicBoolean;
        this.f = atomicBoolean = new AtomicBoolean();
        this.b = flowableDebounce$DebounceSubscriber;
        this.c = l10;
        this.d = object;
    }

    public void d() {
        Serializable serializable = this.f;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (bl3) {
            serializable = this.b;
            long l10 = this.c;
            Object object = this.d;
            ((FlowableDebounce$DebounceSubscriber)serializable).emit(l10, object);
        }
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.d();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        this.b.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.a();
        this.d();
    }
}

