/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractCatchingFuture$AsyncCatchingFuture;
import com.google.common.util.concurrent.AbstractCatchingFuture$CatchingFuture;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture$TrustedFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Platform;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class AbstractCatchingFuture
extends FluentFuture$TrustedFuture
implements Runnable {
    public Class exceptionType;
    public Object fallback;
    public ListenableFuture inputFuture;

    public AbstractCatchingFuture(ListenableFuture object, Class clazz, Object object2) {
        object = (ListenableFuture)Preconditions.checkNotNull(object);
        this.inputFuture = object;
        this.exceptionType = object = (Class)Preconditions.checkNotNull(clazz);
        this.fallback = object = Preconditions.checkNotNull(object2);
    }

    public static ListenableFuture create(ListenableFuture listenableFuture, Class object, Function function, Executor executor) {
        AbstractCatchingFuture$CatchingFuture abstractCatchingFuture$CatchingFuture = new AbstractCatchingFuture$CatchingFuture(listenableFuture, (Class)object, function);
        object = MoreExecutors.rejectionPropagatingExecutor(executor, abstractCatchingFuture$CatchingFuture);
        listenableFuture.addListener(abstractCatchingFuture$CatchingFuture, (Executor)object);
        return abstractCatchingFuture$CatchingFuture;
    }

    public static ListenableFuture create(ListenableFuture listenableFuture, Class object, AsyncFunction asyncFunction, Executor executor) {
        AbstractCatchingFuture$AsyncCatchingFuture abstractCatchingFuture$AsyncCatchingFuture = new AbstractCatchingFuture$AsyncCatchingFuture(listenableFuture, (Class)object, asyncFunction);
        object = MoreExecutors.rejectionPropagatingExecutor(executor, abstractCatchingFuture$AsyncCatchingFuture);
        listenableFuture.addListener(abstractCatchingFuture$AsyncCatchingFuture, (Executor)object);
        return abstractCatchingFuture$AsyncCatchingFuture;
    }

    public final void afterDone() {
        ListenableFuture listenableFuture = this.inputFuture;
        this.maybePropagateCancellationTo(listenableFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    public abstract Object doFallback(Object var1, Throwable var2);

    public String pendingToString() {
        Object object = this.inputFuture;
        Serializable serializable = this.exceptionType;
        Object object2 = this.fallback;
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
        if (serializable != null && object2 != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("exceptionType=[");
            ((StringBuilder)charSequence).append(serializable);
            ((StringBuilder)charSequence).append("], fallback=[");
            ((StringBuilder)charSequence).append(object2);
            ((StringBuilder)charSequence).append("]");
            return ((StringBuilder)charSequence).toString();
        }
        if (charSequence != null) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append((String)object);
            ((StringBuilder)serializable).append((String)charSequence);
            return ((StringBuilder)serializable).toString();
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    public final void run() {
        block21: {
            block20: {
                block22: {
                    var1_1 = this.inputFuture;
                    var2_4 = this.exceptionType;
                    var3_5 = this.fallback;
                    var4_6 = true;
                    var5_7 = false;
                    var6_8 = null;
                    if (var1_1 == null) {
                        var7_11 = var4_6;
                    } else {
                        var7_11 = false;
                        var8_12 = null;
                    }
                    if (var2_4 == null) {
                        var9_13 = var4_6;
                    } else {
                        var9_13 = false;
                        var10_14 = null;
                    }
                    var7_11 |= var9_13;
                    if (var3_5 != null) {
                        var4_6 = false;
                    }
                    if ((var4_6 |= var7_11) || (var4_6 = this.isCancelled())) break block21;
                    var4_6 = false;
                    this.inputFuture = null;
                    var5_7 = var1_1 instanceof InternalFutureFailureAccess;
                    if (var5_7) {
                        var6_8 = var1_1;
                        var6_8 = (InternalFutureFailureAccess)var1_1;
                        var6_8 = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess)var6_8);
                    }
                    var5_7 = false;
                    var6_8 = null;
                    if (var6_8 != null) break block22;
                    try {
                        var8_12 = Futures.getDone((Future)var1_1);
                    }
                    catch (Throwable var6_9) {
                        // empty catch block
                    }
                }
lbl40:
                // 2 sources

                while (true) {
                    var7_11 = false;
                    var8_12 = null;
                    break block20;
                    break;
                }
                catch (ExecutionException var6_10) {
                    var8_12 = var6_10.getCause();
                    if (var8_12 == null) {
                        var10_14 = new StringBuilder();
                        var10_14.append("Future type ");
                        var11_15 = var1_1.getClass();
                        var10_14.append(var11_15);
                        var11_15 = " threw ";
                        var10_14.append((String)var11_15);
                        var6_8 = var6_10.getClass();
                        var10_14.append(var6_8);
                        var10_14.append(" without a cause");
                        var6_8 = var10_14.toString();
                        var8_12 = new NullPointerException((String)var6_8);
                    }
                    var6_8 = var8_12;
                    ** continue;
                }
            }
            if (var6_8 == null) {
                this.set(var8_12);
                return;
            }
            var12_16 = Platform.isInstanceOfThrowableClass((Throwable)var6_8, var2_4);
            if (!var12_16) {
                this.setFuture((ListenableFuture)var1_1);
                return;
            }
            try {
                var1_1 = this.doFallback(var3_5, (Throwable)var6_8);
                this.exceptionType = null;
                this.fallback = null;
                this.setResult(var1_1);
                return;
            }
            catch (Throwable var1_2) {
                try {
                    this.setException(var1_2);
                    return;
                }
                finally {
                    this.exceptionType = null;
                    this.fallback = null;
                }
            }
        }
    }

    public abstract void setResult(Object var1);
}

