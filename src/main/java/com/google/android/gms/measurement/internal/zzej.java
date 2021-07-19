/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzas;

public final class zzej {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final Bundle zzd;

    public zzej(String string2, String string3, Bundle bundle, long l10) {
        this.zza = string2;
        this.zzb = string3;
        this.zzd = bundle;
        this.zzc = l10;
    }

    public static zzej zza(zzas zzas2) {
        String string2 = zzas2.zza;
        String string3 = zzas2.zzc;
        Bundle bundle = zzas2.zzb.zzf();
        long l10 = zzas2.zzd;
        zzej zzej2 = new zzej(string2, string3, bundle, l10);
        return zzej2;
    }

    public final String toString() {
        String string2 = this.zzb;
        String string3 = this.zza;
        String string4 = String.valueOf(this.zzd);
        int n10 = String.valueOf(string2).length();
        int n11 = String.valueOf(string3).length();
        int n12 = String.valueOf(string4).length();
        n10 = n10 + 21 + n11 + n12;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("origin=");
        stringBuilder.append(string2);
        stringBuilder.append(",name=");
        stringBuilder.append(string3);
        stringBuilder.append(",params=");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public final zzas zzb() {
        zzas zzas2;
        String string2 = this.zza;
        Object object = this.zzd;
        Object object2 = new Bundle(object);
        zzaq zzaq2 = new zzaq((Bundle)object2);
        object = this.zzb;
        long l10 = this.zzc;
        object2 = zzas2;
        zzas2 = new zzas(string2, zzaq2, (String)object, l10);
        return zzas2;
    }
}

