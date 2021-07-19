/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$1ThreadFactoryImpl;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class AbstractScheduledService
implements Service {
    private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService delegate;

    public AbstractScheduledService() {
        AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate = new AbstractScheduledService$ServiceDelegate(this, null);
        this.delegate = abstractScheduledService$ServiceDelegate;
    }

    public static /* synthetic */ Logger access$400() {
        return logger;
    }

    public static /* synthetic */ AbstractService access$500(AbstractScheduledService abstractScheduledService) {
        return abstractScheduledService.delegate;
    }

    public final void addListener(Service$Listener service$Listener, Executor executor) {
        this.delegate.addListener(service$Listener, executor);
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitRunning(long l10, TimeUnit timeUnit) {
        this.delegate.awaitRunning(l10, timeUnit);
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public final void awaitTerminated(long l10, TimeUnit timeUnit) {
        this.delegate.awaitTerminated(l10, timeUnit);
    }

    public ScheduledExecutorService executor() {
        Object object = new AbstractScheduledService$1ThreadFactoryImpl(this);
        object = Executors.newSingleThreadScheduledExecutor((ThreadFactory)object);
        AbstractScheduledService$1 abstractScheduledService$1 = new AbstractScheduledService$1(this, (ScheduledExecutorService)object);
        Executor executor = MoreExecutors.directExecutor();
        this.addListener(abstractScheduledService$1, executor);
        return object;
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void runOneIteration();

    public abstract AbstractScheduledService$Scheduler scheduler();

    public String serviceName() {
        return this.getClass().getSimpleName();
    }

    public void shutDown() {
    }

    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public void startUp() {
    }

    public final Service$State state() {
        return this.delegate.state();
    }

    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.serviceName();
        stringBuilder.append((String)object);
        stringBuilder.append(" [");
        object = this.state();
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

