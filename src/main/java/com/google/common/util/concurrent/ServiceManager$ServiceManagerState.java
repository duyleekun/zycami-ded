/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSetMultimap$Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.ListenerCallQueue$Event;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.ServiceManager$Listener;
import com.google.common.util.concurrent.ServiceManager$NoOpService;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$1;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$2;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$AwaitHealthGuard;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$StoppedGuard;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;

public final class ServiceManager$ServiceManagerState {
    public final Monitor$Guard awaitHealthGuard;
    public final ListenerCallQueue listeners;
    public final Monitor monitor;
    public final int numberOfServices;
    public boolean ready;
    public final SetMultimap servicesByState;
    public final Map startupTimers;
    public final Multiset states;
    public final Monitor$Guard stoppedGuard;
    public boolean transitioned;

    public ServiceManager$ServiceManagerState(ImmutableCollection immutableCollection) {
        int n10;
        Object object = new Monitor();
        this.monitor = object;
        this.servicesByState = object = MultimapBuilder.enumKeys(Service$State.class).linkedHashSetValues().build();
        Object object2 = object.keys();
        this.states = object2;
        this.startupTimers = object2 = Maps.newIdentityHashMap();
        this.awaitHealthGuard = object2 = new ServiceManager$ServiceManagerState$AwaitHealthGuard(this);
        this.stoppedGuard = object2 = new ServiceManager$ServiceManagerState$StoppedGuard(this);
        this.listeners = object2 = new ListenerCallQueue();
        this.numberOfServices = n10 = immutableCollection.size();
        object2 = Service$State.NEW;
        object.putAll(object2, immutableCollection);
    }

    public void addListener(ServiceManager$Listener serviceManager$Listener, Executor executor) {
        this.listeners.addListener(serviceManager$Listener, executor);
    }

