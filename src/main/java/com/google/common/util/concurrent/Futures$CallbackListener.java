/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class Futures$CallbackListener
implements Runnable {
    public final FutureCallback callback;
    public final Future future;

    public Futures$CallbackListener(Future future, FutureCallback futureCallback) {
        this.future = future;
        this.callback = futureCallback;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        void var1_4;
        block5: {
            Object object = this.future;
            boolean bl2 = object instanceof InternalFutureFailureAccess;
            if (bl2 && (object = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess)object)) != null) {
                this.callback.onFailure((Throwable)object);
                return;
            }
            try {
                object = this.future;
                object = Futures.getDone((Future)object);
            }
            catch (Error error) {
                break block5;
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
                break block5;
            }
            catch (ExecutionException executionException) {
                FutureCallback futureCallback = this.callback;
                Throwable throwable = executionException.getCause();
                futureCallback.onFailure(throwable);
                return;
            }
            this.callback.onSuccess(object);
            return;
        }
        this.callback.onFailure((Throwable)var1_4);
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        FutureCallback futureCallback = this.callback;
        return moreObjects$ToStringHelper.addValue(futureCallback).toString();
    }
}

