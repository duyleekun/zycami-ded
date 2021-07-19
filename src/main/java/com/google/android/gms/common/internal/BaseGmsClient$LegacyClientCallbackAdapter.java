/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import java.util.Set;

public class BaseGmsClient$LegacyClientCallbackAdapter
implements BaseGmsClient$ConnectionProgressReportCallbacks {
    private final /* synthetic */ BaseGmsClient zza;

    public BaseGmsClient$LegacyClientCallbackAdapter(BaseGmsClient baseGmsClient) {
        this.zza = baseGmsClient;
    }

    public void onReportServiceBinding(ConnectionResult object) {
        boolean bl2 = ((ConnectionResult)object).isSuccess();
        if (bl2) {
            object = this.zza;
            Set set = ((BaseGmsClient)object).getScopes();
            ((BaseGmsClient)object).getRemoteService(null, set);
            return;
        }
        BaseGmsClient$BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener = BaseGmsClient.zzg(this.zza);
        if (baseGmsClient$BaseOnConnectionFailedListener != null) {
            baseGmsClient$BaseOnConnectionFailedListener = BaseGmsClient.zzg(this.zza);
            baseGmsClient$BaseOnConnectionFailedListener.onConnectionFailed((ConnectionResult)object);
        }
    }
}

