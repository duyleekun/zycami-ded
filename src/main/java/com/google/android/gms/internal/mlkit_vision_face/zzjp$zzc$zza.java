/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;
import com.google.android.gms.internal.mlkit_vision_face.zzju;
import com.google.android.gms.internal.mlkit_vision_face.zzjv;

public final class zzjp$zzc$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzjp$zzc$zza zza;
    private static final /* enum */ zzjp$zzc$zza zzb;
    private static final /* enum */ zzjp$zzc$zza zzc;
    private static final /* enum */ zzjp$zzc$zza zzd;
    private static final /* enum */ zzjp$zzc$zza zze;
    private static final /* enum */ zzjp$zzc$zza zzf;
    private static final zzgi zzg;
    private static final /* synthetic */ zzjp$zzc$zza[] zzi;
    private final int zzh;

    static {
        zzjp$zzc$zza zzjp$zzc$zza;
        zzjp$zzc$zza zzjp$zzc$zza2;
        zzjp$zzc$zza zzjp$zzc$zza3;
        zzjp$zzc$zza zzjp$zzc$zza4;
        zzjp$zzc$zza zzjp$zzc$zza5;
        Object object = new zzjp$zzc$zza("UNKNOWN_ACTION", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjp$zzc$zza5 = new zzjp$zzc$zza("INITIALIZATION", n10, n10);
        int n11 = 2;
        zzc = zzjp$zzc$zza4 = new zzjp$zzc$zza("COMPILATION", n11, n11);
        int n12 = 3;
        zzd = zzjp$zzc$zza3 = new zzjp$zzc$zza("EXECUTION", n12, n12);
        int n13 = 4;
        zze = zzjp$zzc$zza2 = new zzjp$zzc$zza("TEARDOWN", n13, n13);
        int n14 = 5;
        zzf = zzjp$zzc$zza = new zzjp$zzc$zza("VALIDATION", n14, n14);
        zzjp$zzc$zza[] zzjp$zzc$zzaArray = new zzjp$zzc$zza[6];
        zzjp$zzc$zzaArray[0] = object;
        zzjp$zzc$zzaArray[n10] = zzjp$zzc$zza5;
        zzjp$zzc$zzaArray[n11] = zzjp$zzc$zza4;
        zzjp$zzc$zzaArray[n12] = zzjp$zzc$zza3;
        zzjp$zzc$zzaArray[n13] = zzjp$zzc$zza2;
        zzjp$zzc$zzaArray[n14] = zzjp$zzc$zza;
        zzi = zzjp$zzc$zzaArray;
        zzg = object = new zzjv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjp$zzc$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzjp$zzc$zza[] values() {
        return (zzjp$zzc$zza[])zzi.clone();
    }

    public static zzgh zzb() {
        return zzju.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjp$zzc$zza.class.getName();
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

