/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcs;
import com.google.android.gms.internal.vision.zzcu;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzct
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzct zzlq;
    public static final /* enum */ zzct zzlr;
    public static final /* enum */ zzct zzls;
    public static final /* enum */ zzct zzlt;
    private static final /* synthetic */ zzct[] zzlu;
    private final int value;

    static {
        zzct zzct2;
        zzct zzct3;
        zzct zzct4;
        Object object = new zzct("MODE_TYPE_UNKNOWN", 0, 0);
        zzlq = object;
        int n10 = 1;
        zzlr = zzct4 = new zzct("FAST", n10, n10);
        int n11 = 2;
        zzls = zzct3 = new zzct("ACCURATE", n11, n11);
        int n12 = 3;
        zzlt = zzct2 = new zzct("SELFIE", n12, n12);
        zzct[] zzctArray = new zzct[4];
        zzctArray[0] = object;
        zzctArray[n10] = zzct4;
        zzctArray[n11] = zzct3;
        zzctArray[n12] = zzct2;
        zzlu = zzctArray;
        zzhq = object = new zzcs();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzct() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzct[] values() {
        return (zzct[])zzlu.clone();
    }

    public static zzij zzal() {
        return zzcu.zzht;
    }

    public static zzct zzr(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzlt;
                }
                return zzls;
            }
            return zzlr;
        }
        return zzlq;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzct.class.getName();
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

