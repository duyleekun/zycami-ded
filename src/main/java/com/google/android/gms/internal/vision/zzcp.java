/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcq;
import com.google.android.gms.internal.vision.zzcr;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzcp
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzcp zzlg;
    public static final /* enum */ zzcp zzlh;
    public static final /* enum */ zzcp zzli;
    public static final /* enum */ zzcp zzlj;
    private static final /* synthetic */ zzcp[] zzlk;
    private final int value;

    static {
        zzcp zzcp2;
        zzcp zzcp3;
        zzcp zzcp4;
        Object object = new zzcp("LANDMARK_TYPE_UNKNOWN", 0, 0);
        zzlg = object;
        int n10 = 1;
        zzlh = zzcp4 = new zzcp("NO_LANDMARK", n10, n10);
        int n11 = 2;
        zzli = zzcp3 = new zzcp("ALL_LANDMARKS", n11, n11);
        int n12 = 3;
        zzlj = zzcp2 = new zzcp("CONTOUR_LANDMARKS", n12, n12);
        zzcp[] zzcpArray = new zzcp[4];
        zzcpArray[0] = object;
        zzcpArray[n10] = zzcp4;
        zzcpArray[n11] = zzcp3;
        zzcpArray[n12] = zzcp2;
        zzlk = zzcpArray;
        zzhq = object = new zzcr();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcp() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzcp[] values() {
        return (zzcp[])zzlk.clone();
    }

    public static zzij zzal() {
        return zzcq.zzht;
    }

    public static zzcp zzq(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzlj;
                }
                return zzli;
            }
            return zzlh;
        }
        return zzlg;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcp.class.getName();
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

