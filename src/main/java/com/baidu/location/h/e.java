/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.h;

import com.baidu.location.h.e$a;
import com.baidu.location.h.e$b;
import java.util.AbstractSequentialList;
import java.util.LinkedList;

public class e {
    private static e a;
    private static final double[] b;
    private static final double[] c;
    private LinkedList d;

    static {
        double[] dArray;
        double[] dArray2;
        int n10 = 96;
        double[] dArray3 = dArray2 = new double[n10];
        double[] dArray4 = dArray2;
        dArray3[0] = 110.389648;
        dArray4[1] = 105.070224;
        dArray3[2] = 96.898845;
        dArray4[3] = 95.617053;
        dArray3[4] = 93.822557;
        dArray4[5] = 91.387165;
        dArray3[6] = 91.387165;
        dArray4[7] = 89.079901;
        dArray3[8] = 87.221341;
        dArray4[9] = 86.259997;
        dArray3[10] = 85.170461;
        dArray4[11] = 85.234525;
        dArray3[12] = 82.863261;
        dArray4[13] = 81.901917;
        dArray3[14] = 79.594685;
        dArray4[15] = 80.395798;
        dArray3[16] = 79.931142;
        dArray4[17] = 77.800174;
        dArray3[18] = 75.252622;
        dArray4[19] = 73.490158;
        dArray3[20] = 73.185732;
        dArray4[21] = 73.874699;
        dArray3[22] = 74.403435;
        dArray4[23] = 74.099003;
        dArray3[24] = 75.460905;
        dArray4[25] = 76.77474;
        dArray3[26] = 78.280852;
        dArray4[27] = 78.15266;
        dArray3[28] = 78.37698;
        dArray4[29] = 78.8897;
        dArray3[30] = 79.690818;
        dArray4[31] = 81.196914;
        dArray3[32] = 81.805762;
        dArray4[33] = 83.888674;
        dArray3[34] = 85.939538;
        dArray4[35] = 87.862215;
        dArray3[36] = 89.031847;
        dArray4[37] = 90.057287;
        dArray3[38] = 91.098741;
        dArray4[39] = 92.156213;
        dArray3[40] = 93.742421;
        dArray4[41] = 95.825333;
        dArray3[42] = 97.956327;
        dArray4[43] = 97.123143;
        dArray3[44] = 98.212679;
        dArray4[45] = 99.206055;
        dArray3[46] = 101.657471;
        dArray4[47] = 102.52267;
        dArray3[48] = 102.23427;
        dArray4[49] = 105.022158;
        dArray3[50] = 106.095662;
        dArray4[51] = 107.858116;
        dArray3[52] = 111.639396;
        dArray4[53] = 109.588503;
        dArray3[54] = 112.280343;
        dArray4[55] = 117.792023;
        dArray3[56] = 118.945559;
        dArray4[57] = 114.203031;
        dArray3[58] = 118.689303;
        dArray4[59] = 123.143466;
        dArray3[60] = 122.726858;
        dArray4[61] = 120.932369;
        dArray3[62] = 123.415857;
        dArray4[63] = 122.374385;
        dArray3[64] = 122.134054;
        dArray4[65] = 121.586108;
        dArray3[66] = 121.17271;
        dArray4[67] = 120.676006;
        dArray3[68] = 120.243409;
        dArray4[69] = 122.790961;
        dArray3[70] = 122.871076;
        dArray4[71] = 121.300884;
        dArray3[72] = 122.134052;
        dArray4[73] = 123.736285;
        dArray3[74] = 126.412019;
        dArray4[75] = 128.559027;
        dArray3[76] = 129.712627;
        dArray4[77] = 131.218707;
        dArray3[78] = 131.987795;
        dArray4[79] = 133.622084;
        dArray3[80] = 135.60888;
        dArray4[81] = 131.378992;
        dArray3[82] = 130.866224;
        dArray4[83] = 128.623088;
        dArray3[84] = 126.091572;
        dArray4[85] = 124.393204;
        dArray3[86] = 122.214164;
        dArray4[87] = 119.65058;
        dArray3[88] = 119.778772;
        dArray4[89] = 118.561044;
        dArray3[90] = 116.510192;
        dArray4[91] = 114.811824;
        dArray3[92] = 119.073776;
        dArray4[93] = 116.446096;
        dArray3[94] = 111.735536;
        dArray4[95] = 110.389648;
        b = dArray2;
        double[] dArray5 = dArray = new double[n10];
        double[] dArray6 = dArray;
        dArray5[0] = 43.216755;
        dArray6[1] = 42.378597;
        dArray5[2] = 43.172612;
        dArray6[3] = 44.421188;
        dArray5[4] = 45.097508;
        dArray6[5] = 45.565732;
        dArray5[6] = 47.334548;
        dArray6[7] = 48.687188;
        dArray5[8] = 49.62362;
        dArray6[9] = 48.947316;
        dArray5[10] = 48.479092;
        dArray6[11] = 47.334548;
        dArray5[12] = 47.438596;
        dArray6[13] = 46.03394;
        dArray5[14] = 45.201556;
        dArray6[15] = 43.344095;
        dArray5[16] = 42.328663;
        dArray6[17] = 41.395882;
        dArray5[18] = 40.829126;
        dArray6[19] = 39.955382;
        dArray5[20] = 39.258748;
        dArray6[21] = 38.361382;
        dArray5[22] = 38.054394;
        dArray6[23] = 37.168842;
        dArray5[24] = 36.389553;
        dArray6[25] = 35.362313;
        dArray5[26] = 34.311457;
        dArray6[27] = 32.587581;
        dArray5[28] = 31.572149;
        dArray6[29] = 30.781055;
        dArray5[30] = 30.438642;
        dArray6[31] = 29.77743;
        dArray5[32] = 30.09623;
        dArray6[33] = 28.714766;
        dArray5[34] = 27.71114;
        dArray6[35] = 27.581258;
        dArray5[36] = 27.014504;
        dArray6[37] = 27.781984;
        dArray5[38] = 27.510415;
        dArray6[39] = 26.506787;
        dArray5[40] = 26.707513;
        dArray6[41] = 27.959095;
        dArray5[42] = 27.29788;
        dArray6[43] = 23.649404;
        dArray5[44] = 23.62579;
        dArray6[45] = 21.677574;
        dArray5[46] = 20.780213;
        dArray6[47] = 21.323353;
        dArray5[48] = 22.185291;
        dArray6[49] = 22.315173;
        dArray5[50] = 22.515897;
        dArray6[51] = 16.802289;
        dArray5[52] = 13.198973;
        dArray6[53] = 0.693351;
        dArray5[54] = 1.541191;
        dArray6[55] = 10.504055;
        dArray5[56] = 15.591095;
        dArray6[57] = 17.892375;
        dArray5[58] = 19.951383;
        dArray6[59] = 22.187501;
        dArray5[60] = 25.375613;
        dArray6[61] = 25.617568;
        dArray5[62] = 30.627458;
        dArray6[63] = 31.082902;
        dArray5[64] = 31.894166;
        dArray6[65] = 32.503117;
        dArray5[66] = 32.805056;
        dArray6[67] = 34.256784;
        dArray5[68] = 35.155304;
        dArray6[69] = 36.90119;
        dArray5[70] = 37.83411;
        dArray6[71] = 37.940728;
        dArray5[72] = 38.64708;
        dArray6[73] = 38.966937;
        dArray5[74] = 40.979374;
        dArray6[75] = 41.253698;
        dArray5[76] = 42.069802;
        dArray6[77] = 42.48888;
        dArray5[78] = 44.65045;
        dArray6[79] = 44.691252;
        dArray5[80] = 48.620679;
        dArray6[81] = 48.091311;
        dArray5[82] = 49.194151;
        dArray6[83] = 50.032311;
        dArray5[84] = 53.274665;
        dArray6[85] = 53.627577;
        dArray5[86] = 53.892257;
        dArray6[87] = 52.987929;
        dArray5[88] = 52.017425;
        dArray6[89] = 50.230825;
        dArray5[90] = 50.186707;
        dArray6[91] = 47.495779;
        dArray5[92] = 47.341379;
        dArray6[93] = 46.503219;
        dArray5[94] = 45.245983;
        dArray6[95] = 43.216755;
        c = dArray;
    }

