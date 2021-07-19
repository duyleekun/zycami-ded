/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.EventBus;
import com.google.firebase.events.Event;
import java.util.Map;

public final class EventBus$$Lambda$1
implements Runnable {
    private final Map.Entry arg$1;
    private final Event arg$2;

    private EventBus$$Lambda$1(Map.Entry entry, Event event) {
        this.arg$1 = entry;
        this.arg$2 = event;
    }

    public static Runnable lambdaFactory$(Map.Entry entry, Event event) {
        EventBus$$Lambda$1 eventBus$$Lambda$1 = new EventBus$$Lambda$1(entry, event);
        return eventBus$$Lambda$1;
    }

    public void run() {
        Map.Entry entry = this.arg$1;
        Event event = this.arg$2;
        EventBus.lambda$publish$0(entry, event);
    }
}

