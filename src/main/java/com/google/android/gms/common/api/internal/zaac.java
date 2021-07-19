/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult$StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zaab;

public final class zaac
implements PendingResult$StatusListener {
    private final /* synthetic */ BasePendingResult zafm;
    private final /* synthetic */ zaab zafn;

    public zaac(zaab zaab2, BasePendingResult basePendingResult) {
        this.zafn = zaab2;
        this.zafm = basePendingResult;
    }

    public final void onComplete(Status object) {
        object = zaab.zaa(this.zafn);
        BasePendingResult basePendingResult = this.zafm;
        object.remove(basePendingResult);
    }
}

