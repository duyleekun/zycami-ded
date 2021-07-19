/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaan;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabf;

public final class zaao
extends zabf {
    private final /* synthetic */ ConnectionResult zagm;
    private final /* synthetic */ zaan zagn;

    public zaao(zaan zaan2, zabd zabd2, ConnectionResult connectionResult) {
        this.zagn = zaan2;
        this.zagm = connectionResult;
        super(zabd2);
    }

    public final void zaan() {
        zaak zaak2 = this.zagn.zagj;
        ConnectionResult connectionResult = this.zagm;
        zaak.zaa(zaak2, connectionResult);
    }
}

