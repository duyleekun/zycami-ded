/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.ResultCallbacks;
import com.huawei.hms.support.api.client.ResultConvert;

public abstract class ConvertedResult {
    public abstract ConvertedResult convertResult(ResultConvert var1);

    public abstract void finalExec(ResultCallbacks var1);
}

