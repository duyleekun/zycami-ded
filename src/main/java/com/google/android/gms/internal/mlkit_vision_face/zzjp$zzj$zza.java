/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;
import com.google.android.gms.internal.mlkit_vision_face.zzkb;
import com.google.android.gms.internal.mlkit_vision_face.zzkc;

public final class zzjp$zzj$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzjp$zzj$zza zza;
    private static final /* enum */ zzjp$zzj$zza zzb;
    private static final /* enum */ zzjp$zzj$zza zzc;
    private static final /* enum */ zzjp$zzj$zza zzd;
    private static final /* enum */ zzjp$zzj$zza zze;
    private static final zzgi zzf;
    private static final /* synthetic */ zzjp$zzj$zza[] zzh;
    private final int zzg;

    static {
        zzjp$zzj$zza zzjp$zzj$zza;
        zzjp$zzj$zza zzjp$zzj$zza2;
        zzjp$zzj$zza zzjp$zzj$zza3;
        zzjp$zzj$zza zzjp$zzj$zza4;
        Object object = new zzjp$zzj$zza("DELEGATE_NONE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjp$zzj$zza4 = new zzjp$zzj$zza("NNAPI", n10, n10);
        int n11 = 2;
        zzc = zzjp$zzj$zza3 = new zzjp$zzj$zza("GPU", n11, n11);
        int n12 = 3;
        zzd = zzjp$zzj$zza2 = new zzjp$zzj$zza("HEXAGON", n12, n12);
        int n13 = 4;
        zze = zzjp$zzj$zza = new zzjp$zzj$zza("EDGETPU", n13, n13);
        zzjp$zzj$zza[] zzjp$zzj$zzaArray = new zzjp$zzj$zza[5];
        zzjp$zzj$zzaArray[0] = object;
        zzjp$zzj$zzaArray[n10] = zzjp$zzj$zza4;
        zzjp$zzj$zzaArray[n11] = zzjp$zzj$zza3;
        zzjp$zzj$zzaArray[n12] = zzjp$zzj$zza2;
        zzjp$zzj$zzaArray[n13] = zzjp$zzj$zza;
        zzh = zzjp$zzj$zzaArray;
        zzf = object = new zzkc();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjp$zzj$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzjp$zzj$zza[] values() {
        return (zzjp$zzj$zza[])zzh.clone();
    }

    public static zzgh zzb() {
        return zzkb.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjp$zzj$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzg;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzg;
    }
}

