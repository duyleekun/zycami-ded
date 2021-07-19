/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfn;
import com.google.android.gms.internal.vision.zzfo;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzfl$zze$zza
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzfl$zze$zza zzoy;
    private static final /* enum */ zzfl$zze$zza zzoz;
    private static final /* enum */ zzfl$zze$zza zzpa;
    private static final /* enum */ zzfl$zze$zza zzpb;
    private static final /* synthetic */ zzfl$zze$zza[] zzpc;
    private final int value;

    static {
        zzfl$zze$zza zzfl$zze$zza;
        zzfl$zze$zza zzfl$zze$zza2;
        zzfl$zze$zza zzfl$zze$zza3;
        Object object = new zzfl$zze$zza("REASON_UNKNOWN", 0, 0);
        zzoy = object;
        int n10 = 1;
        zzoz = zzfl$zze$zza3 = new zzfl$zze$zza("REASON_MISSING", n10, n10);
        int n11 = 2;
        zzpa = zzfl$zze$zza2 = new zzfl$zze$zza("REASON_UPGRADE", n11, n11);
        int n12 = 3;
        zzpb = zzfl$zze$zza = new zzfl$zze$zza("REASON_INVALID", n12, n12);
        zzfl$zze$zza[] zzfl$zze$zzaArray = new zzfl$zze$zza[4];
        zzfl$zze$zzaArray[0] = object;
        zzfl$zze$zzaArray[n10] = zzfl$zze$zza3;
        zzfl$zze$zzaArray[n11] = zzfl$zze$zza2;
        zzfl$zze$zzaArray[n12] = zzfl$zze$zza;
        zzpc = zzfl$zze$zzaArray;
        zzhq = object = new zzfo();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfl$zze$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzfl$zze$zza[] values() {
        return (zzfl$zze$zza[])zzpc.clone();
    }

    public static zzij zzal() {
        return zzfn.zzht;
    }

    public static zzfl$zze$zza zzz(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzpb;
                }
                return zzpa;
            }
            return zzoz;
        }
        return zzoy;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzfl$zze$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.value;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zzak() {
        return this.value;
    }
}

