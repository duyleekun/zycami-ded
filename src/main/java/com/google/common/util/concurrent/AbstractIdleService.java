/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService$1;
import com.google.common.util.concurrent.AbstractIdleService$DelegateService;
import com.google.common.util.concurrent.AbstractIdleService$ThreadNameSupplier;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class AbstractIdleService
implements Service {
    private final Service delegate;
    private final Supplier threadNameSupplier;

    public AbstractIdleService() {
        Object object = new AbstractIdleService$ThreadNameSupplier(this, null);
        this.threadNameSupplier = object;
        this.delegate = object = new AbstractIdleService$DelegateService(this, null);
    }

    public static /* synthetic */ Supplier access$200(AbstractIdleService abstractIdleService) {
        return abstractIdleService.threadNameSupplier;
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
        AbstractIdleService$1 abstractIdleService$1 = new AbstractIdleService$1(this);
        return abstractIdleService$1;
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public String serviceName() {
        return this.getClass().getSimpleName();
    }

    public abstract void shutDown();

    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public abstract void startUp();

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

