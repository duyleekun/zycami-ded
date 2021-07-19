/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractTransformFuture$AsyncTransformFuture;
import com.google.common.util.concurrent.AbstractTransformFuture$TransformFuture;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture$TrustedFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class AbstractTransformFuture
extends FluentFuture$TrustedFuture
implements Runnable {
    public Object function;
    public ListenableFuture inputFuture;

    public AbstractTransformFuture(ListenableFuture object, Object object2) {
        object = (ListenableFuture)Preconditions.checkNotNull(object);
        this.inputFuture = object;
        this.function = object = Preconditions.checkNotNull(object2);
    }

    public static ListenableFuture create(ListenableFuture listenableFuture, Function object, Executor executor) {
        Preconditions.checkNotNull(object);
        AbstractTransformFuture$TransformFuture abstractTransformFuture$TransformFuture = new AbstractTransformFuture$TransformFuture(listenableFuture, (Function)object);
        object = MoreExecutors.rejectionPropagatingExecutor(executor, abstractTransformFuture$TransformFuture);
        listenableFuture.addListener(abstractTransformFuture$TransformFuture, (Executor)object);
        return abstractTransformFuture$TransformFuture;
    }

    public static ListenableFuture create(ListenableFuture listenableFuture, AsyncFunction object, Executor executor) {
        Preconditions.checkNotNull(executor);
        AbstractTransformFuture$AsyncTransformFuture abstractTransformFuture$AsyncTransformFuture = new AbstractTransformFuture$AsyncTransformFuture(listenableFuture, (AsyncFunction)object);
        object = MoreExecutors.rejectionPropagatingExecutor(executor, abstractTransformFuture$AsyncTransformFuture);
        listenableFuture.addListener(abstractTransformFuture$AsyncTransformFuture, (Executor)object);
        return abstractTransformFuture$AsyncTransformFuture;
    }

    public final void afterDone() {
        ListenableFuture listenableFuture = this.inputFuture;
        this.maybePropagateCancellationTo(listenableFuture);
        this.inputFuture = null;
        this.function = null;
    }

    public abstract Object doTransform(Object var1, Object var2);

    public String pendingToString() {
        Object object = this.inputFuture;
        Object object2 = this.function;
        CharSequence charSequence = super.pendingToString();
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "inputFuture=[";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            stringBuilder.append("], ");
            object = stringBuilder.toString();
        } else {
            object = "";
        }
        if (object2 != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("function=[");
            ((StringBuilder)charSequence).append(object2);
            ((StringBuilder)charSequence).append("]");
            return ((StringBuilder)charSequence).toString();
        }
        if (charSequence != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append((String)charSequence);
            return ((StringBuilder)object2).toString();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = this.inputFuture;
        Object object2 = this.function;
        boolean bl2 = this.isCancelled();
        boolean bl3 = true;
        boolean bl4 = object == null ? bl3 : false;
        bl2 |= bl4;
        if (object2 != null) {
            bl3 = false;
        }
        if (bl2 |= bl3) {
            return;
        }
        bl2 = false;
        this.inputFuture = null;
        bl3 = object.isCancelled();
        if (bl3) {
            this.setFuture((ListenableFuture)object);
            return;
        }
        try {
            object = Futures.getDone((Future)object);
        }
        catch (Error error) {
            this.setException(error);
            return;
        }
        catch (RuntimeException runtimeException) {
            this.setException(runtimeException);
            return;
        }
        catch (ExecutionException executionException) {
            object = executionException.getCause();
            this.setException((Throwable)object);
            return;
        }
        catch (CancellationException cancellationException) {
            this.cancel(false);
            return;
        }
        try {
            object = this.doTransform(object2, object);
            this.function = null;
            this.setResult(object);
            return;
        }
        catch (Throwable throwable) {
            try {
                this.setException(throwable);
                return;
            }
            finally {
                this.function = null;
            }
        }
    }

    public abstract void setResult(Object var1);
}

