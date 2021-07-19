/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgo;

public final class zzge$zzs$zzb
extends Enum
implements zzcj {
    private static final /* enum */ zzge$zzs$zzb zzbfd;
    private static final /* enum */ zzge$zzs$zzb zzbfe;
    private static final /* enum */ zzge$zzs$zzb zzbff;
    private static final /* enum */ zzge$zzs$zzb zzbfg;
    private static final /* enum */ zzge$zzs$zzb zzbfh;
    private static final /* enum */ zzge$zzs$zzb zzbfi;
    private static final /* enum */ zzge$zzs$zzb zzbfj;
    private static final /* enum */ zzge$zzs$zzb zzbfk;
    private static final /* enum */ zzge$zzs$zzb zzbfl;
    private static final /* enum */ zzge$zzs$zzb zzbfm;
    private static final /* enum */ zzge$zzs$zzb zzbfn;
    private static final /* enum */ zzge$zzs$zzb zzbfo;
    private static final /* enum */ zzge$zzs$zzb zzbfp;
    private static final /* enum */ zzge$zzs$zzb zzbfq;
    private static final /* enum */ zzge$zzs$zzb zzbfr;
    private static final /* enum */ zzge$zzs$zzb zzbfs;
    private static final /* enum */ zzge$zzs$zzb zzbft;
    private static final /* enum */ zzge$zzs$zzb zzbfu;
    private static final /* enum */ zzge$zzs$zzb zzbfv;
    private static final /* enum */ zzge$zzs$zzb zzbfw;
    private static final /* enum */ zzge$zzs$zzb zzbfx;
    private static final /* synthetic */ zzge$zzs$zzb[] zzbfy;
    private static final zzck zzbq;
    private final int value;

    static {
        zzge$zzs$zzb zzge$zzs$zzb;
        zzge$zzs$zzb zzge$zzs$zzb2;
        zzge$zzs$zzb zzge$zzs$zzb3;
        zzge$zzs$zzb zzge$zzs$zzb4;
        zzge$zzs$zzb zzge$zzs$zzb5;
        zzge$zzs$zzb zzge$zzs$zzb6;
        zzge$zzs$zzb zzge$zzs$zzb7;
        zzge$zzs$zzb zzge$zzs$zzb8;
        zzge$zzs$zzb zzge$zzs$zzb9;
        zzge$zzs$zzb zzge$zzs$zzb10;
        zzge$zzs$zzb zzge$zzs$zzb11;
        zzge$zzs$zzb zzge$zzs$zzb12;
        zzge$zzs$zzb zzge$zzs$zzb13;
        zzge$zzs$zzb zzge$zzs$zzb14;
        Object object = new zzge$zzs$zzb("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
        zzbfd = object;
        int n10 = 1;
        zzbfe = zzge$zzs$zzb14 = new zzge$zzs$zzb("GPRS", n10, n10);
        int n11 = 2;
        zzbff = zzge$zzs$zzb13 = new zzge$zzs$zzb("EDGE", n11, n11);
        int n12 = 3;
        zzbfg = zzge$zzs$zzb12 = new zzge$zzs$zzb("UMTS", n12, n12);
        int n13 = 4;
        zzbfh = zzge$zzs$zzb11 = new zzge$zzs$zzb("CDMA", n13, n13);
        int n14 = 5;
        zzbfi = zzge$zzs$zzb10 = new zzge$zzs$zzb("EVDO_0", n14, n14);
        int n15 = 6;
        zzbfj = zzge$zzs$zzb9 = new zzge$zzs$zzb("EVDO_A", n15, n15);
        n15 = 7;
        zzbfk = zzge$zzs$zzb8 = new zzge$zzs$zzb("RTT", n15, n15);
        n14 = 8;
        zzbfl = zzge$zzs$zzb7 = new zzge$zzs$zzb("HSDPA", n14, n14);
        n13 = 9;
        zzbfm = zzge$zzs$zzb6 = new zzge$zzs$zzb("HSUPA", n13, n13);
        n12 = 10;
        zzbfn = zzge$zzs$zzb5 = new zzge$zzs$zzb("HSPA", n12, n12);
        n11 = 11;
        zzbfo = zzge$zzs$zzb4 = new zzge$zzs$zzb("IDEN", n11, n11);
        n10 = 12;
        zzbfp = zzge$zzs$zzb3 = new zzge$zzs$zzb("EVDO_B", n10, n10);
        int n16 = 13;
        zzbfq = zzge$zzs$zzb2 = new zzge$zzs$zzb("LTE", n16, n16);
        zzge$zzs$zzb zzge$zzs$zzb15 = zzge$zzs$zzb2;
        n11 = 14;
        zzbfr = zzge$zzs$zzb = new zzge$zzs$zzb("EHRPD", n11, n11);
        zzge$zzs$zzb zzge$zzs$zzb16 = zzge$zzs$zzb;
        n10 = 15;
        zzge$zzs$zzb[] zzge$zzs$zzbArray = new zzge$zzs$zzb("HSPAP", n10, n10);
        zzbfs = zzge$zzs$zzbArray;
        zzge$zzs$zzb[] zzge$zzs$zzbArray2 = zzge$zzs$zzbArray;
        n16 = 16;
        zzbft = zzge$zzs$zzb2 = new zzge$zzs$zzb("GSM", n16, n16);
        zzge$zzs$zzb zzge$zzs$zzb17 = zzge$zzs$zzb2;
        n11 = 17;
        zzbfu = zzge$zzs$zzb = new zzge$zzs$zzb("TD_SCDMA", n11, n11);
        zzge$zzs$zzb zzge$zzs$zzb18 = zzge$zzs$zzb;
        n10 = 18;
        zzge$zzs$zzbArray = new zzge$zzs$zzb("IWLAN", n10, n10);
        zzbfv = zzge$zzs$zzbArray;
        zzge$zzs$zzb[] zzge$zzs$zzbArray3 = zzge$zzs$zzbArray;
        n16 = 19;
        zzbfw = zzge$zzs$zzb2 = new zzge$zzs$zzb("LTE_CA", n16, n16);
        n11 = 20;
        zzbfx = zzge$zzs$zzb = new zzge$zzs$zzb("COMBINED", n11, 100);
        zzge$zzs$zzbArray = new zzge$zzs$zzb[21];
        zzge$zzs$zzbArray[0] = object;
        zzge$zzs$zzbArray[1] = zzge$zzs$zzb14;
        zzge$zzs$zzbArray[2] = zzge$zzs$zzb13;
        zzge$zzs$zzbArray[3] = zzge$zzs$zzb12;
        zzge$zzs$zzbArray[4] = zzge$zzs$zzb11;
        zzge$zzs$zzbArray[5] = zzge$zzs$zzb10;
        zzge$zzs$zzbArray[6] = zzge$zzs$zzb9;
        zzge$zzs$zzbArray[7] = zzge$zzs$zzb8;
        zzge$zzs$zzbArray[8] = zzge$zzs$zzb7;
        zzge$zzs$zzbArray[9] = zzge$zzs$zzb6;
        zzge$zzs$zzbArray[10] = zzge$zzs$zzb5;
        zzge$zzs$zzbArray[11] = zzge$zzs$zzb4;
        zzge$zzs$zzbArray[12] = zzge$zzs$zzb3;
        zzge$zzs$zzbArray[13] = zzge$zzs$zzb15;
        zzge$zzs$zzbArray[14] = zzge$zzs$zzb16;
        zzge$zzs$zzbArray[15] = zzge$zzs$zzbArray2;
        zzge$zzs$zzbArray[16] = zzge$zzs$zzb17;
        zzge$zzs$zzbArray[17] = zzge$zzs$zzb18;
        zzge$zzs$zzbArray[18] = zzge$zzs$zzbArray3;
        zzge$zzs$zzbArray[19] = zzge$zzs$zzb2;
        zzge$zzs$zzbArray[n11] = zzge$zzs$zzb;
        zzbfy = zzge$zzs$zzbArray;
        zzbq = object = new zzgo();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zzs$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zzs$zzb[] values() {
        return (zzge$zzs$zzb[])zzbfy.clone();
    }

    public static zzge$zzs$zzb zzaz(int n10) {
        int n11 = 100;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    return null;
                }
                case 19: {
                    return zzbfw;
                }
                case 18: {
                    return zzbfv;
                }
                case 17: {
                    return zzbfu;
                }
                case 16: {
                    return zzbft;
                }
                case 15: {
                    return zzbfs;
                }
                case 14: {
                    return zzbfr;
                }
                case 13: {
                    return zzbfq;
                }
                case 12: {
                    return zzbfp;
                }
                case 11: {
                    return zzbfo;
                }
                case 10: {
                    return zzbfn;
                }
                case 9: {
                    return zzbfm;
                }
                case 8: {
                    return zzbfl;
                }
                case 7: {
                    return zzbfk;
                }
                case 6: {
                    return zzbfj;
                }
                case 5: {
                    return zzbfi;
                }
                case 4: {
                    return zzbfh;
                }
                case 3: {
                    return zzbfg;
                }
                case 2: {
                    return zzbff;
                }
                case 1: {
                    return zzbfe;
                }
                case 0: 
            }
            return zzbfd;
        }
        return zzbfx;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

