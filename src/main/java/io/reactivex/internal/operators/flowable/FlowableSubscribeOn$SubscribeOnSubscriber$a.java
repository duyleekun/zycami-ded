/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.e;

public final class FlowableSubscribeOn$SubscribeOnSubscriber$a
implements Runnable {
    public final e a;
    public final long b;

    public FlowableSubscribeOn$SubscribeOnSubscriber$a(e e10, long l10) {
        this.a = e10;
        this.b = l10;
    }

    public void run() {
        e e10 = this.a;
        long l10 = this.b;
        e10.request(l10);
    }
}

