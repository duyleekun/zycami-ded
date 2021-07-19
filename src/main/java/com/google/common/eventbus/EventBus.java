/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Dispatcher;
import com.google.common.eventbus.EventBus$LoggingHandler;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import com.google.common.eventbus.SubscriberRegistry;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventBus {
    private static final Logger logger = Logger.getLogger(EventBus.class.getName());
    private final Dispatcher dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final SubscriberRegistry subscribers;

    public EventBus() {
        this("default");
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        Executor executor = MoreExecutors.directExecutor();
        Dispatcher dispatcher = Dispatcher.perThreadDispatchQueue();
        this("default", executor, dispatcher, subscriberExceptionHandler);
    }

    public EventBus(String string2) {
        Executor executor = MoreExecutors.directExecutor();
        Dispatcher dispatcher = Dispatcher.perThreadDispatchQueue();
        EventBus$LoggingHandler eventBus$LoggingHandler = EventBus$LoggingHandler.INSTANCE;
        this(string2, executor, dispatcher, eventBus$LoggingHandler);
    }

    public EventBus(String object, Executor executor, Dispatcher dispatcher, SubscriberExceptionHandler subscriberExceptionHandler) {
        SubscriberRegistry subscriberRegistry;
        this.subscribers = subscriberRegistry = new SubscriberRegistry(this);
        object = (String)Preconditions.checkNotNull(object);
        this.identifier = object;
        this.executor = object = (Executor)Preconditions.checkNotNull(executor);
        this.dispatcher = object = (Dispatcher)Preconditions.checkNotNull(dispatcher);
        this.exceptionHandler = object = (SubscriberExceptionHandler)Preconditions.checkNotNull(subscriberExceptionHandler);
    }

    public final Executor executor() {
        return this.executor;
    }

    public void handleSubscriberException(Throwable object, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(subscriberExceptionContext);
        Object object2 = this.exceptionHandler;
        try {
            object2.handleException((Throwable)object, subscriberExceptionContext);
        }
        catch (Throwable throwable) {
            object2 = logger;
            Level level = Level.SEVERE;
            Locale locale = Locale.ROOT;
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = throwable;
            int n11 = 1;
            objectArray[n11] = object;
            object = String.format(locale, "Exception %s thrown while handling exception: %s", objectArray);
            ((Logger)object2).log(level, (String)object, throwable);
        }
    }

    public final String identifier() {
        return this.identifier;
    }

    public void post(Object object) {
        Object object2 = this.subscribers.getSubscribers(object);
        boolean bl2 = object2.hasNext();
        if (bl2) {
            Dispatcher dispatcher = this.dispatcher;
            dispatcher.dispatch(object, (Iterator)object2);
        } else {
            boolean bl3 = object instanceof DeadEvent;
            if (!bl3) {
                object2 = new DeadEvent(this, object);
                this.post(object2);
            }
        }
    }

    public void register(Object object) {
        this.subscribers.register(object);
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        String string2 = this.identifier;
        return moreObjects$ToStringHelper.addValue(string2).toString();
    }

    public void unregister(Object object) {
        this.subscribers.unregister(object);
    }
}

