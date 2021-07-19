/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter;

public final class FlowableCreate$MissingEmitter
extends FlowableCreate$BaseEmitter {
    private static final long serialVersionUID = 3776720187248809713L;

    public FlowableCreate$MissingEmitter(d d10) {
        super(d10);
    }

    public void onNext(Object object) {
        boolean bl2 = this.isCancelled();
        if (bl2) {
            return;
        }
        if (object != null) {
            long l10;
            long l11;
            long l12;
            long l13;
            d d10 = this.downstream;
            d10.onNext(object);
            while ((l13 = (l12 = (l11 = this.get()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false && (l13 = (long)this.compareAndSet(l11, l10 = l11 - 1L)) == false) {
            }
            return;
        }
        object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.onError((Throwable)object);
    }
}

