/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;
import com.google.android.gms.internal.mlkit_vision_face.zzjy;
import com.google.android.gms.internal.mlkit_vision_face.zzka;

public final class zzjz
extends Enum
implements zzgf {
    private static final /* enum */ zzjz zza;
    private static final /* enum */ zzjz zzb;
    private static final /* enum */ zzjz zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzjz[] zzf;
    private final int zze;

    static {
        zzjz zzjz2;
        zzjz zzjz3;
        Object object = new zzjz("UNKNOWN_EVENT_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjz3 = new zzjz("VALIDATION_TEST", n10, n10);
        int n11 = 2;
        zzc = zzjz2 = new zzjz("CONTINUOUS_FEEDBACK", n11, n11);
        zzjz[] zzjzArray = new zzjz[3];
        zzjzArray[0] = object;
        zzjzArray[n10] = zzjz3;
        zzjzArray[n11] = zzjz2;
        zzf = zzjzArray;
        zzd = object = new zzjy();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjz() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzjz[] values() {
        return (zzjz[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzka.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjz.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zze;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zze;
    }
}

