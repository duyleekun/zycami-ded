/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.IStatusCallback$Stub;

public class StatusCallback
extends IStatusCallback$Stub {
    private final BaseImplementation$ResultHolder mResultHolder;

    public StatusCallback(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        this.mResultHolder = baseImplementation$ResultHolder;
    }

    public void onResult(Status status) {
        this.mResultHolder.setResult(status);
    }
}

