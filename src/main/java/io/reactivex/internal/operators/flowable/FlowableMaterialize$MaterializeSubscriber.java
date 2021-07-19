/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.y;
import i.g.d;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

public final class FlowableMaterialize$MaterializeSubscriber
extends SinglePostCompleteSubscriber {
    private static final long serialVersionUID = -3740826063558713822L;

    public FlowableMaterialize$MaterializeSubscriber(d d10) {
        super(d10);
    }

    public void onComplete() {
        y y10 = y.a();
        this.complete(y10);
    }

    public void onDrop(y object) {
        boolean bl2 = ((y)object).g();
        if (bl2) {
            object = ((y)object).d();
            a.Y((Throwable)object);
        }
    }

    public void onError(Throwable object) {
        object = y.b((Throwable)object);
        this.complete(object);
    }

    public void onNext(Object object) {
        long l10;
        this.produced = l10 = this.produced + 1L;
        d d10 = this.downstream;
        object = y.c(object);
        d10.onNext(object);
    }
}

