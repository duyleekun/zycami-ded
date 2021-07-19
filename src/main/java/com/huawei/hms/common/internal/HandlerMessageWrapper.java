/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseContentWrapper;

public class HandlerMessageWrapper {
    public final HuaweiApi mApi;
    public final BaseContentWrapper mContentWrapper;

    public HandlerMessageWrapper(BaseContentWrapper baseContentWrapper, int n10, HuaweiApi huaweiApi) {
        this.mContentWrapper = baseContentWrapper;
        this.mApi = huaweiApi;
    }
}

