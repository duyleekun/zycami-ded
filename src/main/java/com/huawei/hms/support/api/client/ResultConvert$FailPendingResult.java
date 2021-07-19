/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.EmptyPendingResult;
import com.huawei.hms.support.api.client.ResultConvert;
import com.huawei.hms.support.api.client.Status;

public class ResultConvert$FailPendingResult
extends EmptyPendingResult {
    public ResultConvert$FailPendingResult(ResultConvert resultConvert, Status status) {
        this.setResult(status);
    }
}

