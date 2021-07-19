/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.EventBus$$Lambda$1;
import com.google.firebase.components.Preconditions;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.Collections;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class EventBus
implements Subscriber,
Publisher {
    private final Executor defaultExecutor;
    private final Map handlerMap;
    private Queue pendingEvents;

    public EventBus(Executor executor) {
        Cloneable cloneable;
        this.handlerMap = cloneable = new Cloneable();
        this.pendingEvents = cloneable;
        this.defaultExecutor = executor;
    }

    private Set getHandlers(Event set) {
        synchronized (this) {
            block9: {
                Map map = this.handlerMap;
                set = ((Event)((Object)set)).getType();
                set = map.get(set);
                set = (Map)((Object)set);
                if (set != null) break block9;
                set = Collections.emptySet();
            }
            set = set.entrySet();
            return set;
            finally {
            }
        }
    }

    public static /* synthetic */ void lambda$publish$0(Map.Entry entry, Event event) {
        ((EventHandler)entry.getKey()).handle(event);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void enablePublishingAndFlushPending() {
        Event event;
        boolean bl2;
        Object object;
        synchronized (this) {
            object = this.pendingEvents;
            bl2 = false;
            event = null;
            if (object == null) return;
            this.pendingEvents = null;
        }
        if (object == null) return;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            event = (Event)object.next();
            this.publish(event);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void publish(Event event) {
        Object object;
        Preconditions.checkNotNull(event);
        synchronized (this) {
            object = this.pendingEvents;
            if (object != null) {
                object.add(event);
                return;
            }
        }
        object = this.getHandlers(event).iterator();
        boolean bl2;
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Executor executor = (Executor)object2.getValue();
            object2 = EventBus$$Lambda$1.lambdaFactory$((Map.Entry)object2, event);
            executor.execute((Runnable)object2);
        }
        return;
    }

    public void subscribe(Class clazz, EventHandler eventHandler) {
        Executor executor = this.defaultExecutor;
        this.subscribe(clazz, executor, eventHandler);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void subscribe(Class serializable, Executor executor, EventHandler eventHandler) {
        synchronized (this) {
            void var2_2;
            void var3_3;
            Preconditions.checkNotNull(serializable);
            Preconditions.checkNotNull(var3_3);
            Preconditions.checkNotNull(var2_2);
            Map map = this.handlerMap;
            boolean bl2 = map.containsKey(serializable);
            if (!bl2) {
                map = this.handlerMap;
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                map.put(serializable, concurrentHashMap);
            }
            map = this.handlerMap;
            serializable = map.get(serializable);
            serializable = (ConcurrentHashMap)serializable;
            ((ConcurrentHashMap)serializable).put(var3_3, var2_2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unsubscribe(Class clazz, EventHandler object) {
        synchronized (this) {
            Map map;
            Preconditions.checkNotNull(clazz);
            Preconditions.checkNotNull(map);
            Map map2 = this.handlerMap;
            boolean bl2 = map2.containsKey(clazz);
            if (!bl2) {
                return;
            }
            map2 = this.handlerMap;
            map2 = map2.get(clazz);
            map2 = (ConcurrentHashMap)map2;
            ((ConcurrentHashMap)map2).remove(map);
            boolean bl3 = ((ConcurrentHashMap)map2).isEmpty();
            if (bl3) {
                map = this.handlerMap;
                map.remove(clazz);
            }
            return;
        }
    }
}

