/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;

public final class Callables$3
implements Callable {
    public final /* synthetic */ Callable val$callable;
    public final /* synthetic */ Supplier val$nameSupplier;

    public Callables$3(Supplier supplier, Callable callable) {
        this.val$nameSupplier = supplier;
        this.val$callable = callable;
    }

    public Object call() {
        Thread thread = Thread.currentThread();
        String string2 = thread.getName();
        String string3 = (String)this.val$nameSupplier.get();
        boolean bl2 = Callables.access$000(string3, thread);
        try {
            Callable callable = this.val$callable;
            callable = callable.call();
            return callable;
        }
        finally {
            if (bl2) {
                Callables.access$000(string2, thread);
            }
        }
    }
}

