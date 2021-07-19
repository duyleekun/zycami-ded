/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.api;

import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.api.HuaweiApiClientImpl$f;
import com.huawei.hms.support.api.ResolveResult;

public class HuaweiApiClientImpl$f$a
implements Runnable {
    public final /* synthetic */ ResolveResult a;
    public final /* synthetic */ HuaweiApiClientImpl$f b;

    public HuaweiApiClientImpl$f$a(HuaweiApiClientImpl$f f10, ResolveResult resolveResult) {
        this.b = f10;
        this.a = resolveResult;
    }

    public void run() {
        HuaweiApiClientImpl huaweiApiClientImpl = this.b.a;
        ResolveResult resolveResult = this.a;
        HuaweiApiClientImpl.b(huaweiApiClientImpl, resolveResult);
    }
}

