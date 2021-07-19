/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.api;

import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.api.HuaweiApiClientImpl$g;
import com.huawei.hms.support.api.ResolveResult;

public class HuaweiApiClientImpl$g$a
implements Runnable {
    public final /* synthetic */ ResolveResult a;
    public final /* synthetic */ HuaweiApiClientImpl$g b;

    public HuaweiApiClientImpl$g$a(HuaweiApiClientImpl$g g10, ResolveResult resolveResult) {
        this.b = g10;
        this.a = resolveResult;
    }

    public void run() {
        HuaweiApiClientImpl huaweiApiClientImpl = this.b.a;
        ResolveResult resolveResult = this.a;
        HuaweiApiClientImpl.a(huaweiApiClientImpl, resolveResult);
    }
}

