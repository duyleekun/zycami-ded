/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.oe;

import d.v.e0.oe.q;
import d.v.e0.rd;
import java.util.Arrays;
import java.util.List;

public class j {
    private static final int a = 6;
    private static final int[] b;
    private static final float[][] c;

    static {
        float[] fArray;
        float[] fArray2;
        Object object;
        int[] nArray = object = new int[256];
        int[] nArray2 = object;
        nArray[0] = 0;
        nArray2[1] = 4129;
        nArray[2] = 8258;
        nArray2[3] = 12387;
        nArray[4] = 16516;
        nArray2[5] = 20645;
        nArray[6] = 24774;
        nArray2[7] = 28903;
        nArray[8] = 33032;
        nArray2[9] = 37161;
        nArray[10] = 41290;
        nArray2[11] = 45419;
        nArray[12] = 49548;
        nArray2[13] = 53677;
        nArray[14] = 57806;
        nArray2[15] = 61935;
        nArray[16] = 4657;
        nArray2[17] = 528;
        nArray[18] = 12915;
        nArray2[19] = 8786;
        nArray[20] = 21173;
        nArray2[21] = 17044;
        nArray[22] = 29431;
        nArray2[23] = 25302;
        nArray[24] = 37689;
        nArray2[25] = 33560;
        nArray[26] = 45947;
        nArray2[27] = 41818;
        nArray[28] = 54205;
        nArray2[29] = 50076;
        nArray[30] = 62463;
        nArray2[31] = 58334;
        nArray[32] = 9314;
        nArray2[33] = 13379;
        nArray[34] = 1056;
        nArray2[35] = 5121;
        nArray[36] = 25830;
        nArray2[37] = 29895;
        nArray[38] = 17572;
        nArray2[39] = 21637;
        nArray[40] = 42346;
        nArray2[41] = 46411;
        nArray[42] = 34088;
        nArray2[43] = 38153;
        nArray[44] = 58862;
        nArray2[45] = 62927;
        nArray[46] = 50604;
        nArray2[47] = 54669;
        nArray[48] = 13907;
        nArray2[49] = 9842;
        nArray[50] = 5649;
        nArray2[51] = 1584;
        nArray[52] = 30423;
        nArray2[53] = 26358;
        nArray[54] = 22165;
        nArray2[55] = 18100;
        nArray[56] = 46939;
        nArray2[57] = 42874;
        nArray[58] = 38681;
        nArray2[59] = 34616;
        nArray[60] = 63455;
        nArray2[61] = 59390;
        nArray[62] = 55197;
        nArray2[63] = 51132;
        nArray[64] = 18628;
        nArray2[65] = 22757;
        nArray[66] = 26758;
        nArray2[67] = 30887;
        nArray[68] = 2112;
        nArray2[69] = 6241;
        nArray[70] = 10242;
        nArray2[71] = 14371;
        nArray[72] = 51660;
        nArray2[73] = 55789;
        nArray[74] = 59790;
        nArray2[75] = 63919;
        nArray[76] = 35144;
        nArray2[77] = 39273;
        nArray[78] = 43274;
        nArray2[79] = 47403;
        nArray[80] = 23285;
        nArray2[81] = 19156;
        nArray[82] = 31415;
        nArray2[83] = 27286;
        nArray[84] = 6769;
        nArray2[85] = 2640;
        nArray[86] = 14899;
        nArray2[87] = 10770;
        nArray[88] = 56317;
        nArray2[89] = 52188;
        nArray[90] = 64447;
        nArray2[91] = 60318;
        nArray[92] = 39801;
        nArray2[93] = 35672;
        nArray[94] = 47931;
        nArray2[95] = 43802;
        nArray[96] = 27814;
        nArray2[97] = 31879;
        nArray[98] = 19684;
        nArray2[99] = 23749;
        nArray[100] = 11298;
        nArray2[101] = 15363;
        nArray[102] = 3168;
        nArray2[103] = 7233;
        nArray[104] = 60846;
        nArray2[105] = 64911;
        nArray[106] = 52716;
        nArray2[107] = 56781;
        nArray[108] = 44330;
        nArray2[109] = 48395;
        nArray[110] = 36200;
        nArray2[111] = 40265;
        nArray[112] = 32407;
        nArray2[113] = 28342;
        nArray[114] = 24277;
        nArray2[115] = 20212;
        nArray[116] = 15891;
        nArray2[117] = 11826;
        nArray[118] = 7761;
        nArray2[119] = 3696;
        nArray[120] = (char)-97;
        nArray2[121] = 61374;
        nArray[122] = 57309;
        nArray2[123] = 53244;
        nArray[124] = 48923;
        nArray2[125] = 44858;
        nArray[126] = 40793;
        nArray2[127] = 36728;
        nArray[128] = 37256;
        nArray2[129] = 33193;
        nArray[130] = 45514;
        nArray2[131] = 41451;
        nArray[132] = 53516;
        nArray2[133] = 49453;
        nArray[134] = 61774;
        nArray2[135] = 57711;
        nArray[136] = 4224;
        nArray2[137] = 161;
        nArray[138] = 12482;
        nArray2[139] = 8419;
        nArray[140] = 20484;
        nArray2[141] = 16421;
        nArray[142] = 28742;
        nArray2[143] = 24679;
        nArray[144] = 33721;
        nArray2[145] = 37784;
        nArray[146] = 41979;
        nArray2[147] = 46042;
        nArray[148] = 49981;
        nArray2[149] = 54044;
        nArray[150] = 58239;
        nArray2[151] = 62302;
        nArray[152] = 689;
        nArray2[153] = 4752;
        nArray[154] = 8947;
        nArray2[155] = 13010;
        nArray[156] = 16949;
        nArray2[157] = 21012;
        nArray[158] = 25207;
        nArray2[159] = 29270;
        nArray[160] = 46570;
        nArray2[161] = 42443;
        nArray[162] = 38312;
        nArray2[163] = 34185;
        nArray[164] = 62830;
        nArray2[165] = 58703;
        nArray[166] = 54572;
        nArray2[167] = 50445;
        nArray[168] = 13538;
        nArray2[169] = 9411;
        nArray[170] = 5280;
        nArray2[171] = 1153;
        nArray[172] = 29798;
        nArray2[173] = 25671;
        nArray[174] = 21540;
        nArray2[175] = 17413;
        nArray[176] = 42971;
        nArray2[177] = 47098;
        nArray[178] = 34713;
        nArray2[179] = 38840;
        nArray[180] = 59231;
        nArray2[181] = 63358;
        nArray[182] = 50973;
        nArray2[183] = 55100;
        nArray[184] = 9939;
        nArray2[185] = 14066;
        nArray[186] = 1681;
        nArray2[187] = 5808;
        nArray[188] = 26199;
        nArray2[189] = 30326;
        nArray[190] = 17941;
        nArray2[191] = 22068;
        nArray[192] = 55628;
        nArray2[193] = 51565;
        nArray[194] = 63758;
        nArray2[195] = 59695;
        nArray[196] = 39368;
        nArray2[197] = 35305;
        nArray[198] = 47498;
        nArray2[199] = 43435;
        nArray[200] = 22596;
        nArray2[201] = 18533;
        nArray[202] = 30726;
        nArray2[203] = 26663;
        nArray[204] = 6336;
        nArray2[205] = 2273;
        nArray[206] = 14466;
        nArray2[207] = 10403;
        nArray[208] = 52093;
        nArray2[209] = 56156;
        nArray[210] = 60223;
        nArray2[211] = 64286;
        nArray[212] = 35833;
        nArray2[213] = 39896;
        nArray[214] = 43963;
        nArray2[215] = 48026;
        nArray[216] = 19061;
        nArray2[217] = 23124;
        nArray[218] = 27191;
        nArray2[219] = 31254;
        nArray[220] = 2801;
        nArray2[221] = 6864;
        nArray[222] = 10931;
        nArray2[223] = 14994;
        nArray[224] = 64814;
        nArray2[225] = 60687;
        nArray[226] = 56684;
        nArray2[227] = 52557;
        nArray[228] = 48554;
        nArray2[229] = 44427;
        nArray[230] = 40424;
        nArray2[231] = 36297;
        nArray[232] = 31782;
        nArray2[233] = 27655;
        nArray[234] = 23652;
        nArray2[235] = 19525;
        nArray[236] = 15522;
        nArray2[237] = 11395;
        nArray[238] = 7392;
        nArray2[239] = 3265;
        nArray[240] = 61215;
        nArray2[241] = 65342;
        nArray[242] = 53085;
        nArray2[243] = 57212;
        nArray[244] = 44955;
        nArray2[245] = 49082;
        nArray[246] = 36825;
        nArray2[247] = 40952;
        nArray[248] = 28183;
        nArray2[249] = 32310;
        nArray[250] = 20053;
        nArray2[251] = 24180;
        nArray[252] = 11923;
        nArray2[253] = 16050;
        nArray[254] = 3793;
        nArray2[255] = 7920;
        b = object;
        object = new float[6][];
        int n10 = 3;
        float[] fArray3 = fArray2 = new float[n10];
        fArray2[0] = 1.0f;
        fArray3[1] = 0.0f;
        fArray3[2] = 0.0f;
        object[0] = (int)fArray2;
        float[] fArray4 = fArray2 = new float[n10];
        fArray2[0] = -1.0f;
        fArray4[1] = 0.0f;
        fArray4[2] = 0.0f;
        object[1] = (int)fArray2;
        float[] fArray5 = fArray2 = new float[n10];
        fArray2[0] = 0.0f;
        fArray5[1] = 1.0f;
        fArray5[2] = 0.0f;
        object[2] = (int)fArray2;
        float[] fArray6 = fArray2 = new float[n10];
        fArray2[0] = 0.0f;
        fArray6[1] = -1.0f;
        fArray6[2] = 0.0f;
        object[n10] = (int)fArray2;
        float[] fArray7 = fArray2 = new float[n10];
        fArray2[0] = 0.0f;
        fArray7[1] = 0.0f;
        fArray7[2] = 1.0f;
        object[4] = (int)fArray2;
        float[] fArray8 = fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray8[1] = 0.0f;
        fArray8[2] = -1.0f;
        object[5] = (int)fArray;
        c = (float[][])object;
    }

