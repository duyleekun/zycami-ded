/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

public abstract class InnerPendingResult
extends PendingResult {
    public abstract Result awaitOnAnyThread();

    public abstract Result awaitOnAnyThread(long var1, TimeUnit var3);
}

