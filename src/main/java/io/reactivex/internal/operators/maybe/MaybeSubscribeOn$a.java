/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;

public final class MaybeSubscribeOn$a
implements Runnable {
    public final t a;
    public final w b;

    public MaybeSubscribeOn$a(t t10, w w10) {
        this.a = t10;
        this.b = w10;
    }

    public void run() {
        w w10 = this.b;
        t t10 = this.a;
        w10.g(t10);
    }
}