    public static boolean a(List object, int n10) {
        Class<j> clazz = j.class;
        synchronized (clazz) {
            float f10;
            int n11;
            int n12;
            int n13;
            block63: {
                n13 = 0;
                n12 = object.size();
                n11 = 4;
                f10 = 5.6E-45f;
                if (n12 == n11) break block63;
                return false;
            }
            Object object2 = object.get(0);
            object2 = (Integer)object2;
            n12 = (Integer)object2;
            float f11 = n12;
            n11 = 1166016512;
            f10 = 4096.0f;
            f11 /= f10;
            int n14 = 1;
            Object object3 = object.get(n14);
            object3 = (Integer)object3;
            int n15 = (Integer)object3;
            float f12 = (float)n15 / f10;
            int n16 = 2;
            Object object4 = object.get(n16);
            object4 = (Integer)object4;
            int n17 = (Integer)object4;
            float f13 = (float)n17 / f10;
            n11 = 3;
            f10 = 4.2E-45f;
            object = object.get(n11);
            object = (Integer)object;
            int n18 = (Integer)object;
            float f14 = n18;
            n11 = 1120403456;
            f14 /= 100.0f;
            f10 = f11 * f11;
            float f15 = f12 * f12;
            f10 += f15;
            f15 = f13 * f13;
            double d10 = f10 += f15;
            d10 = Math.sqrt(d10);
            f10 = (float)d10;
            CharSequence charSequence = "calculateAxisMap: ------------------------------------ ";
            q.i((String)charSequence);
            charSequence = new StringBuilder();
            Object object5 = "calculateAxisMap: [gyo] = ";
            ((StringBuilder)charSequence).append((String)object5);
            float f16 = Math.abs(f14);
            ((StringBuilder)charSequence).append(f16);
            charSequence = ((StringBuilder)charSequence).toString();
            q.i((String)charSequence);
            charSequence = new StringBuilder();
            object5 = "calculateAxisMap: [mod] = ";
            ((StringBuilder)charSequence).append((String)object5);
            f16 = 1.0f;
            f10 -= f16;
            f16 = Math.abs(f10);
            ((StringBuilder)charSequence).append(f16);
            charSequence = ((StringBuilder)charSequence).toString();
            q.i((String)charSequence);
            charSequence = new StringBuilder();
            object5 = "calculateAxisMap: [ x ] = ";
            ((StringBuilder)charSequence).append((String)object5);
            object5 = c;
            Object object6 = object5[n10];
            Object object7 = object6[0];
            object7 = f11 - object7;
            object7 = Math.abs((float)object7);
            ((StringBuilder)charSequence).append((float)object7);
            charSequence = ((StringBuilder)charSequence).toString();
            q.i((String)charSequence);
            charSequence = new StringBuilder();
            object6 = "calculateAxisMap: [ y ] = ";
            ((StringBuilder)charSequence).append((String)object6);
            object6 = object5[n10];
            object7 = object6[n14];
            object7 = f12 - object7;
            object7 = Math.abs((float)object7);
            ((StringBuilder)charSequence).append((float)object7);
            charSequence = ((StringBuilder)charSequence).toString();
            q.i((String)charSequence);
            charSequence = new StringBuilder();
            object6 = "calculateAxisMap: [ z ] = ";
            ((StringBuilder)charSequence).append((String)object6);
            object6 = object5[n10];
            object7 = object6[n16];
            object7 = f13 - object7;
            object7 = Math.abs((float)object7);
            ((StringBuilder)charSequence).append((float)object7);
            charSequence = ((StringBuilder)charSequence).toString();
            try {
                q.i((String)charSequence);
                f14 = Math.abs(f14);
                f15 = 0.3f;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Exception exception) {
                return false;
            }
            n18 = (int)(f14 == f15 ? 0 : (f14 < f15 ? -1 : 1));
            if (n18 <= 0) {
                f14 = Math.abs(f10);
                n18 = (int)(f14 == f15 ? 0 : (f14 < f15 ? -1 : 1));
                if (n18 <= 0) {
                    object = object5[n10];
                    f14 = (float)object[0];
                    f11 -= f14;
                    f14 = Math.abs(f11);
                    n18 = (int)(f14 == f15 ? 0 : (f14 < f15 ? -1 : 1));
                    if (n18 <= 0) {
                        object = object5[n10];
                        f14 = (float)object[n14];
                        f12 -= f14;
                        f14 = Math.abs(f12);
                        n18 = (int)(f14 == f15 ? 0 : (f14 < f15 ? -1 : 1));
                        if (n18 <= 0) {
                            object = object5[n10];
                            f14 = (float)object[n16];
                            f13 -= f14;
                            f14 = Math.abs(f13);
                            n18 = (int)(f14 == f15 ? 0 : (f14 < f15 ? -1 : 1));
                            if (n18 <= 0) {
                                n13 = n14;
                            }
                        }
                    }
                }
            }
            return n13 != 0;
        }
    }

