/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet$Event;
import com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent;
import com.google.android.exoplayer2.util.ListenerSet$ListenerHolder;
import com.google.common.base.Supplier;
import d.h.a.a.r0.a;
import d.h.a.a.r0.b;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ListenerSet {
    private static final int MSG_ITERATION_FINISHED = 0;
    private static final int MSG_LAZY_RELEASE = 1;
    private final Clock clock;
    private final Supplier eventFlagsSupplier;
    private final ArrayDeque flushingEvents;
    private final HandlerWrapper handler;
    private final ListenerSet$IterationFinishedEvent iterationFinishedEvent;
    private final CopyOnWriteArraySet listeners;
    private final ArrayDeque queuedEvents;
    private boolean released;

    public ListenerSet(Looper looper, Clock clock, Supplier supplier, ListenerSet$IterationFinishedEvent listenerSet$IterationFinishedEvent) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this(copyOnWriteArraySet, looper, clock, supplier, listenerSet$IterationFinishedEvent);
    }

    private ListenerSet(CopyOnWriteArraySet object, Looper looper, Clock clock, Supplier supplier, ListenerSet$IterationFinishedEvent listenerSet$IterationFinishedEvent) {
        this.clock = clock;
        this.listeners = object;
        this.eventFlagsSupplier = supplier;
        this.iterationFinishedEvent = listenerSet$IterationFinishedEvent;
        this.flushingEvents = object;
        super();
        this.queuedEvents = object;
        object = new b(this);
        this.handler = object = clock.createHandler(looper, (Handler.Callback)object);
    }

    public static /* synthetic */ boolean a(ListenerSet listenerSet, Message message) {
        return listenerSet.handleMessage(message);
    }

    public static /* synthetic */ void b(CopyOnWriteArraySet object, int n10, ListenerSet$Event listenerSet$Event) {
        boolean bl2;
        object = ((CopyOnWriteArraySet)object).iterator();
        while (bl2 = object.hasNext()) {
            ListenerSet$ListenerHolder listenerSet$ListenerHolder = (ListenerSet$ListenerHolder)object.next();
            listenerSet$ListenerHolder.invoke(n10, listenerSet$Event);
        }
    }

    private boolean handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 == 0) {
            object = this.listeners.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Object object2 = (ListenerSet$ListenerHolder)object.next();
                Supplier supplier = this.eventFlagsSupplier;
                ListenerSet$IterationFinishedEvent listenerSet$IterationFinishedEvent = this.iterationFinishedEvent;
                ((ListenerSet$ListenerHolder)object2).iterationFinished(supplier, listenerSet$IterationFinishedEvent);
                object2 = this.handler;
                supplier = null;
                n10 = (int)(object2.hasMessages(0) ? 1 : 0);
                if (n10 == 0) continue;
                break;
            }
        } else if (n10 == n11) {
            n10 = ((Message)object).arg1;
            object = (ListenerSet$Event)((Message)object).obj;
            this.sendEvent(n10, (ListenerSet$Event)object);
            this.release();
        }
        return n11 != 0;
    }

    public void add(Object object) {
        boolean bl2 = this.released;
        if (bl2) {
            return;
        }
        Assertions.checkNotNull(object);
        CopyOnWriteArraySet copyOnWriteArraySet = this.listeners;
        Supplier supplier = this.eventFlagsSupplier;
        ListenerSet$ListenerHolder listenerSet$ListenerHolder = new ListenerSet$ListenerHolder(object, supplier);
        copyOnWriteArraySet.add(listenerSet$ListenerHolder);
    }

    public ListenerSet copy(Looper looper, ListenerSet$IterationFinishedEvent listenerSet$IterationFinishedEvent) {
        CopyOnWriteArraySet copyOnWriteArraySet = this.listeners;
        Clock clock = this.clock;
        Supplier supplier = this.eventFlagsSupplier;
        ListenerSet listenerSet = new ListenerSet(copyOnWriteArraySet, looper, clock, supplier, listenerSet$IterationFinishedEvent);
        return listenerSet;
    }

    public void flushEvents() {
        Object object = this.queuedEvents;
        boolean bl2 = ((ArrayDeque)object).isEmpty();
        if (bl2) {
            return;
        }
        object = this.handler;
        ArrayDeque arrayDeque = null;
        bl2 = object.hasMessages(0);
        if (!bl2) {
            object = this.handler.obtainMessage(0);
            object.sendToTarget();
        }
        object = this.flushingEvents;
        bl2 = ((ArrayDeque)object).isEmpty() ^ true;
        arrayDeque = this.flushingEvents;
        ArrayDeque arrayDeque2 = this.queuedEvents;
        arrayDeque.addAll(arrayDeque2);
        arrayDeque = this.queuedEvents;
        arrayDeque.clear();
        if (bl2) {
            return;
        }
        while (!(bl2 = ((ArrayDeque)(object = this.flushingEvents)).isEmpty())) {
            ((Runnable)this.flushingEvents.peekFirst()).run();
            object = this.flushingEvents;
            ((ArrayDeque)object).removeFirst();
        }
    }

    public void lazyRelease(int n10, ListenerSet$Event listenerSet$Event) {
        this.handler.obtainMessage(1, n10, 0, listenerSet$Event).sendToTarget();
    }

    public void queueEvent(int n10, ListenerSet$Event listenerSet$Event) {
        AbstractCollection abstractCollection = this.listeners;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(abstractCollection);
        abstractCollection = this.queuedEvents;
        a a10 = new a(copyOnWriteArraySet, n10, listenerSet$Event);
        ((ArrayDeque)abstractCollection).add(a10);
    }

    public void release() {
        boolean bl2;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            ListenerSet$ListenerHolder listenerSet$ListenerHolder = (ListenerSet$ListenerHolder)iterator2.next();
            ListenerSet$IterationFinishedEvent listenerSet$IterationFinishedEvent = this.iterationFinishedEvent;
            listenerSet$ListenerHolder.release(listenerSet$IterationFinishedEvent);
        }
        this.listeners.clear();
        this.released = true;
    }

    public void remove(Object object) {
        boolean bl2;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            ListenerSet$ListenerHolder listenerSet$ListenerHolder = (ListenerSet$ListenerHolder)iterator2.next();
            Object object2 = listenerSet$ListenerHolder.listener;
            boolean bl3 = object2.equals(object);
            if (!bl3) continue;
            object2 = this.iterationFinishedEvent;
            listenerSet$ListenerHolder.release((ListenerSet$IterationFinishedEvent)object2);
            object2 = this.listeners;
            ((CopyOnWriteArraySet)object2).remove(listenerSet$ListenerHolder);
        }
    }

    public void sendEvent(int n10, ListenerSet$Event listenerSet$Event) {
        this.queueEvent(n10, listenerSet$Event);
        this.flushEvents();
    }
}

