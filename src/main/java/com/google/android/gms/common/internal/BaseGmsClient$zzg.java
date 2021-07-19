/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$zza;

public final class BaseGmsClient$zzg
extends BaseGmsClient$zza {
    private final /* synthetic */ BaseGmsClient zza;

    public BaseGmsClient$zzg(BaseGmsClient baseGmsClient, int n10, Bundle bundle) {
        this.zza = baseGmsClient;
        super(baseGmsClient, n10, null);
    }

    public final void zza(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.zza;
        boolean bl2 = baseGmsClient.enableLocalFallback();
        if (bl2 && (bl2 = BaseGmsClient.zzb(baseGmsClient = this.zza))) {
            BaseGmsClient.zza(this.zza, 16);
            return;
        }
        this.zza.zzb.onReportServiceBinding(connectionResult);
        this.zza.onConnectionFailed(connectionResult);
    }

    public final boolean zza() {
        BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks = this.zza.zzb;
        ConnectionResult connectionResult = ConnectionResult.RESULT_SUCCESS;
        baseGmsClient$ConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
        return true;
    }
}

