/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport;

import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Priority;

public abstract class Event {
    public static Event ofData(int n10, Object object) {
        Integer n11 = n10;
        Priority priority = Priority.DEFAULT;
        AutoValue_Event autoValue_Event = new AutoValue_Event(n11, object, priority);
        return autoValue_Event;
    }

    public static Event ofData(Object object) {
        Priority priority = Priority.DEFAULT;
        AutoValue_Event autoValue_Event = new AutoValue_Event(null, object, priority);
        return autoValue_Event;
    }

    public static Event ofTelemetry(int n10, Object object) {
        Integer n11 = n10;
        Priority priority = Priority.VERY_LOW;
        AutoValue_Event autoValue_Event = new AutoValue_Event(n11, object, priority);
        return autoValue_Event;
    }

    public static Event ofTelemetry(Object object) {
        Priority priority = Priority.VERY_LOW;
        AutoValue_Event autoValue_Event = new AutoValue_Event(null, object, priority);
        return autoValue_Event;
    }

    public static Event ofUrgent(int n10, Object object) {
        Integer n11 = n10;
        Priority priority = Priority.HIGHEST;
        AutoValue_Event autoValue_Event = new AutoValue_Event(n11, object, priority);
        return autoValue_Event;
    }

    public static Event ofUrgent(Object object) {
        Priority priority = Priority.HIGHEST;
        AutoValue_Event autoValue_Event = new AutoValue_Event(null, object, priority);
        return autoValue_Event;
    }

    public abstract Integer getCode();

    public abstract Object getPayload();

    public abstract Priority getPriority();
}

