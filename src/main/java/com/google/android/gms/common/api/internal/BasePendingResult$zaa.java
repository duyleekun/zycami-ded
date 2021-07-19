/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zap;

public final class BasePendingResult$zaa {
    private final /* synthetic */ BasePendingResult zaeb;

    private BasePendingResult$zaa(BasePendingResult basePendingResult) {
        this.zaeb = basePendingResult;
    }

    public /* synthetic */ BasePendingResult$zaa(BasePendingResult basePendingResult, zap zap2) {
        this(basePendingResult);
    }

    public final void finalize() {
        BasePendingResult.zab(BasePendingResult.zaa(this.zaeb));
        super.finalize();
    }
}

