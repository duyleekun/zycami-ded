/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter;

public abstract class FlowableCreate$NoOverflowBaseAsyncEmitter
extends FlowableCreate$BaseEmitter {
    private static final long serialVersionUID = 4127754106204442833L;

    public FlowableCreate$NoOverflowBaseAsyncEmitter(d d10) {
        super(d10);
    }

    public final void onNext(Object object) {
        long l10;
        Object object2 = this.isCancelled();
        if (object2) {
            return;
        }
        if (object == null) {
            object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            this.onError((Throwable)object);
            return;
        }
        long l11 = this.get();
        long l12 = l11 - (l10 = 0L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2) {
            d d10 = this.downstream;
            d10.onNext(object);
            l11 = 1L;
            b.e(this, l11);
        } else {
            this.onOverflow();
        }
    }

    public abstract void onOverflow();
}

