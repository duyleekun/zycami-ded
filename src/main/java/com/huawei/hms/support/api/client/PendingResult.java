/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.ConvertedResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.ResultConvert;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult {
    public abstract Result await();

    public abstract Result await(long var1, TimeUnit var3);

    public abstract void cancel();

    public ConvertedResult convertResult(ResultConvert object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public abstract boolean isCanceled();

    public abstract void setResultCallback(Looper var1, ResultCallback var2);

    public abstract void setResultCallback(ResultCallback var1);

    public abstract void setResultCallback(ResultCallback var1, long var2, TimeUnit var4);
}