    public void awaitHealthy() {
        Monitor monitor = this.monitor;
        Monitor$Guard monitor$Guard = this.awaitHealthGuard;
        monitor.enterWhenUninterruptibly(monitor$Guard);
        try {
            this.checkHealthy();
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    public void awaitHealthy(long l10, TimeUnit object) {
        Object object2 = this.monitor;
        object2.enter();
        try {
            object2 = this.monitor;
            Object object3 = this.awaitHealthGuard;
            boolean bl2 = object2.waitForUninterruptibly((Monitor$Guard)object3, l10, (TimeUnit)((Object)object));
            if (bl2) {
                this.checkHealthy();
                return;
            }
            CharSequence charSequence = new StringBuilder();
            object = "Timeout waiting for the services to become healthy. The following services have not started: ";
            charSequence.append((String)object);
            object = this.servicesByState;
            object2 = Service$State.NEW;
            object3 = Service$State.STARTING;
            object2 = ImmutableSet.of(object2, object3);
            object2 = Predicates.in((Collection)object2);
            object = Multimaps.filterKeys((SetMultimap)object, (Predicate)object2);
            charSequence.append(object);
            charSequence = charSequence.toString();
            TimeoutException timeoutException = new TimeoutException((String)charSequence);
            throw timeoutException;
        }
        finally {
            this.monitor.leave();
        }
    }

    public void awaitStopped() {
        Monitor monitor = this.monitor;
        Monitor$Guard monitor$Guard = this.stoppedGuard;
        monitor.enterWhenUninterruptibly(monitor$Guard);
        this.monitor.leave();
    }

    public void awaitStopped(long l10, TimeUnit object) {
        Object object2;
        Object object3;
        block16: {
            object3 = this.monitor;
            object3.enter();
            try {
                object3 = this.monitor;
            }
            catch (Throwable throwable) {
                this.monitor.leave();
                throw throwable;
            }
            object2 = this.stoppedGuard;
            boolean bl2 = object3.waitForUninterruptibly((Monitor$Guard)object2, l10, (TimeUnit)((Object)object));
            if (!bl2) break block16;
            this.monitor.leave();
            return;
        }
        CharSequence charSequence = new StringBuilder();
        object = "Timeout waiting for the services to stop. The following services have not stopped: ";
        charSequence.append((String)object);
        object = this.servicesByState;
        object3 = Service$State.TERMINATED;
        object2 = Service$State.FAILED;
        object3 = EnumSet.of(object3, object2);
        object3 = Predicates.in((Collection)object3);
        object3 = Predicates.not((Predicate)object3);
        object = Multimaps.filterKeys((SetMultimap)object, (Predicate)object3);
        charSequence.append(object);
        charSequence = charSequence.toString();
        TimeoutException timeoutException = new TimeoutException((String)charSequence);
        throw timeoutException;
    }

    public void checkHealthy() {
        int n10;
        Object object = this.states;
        Object object2 = Service$State.RUNNING;
        int n11 = object.count(object2);
        if (n11 == (n10 = this.numberOfServices)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected to be healthy after starting. The following services are not running: ");
        SetMultimap setMultimap = this.servicesByState;
        object2 = Predicates.not(Predicates.equalTo(object2));
        object2 = Multimaps.filterKeys(setMultimap, (Predicate)object2);
        stringBuilder.append(object2);
        object2 = stringBuilder.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public void dispatchListenerEvents() {
        Preconditions.checkState(this.monitor.isOccupiedByCurrentThread() ^ true, "It is incorrect to execute listeners with the monitor held.");
        this.listeners.dispatch();
    }

    public void enqueueFailedEvent(Service service) {
        ListenerCallQueue listenerCallQueue = this.listeners;
        ServiceManager$ServiceManagerState$2 serviceManager$ServiceManagerState$2 = new ServiceManager$ServiceManagerState$2(this, service);
        listenerCallQueue.enqueue(serviceManager$ServiceManagerState$2);
    }

    public void enqueueHealthyEvent() {
        ListenerCallQueue listenerCallQueue = this.listeners;
        ListenerCallQueue$Event listenerCallQueue$Event = ServiceManager.access$400();
        listenerCallQueue.enqueue(listenerCallQueue$Event);
    }

    public void enqueueStoppedEvent() {
        ListenerCallQueue listenerCallQueue = this.listeners;
        ListenerCallQueue$Event listenerCallQueue$Event = ServiceManager.access$300();
        listenerCallQueue.enqueue(listenerCallQueue$Event);
    }

    public void markReady() {
        Object object;
        Object object2;
        Object object3;
        block20: {
            object3 = this.monitor;
            ((Monitor)object3).enter();
            boolean bl2 = this.transitioned;
            if (bl2) break block20;
            bl2 = true;
            this.ready = bl2;
            return;
        }
        object3 = Lists.newArrayList();
        Object object4 = this.servicesByState();
        object4 = ((ImmutableMultimap)object4).values();
        object4 = ((ImmutableCollection)object4).iterator();
        while (true) {
            boolean bl3 = object4.hasNext();
            if (!bl3) break;
            object2 = object4.next();
            object2 = (Service)object2;
            object = object2.state();
            Service$State service$State = Service$State.NEW;
            if (object == service$State) continue;
            object3.add(object2);
            continue;
            break;
        }
        object2 = new StringBuilder();
        object = "Services started transitioning asynchronously before the ServiceManager was constructed: ";
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(object3);
        object3 = ((StringBuilder)object2).toString();
        try {
            object4 = new IllegalArgumentException((String)object3);
            throw object4;
        }
        finally {
            this.monitor.leave();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImmutableMultimap servicesByState() {
        Object object;
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        Iterator iterator2 = this.monitor;
        ((Monitor)((Object)iterator2)).enter();
        try {
            boolean bl2;
            iterator2 = this.servicesByState;
            iterator2 = iterator2.entries();
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
            }
        }
        catch (Throwable throwable) {
            this.monitor.leave();
            throw throwable;
        }
        {
            Object v10 = (object = (Map.Entry)object).getValue();
            boolean bl3 = v10 instanceof ServiceManager.NoOpService;
            if (bl3) continue;
            immutableSetMultimap$Builder.put((Map.Entry)object);
            continue;
        }
        this.monitor.leave();
        return immutableSetMultimap$Builder.build();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImmutableMap startupTimes() {
        Service service;
        Object object;
        Object object2;
        Object object3 = this.monitor;
        ((Monitor)object3).enter();
        try {
            boolean bl2;
            object3 = this.startupTimers;
            int n10 = object3.size();
            object3 = Lists.newArrayListWithCapacity(n10);
            object2 = this.startupTimers;
            object2 = object2.entrySet();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                object = object2.next();
                object = (Map.Entry)object;
                Object k10 = object.getKey();
                service = (Service)k10;
                object = object.getValue();
            }
        }
        catch (Throwable throwable) {
            this.monitor.leave();
            throw throwable;
        }
        {
            boolean bl3 = ((Stopwatch)(object = (Stopwatch)object)).isRunning();
            if (bl3 || (bl3 = service instanceof ServiceManager.NoOpService)) continue;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long l10 = ((Stopwatch)object).elapsed(timeUnit);
            object = l10;
            object = Maps.immutableEntry(service, object);
            object3.add(object);
            continue;
        }
        this.monitor.leave();
        object2 = Ordering.natural();
        object = new ServiceManager$ServiceManagerState$1(this);
        object2 = ((Ordering)object2).onResultOf((Function)object);
        Collections.sort(object3, object2);
        return ImmutableMap.copyOf((Iterable)object3);
    }

    /*
     * Unable to fully structure code
     */
    public void transitionService(Service var1_1, Service$State var2_3, Service$State var3_4) {
        block35: {
            block34: {
                Preconditions.checkNotNull(var1_1);
                var4_5 = 1;
                if (var2_3 != var3_4) {
                    var5_6 = var4_5;
                } else {
                    var5_6 = 0;
                    var6_7 = null;
                }
                Preconditions.checkArgument((boolean)var5_6);
                var6_7 = this.monitor;
                var6_7.enter();
                this.transitioned = var4_5;
                var5_6 = this.ready;
                if (var5_6 != 0) break block34;
                this.monitor.leave();
                this.dispatchListenerEvents();
                return;
            }
            var6_7 = this.servicesByState;
            var5_6 = var6_7.remove(var2_3, var1_1);
            var7_8 = "Service %s not at the expected location in the state map %s";
            Preconditions.checkState((boolean)var5_6, (String)var7_8, var1_1, var2_3);
            var2_3 = this.servicesByState;
            var8_9 = var2_3.put(var3_4, var1_1);
            var6_7 = "Service %s in the state map unexpectedly at %s";
            Preconditions.checkState((boolean)var8_9, (String)var6_7, var1_1, var3_4);
            var2_3 = this.startupTimers;
            var2_3 = var2_3.get(var1_1);
            var2_3 = (Stopwatch)var2_3;
            if (var2_3 != null) ** GOTO lbl48
            var2_3 = Stopwatch.createStarted();
            var6_7 = this.startupTimers;
            var6_7.put(var1_1, var2_3);
lbl48:
            // 2 sources

            var6_7 = Service$State.RUNNING;
            var9_10 = var3_4.compareTo(var6_7);
            if (var9_10 < 0) ** GOTO lbl74
            var9_10 = (int)var2_3.isRunning();
            if (var9_10 == 0) ** GOTO lbl74
            var2_3.stop();
            var9_10 = var1_1 instanceof ServiceManager.NoOpService;
            if (var9_10 != 0) ** GOTO lbl74
            var7_8 = ServiceManager.access$200();
            var10_11 = Level.FINE;
            var11_12 = "Started {0} in {1}.";
            var12_13 = 2;
            var13_14 = new Object[var12_13];
            var13_14[0] = var1_1;
            var13_14[var4_5] = var2_3;
            var7_8.log(var10_11, var11_12, var13_14);
lbl74:
            // 4 sources

            if (var3_4 != (var2_3 = Service$State.FAILED)) ** GOTO lbl77
            this.enqueueFailedEvent((Service)var1_1);
lbl77:
            // 2 sources

            var1_1 = this.states;
            var14_15 = var1_1.count(var6_7);
            var15_16 = this.numberOfServices;
            if (var14_15 != var15_16) ** GOTO lbl86
            this.enqueueHealthyEvent();
            break block35;
lbl86:
            // 1 sources

            var1_1 = this.states;
            var3_4 = Service$State.TERMINATED;
            var14_15 = var1_1.count(var3_4);
            var3_4 = this.states;
            var8_9 = var3_4.count(var2_3);
            var14_15 += var8_9;
            var8_9 = this.numberOfServices;
            if (var14_15 != var8_9) break block35;
            this.enqueueStoppedEvent();
        }
        return;
        finally {
            this.monitor.leave();
            this.dispatchListenerEvents();
        }
    }

    public void tryStartTiming(Service service) {
        block8: {
            Object object = this.monitor;
            ((Monitor)object).enter();
            object = this.startupTimers;
            object = object.get(service);
            object = (Stopwatch)object;
            if (object != null) break block8;
            object = this.startupTimers;
            Stopwatch stopwatch = Stopwatch.createStarted();
            object.put(service, stopwatch);
        }
        return;
        finally {
            this.monitor.leave();
        }
    }
}

