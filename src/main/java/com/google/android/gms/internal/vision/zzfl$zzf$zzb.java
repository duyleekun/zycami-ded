/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfp;
import com.google.android.gms.internal.vision.zzfq;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzfl$zzf$zzb
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzfl$zzf$zzb zzpm;
    private static final /* enum */ zzfl$zzf$zzb zzpn;
    private static final /* enum */ zzfl$zzf$zzb zzpo;
    private static final /* enum */ zzfl$zzf$zzb zzpp;
    private static final /* synthetic */ zzfl$zzf$zzb[] zzpq;
    private final int value;

    static {
        zzfl$zzf$zzb zzfl$zzf$zzb;
        zzfl$zzf$zzb zzfl$zzf$zzb2;
        zzfl$zzf$zzb zzfl$zzf$zzb3;
        Object object = new zzfl$zzf$zzb("RESULT_UNKNOWN", 0, 0);
        zzpm = object;
        int n10 = 1;
        zzpn = zzfl$zzf$zzb3 = new zzfl$zzf$zzb("RESULT_SUCCESS", n10, n10);
        int n11 = 2;
        zzpo = zzfl$zzf$zzb2 = new zzfl$zzf$zzb("RESULT_FAIL", n11, n11);
        int n12 = 3;
        zzpp = zzfl$zzf$zzb = new zzfl$zzf$zzb("RESULT_SKIPPED", n12, n12);
        zzfl$zzf$zzb[] zzfl$zzf$zzbArray = new zzfl$zzf$zzb[4];
        zzfl$zzf$zzbArray[0] = object;
        zzfl$zzf$zzbArray[n10] = zzfl$zzf$zzb3;
        zzfl$zzf$zzbArray[n11] = zzfl$zzf$zzb2;
        zzfl$zzf$zzbArray[n12] = zzfl$zzf$zzb;
        zzpq = zzfl$zzf$zzbArray;
        zzhq = object = new zzfp();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfl$zzf$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzfl$zzf$zzb[] values() {
        return (zzfl$zzf$zzb[])zzpq.clone();
    }

    public static zzfl$zzf$zzb zzaa(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzpp;
                }
                return zzpo;
            }
            return zzpn;
        }
        return zzpm;
    }

    public static zzij zzal() {
        return zzfq.zzht;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzfl$zzf$zzb.class.getName();
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

