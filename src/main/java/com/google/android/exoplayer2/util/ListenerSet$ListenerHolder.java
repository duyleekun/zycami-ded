/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.ListenerSet$Event;
import com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent;
import com.google.android.exoplayer2.util.MutableFlags;
import com.google.common.base.Supplier;

public final class ListenerSet$ListenerHolder {
    private MutableFlags eventsFlags;
    public final Object listener;
    private boolean needsIterationFinishedEvent;
    private boolean released;

    public ListenerSet$ListenerHolder(Object object, Supplier supplier) {
        this.listener = object;
        this.eventsFlags = object = (MutableFlags)supplier.get();
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = ListenerSet$ListenerHolder.class) == (clazz = object.getClass())) {
            object2 = this.listener;
            object = ((ListenerSet$ListenerHolder)object).listener;
            return object2.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.listener.hashCode();
    }

    public void invoke(int n10, ListenerSet$Event listenerSet$Event) {
        int n11 = this.released;
        if (n11 == 0) {
            n11 = -1;
            if (n10 != n11) {
                MutableFlags mutableFlags = this.eventsFlags;
                mutableFlags.add(n10);
            }
            n10 = 1;
            this.needsIterationFinishedEvent = n10;
            Object object = this.listener;
            listenerSet$Event.invoke(object);
        }
    }

    public void iterationFinished(Supplier object, ListenerSet$IterationFinishedEvent listenerSet$IterationFinishedEvent) {
        boolean bl2 = this.released;
        if (!bl2 && (bl2 = this.needsIterationFinishedEvent)) {
            MutableFlags mutableFlags = this.eventsFlags;
            this.eventsFlags = object = (MutableFlags)object.get();
            this.needsIterationFinishedEvent = false;
            object = this.listener;
            listenerSet$IterationFinishedEvent.invoke(object, mutableFlags);
        }
    }

    public void release(ListenerSet$IterationFinishedEvent listenerSet$IterationFinishedEvent) {
        this.released = true;
        boolean bl2 = this.needsIterationFinishedEvent;
        if (bl2) {
            Object object = this.listener;
            MutableFlags mutableFlags = this.eventsFlags;
            listenerSet$IterationFinishedEvent.invoke(object, mutableFlags);
        }
    }
}

