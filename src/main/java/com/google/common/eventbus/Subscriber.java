/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscriber$1;
import com.google.common.eventbus.Subscriber$SynchronizedSubscriber;
import com.google.common.eventbus.SubscriberExceptionContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

public class Subscriber {
    private EventBus bus;
    private final Executor executor;
    private final Method method;
    public final Object target;

    private Subscriber(EventBus object, Object object2, Method method) {
        this.bus = object;
        this.target = object2 = Preconditions.checkNotNull(object2);
        this.method = method;
        method.setAccessible(true);
        this.executor = object = ((EventBus)object).executor();
    }

    public /* synthetic */ Subscriber(EventBus eventBus, Object object, Method method, Subscriber$1 subscriber$1) {
        this(eventBus, object, method);
    }

    public static /* synthetic */ SubscriberExceptionContext access$100(Subscriber subscriber, Object object) {
        return subscriber.context(object);
    }

    public static /* synthetic */ EventBus access$200(Subscriber subscriber) {
        return subscriber.bus;
    }

    private SubscriberExceptionContext context(Object object) {
        EventBus eventBus = this.bus;
        Object object2 = this.target;
        Method method = this.method;
        SubscriberExceptionContext subscriberExceptionContext = new SubscriberExceptionContext(eventBus, object, object2, method);
        return subscriberExceptionContext;
    }

    public static Subscriber create(EventBus eventBus, Object object, Method method) {
        boolean bl2 = Subscriber.isDeclaredThreadSafe(method);
        Subscriber subscriber = bl2 ? new Subscriber(eventBus, object, method) : new Subscriber$SynchronizedSubscriber(eventBus, object, method, null);
        return subscriber;
    }

    private static boolean isDeclaredThreadSafe(Method object) {
        boolean bl2;
        Class<AllowConcurrentEvents> clazz = AllowConcurrentEvents.class;
        if ((object = ((Method)object).getAnnotation(clazz)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public final void dispatchEvent(Object object) {
        Executor executor = this.executor;
        Subscriber$1 subscriber$1 = new Subscriber$1(this, object);
        executor.execute(subscriber$1);
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof Subscriber;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Subscriber)object;
            Object object2 = this.target;
            Object object3 = ((Subscriber)object).target;
            if (object2 == object3 && (bl4 = ((Method)(object2 = this.method)).equals(object = ((Subscriber)object).method))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public final int hashCode() {
        int n10 = (this.method.hashCode() + 31) * 31;
        int n11 = System.identityHashCode(this.target);
        return n10 + n11;
    }

    public void invokeSubscriberMethod(Object object) {
        Object object2 = this.method;
        Object object3 = this.target;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        Object object4 = Preconditions.checkNotNull(object);
        objectArray[0] = object4;
        try {
            ((Method)object2).invoke(object3, objectArray);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = invocationTargetException.getCause();
            boolean bl2 = object2 instanceof Error;
            if (bl2) {
                throw (Error)invocationTargetException.getCause();
            }
            throw invocationTargetException;
        }
        catch (IllegalAccessException illegalAccessException) {
            objectArray = new StringBuilder();
            objectArray.append("Method became inaccessible: ");
            objectArray.append(object);
            object = objectArray.toString();
            object3 = new Error((String)object, illegalAccessException);
            throw object3;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            objectArray = new StringBuilder();
            objectArray.append("Method rejected target/argument: ");
            objectArray.append(object);
            object = objectArray.toString();
            object3 = new Error((String)object, illegalArgumentException);
            throw object3;
        }
    }
}

