/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public class ApiExceptionUtil {
    public static ApiException fromStatus(Status status) {
        boolean bl2 = status.hasResolution();
        if (bl2) {
            ResolvableApiException resolvableApiException = new ResolvableApiException(status);
            return resolvableApiException;
        }
        ApiException apiException = new ApiException(status);
        return apiException;
    }
}