    public static boolean b(int n10, int n11) {
        int n12 = 1;
        if ((n10 &= (n11 = n12 << n11)) != n11) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static int c(byte[] byArray) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray[i10];
            int n12 = n11 >> 8;
            n11 <<= 8;
            char c10 = (char)-1;
            n11 &= c10;
            int[] nArray = b;
            n10 = n10 & 0xFF ^ n12;
            n10 = nArray[n10];
            n11 = (n11 ^ n10) & c10;
        }
        return n11;
    }

    public static int d(rd object) {
        object = j.e((rd)object);
        int n10 = object[3] << 8 & 0xFF00;
        return Math.round((float)((short)(object[4] & 0xFF | n10)) * 1.0f);
    }

    public static byte[] e(rd rd2) {
        int n10;
        byte by2;
        int n11;
        byte[] byArray = new byte[7];
        byArray[0] = n11 = 6;
        byArray[1] = by2 = (byte)(rd2.a() >> 8);
        byArray[2] = by2 = (byte)rd2.a();
        byArray[3] = by2 = (byte)(rd2.b() >> 8);
        byArray[4] = n10 = (int)rd2.b();
        n10 = 5;
        int n12 = j.c(Arrays.copyOfRange(byArray, 0, n10));
        byArray[n10] = by2 = (byte)(n12 >> 8);
        byArray[n11] = n10 = (int)((byte)n12);
        return byArray;
    }
}

