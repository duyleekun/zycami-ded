/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager;

public class HuaweiApiManager$ConnectionManager$4
implements Runnable {
    public final /* synthetic */ HuaweiApiManager$ConnectionManager this$1;
    public final /* synthetic */ int val$cause;

    public HuaweiApiManager$ConnectionManager$4(HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager, int n10) {
        this.this$1 = huaweiApiManager$ConnectionManager;
        this.val$cause = n10;
    }

    public void run() {
        HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager = this.this$1;
        int n10 = this.val$cause;
        HuaweiApiManager$ConnectionManager.access$700(huaweiApiManager$ConnectionManager, n10);
    }
}

