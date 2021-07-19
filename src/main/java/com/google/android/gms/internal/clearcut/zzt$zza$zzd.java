/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzx;

public final class zzt$zza$zzd
extends Enum
implements zzcj {
    private static final zzck zzbq;
    private static final /* enum */ zzt$zza$zzd zzcf;
    private static final /* enum */ zzt$zza$zzd zzcg;
    private static final /* enum */ zzt$zza$zzd zzch;
    private static final /* enum */ zzt$zza$zzd zzci;
    private static final /* enum */ zzt$zza$zzd zzcj;
    private static final /* enum */ zzt$zza$zzd zzck;
    private static final /* enum */ zzt$zza$zzd zzcl;
    private static final /* enum */ zzt$zza$zzd zzcm;
    private static final /* enum */ zzt$zza$zzd zzcn;
    private static final /* enum */ zzt$zza$zzd zzco;
    private static final /* synthetic */ zzt$zza$zzd[] zzcp;
    private final int value;

    static {
        zzt$zza$zzd zzt$zza$zzd;
        zzt$zza$zzd zzt$zza$zzd2;
        zzt$zza$zzd zzt$zza$zzd3;
        zzt$zza$zzd zzt$zza$zzd4;
        zzt$zza$zzd zzt$zza$zzd5;
        zzt$zza$zzd zzt$zza$zzd6;
        zzt$zza$zzd zzt$zza$zzd7;
        zzt$zza$zzd zzt$zza$zzd8;
        zzt$zza$zzd zzt$zza$zzd9;
        Object object = new zzt$zza$zzd("DENSITY_UNKNOWN", 0, 0);
        zzcf = object;
        int n10 = 1;
        zzcg = zzt$zza$zzd9 = new zzt$zza$zzd("DENSITY_ALLDPI", n10, n10);
        int n11 = 2;
        zzch = zzt$zza$zzd8 = new zzt$zza$zzd("DENSITY_LDPI", n11, n11);
        int n12 = 3;
        zzci = zzt$zza$zzd7 = new zzt$zza$zzd("DENSITY_MDPI", n12, n12);
        int n13 = 4;
        zzcj = zzt$zza$zzd6 = new zzt$zza$zzd("DENSITY_TVDPI", n13, n13);
        int n14 = 5;
        zzck = zzt$zza$zzd5 = new zzt$zza$zzd("DENSITY_HDPI", n14, n14);
        int n15 = 7;
        zzcl = zzt$zza$zzd4 = new zzt$zza$zzd("DENSITY_XHDPI", 6, n15);
        n14 = 8;
        zzcm = zzt$zza$zzd3 = new zzt$zza$zzd("DENSITY_DPI400", n15, n14);
        n13 = 9;
        zzcn = zzt$zza$zzd2 = new zzt$zza$zzd("DENSITY_XXHDPI", n14, n13);
        n12 = 10;
        zzco = zzt$zza$zzd = new zzt$zza$zzd("DENSITY_XXXHDPI", n13, n12);
        zzt$zza$zzd[] zzt$zza$zzdArray = new zzt$zza$zzd[n12];
        zzt$zza$zzdArray[0] = object;
        zzt$zza$zzdArray[n10] = zzt$zza$zzd9;
        zzt$zza$zzdArray[n11] = zzt$zza$zzd8;
        zzt$zza$zzdArray[3] = zzt$zza$zzd7;
        zzt$zza$zzdArray[4] = zzt$zza$zzd6;
        zzt$zza$zzdArray[5] = zzt$zza$zzd5;
        zzt$zza$zzdArray[6] = zzt$zza$zzd4;
        zzt$zza$zzdArray[7] = zzt$zza$zzd3;
        zzt$zza$zzdArray[8] = zzt$zza$zzd2;
        zzt$zza$zzdArray[n13] = zzt$zza$zzd;
        zzcp = zzt$zza$zzdArray;
        zzbq = object = new zzx();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzt$zza$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzt$zza$zzd[] values() {
        return (zzt$zza$zzd[])zzcp.clone();
    }

    public static zzck zzd() {
        return zzbq;
    }

    public static zzt$zza$zzd zzd(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 10: {
                return zzco;
            }
            case 9: {
                return zzcn;
            }
            case 8: {
                return zzcm;
            }
            case 7: {
                return zzcl;
            }
            case 5: {
                return zzck;
            }
            case 4: {
                return zzcj;
            }
            case 3: {
                return zzci;
            }
            case 2: {
                return zzch;
            }
            case 1: {
                return zzcg;
            }
            case 0: 
        }
        return zzcf;
    }

    public final int zzc() {
        return this.value;
    }
}

