/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.Dispatcher;
import com.google.common.eventbus.Subscriber;
import java.util.Iterator;

public final class Dispatcher$ImmediateDispatcher
extends Dispatcher {
    private static final Dispatcher$ImmediateDispatcher INSTANCE;

    static {
        Dispatcher$ImmediateDispatcher dispatcher$ImmediateDispatcher;
        INSTANCE = dispatcher$ImmediateDispatcher = new Dispatcher$ImmediateDispatcher();
    }

    private Dispatcher$ImmediateDispatcher() {
    }

    public static /* synthetic */ Dispatcher$ImmediateDispatcher access$200() {
        return INSTANCE;
    }

    public void dispatch(Object object, Iterator iterator2) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        while (bl2 = iterator2.hasNext()) {
            Subscriber subscriber = (Subscriber)iterator2.next();
            subscriber.dispatchEvent(object);
        }
    }
}

