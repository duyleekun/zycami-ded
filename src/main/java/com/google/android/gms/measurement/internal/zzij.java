/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhu;
import com.google.android.gms.measurement.internal.zzjb;

public final class zzij
implements Runnable {
    public final /* synthetic */ zzhu zza;
    public final /* synthetic */ zzjb zzb;

    public zzij(zzjb zzjb2, zzhu zzhu2) {
        this.zzb = zzjb2;
        this.zza = zzhu2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = this.zzb;
        zzdz zzdz2 = zzjb.zzM((zzjb)object);
        if (zzdz2 == null) {
            this.zzb.zzx.zzat().zzb().zza("Failed to send current screen to service");
            return;
        }
        try {
            object = this.zza;
            if (object == null) {
                object = this.zzb;
                object = ((zzge)object).zzx;
                object = ((zzfl)object).zzaw();
                long l10 = 0L;
                Object var5_6 = null;
                Object var6_8 = null;
                String string2 = object.getPackageName();
                zzdz2.zzk(l10, null, null, string2);
            } else {
                long l11 = ((zzhu)object).zzc;
                String string3 = ((zzhu)object).zza;
                String string4 = ((zzhu)object).zzb;
                object = this.zzb;
                object = ((zzge)object).zzx;
                object = ((zzfl)object).zzaw();
                String string5 = object.getPackageName();
                zzdz2.zzk(l11, string3, string4, string5);
            }
            object = this.zzb;
            zzjb.zzN((zzjb)object);
            return;
        }
        catch (RemoteException remoteException) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to send current screen to the service", (Object)remoteException);
            return;
        }
    }
}

