/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;
import com.google.android.gms.internal.vision.zzlv;
import com.google.android.gms.internal.vision.zzlw;

public final class zzls$zza$zza
extends Enum
implements zzih {
    private static final /* enum */ zzls$zza$zza zzafc;
    private static final /* enum */ zzls$zza$zza zzafd;
    private static final /* enum */ zzls$zza$zza zzafe;
    private static final /* enum */ zzls$zza$zza zzaff;
    private static final /* enum */ zzls$zza$zza zzafg;
    private static final /* enum */ zzls$zza$zza zzafh;
    private static final /* enum */ zzls$zza$zza zzafi;
    private static final /* enum */ zzls$zza$zza zzafj;
    private static final /* enum */ zzls$zza$zza zzafk;
    private static final /* enum */ zzls$zza$zza zzafl;
    private static final /* enum */ zzls$zza$zza zzafm;
    private static final /* enum */ zzls$zza$zza zzafn;
    private static final /* enum */ zzls$zza$zza zzafo;
    private static final /* enum */ zzls$zza$zza zzafp;
    private static final /* enum */ zzls$zza$zza zzafq;
    private static final /* enum */ zzls$zza$zza zzafr;
    private static final /* enum */ zzls$zza$zza zzafs;
    private static final /* enum */ zzls$zza$zza zzaft;
    private static final /* enum */ zzls$zza$zza zzafu;
    private static final /* enum */ zzls$zza$zza zzafv;
    private static final /* enum */ zzls$zza$zza zzafw;
    private static final /* enum */ zzls$zza$zza zzafx;
    private static final /* enum */ zzls$zza$zza zzafy;
    private static final /* enum */ zzls$zza$zza zzafz;
    private static final /* enum */ zzls$zza$zza zzaga;
    private static final /* synthetic */ zzls$zza$zza[] zzagb;
    private static final zzig zzhq;
    private final int value;

    static {
        zzls$zza$zza zzls$zza$zza;
        zzls$zza$zza zzls$zza$zza2;
        zzls$zza$zza zzls$zza$zza3;
        zzls$zza$zza zzls$zza$zza4;
        zzls$zza$zza zzls$zza$zza5;
        zzls$zza$zza zzls$zza$zza6;
        zzls$zza$zza zzls$zza$zza7;
        zzls$zza$zza zzls$zza$zza8;
        zzls$zza$zza zzls$zza$zza9;
        zzls$zza$zza zzls$zza$zza10;
        zzls$zza$zza zzls$zza$zza11;
        zzls$zza$zza zzls$zza$zza12;
        zzls$zza$zza zzls$zza$zza13;
        zzls$zza$zza zzls$zza$zza14;
        Object object = new zzls$zza$zza("TYPE_UNKNOWN", 0, 0);
        zzafc = object;
        int n10 = 1;
        zzafd = zzls$zza$zza14 = new zzls$zza$zza("FREE_FORM", n10, n10);
        int n11 = 2;
        zzafe = zzls$zza$zza13 = new zzls$zza$zza("FEMALE", n11, n11);
        int n12 = 3;
        zzaff = zzls$zza$zza12 = new zzls$zza$zza("MALE", n12, n12);
        int n13 = 5;
        zzafg = zzls$zza$zza11 = new zzls$zza$zza("AGE", 4, n13);
        int n14 = 6;
        zzafh = zzls$zza$zza10 = new zzls$zza$zza("NON_HUMAN", n13, n14);
        int n15 = 7;
        zzafi = zzls$zza$zza9 = new zzls$zza$zza("GLASSES", n14, n15);
        n14 = 8;
        zzafj = zzls$zza$zza8 = new zzls$zza$zza("DARK_GLASSES", n15, n14);
        n13 = 9;
        zzafk = zzls$zza$zza7 = new zzls$zza$zza("HEADWEAR", n14, n13);
        n12 = 10;
        zzafl = zzls$zza$zza6 = new zzls$zza$zza("EYES_VISIBLE", n13, n12);
        zzafm = zzls$zza$zza5 = new zzls$zza$zza("LEFT_EYELID_CLOSED", n12, 16);
        n10 = 11;
        zzafn = zzls$zza$zza4 = new zzls$zza$zza("RIGHT_EYELID_CLOSED", n10, 17);
        n11 = 12;
        zzafo = zzls$zza$zza3 = new zzls$zza$zza("MOUTH_OPEN", n11, n10);
        zzls$zza$zza zzls$zza$zza15 = zzls$zza$zza3;
        n12 = 13;
        zzls$zza$zza[] zzls$zza$zzaArray = new zzls$zza$zza("FACIAL_HAIR", n12, n11);
        zzafp = zzls$zza$zzaArray;
        zzls$zza$zza[] zzls$zza$zzaArray2 = zzls$zza$zzaArray;
        int n16 = 14;
        zzafq = zzls$zza$zza2 = new zzls$zza$zza("LONG_HAIR", n16, n12);
        zzls$zza$zza zzls$zza$zza16 = zzls$zza$zza2;
        n10 = 15;
        zzafr = zzls$zza$zza = new zzls$zza$zza("FRONTAL_GAZE", n10, n16);
        zzls$zza$zza zzls$zza$zza17 = zzls$zza$zza;
        zzafs = zzls$zza$zza3 = new zzls$zza$zza("SMILING", 16, n10);
        n10 = 18;
        zzls$zza$zza zzls$zza$zza18 = zzls$zza$zza3;
        zzls$zza$zzaArray = new zzls$zza$zza("UNDER_EXPOSED", 17, n10);
        zzaft = zzls$zza$zzaArray;
        zzls$zza$zza[] zzls$zza$zzaArray3 = zzls$zza$zzaArray;
        n16 = 19;
        zzafu = zzls$zza$zza = new zzls$zza$zza("BLURRED", n10, n16);
        zzls$zza$zza zzls$zza$zza19 = zzls$zza$zza;
        n11 = 20;
        zzafv = zzls$zza$zza3 = new zzls$zza$zza("LEFT_EYE_VISIBLE", n16, n11);
        n12 = 21;
        zzafw = zzls$zza$zza2 = new zzls$zza$zza("RIGHT_EYE_VISIBLE", n11, n12);
        zzls$zza$zza zzls$zza$zza20 = zzls$zza$zza2;
        n10 = 22;
        zzls$zza$zzaArray = new zzls$zza$zza("LEFT_EAR_VISIBLE", n12, n10);
        zzafx = zzls$zza$zzaArray;
        zzls$zza$zza[] zzls$zza$zzaArray4 = zzls$zza$zzaArray;
        zzafy = zzls$zza$zza = new zzls$zza$zza("RIGHT_EAR_VISIBLE", n10, 23);
        zzls$zza$zzaArray = new zzls$zza$zza("NOSE_TIP_VISIBLE", 23, 24);
        zzafz = zzls$zza$zzaArray;
        zzls$zza$zza[] zzls$zza$zzaArray5 = zzls$zza$zzaArray;
        n16 = 25;
        zzaga = zzls$zza$zza2 = new zzls$zza$zza("MOUTH_CENTER_VISIBLE", 24, n16);
        zzls$zza$zzaArray = new zzls$zza$zza[n16];
        zzls$zza$zzaArray[0] = object;
        zzls$zza$zzaArray[1] = zzls$zza$zza14;
        zzls$zza$zzaArray[2] = zzls$zza$zza13;
        zzls$zza$zzaArray[3] = zzls$zza$zza12;
        zzls$zza$zzaArray[4] = zzls$zza$zza11;
        zzls$zza$zzaArray[5] = zzls$zza$zza10;
        zzls$zza$zzaArray[6] = zzls$zza$zza9;
        zzls$zza$zzaArray[7] = zzls$zza$zza8;
        zzls$zza$zzaArray[8] = zzls$zza$zza7;
        zzls$zza$zzaArray[9] = zzls$zza$zza6;
        zzls$zza$zzaArray[10] = zzls$zza$zza5;
        zzls$zza$zzaArray[11] = zzls$zza$zza4;
        zzls$zza$zzaArray[12] = zzls$zza$zza15;
        zzls$zza$zzaArray[13] = zzls$zza$zzaArray2;
        zzls$zza$zzaArray[14] = zzls$zza$zza16;
        zzls$zza$zzaArray[15] = zzls$zza$zza17;
        zzls$zza$zzaArray[16] = zzls$zza$zza18;
        zzls$zza$zzaArray[17] = zzls$zza$zzaArray3;
        zzls$zza$zzaArray[18] = zzls$zza$zza19;
        zzls$zza$zzaArray[19] = zzls$zza$zza3;
        zzls$zza$zzaArray[20] = zzls$zza$zza20;
        zzls$zza$zzaArray[21] = zzls$zza$zzaArray4;
        zzls$zza$zzaArray[22] = zzls$zza$zza;
        zzls$zza$zzaArray[23] = zzls$zza$zzaArray5;
        zzls$zza$zzaArray[24] = zzls$zza$zza2;
        zzagb = zzls$zza$zzaArray;
        zzhq = object = new zzlw();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzls$zza$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzls$zza$zza[] values() {
        return (zzls$zza$zza[])zzagb.clone();
    }

    public static zzij zzal() {
        return zzlv.zzht;
    }

    public static zzls$zza$zza zzcg(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 25: {
                return zzaga;
            }
            case 24: {
                return zzafz;
            }
            case 23: {
                return zzafy;
            }
            case 22: {
                return zzafx;
            }
            case 21: {
                return zzafw;
            }
            case 20: {
                return zzafv;
            }
            case 19: {
                return zzafu;
            }
            case 18: {
                return zzaft;
            }
            case 17: {
                return zzafn;
            }
            case 16: {
                return zzafm;
            }
            case 15: {
                return zzafs;
            }
            case 14: {
                return zzafr;
            }
            case 13: {
                return zzafq;
            }
            case 12: {
                return zzafp;
            }
            case 11: {
                return zzafo;
            }
            case 10: {
                return zzafl;
            }
            case 9: {
                return zzafk;
            }
            case 8: {
                return zzafj;
            }
            case 7: {
                return zzafi;
            }
            case 6: {
                return zzafh;
            }
            case 5: {
                return zzafg;
            }
            case 3: {
                return zzaff;
            }
            case 2: {
                return zzafe;
            }
            case 1: {
                return zzafd;
            }
            case 0: 
        }
        return zzafc;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzls$zza$zza.class.getName();
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

