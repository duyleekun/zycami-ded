/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors$ListeningDecorator;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class MoreExecutors$ScheduledListeningDecorator
extends MoreExecutors$ListeningDecorator
implements ListeningScheduledExecutorService {
    public final ScheduledExecutorService delegate;

    public MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService = (ScheduledExecutorService)Preconditions.checkNotNull(scheduledExecutorService);
    }

    public ListenableScheduledFuture schedule(Runnable runnable, long l10, TimeUnit timeUnit) {
        runnable = TrustedListenableFutureTask.create(runnable, null);
        ScheduledFuture<?> scheduledFuture = this.delegate.schedule(runnable, l10, timeUnit);
        MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask = new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask((ListenableFuture)((Object)runnable), scheduledFuture);
        return moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask;
    }

    public ListenableScheduledFuture schedule(Callable object, long l10, TimeUnit timeUnit) {
        object = TrustedListenableFutureTask.create((Callable)object);
        ScheduledFuture<?> scheduledFuture = this.delegate.schedule((Runnable)object, l10, timeUnit);
        MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask = new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask((ListenableFuture)object, scheduledFuture);
        return moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask;
    }

    public ListenableScheduledFuture scheduleAtFixedRate(Runnable object, long l10, long l11, TimeUnit timeUnit) {
        MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask((Runnable)object);
        object = this.delegate.scheduleAtFixedRate(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, l10, l11, timeUnit);
        MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask = new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, (ScheduledFuture)object);
        return moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask;
    }

    public ListenableScheduledFuture scheduleWithFixedDelay(Runnable object, long l10, long l11, TimeUnit timeUnit) {
        MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask((Runnable)object);
        object = this.delegate.scheduleWithFixedDelay(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, l10, l11, timeUnit);
        MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask = new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, (ScheduledFuture)object);
        return moreExecutors$ScheduledListeningDecorator$ListenableScheduledTask;
    }
}

