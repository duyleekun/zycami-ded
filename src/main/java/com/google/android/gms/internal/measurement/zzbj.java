/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbr;

public final class zzbj
extends zzbg {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzbq zzc;

    public zzbj(zzbq object, Bundle bundle, Activity activity) {
        this.zzc = object;
        this.zza = bundle;
        this.zzb = activity;
        object = ((zzbq)object).zza;
        super((zzbr)object, true);
    }

    public final void zza() {
        Object object;
        Object object2;
        Bundle bundle = this.zza;
        if (bundle != null) {
            boolean bl2;
            bundle = new Bundle();
            object2 = this.zza;
            object = "com.google.app_measurement.screen_service";
            boolean bl3 = object2.containsKey((String)object);
            if (bl3 && (bl2 = (object2 = this.zza.get((String)object)) instanceof Bundle)) {
                object2 = (Bundle)object2;
                bundle.putBundle((String)object, (Bundle)object2);
            }
        } else {
            bundle = null;
        }
        object2 = zzbr.zzR(this.zzc.zza);
        object = ObjectWrapper.wrap(this.zzb);
        long l10 = this.zzi;
        object2.onActivityCreated((IObjectWrapper)object, bundle, l10);
    }
}

