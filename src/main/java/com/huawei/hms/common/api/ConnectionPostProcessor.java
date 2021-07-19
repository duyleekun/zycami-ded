/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.api;

import com.huawei.hms.api.HuaweiApiClient;
import java.lang.ref.WeakReference;

public interface ConnectionPostProcessor {
    public void run(HuaweiApiClient var1, WeakReference var2);
}

