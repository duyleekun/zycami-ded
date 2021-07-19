/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

public class Event {
    private final Object payload;
    private final Class type;

    public Event(Class object, Object object2) {
        object = (Class)Preconditions.checkNotNull(object);
        this.type = object;
        this.payload = object = Preconditions.checkNotNull(object2);
    }

    public Object getPayload() {
        return this.payload;
    }

    public Class getType() {
        return this.type;
    }

    public String toString() {
        Object object = this.type;
        object = this.payload;
        Object[] objectArray = new Object[]{object, object};
        return String.format("Event{type: %s, payload: %s}", objectArray);
    }
}

