/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver
extends AtomicReference
implements g0,
b {
    public static final Object TERMINATED;
    private static final long serialVersionUID = -4875965440900746268L;
    public final Queue queue;

    static {
        Object object;
        TERMINATED = object = new Object();
    }

    public BlockingObserver(Queue queue) {
        this.queue = queue;
    }

    public void dispose() {
        boolean bl2 = DisposableHelper.dispose(this);
        if (bl2) {
            Queue queue = this.queue;
            Object object = TERMINATED;
            queue.offer(object);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
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

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

