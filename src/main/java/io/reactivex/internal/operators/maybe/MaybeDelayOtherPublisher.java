/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import i.g.c;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher$a;

public final class MaybeDelayOtherPublisher
extends a {
    public final c b;

    public MaybeDelayOtherPublisher(w w10, c c10) {
        super(w10);
        this.b = c10;
    }

    public void t1(t t10) {
        w w10 = this.a;
        c c10 = this.b;
        MaybeDelayOtherPublisher$a maybeDelayOtherPublisher$a = new MaybeDelayOtherPublisher$a(t10, c10);
        w10.g(maybeDelayOtherPublisher$a);
    }
}

