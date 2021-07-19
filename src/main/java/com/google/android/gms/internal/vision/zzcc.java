/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcd;
import com.google.android.gms.internal.vision.zzce;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzcc
extends Enum
implements zzih {
    private static final zzig zzhq;
    public static final /* enum */ zzcc zzic;
    public static final /* enum */ zzcc zzid;
    public static final /* enum */ zzcc zzie;
    public static final /* enum */ zzcc zzif;
    private static final /* synthetic */ zzcc[] zzig;
    private final int value;

    static {
        zzcc zzcc2;
        zzcc zzcc3;
        zzcc zzcc4;
        Object object = new zzcc("ROTATION_0", 0, 0);
        zzic = object;
        int n10 = 1;
        zzid = zzcc4 = new zzcc("ROTATION_90", n10, n10);
        int n11 = 2;
        zzie = zzcc3 = new zzcc("ROTATION_180", n11, n11);
        int n12 = 3;
        zzif = zzcc2 = new zzcc("ROTATION_270", n12, n12);
        zzcc[] zzccArray = new zzcc[4];
        zzccArray[0] = object;
        zzccArray[n10] = zzcc4;
        zzccArray[n11] = zzcc3;
        zzccArray[n12] = zzcc2;
        zzig = zzccArray;
        zzhq = object = new zzce();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzcc[] values() {
        return (zzcc[])zzig.clone();
    }

    public static zzij zzal() {
        return zzcd.zzht;
    }

    public static zzcc zzi(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzif;
                }
                return zzie;
            }
            return zzid;
        }
        return zzic;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcc.class.getName();
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

