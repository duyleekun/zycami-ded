/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.huawei.hms.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.api.HuaweiApiClientImpl$a;
import com.huawei.hms.api.HuaweiApiClientImpl$g$a;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;

public class HuaweiApiClientImpl$g
implements ResultCallback {
    public final /* synthetic */ HuaweiApiClientImpl a;

    private HuaweiApiClientImpl$g(HuaweiApiClientImpl huaweiApiClientImpl) {
        this.a = huaweiApiClientImpl;
    }

    public /* synthetic */ HuaweiApiClientImpl$g(HuaweiApiClientImpl huaweiApiClientImpl, HuaweiApiClientImpl$a huaweiApiClientImpl$a) {
        this(huaweiApiClientImpl);
    }

    public void a(ResolveResult resolveResult) {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new HuaweiApiClientImpl$g$a(this, resolveResult);
        handler.post((Runnable)object);
    }
}

