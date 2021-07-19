/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.internal.service.zaa;

public final class zaf
extends zaa {
    private final BaseImplementation$ResultHolder mResultHolder;

    public zaf(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        this.mResultHolder = baseImplementation$ResultHolder;
    }

    public final void zaj(int n10) {
        BaseImplementation$ResultHolder baseImplementation$ResultHolder = this.mResultHolder;
        Status status = new Status(n10);
        baseImplementation$ResultHolder.setResult(status);
    }
}

