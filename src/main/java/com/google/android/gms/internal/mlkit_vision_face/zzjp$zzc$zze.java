/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;
import com.google.android.gms.internal.mlkit_vision_face.zzjw;
import com.google.android.gms.internal.mlkit_vision_face.zzjx;

public final class zzjp$zzc$zze
extends Enum
implements zzgf {
    private static final /* enum */ zzjp$zzc$zze zza;
    private static final /* enum */ zzjp$zzc$zze zzb;
    private static final /* enum */ zzjp$zzc$zze zzc;
    private static final /* enum */ zzjp$zzc$zze zzd;
    private static final /* enum */ zzjp$zzc$zze zze;
    private static final /* enum */ zzjp$zzc$zze zzf;
    private static final zzgi zzg;
    private static final /* synthetic */ zzjp$zzc$zze[] zzi;
    private final int zzh;

    static {
        zzjp$zzc$zze zzjp$zzc$zze;
        zzjp$zzc$zze zzjp$zzc$zze2;
        zzjp$zzc$zze zzjp$zzc$zze3;
        zzjp$zzc$zze zzjp$zzc$zze4;
        zzjp$zzc$zze zzjp$zzc$zze5;
        Object object = new zzjp$zzc$zze("UNKNOWN_STATUS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjp$zzc$zze5 = new zzjp$zzc$zze("COMPLETED_EVENT", n10, n10);
        int n11 = 2;
        zzc = zzjp$zzc$zze4 = new zzjp$zzc$zze("MISSING_END_EVENT", n11, n11);
        int n12 = 3;
        zzd = zzjp$zzc$zze3 = new zzjp$zzc$zze("HANG", n12, n12);
        int n13 = 4;
        zze = zzjp$zzc$zze2 = new zzjp$zzc$zze("ABANDONED_FROM_HANG", n13, n13);
        int n14 = 5;
        zzf = zzjp$zzc$zze = new zzjp$zzc$zze("FORCED_CRASH_FROM_HANG", n14, n14);
        zzjp$zzc$zze[] zzjp$zzc$zzeArray = new zzjp$zzc$zze[6];
        zzjp$zzc$zzeArray[0] = object;
        zzjp$zzc$zzeArray[n10] = zzjp$zzc$zze5;
        zzjp$zzc$zzeArray[n11] = zzjp$zzc$zze4;
        zzjp$zzc$zzeArray[n12] = zzjp$zzc$zze3;
        zzjp$zzc$zzeArray[n13] = zzjp$zzc$zze2;
        zzjp$zzc$zzeArray[n14] = zzjp$zzc$zze;
        zzi = zzjp$zzc$zzeArray;
        zzg = object = new zzjx();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjp$zzc$zze() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzjp$zzc$zze[] values() {
        return (zzjp$zzc$zze[])zzi.clone();
    }

    public static zzgh zzb() {
        return zzjw.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjp$zzc$zze.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzh;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzh;
    }
}

