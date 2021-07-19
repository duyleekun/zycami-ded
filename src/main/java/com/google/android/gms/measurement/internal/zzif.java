/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;

public final class zzif
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzjb zzb;

    public zzif(zzjb zzjb2, zzp zzp2) {
        this.zzb = zzjb2;
        this.zza = zzp2;
    }

    public final void run() {
        zzdz zzdz2 = zzjb.zzM(this.zzb);
        if (zzdz2 == null) {
            this.zzb.zzx.zzat().zzb().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        Object object = this.zza;
        Preconditions.checkNotNull(object);
        object = this.zza;
        try {
            zzdz2.zzs((zzp)object);
        }
        catch (RemoteException remoteException) {
            object = this.zzb.zzx.zzat().zzb();
            String string2 = "Failed to reset data on the service: remote exception";
            ((zzeg)object).zzb(string2, (Object)remoteException);
        }
        zzjb.zzN(this.zzb);
    }
}

