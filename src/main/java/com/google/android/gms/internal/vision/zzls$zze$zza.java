/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzih;
import com.google.android.gms.internal.vision.zzij;
import com.google.android.gms.internal.vision.zzlx;
import com.google.android.gms.internal.vision.zzly;

public final class zzls$zze$zza
extends Enum
implements zzih {
    public static final /* enum */ zzls$zze$zza zzagn;
    public static final /* enum */ zzls$zze$zza zzago;
    private static final /* enum */ zzls$zze$zza zzagp;
    private static final /* enum */ zzls$zze$zza zzagq;
    private static final /* enum */ zzls$zze$zza zzagr;
    private static final /* enum */ zzls$zze$zza zzags;
    private static final /* enum */ zzls$zze$zza zzagt;
    public static final /* enum */ zzls$zze$zza zzagu;
    private static final /* enum */ zzls$zze$zza zzagv;
    public static final /* enum */ zzls$zze$zza zzagw;
    public static final /* enum */ zzls$zze$zza zzagx;
    public static final /* enum */ zzls$zze$zza zzagy;
    private static final /* enum */ zzls$zze$zza zzagz;
    private static final /* enum */ zzls$zze$zza zzaha;
    private static final /* enum */ zzls$zze$zza zzahb;
    private static final /* enum */ zzls$zze$zza zzahc;
    private static final /* enum */ zzls$zze$zza zzahd;
    private static final /* enum */ zzls$zze$zza zzahe;
    private static final /* enum */ zzls$zze$zza zzahf;
    private static final /* enum */ zzls$zze$zza zzahg;
    private static final /* enum */ zzls$zze$zza zzahh;
    private static final /* enum */ zzls$zze$zza zzahi;
    private static final /* enum */ zzls$zze$zza zzahj;
    private static final /* enum */ zzls$zze$zza zzahk;
    private static final /* enum */ zzls$zze$zza zzahl;
    private static final /* enum */ zzls$zze$zza zzahm;
    public static final /* enum */ zzls$zze$zza zzahn;
    public static final /* enum */ zzls$zze$zza zzaho;
    private static final /* enum */ zzls$zze$zza zzahp;
    private static final /* enum */ zzls$zze$zza zzahq;
    private static final /* enum */ zzls$zze$zza zzahr;
    private static final /* enum */ zzls$zze$zza zzahs;
    private static final /* enum */ zzls$zze$zza zzaht;
    private static final /* enum */ zzls$zze$zza zzahu;
    public static final /* enum */ zzls$zze$zza zzahv;
    public static final /* enum */ zzls$zze$zza zzahw;
    public static final /* enum */ zzls$zze$zza zzahx;
    public static final /* enum */ zzls$zze$zza zzahy;
    public static final /* enum */ zzls$zze$zza zzahz;
    private static final /* synthetic */ zzls$zze$zza[] zzaia;
    private static final zzig zzhq;
    private final int value;

    static {
        zzls$zze$zza zzls$zze$zza;
        zzls$zze$zza zzls$zze$zza2;
        zzls$zze$zza zzls$zze$zza3;
        zzls$zze$zza zzls$zze$zza4;
        zzls$zze$zza zzls$zze$zza5;
        zzls$zze$zza zzls$zze$zza6;
        zzls$zze$zza zzls$zze$zza7;
        zzls$zze$zza zzls$zze$zza8;
        zzls$zze$zza zzls$zze$zza9;
        zzls$zze$zza zzls$zze$zza10;
        zzls$zze$zza zzls$zze$zza11;
        zzls$zze$zza zzls$zze$zza12;
        zzls$zze$zza zzls$zze$zza13;
        Object object = new zzls$zze$zza("LEFT_EYE", 0, 0);
        zzagn = object;
        int n10 = 1;
        zzago = zzls$zze$zza13 = new zzls$zze$zza("RIGHT_EYE", n10, n10);
        int n11 = 2;
        zzagp = zzls$zze$zza12 = new zzls$zze$zza("LEFT_OF_LEFT_EYEBROW", n11, n11);
        int n12 = 3;
        zzagq = zzls$zze$zza11 = new zzls$zze$zza("RIGHT_OF_LEFT_EYEBROW", n12, n12);
        int n13 = 4;
        zzagr = zzls$zze$zza10 = new zzls$zze$zza("LEFT_OF_RIGHT_EYEBROW", n13, n13);
        int n14 = 5;
        zzags = zzls$zze$zza9 = new zzls$zze$zza("RIGHT_OF_RIGHT_EYEBROW", n14, n14);
        int n15 = 6;
        zzagt = zzls$zze$zza8 = new zzls$zze$zza("MIDPOINT_BETWEEN_EYES", n15, n15);
        n14 = 9;
        zzagu = zzls$zze$zza7 = new zzls$zze$zza("NOSE_TIP", 7, n14);
        n12 = 10;
        zzagv = zzls$zze$zza6 = new zzls$zze$zza("UPPER_LIP", 8, n12);
        n11 = 11;
        zzagw = zzls$zze$zza5 = new zzls$zze$zza("LOWER_LIP", n14, n11);
        n10 = 12;
        zzagx = zzls$zze$zza4 = new zzls$zze$zza("MOUTH_LEFT", n12, n10);
        zzagy = zzls$zze$zza3 = new zzls$zze$zza("MOUTH_RIGHT", n11, 13);
        zzagz = zzls$zze$zza2 = new zzls$zze$zza("MOUTH_CENTER", n10, 45);
        zzls$zze$zza[] zzls$zze$zzaArray = new zzls$zze$zza("NOSE_BOTTOM_RIGHT", 13, 43);
        zzaha = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray2 = zzls$zze$zzaArray;
        zzahb = zzls$zze$zza = new zzls$zze$zza("NOSE_BOTTOM_LEFT", 14, 44);
        zzls$zze$zza zzls$zze$zza14 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("NOSE_BOTTOM_CENTER", 15, 200);
        zzahc = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray3 = zzls$zze$zzaArray;
        zzahd = zzls$zze$zza = new zzls$zze$zza("LEFT_EYE_TOP_BOUNDARY", 16, 220);
        zzls$zze$zza zzls$zze$zza15 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("LEFT_EYE_RIGHT_CORNER", 17, 221);
        zzahe = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray4 = zzls$zze$zzaArray;
        zzahf = zzls$zze$zza = new zzls$zze$zza("LEFT_EYE_BOTTOM_BOUNDARY", 18, 222);
        zzls$zze$zza zzls$zze$zza16 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("LEFT_EYE_LEFT_CORNER", 19, 223);
        zzahg = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray5 = zzls$zze$zzaArray;
        zzahh = zzls$zze$zza = new zzls$zze$zza("RIGHT_EYE_TOP_BOUNDARY", 20, 224);
        zzls$zze$zza zzls$zze$zza17 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("RIGHT_EYE_RIGHT_CORNER", 21, 225);
        zzahi = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray6 = zzls$zze$zzaArray;
        zzahj = zzls$zze$zza = new zzls$zze$zza("RIGHT_EYE_BOTTOM_BOUNDARY", 22, 226);
        zzls$zze$zza zzls$zze$zza18 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("RIGHT_EYE_LEFT_CORNER", 23, 227);
        zzahk = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray7 = zzls$zze$zzaArray;
        zzahl = zzls$zze$zza = new zzls$zze$zza("LEFT_EYEBROW_UPPER_MIDPOINT", 24, 300);
        zzls$zze$zza zzls$zze$zza19 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("RIGHT_EYEBROW_UPPER_MIDPOINT", 25, 302);
        zzahm = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray8 = zzls$zze$zzaArray;
        zzahn = zzls$zze$zza = new zzls$zze$zza("LEFT_EAR_TRAGION", 26, 240);
        zzls$zze$zza zzls$zze$zza20 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("RIGHT_EAR_TRAGION", 27, 241);
        zzaho = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray9 = zzls$zze$zzaArray;
        zzahp = zzls$zze$zza = new zzls$zze$zza("LEFT_EYE_PUPIL", 28, 304);
        zzls$zze$zza zzls$zze$zza21 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("RIGHT_EYE_PUPIL", 29, 305);
        zzahq = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray10 = zzls$zze$zzaArray;
        zzahr = zzls$zze$zza = new zzls$zze$zza("FOREHEAD_GLABELLA", 30, 312);
        zzls$zze$zza zzls$zze$zza22 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("CHIN_GNATHION", 31, 314);
        zzahs = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray11 = zzls$zze$zzaArray;
        zzaht = zzls$zze$zza = new zzls$zze$zza("CHIN_LEFT_GONION", 32, 315);
        zzls$zze$zza zzls$zze$zza23 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("CHIN_RIGHT_GONION", 33, 316);
        zzahu = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray12 = zzls$zze$zzaArray;
        zzahv = zzls$zze$zza = new zzls$zze$zza("LEFT_CHEEK_CENTER", 34, 238);
        zzls$zze$zza zzls$zze$zza24 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("RIGHT_CHEEK_CENTER", 35, 239);
        zzahw = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray13 = zzls$zze$zzaArray;
        zzahx = zzls$zze$zza = new zzls$zze$zza("LEFT_EAR_TOP", 36, 242);
        zzls$zze$zza zzls$zze$zza25 = zzls$zze$zza;
        zzls$zze$zzaArray = new zzls$zze$zza("RIGHT_EAR_TOP", 37, 243);
        zzahy = zzls$zze$zzaArray;
        zzls$zze$zza[] zzls$zze$zzaArray14 = zzls$zze$zzaArray;
        zzahz = zzls$zze$zza = new zzls$zze$zza("LANDMARK_UNKNOWN", 38, 15000);
        zzls$zze$zzaArray = new zzls$zze$zza[]{object, zzls$zze$zza13, zzls$zze$zza12, zzls$zze$zza11, zzls$zze$zza10, zzls$zze$zza9, zzls$zze$zza8, zzls$zze$zza7, zzls$zze$zza6, zzls$zze$zza5, zzls$zze$zza4, zzls$zze$zza3, zzls$zze$zza2, zzls$zze$zzaArray2, zzls$zze$zza14, zzls$zze$zzaArray3, zzls$zze$zza15, zzls$zze$zzaArray4, zzls$zze$zza16, zzls$zze$zzaArray5, zzls$zze$zza17, zzls$zze$zzaArray6, zzls$zze$zza18, zzls$zze$zzaArray7, zzls$zze$zza19, zzls$zze$zzaArray8, zzls$zze$zza20, zzls$zze$zzaArray9, zzls$zze$zza21, zzls$zze$zzaArray10, zzls$zze$zza22, zzls$zze$zzaArray11, zzls$zze$zza23, zzls$zze$zzaArray12, zzls$zze$zza24, zzls$zze$zzaArray13, zzls$zze$zza25, zzls$zze$zzaArray14, zzls$zze$zza};
        zzaia = zzls$zze$zzaArray;
        zzhq = object = new zzly();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzls$zze$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static zzls$zze$zza[] values() {
        return (zzls$zze$zza[])zzaia.clone();
    }

    public static zzij zzal() {
        return zzlx.zzht;
    }

    public static zzls$zze$zza zzch(int n10) {
        int n11 = 200;
        if (n10 != n11) {
            n11 = 300;
            if (n10 != n11) {
                n11 = 302;
                if (n10 != n11) {
                    n11 = 312;
                    if (n10 != n11) {
                        n11 = 15000;
                        if (n10 != n11) {
                            n11 = 304;
                            if (n10 != n11) {
                                n11 = 305;
                                if (n10 != n11) {
                                    switch (n10) {
                                        default: {
                                            switch (n10) {
                                                default: {
                                                    switch (n10) {
                                                        default: {
                                                            switch (n10) {
                                                                default: {
                                                                    switch (n10) {
                                                                        default: {
                                                                            switch (n10) {
                                                                                default: {
                                                                                    return null;
                                                                                }
                                                                                case 316: {
                                                                                    return zzahu;
                                                                                }
                                                                                case 315: {
                                                                                    return zzaht;
                                                                                }
                                                                                case 314: 
                                                                            }
                                                                            return zzahs;
                                                                        }
                                                                        case 243: {
                                                                            return zzahy;
                                                                        }
                                                                        case 242: {
                                                                            return zzahx;
                                                                        }
                                                                        case 241: {
                                                                            return zzaho;
                                                                        }
                                                                        case 240: {
                                                                            return zzahn;
                                                                        }
                                                                        case 239: {
                                                                            return zzahw;
                                                                        }
                                                                        case 238: 
                                                                    }
                                                                    return zzahv;
                                                                }
                                                                case 227: {
                                                                    return zzahk;
                                                                }
                                                                case 226: {
                                                                    return zzahj;
                                                                }
                                                                case 225: {
                                                                    return zzahi;
                                                                }
                                                                case 224: {
                                                                    return zzahh;
                                                                }
                                                                case 223: {
                                                                    return zzahg;
                                                                }
                                                                case 222: {
                                                                    return zzahf;
                                                                }
                                                                case 221: {
                                                                    return zzahe;
                                                                }
                                                                case 220: 
                                                            }
                                                            return zzahd;
                                                        }
                                                        case 45: {
                                                            return zzagz;
                                                        }
                                                        case 44: {
                                                            return zzahb;
                                                        }
                                                        case 43: 
                                                    }
                                                    return zzaha;
                                                }
                                                case 13: {
                                                    return zzagy;
                                                }
                                                case 12: {
                                                    return zzagx;
                                                }
                                                case 11: {
                                                    return zzagw;
                                                }
                                                case 10: {
                                                    return zzagv;
                                                }
                                                case 9: 
                                            }
                                            return zzagu;
                                        }
                                        case 6: {
                                            return zzagt;
                                        }
                                        case 5: {
                                            return zzags;
                                        }
                                        case 4: {
                                            return zzagr;
                                        }
                                        case 3: {
                                            return zzagq;
                                        }
                                        case 2: {
                                            return zzagp;
                                        }
                                        case 1: {
                                            return zzago;
                                        }
                                        case 0: 
                                    }
                                    return zzagn;
                                }
                                return zzahq;
                            }
                            return zzahp;
                        }
                        return zzahz;
                    }
                    return zzahr;
                }
                return zzahm;
            }
            return zzahl;
        }
        return zzahc;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzls$zze$zza.class.getName();
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

