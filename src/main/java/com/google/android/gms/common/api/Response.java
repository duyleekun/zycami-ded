/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public class Response {
    private Result zza;

    public Response() {
    }

    public Response(Result result2) {
        this.zza = result2;
    }

    public Result getResult() {
        return this.zza;
    }

    public void setResult(Result result2) {
        this.zza = result2;
    }
}

