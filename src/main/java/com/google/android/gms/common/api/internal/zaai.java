/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zaah;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabf;

public final class zaai
extends zabf {
    private final /* synthetic */ zaah zafv;

    public zaai(zaah zaah2, zabd zabd2) {
        this.zafv = zaah2;
        super(zabd2);
    }

    public final void zaan() {
        this.zafv.onConnectionSuspended(1);
    }
}

