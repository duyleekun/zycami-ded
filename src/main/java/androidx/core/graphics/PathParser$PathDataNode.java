/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 */
package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;

public class PathParser$PathDataNode {
    public float[] mParams;
    public char mType;

    public PathParser$PathDataNode(char c10, float[] fArray) {
        this.mType = c10;
        this.mParams = fArray;
    }

    public PathParser$PathDataNode(PathParser$PathDataNode object) {
        int n10;
        this.mType = n10 = ((PathParser$PathDataNode)object).mType;
        object = ((PathParser$PathDataNode)object).mParams;
        n10 = ((Object)object).length;
        object = PathParser.copyOfRange((float[])object, 0, n10);
        this.mParams = (float[])object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void addCommand(Path var0, float[] var1_1, char var2_2, char var3_3, float[] var4_4) {
        block28: {
            var5_5 = var0;
            var6_6 = var3_3;
            var7_7 = var4_4;
            var8_8 = 0;
            var9_9 = 0.0f;
            var10_10 = var1_1[0];
            var11_11 = 1;
            var12_12 = var1_1[var11_11];
            var13_13 = 2;
            var14_14 = 2.8E-45f;
            var15_15 = var1_1[var13_13];
            var16_16 = 3;
            var17_17 = var1_1[var16_16];
            var18_18 = 4;
            var19_19 = var1_1[var18_18];
            var20_20 = 5;
            var21_21 = var1_1[var20_20];
            switch (var3_3) lbl-1000:
            // 2 sources

            {
                default: {
                    var22_22 = var13_13;
                    break block28;
                }
                case 90: 
                case 122: {
                    var0.close();
                    var0.moveTo(var19_19, var21_21);
                    var10_10 = var19_19;
                    var15_15 = var19_19;
                    var12_12 = var21_21;
                    var17_17 = var21_21;
                    ** GOTO lbl-1000
                }
                case 81: 
                case 83: 
                case 113: 
                case 115: {
                    var22_22 = var18_18;
                    break block28;
                }
                case 72: 
                case 86: 
                case 104: 
                case 118: {
                    var22_22 = var11_11;
                    break block28;
                }
                case 67: 
                case 99: {
                    var23_23 = 6;
                    var24_24 = 8.4E-45f;
                    break;
                }
                case 65: 
                case 97: {
                    var23_23 = 7;
                    var24_24 = 9.8E-45f;
                }
            }
            var22_22 = var23_23;
        }
        var25_25 = var10_10;
        var26_26 = var12_12;
        var27_27 = var19_19;
        var28_28 = var21_21;
        var29_29 = 0;
        var30_30 = 0.0f;
        var31_31 = var2_2;
        while (var29_29 < (var32_32 = var7_7.length)) {
            block27: {
                block54: {
                    block29: {
                        block30: {
                            block31: {
                                block32: {
                                    block33: {
                                        block34: {
                                            block52: {
                                                block47: {
                                                    block35: {
                                                        block36: {
                                                            block37: {
                                                                block38: {
                                                                    block39: {
                                                                        block49: {
                                                                            block53: {
                                                                                block40: {
                                                                                    block51: {
                                                                                        block50: {
                                                                                            block41: {
                                                                                                block42: {
                                                                                                    block43: {
                                                                                                        block48: {
                                                                                                            block44: {
                                                                                                                block45: {
                                                                                                                    block46: {
                                                                                                                        var32_32 = 65;
                                                                                                                        var12_12 = 9.1E-44f;
                                                                                                                        if (var6_6 == var32_32) break block29;
                                                                                                                        var32_32 = 67;
                                                                                                                        var12_12 = 9.4E-44f;
                                                                                                                        if (var6_6 == var32_32) break block30;
                                                                                                                        var33_33 = 72;
                                                                                                                        var21_21 = 1.01E-43f;
                                                                                                                        if (var6_6 == var33_33) break block31;
                                                                                                                        var33_33 = 81;
                                                                                                                        var21_21 = 1.14E-43f;
                                                                                                                        if (var6_6 == var33_33) break block32;
                                                                                                                        var23_23 = 86;
                                                                                                                        var24_24 = 1.2E-43f;
                                                                                                                        if (var6_6 == var23_23) break block33;
                                                                                                                        var23_23 = 97;
                                                                                                                        var24_24 = 1.36E-43f;
                                                                                                                        if (var6_6 == var23_23) break block34;
                                                                                                                        var23_23 = 99;
                                                                                                                        var24_24 = 1.39E-43f;
                                                                                                                        if (var6_6 == var23_23) break block35;
                                                                                                                        var13_13 = 104;
                                                                                                                        var14_14 = 1.46E-43f;
                                                                                                                        if (var6_6 == var13_13) break block36;
                                                                                                                        var13_13 = 113;
                                                                                                                        var14_14 = 1.58E-43f;
                                                                                                                        if (var6_6 == var13_13) break block37;
                                                                                                                        var11_11 = 118;
                                                                                                                        if (var6_6 == var11_11) break block38;
                                                                                                                        var11_11 = 76;
                                                                                                                        if (var6_6 == var11_11) break block39;
                                                                                                                        var11_11 = 77;
                                                                                                                        if (var6_6 == var11_11) break block40;
                                                                                                                        var11_11 = 115;
                                                                                                                        var8_8 = 83;
                                                                                                                        var9_9 = 1.16E-43f;
                                                                                                                        var34_34 = 0x40000000;
                                                                                                                        var35_35 = 2.0f;
                                                                                                                        if (var6_6 == var8_8) break block41;
                                                                                                                        var36_36 = 116;
                                                                                                                        var19_19 = 1.63E-43f;
                                                                                                                        var8_8 = 84;
                                                                                                                        var9_9 = 1.18E-43f;
                                                                                                                        if (var6_6 == var8_8) break block42;
                                                                                                                        var32_32 = 108;
                                                                                                                        var12_12 = 1.51E-43f;
                                                                                                                        if (var6_6 == var32_32) break block43;
                                                                                                                        var32_32 = 109;
                                                                                                                        var12_12 = 1.53E-43f;
                                                                                                                        if (var6_6 == var32_32) break block44;
                                                                                                                        if (var6_6 == var11_11) break block45;
                                                                                                                        if (var6_6 == var36_36) break block46;
lbl105:
                                                                                                                        // 7 sources

                                                                                                                        while (true) {
                                                                                                                            var37_37 = var29_29;
                                                                                                                            break block27;
                                                                                                                            break;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (var31_31 != var13_13 && var31_31 != var36_36 && var31_31 != var33_33 && var31_31 != var8_8) {
                                                                                                                        var31_31 = 0;
                                                                                                                        var10_10 = 0.0f;
                                                                                                                        var36_36 = 0;
                                                                                                                        var19_19 = 0.0f;
                                                                                                                    } else {
                                                                                                                        var19_19 = var25_25 - var15_15;
                                                                                                                        var10_10 = var26_26 - var17_17;
                                                                                                                    }
                                                                                                                    var32_32 = var29_29 + 0;
                                                                                                                    var15_15 = var7_7[var32_32];
                                                                                                                    var38_38 = var29_29 + 1;
                                                                                                                    var21_21 = var7_7[var38_38];
                                                                                                                    var5_5.rQuadTo(var19_19, var10_10, var15_15, var21_21);
                                                                                                                    var12_12 = var7_7[var32_32];
                                                                                                                    var25_25 += var12_12;
                                                                                                                    var12_12 = var7_7[var38_38];
                                                                                                                    var17_17 = var10_10 += (var26_26 += var12_12);
                                                                                                                    var15_15 = var19_19 += var25_25;
                                                                                                                    ** GOTO lbl105
                                                                                                                }
                                                                                                                if (var31_31 == var23_23 || var31_31 == var11_11) ** GOTO lbl-1000
                                                                                                                var32_32 = 67;
                                                                                                                var12_12 = 9.4E-44f;
                                                                                                                if (var31_31 == var32_32) ** GOTO lbl-1000
                                                                                                                var32_32 = 83;
                                                                                                                var12_12 = 1.16E-43f;
                                                                                                                if (var31_31 != var32_32) {
                                                                                                                    var32_32 = 0;
                                                                                                                    var12_12 = 0.0f;
                                                                                                                    var39_39 = 0;
                                                                                                                    var15_15 = 0.0f;
                                                                                                                } else lbl-1000:
                                                                                                                // 3 sources

                                                                                                                {
                                                                                                                    var10_10 = var25_25 - var15_15;
                                                                                                                    var15_15 = var26_26 - var17_17;
                                                                                                                    var12_12 = var10_10;
                                                                                                                }
                                                                                                                var8_8 = var29_29 + 0;
                                                                                                                var17_17 = var7_7[var8_8];
                                                                                                                var11_11 = var29_29 + 1;
                                                                                                                var19_19 = var7_7[var11_11];
                                                                                                                var13_13 = var29_29 + 2;
                                                                                                                var21_21 = var7_7[var13_13];
                                                                                                                var34_34 = var29_29 + 3;
                                                                                                                var24_24 = var7_7[var34_34];
                                                                                                                var0.rCubicTo(var12_12, var15_15, var17_17, var19_19, var21_21, var24_24);
                                                                                                                var10_10 = var7_7[var8_8] + var25_25;
                                                                                                                var12_12 = var7_7[var11_11] + var26_26;
                                                                                                                var15_15 = var7_7[var13_13];
                                                                                                                var25_25 += var15_15;
                                                                                                                var15_15 = var7_7[var34_34];
                                                                                                                break block47;
                                                                                                            }
                                                                                                            var31_31 = var29_29 + 0;
                                                                                                            var12_12 = var7_7[var31_31];
                                                                                                            var25_25 += var12_12;
                                                                                                            var32_32 = var29_29 + 1;
                                                                                                            var19_19 = var7_7[var32_32];
                                                                                                            var26_26 += var19_19;
                                                                                                            if (var29_29 <= 0) break block48;
                                                                                                            var10_10 = var7_7[var31_31];
                                                                                                            var12_12 = var7_7[var32_32];
                                                                                                            var5_5.rLineTo(var10_10, var12_12);
                                                                                                            ** GOTO lbl105
                                                                                                        }
                                                                                                        var10_10 = var7_7[var31_31];
                                                                                                        var12_12 = var7_7[var32_32];
                                                                                                        var5_5.rMoveTo(var10_10, var12_12);
                                                                                                        break block49;
                                                                                                    }
                                                                                                    var31_31 = var29_29 + 0;
                                                                                                    var12_12 = var7_7[var31_31];
                                                                                                    var36_36 = var29_29 + 1;
                                                                                                    var21_21 = var7_7[var36_36];
                                                                                                    var5_5.rLineTo(var12_12, var21_21);
                                                                                                    var10_10 = var7_7[var31_31];
                                                                                                    var25_25 += var10_10;
                                                                                                    var10_10 = var7_7[var36_36];
lbl185:
                                                                                                    // 2 sources

                                                                                                    while (true) {
                                                                                                        var26_26 += var10_10;
                                                                                                        ** GOTO lbl105
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                if (var31_31 == var13_13 || var31_31 == var36_36 || var31_31 == var33_33 || var31_31 == var8_8) {
                                                                                                    var25_25 = var25_25 * var35_35 - var15_15;
                                                                                                    var26_26 = var26_26 * var35_35 - var17_17;
                                                                                                }
                                                                                                var31_31 = var29_29 + 0;
                                                                                                var12_12 = var7_7[var31_31];
                                                                                                var39_39 = var29_29 + 1;
                                                                                                var17_17 = var7_7[var39_39];
                                                                                                var5_5.quadTo(var25_25, var26_26, var12_12, var17_17);
                                                                                                var10_10 = var7_7[var31_31];
                                                                                                var12_12 = var7_7[var39_39];
                                                                                                var37_37 = var29_29;
                                                                                                var17_17 = var26_26;
                                                                                                var15_15 = var25_25;
                                                                                                var25_25 = var10_10;
                                                                                                var26_26 = var12_12;
                                                                                                break block27;
                                                                                            }
                                                                                            if (var31_31 == var23_23 || var31_31 == var11_11) break block50;
                                                                                            var32_32 = 67;
                                                                                            var12_12 = 9.4E-44f;
                                                                                            if (var31_31 == var32_32) break block50;
                                                                                            var32_32 = 83;
                                                                                            var12_12 = 1.16E-43f;
                                                                                            if (var31_31 != var32_32) break block51;
                                                                                        }
                                                                                        var25_25 = var25_25 * var35_35 - var15_15;
                                                                                        var26_26 = var26_26 * var35_35 - var17_17;
                                                                                    }
                                                                                    var15_15 = var26_26;
                                                                                    var12_12 = var25_25;
                                                                                    var40_40 = var29_29 + 0;
                                                                                    var17_17 = var7_7[var40_40];
                                                                                    var41_41 = var29_29 + 1;
                                                                                    var19_19 = var7_7[var41_41];
                                                                                    var8_8 = var29_29 + 2;
                                                                                    var21_21 = var7_7[var8_8];
                                                                                    var11_11 = var29_29 + 3;
                                                                                    var24_24 = var7_7[var11_11];
                                                                                    var0.cubicTo(var25_25, var26_26, var17_17, var19_19, var21_21, var24_24);
                                                                                    var10_10 = var7_7[var40_40];
                                                                                    var12_12 = var7_7[var41_41];
                                                                                    var25_25 = var7_7[var8_8];
                                                                                    var26_26 = var7_7[var11_11];
                                                                                    break block52;
                                                                                }
                                                                                var31_31 = var29_29 + 0;
                                                                                var25_25 = var7_7[var31_31];
                                                                                var32_32 = var29_29 + 1;
                                                                                var26_26 = var7_7[var32_32];
                                                                                if (var29_29 <= 0) break block53;
                                                                                var10_10 = var7_7[var31_31];
                                                                                var12_12 = var7_7[var32_32];
                                                                                var5_5.lineTo(var10_10, var12_12);
                                                                                ** GOTO lbl105
                                                                            }
                                                                            var10_10 = var7_7[var31_31];
                                                                            var12_12 = var7_7[var32_32];
                                                                            var5_5.moveTo(var10_10, var12_12);
                                                                        }
                                                                        var37_37 = var29_29;
                                                                        var28_28 = var26_26;
                                                                        var27_27 = var25_25;
                                                                        break block27;
                                                                    }
                                                                    var31_31 = var29_29 + 0;
                                                                    var12_12 = var7_7[var31_31];
                                                                    var36_36 = var29_29 + 1;
                                                                    var21_21 = var7_7[var36_36];
                                                                    var5_5.lineTo(var12_12, var21_21);
                                                                    var25_25 = var7_7[var31_31];
                                                                    var26_26 = var7_7[var36_36];
                                                                    ** GOTO lbl105
                                                                }
                                                                var31_31 = var29_29 + 0;
                                                                var12_12 = var7_7[var31_31];
                                                                var36_36 = 0;
                                                                var19_19 = 0.0f;
                                                                var5_5.rLineTo(0.0f, var12_12);
                                                                var10_10 = var7_7[var31_31];
                                                                ** continue;
                                                            }
                                                            var31_31 = var29_29 + 0;
                                                            var12_12 = var7_7[var31_31];
                                                            var39_39 = var29_29 + 1;
                                                            var17_17 = var7_7[var39_39];
                                                            var36_36 = var29_29 + 2;
                                                            var21_21 = var7_7[var36_36];
                                                            var23_23 = var29_29 + 3;
                                                            var9_9 = var7_7[var23_23];
                                                            var5_5.rQuadTo(var12_12, var17_17, var21_21, var9_9);
                                                            var10_10 = var7_7[var31_31] + var25_25;
                                                            var12_12 = var7_7[var39_39] + var26_26;
                                                            var15_15 = var7_7[var36_36];
                                                            var25_25 += var15_15;
                                                            var15_15 = var7_7[var23_23];
                                                            break block47;
                                                        }
                                                        var31_31 = var29_29 + 0;
                                                        var12_12 = var7_7[var31_31];
                                                        var36_36 = 0;
                                                        var19_19 = 0.0f;
                                                        var5_5.rLineTo(var12_12, 0.0f);
                                                        var10_10 = var7_7[var31_31];
                                                        var25_25 += var10_10;
                                                        ** GOTO lbl105
                                                    }
                                                    var31_31 = var29_29 + 0;
                                                    var12_12 = var7_7[var31_31];
                                                    var31_31 = var29_29 + 1;
                                                    var15_15 = var7_7[var31_31];
                                                    var8_8 = var29_29 + 2;
                                                    var17_17 = var7_7[var8_8];
                                                    var11_11 = var29_29 + 3;
                                                    var19_19 = var7_7[var11_11];
                                                    var13_13 = var29_29 + 4;
                                                    var21_21 = var7_7[var13_13];
                                                    var34_34 = var29_29 + 5;
                                                    var24_24 = var7_7[var34_34];
                                                    var0.rCubicTo(var12_12, var15_15, var17_17, var19_19, var21_21, var24_24);
                                                    var10_10 = var7_7[var8_8] + var25_25;
                                                    var12_12 = var7_7[var11_11] + var26_26;
                                                    var15_15 = var7_7[var13_13];
                                                    var25_25 += var15_15;
                                                    var15_15 = var7_7[var34_34];
                                                }
                                                var26_26 += var15_15;
                                            }
                                            var15_15 = var10_10;
                                            var17_17 = var12_12;
                                            ** continue;
                                        }
                                        var8_8 = var29_29 + 5;
                                        var17_17 = var7_7[var8_8] + var25_25;
                                        var11_11 = var29_29 + 6;
                                        var19_19 = var7_7[var11_11] + var26_26;
                                        var31_31 = var29_29 + 0;
                                        var21_21 = var7_7[var31_31];
                                        var31_31 = var29_29 + 1;
                                        var24_24 = var7_7[var31_31];
                                        var31_31 = var29_29 + 2;
                                        var14_14 = var7_7[var31_31];
                                        var31_31 = var29_29 + 3;
                                        var10_10 = var7_7[var31_31];
                                        var32_32 = 0;
                                        var12_12 = 0.0f;
                                        cfr_temp_0 = var10_10 - 0.0f;
                                        var31_31 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                        if (var31_31 != 0) {
                                            var34_34 = 1;
                                            var35_35 = 1.4E-45f;
                                        } else {
                                            var34_34 = 0;
                                            var35_35 = 0.0f;
                                        }
                                        var31_31 = var29_29 + 4;
                                        var10_10 = var7_7[var31_31];
                                        cfr_temp_1 = var10_10 - 0.0f;
                                        var31_31 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                                        if (var31_31 != 0) {
                                            var42_42 = true;
                                            var43_43 = 1.4E-45f;
                                        } else {
                                            var42_42 = false;
                                            var43_43 = 0.0f;
                                        }
                                        var12_12 = var25_25;
                                        var15_15 = var26_26;
                                        var37_37 = var29_29;
                                        var30_30 = var14_14;
                                        var14_14 = var26_26;
                                        var40_40 = var34_34;
                                        var26_26 = var35_35;
                                        var44_44 = var25_25;
                                        var41_41 = var42_42;
                                        var25_25 = var43_43;
                                        PathParser$PathDataNode.drawArc(var0, var12_12, var15_15, var17_17, var19_19, var21_21, var24_24, var30_30, (boolean)var34_34, var42_42);
                                        var10_10 = var7_7[var8_8];
                                        var25_25 = var12_12 + var10_10;
                                        var10_10 = var7_7[var11_11];
                                        var26_26 = var15_15 + var10_10;
                                        break block54;
                                    }
                                    var37_37 = var29_29;
                                    var44_44 = var25_25;
                                    var10_10 = var7_7[var29_29 += 0];
                                    var5_5.lineTo(var25_25, var10_10);
                                    var26_26 = var7_7[var29_29];
                                    break block27;
                                }
                                var37_37 = var29_29;
                                var10_10 = var7_7[var29_29 += 0];
                                var32_32 = var37_37 + 1;
                                var15_15 = var7_7[var32_32];
                                var38_38 = var37_37 + 2;
                                var19_19 = var7_7[var38_38];
                                var33_33 = var37_37 + 3;
                                var24_24 = var7_7[var33_33];
                                var5_5.quadTo(var10_10, var15_15, var19_19, var24_24);
                                var10_10 = var7_7[var29_29];
                                var12_12 = var7_7[var32_32];
                                var25_25 = var7_7[var38_38];
                                var26_26 = var7_7[var33_33];
                                var15_15 = var10_10;
                                var17_17 = var12_12;
                                break block27;
                            }
                            var37_37 = var29_29;
                            var14_14 = var26_26;
                            var10_10 = var7_7[var29_29 += 0];
                            var5_5.lineTo(var10_10, var26_26);
                            var25_25 = var7_7[var29_29];
                            break block27;
                        }
                        var37_37 = var29_29;
                        var12_12 = var7_7[var29_29 += 0];
                        var29_29 = var37_37 + 1;
                        var15_15 = var7_7[var29_29];
                        var29_29 = var37_37 + 2;
                        var17_17 = var7_7[var29_29];
                        var40_40 = var37_37 + 3;
                        var19_19 = var7_7[var40_40];
                        var41_41 = var37_37 + 4;
                        var21_21 = var7_7[var41_41];
                        var6_6 = var37_37 + 5;
                        var24_24 = var7_7[var6_6];
                        var0.cubicTo(var12_12, var15_15, var17_17, var19_19, var21_21, var24_24);
                        var25_25 = var7_7[var41_41];
                        var10_10 = var7_7[var6_6];
                        var12_12 = var7_7[var29_29];
                        var15_15 = var7_7[var40_40];
                        var26_26 = var10_10;
                        var17_17 = var15_15;
                        var15_15 = var12_12;
                        break block27;
                    }
                    var37_37 = var29_29;
                    var14_14 = var26_26;
                    var44_44 = var25_25;
                    var8_8 = var29_29 + 5;
                    var17_17 = var7_7[var8_8];
                    var11_11 = var29_29 + 6;
                    var19_19 = var7_7[var11_11];
                    var21_21 = var7_7[var29_29 += 0];
                    var29_29 = var37_37 + 1;
                    var24_24 = var7_7[var29_29];
                    var29_29 = var37_37 + 2;
                    var30_30 = var7_7[var29_29];
                    var31_31 = var37_37 + 3;
                    var10_10 = var7_7[var31_31];
                    var32_32 = 0;
                    var12_12 = 0.0f;
                    cfr_temp_2 = var10_10 - 0.0f;
                    var31_31 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1));
                    if (var31_31 != 0) {
                        var40_40 = 1;
                        var26_26 = 1.4E-45f;
                    } else {
                        var40_40 = 0;
                        var26_26 = 0.0f;
                    }
                    var31_31 = var37_37 + 4;
                    var10_10 = var7_7[var31_31];
                    cfr_temp_3 = var10_10 - 0.0f;
                    var31_31 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
                    if (var31_31 != 0) {
                        var41_41 = true;
                        var25_25 = 1.4E-45f;
                    } else {
                        var41_41 = false;
                        var25_25 = 0.0f;
                    }
                    var12_12 = var44_44;
                    var15_15 = var14_14;
                    PathParser$PathDataNode.drawArc(var0, var44_44, var14_14, var17_17, var19_19, var21_21, var24_24, var30_30, (boolean)var40_40, var41_41);
                    var25_25 = var7_7[var8_8];
                    var26_26 = var7_7[var11_11];
                }
                var17_17 = var26_26;
                var15_15 = var25_25;
            }
            var29_29 = var37_37 + var22_22;
            var31_31 = var3_3;
            var6_6 = var3_3;
            var8_8 = 0;
            var9_9 = 0.0f;
            var11_11 = 1;
            var13_13 = 2;
            var14_14 = 2.8E-45f;
        }
        var14_14 = var26_26;
        var44_44 = var25_25;
        var1_1[0] = var25_25;
        var1_1[1] = var26_26;
        var1_1[2] = var15_15;
        var1_1[var16_16] = var17_17;
        var1_1[var18_18] = var27_27;
        var1_1[var20_20] = var28_28;
    }

    private static void arcToBezier(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
        double d19 = d12;
        double d20 = 4.0;
        double d21 = d18 * d20;
        double d22 = Math.PI;
        d21 = Math.ceil(Math.abs(d21 / d22));
        int n10 = (int)d21;
        double d23 = Math.cos(d16);
        double d24 = Math.sin(d16);
        double d25 = Math.cos(d17);
        double d26 = Math.sin(d17);
        double d27 = -d12;
        double d28 = d27 * d23;
        double d29 = d28 * d26;
        double d30 = d13 * d24;
        double d31 = d30 * d25;
        d29 -= d31;
        d26 *= (d27 *= d24);
        d31 = d13 * d23;
        d25 = n10;
        d25 = d18 / d25;
        double d32 = d26 += (d25 *= d31);
        double d33 = d29;
        d26 = d14;
        d29 = d15;
        double d34 = d17;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d35 = d34 + d25;
            double d36 = Math.sin(d35);
            double d37 = Math.cos(d35);
            double d38 = d19 * d23 * d37;
            d38 = d10 + d38;
            double d39 = d30 * d36;
            double d40 = d38 - d39;
            d38 = d19 * d24 * d37;
            d38 = d11 + d38;
            d39 = d31 * d36;
            d19 = d38 + d39;
            d38 = d28 * d36;
            d39 = d30 * d37;
            d38 -= d39;
            d36 *= d27;
            d34 = d35 - d34;
            d37 = Math.tan(d34 / 2.0);
            d34 = Math.sin(d34);
            d39 = 3.0;
            double d41 = d37 * d39 * d37;
            double d42 = 4.0;
            d37 = Math.sqrt(d41 + d42);
            d41 = 1.0;
            d34 = d34 * (d37 -= d41) / d39;
            d26 += (d33 *= d34);
            d33 = d23;
            d23 = d29 + (d32 *= d34);
            d29 = d34 * d38;
            d16 = d24;
            d24 = d40 - d29;
            d13 = d25;
            d25 = d19 - (d34 *= (d36 += (d37 *= d31)));
            d29 = d27;
            path.rLineTo(0.0f, 0.0f);
            float f10 = (float)d26;
            float f11 = (float)d23;
            float f12 = (float)d24;
            float f13 = (float)d25;
            float f14 = (float)d40;
            float f15 = (float)d19;
            path.cubicTo(f10, f11, f12, f13, f14, f15);
            d25 = d13;
            d24 = d16;
            d26 = d40;
            d23 = d33;
            d34 = d35;
            d32 = d36;
            d33 = d38;
            d29 = d19;
            d19 = d12;
        }
    }

    private static void drawArc(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean bl2, boolean bl3) {
        boolean bl4;
        float f17 = f10;
        double d10 = Math.toRadians(f16);
        double d11 = Math.cos(d10);
        double d12 = Math.sin(d10);
        double d13 = f10;
        double d14 = d13 * d11;
        float f18 = f11;
        double d15 = d13;
        d13 = f11;
        double d16 = d13 * d12;
        d14 += d16;
        double d17 = f14;
        d14 /= d17;
        float f19 = -f10;
        double d18 = (double)f19 * d12;
        d16 = d13 * d11;
        d18 += d16;
        d16 = d13;
        d13 = f15;
        double d19 = (double)f12 * d11;
        float f20 = f13;
        double d20 = d18 /= d13;
        d18 = f13;
        double d21 = d18 * d12;
        d19 = (d19 + d21) / d17;
        f20 = -f12;
        d21 = d17;
        d17 = (double)f20 * d12;
        d17 = (d17 + (d18 *= d11)) / d13;
        d18 = d14 - d19;
        double d22 = d20 - d17;
        double d23 = d14 + d19;
        double d24 = 2.0;
        d23 /= d24;
        double d25 = (d20 + d17) / d24;
        d24 = d18 * d18;
        double d26 = d22 * d22;
        double d27 = d12;
        d12 = d24 + d26;
        d24 = 0.0;
        Object object = d12 == d24 ? 0 : (d12 > d24 ? 1 : -1);
        String string2 = "PathParser";
        if (object == false) {
            Log.w((String)string2, (String)" Points are coincident");
            return;
        }
        d26 = 1.0 / d12;
        double d28 = 0.25;
        double d29 = (d26 -= d28) - d24;
        object = d29 == 0.0 ? 0 : (d29 < 0.0 ? -1 : 1);
        if (object < 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Points are too far apart ");
            charSequence.append(d12);
            charSequence = charSequence.toString();
            Log.w((String)string2, (String)charSequence);
            f17 = (float)(Math.sqrt(d12) / 1.99999);
            float f21 = f14 * f17;
            f18 = f15 * f17;
            f17 = f10;
            PathParser$PathDataNode.drawArc(path, f10, f11, f12, f13, f21, f18, f16, bl2, bl3);
            return;
        }
        d12 = Math.sqrt(d26);
        d18 *= d12;
        d12 *= d22;
        boolean bl5 = bl3;
        if (bl2 == bl3) {
            d23 -= d12;
            d25 += d18;
        } else {
            d23 += d12;
            d25 -= d18;
        }
        d18 = d20 - d25;
        d12 = d14 - d23;
        d20 = Math.atan2(d18, d12);
        double d30 = Math.atan2(d17 -= d25, d19 -= d23) - d20;
        double d31 = d30 == d24 ? 0 : (d30 > d24 ? 1 : -1);
        if (d31 >= 0) {
            bl4 = true;
            f18 = Float.MIN_VALUE;
        } else {
            bl4 = false;
            f18 = 0.0f;
        }
        if (bl5 != bl4) {
            d17 = Math.PI * 2;
            d30 = d31 > 0 ? (d30 -= d17) : (d30 += d17);
        }
        double d32 = (d23 *= d21) * d11;
        d12 = (d25 *= d13) * d27;
        double d33 = d32 - d12;
        d32 = d21;
        double d34 = (d23 *= d27) + (d25 *= d11);
        d32 = d15;
        d11 = d16;
        d14 = d15;
        d15 = d16;
        d16 = d20;
        d20 = d30;
        PathParser$PathDataNode.arcToBezier(path, d33, d34, d21, d13, d32, d11, d10, d16, d30);
    }

    public static void nodesToPath(PathParser$PathDataNode[] pathParser$PathDataNodeArray, Path path) {
        int n10;
        int n11 = 6;
        float[] fArray = new float[n11];
        char c10 = 'm';
        for (int i10 = 0; i10 < (n10 = pathParser$PathDataNodeArray.length); ++i10) {
            PathParser$PathDataNode pathParser$PathDataNode = pathParser$PathDataNodeArray[i10];
            n10 = pathParser$PathDataNode.mType;
            float[] fArray2 = pathParser$PathDataNodeArray[i10].mParams;
            PathParser$PathDataNode.addCommand(path, fArray, c10, (char)n10, fArray2);
            PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArray[i10];
            c10 = pathParser$PathDataNode2.mType;
        }
    }

    public void interpolatePathDataNode(PathParser$PathDataNode pathParser$PathDataNode, PathParser$PathDataNode pathParser$PathDataNode2, float f10) {
        float[] fArray;
        int n10;
        int n11;
        this.mType = n11 = pathParser$PathDataNode.mType;
        for (n11 = 0; n11 < (n10 = (fArray = pathParser$PathDataNode.mParams).length); ++n11) {
            float[] fArray2 = this.mParams;
            float f11 = fArray[n11];
            float f12 = 1.0f - f10;
            f11 *= f12;
            float[] fArray3 = pathParser$PathDataNode2.mParams;
            f12 = fArray3[n11] * f10;
            fArray2[n11] = f11 += f12;
        }
    }
}

