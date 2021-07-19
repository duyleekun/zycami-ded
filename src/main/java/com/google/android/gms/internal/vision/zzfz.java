/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzga;
import com.google.android.gms.internal.vision.zzgb;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;

public final class zzfz
extends Enum
implements zzih {
    private static final zzig zzhq;
    private static final /* enum */ zzfz zzry;
    private static final /* enum */ zzfz zzrz;
    private static final /* enum */ zzfz zzsa;
    private static final /* enum */ zzfz zzsb;
    private static final /* enum */ zzfz zzsc;
    private static final /* enum */ zzfz zzsd;
    private static final /* enum */ zzfz zzse;
    private static final /* enum */ zzfz zzsf;
    private static final /* enum */ zzfz zzsg;
    private static final /* enum */ zzfz zzsh;
    private static final /* enum */ zzfz zzsi;
    private static final /* enum */ zzfz zzsj;
    private static final /* enum */ zzfz zzsk;
    private static final /* enum */ zzfz zzsl;
    private static final /* enum */ zzfz zzsm;
    private static final /* enum */ zzfz zzsn;
    private static final /* synthetic */ zzfz[] zzso;
    private final int value;

    static {
        zzfz zzfz2;
        zzfz zzfz3;
        zzfz zzfz4;
        zzfz zzfz5;
        zzfz zzfz6;
        zzfz zzfz7;
        zzfz zzfz8;
        zzfz zzfz9;
        zzfz zzfz10;
        zzfz zzfz11;
        zzfz zzfz12;
        zzfz zzfz13;
        zzfz zzfz14;
        zzfz zzfz15;
        Object object = new zzfz("UNRECOGNIZED", 0, 0);
        zzry = object;
        int n10 = 1;
        zzrz = zzfz15 = new zzfz("CODE_128", n10, n10);
        int n11 = 2;
        zzsa = zzfz14 = new zzfz("CODE_39", n11, n11);
        int n12 = 3;
        zzsb = zzfz13 = new zzfz("CODE_93", n12, n12);
        int n13 = 4;
        zzsc = zzfz12 = new zzfz("CODABAR", n13, n13);
        int n14 = 5;
        zzsd = zzfz11 = new zzfz("DATA_MATRIX", n14, n14);
        int n15 = 6;
        zzse = zzfz10 = new zzfz("EAN_13", n15, n15);
        n15 = 7;
        zzsf = zzfz9 = new zzfz("EAN_8", n15, n15);
        n14 = 8;
        zzsg = zzfz8 = new zzfz("ITF", n14, n14);
        n13 = 9;
        zzsh = zzfz7 = new zzfz("QR_CODE", n13, n13);
        n12 = 10;
        zzsi = zzfz6 = new zzfz("UPC_A", n12, n12);
        n11 = 11;
        zzsj = zzfz5 = new zzfz("UPC_E", n11, n11);
        n10 = 12;
        zzsk = zzfz4 = new zzfz("PDF417", n10, n10);
        int n16 = 13;
        zzfz[] zzfzArray = new zzfz("AZTEC", n16, n16);
        zzsl = zzfzArray;
        zzfz[] zzfzArray2 = zzfzArray;
        n11 = 14;
        zzsm = zzfz3 = new zzfz("DATABAR", n11, n11);
        n10 = 15;
        n12 = 16;
        zzsn = zzfz2 = new zzfz("TEZ_CODE", n10, n12);
        zzfzArray = new zzfz[n12];
        zzfzArray[0] = object;
        zzfzArray[1] = zzfz15;
        zzfzArray[2] = zzfz14;
        zzfzArray[3] = zzfz13;
        zzfzArray[4] = zzfz12;
        zzfzArray[5] = zzfz11;
        zzfzArray[6] = zzfz10;
        zzfzArray[7] = zzfz9;
        zzfzArray[8] = zzfz8;
        zzfzArray[9] = zzfz7;
        zzfzArray[10] = zzfz6;
        zzfzArray[11] = zzfz5;
        zzfzArray[12] = zzfz4;
        zzfzArray[13] = zzfzArray2;
        zzfzArray[14] = zzfz3;
        zzfzArray[n10] = zzfz2;
        zzso = zzfzArray;
        zzhq = object = new zzgb();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzfz() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzfz[] values() {
        return (zzfz[])zzso.clone();
    }

    public static zzfz zzai(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 16: {
                return zzsn;
            }
            case 14: {
                return zzsm;
            }
            case 13: {
                return zzsl;
            }
            case 12: {
                return zzsk;
            }
            case 11: {
                return zzsj;
            }
            case 10: {
                return zzsi;
            }
            case 9: {
                return zzsh;
            }
            case 8: {
                return zzsg;
            }
            case 7: {
                return zzsf;
            }
            case 6: {
                return zzse;
            }
            case 5: {
                return zzsd;
            }
            case 4: {
                return zzsc;
            }
            case 3: {
                return zzsb;
            }
            case 2: {
                return zzsa;
            }
            case 1: {
                return zzrz;
            }
            case 0: 
        }
        return zzry;
    }

    public static zzij zzal() {
        return zzga.zzht;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzfz.class.getName();
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

