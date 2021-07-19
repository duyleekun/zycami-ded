/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.e1.b;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary$WindowBoundaryMainSubscriber;

public final class FlowableWindowBoundary$a
extends b {
    public final FlowableWindowBoundary$WindowBoundaryMainSubscriber b;
    public boolean c;

    public FlowableWindowBoundary$a(FlowableWindowBoundary$WindowBoundaryMainSubscriber flowableWindowBoundary$WindowBoundaryMainSubscriber) {
        this.b = flowableWindowBoundary$WindowBoundaryMainSubscriber;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.b.innerComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.b.innerError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.b.innerNext();
    }
}

