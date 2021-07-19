/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult$StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.concurrent.TimeUnit;

public final class OptionalPendingResultImpl
extends OptionalPendingResult {
    private final BasePendingResult zajq;

    public OptionalPendingResultImpl(PendingResult pendingResult) {
        pendingResult = (BasePendingResult)pendingResult;
        this.zajq = pendingResult;
    }

    public final void addStatusListener(PendingResult$StatusListener pendingResult$StatusListener) {
        ((PendingResult)this.zajq).addStatusListener(pendingResult$StatusListener);
    }

    public final Result await() {
        return ((PendingResult)this.zajq).await();
    }

    public final Result await(long l10, TimeUnit timeUnit) {
        return ((PendingResult)this.zajq).await(l10, timeUnit);
    }

    public final void cancel() {
        ((PendingResult)this.zajq).cancel();
    }

    public final Result get() {
        boolean bl2 = ((OptionalPendingResult)this).isDone();
        if (bl2) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return ((PendingResult)this).await(0L, timeUnit);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
        throw illegalStateException;
    }

    public final boolean isCanceled() {
        return ((PendingResult)this.zajq).isCanceled();
    }

    public final boolean isDone() {
        return this.zajq.isReady();
    }

    public final void setResultCallback(ResultCallback resultCallback) {
        ((PendingResult)this.zajq).setResultCallback(resultCallback);
    }

    public final void setResultCallback(ResultCallback resultCallback, long l10, TimeUnit timeUnit) {
        ((PendingResult)this.zajq).setResultCallback(resultCallback, l10, timeUnit);
    }

    public final TransformedResult then(ResultTransform resultTransform) {
        return ((PendingResult)this.zajq).then(resultTransform);
    }

    public final Integer zam() {
        return ((PendingResult)this.zajq).zam();
    }
}

