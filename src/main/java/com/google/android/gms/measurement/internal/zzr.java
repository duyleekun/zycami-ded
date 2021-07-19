/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Pair
 */
package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzr {
    private final zzfl zza;

    public zzr(zzfl zzfl2) {
        this.zza = zzfl2;
    }

    public final void zza() {
        Object object = this.zza.zzau();
        ((zzge)object).zzg();
        boolean bl2 = this.zze();
        if (!bl2) {
            return;
        }
        bl2 = this.zzd();
        Object object2 = "_cc";
        String string2 = null;
        if (bl2) {
            this.zza.zzd().zzu.zzb(null);
            object = new Bundle();
            String string3 = "(not set)";
            object.putString("source", string3);
            object.putString("medium", string3);
            object.putString("_cis", "intent");
            long l10 = 1L;
            object.putLong((String)object2, l10);
            object2 = this.zza.zzk();
            string2 = "auto";
            string3 = "_cmpx";
            ((zzhn)object2).zzs(string2, string3, (Bundle)object);
        } else {
            object = this.zza.zzd().zzu.zza();
            boolean bl3 = TextUtils.isEmpty((CharSequence)object);
            if (bl3) {
                object = this.zza.zzat().zzc();
                object2 = "Cache still valid but referrer not found";
                ((zzeg)object).zza((String)object2);
            } else {
                boolean bl4;
                zzeu zzeu2 = this.zza.zzd().zzv;
                long l11 = zzeu2.zza();
                long l12 = 3600000L;
                l11 /= l12;
                long l13 = -1;
                l11 = (l11 + l13) * l12;
                object = Uri.parse((String)object);
                Bundle bundle = new Bundle();
                Object object3 = object.getPath();
                Pair pair = new Pair(object3, (Object)bundle);
                object3 = object.getQueryParameterNames().iterator();
                while (bl4 = object3.hasNext()) {
                    String string4 = (String)object3.next();
                    String string5 = object.getQueryParameter(string4);
                    bundle.putString(string4, string5);
                }
                ((Bundle)pair.second).putLong((String)object2, l11);
                object = this.zza.zzk();
                object2 = (String)pair.first;
                zzeu2 = (Bundle)pair.second;
                String string6 = "_cmp";
                ((zzhn)object).zzs((String)object2, string6, (Bundle)zzeu2);
            }
            object = this.zza.zzd().zzu;
            ((zzew)object).zzb(null);
        }
        this.zza.zzd().zzv.zzb(0L);
    }

    public final void zzb(String object, Bundle object2) {
        ((zzge)this.zza.zzau()).zzg();
        zzfl zzfl2 = this.zza;
        boolean bl2 = zzfl2.zzF();
        if (!bl2) {
            bl2 = object2.isEmpty();
            if (bl2) {
                object = null;
            } else {
                bl2 = true;
                boolean bl3 = ((String)object).isEmpty();
                if (bl2 == bl3) {
                    object = "auto";
                }
                zzfl2 = new Uri.Builder();
                zzfl2.path((String)object);
                object = object2.keySet().iterator();
                while (bl3 = object.hasNext()) {
                    String string2 = (String)object.next();
                    String string3 = object2.getString(string2);
                    zzfl2.appendQueryParameter(string2, string3);
                }
                object = zzfl2.build().toString();
            }
            boolean bl4 = TextUtils.isEmpty((CharSequence)object);
            if (!bl4) {
                this.zza.zzd().zzu.zzb((String)object);
                object = this.zza.zzd().zzv;
                object2 = this.zza.zzax();
                long l10 = object2.currentTimeMillis();
                ((zzeu)object).zzb(l10);
            }
        }
    }

    public final void zzc() {
        boolean bl2 = this.zze();
        if (bl2 && (bl2 = this.zzd())) {
            zzew zzew2 = this.zza.zzd().zzu;
            zzew2.zzb(null);
        }
    }

    public final boolean zzd() {
        zzdv zzdv2;
        Object object = this.zze();
        if (object == 0) {
            return false;
        }
        long l10 = this.zza.zzax().currentTimeMillis();
        long l11 = this.zza.zzd().zzv.zza();
        zzae zzae2 = this.zza.zzc();
        long l12 = (l10 -= l11) - (l11 = zzae2.zzj(null, zzdv2 = zzdw.zzQ));
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object > 0;
    }

    public final boolean zze() {
        long l10;
        zzeu zzeu2 = this.zza.zzd().zzv;
        long l11 = zzeu2.zza();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object > 0;
    }
}

