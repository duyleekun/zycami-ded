/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zaan;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;

public final class zaap
extends zabf {
    private final /* synthetic */ BaseGmsClient$ConnectionProgressReportCallbacks zago;

    public zaap(zaan zaan2, zabd zabd2, BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks) {
        this.zago = baseGmsClient$ConnectionProgressReportCallbacks;
        super(zabd2);
    }

    public final void zaan() {
        BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks = this.zago;
        ConnectionResult connectionResult = new ConnectionResult(16, null);
        baseGmsClient$ConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
    }
}

