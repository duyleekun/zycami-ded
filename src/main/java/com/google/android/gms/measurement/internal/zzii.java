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
import com.google.android.gms.measurement.internal.zzec;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;

public final class zzii
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzjb zzb;

    public zzii(zzjb zzjb2, zzp zzp2) {
        this.zzb = zzjb2;
        this.zza = zzp2;
    }

    public final void run() {
        Object object;
        Object object2 = zzjb.zzM(this.zzb);
        if (object2 == null) {
            this.zzb.zzx.zzat().zzb().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            object = this.zza;
        }
        catch (RemoteException remoteException) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to send app launch to the service", (Object)remoteException);
            return;
        }
        Preconditions.checkNotNull(object);
        object = this.zza;
        object2.zzf((zzp)object);
        object = this.zzb;
        object = ((zzge)object).zzx;
        object = ((zzfl)object).zzn();
        ((zzec)object).zzn();
        object = this.zzb;
        zzp zzp2 = this.zza;
        ((zzjb)object).zzk((zzdz)object2, null, zzp2);
        object2 = this.zzb;
        zzjb.zzN((zzjb)object2);
    }
}

