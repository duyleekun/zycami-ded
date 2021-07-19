/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AggregateFuture$1;
import com.google.common.util.concurrent.AggregateFuture$2;
import com.google.common.util.concurrent.AggregateFuture$ReleaseResourcesReason;
import com.google.common.util.concurrent.AggregateFutureState;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.AbstractCollection;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AggregateFuture
extends AggregateFutureState {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    private ImmutableCollection futures;

    public AggregateFuture(ImmutableCollection immutableCollection, boolean bl2, boolean bl3) {
        int n10 = immutableCollection.size();
        super(n10);
        this.futures = immutableCollection = (ImmutableCollection)Preconditions.checkNotNull(immutableCollection);
        this.allMustSucceed = bl2;
        this.collectsValues = bl3;
    }

    public static /* synthetic */ ImmutableCollection access$002(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        aggregateFuture.futures = immutableCollection;
        return immutableCollection;
    }

    public static /* synthetic */ void access$100(AggregateFuture aggregateFuture, int n10, Future future) {
        aggregateFuture.collectValueFromNonCancelledFuture(n10, future);
    }

    public static /* synthetic */ void access$200(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        aggregateFuture.decrementCountAndMaybeComplete(immutableCollection);
    }

    private static boolean addCausalChain(Set set, Throwable throwable) {
        while (throwable != null) {
            boolean bl2 = set.add(throwable);
            if (!bl2) {
                return false;
            }
            throwable = throwable.getCause();
        }
        return true;
    }

    private void collectValueFromNonCancelledFuture(int n10, Future object) {
        object = Futures.getDone((Future)object);
        try {
            this.collectOneValue(n10, object);
        }
        catch (Throwable throwable) {
            this.handleException(throwable);
        }
        catch (ExecutionException executionException) {
            Throwable throwable = executionException.getCause();
            this.handleException(throwable);
        }
    }

    private void decrementCountAndMaybeComplete(ImmutableCollection immutableCollection) {
        int n10 = this.decrementRemainingAndGet();
        boolean bl2 = n10 >= 0;
        String string2 = "Less than 0 remaining futures";
        Preconditions.checkState(bl2, string2);
        if (n10 == 0) {
            this.processCompleted(immutableCollection);
        }
    }

    private void handleException(Throwable throwable) {
        Set set;
        Preconditions.checkNotNull(throwable);
        boolean bl2 = this.allMustSucceed;
        if (bl2 && !(bl2 = this.setException(throwable)) && (bl2 = AggregateFuture.addCausalChain(set = this.getOrInitSeenExceptions(), throwable))) {
            AggregateFuture.log(throwable);
            return;
        }
        bl2 = throwable instanceof Error;
        if (bl2) {
            AggregateFuture.log(throwable);
        }
    }

    private static void log(Throwable throwable) {
        boolean bl2 = throwable instanceof Error;
        String string2 = bl2 ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first";
        Logger logger = AggregateFuture.logger;
        Level level = Level.SEVERE;
        logger.log(level, string2, throwable);
    }

    private void processCompleted(ImmutableCollection object) {
        if (object != null) {
            boolean bl2;
            int n10 = 0;
            object = ((ImmutableCollection)object).iterator();
            while (bl2 = object.hasNext()) {
                Future future = (Future)object.next();
                boolean bl3 = future.isCancelled();
                if (!bl3) {
                    this.collectValueFromNonCancelledFuture(n10, future);
                }
                ++n10;
            }
        }
        this.clearSeenExceptions();
        this.handleAllCompleted();
        object = AggregateFuture$ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED;
        this.releaseResources((AggregateFuture$ReleaseResourcesReason)((Object)object));
    }

    public final void addInitialException(Set set) {
        Preconditions.checkNotNull(set);
        boolean bl2 = this.isCancelled();
        if (!bl2) {
            Throwable throwable = this.tryInternalFastPathGetFailure();
            AggregateFuture.addCausalChain(set, throwable);
        }
    }

    public final void afterDone() {
        Future future;
        boolean bl2;
        super.afterDone();
        Object object = this.futures;
        AggregateFuture$ReleaseResourcesReason aggregateFuture$ReleaseResourcesReason = AggregateFuture$ReleaseResourcesReason.OUTPUT_FUTURE_DONE;
        this.releaseResources(aggregateFuture$ReleaseResourcesReason);
        boolean bl3 = this.isCancelled();
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            future = null;
        }
        if (bl3 &= bl2) {
            bl3 = this.wasInterrupted();
            object = ((ImmutableCollection)object).iterator();
            while (bl2 = object.hasNext()) {
                future = (Future)object.next();
                future.cancel(bl3);
            }
        }
    }

    public abstract void collectOneValue(int var1, Object var2);

    public abstract void handleAllCompleted();

    public final void init() {
        Object object = this.futures;
        int n10 = (int)(((AbstractCollection)object).isEmpty() ? 1 : 0);
        if (n10 != 0) {
            this.handleAllCompleted();
            return;
        }
        n10 = this.allMustSucceed;
        if (n10 != 0) {
            boolean bl2;
            n10 = 0;
            object = null;
            UnmodifiableIterator unmodifiableIterator = this.futures.iterator();
            while (bl2 = unmodifiableIterator.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture)unmodifiableIterator.next();
                int n11 = n10 + 1;
                AggregateFuture$1 aggregateFuture$1 = new AggregateFuture$1(this, listenableFuture, n10);
                object = MoreExecutors.directExecutor();
                listenableFuture.addListener(aggregateFuture$1, (Executor)object);
                n10 = n11;
            }
        } else {
            boolean bl3;
            n10 = this.collectsValues;
            if (n10 != 0) {
                object = this.futures;
            } else {
                n10 = 0;
                object = null;
            }
            AggregateFuture$2 aggregateFuture$2 = new AggregateFuture$2(this, (ImmutableCollection)object);
            object = this.futures.iterator();
            while (bl3 = object.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture)object.next();
                Executor executor = MoreExecutors.directExecutor();
                listenableFuture.addListener(aggregateFuture$2, executor);
            }
        }
    }

    public final String pendingToString() {
        ImmutableCollection immutableCollection = this.futures;
        if (immutableCollection != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("futures=");
            stringBuilder.append(immutableCollection);
            return stringBuilder.toString();
        }
        return super.pendingToString();
    }

    public void releaseResources(AggregateFuture$ReleaseResourcesReason aggregateFuture$ReleaseResourcesReason) {
        Preconditions.checkNotNull((Object)aggregateFuture$ReleaseResourcesReason);
        this.futures = null;
    }
}

