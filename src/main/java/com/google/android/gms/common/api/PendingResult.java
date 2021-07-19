/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult$StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult {
    public void addStatusListener(PendingResult$StatusListener object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public abstract Result await();

    public abstract Result await(long var1, TimeUnit var3);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback var1);

    public abstract void setResultCallback(ResultCallback var1, long var2, TimeUnit var4);

    public TransformedResult then(ResultTransform object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Integer zam() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

