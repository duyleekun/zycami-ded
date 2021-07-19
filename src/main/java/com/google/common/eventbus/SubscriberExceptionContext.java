/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;
import java.lang.reflect.Method;

public class SubscriberExceptionContext {
    private final Object event;
    private final EventBus eventBus;
    private final Object subscriber;
    private final Method subscriberMethod;

    public SubscriberExceptionContext(EventBus object, Object object2, Object object3, Method method) {
        object = (EventBus)Preconditions.checkNotNull(object);
        this.eventBus = object;
        this.event = object = Preconditions.checkNotNull(object2);
        this.subscriber = object = Preconditions.checkNotNull(object3);
        this.subscriberMethod = object = (Method)Preconditions.checkNotNull(method);
    }

    public Object getEvent() {
        return this.event;
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public Object getSubscriber() {
        return this.subscriber;
    }

    public Method getSubscriberMethod() {
        return this.subscriberMethod;
    }
}

