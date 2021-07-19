/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbc;
import com.google.android.gms.internal.mlkit_vision_common.zzbd;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzan$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzan$zza zza;
    private static final /* enum */ zzr$zzan$zza zzb;
    private static final /* enum */ zzr$zzan$zza zzc;
    private static final /* enum */ zzr$zzan$zza zzd;
    private static final /* enum */ zzr$zzan$zza zze;
    private static final /* enum */ zzr$zzan$zza zzf;
    private static final /* enum */ zzr$zzan$zza zzg;
    private static final zzeo zzh;
    private static final /* synthetic */ zzr$zzan$zza[] zzj;
    private final int zzi;

    static {
        zzr$zzan$zza zzr$zzan$zza;
        zzr$zzan$zza zzr$zzan$zza2;
        zzr$zzan$zza zzr$zzan$zza3;
        zzr$zzan$zza zzr$zzan$zza4;
        zzr$zzan$zza zzr$zzan$zza5;
        zzr$zzan$zza zzr$zzan$zza6;
        Object object = new zzr$zzan$zza("CATEGORY_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzan$zza6 = new zzr$zzan$zza("CATEGORY_HOME_GOOD", n10, n10);
        int n11 = 2;
        zzc = zzr$zzan$zza5 = new zzr$zzan$zza("CATEGORY_FASHION_GOOD", n11, n11);
        int n12 = 3;
        zzd = zzr$zzan$zza4 = new zzr$zzan$zza("CATEGORY_ANIMAL", n12, n12);
        int n13 = 4;
        zze = zzr$zzan$zza3 = new zzr$zzan$zza("CATEGORY_FOOD", n13, n13);
        int n14 = 5;
        zzf = zzr$zzan$zza2 = new zzr$zzan$zza("CATEGORY_PLACE", n14, n14);
        int n15 = 6;
        zzg = zzr$zzan$zza = new zzr$zzan$zza("CATEGORY_PLANT", n15, n15);
        zzr$zzan$zza[] zzr$zzan$zzaArray = new zzr$zzan$zza[7];
        zzr$zzan$zzaArray[0] = object;
        zzr$zzan$zzaArray[n10] = zzr$zzan$zza6;
        zzr$zzan$zzaArray[n11] = zzr$zzan$zza5;
        zzr$zzan$zzaArray[n12] = zzr$zzan$zza4;
        zzr$zzan$zzaArray[n13] = zzr$zzan$zza3;
        zzr$zzan$zzaArray[n14] = zzr$zzan$zza2;
        zzr$zzan$zzaArray[n15] = zzr$zzan$zza;
        zzj = zzr$zzan$zzaArray;
        zzh = object = new zzbd();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzan$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzr$zzan$zza[] values() {
        return (zzr$zzan$zza[])zzj.clone();
    }

    public static zzen zzb() {
        return zzbc.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzan$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzi;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzi;
    }
}

