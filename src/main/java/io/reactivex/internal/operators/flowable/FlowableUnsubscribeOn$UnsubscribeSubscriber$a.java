/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn$UnsubscribeSubscriber;

public final class FlowableUnsubscribeOn$UnsubscribeSubscriber$a
implements Runnable {
    public final /* synthetic */ FlowableUnsubscribeOn$UnsubscribeSubscriber a;

    public FlowableUnsubscribeOn$UnsubscribeSubscriber$a(FlowableUnsubscribeOn$UnsubscribeSubscriber unsubscribeSubscriber) {
        this.a = unsubscribeSubscriber;
    }

    public void run() {
        this.a.upstream.cancel();
    }
}

