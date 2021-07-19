/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher;

public class Dispatcher$PerThreadQueuedDispatcher$2
extends ThreadLocal {
    public final /* synthetic */ Dispatcher$PerThreadQueuedDispatcher this$0;

    public Dispatcher$PerThreadQueuedDispatcher$2(Dispatcher$PerThreadQueuedDispatcher dispatcher$PerThreadQueuedDispatcher) {
        this.this$0 = dispatcher$PerThreadQueuedDispatcher;
    }

    public Boolean initialValue() {
        return Boolean.FALSE;
    }
}

