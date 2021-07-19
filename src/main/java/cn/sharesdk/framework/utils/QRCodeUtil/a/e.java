/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  cn.sharesdk.framework.utils.QRCodeUtil.a.b
 */
package cn.sharesdk.framework.utils.QRCodeUtil.a;

import cn.sharesdk.framework.utils.QRCodeUtil.WriterException;
import cn.sharesdk.framework.utils.QRCodeUtil.a.b;
import cn.sharesdk.framework.utils.QRCodeUtil.a.d;
import cn.sharesdk.framework.utils.QRCodeUtil.a.f;
import cn.sharesdk.framework.utils.QRCodeUtil.n;

public final class e {
    private static final int[][] a;
    private static final int[][] b;
    private static final int[][] c;
    private static final int[][] d;

    static {
        int[] nArray;
        int n10 = 7;
        int[][] nArrayArray = new int[n10][];
        int[] nArray2 = nArray = new int[n10];
        int[] nArray3 = nArray;
        nArray2[0] = 1;
        nArray3[1] = 1;
        nArray2[2] = 1;
        nArray3[3] = 1;
        nArray2[4] = 1;
        nArray3[5] = 1;
        nArray3[6] = 1;
        nArrayArray[0] = nArray;
        int[] nArray4 = nArray = new int[n10];
        int[] nArray5 = nArray;
        nArray4[0] = 1;
        nArray5[1] = 0;
        nArray4[2] = 0;
        nArray5[3] = 0;
        nArray4[4] = 0;
        nArray5[5] = 0;
        nArray5[6] = 1;
        int n11 = 1;
        nArrayArray[n11] = nArray;
        int[] nArray6 = nArray = new int[n10];
        int[] nArray7 = nArray;
        nArray6[0] = 1;
        nArray7[1] = 0;
        nArray6[2] = 1;
        nArray7[3] = 1;
        nArray6[4] = 1;
        nArray7[5] = 0;
        nArray7[6] = 1;
        int n12 = 2;
        nArrayArray[n12] = nArray;
        int[] nArray8 = nArray = new int[n10];
        int[] nArray9 = nArray;
        nArray8[0] = 1;
        nArray9[1] = 0;
        nArray8[2] = 1;
        nArray9[3] = 1;
        nArray8[4] = 1;
        nArray9[5] = 0;
        nArray9[6] = 1;
        int n13 = 3;
        nArrayArray[n13] = nArray;
        int[] nArray10 = nArray = new int[n10];
        int[] nArray11 = nArray;
        nArray10[0] = 1;
        nArray11[1] = 0;
        nArray10[2] = 1;
        nArray11[3] = 1;
        nArray10[4] = 1;
        nArray11[5] = 0;
        nArray11[6] = 1;
        int n14 = 4;
        nArrayArray[n14] = nArray;
        int[] nArray12 = nArray = new int[n10];
        int[] nArray13 = nArray;
        nArray12[0] = 1;
        nArray13[1] = 0;
        nArray12[2] = 0;
        nArray13[3] = 0;
        nArray12[4] = 0;
        nArray13[5] = 0;
        nArray13[6] = 1;
        int n15 = 5;
        nArrayArray[n15] = nArray;
        int[] nArray14 = nArray = new int[n10];
        int[] nArray15 = nArray;
        nArray14[0] = 1;
        nArray15[1] = 1;
        nArray14[2] = 1;
        nArray15[3] = 1;
        nArray14[4] = 1;
        nArray15[5] = 1;
        nArray15[6] = 1;
        int n16 = 6;
        nArrayArray[n16] = nArray;
        a = nArrayArray;
        nArrayArray = new int[n15][];
        int[] nArray16 = nArray = new int[n15];
        int[] nArray17 = nArray;
        nArray16[0] = 1;
        nArray17[1] = 1;
        nArray16[2] = 1;
        nArray17[3] = 1;
        nArray17[4] = 1;
        nArrayArray[0] = nArray;
        int[] nArray18 = nArray = new int[n15];
        int[] nArray19 = nArray;
        nArray18[0] = 1;
        nArray19[1] = 0;
        nArray18[2] = 0;
        nArray19[3] = 0;
        nArray19[4] = 1;
        nArrayArray[n11] = nArray;
        int[] nArray20 = nArray = new int[n15];
        int[] nArray21 = nArray;
        nArray20[0] = 1;
        nArray21[1] = 0;
        nArray20[2] = 1;
        nArray21[3] = 0;
        nArray21[4] = 1;
        nArrayArray[n12] = nArray;
        int[] nArray22 = nArray = new int[n15];
        int[] nArray23 = nArray;
        nArray22[0] = 1;
        nArray23[1] = 0;
        nArray22[2] = 0;
        nArray23[3] = 0;
        nArray23[4] = 1;
        nArrayArray[n13] = nArray;
        int[] nArray24 = nArray = new int[n15];
        int[] nArray25 = nArray;
        nArray24[0] = 1;
        nArray25[1] = 1;
        nArray24[2] = 1;
        nArray25[3] = 1;
        nArray25[4] = 1;
        nArrayArray[n14] = nArray;
        b = nArrayArray;
        nArrayArray = new int[40][];
        int[] nArray26 = nArray = new int[n10];
        int[] nArray27 = nArray;
        nArray26[0] = -1;
        nArray27[1] = -1;
        nArray26[2] = -1;
        nArray27[3] = -1;
        nArray26[4] = -1;
        nArray27[5] = -1;
        nArray27[6] = -1;
        nArrayArray[0] = nArray;
        int[] nArray28 = nArray = new int[n10];
        int[] nArray29 = nArray;
        nArray28[0] = 6;
        nArray29[1] = 18;
        nArray28[2] = -1;
        nArray29[3] = -1;
        nArray28[4] = -1;
        nArray29[5] = -1;
        nArray29[6] = -1;
        nArrayArray[n11] = nArray;
        int[] nArray30 = nArray = new int[n10];
        int[] nArray31 = nArray;
        nArray30[0] = 6;
        nArray31[1] = 22;
        nArray30[2] = -1;
        nArray31[3] = -1;
        nArray30[4] = -1;
        nArray31[5] = -1;
        nArray31[6] = -1;
        nArrayArray[n12] = nArray;
        int[] nArray32 = nArray = new int[n10];
        int[] nArray33 = nArray;
        nArray32[0] = 6;
        nArray33[1] = 26;
        nArray32[2] = -1;
        nArray33[3] = -1;
        nArray32[4] = -1;
        nArray33[5] = -1;
        nArray33[6] = -1;
        nArrayArray[n13] = nArray;
        int[] nArray34 = nArray = new int[n10];
        int[] nArray35 = nArray;
        nArray34[0] = 6;
        nArray35[1] = 30;
        nArray34[2] = -1;
        nArray35[3] = -1;
        nArray34[4] = -1;
        nArray35[5] = -1;
        nArray35[6] = -1;
        nArrayArray[n14] = nArray;
        int[] nArray36 = nArray = new int[n10];
        int[] nArray37 = nArray;
        nArray36[0] = 6;
        nArray37[1] = 34;
        nArray36[2] = -1;
        nArray37[3] = -1;
        nArray36[4] = -1;
        nArray37[5] = -1;
        nArray37[6] = -1;
        nArrayArray[n15] = nArray;
        int[] nArray38 = nArray = new int[n10];
        int[] nArray39 = nArray;
        nArray38[0] = 6;
        nArray39[1] = 22;
        nArray38[2] = 38;
        nArray39[3] = -1;
        nArray38[4] = -1;
        nArray39[5] = -1;
        nArray39[6] = -1;
        nArrayArray[n16] = nArray;
        int[] nArray40 = nArray = new int[n10];
        int[] nArray41 = nArray;
        nArray40[0] = 6;
        nArray41[1] = 24;
        nArray40[2] = 42;
        nArray41[3] = -1;
        nArray40[4] = -1;
        nArray41[5] = -1;
        nArray41[6] = -1;
        nArrayArray[n10] = nArray;
        int[] nArray42 = nArray = new int[n10];
        int[] nArray43 = nArray;
        nArray42[0] = 6;
        nArray43[1] = 26;
        nArray42[2] = 46;
        nArray43[3] = -1;
        nArray42[4] = -1;
        nArray43[5] = -1;
        nArray43[6] = -1;
        int n17 = 8;
        nArrayArray[n17] = nArray;
        int[] nArray44 = nArray = new int[n10];
        int[] nArray45 = nArray;
        nArray44[0] = 6;
        nArray45[1] = 28;
        nArray44[2] = 50;
        nArray45[3] = -1;
        nArray44[4] = -1;
        nArray45[5] = -1;
        nArray45[6] = -1;
        int n18 = 9;
        nArrayArray[n18] = nArray;
        int[] nArray46 = nArray = new int[n10];
        int[] nArray47 = nArray;
        nArray46[0] = 6;
        nArray47[1] = 30;
        nArray46[2] = 54;
        nArray47[3] = -1;
        nArray46[4] = -1;
        nArray47[5] = -1;
        nArray47[6] = -1;
        int n19 = 10;
        nArrayArray[n19] = nArray;
        int[] nArray48 = nArray = new int[n10];
        int[] nArray49 = nArray;
        nArray48[0] = 6;
        nArray49[1] = 32;
        nArray48[2] = 58;
        nArray49[3] = -1;
        nArray48[4] = -1;
        nArray49[5] = -1;
        nArray49[6] = -1;
        int n20 = 11;
        nArrayArray[n20] = nArray;
        int[] nArray50 = nArray = new int[n10];
        int[] nArray51 = nArray;
        nArray50[0] = 6;
        nArray51[1] = 34;
        nArray50[2] = 62;
        nArray51[3] = -1;
        nArray50[4] = -1;
        nArray51[5] = -1;
        nArray51[6] = -1;
        int n21 = 12;
        nArrayArray[n21] = nArray;
        int[] nArray52 = nArray = new int[n10];
        int[] nArray53 = nArray;
        nArray52[0] = 6;
        nArray53[1] = 26;
        nArray52[2] = 46;
        nArray53[3] = 66;
        nArray52[4] = -1;
        nArray53[5] = -1;
        nArray53[6] = -1;
        nArrayArray[13] = nArray;
        int[] nArray54 = nArray = new int[n10];
        int[] nArray55 = nArray;
        nArray54[0] = 6;
        nArray55[1] = 26;
        nArray54[2] = 48;
        nArray55[3] = 70;
        nArray54[4] = -1;
        nArray55[5] = -1;
        nArray55[6] = -1;
        int n22 = 14;
        nArrayArray[n22] = nArray;
        int[] nArray56 = nArray = new int[n10];
        int[] nArray57 = nArray;
        nArray56[0] = 6;
        nArray57[1] = 26;
        nArray56[2] = 50;
        nArray57[3] = 74;
        nArray56[4] = -1;
        nArray57[5] = -1;
        nArray57[6] = -1;
        int n23 = 15;
        nArrayArray[n23] = nArray;
        int[] nArray58 = nArray = new int[n10];
        int[] nArray59 = nArray;
        nArray58[0] = 6;
        nArray59[1] = 30;
        nArray58[2] = 54;
        nArray59[3] = 78;
        nArray58[4] = -1;
        nArray59[5] = -1;
        nArray59[6] = -1;
        nArrayArray[16] = nArray;
        int[] nArray60 = nArray = new int[n10];
        int[] nArray61 = nArray;
        nArray60[0] = 6;
        nArray61[1] = 30;
        nArray60[2] = 56;
        nArray61[3] = 82;
        nArray60[4] = -1;
        nArray61[5] = -1;
        nArray61[6] = -1;
        nArrayArray[17] = nArray;
        int[] nArray62 = nArray = new int[n10];
        int[] nArray63 = nArray;
        nArray62[0] = 6;
        nArray63[1] = 30;
        nArray62[2] = 58;
        nArray63[3] = 86;
        nArray62[4] = -1;
        nArray63[5] = -1;
        nArray63[6] = -1;
        nArrayArray[18] = nArray;
        int[] nArray64 = nArray = new int[n10];
        int[] nArray65 = nArray;
        nArray64[0] = 6;
        nArray65[1] = 34;
        nArray64[2] = 62;
        nArray65[3] = 90;
        nArray64[4] = -1;
        nArray65[5] = -1;
        nArray65[6] = -1;
        nArrayArray[19] = nArray;
        int[] nArray66 = nArray = new int[n10];
        int[] nArray67 = nArray;
        nArray66[0] = 6;
        nArray67[1] = 28;
        nArray66[2] = 50;
        nArray67[3] = 72;
        nArray66[4] = 94;
        nArray67[5] = -1;
        nArray67[6] = -1;
        nArrayArray[20] = nArray;
        int[] nArray68 = nArray = new int[n10];
        int[] nArray69 = nArray;
        nArray68[0] = 6;
        nArray69[1] = 26;
        nArray68[2] = 50;
        nArray69[3] = 74;
        nArray68[4] = 98;
        nArray69[5] = -1;
        nArray69[6] = -1;
        nArrayArray[21] = nArray;
        int[] nArray70 = nArray = new int[n10];
        int[] nArray71 = nArray;
        nArray70[0] = 6;
        nArray71[1] = 30;
        nArray70[2] = 54;
        nArray71[3] = 78;
        nArray70[4] = 102;
        nArray71[5] = -1;
        nArray71[6] = -1;
        nArrayArray[22] = nArray;
        int[] nArray72 = nArray = new int[n10];
        int[] nArray73 = nArray;
        nArray72[0] = 6;
        nArray73[1] = 28;
        nArray72[2] = 54;
        nArray73[3] = 80;
        nArray72[4] = 106;
        nArray73[5] = -1;
        nArray73[6] = -1;
        nArrayArray[23] = nArray;
        int[] nArray74 = nArray = new int[n10];
        int[] nArray75 = nArray;
        nArray74[0] = 6;
        nArray75[1] = 32;
        nArray74[2] = 58;
        nArray75[3] = 84;
        nArray74[4] = 110;
        nArray75[5] = -1;
        nArray75[6] = -1;
        nArrayArray[24] = nArray;
        int[] nArray76 = nArray = new int[n10];
        int[] nArray77 = nArray;
        nArray76[0] = 6;
        nArray77[1] = 30;
        nArray76[2] = 58;
        nArray77[3] = 86;
        nArray76[4] = 114;
        nArray77[5] = -1;
        nArray77[6] = -1;
        nArrayArray[25] = nArray;
        int[] nArray78 = nArray = new int[n10];
        int[] nArray79 = nArray;
        nArray78[0] = 6;
        nArray79[1] = 34;
        nArray78[2] = 62;
        nArray79[3] = 90;
        nArray78[4] = 118;
        nArray79[5] = -1;
        nArray79[6] = -1;
        nArrayArray[26] = nArray;
        int[] nArray80 = nArray = new int[n10];
        int[] nArray81 = nArray;
        nArray80[0] = 6;
        nArray81[1] = 26;
        nArray80[2] = 50;
        nArray81[3] = 74;
        nArray80[4] = 98;
        nArray81[5] = 122;
        nArray81[6] = -1;
        nArrayArray[27] = nArray;
        int[] nArray82 = nArray = new int[n10];
        int[] nArray83 = nArray;
        nArray82[0] = 6;
        nArray83[1] = 30;
        nArray82[2] = 54;
        nArray83[3] = 78;
        nArray82[4] = 102;
        nArray83[5] = 126;
        nArray83[6] = -1;
        nArrayArray[28] = nArray;
        int[] nArray84 = nArray = new int[n10];
        int[] nArray85 = nArray;
        nArray84[0] = 6;
        nArray85[1] = 26;
        nArray84[2] = 52;
        nArray85[3] = 78;
        nArray84[4] = 104;
        nArray85[5] = 130;
        nArray85[6] = -1;
        nArrayArray[29] = nArray;
        int[] nArray86 = nArray = new int[n10];
        int[] nArray87 = nArray;
        nArray86[0] = 6;
        nArray87[1] = 30;
        nArray86[2] = 56;
        nArray87[3] = 82;
        nArray86[4] = 108;
        nArray87[5] = 134;
        nArray87[6] = -1;
        nArrayArray[30] = nArray;
        int[] nArray88 = nArray = new int[n10];
        int[] nArray89 = nArray;
        nArray88[0] = 6;
        nArray89[1] = 34;
        nArray88[2] = 60;
        nArray89[3] = 86;
        nArray88[4] = 112;
        nArray89[5] = 138;
        nArray89[6] = -1;
        nArrayArray[31] = nArray;
        int[] nArray90 = nArray = new int[n10];
        int[] nArray91 = nArray;
        nArray90[0] = 6;
        nArray91[1] = 30;
        nArray90[2] = 58;
        nArray91[3] = 86;
        nArray90[4] = 114;
        nArray91[5] = 142;
        nArray91[6] = -1;
        nArrayArray[32] = nArray;
        int[] nArray92 = nArray = new int[n10];
        int[] nArray93 = nArray;
        nArray92[0] = 6;
        nArray93[1] = 34;
        nArray92[2] = 62;
        nArray93[3] = 90;
        nArray92[4] = 118;
        nArray93[5] = 146;
        nArray93[6] = -1;
        nArrayArray[33] = nArray;
        int[] nArray94 = nArray = new int[n10];
        int[] nArray95 = nArray;
        nArray94[0] = 6;
        nArray95[1] = 30;
        nArray94[2] = 54;
        nArray95[3] = 78;
        nArray94[4] = 102;
        nArray95[5] = 126;
        nArray95[6] = 150;
        nArrayArray[34] = nArray;
        int[] nArray96 = nArray = new int[n10];
        int[] nArray97 = nArray;
        nArray96[0] = 6;
        nArray97[1] = 24;
        nArray96[2] = 50;
        nArray97[3] = 76;
        nArray96[4] = 102;
        nArray97[5] = 128;
        nArray97[6] = 154;
        nArrayArray[35] = nArray;
        int[] nArray98 = nArray = new int[n10];
        int[] nArray99 = nArray;
        nArray98[0] = 6;
        nArray99[1] = 28;
        nArray98[2] = 54;
        nArray99[3] = 80;
        nArray98[4] = 106;
        nArray99[5] = 132;
        nArray99[6] = 158;
        nArrayArray[36] = nArray;
        int[] nArray100 = nArray = new int[n10];
        int[] nArray101 = nArray;
        nArray100[0] = 6;
        nArray101[1] = 32;
        nArray100[2] = 58;
        nArray101[3] = 84;
        nArray100[4] = 110;
        nArray101[5] = 136;
        nArray101[6] = 162;
        nArrayArray[37] = nArray;
        int[] nArray102 = nArray = new int[n10];
        int[] nArray103 = nArray;
        nArray102[0] = 6;
        nArray103[1] = 26;
        nArray102[2] = 54;
        nArray103[3] = 82;
        nArray102[4] = 110;
        nArray103[5] = 138;
        nArray103[6] = 166;
        nArrayArray[38] = nArray;
        int[] nArray104 = nArray = new int[n10];
        int[] nArray105 = nArray;
        nArray104[0] = 6;
        nArray105[1] = 30;
        nArray104[2] = 58;
        nArray105[3] = 86;
        nArray104[4] = 114;
        nArray105[5] = 142;
        nArray105[6] = 170;
        nArrayArray[39] = nArray;
        c = nArrayArray;
        nArrayArray = new int[n23][];
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 0;
        nArrayArray[0] = nArray;
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 1;
        nArrayArray[n11] = nArray;
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 2;
        nArrayArray[n12] = nArray;
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 3;
        nArrayArray[n13] = nArray;
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 4;
        nArrayArray[n14] = nArray;
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 5;
        nArrayArray[n15] = nArray;
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 7;
        nArrayArray[n16] = nArray;
        nArray = new int[n12];
        nArray[0] = 8;
        nArray[1] = 8;
        nArrayArray[n10] = nArray;
        int[] nArray106 = new int[n12];
        nArray106[0] = 7;
        nArray106[1] = 8;
        nArrayArray[n17] = nArray106;
        nArray106 = new int[n12];
        nArray106[0] = 5;
        nArray106[1] = 8;
        nArrayArray[n18] = nArray106;
        nArray106 = new int[n12];
        nArray106[0] = 4;
        nArray106[1] = 8;
        nArrayArray[n19] = nArray106;
        nArray106 = new int[n12];
        nArray106[0] = 3;
        nArray106[1] = 8;
        nArrayArray[n20] = nArray106;
        nArray106 = new int[n12];
        nArray106[0] = 2;
        nArray106[1] = 8;
        nArrayArray[n21] = nArray106;
        nArray106 = new int[n12];
        nArray106[0] = 1;
        nArray106[1] = 8;
        nArrayArray[13] = nArray106;
        nArray106 = new int[n12];
        nArray106[0] = 0;
        nArray106[1] = 8;
        nArrayArray[n22] = nArray106;
        d = nArrayArray;
    }

