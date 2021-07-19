/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;

public final class zzjo
extends Enum {
    public static final /* enum */ zzjo zza;
    public static final /* enum */ zzjo zzb;
    public static final /* enum */ zzjo zzc;
    public static final /* enum */ zzjo zzd;
    public static final /* enum */ zzjo zze;
    public static final /* enum */ zzjo zzf;
    public static final /* enum */ zzjo zzg;
    public static final /* enum */ zzjo zzh;
    public static final /* enum */ zzjo zzi;
    private static final /* synthetic */ zzjo[] zzk;
    private final Object zzj;

    static {
        zzjo zzjo2;
        zzjo zzjo3;
        zzjo zzjo4;
        Object object = 0;
        zza = zzjo4 = new zzjo("INT", 0, object);
        Object object2 = 0L;
        int n10 = 1;
        object = new zzjo("LONG", n10, object2);
        zzb = object;
        Object object3 = Float.valueOf(0.0f);
        int n11 = 2;
        object2 = new zzjo("FLOAT", n11, object3);
        zzc = object2;
        Object object4 = 0.0;
        int n12 = 3;
        object3 = new zzjo("DOUBLE", n12, object4);
        zzd = object3;
        Object object5 = Boolean.FALSE;
        object4 = new zzjo("BOOLEAN", 4, object5);
        zze = object4;
        object5 = new zzjo("STRING", 5, (Object)"");
        zzf = object5;
        Object object6 = zzez.zza;
        zzg = zzjo3 = new zzjo("BYTE_STRING", 6, object6);
        object6 = new zzjo("ENUM", 7, null);
        zzh = object6;
        int n13 = 8;
        zzi = zzjo2 = new zzjo("MESSAGE", n13, null);
        zzjo[] zzjoArray = new zzjo[9];
        zzjoArray[0] = zzjo4;
        zzjoArray[n10] = object;
        zzjoArray[n11] = object2;
        zzjoArray[n12] = object3;
        zzjoArray[4] = object4;
        zzjoArray[5] = object5;
        zzjoArray[6] = zzjo3;
        zzjoArray[7] = object6;
        zzjoArray[n13] = zzjo2;
        zzk = zzjoArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjo() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzj = var3_1;
    }

    public static zzjo[] values() {
        return (zzjo[])zzk.clone();
    }
}

