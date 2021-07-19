/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzc;
import com.google.android.gms.internal.mlkit_vision_face.zze;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.Arrays;

public final class zzf {
    private final String zza;
    private final zze zzb;
    private zze zzc;
    private boolean zzd;

    private zzf(String string2) {
        zze zze2;
        this.zzb = zze2 = new zze(null);
        this.zzc = zze2;
        this.zzd = false;
        this.zza = string2 = (String)zzj.zza(string2);
    }

    public /* synthetic */ zzf(String string2, zzc zzc2) {
        this(string2);
    }

    private final zzf zzb(String string2, Object object) {
        zze zze2;
        this.zzc.zzc = zze2 = new zze(null);
        this.zzc = zze2;
        zze2.zzb = object;
        zze2.zza = string2 = (String)zzj.zza(string2);
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        Object object = this.zza;
        stringBuilder.append((String)object);
        char c10 = '{';
        stringBuilder.append(c10);
        object = this.zzb.zzc;
        Object object2 = "";
        while (object != null) {
            char c11;
            Object object3 = ((zze)object).zzb;
            stringBuilder.append((String)object2);
            object2 = ((zze)object).zza;
            if (object2 != null) {
                stringBuilder.append((String)object2);
                c11 = '=';
                stringBuilder.append(c11);
            }
            if (object3 != null && (c11 = (char)(((Class)(object2 = object3.getClass())).isArray() ? 1 : 0)) != '\u0000') {
                c11 = '\u0001';
                Object[] objectArray = new Object[c11];
                objectArray[0] = object3;
                object3 = Arrays.deepToString(objectArray);
                int n10 = ((String)object3).length() - c11;
                stringBuilder.append((CharSequence)object3, (int)c11, n10);
            } else {
                stringBuilder.append(object3);
            }
            object = ((zze)object).zzc;
            object2 = ", ";
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final zzf zza(String string2, float f10) {
        String string3 = String.valueOf(f10);
        return this.zzb(string2, string3);
    }

    public final zzf zza(String string2, int n10) {
        String string3 = String.valueOf(n10);
        return this.zzb(string2, string3);
    }

    public final zzf zza(String string2, Object object) {
        return this.zzb(string2, object);
    }

    public final zzf zza(String string2, boolean bl2) {
        String string3 = String.valueOf(bl2);
        return this.zzb(string2, string3);
    }
}

