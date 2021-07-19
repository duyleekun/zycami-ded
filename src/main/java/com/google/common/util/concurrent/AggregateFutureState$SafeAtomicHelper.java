/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AggregateFutureState;
import com.google.common.util.concurrent.AggregateFutureState$AtomicHelper;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class AggregateFutureState$SafeAtomicHelper
extends AggregateFutureState$AtomicHelper {
    public final AtomicIntegerFieldUpdater remainingCountUpdater;
    public final AtomicReferenceFieldUpdater seenExceptionsUpdater;

    public AggregateFutureState$SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super(null);
        this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
        this.remainingCountUpdater = atomicIntegerFieldUpdater;
    }

    public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set set, Set set2) {
        this.seenExceptionsUpdater.compareAndSet(aggregateFutureState, set, set2);
    }

    public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
        return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
    }
}

