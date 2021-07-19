/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbp;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;

public final class zzbq
implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ zzbr zza;

    public zzbq(zzbr zzbr2) {
        this.zza = zzbr2;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzbr zzbr2 = this.zza;
        zzbj zzbj2 = new zzbj(this, bundle, activity);
        zzbr.zzS(zzbr2, zzbj2);
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbr zzbr2 = this.zza;
        zzbp zzbp2 = new zzbp(this, activity);
        zzbr.zzS(zzbr2, zzbp2);
    }

    public final void onActivityPaused(Activity activity) {
        zzbr zzbr2 = this.zza;
        zzbm zzbm2 = new zzbm(this, activity);
        zzbr.zzS(zzbr2, zzbm2);
    }

    public final void onActivityResumed(Activity activity) {
        zzbr zzbr2 = this.zza;
        zzbl zzbl2 = new zzbl(this, activity);
        zzbr.zzS(zzbr2, zzbl2);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzm zzm2 = new zzm();
        zzbr zzbr2 = this.zza;
        zzbo zzbo2 = new zzbo(this, activity, zzm2);
        zzbr.zzS(zzbr2, zzbo2);
        long l10 = 50;
        activity = zzm2.zzd(l10);
        if (activity != null) {
            bundle.putAll((Bundle)activity);
        }
    }

    public final void onActivityStarted(Activity activity) {
        zzbr zzbr2 = this.zza;
        zzbk zzbk2 = new zzbk(this, activity);
        zzbr.zzS(zzbr2, zzbk2);
    }

    public final void onActivityStopped(Activity activity) {
        zzbr zzbr2 = this.zza;
        zzbn zzbn2 = new zzbn(this, activity);
        zzbr.zzS(zzbr2, zzbn2);
    }
}

