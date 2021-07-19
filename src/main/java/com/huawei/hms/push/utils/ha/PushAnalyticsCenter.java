/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push.utils.ha;

import com.huawei.hms.push.utils.ha.PushAnalyticsCenter$a;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;

public class PushAnalyticsCenter {
    public PushBaseAnalytics a;

    public static PushAnalyticsCenter getInstance() {
        return PushAnalyticsCenter$a.a();
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.a = pushBaseAnalytics;
    }
}

