/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.PendingResultUtil$zaa;

public final class zai
implements PendingResultUtil$zaa {
    public final ApiException zaf(Status status) {
        return ApiExceptionUtil.fromStatus(status);
    }
}

