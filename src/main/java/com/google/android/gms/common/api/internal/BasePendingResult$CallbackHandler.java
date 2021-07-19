/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  android.util.Pair
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.base.zap;

public class BasePendingResult$CallbackHandler
extends zap {
    public BasePendingResult$CallbackHandler() {
        Looper looper = Looper.getMainLooper();
        this(looper);
    }

    public BasePendingResult$CallbackHandler(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Don't know how to handle message: ");
                stringBuilder.append(n10);
                object = stringBuilder.toString();
                Exception exception = new Exception();
                Log.wtf((String)"BasePendingResult", (String)object, (Throwable)exception);
                return;
            }
            object = (BasePendingResult)object.obj;
            Status status = Status.RESULT_TIMEOUT;
            object.zab(status);
            return;
        }
        object = (Pair)object.obj;
        ResultCallback resultCallback = (ResultCallback)object.first;
        object = (Result)object.second;
        try {
            resultCallback.onResult((Result)object);
            return;
        }
        catch (RuntimeException runtimeException) {
            BasePendingResult.zab((Result)object);
            throw runtimeException;
        }
    }

    public final void zaa(ResultCallback resultCallback, Result result2) {
        Pair pair = new Pair((Object)resultCallback, (Object)result2);
        resultCallback = this.obtainMessage(1, pair);
        this.sendMessage((Message)resultCallback);
    }
}

