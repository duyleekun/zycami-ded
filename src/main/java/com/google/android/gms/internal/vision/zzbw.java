/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzby;
import com.google.android.gms.internal.vision.zzbz;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzbw
extends Enum
implements zzih {
    private static final /* enum */ zzbw zzhi;
    private static final /* enum */ zzbw zzhj;
    public static final /* enum */ zzbw zzhk;
    private static final /* enum */ zzbw zzhl;
    private static final /* enum */ zzbw zzhm;
    private static final /* enum */ zzbw zzhn;
    private static final /* enum */ zzbw zzho;
    private static final /* enum */ zzbw zzhp;
    private static final zzig zzhq;
    private static final /* synthetic */ zzbw[] zzhr;
    private final int value;

    static {
        zzbw zzbw2;
        zzbw zzbw3;
        zzbw zzbw4;
        zzbw zzbw5;
        zzbw zzbw6;
        zzbw zzbw7;
        zzbw zzbw8;
        Object object = new zzbw("RGBA", 0, 0);
        zzhi = object;
        int n10 = 1;
        int n11 = 5;
        zzhj = zzbw8 = new zzbw("NV12", n10, n11);
        int n12 = 2;
        zzhk = zzbw7 = new zzbw("NV21", n12, n10);
        int n13 = 3;
        int n14 = 6;
        zzhl = zzbw6 = new zzbw("YV12", n13, n14);
        int n15 = 4;
        int n16 = 7;
        zzhm = zzbw5 = new zzbw("YV21", n15, n16);
        zzhn = zzbw4 = new zzbw("RGB", n11, n12);
        zzho = zzbw3 = new zzbw("GRAY", n14, n13);
        zzhp = zzbw2 = new zzbw("GRAY16", n16, n15);
        zzbw[] zzbwArray = new zzbw[8];
        zzbwArray[0] = object;
        zzbwArray[n10] = zzbw8;
        zzbwArray[n12] = zzbw7;
        zzbwArray[n13] = zzbw6;
        zzbwArray[n15] = zzbw5;
        zzbwArray[n11] = zzbw4;
        zzbwArray[6] = zzbw3;
        zzbwArray[n16] = zzbw2;
        zzhr = zzbwArray;
        zzhq = object = new zzbz();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbw() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzbw[] values() {
        return (zzbw[])zzhr.clone();
    }

    public static zzij zzal() {
        return zzby.zzht;
    }

    public static zzbw zzf(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 7: {
                return zzhm;
            }
            case 6: {
                return zzhl;
            }
            case 5: {
                return zzhj;
            }
            case 4: {
                return zzhp;
            }
            case 3: {
                return zzho;
            }
            case 2: {
                return zzhn;
            }
            case 1: {
                return zzhk;
            }
            case 0: 
        }
        return zzhi;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbw.class.getName();
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

