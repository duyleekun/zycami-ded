/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.Dispatcher;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.EventBus$LoggingHandler;
import com.google.common.eventbus.SubscriberExceptionHandler;
import java.util.concurrent.Executor;

public class AsyncEventBus
extends EventBus {
    public AsyncEventBus(String string2, Executor executor) {
        Dispatcher dispatcher = Dispatcher.legacyAsync();
        EventBus$LoggingHandler eventBus$LoggingHandler = EventBus$LoggingHandler.INSTANCE;
        super(string2, executor, dispatcher, eventBus$LoggingHandler);
    }

    public AsyncEventBus(Executor executor) {
        Dispatcher dispatcher = Dispatcher.legacyAsync();
        EventBus$LoggingHandler eventBus$LoggingHandler = EventBus$LoggingHandler.INSTANCE;
        super("default", executor, dispatcher, eventBus$LoggingHandler);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        Dispatcher dispatcher = Dispatcher.legacyAsync();
        super("default", executor, dispatcher, subscriberExceptionHandler);
    }
}

