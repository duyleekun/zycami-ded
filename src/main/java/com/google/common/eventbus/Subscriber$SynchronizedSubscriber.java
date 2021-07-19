/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscriber;
import com.google.common.eventbus.Subscriber$1;
import java.lang.reflect.Method;

public final class Subscriber$SynchronizedSubscriber
extends Subscriber {
    private Subscriber$SynchronizedSubscriber(EventBus eventBus, Object object, Method method) {
        super(eventBus, object, method, null);
    }

    public /* synthetic */ Subscriber$SynchronizedSubscriber(EventBus eventBus, Object object, Method method, Subscriber$1 subscriber$1) {
        this(eventBus, object, method);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invokeSubscriberMethod(Object object) {
        synchronized (this) {
            super.invokeSubscriberMethod(object);
            return;
        }
    }
}

