/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IGmsCallbacks$zza;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzc;

public final class BaseGmsClient$zze
extends IGmsCallbacks$zza {
    private BaseGmsClient zza;
    private final int zzb;

    public BaseGmsClient$zze(BaseGmsClient baseGmsClient, int n10) {
        this.zza = baseGmsClient;
        this.zzb = n10;
    }

    public final void onPostInitComplete(int n10, IBinder iBinder, Bundle bundle) {
        Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
        BaseGmsClient baseGmsClient = this.zza;
        int n11 = this.zzb;
        baseGmsClient.onPostInitHandler(n10, iBinder, bundle, n11);
        this.zza = null;
    }

    public final void zza(int n10, Bundle bundle) {
        Exception exception = new Exception();
        Log.wtf((String)"GmsClient", (String)"received deprecated onAccountValidationComplete callback, ignoring", (Throwable)exception);
    }

    public final void zza(int n10, IBinder iBinder, zzc zzc2) {
        Preconditions.checkNotNull(this.zza, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(zzc2);
        BaseGmsClient.zza(this.zza, zzc2);
        zzc2 = zzc2.zza;
        this.onPostInitComplete(n10, iBinder, (Bundle)zzc2);
    }
}

