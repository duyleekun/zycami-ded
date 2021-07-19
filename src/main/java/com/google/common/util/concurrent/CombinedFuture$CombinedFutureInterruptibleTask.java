/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.InterruptibleTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public abstract class CombinedFuture$CombinedFutureInterruptibleTask
extends InterruptibleTask {
    private final Executor listenerExecutor;
    public final /* synthetic */ CombinedFuture this$0;
    public boolean thrownByExecute = true;

    public CombinedFuture$CombinedFutureInterruptibleTask(CombinedFuture object, Executor executor) {
        this.this$0 = object;
        this.listenerExecutor = object = (Executor)Preconditions.checkNotNull(executor);
    }

    public final void afterRanInterruptibly(Object object, Throwable throwable) {
        CombinedFuture combinedFuture = this.this$0;
        CombinedFuture.access$002(combinedFuture, null);
        if (throwable != null) {
            boolean bl2 = throwable instanceof ExecutionException;
            if (bl2) {
                object = this.this$0;
                throwable = throwable.getCause();
                ((AbstractFuture)object).setException(throwable);
            } else {
                bl2 = throwable instanceof CancellationException;
                if (bl2) {
                    object = this.this$0;
                    throwable = null;
                    ((AbstractFuture$TrustedFuture)object).cancel(false);
                } else {
                    object = this.this$0;
                    ((AbstractFuture)object).setException(throwable);
                }
            }
        } else {
            this.setValue(object);
        }
    }

    public final void execute() {
        block3: {
            Executor executor = this.listenerExecutor;
            try {
                executor.execute(this);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                boolean bl2 = this.thrownByExecute;
                if (!bl2) break block3;
                CombinedFuture combinedFuture = this.this$0;
                combinedFuture.setException(rejectedExecutionException);
            }
        }
    }

    public final boolean isDone() {
        return this.this$0.isDone();
    }

    public abstract void setValue(Object var1);
}

