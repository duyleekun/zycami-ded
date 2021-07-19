/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.Dispatcher$ImmediateDispatcher;
import com.google.common.eventbus.Dispatcher$LegacyAsyncDispatcher;
import com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher;
import java.util.Iterator;

public abstract class Dispatcher {
    public static Dispatcher immediate() {
        return Dispatcher$ImmediateDispatcher.access$200();
    }

    public static Dispatcher legacyAsync() {
        Dispatcher$LegacyAsyncDispatcher dispatcher$LegacyAsyncDispatcher = new Dispatcher$LegacyAsyncDispatcher(null);
        return dispatcher$LegacyAsyncDispatcher;
    }

    public static Dispatcher perThreadDispatchQueue() {
        Dispatcher$PerThreadQueuedDispatcher dispatcher$PerThreadQueuedDispatcher = new Dispatcher$PerThreadQueuedDispatcher(null);
        return dispatcher$PerThreadQueuedDispatcher;
    }

    public abstract void dispatch(Object var1, Iterator var2);
}

