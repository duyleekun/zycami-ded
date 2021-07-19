/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

public class EmptyPendingResult
extends PendingResult {
    private Result a;

    public Result await() {
        return this.a;
    }

    public Result await(long l10, TimeUnit timeUnit) {
        return this.a;
    }

    public void cancel() {
    }

    public Result getResult() {
        return this.a;
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResult(Result result2) {
        this.a = result2;
    }

    public void setResultCallback(Looper looper, ResultCallback resultCallback) {
    }

    public void setResultCallback(ResultCallback resultCallback) {
    }

    public void setResultCallback(ResultCallback resultCallback, long l10, TimeUnit timeUnit) {
    }
}

