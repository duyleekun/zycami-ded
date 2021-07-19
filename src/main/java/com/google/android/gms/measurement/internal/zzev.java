/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.util.Pair
 */
package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzer;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzge;
import java.util.Random;

public final class zzev {
    public final String zza;
    public final /* synthetic */ zzex zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    public /* synthetic */ zzev(zzex object, String string2, long l10, zzer zzer2) {
        this.zzb = object;
        object = "health_monitor";
        Preconditions.checkNotEmpty((String)object);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            l12 = 1;
        } else {
            l12 = 0;
            object = null;
        }
        Preconditions.checkArgument((boolean)l12);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = l10;
    }

    private final void zzc() {
        this.zzb.zzg();
        long l10 = this.zzb.zzx.zzax().currentTimeMillis();
        SharedPreferences.Editor editor = this.zzb.zzd().edit();
        String string2 = this.zzc;
        editor.remove(string2);
        string2 = this.zzd;
        editor.remove(string2);
        string2 = this.zza;
        editor.putLong(string2, l10);
        editor.apply();
    }

    private final long zzd() {
        SharedPreferences sharedPreferences = this.zzb.zzd();
        String string2 = this.zza;
        return sharedPreferences.getLong(string2, 0L);
    }

    public final void zza(String string2, long l10) {
        zzex zzex2 = this.zzb;
        zzex2.zzg();
        l10 = this.zzd();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            this.zzc();
        }
        if (string2 == null) {
            string2 = "";
        }
        zzex2 = this.zzb.zzd();
        String string3 = this.zzc;
        l10 = zzex2.getLong(string3, l11);
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l13 = 1L;
        if (object <= 0) {
            zzex2 = this.zzb.zzd().edit();
            string3 = this.zzd;
            zzex2.putString(string3, string2);
            string2 = this.zzc;
            zzex2.putLong(string2, l13);
            zzex2.apply();
            return;
        }
        Object object2 = this.zzb.zzx.zzl().zzf();
        long l14 = ((Random)object2).nextLong();
        l11 = Long.MAX_VALUE;
        long l15 = l11 / (l10 += l13);
        SharedPreferences.Editor editor = this.zzb.zzd().edit();
        long l16 = (l11 &= l14) - l15;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object < 0) {
            object2 = this.zzd;
            editor.putString((String)object2, string2);
        }
        string2 = this.zzc;
        editor.putLong(string2, l10);
        editor.apply();
    }

    public final Pair zzb() {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object;
        this.zzb.zzg();
        Object object2 = this.zzb;
        ((zzge)object2).zzg();
        long l14 = this.zzd();
        long l15 = 0L;
        long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        if (l16 == false) {
            this.zzc();
            l14 = l15;
        } else {
            object = this.zzb.zzx.zzax();
            l13 = object.currentTimeMillis();
            l14 = Math.abs(l14 - l13);
        }
        l13 = this.zze;
        long l17 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1);
        if (l17 < 0) {
            return null;
        }
        if ((l12 = (l11 = l14 - (l13 += l13)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            this.zzc();
            return null;
        }
        object2 = this.zzb.zzd();
        String string2 = this.zzd;
        object2 = object2.getString(string2, null);
        string2 = this.zzb.zzd();
        object = this.zzc;
        l13 = string2.getLong((String)object, l15);
        this.zzc();
        if (object2 != null && (l10 = l13 == l15 ? 0 : (l13 < l15 ? -1 : 1)) > 0) {
            Long l18 = l13;
            string2 = new Pair(object2, (Object)l18);
            return string2;
        }
        return zzex.zza;
    }
}

