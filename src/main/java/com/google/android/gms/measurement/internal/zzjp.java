/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzjq;

public final class zzjp {
    public final /* synthetic */ zzjq zza;

    public zzjp(zzjq zzjq2) {
        this.zza = zzjq2;
    }

    public final void zza() {
        ((zzge)this.zza).zzg();
        Object object = this.zza.zzx.zzd();
        Object object2 = this.zza.zzx.zzax();
        long l10 = object2.currentTimeMillis();
        boolean n10 = ((zzex)object).zzl(l10);
        if (n10) {
            this.zza.zzx.zzd().zzl.zzb(true);
            object = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState((ActivityManager.RunningAppProcessInfo)object);
            int n11 = ((ActivityManager.RunningAppProcessInfo)object).importance;
            int n12 = 100;
            if (n11 == n12) {
                object = this.zza.zzx.zzat().zzk();
                object2 = "Detected application was in foreground";
                ((zzeg)object).zza((String)object2);
                object = this.zza.zzx.zzax();
                long l11 = object.currentTimeMillis();
                this.zzc(l11, false);
            }
        }
    }

    public final void zzb(long l10, boolean bl2) {
        ((zzge)this.zza).zzg();
        zzjq.zzj(this.zza);
        Object object = this.zza.zzx.zzd();
        boolean bl3 = ((zzex)object).zzl(l10);
        if (bl3) {
            object = this.zza.zzx.zzd().zzl;
            boolean bl4 = true;
            ((zzes)object).zzb(bl4);
        }
        this.zza.zzx.zzd().zzo.zzb(l10);
        object = this.zza.zzx.zzd().zzl;
        bl3 = ((zzes)object).zza();
        if (bl3) {
            this.zzc(l10, bl2);
        }
    }

    public final void zzc(long l10, boolean bl2) {
        Object object;
        ((zzge)this.zza).zzg();
        Object object2 = this.zza.zzx;
        boolean bl3 = ((zzfl)object2).zzF();
        if (!bl3) {
            return;
        }
        this.zza.zzx.zzd().zzo.zzb(l10);
        long l11 = this.zza.zzx.zzax().elapsedRealtime();
        Object object3 = this.zza.zzx.zzat().zzk();
        object2 = l11;
        ((zzeg)object3).zzb("Session started, time", object2);
        object2 = l10 / 1000L;
        object3 = this.zza.zzx.zzk();
        Object object4 = "auto";
        String string2 = "_sid";
        Object object5 = object2;
        ((zzhn)object3).zzB((String)object4, string2, object2, l10);
        this.zza.zzx.zzd().zzl.zzb(false);
        Bundle bundle = new Bundle();
        l11 = (Long)object2;
        bundle.putLong("_sid", l11);
        object2 = this.zza.zzx.zzc();
        Object object6 = zzdw.zzai;
        object3 = null;
        bl3 = ((zzae)object2).zzn(null, (zzdv)object6);
        if (bl3 && bl2) {
            l11 = 1L;
            object = "_aib";
            bundle.putLong((String)object, l11);
        }
        object4 = this.zza.zzx.zzk();
        string2 = "auto";
        object5 = "_s";
        ((zzhn)object4).zzt(string2, (String)object5, l10, bundle);
        zzll.zzb();
        object = this.zza.zzx.zzc();
        object2 = zzdw.zzan;
        bl2 = ((zzae)object).zzn(null, (zzdv)object2);
        if (bl2 && !(bl3 = TextUtils.isEmpty((CharSequence)(object = this.zza.zzx.zzd().zzt.zza())))) {
            Bundle bundle2 = new Bundle();
            object2 = "_ffr";
            bundle2.putString((String)object2, (String)object);
            object = this.zza.zzx;
            object6 = ((zzfl)object).zzk();
            object3 = "auto";
            object4 = "_ssr";
            ((zzhn)object6).zzt((String)object3, (String)object4, l10, bundle2);
        }
    }
}

