/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.internal.AutoLifecycleFragment;

public class AutoLifecycleFragment$ClientInfo {
    public final HuaweiApiClient apiClient;
    public final int clientId;
    public final /* synthetic */ AutoLifecycleFragment this$0;

    public AutoLifecycleFragment$ClientInfo(AutoLifecycleFragment autoLifecycleFragment, int n10, HuaweiApiClient huaweiApiClient) {
        this.this$0 = autoLifecycleFragment;
        this.apiClient = huaweiApiClient;
        this.clientId = n10;
    }

    public void stopAutoManage() {
        this.apiClient.disconnect();
    }
}

