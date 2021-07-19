/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgc;
import com.google.android.gms.internal.vision.zzgf;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzgd
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzgd zzsp;
    private static final /* enum */ zzgd zzsq;
    private static final /* enum */ zzgd zzsr;
    private static final /* enum */ zzgd zzss;
    private static final /* enum */ zzgd zzst;
    private static final /* enum */ zzgd zzsu;
    private static final /* enum */ zzgd zzsv;
    private static final /* enum */ zzgd zzsw;
    private static final /* enum */ zzgd zzsx;
    private static final /* enum */ zzgd zzsy;
    private static final /* enum */ zzgd zzsz;
    private static final /* enum */ zzgd zzta;
    private static final /* enum */ zzgd zztb;
    private static final /* enum */ zzgd zztc;
    private static final /* synthetic */ zzgd[] zztd;
    private final int value;

    static {
        zzgd zzgd2;
        zzgd zzgd3;
        zzgd zzgd4;
        zzgd zzgd5;
        zzgd zzgd6;
        zzgd zzgd7;
        zzgd zzgd8;
        zzgd zzgd9;
        zzgd zzgd10;
        zzgd zzgd11;
        zzgd zzgd12;
        zzgd zzgd13;
        zzgd zzgd14;
        Object object = new zzgd("UNKNOWN_FORMAT", 0, 0);
        zzsp = object;
        int n10 = 1;
        zzsq = zzgd14 = new zzgd("CONTACT_INFO", n10, n10);
        int n11 = 2;
        zzsr = zzgd13 = new zzgd("EMAIL", n11, n11);
        int n12 = 3;
        zzss = zzgd12 = new zzgd("ISBN", n12, n12);
        int n13 = 4;
        zzst = zzgd11 = new zzgd("PHONE", n13, n13);
        int n14 = 5;
        zzsu = zzgd10 = new zzgd("PRODUCT", n14, n14);
        int n15 = 6;
        zzsv = zzgd9 = new zzgd("SMS", n15, n15);
        n15 = 7;
        zzsw = zzgd8 = new zzgd("TEXT", n15, n15);
        n14 = 8;
        zzsx = zzgd7 = new zzgd("URL", n14, n14);
        n13 = 9;
        zzsy = zzgd6 = new zzgd("WIFI", n13, n13);
        n12 = 10;
        zzsz = zzgd5 = new zzgd("GEO", n12, n12);
        n11 = 11;
        zzta = zzgd4 = new zzgd("CALENDAR_EVENT", n11, n11);
        n10 = 12;
        zztb = zzgd3 = new zzgd("DRIVER_LICENSE", n10, n10);
        int n16 = 13;
        zztc = zzgd2 = new zzgd("BOARDING_PASS", n16, n16);
        zzgd[] zzgdArray = new zzgd[14];
        zzgdArray[0] = object;
        zzgdArray[1] = zzgd14;
        zzgdArray[2] = zzgd13;
        zzgdArray[3] = zzgd12;
        zzgdArray[4] = zzgd11;
        zzgdArray[5] = zzgd10;
        zzgdArray[6] = zzgd9;
        zzgdArray[7] = zzgd8;
        zzgdArray[8] = zzgd7;
        zzgdArray[9] = zzgd6;
        zzgdArray[10] = zzgd5;
        zzgdArray[11] = zzgd4;
        zzgdArray[12] = zzgd3;
        zzgdArray[n16] = zzgd2;
        zztd = zzgdArray;
        zzhq = object = new zzgc();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzgd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzgd[] values() {
        return (zzgd[])zztd.clone();
    }

    public static zzgd zzaj(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 13: {
                return zztc;
            }
            case 12: {
                return zztb;
            }
            case 11: {
                return zzta;
            }
            case 10: {
                return zzsz;
            }
            case 9: {
                return zzsy;
            }
            case 8: {
                return zzsx;
            }
            case 7: {
                return zzsw;
            }
            case 6: {
                return zzsv;
            }
            case 5: {
                return zzsu;
            }
            case 4: {
                return zzst;
            }
            case 3: {
                return zzss;
            }
            case 2: {
                return zzsr;
            }
            case 1: {
                return zzsq;
            }
            case 0: 
        }
        return zzsp;
    }

    public static zzij zzal() {
        return zzgf.zzht;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzgd.class.getName();
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

