/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS;
    private static final int SEARCH_LENGTH = 4096;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[29];
        int[] nArray3 = nArray;
        nArray2[0] = 1769172845;
        nArray3[1] = 1769172786;
        nArray2[2] = 1769172787;
        nArray3[3] = 1769172788;
        nArray2[4] = 1769172789;
        nArray3[5] = 1769172790;
        nArray2[6] = 1769172793;
        nArray3[7] = 1635148593;
        nArray2[8] = 1752589105;
        nArray3[9] = 1751479857;
        nArray2[10] = 1635135537;
        nArray3[11] = 1836069937;
        nArray2[12] = 1836069938;
        nArray3[13] = 862401121;
        nArray2[14] = 862401122;
        nArray3[15] = 862417462;
        nArray2[16] = 0x33677336;
        nArray3[17] = 862414134;
        nArray2[18] = 0x33676736;
        nArray3[19] = 1295275552;
        nArray2[20] = 1295270176;
        nArray3[21] = 1714714144;
        nArray2[22] = 1801741417;
        nArray3[23] = 1295275600;
        nArray2[24] = 1903435808;
        nArray3[25] = 1297305174;
        nArray2[26] = 1684175153;
        nArray3[27] = 1769172332;
        nArray3[28] = 1885955686;
        COMPATIBLE_BRANDS = nArray;
    }

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int n10, boolean bl2) {
        int n11 = n10 >>> 8;
        boolean bl3 = true;
        int n12 = 3368816;
        if (n11 == n12) {
            return bl3;
        }
        n11 = 1751476579;
        if (n10 == n11 && bl2) {
            return bl3;
        }
        int[] nArray = COMPATIBLE_BRANDS;
        n11 = nArray.length;
        n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13 = nArray[i10];
            if (n13 != n10) continue;
            return bl3;
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) {
        return Sniffer.sniffInternal(extractorInput, true, false);
    }

    /*
     * Unable to fully structure code
     */
    private static boolean sniffInternal(ExtractorInput var0, boolean var1_1, boolean var2_2) {
        block22: {
            block21: {
                block17: {
                    block19: {
                        block20: {
                            var3_3 = var0;
                            var4_4 = var0.getLength();
                            var6_5 = -1;
                            var8_6 = var4_4 == var6_5 ? 0 : (var4_4 < var6_5 ? -1 : 1);
                            var9_7 = 4096L;
                            if (var8_6 != false && (var11_8 = var4_4 == var9_7 ? 0 : (var4_4 < var9_7 ? -1 : 1)) <= 0) {
                                var9_7 = var4_4;
                            }
                            var12_9 = (int)var9_7;
                            var13_10 = new ParsableByteArray(64);
                            var11_8 = 0;
                            var14_11 = 0;
                            var15_12 = 0;
                            block0: while (true) {
                                var16_13 = 1;
                                var17_14 = 1.4E-45f;
                                if (var14_11 >= var12_9) break block17;
                                var18_15 = 8;
                                var19_16 = 1.1E-44f;
                                var13_10.reset(var18_15);
                                var20_17 = var13_10.getData();
                                var21_18 = var3_3.peekFully(var20_17, 0, var18_15, (boolean)var16_13);
                                if (!var21_18) break block17;
                                var22_19 = var13_10.readUnsignedInt();
                                var24_20 = var13_10.readInt();
                                var25_21 = 1L;
                                var27_22 = var22_19 == var25_21 ? 0 : (var22_19 < var25_21 ? -1 : 1);
                                var16_13 = 16;
                                var17_14 = 2.24E-44f;
                                if (var27_22 == false) {
                                    var20_17 = var13_10.getData();
                                    var3_3.peekFully(var20_17, var18_15, var18_15);
                                    var13_10.setLimit(var16_13);
                                    var22_19 = var13_10.readLong();
                                } else {
                                    var28_23 = 0L;
                                    cfr_temp_0 = var22_19 - var28_23;
                                    var16_13 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                    if (var16_13 == 0 && (var16_13 = (int)((cfr_temp_1 = (var28_23 = var0.getLength()) - var6_5) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
                                        var22_19 = var0.getPeekPosition();
                                        var28_23 -= var22_19;
                                        var22_19 = var18_15;
                                        var22_19 = var28_23 + var22_19;
                                    }
                                    var16_13 = var18_15;
                                    var17_14 = var19_16;
                                }
                                var6_5 = var16_13;
                                var27_22 = var22_19 == var6_5 ? 0 : (var22_19 < var6_5 ? -1 : 1);
                                if (var27_22 < 0) {
                                    return false;
                                }
                                var14_11 += var16_13;
                                var16_13 = 1836019574;
                                var17_14 = 4.631354E27f;
                                if (var24_20 != var16_13) break;
                                var30_24 = (int)var22_19;
                                var12_9 += var30_24;
                                if (var8_6 != false && (var30_24 = (int)((cfr_temp_2 = (var6_5 = (long)var12_9) - var4_4) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) > 0) {
                                    var12_9 = (int)var4_4;
                                }
lbl57:
                                // 4 sources

                                while (true) {
                                    var6_5 = -1;
                                    continue block0;
                                    break;
                                }
                                break;
                            }
                            var16_13 = 0x6D6F6F66;
                            var17_14 = 4.6313494E27f;
                            if (var24_20 == var16_13) break block19;
                            var16_13 = 1836475768;
                            var17_14 = 4.7659988E27f;
                            if (var24_20 == var16_13) break block19;
                            var31_25 = var4_4;
                            var4_4 = (long)var14_11 + var22_19 - var6_5;
                            var27_22 = var14_11;
                            var33_26 = var12_9;
                            cfr_temp_3 = var4_4 - var33_26;
                            var35_27 = (int)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                            if (var35_27 < 0) break block20;
                            var36_28 = 0;
                            var30_24 = 1;
                            break block21;
                        }
                        var35_27 = (int)(var22_19 -= var6_5);
                        var14_11 += var35_27;
                        var36_28 = 1718909296;
                        if (var24_20 == var36_28) {
                            block18: {
                                if (var35_27 < var18_15) {
                                    return false;
                                }
                                var13_10.reset(var35_27);
                                var37_29 = var13_10.getData();
                                var3_3.peekFully(var37_29, 0, var35_27);
                                for (var36_28 = 0; var36_28 < (var35_27 /= 4); ++var36_28) {
                                    var30_24 = 1;
                                    if (var36_28 == var30_24) {
                                        var38_30 = 4;
                                        var13_10.skipBytes(var38_30);
                                        var11_8 = (long)var2_2;
                                        continue;
                                    }
                                    var38_30 = var13_10.readInt();
                                    var11_8 = (long)var2_2;
                                    if ((var38_30 = (int)Sniffer.isCompatibleBrand(var38_30, var2_2)) == 0) continue;
                                    var15_12 = var30_24;
                                    break block18;
                                }
                                var11_8 = (long)var2_2;
                            }
                            if (var15_12 == 0) {
                                return false;
                            }
                            var36_28 = 0;
                        } else {
                            var11_8 = (long)var2_2;
                            var36_28 = 0;
                            if (var35_27 != 0) {
                                var3_3.advancePeekPosition(var35_27);
                            }
                        }
                        var11_8 = 0;
                        var4_4 = var31_25;
                        ** while (true)
                    }
                    var36_28 = 0;
                    var39_31 = var30_24 = 1;
                    break block22;
                }
                var36_28 = 0;
                var30_24 = var16_13;
            }
            var39_31 = 0;
            var3_3 = null;
        }
        if (var15_12 == 0) ** GOTO lbl-1000
        var35_27 = var1_1;
        if (var1_1 == var39_31) {
            var11_8 = var30_24;
        } else lbl-1000:
        // 2 sources

        {
            var11_8 = 0;
        }
        return (boolean)var11_8;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) {
        return Sniffer.sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean bl2) {
        return Sniffer.sniffInternal(extractorInput, false, bl2);
    }
}

