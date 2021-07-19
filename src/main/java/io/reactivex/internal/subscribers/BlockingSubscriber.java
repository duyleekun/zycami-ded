/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.o;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingSubscriber
extends AtomicReference
implements o,
e {
    public static final Object TERMINATED;
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue queue;

    static {
        Object object;
        TERMINATED = object = new Object();
    }

    public BlockingSubscriber(Queue queue) {
        this.queue = queue;
    }

    public void cancel() {
        boolean bl2 = SubscriptionHelper.cancel(this);
        if (bl2) {
            Queue queue = this.queue;
            Object object = TERMINATED;
            queue.offer(object);
        }
    }

    public boolean isCancelled() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        Queue queue = this.queue;
        Object object = NotificationLite.complete();
        queue.offer(object);
    }

    public void onError(Throwable object) {
        Queue queue = this.queue;
        object = NotificationLite.error((Throwable)object);
        queue.offer(object);
    }

    public void onNext(Object object) {
        Queue queue = this.queue;
        object = NotificationLite.next(object);
        queue.offer(object);
    }

    public void onSubscribe(e object) {
        boolean bl2 = SubscriptionHelper.setOnce(this, (e)object);
        if (bl2) {
            object = this.queue;
            Object object2 = NotificationLite.subscription(this);
            object.offer(object2);
        }
    }

    public void request(long l10) {
        ((e)this.get()).request(l10);
    }
}

