/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.g;
import e.a.q;
import e.a.t;
import e.a.w;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable$OtherObserver;

public final class MaybeDelayWithCompletable
extends q {
    public final w a;
    public final g b;

    public MaybeDelayWithCompletable(w w10, g g10) {
        this.a = w10;
        this.b = g10;
    }

    public void t1(t t10) {
        g g10 = this.b;
        w w10 = this.a;
        MaybeDelayWithCompletable$OtherObserver maybeDelayWithCompletable$OtherObserver = new MaybeDelayWithCompletable$OtherObserver(t10, w10);
        g10.f(maybeDelayWithCompletable$OtherObserver);
    }
}

