/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import e.a.w0.c.l;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueSubscription
extends AtomicInteger
implements l {
    private static final long serialVersionUID = -6671519529404341862L;

    public final boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public final boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }
}

