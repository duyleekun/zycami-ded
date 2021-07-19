/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.Callables$1;
import com.google.common.util.concurrent.Callables$2;
import com.google.common.util.concurrent.Callables$3;
import com.google.common.util.concurrent.Callables$4;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;

public final class Callables {
    private Callables() {
    }

    public static /* synthetic */ boolean access$000(String string2, Thread thread) {
        return Callables.trySetName(string2, thread);
    }

    public static AsyncCallable asAsyncCallable(Callable callable, ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        Callables$2 callables$2 = new Callables$2(listeningExecutorService, callable);
        return callables$2;
    }

    public static Callable returning(Object object) {
        Callables$1 callables$1 = new Callables$1(object);
        return callables$1;
    }

    public static Runnable threadRenaming(Runnable runnable, Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        Callables$4 callables$4 = new Callables$4(supplier, runnable);
        return callables$4;
    }

    public static Callable threadRenaming(Callable callable, Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        Callables$3 callables$3 = new Callables$3(supplier, callable);
        return callables$3;
    }

    private static boolean trySetName(String string2, Thread thread) {
        try {
            thread.setName(string2);
            return true;
        }
        catch (SecurityException securityException) {
            return false;
        }
    }
}

