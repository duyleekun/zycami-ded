/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.WrappingScheduledExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final class MoreExecutors$4
extends WrappingScheduledExecutorService {
    public final /* synthetic */ Supplier val$nameSupplier;

    public MoreExecutors$4(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
        this.val$nameSupplier = supplier;
        super(scheduledExecutorService);
    }

    public Runnable wrapTask(Runnable runnable) {
        Supplier supplier = this.val$nameSupplier;
        return Callables.threadRenaming(runnable, supplier);
    }

    public Callable wrapTask(Callable callable) {
        Supplier supplier = this.val$nameSupplier;
        return Callables.threadRenaming(callable, supplier);
    }
}

