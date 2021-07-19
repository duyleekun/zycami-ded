/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;

public final class zzio
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzjb zzb;

    public zzio(zzjb zzjb2, zzp zzp2) {
        this.zzb = zzjb2;
        this.zza = zzp2;
    }

    public final void run() {
        zzp zzp2;
        Object object = zzjb.zzM(this.zzb);
        if (object == null) {
            this.zzb.zzx.zzat().zzb().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzp2 = this.zza;
        }
        catch (RemoteException remoteException) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to send measurementEnabled to the service", (Object)remoteException);
            return;
        }
        Preconditions.checkNotNull(zzp2);
        zzp2 = this.zza;
        object.zzh(zzp2);
        object = this.zzb;
        zzjb.zzN((zzjb)object);
    }
}

