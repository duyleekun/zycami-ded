/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import java.util.Objects;

public final class AutoValue_PersistedEvent
extends PersistedEvent {
    private final EventInternal event;
    private final long id;
    private final TransportContext transportContext;

    public AutoValue_PersistedEvent(long l10, TransportContext transportContext, EventInternal eventInternal) {
        this.id = l10;
        Objects.requireNonNull(transportContext, "Null transportContext");
        this.transportContext = transportContext;
        Objects.requireNonNull(eventInternal, "Null event");
        this.event = eventInternal;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof PersistedEvent;
        if (object2) {
            boolean bl3;
            TransportContext transportContext;
            Object object3;
            long l10 = this.id;
            long l11 = ((PersistedEvent)(object = (PersistedEvent)object)).getId();
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 || !(object2 = (object3 = this.transportContext).equals(transportContext = ((PersistedEvent)object).getTransportContext())) || !(bl3 = (object3 = this.event).equals(object = ((PersistedEvent)object).getEvent()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public EventInternal getEvent() {
        return this.event;
    }

    public long getId() {
        return this.id;
    }

    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    public int hashCode() {
        long l10 = this.id;
        long l11 = l10 >>> 32;
        int n10 = (int)(l10 ^ l11);
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.transportContext.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.event.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersistedEvent{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", transportContext=");
        Object object = this.transportContext;
        stringBuilder.append(object);
        stringBuilder.append(", event=");
        object = this.event;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

