/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AggregateFutureState;
import com.google.common.util.concurrent.AggregateFutureState$1;
import java.util.Set;

public abstract class AggregateFutureState$AtomicHelper {
    private AggregateFutureState$AtomicHelper() {
    }

    public /* synthetic */ AggregateFutureState$AtomicHelper(AggregateFutureState$1 aggregateFutureState$1) {
        this();
    }

    public abstract void compareAndSetSeenExceptions(AggregateFutureState var1, Set var2, Set var3);

    public abstract int decrementAndGetRemainingCount(AggregateFutureState var1);
}

