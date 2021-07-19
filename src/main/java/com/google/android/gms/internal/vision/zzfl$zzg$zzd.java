/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfv;
import com.google.android.gms.internal.vision.zzfw;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzfl$zzg$zzd
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzfl$zzg$zzd zzqf;
    public static final /* enum */ zzfl$zzg$zzd zzqg;
    public static final /* enum */ zzfl$zzg$zzd zzqh;
    public static final /* enum */ zzfl$zzg$zzd zzqi;
    private static final /* synthetic */ zzfl$zzg$zzd[] zzqj;
    private final int value;

    static {
        zzfl$zzg$zzd zzfl$zzg$zzd;
        zzfl$zzg$zzd zzfl$zzg$zzd2;
        zzfl$zzg$zzd zzfl$zzg$zzd3;
        Object object = new zzfl$zzg$zzd("MODE_UNKNOWN", 0, 0);
        zzqf = object;
        int n10 = 1;
        zzqg = zzfl$zzg$zzd3 = new zzfl$zzg$zzd("MODE_ACCURATE", n10, n10);
        int n11 = 2;
        zzqh = zzfl$zzg$zzd2 = new zzfl$zzg$zzd("MODE_FAST", n11, n11);
        int n12 = 3;
        zzqi = zzfl$zzg$zzd = new zzfl$zzg$zzd("MODE_SELFIE", n12, n12);
        zzfl$zzg$zzd[] zzfl$zzg$zzdArray = new zzfl$zzg$zzd[4];
        zzfl$zzg$zzdArray[0] = object;
        zzfl$zzg$zzdArray[n10] = zzfl$zzg$zzd3;
        zzfl$zzg$zzdArray[n11] = zzfl$zzg$zzd2;
        zzfl$zzg$zzdArray[n12] = zzfl$zzg$zzd;
        zzqj = zzfl$zzg$zzdArray;
        zzhq = object = new zzfw();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfl$zzg$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzfl$zzg$zzd[] values() {
        return (zzfl$zzg$zzd[])zzqj.clone();
    }

    public static zzfl$zzg$zzd zzad(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzqi;
                }
                return zzqh;
            }
            return zzqg;
        }
        return zzqf;
    }

    public static zzij zzal() {
        return zzfv.zzht;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzfl$zzg$zzd.class.getName();
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

