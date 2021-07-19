/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.d;
import i.g.e;

public final class FlowableConcatMap$c
implements e {
    public final d a;
    public final Object b;
    public boolean c;

    public FlowableConcatMap$c(Object object, d d10) {
        this.b = object;
        this.a = d10;
    }

    public void cancel() {
    }

    public void request(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0 && (object = (Object)this.c) == false) {
            object = 1;
            this.c = object;
            d d10 = this.a;
            Object object2 = this.b;
            d10.onNext(object2);
            d10.onComplete();
        }
    }
}

