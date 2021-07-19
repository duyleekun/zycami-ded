/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.j;
import e.a.w;
import e.a.w0.c.f;
import i.g.d;
import io.reactivex.internal.operators.maybe.MaybeToFlowable$MaybeToFlowableSubscriber;

public final class MaybeToFlowable
extends j
implements f {
    public final w b;

    public MaybeToFlowable(w w10) {
        this.b = w10;
    }

    public void m6(d d10) {
        w w10 = this.b;
        MaybeToFlowable$MaybeToFlowableSubscriber maybeToFlowable$MaybeToFlowableSubscriber = new MaybeToFlowable$MaybeToFlowableSubscriber(d10);
        w10.g(maybeToFlowable$MaybeToFlowableSubscriber);
    }

    public w source() {
        return this.b;
    }
}

