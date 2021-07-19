/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil$ResultConverter;

public final class zak
implements PendingResultUtil$ResultConverter {
    private final /* synthetic */ Response zaoz;

    public zak(Response response) {
        this.zaoz = response;
    }

    public final /* synthetic */ Object convert(Result result2) {
        this.zaoz.setResult(result2);
        return this.zaoz;
    }
}

