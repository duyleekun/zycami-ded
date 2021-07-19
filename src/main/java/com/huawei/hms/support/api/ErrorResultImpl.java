/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.ErrorResultImpl$a;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.TimeUnit;

public abstract class ErrorResultImpl
extends PendingResult {
    private Result a = null;
    private int b;

    public ErrorResultImpl(int n10) {
        this.b = n10;
    }

    public static /* synthetic */ int a(ErrorResultImpl errorResultImpl) {
        return errorResultImpl.b;
    }

    private Result a(int n10) {
        String string2 = "ErrorResultImpl";
        Object object = ErrorResultImpl.class.getGenericSuperclass();
        if (object != null) {
            object = ((ParameterizedType)object).getActualTypeArguments();
            Status status = null;
            object = GenericTypeReflector.getType(object[0]);
            object = ((Class)object).newInstance();
            object = (Result)object;
            this.a = object;
            status = new Status(n10);
            try {
                ((Result)object).setStatus(status);
            }
            catch (IllegalAccessException illegalAccessException) {
                String string3 = "IllegalAccessException";
                HMSLog.e(string2, string3);
            }
            catch (InstantiationException instantiationException) {
                String string4 = "InstantiationException";
                HMSLog.e(string2, string4);
            }
            return this.a;
        }
        return null;
    }

    public static /* synthetic */ Result a(ErrorResultImpl errorResultImpl, int n10) {
        return errorResultImpl.a(n10);
    }

    public final Result await() {
        return this.await(0L, null);
    }

    public Result await(long l10, TimeUnit timeUnit) {
        Looper looper;
        Object object = Looper.myLooper();
        if (object != (looper = Looper.getMainLooper())) {
            int n10 = this.b;
            return this.a(n10);
        }
        object = new IllegalStateException("await must not be called on the UI thread");
        throw object;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public final void setResultCallback(Looper object, ResultCallback resultCallback) {
        if (object == null) {
            object = Looper.myLooper();
        }
        Handler handler = new Handler(object);
        object = new ErrorResultImpl$a(this, resultCallback);
        handler.post((Runnable)object);
    }

    public final void setResultCallback(ResultCallback resultCallback) {
        Looper looper = Looper.getMainLooper();
        this.setResultCallback(looper, resultCallback);
    }

    public void setResultCallback(ResultCallback resultCallback, long l10, TimeUnit timeUnit) {
        this.setResultCallback(resultCallback);
    }
}

