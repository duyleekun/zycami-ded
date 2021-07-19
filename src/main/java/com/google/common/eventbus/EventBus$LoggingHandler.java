/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class EventBus$LoggingHandler
implements SubscriberExceptionHandler {
    public static final EventBus$LoggingHandler INSTANCE;

    static {
        EventBus$LoggingHandler eventBus$LoggingHandler;
        INSTANCE = eventBus$LoggingHandler = new EventBus$LoggingHandler();
    }

    private static Logger logger(SubscriberExceptionContext object) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = EventBus.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append(".");
        object = ((SubscriberExceptionContext)object).getEventBus().identifier();
        stringBuilder.append((String)object);
        return Logger.getLogger(stringBuilder.toString());
    }

    private static String message(SubscriberExceptionContext object) {
        Object object2 = ((SubscriberExceptionContext)object).getSubscriberMethod();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception thrown by subscriber method ");
        String string2 = ((Method)object2).getName();
        stringBuilder.append(string2);
        stringBuilder.append('(');
        object2 = ((Method)object2).getParameterTypes()[0].getName();
        stringBuilder.append((String)object2);
        stringBuilder.append(')');
        stringBuilder.append(" on subscriber ");
        object2 = ((SubscriberExceptionContext)object).getSubscriber();
        stringBuilder.append(object2);
        stringBuilder.append(" when dispatching event: ");
        object = ((SubscriberExceptionContext)object).getEvent();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    public void handleException(Throwable throwable, SubscriberExceptionContext object) {
        Level level;
        Logger logger = EventBus$LoggingHandler.logger((SubscriberExceptionContext)object);
        boolean bl2 = logger.isLoggable(level = Level.SEVERE);
        if (bl2) {
            object = EventBus$LoggingHandler.message((SubscriberExceptionContext)object);
            logger.log(level, (String)object, throwable);
        }
    }
}

