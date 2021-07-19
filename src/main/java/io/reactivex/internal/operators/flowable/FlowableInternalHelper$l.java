/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.g;
import i.g.d;

public final class FlowableInternalHelper$l
implements g {
    public final d a;

    public FlowableInternalHelper$l(d d10) {
        this.a = d10;
    }

    public void a(Throwable throwable) {
        this.a.onError(throwable);
    }
}

