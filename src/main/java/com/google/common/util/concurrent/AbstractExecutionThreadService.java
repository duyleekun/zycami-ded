/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService$1;
import com.google.common.util.concurrent.AbstractExecutionThreadService$2;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class AbstractExecutionThreadService
implements Service {
    private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate;

    public AbstractExecutionThreadService() {
        AbstractExecutionThreadService$1 abstractExecutionThreadService$1 = new AbstractExecutionThreadService$1(this);
        this.delegate = abstractExecutionThreadService$1;
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
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

    public Executor executor() {
        AbstractExecutionThreadService$2 abstractExecutionThreadService$2 = new AbstractExecutionThreadService$2(this);
        return abstractExecutionThreadService$2;
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void run();

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

    public void triggerShutdown() {
    }
}

