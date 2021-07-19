/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.app.job.JobInfo
 *  android.app.job.JobInfo$Builder
 *  android.app.job.JobScheduler
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 */
package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzg;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzfb;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkk;

public final class zzjt
extends zzjv {
    private final AlarmManager zzb;
    private zzal zzc;
    private Integer zzd;

    public zzjt(zzkd zzkd2) {
        super(zzkd2);
        zzkd2 = (AlarmManager)this.zzx.zzaw().getSystemService("alarm");
        this.zzb = zzkd2;
    }

    private final zzal zzf() {
        zzal zzal2 = this.zzc;
        if (zzal2 == null) {
            zzfl zzfl2 = this.zza.zzR();
            this.zzc = zzal2 = new zzjs(this, zzfl2);
        }
        return this.zzc;
    }

    private final void zzh() {
        Context context = this.zzx.zzaw();
        String string2 = "jobscheduler";
        if ((context = (JobScheduler)context.getSystemService(string2)) != null) {
            int n10 = this.zzi();
            context.cancel(n10);
        }
    }

    private final int zzi() {
        Object object = this.zzd;
        if (object == null) {
            object = String.valueOf(this.zzx.zzaw().getPackageName());
            String string2 = "measurement";
            int n10 = ((String)object).length();
            object = n10 != 0 ? string2.concat((String)object) : new String(string2);
            int n11 = ((String)object).hashCode();
            this.zzd = object = Integer.valueOf(n11);
        }
        return this.zzd;
    }

    private final PendingIntent zzj() {
        Context context = this.zzx.zzaw();
        Intent intent = new Intent();
        intent = intent.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast((Context)context, (int)0, (Intent)intent, (int)0);
    }

    public final boolean zzaz() {
        int n10;
        int n11;
        AlarmManager alarmManager = this.zzb;
        if (alarmManager != null) {
            PendingIntent pendingIntent = this.zzj();
            alarmManager.cancel(pendingIntent);
        }
        if ((n11 = Build.VERSION.SDK_INT) >= (n10 = 24)) {
            this.zzh();
        }
        return false;
    }

    public final void zzc(long l10) {
        Object object;
        Object object2;
        this.zzX();
        this.zzx.zzas();
        Object object3 = this.zzx.zzaw();
        int n10 = zzfb.zza((Context)object3);
        if (n10 == 0) {
            object2 = this.zzx.zzat().zzj();
            object = "Receiver not registered/enabled";
            ((zzeg)object2).zza((String)object);
        }
        n10 = 0;
        object2 = null;
        int n11 = zzkk.zzP((Context)object3, false);
        if (n11 == 0) {
            object3 = this.zzx.zzat().zzj();
            object2 = "Service not registered/enabled";
            ((zzeg)object3).zza((String)object2);
        }
        this.zzd();
        object3 = this.zzx.zzat().zzk();
        object2 = l10;
        ((zzeg)object3).zzb("Scheduling upload, millis", object2);
        long l11 = this.zzx.zzax().elapsedRealtime() + l10;
        object3 = this.zzx;
        ((zzfl)object3).zzc();
        object = zzdw.zzw;
        PersistableBundle persistableBundle = null;
        object = (Long)((zzdv)object).zzb(null);
        long l12 = (Long)object;
        long l13 = Math.max(0L, l12);
        n11 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        if (n11 < 0 && (n11 = (int)(((zzal)(object3 = this.zzf())).zzc() ? 1 : 0)) == 0) {
            object3 = this.zzf();
            ((zzal)object3).zzb(l10);
        }
        object3 = this.zzx;
        ((zzfl)object3).zzas();
        n11 = Build.VERSION.SDK_INT;
        n10 = 24;
        if (n11 >= n10) {
            object3 = this.zzx.zzaw();
            object2 = new ComponentName((Context)object3, "com.google.android.gms.measurement.AppMeasurementJobService");
            int n12 = this.zzi();
            persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            JobInfo.Builder builder = new JobInfo.Builder(n12, (ComponentName)object2);
            object2 = builder.setMinimumLatency(l10);
            l10 += l10;
            JobInfo jobInfo = object2.setOverrideDeadline(l10).setExtras(persistableBundle).build();
            zzg.zza((Context)object3, jobInfo, "com.google.android.gms", "UploadAlarm");
            return;
        }
        object = this.zzb;
        if (object != null) {
            object3 = this.zzx;
            ((zzfl)object3).zzc();
            n11 = 2;
            object2 = (Long)zzdw.zzr.zzb(null);
            l12 = Math.max((Long)object2, l10);
            PendingIntent pendingIntent = this.zzj();
            object.setInexactRepeating(n11, l11, l12, pendingIntent);
        }
    }

    public final void zzd() {
        this.zzX();
        Object object = this.zzx.zzat().zzk();
        String string2 = "Unscheduling upload";
        ((zzeg)object).zza(string2);
        object = this.zzb;
        if (object != null) {
            string2 = this.zzj();
            object.cancel((PendingIntent)string2);
        }
        object = this.zzf();
        ((zzal)object).zzd();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            this.zzh();
        }
    }
}

