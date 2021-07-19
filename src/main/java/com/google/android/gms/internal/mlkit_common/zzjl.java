/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;
import com.google.android.gms.internal.mlkit_common.zzjn;
import com.google.android.gms.internal.mlkit_common.zzjo;

public final class zzjl
extends Enum
implements zzfv {
    private static final /* enum */ zzjl zza;
    private static final /* enum */ zzjl zzb;
    private static final /* enum */ zzjl zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzjl[] zzf;
    private final int zze;

    static {
        zzjl zzjl2;
        zzjl zzjl3;
        Object object = new zzjl("UNKNOWN_EVENT_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjl3 = new zzjl("VALIDATION_TEST", n10, n10);
        int n11 = 2;
        zzc = zzjl2 = new zzjl("CONTINUOUS_FEEDBACK", n11, n11);
        zzjl[] zzjlArray = new zzjl[3];
        zzjlArray[0] = object;
        zzjlArray[n10] = zzjl3;
        zzjlArray[n11] = zzjl2;
        zzf = zzjlArray;
        zzd = object = new zzjo();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjl() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzjl[] values() {
        return (zzjl[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzjn.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjl.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zze;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zze;
    }
}

