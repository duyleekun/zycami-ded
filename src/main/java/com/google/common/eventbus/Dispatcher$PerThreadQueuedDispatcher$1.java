/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.collect.Queues;
import com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher;
import java.util.Queue;

public class Dispatcher$PerThreadQueuedDispatcher$1
extends ThreadLocal {
    public final /* synthetic */ Dispatcher.PerThreadQueuedDispatcher this$0;

    public Dispatcher$PerThreadQueuedDispatcher$1(Dispatcher.PerThreadQueuedDispatcher perThreadQueuedDispatcher) {
        this.this$0 = perThreadQueuedDispatcher;
    }

    public Queue initialValue() {
        return Queues.newArrayDeque();
    }
}

