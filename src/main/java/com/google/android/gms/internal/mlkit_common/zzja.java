/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;

public final class zzja
extends Enum {
    public static final /* enum */ zzja zza;
    public static final /* enum */ zzja zzb;
    public static final /* enum */ zzja zzc;
    public static final /* enum */ zzja zzd;
    public static final /* enum */ zzja zze;
    public static final /* enum */ zzja zzf;
    public static final /* enum */ zzja zzg;
    public static final /* enum */ zzja zzh;
    public static final /* enum */ zzja zzi;
    private static final /* synthetic */ zzja[] zzk;
    private final Object zzj;

    static {
        zzja zzja2;
        zzja zzja3;
        zzja zzja4;
        Object object = 0;
        zza = zzja4 = new zzja("INT", 0, object);
        Object object2 = 0L;
        int n10 = 1;
        object = new zzja("LONG", n10, object2);
        zzb = object;
        Object object3 = Float.valueOf(0.0f);
        int n11 = 2;
        object2 = new zzja("FLOAT", n11, object3);
        zzc = object2;
        Object object4 = 0.0;
        int n12 = 3;
        object3 = new zzja("DOUBLE", n12, object4);
        zzd = object3;
        Object object5 = Boolean.FALSE;
        object4 = new zzja("BOOLEAN", 4, object5);
        zze = object4;
        object5 = new zzja("STRING", 5, (Object)"");
        zzf = object5;
        Object object6 = zzep.zza;
        zzg = zzja3 = new zzja("BYTE_STRING", 6, object6);
        object6 = new zzja("ENUM", 7, null);
        zzh = object6;
        int n13 = 8;
        zzi = zzja2 = new zzja("MESSAGE", n13, null);
        zzja[] zzjaArray = new zzja[9];
        zzjaArray[0] = zzja4;
        zzjaArray[n10] = object;
        zzjaArray[n11] = object2;
        zzjaArray[n12] = object3;
        zzjaArray[4] = object4;
        zzjaArray[5] = object5;
        zzjaArray[6] = zzja3;
        zzjaArray[7] = object6;
        zzjaArray[n13] = zzja2;
        zzk = zzjaArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzja() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzj = var3_1;
    }

    public static zzja[] values() {
        return (zzja[])zzk.clone();
    }
}

