/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzay;
import com.google.android.gms.internal.mlkit_vision_common.zzaz;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzal$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzal$zza zza;
    private static final /* enum */ zzr$zzal$zza zzb;
    private static final /* enum */ zzr$zzal$zza zzc;
    private static final /* enum */ zzr$zzal$zza zzd;
    private static final /* enum */ zzr$zzal$zza zze;
    private static final /* enum */ zzr$zzal$zza zzf;
    private static final /* enum */ zzr$zzal$zza zzg;
    private static final zzeo zzh;
    private static final /* synthetic */ zzr$zzal$zza[] zzj;
    private final int zzi;

    static {
        zzr$zzal$zza zzr$zzal$zza;
        zzr$zzal$zza zzr$zzal$zza2;
        zzr$zzal$zza zzr$zzal$zza3;
        zzr$zzal$zza zzr$zzal$zza4;
        zzr$zzal$zza zzr$zzal$zza5;
        zzr$zzal$zza zzr$zzal$zza6;
        Object object = new zzr$zzal$zza("TYPE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzal$zza6 = new zzr$zzal$zza("CUSTOM", n10, n10);
        int n11 = 2;
        zzc = zzr$zzal$zza5 = new zzr$zzal$zza("AUTOML_IMAGE_LABELING", n11, n11);
        int n12 = 3;
        zzd = zzr$zzal$zza4 = new zzr$zzal$zza("BASE_TRANSLATE", n12, n12);
        int n13 = 4;
        zze = zzr$zzal$zza3 = new zzr$zzal$zza("CUSTOM_OBJECT_DETECTION", n13, n13);
        int n14 = 5;
        zzf = zzr$zzal$zza2 = new zzr$zzal$zza("CUSTOM_IMAGE_LABELING", n14, n14);
        int n15 = 6;
        zzg = zzr$zzal$zza = new zzr$zzal$zza("BASE_ENTITY_EXTRACTION", n15, n15);
        zzr$zzal$zza[] zzr$zzal$zzaArray = new zzr$zzal$zza[7];
        zzr$zzal$zzaArray[0] = object;
        zzr$zzal$zzaArray[n10] = zzr$zzal$zza6;
        zzr$zzal$zzaArray[n11] = zzr$zzal$zza5;
        zzr$zzal$zzaArray[n12] = zzr$zzal$zza4;
        zzr$zzal$zzaArray[n13] = zzr$zzal$zza3;
        zzr$zzal$zzaArray[n14] = zzr$zzal$zza2;
        zzr$zzal$zzaArray[n15] = zzr$zzal$zza;
        zzj = zzr$zzal$zzaArray;
        zzh = object = new zzaz();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzal$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzr$zzal$zza[] values() {
        return (zzr$zzal$zza[])zzj.clone();
    }

    public static zzen zzb() {
        return zzay.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzal$zza.class.getName();
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

