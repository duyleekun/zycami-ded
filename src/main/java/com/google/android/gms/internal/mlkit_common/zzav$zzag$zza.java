/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbu;
import com.google.android.gms.internal.mlkit_common.zzbv;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzag$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzag$zza zza;
    private static final /* enum */ zzav$zzag$zza zzb;
    private static final /* enum */ zzav$zzag$zza zzc;
    private static final /* enum */ zzav$zzag$zza zzd;
    private static final /* enum */ zzav$zzag$zza zze;
    private static final /* enum */ zzav$zzag$zza zzf;
    private static final zzfu zzg;
    private static final /* synthetic */ zzav$zzag$zza[] zzi;
    private final int zzh;

    static {
        zzav$zzag$zza zzav$zzag$zza;
        zzav$zzag$zza zzav$zzag$zza2;
        zzav$zzag$zza zzav$zzag$zza3;
        zzav$zzag$zza zzav$zzag$zza4;
        zzav$zzag$zza zzav$zzag$zza5;
        Object object = new zzav$zzag$zza("SOURCE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzag$zza5 = new zzav$zzag$zza("BITMAP", n10, n10);
        int n11 = 2;
        zzc = zzav$zzag$zza4 = new zzav$zzag$zza("BYTEARRAY", n11, n11);
        int n12 = 3;
        zzd = zzav$zzag$zza3 = new zzav$zzag$zza("BYTEBUFFER", n12, n12);
        int n13 = 4;
        zze = zzav$zzag$zza2 = new zzav$zzag$zza("FILEPATH", n13, n13);
        int n14 = 5;
        zzf = zzav$zzag$zza = new zzav$zzag$zza("ANDROID_MEDIA_IMAGE", n14, n14);
        zzav$zzag$zza[] zzav$zzag$zzaArray = new zzav$zzag$zza[6];
        zzav$zzag$zzaArray[0] = object;
        zzav$zzag$zzaArray[n10] = zzav$zzag$zza5;
        zzav$zzag$zzaArray[n11] = zzav$zzag$zza4;
        zzav$zzag$zzaArray[n12] = zzav$zzag$zza3;
        zzav$zzag$zzaArray[n13] = zzav$zzag$zza2;
        zzav$zzag$zzaArray[n14] = zzav$zzag$zza;
        zzi = zzav$zzag$zzaArray;
        zzg = object = new zzbv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzag$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzav$zzag$zza[] values() {
        return (zzav$zzag$zza[])zzi.clone();
    }

    public static zzfx zzb() {
        return zzbu.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzag$zza.class.getName();
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

