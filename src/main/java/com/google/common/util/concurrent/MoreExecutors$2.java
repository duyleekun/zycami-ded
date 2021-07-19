/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Executor;

public final class MoreExecutors$2
implements Executor {
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ Supplier val$nameSupplier;

    public MoreExecutors$2(Executor executor, Supplier supplier) {
        this.val$executor = executor;
        this.val$nameSupplier = supplier;
    }

    public void execute(Runnable runnable) {
        Executor executor = this.val$executor;
        Supplier supplier = this.val$nameSupplier;
        runnable = Callables.threadRenaming(runnable, supplier);
        executor.execute(runnable);
    }
}

