/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager;

public class HuaweiApiManager$ConnectionManager$2
implements Runnable {
    public final /* synthetic */ HuaweiApiManager$ConnectionManager this$1;
    public final /* synthetic */ ConnectionResult val$result;

    public HuaweiApiManager$ConnectionManager$2(HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager, ConnectionResult connectionResult) {
        this.this$1 = huaweiApiManager$ConnectionManager;
        this.val$result = connectionResult;
    }

    public void run() {
        HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager = this.this$1;
        ConnectionResult connectionResult = this.val$result;
        HuaweiApiManager$ConnectionManager.access$500(huaweiApiManager$ConnectionManager, connectionResult);
    }
}

