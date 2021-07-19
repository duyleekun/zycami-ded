/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.huawei.hms.common.api.internal;

import android.os.Looper;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

public final class OptionalPendingResultImpl
extends OptionalPendingResult {
    private final PendingResult pendingResult;

    public OptionalPendingResultImpl(PendingResult pendingResult) {
        this.pendingResult = pendingResult;
    }

    public final void addStatusListener() {
    }

    public final Result await() {
        return this.pendingResult.await();
    }

    public final Result await(long l10, TimeUnit timeUnit) {
        return this.pendingResult.await(l10, timeUnit);
    }

    public final void cancel() {
    }

    public final Result get() {
        IllegalStateException illegalStateException = new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
        throw illegalStateException;
    }

    public final boolean isCanceled() {
        return false;
    }

    public final boolean isDone() {
        return false;
    }

    public void setResultCallback(Looper looper, ResultCallback resultCallback) {
        this.pendingResult.setResultCallback(looper, resultCallback);
    }

    public final void setResultCallback(ResultCallback resultCallback) {
        this.pendingResult.setResultCallback(resultCallback);
    }

    public final void setResultCallback(ResultCallback resultCallback, long l10, TimeUnit timeUnit) {
        this.setResultCallback(resultCallback);
    }
}

