/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.adapter.AvailableAdapter$AvailableCallBack;
import com.huawei.hms.common.internal.BaseHmsClient;

public class BaseHmsClient$2
implements AvailableAdapter$AvailableCallBack {
    public final /* synthetic */ BaseHmsClient this$0;

    public BaseHmsClient$2(BaseHmsClient baseHmsClient) {
        this.this$0 = baseHmsClient;
    }

    public void onComplete(int n10) {
        if (n10 == 0) {
            BaseHmsClient baseHmsClient = this.this$0;
            BaseHmsClient.access$700(baseHmsClient);
        } else {
            BaseHmsClient baseHmsClient = this.this$0;
            BaseHmsClient.access$300(baseHmsClient, n10);
        }
    }
}

