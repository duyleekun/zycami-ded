/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import i.g.c;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher$a;

public final class MaybeDelaySubscriptionOtherPublisher
extends a {
    public final c b;

    public MaybeDelaySubscriptionOtherPublisher(w w10, c c10) {
        super(w10);
        this.b = c10;
    }

    public void t1(t t10) {
        c c10 = this.b;
        w w10 = this.a;
        MaybeDelaySubscriptionOtherPublisher$a maybeDelaySubscriptionOtherPublisher$a = new MaybeDelaySubscriptionOtherPublisher$a(t10, w10);
        c10.subscribe(maybeDelaySubscriptionOtherPublisher$a);
    }
}

