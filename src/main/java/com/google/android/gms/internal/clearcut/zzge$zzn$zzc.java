/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzgk;

public final class zzge$zzn$zzc
extends Enum
implements zzcj {
    private static final zzck zzbq;
    private static final /* enum */ zzge$zzn$zzc zzxl;
    private static final /* enum */ zzge$zzn$zzc zzxm;
    private static final /* enum */ zzge$zzn$zzc zzxn;
    private static final /* enum */ zzge$zzn$zzc zzxo;
    private static final /* enum */ zzge$zzn$zzc zzxp;
    private static final /* enum */ zzge$zzn$zzc zzxq;
    private static final /* enum */ zzge$zzn$zzc zzxr;
    private static final /* enum */ zzge$zzn$zzc zzxs;
    private static final /* enum */ zzge$zzn$zzc zzxt;
    private static final /* enum */ zzge$zzn$zzc zzxu;
    private static final /* synthetic */ zzge$zzn$zzc[] zzxv;
    private final int value;

    static {
        zzge$zzn$zzc zzge$zzn$zzc;
        zzge$zzn$zzc zzge$zzn$zzc2;
        zzge$zzn$zzc zzge$zzn$zzc3;
        zzge$zzn$zzc zzge$zzn$zzc4;
        zzge$zzn$zzc zzge$zzn$zzc5;
        zzge$zzn$zzc zzge$zzn$zzc6;
        zzge$zzn$zzc zzge$zzn$zzc7;
        zzge$zzn$zzc zzge$zzn$zzc8;
        zzge$zzn$zzc zzge$zzn$zzc9;
        Object object = new zzge$zzn$zzc("OS_UNKNOWN", 0, 0);
        zzxl = object;
        int n10 = 1;
        zzxm = zzge$zzn$zzc9 = new zzge$zzn$zzc("MAC", n10, n10);
        int n11 = 2;
        zzxn = zzge$zzn$zzc8 = new zzge$zzn$zzc("WINDOWS", n11, n11);
        int n12 = 3;
        zzxo = zzge$zzn$zzc7 = new zzge$zzn$zzc("ANDROID", n12, n12);
        int n13 = 4;
        zzxp = zzge$zzn$zzc6 = new zzge$zzn$zzc("LINUX", n13, n13);
        int n14 = 5;
        zzxq = zzge$zzn$zzc5 = new zzge$zzn$zzc("CHROME_OS", n14, n14);
        int n15 = 6;
        zzxr = zzge$zzn$zzc4 = new zzge$zzn$zzc("IPAD", n15, n15);
        n15 = 7;
        zzxs = zzge$zzn$zzc3 = new zzge$zzn$zzc("IPHONE", n15, n15);
        n14 = 8;
        zzxt = zzge$zzn$zzc2 = new zzge$zzn$zzc("IPOD", n14, n14);
        n13 = 9;
        zzxu = zzge$zzn$zzc = new zzge$zzn$zzc("CHROMECAST", n13, n13);
        zzge$zzn$zzc[] zzge$zzn$zzcArray = new zzge$zzn$zzc[10];
        zzge$zzn$zzcArray[0] = object;
        zzge$zzn$zzcArray[n10] = zzge$zzn$zzc9;
        zzge$zzn$zzcArray[n11] = zzge$zzn$zzc8;
        zzge$zzn$zzcArray[n12] = zzge$zzn$zzc7;
        zzge$zzn$zzcArray[4] = zzge$zzn$zzc6;
        zzge$zzn$zzcArray[5] = zzge$zzn$zzc5;
        zzge$zzn$zzcArray[6] = zzge$zzn$zzc4;
        zzge$zzn$zzcArray[7] = zzge$zzn$zzc3;
        zzge$zzn$zzcArray[8] = zzge$zzn$zzc2;
        zzge$zzn$zzcArray[n13] = zzge$zzn$zzc;
        zzxv = zzge$zzn$zzcArray;
        zzbq = object = new zzgk();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzge$zzn$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzge$zzn$zzc[] values() {
        return (zzge$zzn$zzc[])zzxv.clone();
    }

    public static zzge$zzn$zzc zzav(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 9: {
                return zzxu;
            }
            case 8: {
                return zzxt;
            }
            case 7: {
                return zzxs;
            }
            case 6: {
                return zzxr;
            }
            case 5: {
                return zzxq;
            }
            case 4: {
                return zzxp;
            }
            case 3: {
                return zzxo;
            }
            case 2: {
                return zzxn;
            }
            case 1: {
                return zzxm;
            }
            case 0: 
        }
        return zzxl;
    }

    public static zzck zzd() {
        return zzbq;
    }

    public final int zzc() {
        return this.value;
    }
}

