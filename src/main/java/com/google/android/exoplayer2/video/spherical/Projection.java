/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.spherical.Projection$Mesh;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;

public final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Projection$Mesh leftMesh;
    public final Projection$Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    public Projection(Projection$Mesh projection$Mesh, int n10) {
        this(projection$Mesh, projection$Mesh, n10);
    }

    public Projection(Projection$Mesh projection$Mesh, Projection$Mesh projection$Mesh2, int n10) {
        boolean bl2;
        this.leftMesh = projection$Mesh;
        this.rightMesh = projection$Mesh2;
        this.stereoMode = n10;
        if (projection$Mesh == projection$Mesh2) {
            bl2 = true;
        } else {
            bl2 = false;
            projection$Mesh = null;
        }
        this.singleMesh = bl2;
    }

    /*
     * Unable to fully structure code
     */
    public static Projection createEquirectangular(float var0, int var1_1, int var2_2, float var3_3, float var4_4, int var5_5) {
        var6_6 = var0;
        var7_7 = var1_1;
        var8_8 = var2_2;
        var9_9 = var3_3;
        var10_10 = var4_4;
        var11_11 = 0;
        var12_12 = 0.0f;
        cfr_temp_0 = var0 - 0.0f;
        var13_13 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
        var14_14 = 1;
        var15_15 = 1.4E-45f;
        if (var13_13 > 0) {
            var13_13 = var14_14;
            var16_16 = var15_15;
        } else {
            var13_13 = (float)false;
            var16_16 = 0.0f;
        }
        Assertions.checkArgument((boolean)var13_13);
        if (var7_7 >= var14_14) {
            var13_13 = var14_14;
            var16_16 = var15_15;
        } else {
            var13_13 = (float)false;
            var16_16 = 0.0f;
        }
        Assertions.checkArgument((boolean)var13_13);
        if (var8_8 >= var14_14) {
            var13_13 = var14_14;
            var16_16 = var15_15;
        } else {
            var13_13 = (float)false;
            var16_16 = 0.0f;
        }
        Assertions.checkArgument((boolean)var13_13);
        cfr_temp_1 = var9_9 - 0.0f;
        var13_13 = cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1);
        if (var13_13 > 0 && (var13_13 = (cfr_temp_2 = var9_9 - (var16_16 = 180.0f)) == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1)) <= 0) {
            var13_13 = var14_14;
            var16_16 = var15_15;
        } else {
            var13_13 = (float)false;
            var16_16 = 0.0f;
        }
        Assertions.checkArgument((boolean)var13_13);
        cfr_temp_3 = var10_10 - 0.0f;
        var11_11 = cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1);
        if (var11_11 > 0 && (var11_11 = (int)((cfr_temp_4 = var10_10 - (var12_12 = 360.0f)) == 0.0f ? 0 : (cfr_temp_4 < 0.0f ? -1 : 1))) <= 0) {
            var11_11 = var14_14;
            var12_12 = var15_15;
        } else {
            var11_11 = 0;
            var12_12 = 0.0f;
        }
        Assertions.checkArgument((boolean)var11_11);
        var17_17 = Math.toRadians(var9_9);
        var9_9 = (float)var17_17;
        var19_18 = Math.toRadians(var10_10);
        var10_10 = (float)var19_18;
        var12_12 = var7_7;
        var12_12 = var9_9 / var12_12;
        var16_16 = var8_8;
        var16_16 = var10_10 / var16_16;
        var21_19 = var8_8 + 1;
        var22_20 = var21_19 * 2;
        var23_21 = 2;
        var24_22 = 2.8E-45f;
        var22_20 = (var22_20 + var23_21) * var7_7;
        var25_23 = var22_20 * 3;
        var26_24 = new float[var25_23];
        var27_25 = new float[var22_20 *= var23_21];
        var28_26 = 0;
        var29_27 = 0.0f;
        var30_28 = 0;
        var31_29 = 0;
        while (var28_26 < var7_7) {
            var32_30 = (float)var28_26 * var12_12;
            var33_31 = 2.0f;
            var34_32 = var9_9 / var33_31;
            var32_30 -= var34_32;
            var14_14 = var28_26 + 1;
            var24_22 = (float)var14_14 * var12_12 - var34_32;
            var7_7 = 0;
            var35_33 = 0.0f;
            while (var7_7 < var21_19) {
                var4_4 = var32_30;
                var36_34 = var14_14;
                var37_35 = 0;
                var32_30 = 0.0f;
                var14_14 = 2;
                var15_15 = 2.8E-45f;
                while (var37_35 < var14_14) {
                    block18: {
                        if (var37_35 == 0) {
                            var15_15 = var4_4;
                            var38_36 = var21_19;
                        } else {
                            var38_36 = var21_19;
                            var15_15 = var24_22;
                        }
                        var39_37 = (float)var7_7 * var16_16;
                        var40_38 = var39_37 + 3.1415927f;
                        var41_39 = var10_10 / var33_31;
                        var42_40 = var16_16;
                        var16_16 = var40_38 - var41_39;
                        var43_41 = var30_28 + 1;
                        var44_42 = var7_7;
                        var45_43 = var6_6;
                        var47_44 = var12_12;
                        var17_17 = var16_16;
                        var48_45 = Math.sin(var17_17) * var45_43;
                        var50_46 = var37_35;
                        var51_47 = var15_15;
                        var53_48 = Math.cos(var51_47);
                        var55_49 = var27_25;
                        var56_50 = var24_22;
                        var57_51 = var48_45 * var53_48;
                        var26_24[var30_28] = var59_52 = -((float)var57_51);
                        var22_20 = var43_41 + 1;
                        var48_45 = Math.sin(var51_47);
                        var23_21 = var28_26;
                        var60_53 = var45_43 * var48_45;
                        var26_24[var43_41] = var29_27 = (float)var60_53;
                        var28_26 = var22_20 + 1;
                        var17_17 = Math.cos(var17_17);
                        var45_43 *= var17_17;
                        var17_17 = Math.cos(var51_47);
                        var26_24[var22_20] = var35_33 = (float)(var45_43 *= var17_17);
                        var7_7 = var31_29 + 1;
                        var27_25[var31_29] = var39_37 /= var10_10;
                        var8_8 = var7_7 + 1;
                        var11_11 = var23_21 + var37_35;
                        var27_25[var7_7] = var12_12 = (float)var11_11 * var47_44 / var9_9;
                        if (var44_42 != 0 || var37_35 != 0) break block18;
                        var7_7 = var2_2;
                        var11_11 = var44_42;
                        var13_13 = var37_35;
                        ** GOTO lbl-1000
                    }
                    var7_7 = var2_2;
                    var11_11 = var44_42;
                    var13_13 = var50_46;
                    if (var44_42 == var2_2) {
                        var37_35 = 1;
                        var32_30 = 1.4E-45f;
                        ** if (var50_46 != var37_35) goto lbl-1000
                    }
                    ** GOTO lbl-1000
lbl-1000:
                    // 2 sources

                    {
                        var37_35 = var28_26 + -3;
                        var14_14 = 3;
                        var15_15 = 4.2E-45f;
                        System.arraycopy(var26_24, var37_35, var26_24, var28_26, var14_14);
                        var28_26 += 3;
                        var37_35 = var8_8 + -2;
                        var62_54 = var55_49;
                        var21_19 = 2;
                        var39_37 = 2.8E-45f;
                        System.arraycopy(var55_49, var37_35, var55_49, var8_8, var21_19);
                        var8_8 += 2;
                        ** GOTO lbl156
                    }
lbl-1000:
                    // 2 sources

                    {
                        var62_54 = var55_49;
                        var21_19 = 2;
                        var39_37 = 2.8E-45f;
                    }
lbl156:
                    // 2 sources

                    var31_29 = var8_8;
                    var30_28 = var28_26;
                    var37_35 = (int)(var13_13 + true);
                    var8_8 = var7_7;
                    var7_7 = var11_11;
                    var27_25 = var62_54;
                    var14_14 = var21_19;
                    var15_15 = var39_37;
                    var28_26 = var23_21;
                    var21_19 = var38_36;
                    var16_16 = var42_40;
                    var12_12 = var47_44;
                    var24_22 = var56_50;
                }
                var47_44 = var12_12;
                var42_40 = var16_16;
                var38_36 = var21_19;
                var56_50 = var24_22;
                var23_21 = var28_26;
                var11_11 = var7_7;
                var7_7 = var8_8;
                var21_19 = var14_14;
                var39_37 = var15_15;
                var62_54 = var27_25;
                var8_8 = var11_11 + 1;
                var32_30 = var4_4;
                var14_14 = var36_34;
                var21_19 = var38_36;
                var63_55 = var8_8;
                var8_8 = var7_7;
                var7_7 = var63_55;
            }
            var36_34 = var14_14;
            var7_7 = var1_1;
            var28_26 = var14_14;
            var14_14 = 1;
            var15_15 = 1.4E-45f;
            var23_21 = 2;
            var24_22 = 2.8E-45f;
        }
        var62_54 = var27_25;
        var8_8 = 1;
        var64_56 = new Projection$SubMesh(0, var26_24, var27_25, var8_8);
        var67_59 = new Projection$SubMesh[var8_8];
        var67_59[0] = var64_56;
        var66_58 = new Projection$Mesh(var67_59);
        var65_57 = new Projection(var66_58, var5_5);
        return var65_57;
    }

    public static Projection createEquirectangular(int n10) {
        return Projection.createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, n10);
    }
}

