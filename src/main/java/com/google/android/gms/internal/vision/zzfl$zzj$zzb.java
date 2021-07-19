/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfx;
import com.google.android.gms.internal.vision.zzfy;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzfl$zzj$zzb
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzfl$zzj$zzb zzra;
    private static final /* enum */ zzfl$zzj$zzb zzrb;
    private static final /* enum */ zzfl$zzj$zzb zzrc;
    private static final /* enum */ zzfl$zzj$zzb zzrd;
    private static final /* synthetic */ zzfl$zzj$zzb[] zzre;
    private final int value;

    static {
        zzfl$zzj$zzb zzfl$zzj$zzb;
        zzfl$zzj$zzb zzfl$zzj$zzb2;
        zzfl$zzj$zzb zzfl$zzj$zzb3;
        Object object = new zzfl$zzj$zzb("FORMAT_UNKNOWN", 0, 0);
        zzra = object;
        int n10 = 1;
        zzrb = zzfl$zzj$zzb3 = new zzfl$zzj$zzb("FORMAT_LUMINANCE", n10, n10);
        int n11 = 2;
        zzrc = zzfl$zzj$zzb2 = new zzfl$zzj$zzb("FORMAT_RGB8", n11, n11);
        int n12 = 3;
        zzrd = zzfl$zzj$zzb = new zzfl$zzj$zzb("FORMAT_MONOCHROME", n12, n12);
        zzfl$zzj$zzb[] zzfl$zzj$zzbArray = new zzfl$zzj$zzb[4];
        zzfl$zzj$zzbArray[0] = object;
        zzfl$zzj$zzbArray[n10] = zzfl$zzj$zzb3;
        zzfl$zzj$zzbArray[n11] = zzfl$zzj$zzb2;
        zzfl$zzj$zzbArray[n12] = zzfl$zzj$zzb;
        zzre = zzfl$zzj$zzbArray;
        zzhq = object = new zzfx();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfl$zzj$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzfl$zzj$zzb[] values() {
        return (zzfl$zzj$zzb[])zzre.clone();
    }

    public static zzfl$zzj$zzb zzae(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return zzrd;
                }
                return zzrc;
            }
            return zzrb;
        }
        return zzra;
    }

    public static zzij zzal() {
        return zzfy.zzht;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzfl$zzj$zzb.class.getName();
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

