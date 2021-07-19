/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscriber;
import com.google.common.eventbus.SubscriberExceptionContext;
import java.lang.reflect.InvocationTargetException;

public class Subscriber$1
implements Runnable {
    public final /* synthetic */ Subscriber this$0;
    public final /* synthetic */ Object val$event;

    public Subscriber$1(Subscriber subscriber, Object object) {
        this.this$0 = subscriber;
        this.val$event = object;
    }

    public void run() {
        Subscriber subscriber = this.this$0;
        Object object = this.val$event;
        try {
            subscriber.invokeSubscriberMethod(object);
        }
        catch (InvocationTargetException invocationTargetException) {
            object = Subscriber.access$200(this.this$0);
            Throwable throwable = invocationTargetException.getCause();
            Object object2 = this.this$0;
            Object object3 = this.val$event;
            object2 = Subscriber.access$100((Subscriber)object2, object3);
            ((EventBus)object).handleSubscriberException(throwable, (SubscriberExceptionContext)object2);
        }
    }
}

