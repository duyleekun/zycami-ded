/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil$PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil$SpsData;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.nio.ByteBuffer;

public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES;
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE;
    private static final String TAG = "NalUnitUtil";
    private static int[] scratchEscapePositions;
    private static final Object scratchEscapePositionsLock;

    static {
        Object object;
        byte[] byArray = object = new byte[4];
        byte[] byArray2 = object;
        byArray[0] = 0;
        byArray2[1] = 0;
        byArray[2] = 0;
        byArray2[3] = 1;
        NAL_START_CODE = object;
        Object[] objectArray = object = (Object)new float[17];
        Object[] objectArray2 = object;
        objectArray[0] = (byte)1.0f;
        objectArray2[1] = (byte)1.0f;
        objectArray[2] = (byte)1.0909091f;
        objectArray2[3] = (byte)0.90909094f;
        objectArray[4] = (byte)1.4545455f;
        objectArray2[5] = (byte)1.2121212f;
        objectArray[6] = (byte)2.1818182f;
        objectArray2[7] = (byte)1.8181819f;
        objectArray[8] = (byte)2.909091f;
        objectArray2[9] = (byte)2.4242425f;
        objectArray[10] = (byte)1.6363636f;
        objectArray2[11] = (byte)1.3636364f;
        objectArray[12] = (byte)1.939394f;
        objectArray2[13] = (byte)1.6161616f;
        objectArray[14] = (byte)1.3333334f;
        objectArray2[15] = (byte)1.5f;
        objectArray2[16] = (byte)2.0f;
        ASPECT_RATIO_IDC_VALUES = object;
        object = new Object;
        object();
        scratchEscapePositionsLock = object;
        scratchEscapePositions = new int[10];
    }

    private NalUnitUtil() {
    }

    public static void clearPrefixFlags(boolean[] blArray) {
        blArray[0] = false;
        blArray[1] = false;
        blArray[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int n10;
        int n11 = byteBuffer.position();
        int n12 = 0;
        int n13 = 0;
        ByteBuffer byteBuffer2 = null;
        while ((n10 = n12 + 1) < n11) {
            int n14 = byteBuffer.get(n12) & 0xFF;
            int n15 = 3;
            if (n13 == n15) {
                int n16;
                int n17 = 1;
                if (n14 == n17 && (n17 = byteBuffer.get(n10) & 0x1F) == (n16 = 7)) {
                    byteBuffer2 = byteBuffer.duplicate();
                    byteBuffer2.position(n12 -= n15);
                    byteBuffer2.limit(n11);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBuffer2);
                    return;
                }
            } else if (n14 == 0) {
                ++n13;
            }
            if (n14 != 0) {
                n13 = 0;
                byteBuffer2 = null;
            }
            n12 = n10;
        }
        byteBuffer.clear();
    }

    /*
     * Unable to fully structure code
     */
    public static int findNalUnit(byte[] var0, int var1_1, int var2_2, boolean[] var3_3) {
        block19: {
            block14: {
                block17: {
                    block18: {
                        block15: {
                            block16: {
                                var4_4 = var2_2 - var1_1;
                                var5_5 = 0;
                                var6_6 = 1;
                                var7_7 = var4_4 >= 0 ? var6_6 : 0;
                                Assertions.checkState((boolean)var7_7);
                                if (var4_4 == 0) {
                                    return var2_2;
                                }
                                var7_7 = var3_3[0];
                                if (var7_7 != 0) {
                                    NalUnitUtil.clearPrefixFlags(var3_3);
                                    return var1_1 + -3;
                                }
                                var7_7 = 2;
                                if (var4_4 > var6_6 && (var8_8 = var3_3[var6_6]) != 0 && (var8_8 = var0[var1_1]) == var6_6) {
                                    NalUnitUtil.clearPrefixFlags(var3_3);
                                    return var1_1 - var7_7;
                                }
                                if (var4_4 > var7_7 && (var8_8 = var3_3[var7_7]) != 0 && (var8_8 = var0[var1_1]) == 0) {
                                    var8_8 = var1_1 + 1;
                                    if ((var8_8 = var0[var8_8]) == var6_6) {
                                        NalUnitUtil.clearPrefixFlags(var3_3);
                                        return var1_1 - var6_6;
                                    }
                                }
                                var8_8 = var2_2 + -1;
                                var1_1 += var7_7;
                                while (var1_1 < var8_8) {
                                    var9_9 = var0[var1_1] & 254;
                                    if (var9_9 == 0) {
                                        var9_9 = var1_1 + -2;
                                        var10_10 = var0[var9_9];
                                        if (var10_10 == 0) {
                                            var10_10 = var1_1 + -1;
                                            if ((var10_10 = var0[var10_10]) == 0 && (var10_10 = var0[var1_1]) == var6_6) {
                                                NalUnitUtil.clearPrefixFlags(var3_3);
                                                return var9_9;
                                            }
                                        }
                                        var1_1 += -2;
                                    }
                                    var1_1 += 3;
                                }
                                if (var4_4 <= var7_7) break block15;
                                var1_1 = var2_2 + -3;
                                if ((var1_1 = var0[var1_1]) != 0) break block16;
                                var1_1 = var2_2 + -2;
                                if ((var1_1 = var0[var1_1]) == 0 && (var1_1 = var0[var8_8]) == var6_6) break block17;
                            }
lbl42:
                            // 4 sources

                            while (true) {
                                var1_1 = 0;
                                break block14;
                                break;
                            }
                        }
                        if (var4_4 != var7_7) break block18;
                        var1_1 = var3_3[var7_7];
                        if (var1_1 == 0) ** GOTO lbl42
                        var1_1 = var2_2 + -2;
                        if ((var1_1 = var0[var1_1]) != 0 || (var1_1 = var0[var8_8]) != var6_6) ** GOTO lbl42
                        break block17;
                    }
                    var1_1 = var3_3[var6_6];
                    if (var1_1 != 0 && (var1_1 = var0[var8_8]) == var6_6) ** break;
                    ** while (true)
                }
                var1_1 = var6_6;
            }
            var3_3[0] = var1_1;
            if (var4_4 <= var6_6) break block19;
            var1_1 = var2_2 + -2;
            if ((var1_1 = var0[var1_1]) != 0 || (var1_1 = var0[var8_8]) != 0) ** GOTO lbl-1000
            ** GOTO lbl-1000
        }
        var1_1 = var3_3[var7_7];
        if (var1_1 != 0 && (var1_1 = var0[var8_8]) == 0) lbl-1000:
        // 2 sources

        {
            var1_1 = var6_6;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = 0;
        }
        var3_3[var6_6] = var1_1;
        var11_11 = var0[var8_8];
        if (var11_11 == 0) {
            var5_5 = var6_6;
        }
        var3_3[var7_7] = var5_5;
        return var2_2;
    }

    private static int findNextUnescapeIndex(byte[] byArray, int n10, int n11) {
        int n12;
        while (n10 < (n12 = n11 + -2)) {
            n12 = byArray[n10];
            if (n12 == 0) {
                n12 = n10 + 1;
                if ((n12 = byArray[n12]) == 0) {
                    n12 = n10 + 2;
                    int n13 = 3;
                    if ((n12 = byArray[n12]) == n13) {
                        return n10;
                    }
                }
            }
            ++n10;
        }
        return n11;
    }

    public static int getH265NalUnitType(byte[] byArray, int n10) {
        return (byArray[n10 += 3] & 0x7E) >> 1;
    }

    public static int getNalUnitType(byte[] byArray, int n10) {
        return byArray[n10 += 3] & 0x1F;
    }

    public static boolean isNalUnitSei(String string2, byte by2) {
        int n10;
        int n11;
        String string3 = "video/avc";
        int n12 = string3.equals(string2);
        int n13 = 1;
        if (!(n12 != 0 && (n12 = by2 & 0x1F) == (n11 = 6) || (n10 = (string3 = "video/hevc").equals(string2)) != 0 && (n10 = (by2 & 0x7E) >> n13) == (by2 = (byte)39))) {
            n13 = 0;
        }
        return n13 != 0;
    }

    public static NalUnitUtil$PpsData parsePpsNalUnit(byte[] byArray, int n10, int n11) {
        Object object = new ParsableNalUnitBitArray(byArray, n10, n11);
        ((ParsableNalUnitBitArray)object).skipBits(8);
        int n12 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        n10 = ((ParsableNalUnitBitArray)object).readUnsignedExpGolombCodedInt();
        ((ParsableNalUnitBitArray)object).skipBit();
        n11 = (int)(((ParsableNalUnitBitArray)object).readBit() ? 1 : 0);
        object = new NalUnitUtil$PpsData(n12, n10, n11 != 0);
        return object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static NalUnitUtil$SpsData parseSpsNalUnit(byte[] var0, int var1_1, int var2_2) {
        block18: {
            block17: {
                var4_4 = var1_1;
                var5_5 = var2_2;
                var3_3 = new ParsableNalUnitBitArray(var0, var1_1, var2_2);
                var6_6 = 8;
                var7_7 = 1.1E-44f;
                var3_3.skipBits(var6_6);
                var5_5 = var3_3.readBits(var6_6);
                var8_8 = var3_3.readBits(var6_6);
                var9_9 = var3_3.readBits(var6_6);
                var10_10 = var3_3.readUnsignedExpGolombCodedInt();
                var4_4 = 3;
                var11_11 = 1;
                var12_12 = 1.4E-45f;
                var13_13 = 100;
                if (var5_5 != var13_13 && var5_5 != (var13_13 = 110) && var5_5 != (var13_13 = 122) && var5_5 != (var13_13 = 244) && var5_5 != (var13_13 = 44) && var5_5 != (var13_13 = 83) && var5_5 != (var13_13 = 86) && var5_5 != (var13_13 = 118) && var5_5 != (var13_13 = 128) && var5_5 != (var13_13 = 138)) {
                    var13_13 = var11_11;
                    var14_14 = 0;
                } else {
                    var13_13 = var3_3.readUnsignedExpGolombCodedInt();
                    var14_14 = var13_13 == var4_4 ? var3_3.readBit() : 0;
                    var3_3.readUnsignedExpGolombCodedInt();
                    var3_3.readUnsignedExpGolombCodedInt();
                    var3_3.skipBit();
                    var15_15 = var3_3.readBit();
                    if (var15_15 != 0) {
                        var15_15 = var13_13 != var4_4 ? var6_6 : 12;
                        for (var16_16 = 0; var16_16 < var15_15; ++var16_16) {
                            var17_17 = var3_3.readBit();
                            if (var17_17 == 0) continue;
                            var17_17 = 6;
                            var17_17 = var16_16 < var17_17 ? 16 : 64;
                            NalUnitUtil.skipScalingList((ParsableNalUnitBitArray)var3_3, var17_17);
                        }
                    }
                }
                var15_15 = var3_3.readUnsignedExpGolombCodedInt() + 4;
                var16_16 = var3_3.readUnsignedExpGolombCodedInt();
                if (var16_16 != 0) break block17;
                var17_17 = var3_3.readUnsignedExpGolombCodedInt() + 4;
                ** GOTO lbl59
            }
            if (var16_16 == var11_11) {
                var17_17 = (int)var3_3.readBit();
                var3_3.readSignedExpGolombCodedInt();
                var3_3.readSignedExpGolombCodedInt();
                var18_18 = var3_3.readUnsignedExpGolombCodedInt();
                var20_19 = 0;
                while ((var23_21 = (cfr_temp_0 = (var21_20 = (long)var20_19) - var18_18) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) < 0) {
                    var3_3.readUnsignedExpGolombCodedInt();
                    var20_19 += 1;
                }
                var20_19 = var17_17;
                var17_17 = 0;
            } else {
                var17_17 = 0;
lbl59:
                // 2 sources

                var20_19 = 0;
            }
            var3_3.readUnsignedExpGolombCodedInt();
            var3_3.skipBit();
            var6_6 = var3_3.readUnsignedExpGolombCodedInt() + var11_11;
            var4_4 = var3_3.readUnsignedExpGolombCodedInt() + var11_11;
            var24_22 = var3_3.readBit();
            var23_21 = (2 - var24_22) * var4_4;
            if (var24_22 == 0) {
                var3_3.skipBit();
            }
            var3_3.skipBit();
            var4_4 = 16;
            var6_6 *= var4_4;
            var23_21 *= var4_4;
            var4_4 = (int)var3_3.readBit();
            if (var4_4 != 0) {
                var4_4 = var3_3.readUnsignedExpGolombCodedInt();
                var25_23 = var3_3.readUnsignedExpGolombCodedInt();
                var26_24 = var3_3.readUnsignedExpGolombCodedInt();
                var27_25 = var3_3.readUnsignedExpGolombCodedInt();
                if (var13_13 == 0) {
                    var13_13 = 2 - var24_22;
                } else {
                    var28_26 = 2;
                    var29_27 = 2.8E-45f;
                    var11_11 = 3;
                    var12_12 = 4.2E-45f;
                    if (var13_13 == var11_11) {
                        var11_11 = 1;
                        var12_12 = 1.4E-45f;
                        var30_28 = 1;
                        var31_29 = 1.4E-45f;
                    } else {
                        var30_28 = var28_26;
                        var31_29 = var29_27;
                        var11_11 = 1;
                        var12_12 = 1.4E-45f;
                    }
                    if (var13_13 == var11_11) {
                        var11_11 = var28_26;
                        var12_12 = var29_27;
                    }
                    var13_13 = (2 - var24_22) * var11_11;
                    var11_11 = var30_28;
                    var12_12 = var31_29;
                }
                var4_4 = (var4_4 + var25_23) * var11_11;
                var6_6 -= var4_4;
                var26_24 = (var26_24 + var27_25) * var13_13;
                var23_21 -= var26_24;
            }
            var25_23 = var23_21;
            var23_21 = var6_6;
            var6_6 = 1065353216;
            var7_7 = 1.0f;
            var4_4 = (int)var3_3.readBit();
            if (var4_4 == 0 || (var4_4 = (int)var3_3.readBit()) == 0) ** GOTO lbl142
            var4_4 = var3_3.readBits(8);
            var11_11 = 255;
            var12_12 = 3.57E-43f;
            if (var4_4 != var11_11) break block18;
            var11_11 = 16;
            var12_12 = 2.24E-44f;
            var4_4 = var3_3.readBits(var11_11);
            var32_30 = var3_3.readBits(var11_11);
            if (var4_4 != 0 && var32_30 != 0) {
                var7_7 = var4_4;
                var33_32 = var32_30;
                var7_7 /= var33_32;
            }
            ** GOTO lbl142
        }
        var3_3 = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
        var11_11 = ((Object)var3_3).length;
        if (var4_4 < var11_11) {
            var33_33 = var3_3[var4_4];
            var12_12 = (float)var33_33;
        } else {
            var32_31 = 46;
            var33_34 = 6.4E-44f;
            var34_35 = new StringBuilder(var32_31);
            var34_35.append("Unexpected aspect_ratio_idc value: ");
            var34_35.append(var4_4);
            var3_3 = var34_35.toString();
            var35_36 = "NalUnitUtil";
            Log.w((String)var35_36, (String)var3_3);
lbl142:
            // 3 sources

            var12_12 = var7_7;
        }
        var35_36 = var3_3;
        var13_13 = var14_14;
        var14_14 = var24_22;
        var3_3 = new NalUnitUtil$SpsData(var5_5, var8_8, var9_9, var10_10, (int)var23_21, (int)var25_23, var12_12, (boolean)var13_13, (boolean)var24_22, var15_15, var16_16, var17_17, (boolean)var20_19);
        return var3_3;
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int n10) {
        int n11 = 8;
        int n12 = n11;
        for (int i10 = 0; i10 < n10; ++i10) {
            if (n11 != 0) {
                n11 = (parsableNalUnitBitArray.readSignedExpGolombCodedInt() + n12 + 256) % 256;
            }
            if (n11 == 0) continue;
            n12 = n11;
        }
    }

    /*
     * Exception decompiling
     */
    public static int unescapeStream(byte[] var0, int var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 7[TRYBLOCK] [8 : 132->135)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

