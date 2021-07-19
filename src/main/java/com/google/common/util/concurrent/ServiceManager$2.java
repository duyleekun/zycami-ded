/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue$Event;
import com.google.common.util.concurrent.ServiceManager$Listener;

public final class ServiceManager$2
implements ListenerCallQueue$Event {
    public void call(ServiceManager$Listener serviceManager$Listener) {
        serviceManager$Listener.stopped();
    }

    public String toString() {
        return "stopped()";
    }
}

