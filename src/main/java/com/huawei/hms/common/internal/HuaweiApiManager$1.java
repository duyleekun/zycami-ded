/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.HuaweiApiManager;
import d.j.d.a.l;

public class HuaweiApiManager$1
implements Runnable {
    public final /* synthetic */ HuaweiApiManager this$0;
    public final /* synthetic */ HuaweiApi val$api;
    public final /* synthetic */ l val$completionSource;

    public HuaweiApiManager$1(HuaweiApiManager huaweiApiManager, HuaweiApi huaweiApi, l l10) {
        this.this$0 = huaweiApiManager;
        this.val$api = huaweiApi;
        this.val$completionSource = l10;
    }

    public void run() {
        HuaweiApiManager huaweiApiManager = this.this$0;
        HuaweiApi huaweiApi = this.val$api;
        l l10 = this.val$completionSource;
        HuaweiApiManager.access$000(huaweiApiManager, huaweiApi, l10);
    }
}

