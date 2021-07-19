/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

public class Response {
    public Result result;

    public Response() {
    }

    public Response(Result result2) {
        this.result = result2;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result2) {
        this.result = result2;
    }
}

