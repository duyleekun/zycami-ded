/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzft;
import com.google.android.gms.internal.vision.zzfu;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzfl$zzg$zzc
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzfl$zzg$zzc zzqa;
    public static final /* enum */ zzfl$zzg$zzc zzqb;
    public static final /* enum */ zzfl$zzg$zzc zzqc;
    public static final /* enum */ zzfl$zzg$zzc zzqd;
    private static final /* synthetic */ zzfl$zzg$zzc[] zzqe;
    private final int value;

    static {
        zzfl$zzg$zzc zzfl$zzg$zzc;
        zzfl$zzg$zzc zzfl$zzg$zzc2;
        zzfl$zzg$zzc zzfl$zzg$zzc3;
        Object object = new zzfl$zzg$zzc("LANDMARK_UNKNOWN", 0, 0);
        zzqa = object;
        int n10 = 1;
        zzqb = zzfl$zzg$zzc3 = new zzfl$zzg$zzc("LANDMARK_NONE", n10, n10);
        int n11 = 2;
        zzqc = zzfl$zzg$zzc2 = new zzfl$zzg$zzc("LANDMARK_ALL", n11, n11);
        int n12 = 3;
        zzqd = zzfl$zzg$zzc = new zzfl$zzg$zzc("LANDMARK_CONTOUR", n12, n12);
        zzfl$zzg$zzc[] zzfl$zzg$zzcArray = new zzfl$zzg$zzc[4];
        zzfl$zzg$zzcArray[0] = object;
        zzfl$zzg$zzcArray[n10] = zzfl$zzg$zzc3;
        zzfl$zzg$zzcArray[n11] = zzfl$zzg$zzc2;
        zzfl$zzg$zzcArray[n12] = zzfl$zzg$zzc;
        zzqe = zzfl$zzg$zzcArray;
        zzhq = object = new zzft();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfl$zzg$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzfl$zzg$zzc[] values() {
        return (zzfl$zzg$zzc[])zzqe.clone();
    }

    public static zzfl$zzg$zzc zzac(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzqd;
                }
                return zzqc;
            }
            return zzqb;
        }
        return zzqa;
    }

    public static zzij zzal() {
        return zzfu.zzht;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzfl$zzg$zzc.class.getName();
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

