/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;
import com.google.android.gms.internal.vision.zzlz;
import com.google.android.gms.internal.vision.zzmb;

public final class zzls$zze$zzc
extends Enum
implements zzih {
    private static final /* enum */ zzls$zze$zzc zzaib;
    private static final /* enum */ zzls$zze$zzc zzaic;
    private static final /* enum */ zzls$zze$zzc zzaid;
    private static final /* enum */ zzls$zze$zzc zzaie;
    private static final /* synthetic */ zzls$zze$zzc[] zzaif;
    private static final zzig zzhq;
    private final int value;

    static {
        zzls$zze$zzc zzls$zze$zzc;
        zzls$zze$zzc zzls$zze$zzc2;
        zzls$zze$zzc zzls$zze$zzc3;
        Object object = new zzls$zze$zzc("VISIBILITY_UNKNOWN", 0, 0);
        zzaib = object;
        int n10 = 1;
        zzaic = zzls$zze$zzc3 = new zzls$zze$zzc("VISIBLE", n10, n10);
        int n11 = 2;
        zzaid = zzls$zze$zzc2 = new zzls$zze$zzc("OCCLUDED_SELF", n11, n11);
        int n12 = 3;
        zzaie = zzls$zze$zzc = new zzls$zze$zzc("OCCLUDED_OTHER", n12, n12);
        zzls$zze$zzc[] zzls$zze$zzcArray = new zzls$zze$zzc[4];
        zzls$zze$zzcArray[0] = object;
        zzls$zze$zzcArray[n10] = zzls$zze$zzc3;
        zzls$zze$zzcArray[n11] = zzls$zze$zzc2;
        zzls$zze$zzcArray[n12] = zzls$zze$zzc;
        zzaif = zzls$zze$zzcArray;
        zzhq = object = new zzlz();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzls$zze$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzls$zze$zzc[] values() {
        return (zzls$zze$zzc[])zzaif.clone();
    }

    public static zzij zzal() {
        return zzmb.zzht;
    }

    public static zzls$zze$zzc zzci(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzaie;
                }
                return zzaid;
            }
            return zzaic;
        }
        return zzaib;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzls$zze$zzc.class.getName();
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

