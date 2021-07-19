/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;

public abstract class OptionalPendingResult
extends PendingResult {
    public abstract Result get();

    public abstract boolean isDone();
}

