/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import i.g.d;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class r0
extends j {
    public static final j b;

    static {
        r0 r02 = new r0();
        b = r02;
    }

    private r0() {
    }

    public void m6(d d10) {
        EmptySubscription emptySubscription = EmptySubscription.INSTANCE;
        d10.onSubscribe(emptySubscription);
    }
}