    public static int a(int n10) {
        n10 = Integer.numberOfLeadingZeros(n10);
        return 32 - n10;
    }

    public static int a(int n10, int n11) {
        if (n11 != 0) {
            int n12 = e.a(n11);
            int n13 = n12 + -1;
            n10 <<= n13;
            while ((n13 = e.a(n10)) >= n12) {
                n13 = e.a(n10) - n12;
                n13 = n11 << n13;
                n10 ^= n13;
            }
            return n10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("0 polynomial");
        throw illegalArgumentException;
    }

    private static void a(int n10, int n11, b b10) {
        int n12;
        for (int i10 = 0; i10 < (n12 = 8); ++i10) {
            n12 = n10 + i10;
            boolean bl2 = e.b(b10.a(n12, n11));
            if (bl2) {
                b10.a(n12, n11, 0);
                continue;
            }
            WriterException writerException = new WriterException();
            throw writerException;
        }
    }

    public static void a(b b10) {
        b10.a((byte)-1);
    }

    public static void a(cn.sharesdk.framework.utils.QRCodeUtil.b object, int n10, b object2) {
        int n11;
        int n12 = object2.a() + -1;
        int n13 = n11 = -1;
        int n14 = 0;
        for (int i10 = object2.b() + -1; i10 > 0; i10 += -2) {
            int n15 = 6;
            if (i10 == n15) {
                i10 += -1;
            }
            while (n12 >= 0 && n12 < (n15 = object2.a())) {
                int n16;
                for (n15 = 0; n15 < (n16 = 2); ++n15) {
                    boolean bl2;
                    n16 = i10 - n15;
                    int n17 = e.b(object2.a(n16, n12));
                    if (!n17) continue;
                    n17 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a();
                    if (n14 < n17) {
                        n17 = (int)(((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a(n14) ? 1 : 0);
                        ++n14;
                    } else {
                        n17 = 0;
                    }
                    if (n10 != n11 && (bl2 = cn.sharesdk.framework.utils.QRCodeUtil.a.d.a(n10, n16, n12))) {
                        n17 ^= true;
                    }
                    object2.a(n16, n12, n17 != 0);
                }
                n12 += n13;
            }
            n13 = -n13;
            n12 += n13;
        }
        n10 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a();
        if (n14 == n10) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Not all bits consumed: ");
        ((StringBuilder)object2).append(n14);
        ((StringBuilder)object2).append('/');
        int n18 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a();
        ((StringBuilder)object2).append(n18);
        object = ((StringBuilder)object2).toString();
        WriterException writerException = new WriterException((String)object);
        throw writerException;
    }

    public static void a(cn.sharesdk.framework.utils.QRCodeUtil.b b10, cn.sharesdk.framework.utils.QRCodeUtil.f f10, n n10, int n11, b b11) {
        e.a(b11);
        e.a(n10, b11);
        e.a(f10, n11, b11);
        e.b(n10, b11);
        e.a(b10, n11, b11);
    }

    public static void a(cn.sharesdk.framework.utils.QRCodeUtil.f f10, int n10, b b10) {
        int n11;
        cn.sharesdk.framework.utils.QRCodeUtil.b b11 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
        e.a(f10, n10, b11);
        f10 = null;
        for (n10 = 0; n10 < (n11 = b11.a()); ++n10) {
            n11 = b11.a();
            int n12 = 1;
            n11 = n11 - n12 - n10;
            n11 = (int)(b11.a(n11) ? 1 : 0);
            int[] nArray = d[n10];
            int n13 = nArray[0];
            int n14 = nArray[n12];
            b10.a(n13, n14, n11 != 0);
            n14 = 8;
            if (n10 < n14) {
                n13 = b10.b() - n10 - n12;
                b10.a(n13, n14, n11 != 0);
                continue;
            }
            n12 = b10.a() + -7;
            n13 = n10 + -8;
            b10.a(n14, n12 += n13, n11 != 0);
        }
    }

    public static void a(cn.sharesdk.framework.utils.QRCodeUtil.f object, int n10, cn.sharesdk.framework.utils.QRCodeUtil.b b10) {
        int n11 = f.b(n10);
        if (n11 != 0) {
            int n12 = ((cn.sharesdk.framework.utils.QRCodeUtil.f)((Object)object)).a() << 3 | n10;
            b10.a(n12, 5);
            n12 = e.a(n12, 1335);
            b10.a(n12, 10);
            object = new cn.sharesdk.framework.utils.QRCodeUtil.b();
            n10 = 21522;
            n11 = 15;
            ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a(n10, n11);
            b10.b((cn.sharesdk.framework.utils.QRCodeUtil.b)object);
            n12 = b10.a();
            if (n12 == n11) {
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("should not happen but we got: ");
            int n13 = b10.a();
            charSequence.append(n13);
            charSequence = charSequence.toString();
            object = new WriterException((String)charSequence);
            throw object;
        }
        object = new WriterException("Invalid mask pattern");
        throw object;
    }

    public static void a(n n10, b b10) {
        e.d(b10);
        e.c(b10);
        e.c(n10, b10);
        e.b(b10);
    }

    public static void a(n object, cn.sharesdk.framework.utils.QRCodeUtil.b object2) {
        int n10 = ((n)object).a();
        int n11 = 6;
        ((cn.sharesdk.framework.utils.QRCodeUtil.b)object2).a(n10, n11);
        int n12 = e.a(((n)object).a(), 7973);
        ((cn.sharesdk.framework.utils.QRCodeUtil.b)object2).a(n12, 12);
        n12 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object2).a();
        n10 = 18;
        if (n12 == n10) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("should not happen but we got: ");
        int n13 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object2).a();
        stringBuilder.append(n13);
        object2 = stringBuilder.toString();
        object = new WriterException((String)object2);
        throw object;
    }

    private static void b(int n10, int n11, b b10) {
        int n12;
        for (int i10 = 0; i10 < (n12 = 7); ++i10) {
            n12 = n11 + i10;
            boolean bl2 = e.b(b10.a(n10, n12));
            if (bl2) {
                b10.a(n10, n12, 0);
                continue;
            }
            WriterException writerException = new WriterException();
            throw writerException;
        }
    }

    private static void b(b b10) {
        int n10;
        int n11;
        int n12 = n11 = 8;
        while (n12 < (n10 = b10.b() - n11)) {
            n10 = n12 + 1;
            int n13 = n10 % 2;
            int n14 = 6;
            boolean bl2 = e.b(b10.a(n12, n14));
            if (bl2) {
                b10.a(n12, n14, n13);
            }
            if (bl2 = e.b(b10.a(n14, n12))) {
                b10.a(n14, n12, n13);
            }
            n12 = n10;
        }
    }

    public static void b(n n10, b b10) {
        int n11;
        int n12;
        int n13 = n10.a();
        if (n13 < (n12 = 7)) {
            return;
        }
        cn.sharesdk.framework.utils.QRCodeUtil.b b11 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
        e.a(n10, b11);
        int n14 = 17;
        n12 = 0;
        for (int i10 = 0; i10 < (n11 = 6); ++i10) {
            int n15;
            for (n11 = 0; n11 < (n15 = 3); ++n11) {
                n15 = (int)(b11.a(n14) ? 1 : 0);
                n14 += -1;
                int n16 = b10.a() + -11 + n11;
                b10.a(i10, n16, n15 != 0);
                n16 = b10.a() + -11 + n11;
                b10.a(n16, i10, n15 != 0);
            }
        }
    }

    private static boolean b(int n10) {
        int n11 = -1;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    private static void c(int n10, int n11, b b10) {
        int n12;
        for (int i10 = 0; i10 < (n12 = 5); ++i10) {
            int[] nArray = b[i10];
            for (int i11 = 0; i11 < n12; ++i11) {
                int n13 = n10 + i11;
                int n14 = n11 + i10;
                int n15 = nArray[i11];
                b10.a(n13, n14, n15);
            }
        }
    }

    private static void c(b object) {
        int n10 = object.a();
        int n11 = 8;
        n10 -= n11;
        if ((n10 = (int)object.a(n11, n10)) != 0) {
            n10 = object.a() - n11;
            object.a(n11, n10, 1);
            return;
        }
        object = new WriterException();
        throw object;
    }

    private static void c(n object, b b10) {
        int n10;
        int n11 = ((n)object).a();
        if (n11 < (n10 = 2)) {
            return;
        }
        int n12 = ((n)object).a() + -1;
        int[][] nArray = c;
        object = nArray[n12];
        n11 = ((Object)object).length;
        n10 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object2 = object[i10];
            if (object2 < 0) continue;
            int n13 = ((Object)object).length;
            for (int i11 = 0; i11 < n13; ++i11) {
                int n14;
                reference var10_10 = object[i11];
                if (var10_10 < 0 || (n14 = e.b(b10.a((int)var10_10, (int)object2))) == false) continue;
                n14 = object2 + -2;
                e.c((int)(var10_10 += -2), n14, b10);
            }
        }
    }

    private static void d(int n10, int n11, b b10) {
        int n12;
        for (int i10 = 0; i10 < (n12 = 7); ++i10) {
            int[] nArray = a[i10];
            for (int i11 = 0; i11 < n12; ++i11) {
                int n13 = n10 + i11;
                int n14 = n11 + i10;
                int n15 = nArray[i11];
                b10.a(n13, n14, n15);
            }
        }
    }

    private static void d(b b10) {
        int n10 = a[0].length;
        e.d(0, 0, b10);
        e.d(b10.b() - n10, 0, b10);
        int n11 = b10.b() - n10;
        e.d(0, n11, b10);
        n10 = 7;
        e.a(0, n10, b10);
        e.a(b10.b() + -8, n10, b10);
        n11 = b10.b() + -8;
        e.a(0, n11, b10);
        e.b(n10, 0, b10);
        e.b(b10.a() - n10 + -1, 0, b10);
        int n12 = b10.a() - n10;
        e.b(n10, n12, b10);
    }
}

