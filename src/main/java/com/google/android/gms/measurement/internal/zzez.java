/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zze;
import com.google.android.gms.internal.measurement.zzf;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzfa;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;

public final class zzez
implements ServiceConnection {
    public final /* synthetic */ zzfa zza;
    private final String zzb;

    public zzez(zzfa zzfa2, String string2) {
        this.zza = zzfa2;
        this.zzb = string2;
    }

    public static /* synthetic */ String zza(zzez zzez2) {
        return zzez2.zzb;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceConnected(ComponentName object, IBinder object2) {
        if (object2 == null) {
            this.zza.zza.zzat().zze().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            object = zze.zzb((IBinder)object2);
            if (object == null) {
                object = this.zza;
                object = ((zzfa)object).zza;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zze();
                object2 = "Install Referrer Service implementation was not found";
                ((zzeg)object).zza((String)object2);
                return;
            }
            object2 = this.zza;
            object2 = ((zzfa)object2).zza;
            object2 = ((zzfl)object2).zzat();
            object2 = ((zzei)object2).zzk();
            Object object3 = "Install Referrer Service connected";
            ((zzeg)object2).zza((String)object3);
            object2 = this.zza;
            object2 = ((zzfa)object2).zza;
            object2 = ((zzfl)object2).zzau();
            object3 = new zzey(this, (zzf)object, this);
            ((zzfi)object2).zzh((Runnable)object3);
            return;
        }
        catch (Exception exception) {
            this.zza.zza.zzat().zze().zzb("Exception occurred while calling Install Referrer API", exception);
            return;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzat().zzk().zza("Install Referrer Service disconnected");
    }
}

