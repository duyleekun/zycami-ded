/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcn;
import com.google.android.gms.internal.vision.zzco;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzci$zzb$zzc
extends Enum
implements zzih {
    private static final zzig zzhq;
    public static final /* enum */ zzci$zzb$zzc zzjv;
    public static final /* enum */ zzci$zzb$zzc zzjw;
    public static final /* enum */ zzci$zzb$zzc zzjx;
    public static final /* enum */ zzci$zzb$zzc zzjy;
    public static final /* enum */ zzci$zzb$zzc zzjz;
    public static final /* enum */ zzci$zzb$zzc zzka;
    public static final /* enum */ zzci$zzb$zzc zzkb;
    public static final /* enum */ zzci$zzb$zzc zzkc;
    public static final /* enum */ zzci$zzb$zzc zzkd;
    public static final /* enum */ zzci$zzb$zzc zzke;
    public static final /* enum */ zzci$zzb$zzc zzkf;
    public static final /* enum */ zzci$zzb$zzc zzkg;
    public static final /* enum */ zzci$zzb$zzc zzkh;
    public static final /* enum */ zzci$zzb$zzc zzki;
    public static final /* enum */ zzci$zzb$zzc zzkj;
    public static final /* enum */ zzci$zzb$zzc zzkk;
    private static final /* synthetic */ zzci$zzb$zzc[] zzkl;
    private final int value;

    static {
        zzci$zzb$zzc zzci$zzb$zzc;
        zzci$zzb$zzc zzci$zzb$zzc2;
        zzci$zzb$zzc zzci$zzb$zzc3;
        zzci$zzb$zzc zzci$zzb$zzc4;
        zzci$zzb$zzc zzci$zzb$zzc5;
        zzci$zzb$zzc zzci$zzb$zzc6;
        zzci$zzb$zzc zzci$zzb$zzc7;
        zzci$zzb$zzc zzci$zzb$zzc8;
        zzci$zzb$zzc zzci$zzb$zzc9;
        zzci$zzb$zzc zzci$zzb$zzc10;
        zzci$zzb$zzc zzci$zzb$zzc11;
        zzci$zzb$zzc zzci$zzb$zzc12;
        zzci$zzb$zzc zzci$zzb$zzc13;
        zzci$zzb$zzc zzci$zzb$zzc14;
        Object object = new zzci$zzb$zzc("CONTOUR_UNKNOWN", 0, 0);
        zzjv = object;
        int n10 = 1;
        zzjw = zzci$zzb$zzc14 = new zzci$zzb$zzc("FACE_OVAL", n10, n10);
        int n11 = 2;
        zzjx = zzci$zzb$zzc13 = new zzci$zzb$zzc("LEFT_EYEBROW_TOP", n11, n11);
        int n12 = 3;
        zzjy = zzci$zzb$zzc12 = new zzci$zzb$zzc("LEFT_EYEBROW_BOTTOM", n12, n12);
        int n13 = 4;
        zzjz = zzci$zzb$zzc11 = new zzci$zzb$zzc("RIGHT_EYEBROW_TOP", n13, n13);
        int n14 = 5;
        zzka = zzci$zzb$zzc10 = new zzci$zzb$zzc("RIGHT_EYEBROW_BOTTOM", n14, n14);
        int n15 = 6;
        zzkb = zzci$zzb$zzc9 = new zzci$zzb$zzc("LEFT_EYE", n15, n15);
        n15 = 7;
        zzkc = zzci$zzb$zzc8 = new zzci$zzb$zzc("RIGHT_EYE", n15, n15);
        n14 = 8;
        zzkd = zzci$zzb$zzc7 = new zzci$zzb$zzc("UPPER_LIP_TOP", n14, n14);
        n13 = 9;
        zzke = zzci$zzb$zzc6 = new zzci$zzb$zzc("UPPER_LIP_BOTTOM", n13, n13);
        n12 = 10;
        zzkf = zzci$zzb$zzc5 = new zzci$zzb$zzc("LOWER_LIP_TOP", n12, n12);
        n11 = 11;
        zzkg = zzci$zzb$zzc4 = new zzci$zzb$zzc("LOWER_LIP_BOTTOM", n11, n11);
        n10 = 12;
        zzkh = zzci$zzb$zzc3 = new zzci$zzb$zzc("NOSE_BRIDGE", n10, n10);
        int n16 = 13;
        zzci$zzb$zzc[] zzci$zzb$zzcArray = new zzci$zzb$zzc("NOSE_BOTTOM", n16, n16);
        zzki = zzci$zzb$zzcArray;
        zzci$zzb$zzc[] zzci$zzb$zzcArray2 = zzci$zzb$zzcArray;
        n11 = 14;
        zzkj = zzci$zzb$zzc2 = new zzci$zzb$zzc("LEFT_CHEEK_CENTER", n11, n11);
        n10 = 15;
        zzkk = zzci$zzb$zzc = new zzci$zzb$zzc("RIGHT_CHEEK_CENTER", n10, n10);
        zzci$zzb$zzcArray = new zzci$zzb$zzc[16];
        zzci$zzb$zzcArray[0] = object;
        zzci$zzb$zzcArray[1] = zzci$zzb$zzc14;
        zzci$zzb$zzcArray[2] = zzci$zzb$zzc13;
        zzci$zzb$zzcArray[3] = zzci$zzb$zzc12;
        zzci$zzb$zzcArray[4] = zzci$zzb$zzc11;
        zzci$zzb$zzcArray[5] = zzci$zzb$zzc10;
        zzci$zzb$zzcArray[6] = zzci$zzb$zzc9;
        zzci$zzb$zzcArray[7] = zzci$zzb$zzc8;
        zzci$zzb$zzcArray[8] = zzci$zzb$zzc7;
        zzci$zzb$zzcArray[9] = zzci$zzb$zzc6;
        zzci$zzb$zzcArray[10] = zzci$zzb$zzc5;
        zzci$zzb$zzcArray[11] = zzci$zzb$zzc4;
        zzci$zzb$zzcArray[12] = zzci$zzb$zzc3;
        zzci$zzb$zzcArray[13] = zzci$zzb$zzcArray2;
        zzci$zzb$zzcArray[14] = zzci$zzb$zzc2;
        zzci$zzb$zzcArray[n10] = zzci$zzb$zzc;
        zzkl = zzci$zzb$zzcArray;
        zzhq = object = new zzcn();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzci$zzb$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzci$zzb$zzc[] values() {
        return (zzci$zzb$zzc[])zzkl.clone();
    }

    public static zzij zzal() {
        return zzco.zzht;
    }

    public static zzci$zzb$zzc zzp(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 15: {
                return zzkk;
            }
            case 14: {
                return zzkj;
            }
            case 13: {
                return zzki;
            }
            case 12: {
                return zzkh;
            }
            case 11: {
                return zzkg;
            }
            case 10: {
                return zzkf;
            }
            case 9: {
                return zzke;
            }
            case 8: {
                return zzkd;
            }
            case 7: {
                return zzkc;
            }
            case 6: {
                return zzkb;
            }
            case 5: {
                return zzka;
            }
            case 4: {
                return zzjz;
            }
            case 3: {
                return zzjy;
            }
            case 2: {
                return zzjx;
            }
            case 1: {
                return zzjw;
            }
            case 0: 
        }
        return zzjv;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzci$zzb$zzc.class.getName();
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

