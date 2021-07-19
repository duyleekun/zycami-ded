/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenerCallQueue$Event;
import com.google.common.util.concurrent.ListenerCallQueue$PerListenerQueue;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public final class ListenerCallQueue {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List listeners;

    public ListenerCallQueue() {
        List list = new List();
        this.listeners = list = Collections.synchronizedList(list);
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void enqueueHelper(ListenerCallQueue$Event listenerCallQueue$Event, Object object) {
        Preconditions.checkNotNull(listenerCallQueue$Event, "event");
        Preconditions.checkNotNull(object, "label");
        List list = this.listeners;
        synchronized (list) {
            Object object2 = this.listeners;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (ListenerCallQueue$PerListenerQueue)object3;
                ((ListenerCallQueue$PerListenerQueue)object3).add(listenerCallQueue$Event, object);
            }
            return;
        }
    }

    public void addListener(Object object, Executor executor) {
        Preconditions.checkNotNull(object, "listener");
        Preconditions.checkNotNull(executor, "executor");
        List list = this.listeners;
        ListenerCallQueue$PerListenerQueue listenerCallQueue$PerListenerQueue = new ListenerCallQueue$PerListenerQueue(object, executor);
        list.add(listenerCallQueue$PerListenerQueue);
    }

    public void dispatch() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.listeners).size()); ++i10) {
            object = (ListenerCallQueue$PerListenerQueue)this.listeners.get(i10);
            ((ListenerCallQueue$PerListenerQueue)object).dispatch();
        }
    }

    public void enqueue(ListenerCallQueue$Event listenerCallQueue$Event) {
        this.enqueueHelper(listenerCallQueue$Event, listenerCallQueue$Event);
    }

    public void enqueue(ListenerCallQueue$Event listenerCallQueue$Event, String string2) {
        this.enqueueHelper(listenerCallQueue$Event, string2);
    }
}

