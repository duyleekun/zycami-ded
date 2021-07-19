/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.AggregateFutureState$AtomicHelper;
import com.google.common.util.concurrent.AggregateFutureState$SafeAtomicHelper;
import com.google.common.util.concurrent.AggregateFutureState$SynchronizedAtomicHelper;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AggregateFutureState
extends AbstractFuture$TrustedFuture {
    private static final AggregateFutureState$AtomicHelper ATOMIC_HELPER;
    private static final Logger log;
    private volatile int remaining;
    private volatile Set seenExceptions = null;

    static {
        Object object;
        log = Logger.getLogger(AggregateFutureState.class.getName());
        Throwable throwable = null;
        Object object2 = AggregateFutureState.class;
        AtomicIntegerFieldUpdater<Set> atomicIntegerFieldUpdater = Set.class;
        String string2 = "seenExceptions";
        object2 = AtomicReferenceFieldUpdater.newUpdater(object2, atomicIntegerFieldUpdater, string2);
        atomicIntegerFieldUpdater = AggregateFutureState.class;
        string2 = "remaining";
        atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(atomicIntegerFieldUpdater, string2);
        try {
            object = new AggregateFutureState$SafeAtomicHelper((AtomicReferenceFieldUpdater)object2, atomicIntegerFieldUpdater);
        }
        catch (Throwable throwable2) {
            object2 = new AggregateFutureState$SynchronizedAtomicHelper(null);
            throwable = throwable2;
            object = object2;
        }
        ATOMIC_HELPER = object;
        if (throwable != null) {
            object = log;
            object2 = Level.SEVERE;
            atomicIntegerFieldUpdater = "SafeAtomicHelper is broken!";
            ((Logger)object).log((Level)object2, (String)((Object)atomicIntegerFieldUpdater), throwable);
        }
    }

    public AggregateFutureState(int n10) {
        this.remaining = n10;
    }

    public static /* synthetic */ Set access$200(AggregateFutureState aggregateFutureState) {
        return aggregateFutureState.seenExceptions;
    }

    public static /* synthetic */ Set access$202(AggregateFutureState aggregateFutureState, Set set) {
        aggregateFutureState.seenExceptions = set;
        return set;
    }

    public static /* synthetic */ int access$306(AggregateFutureState aggregateFutureState) {
        int n10;
        aggregateFutureState.remaining = n10 = aggregateFutureState.remaining + -1;
        return n10;
    }

    public abstract void addInitialException(Set var1);

    public final void clearSeenExceptions() {
        this.seenExceptions = null;
    }

    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    public final Set getOrInitSeenExceptions() {
        Set set = this.seenExceptions;
        if (set == null) {
            set = Sets.newConcurrentHashSet();
            this.addInitialException(set);
            AggregateFutureState$AtomicHelper aggregateFutureState$AtomicHelper = ATOMIC_HELPER;
            aggregateFutureState$AtomicHelper.compareAndSetSeenExceptions(this, null, set);
            set = this.seenExceptions;
        }
        return set;
    }
}

