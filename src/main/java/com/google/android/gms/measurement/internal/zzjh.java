/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzjd;
import com.google.android.gms.measurement.internal.zzje;
import com.google.android.gms.measurement.internal.zzjf;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzkd;

public final class zzjh {
    private final Context zza;

    public zzjh(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    private final zzei zzk() {
        return zzfl.zzC(this.zza, null, null).zzat();
    }

    public final void zza() {
        zzfl zzfl2 = zzfl.zzC(this.zza, null, null);
        zzei zzei2 = zzfl2.zzat();
        zzfl2.zzas();
        zzei2.zzk().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzfl zzfl2 = zzfl.zzC(this.zza, null, null);
        zzei zzei2 = zzfl2.zzat();
        zzfl2.zzas();
        zzei2.zzk().zza("Local AppMeasurementService is shutting down");
    }

    public final int zzc(Intent intent, int n10, int n11) {
        Object object = zzfl.zzC(this.zza, null, null);
        zzei zzei2 = ((zzfl)object).zzat();
        int n12 = 2;
        if (intent == null) {
            zzei2.zze().zza("AppMeasurementService started with null intent");
            return n12;
        }
        String string2 = intent.getAction();
        ((zzfl)object).zzas();
        object = zzei2.zzk();
        Integer n13 = n11;
        String string3 = "Local AppMeasurementService called. startId, action";
        ((zzeg)object).zzc(string3, n13, string2);
        object = "com.google.android.gms.measurement.UPLOAD";
        n10 = (int)(((String)object).equals(string2) ? 1 : 0);
        if (n10 != 0) {
            object = new zzjd(this, n11, zzei2, intent);
            this.zzd((Runnable)object);
        }
        return n12;
    }

    public final void zzd(Runnable runnable) {
        zzkd zzkd2 = zzkd.zza(this.zza);
        zzfi zzfi2 = zzkd2.zzau();
        zzjf zzjf2 = new zzjf(this, zzkd2, runnable);
        zzfi2.zzh(zzjf2);
    }

    public final IBinder zze(Intent object) {
        if (object == null) {
            this.zzk().zzb().zza("onBind called with null intent");
            return null;
        }
        Object object2 = "com.google.android.gms.measurement.START";
        boolean bl2 = ((String)object2).equals(object = object.getAction());
        if (bl2) {
            object2 = zzkd.zza(this.zza);
            object = new zzgd((zzkd)object2, null);
            return object;
        }
        this.zzk().zze().zzb("onBind received unknown action", object);
        return null;
    }

    public final boolean zzf(Intent object) {
        boolean bl2 = true;
        if (object == null) {
            this.zzk().zzb().zza("onUnbind called with null intent");
            return bl2;
        }
        object = object.getAction();
        this.zzk().zzk().zzb("onUnbind called for intent. action", object);
        return bl2;
    }

    public final boolean zzg(JobParameters jobParameters) {
        Object object = zzfl.zzC(this.zza, null, null);
        zzei zzei2 = ((zzfl)object).zzat();
        String string2 = jobParameters.getExtras().getString("action");
        ((zzfl)object).zzas();
        object = zzei2.zzk();
        String string3 = "Local AppMeasurementJobService called. action";
        ((zzeg)object).zzb(string3, string2);
        object = "com.google.android.gms.measurement.UPLOAD";
        boolean bl2 = ((String)object).equals(string2);
        if (bl2) {
            object = new zzje(this, zzei2, jobParameters);
            this.zzd((Runnable)object);
        }
        return true;
    }

    public final void zzh(Intent object) {
        if (object == null) {
            this.zzk().zzb().zza("onRebind called with null intent");
            return;
        }
        object = object.getAction();
        this.zzk().zzk().zzb("onRebind called. action", object);
    }

    public final /* synthetic */ void zzi(zzei zzei2, JobParameters jobParameters) {
        zzei2.zzk().zza("AppMeasurementJobService processed last upload request.");
        ((zzjg)this.zza).zzb(jobParameters, false);
    }

    public final /* synthetic */ void zzj(int n10, zzei object, Intent intent) {
        Object object2 = (zzjg)this.zza;
        boolean bl2 = object2.zza(n10);
        if (bl2) {
            object = ((zzei)object).zzk();
            Object object3 = n10;
            object2 = "Local AppMeasurementService processed last upload request. StartId";
            ((zzeg)object).zzb((String)object2, object3);
            object3 = this.zzk().zzk();
            object = "Completed wakeful intent.";
            ((zzeg)object3).zza((String)object);
            object3 = (zzjg)this.zza;
            object3.zzc(intent);
        }
    }
}

