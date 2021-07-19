/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzka;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkj;

public final class zzkb
implements zzkj {
    public final /* synthetic */ zzkd zza;

    public zzkb(zzkd zzkd2) {
        this.zza = zzkd2;
    }

    public final void zza(String string2, Bundle bundle) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            zzkd.zzab(this.zza).zzat().zzb().zza("AppId not known when logging error event");
            return;
        }
        zzfi zzfi2 = this.zza.zzau();
        zzka zzka2 = new zzka(this, string2, bundle);
        zzfi2.zzh(zzka2);
    }
}

