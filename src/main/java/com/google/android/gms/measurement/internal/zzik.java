/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;

public final class zzik
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ zzjb zzc;

    public zzik(zzjb zzjb2, zzp zzp2, Bundle bundle) {
        this.zzc = zzjb2;
        this.zza = zzp2;
        this.zzb = bundle;
    }

    public final void run() {
        zzp zzp2;
        zzdz zzdz2 = zzjb.zzM(this.zzc);
        String string2 = "Failed to send default event parameters to service";
        if (zzdz2 == null) {
            this.zzc.zzx.zzat().zzb().zza(string2);
            return;
        }
        try {
            zzp2 = this.zza;
        }
        catch (RemoteException remoteException) {
            this.zzc.zzx.zzat().zzb().zzb(string2, (Object)remoteException);
            return;
        }
        Preconditions.checkNotNull(zzp2);
        zzp2 = this.zzb;
        zzp zzp3 = this.zza;
        zzdz2.zzt((Bundle)zzp2, zzp3);
    }
}

