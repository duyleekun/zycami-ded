/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.events;

import com.google.firebase.events.EventHandler;
import java.util.concurrent.Executor;

public interface Subscriber {
    public void subscribe(Class var1, EventHandler var2);

    public void subscribe(Class var1, Executor var2, EventHandler var3);

    public void unsubscribe(Class var1, EventHandler var2);
}

