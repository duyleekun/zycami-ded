/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Pair
 */
package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;

public class PendingResultImpl$d
extends Handler {
    public PendingResultImpl$d(Looper looper) {
        super(looper);
    }

    public void a(ResultCallback resultCallback, Result result2) {
        Pair pair = new Pair((Object)resultCallback, (Object)result2);
        resultCallback = this.obtainMessage(1, pair);
        this.sendMessage((Message)resultCallback);
    }

    public void b(ResultCallback resultCallback, Result result2) {
        resultCallback.onResult(result2);
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == n11) {
            object = (Pair)object.obj;
            ResultCallback resultCallback = (ResultCallback)object.first;
            object = (Result)object.second;
            this.b(resultCallback, (Result)object);
        }
    }
}

