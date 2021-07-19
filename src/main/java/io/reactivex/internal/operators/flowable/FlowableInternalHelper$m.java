/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.g;
import i.g.d;

public final class FlowableInternalHelper$m
implements g {
    public final d a;

    public FlowableInternalHelper$m(d d10) {
        this.a = d10;
    }

    public void accept(Object object) {
        this.a.onNext(object);
    }
}

