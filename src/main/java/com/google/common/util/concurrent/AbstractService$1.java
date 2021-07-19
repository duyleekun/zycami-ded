/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Event;
import com.google.common.util.concurrent.Service$Listener;

public final class AbstractService$1
implements ListenerCallQueue$Event {
    public void call(Service$Listener service$Listener) {
        service$Listener.starting();
    }

    public String toString() {
        return "starting()";
    }
}

