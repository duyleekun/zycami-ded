/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.WrappingExecutorService;
import java.util.concurrent.Callable;

public class WrappingExecutorService$1
implements Runnable {
    public final /* synthetic */ WrappingExecutorService this$0;
    public final /* synthetic */ Callable val$wrapped;

    public WrappingExecutorService$1(WrappingExecutorService wrappingExecutorService, Callable callable) {
        this.this$0 = wrappingExecutorService;
        this.val$wrapped = callable;
    }

    public void run() {
        Callable callable;
        try {
            callable = this.val$wrapped;
        }
        catch (Exception exception) {
            Throwables.throwIfUnchecked(exception);
            RuntimeException runtimeException = new RuntimeException(exception);
            throw runtimeException;
        }
        callable.call();
    }
}

