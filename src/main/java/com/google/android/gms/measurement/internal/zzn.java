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
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgl;

public final class zzn
implements zzgl {
    public final zzv zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, zzv zzv2) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzv2;
    }

    public final void interceptEvent(String string2, String object, Bundle object2, long l10) {
        zzv zzv2;
        try {
            zzv2 = this.zza;
        }
        catch (RemoteException remoteException) {
            object = this.zzb.zza;
            if (object != null) {
                object = ((zzfl)object).zzat().zze();
                object2 = "Event interceptor threw exception";
                ((zzeg)object).zzb((String)object2, (Object)remoteException);
            }
            return;
        }
        zzv2.zzd(string2, (String)object, (Bundle)object2, l10);
    }
}

