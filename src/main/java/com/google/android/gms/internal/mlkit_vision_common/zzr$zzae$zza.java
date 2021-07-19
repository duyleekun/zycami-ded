/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzaq;
import com.google.android.gms.internal.mlkit_vision_common.zzar;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzae$zza
extends Enum
implements zzel {
    public static final /* enum */ zzr$zzae$zza zza;
    public static final /* enum */ zzr$zzae$zza zzb;
    public static final /* enum */ zzr$zzae$zza zzc;
    public static final /* enum */ zzr$zzae$zza zzd;
    public static final /* enum */ zzr$zzae$zza zze;
    public static final /* enum */ zzr$zzae$zza zzf;
    private static final /* enum */ zzr$zzae$zza zzg;
    private static final /* enum */ zzr$zzae$zza zzh;
    private static final /* enum */ zzr$zzae$zza zzi;
    private static final zzeo zzj;
    private static final /* synthetic */ zzr$zzae$zza[] zzl;
    private final int zzk;

    static {
        zzr$zzae$zza zzr$zzae$zza;
        zzr$zzae$zza zzr$zzae$zza2;
        zzr$zzae$zza zzr$zzae$zza3;
        zzr$zzae$zza zzr$zzae$zza4;
        zzr$zzae$zza zzr$zzae$zza5;
        zzr$zzae$zza zzr$zzae$zza6;
        zzr$zzae$zza zzr$zzae$zza7;
        zzr$zzae$zza zzr$zzae$zza8;
        Object object = new zzr$zzae$zza("UNKNOWN_FORMAT", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzae$zza8 = new zzr$zzae$zza("NV16", n10, n10);
        int n11 = 2;
        zzc = zzr$zzae$zza7 = new zzr$zzae$zza("NV21", n11, n11);
        int n12 = 3;
        zzd = zzr$zzae$zza6 = new zzr$zzae$zza("YV12", n12, n12);
        int n13 = 4;
        int n14 = 7;
        zze = zzr$zzae$zza5 = new zzr$zzae$zza("YUV_420_888", n13, n14);
        int n15 = 5;
        int n16 = 8;
        zzg = zzr$zzae$zza4 = new zzr$zzae$zza("JPEG", n15, n16);
        n12 = 6;
        zzf = zzr$zzae$zza3 = new zzr$zzae$zza("BITMAP", n12, n13);
        zzh = zzr$zzae$zza2 = new zzr$zzae$zza("CM_SAMPLE_BUFFER_REF", n14, n15);
        zzi = zzr$zzae$zza = new zzr$zzae$zza("UI_IMAGE", n16, n12);
        zzr$zzae$zza[] zzr$zzae$zzaArray = new zzr$zzae$zza[9];
        zzr$zzae$zzaArray[0] = object;
        zzr$zzae$zzaArray[n10] = zzr$zzae$zza8;
        zzr$zzae$zzaArray[n11] = zzr$zzae$zza7;
        zzr$zzae$zzaArray[3] = zzr$zzae$zza6;
        zzr$zzae$zzaArray[4] = zzr$zzae$zza5;
        zzr$zzae$zzaArray[n15] = zzr$zzae$zza4;
        zzr$zzae$zzaArray[n12] = zzr$zzae$zza3;
        zzr$zzae$zzaArray[7] = zzr$zzae$zza2;
        zzr$zzae$zzaArray[n16] = zzr$zzae$zza;
        zzl = zzr$zzae$zzaArray;
        zzj = object = new zzar();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzae$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzk = var3_1;
    }

    public static zzr$zzae$zza[] values() {
        return (zzr$zzae$zza[])zzl.clone();
    }

    public static zzen zzb() {
        return zzaq.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzae$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzk;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzk;
    }
}

