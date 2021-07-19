/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.Dispatcher$1;
import com.google.common.eventbus.Subscriber;

public final class Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber {
    private final Object event;
    private final Subscriber subscriber;

    private Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber(Object object, Subscriber subscriber) {
        this.event = object;
        this.subscriber = subscriber;
    }

    public /* synthetic */ Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber(Object object, Subscriber subscriber, Dispatcher$1 dispatcher$1) {
        this(object, subscriber);
    }

    public static /* synthetic */ Object access$700(Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber dispatcher$LegacyAsyncDispatcher$EventWithSubscriber) {
        return dispatcher$LegacyAsyncDispatcher$EventWithSubscriber.event;
    }

    public static /* synthetic */ Subscriber access$800(Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber dispatcher$LegacyAsyncDispatcher$EventWithSubscriber) {
        return dispatcher$LegacyAsyncDispatcher$EventWithSubscriber.subscriber;
    }
}

