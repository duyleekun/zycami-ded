/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AggregateFutureState;
import com.google.common.util.concurrent.AggregateFutureState$1;
import com.google.common.util.concurrent.AggregateFutureState$AtomicHelper;
import java.util.Set;

public final class AggregateFutureState$SynchronizedAtomicHelper
extends AggregateFutureState$AtomicHelper {
    private AggregateFutureState$SynchronizedAtomicHelper() {
        super(null);
    }

    public /* synthetic */ AggregateFutureState$SynchronizedAtomicHelper(AggregateFutureState$1 aggregateFutureState$1) {
        this();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set set, Set set2) {
        synchronized (aggregateFutureState) {
            Set set3 = AggregateFutureState.access$200(aggregateFutureState);
            if (set3 == set) {
                AggregateFutureState.access$202(aggregateFutureState, set2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
        synchronized (aggregateFutureState) {
            return AggregateFutureState.access$306(aggregateFutureState);
        }
    }
}

