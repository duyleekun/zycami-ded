/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzaa;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzz;

public final class zzr$zzy$zza$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzy$zza$zza zza;
    private static final /* enum */ zzr$zzy$zza$zza zzb;
    private static final /* enum */ zzr$zzy$zza$zza zzc;
    private static final /* enum */ zzr$zzy$zza$zza zzd;
    private static final /* enum */ zzr$zzy$zza$zza zze;
    private static final zzeo zzf;
    private static final /* synthetic */ zzr$zzy$zza$zza[] zzh;
    private final int zzg;

    static {
        zzr$zzy$zza$zza zzr$zzy$zza$zza;
        zzr$zzy$zza$zza zzr$zzy$zza$zza2;
        zzr$zzy$zza$zza zzr$zzy$zza$zza3;
        zzr$zzy$zza$zza zzr$zzy$zza$zza4;
        Object object = new zzr$zzy$zza$zza("UNKNOWN_DATA_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzy$zza$zza4 = new zzr$zzy$zza$zza("TYPE_FLOAT32", n10, n10);
        int n11 = 2;
        zzc = zzr$zzy$zza$zza3 = new zzr$zzy$zza$zza("TYPE_INT32", n11, n11);
        int n12 = 3;
        zzd = zzr$zzy$zza$zza2 = new zzr$zzy$zza$zza("TYPE_BYTE", n12, n12);
        int n13 = 4;
        zze = zzr$zzy$zza$zza = new zzr$zzy$zza$zza("TYPE_LONG", n13, n13);
        zzr$zzy$zza$zza[] zzr$zzy$zza$zzaArray = new zzr$zzy$zza$zza[5];
        zzr$zzy$zza$zzaArray[0] = object;
        zzr$zzy$zza$zzaArray[n10] = zzr$zzy$zza$zza4;
        zzr$zzy$zza$zzaArray[n11] = zzr$zzy$zza$zza3;
        zzr$zzy$zza$zzaArray[n12] = zzr$zzy$zza$zza2;
        zzr$zzy$zza$zzaArray[n13] = zzr$zzy$zza$zza;
        zzh = zzr$zzy$zza$zzaArray;
        zzf = object = new zzaa();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzy$zza$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzr$zzy$zza$zza[] values() {
        return (zzr$zzy$zza$zza[])zzh.clone();
    }

    public static zzen zzb() {
        return zzz.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzy$zza$zza.class.getName();
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

