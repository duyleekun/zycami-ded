/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;
import com.google.android.gms.internal.mlkit_vision_face.zzjs;
import com.google.android.gms.internal.mlkit_vision_face.zzjt;

public final class zzjp$zza$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzjp$zza$zza zza;
    private static final /* enum */ zzjp$zza$zza zzb;
    private static final zzgi zzc;
    private static final /* synthetic */ zzjp$zza$zza[] zze;
    private final int zzd;

    static {
        zzjp$zza$zza zzjp$zza$zza;
        Object object = new zzjp$zza$zza("UNKNOWN_ENGINE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjp$zza$zza = new zzjp$zza$zza("TFLITE", n10, n10);
        zzjp$zza$zza[] zzjp$zza$zzaArray = new zzjp$zza$zza[2];
        zzjp$zza$zzaArray[0] = object;
        zzjp$zza$zzaArray[n10] = zzjp$zza$zza;
        zze = zzjp$zza$zzaArray;
        zzc = object = new zzjt();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjp$zza$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzd = var3_1;
    }

    public static zzjp$zza$zza[] values() {
        return (zzjp$zza$zza[])zze.clone();
    }

    public static zzgh zzb() {
        return zzjs.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjp$zza$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzd;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzd;
    }
}

