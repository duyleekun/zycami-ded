/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;

public final class Callables$4
implements Runnable {
    public final /* synthetic */ Supplier val$nameSupplier;
    public final /* synthetic */ Runnable val$task;

    public Callables$4(Supplier supplier, Runnable runnable) {
        this.val$nameSupplier = supplier;
        this.val$task = runnable;
    }

    public void run() {
        Thread thread = Thread.currentThread();
        String string2 = thread.getName();
        String string3 = (String)this.val$nameSupplier.get();
        boolean bl2 = Callables.access$000(string3, thread);
        try {
            Runnable runnable = this.val$task;
            runnable.run();
            return;
        }
        finally {
            if (bl2) {
                Callables.access$000(string2, thread);
            }
        }
    }
}

