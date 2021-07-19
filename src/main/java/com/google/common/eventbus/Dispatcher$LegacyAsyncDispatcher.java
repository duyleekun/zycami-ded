/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.common.eventbus.Dispatcher;
import com.google.common.eventbus.Dispatcher$1;
import com.google.common.eventbus.Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber;
import com.google.common.eventbus.Subscriber;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class Dispatcher$LegacyAsyncDispatcher
extends Dispatcher {
    private final ConcurrentLinkedQueue queue;

    private Dispatcher$LegacyAsyncDispatcher() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        this.queue = concurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
    }

    public /* synthetic */ Dispatcher$LegacyAsyncDispatcher(Dispatcher$1 dispatcher$1) {
        this();
    }

    public void dispatch(Object object, Iterator object2) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        while (bl2 = object2.hasNext()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.queue;
            Subscriber subscriber = (Subscriber)object2.next();
            Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber dispatcher$LegacyAsyncDispatcher$EventWithSubscriber = new Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber(object, subscriber, null);
            concurrentLinkedQueue.add(dispatcher$LegacyAsyncDispatcher$EventWithSubscriber);
        }
        while ((object = (Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber)this.queue.poll()) != null) {
            object2 = Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber.access$800((Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber)object);
            object = Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber.access$700((Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber)object);
            ((Subscriber)object2).dispatchEvent(object);
        }
    }
}

