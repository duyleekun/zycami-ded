/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api;

import com.huawei.hms.support.api.ErrorResultImpl;
import com.huawei.hms.support.api.client.ResultCallback;

public class ErrorResultImpl$a
implements Runnable {
    public final /* synthetic */ ResultCallback a;
    public final /* synthetic */ ErrorResultImpl b;

    public ErrorResultImpl$a(ErrorResultImpl errorResultImpl, ResultCallback resultCallback) {
        this.b = errorResultImpl;
        this.a = resultCallback;
    }

    public void run() {
        ResultCallback resultCallback = this.a;
        Object object = this.b;
        int n10 = ErrorResultImpl.a((ErrorResultImpl)object);
        object = ErrorResultImpl.a((ErrorResultImpl)object, n10);
        resultCallback.onResult(object);
    }
}

