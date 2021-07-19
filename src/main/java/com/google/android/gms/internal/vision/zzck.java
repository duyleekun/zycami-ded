/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcl;
import com.google.android.gms.internal.vision.zzcm;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzck
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzck zzjk;
    public static final /* enum */ zzck zzjl;
    public static final /* enum */ zzck zzjm;
    private static final /* synthetic */ zzck[] zzjn;
    private final int value;

    static {
        zzck zzck2;
        zzck zzck3;
        Object object = new zzck("CLASSIFICATION_TYPE_UNKNOWN", 0, 0);
        zzjk = object;
        int n10 = 1;
        zzjl = zzck3 = new zzck("NO_CLASSIFICATION", n10, n10);
        int n11 = 2;
        zzjm = zzck2 = new zzck("ALL_CLASSIFICATIONS", n11, n11);
        zzck[] zzckArray = new zzck[3];
        zzckArray[0] = object;
        zzckArray[n10] = zzck3;
        zzckArray[n11] = zzck2;
        zzjn = zzckArray;
        zzhq = object = new zzcm();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzck() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzck[] values() {
        return (zzck[])zzjn.clone();
    }

    public static zzij zzal() {
        return zzcl.zzht;
    }

    public static zzck zzo(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return zzjm;
            }
            return zzjl;
        }
        return zzjk;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzck.class.getName();
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