    private e() {
        e e10 = this;
        this.d = null;
        int n10 = b.length;
        Object object = new LinkedList();
        this.d = object;
        int n11 = 0;
        object = null;
        int n12 = 0;
        while (n12 < (n11 = n10 + -1)) {
            e$a e$a;
            e$a e$a2;
            LinkedList linkedList = e10.d;
            double[] dArray = b;
            double d10 = dArray[n12];
            double d11 = 100000.0;
            double d12 = d10 * d11;
            double[] dArray2 = c;
            double d13 = dArray2[n12] * d11;
            object = e$a2;
            e$a2 = new e$a(this, d12, d13);
            d12 = dArray[++n12] * d11;
            d10 = dArray2[n12];
            double d14 = d10 * d11;
            object = e$a;
            d13 = d14;
            e$a = new e$a(this, d12, d14);
            e$b e$b = new e$b(e10, e$a2, e$a);
            linkedList.add(e$b);
        }
    }

    public static e a() {
        e e10 = a;
        if (e10 == null) {
            a = e10 = new e();
        }
        return a;
    }

    public int a(double d10) {
        double d11 = -1.0E-8;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object < 0) {
            return -1;
        }
        d11 = 1.0E-8;
        double d13 = d10 - d11;
        Object object2 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object2 > 0) {
            return 1;
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(double d10, double d11) {
        int n10;
        boolean bl2 = true;
        double d12 = 100000.0;
        double d13 = d10 * d12;
        double d14 = d11 * d12;
        Object object = this;
        e$a e$a = new e$a(this, d13, d14);
        Object object2 = this.d;
        try {
            object2 = ((AbstractSequentialList)object2).iterator();
            n10 = 0;
        }
        catch (Exception exception) {
            return bl2;
        }
        while (true) {
            int n11;
            Object object3;
            int n12;
            block21: {
                n12 = object2.hasNext();
                if (n12 == 0) break;
                object3 = object2.next();
                object3 = (e$b)object3;
                n11 = ((e$b)object3).b(e$a);
                if (n11 == 0) break block21;
                return bl2;
            }
            d12 = ((e$b)object3).a(e$a);
            n11 = this.a(d12);
            object = ((e$b)object3).a;
            double d15 = ((e$a)object).b;
            double d16 = e$a.b;
            d15 -= d16;
            int n13 = this.a(d15);
            object3 = ((e$b)object3).b;
            d13 = ((e$a)object3).b;
            d14 = e$a.b;
            d13 -= d14;
            n12 = this.a(d13);
            if (n11 > 0 && n13 <= 0 && n12 > 0) {
                ++n10;
            }
            if (n11 >= 0 || n12 > 0 || n13 <= 0) continue;
            n10 += -1;
            continue;
            break;
        }
        if (n10 != 0) return bl2;
        return false;
    }
}

