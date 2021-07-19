/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter;

public final class FlowableCreate$ErrorAsyncEmitter
extends FlowableCreate$NoOverflowBaseAsyncEmitter {
    private static final long serialVersionUID = 338953216916120960L;

    public FlowableCreate$ErrorAsyncEmitter(d d10) {
        super(d10);
    }

    public void onOverflow() {
        MissingBackpressureException missingBackpressureException = new MissingBackpressureException("create: could not emit value due to lack of requests");
        this.onError(missingBackpressureException);
    }
}

