/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.Dispatcher;
import com.google.common.eventbus.Dispatcher$1;
import com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$1;
import com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event;
import com.google.common.eventbus.Subscriber;
import java.util.Iterator;
import java.util.Queue;

public final class Dispatcher$PerThreadQueuedDispatcher
extends Dispatcher {
    private final ThreadLocal dispatching;
    private final ThreadLocal queue;

    private Dispatcher$PerThreadQueuedDispatcher() {
        ThreadLocal threadLocal = new Dispatcher$PerThreadQueuedDispatcher$1(this);
        this.queue = threadLocal;
        super(this);
        this.dispatching = threadLocal;
    }

    public /* synthetic */ Dispatcher$PerThreadQueuedDispatcher(Dispatcher$1 dispatcher$1) {
        this();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispatch(Object object, Iterator object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Queue queue = (Queue)this.queue.get();
        Object object3 = new Dispatcher$PerThreadQueuedDispatcher$Event(object, (Iterator)object2, null);
        queue.offer(object3);
        object = (Boolean)this.dispatching.get();
        boolean bl2 = (Boolean)object;
        if (bl2) return;
        object = this.dispatching;
        object2 = Boolean.TRUE;
        ((ThreadLocal)object).set(object2);
        try {
            block2: while (true) {
                object = queue.poll();
                if ((object = (Dispatcher$PerThreadQueuedDispatcher$Event)object) == null) {
                    this.dispatching.remove();
                    object = this.queue;
                    ((ThreadLocal)object).remove();
                    return;
                }
                while (true) {
                    boolean bl3;
                    if (!(bl3 = (object2 = Dispatcher$PerThreadQueuedDispatcher$Event.access$400((Dispatcher$PerThreadQueuedDispatcher$Event)object)).hasNext())) continue block2;
                    object2 = Dispatcher$PerThreadQueuedDispatcher$Event.access$400((Dispatcher$PerThreadQueuedDispatcher$Event)object);
                    object2 = object2.next();
                    object2 = (Subscriber)object2;
                    object3 = Dispatcher$PerThreadQueuedDispatcher$Event.access$500((Dispatcher$PerThreadQueuedDispatcher$Event)object);
                    ((Subscriber)object2).dispatchEvent(object3);
                }
                break;
            }
        }
        catch (Throwable throwable) {
            this.dispatching.remove();
            this.queue.remove();
            throw throwable;
        }
    }
}

