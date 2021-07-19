/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public interface Service {
    public void addListener(Service$Listener var1, Executor var2);

    public void awaitRunning();

    public void awaitRunning(long var1, TimeUnit var3);

    public void awaitTerminated();

    public void awaitTerminated(long var1, TimeUnit var3);

    public Throwable failureCause();

    public boolean isRunning();

    public Service startAsync();

    public Service$State state();

    public Service stopAsync();
}

