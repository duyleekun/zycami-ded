/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.ArcCurveFit$Arc;
import androidx.constraintlayout.motion.utils.CurveFit;

public class ArcCurveFit
extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    public ArcCurveFit$Arc[] mArcs;
    private final double[] mTime;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public ArcCurveFit(int[] var1_1, double[] var2_2, double[][] var3_3) {
        var4_4 = this;
        var5_5 = var2_2;
        super();
        this.mTime = var2_2;
        var6_6 = var2_2.length;
        var7_7 = 1;
        var8_8 = 1.4E-45f;
        var9_9 = new ArcCurveFit$Arc[var6_6 - var7_7];
        this.mArcs = var9_9;
        var6_6 = 0;
        var9_9 = null;
        var10_10 = 0;
        var11_11 = var7_7;
        var12_12 = var8_8;
        var13_13 = var7_7;
        var14_14 = var8_8;
        while (true) {
            block6: {
                block5: {
                    if (var10_10 >= (var16_16 = (var15_15 = var4_4.mArcs).length)) {
                        return;
                    }
                    var16_16 = var1_1[var10_10];
                    var17_17 = 3;
                    var18_18 = 4.2E-45f;
                    var19_19 = 2;
                    var20_20 = 2.8E-45f;
                    if (var16_16 == 0) break block5;
                    if (var16_16 == var7_7) ** GOTO lbl-1000
                    if (var16_16 == var19_19) ** GOTO lbl-1000
                    if (var16_16 == var17_17) {
                        ** if (var11_11 != var7_7) goto lbl-1000
                    }
                    break block6;
lbl-1000:
                    // 2 sources

                    {
                        var11_11 = var19_19;
                        var12_12 = var20_20;
                        ** GOTO lbl36
                    }
lbl-1000:
                    // 2 sources

                    {
                        var11_11 = var7_7;
                        var12_12 = var8_8;
                    }
lbl36:
                    // 2 sources

                    var13_13 = var11_11;
                    var14_14 = var12_12;
                    break block6;
                }
                var13_13 = var17_17;
                var14_14 = var18_18;
            }
            var22_22 = var5_5[var10_10];
            var24_23 = var10_10 + 1;
            var25_24 = var5_5[var24_23];
            var27_25 = var3_3[var10_10][0];
            var29_26 = var3_3[var10_10][var7_7];
            var31_27 = var3_3[var24_23][0];
            var33_28 = var3_3[var24_23][var7_7];
            var17_17 = var13_13;
            var18_18 = var14_14;
            var15_15[var10_10] = var21_21 = new ArcCurveFit$Arc(var13_13, var22_22, var25_24, var27_25, var29_26, var31_27, var33_28);
            var10_10 = var24_23;
        }
    }

    public double getPos(double d10, int n10) {
        ArcCurveFit$Arc arcCurveFit$Arc;
        Object object = this.mArcs;
        int n11 = 0;
        ArcCurveFit$Arc arcCurveFit$Arc2 = object[0];
        double d11 = arcCurveFit$Arc2.mTime1;
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object2 < 0) {
            arcCurveFit$Arc = object[0];
            d10 = arcCurveFit$Arc.mTime1;
        } else {
            object2 = ((ArcCurveFit$Arc[])object).length + -1;
            arcCurveFit$Arc2 = object[object2];
            d11 = arcCurveFit$Arc2.mTime2;
            double d13 = d10 - d11;
            object2 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object2 > 0) {
                int n12 = ((ArcCurveFit$Arc[])object).length + -1;
                arcCurveFit$Arc = object[n12];
                d10 = arcCurveFit$Arc.mTime2;
            }
        }
        while (n11 < (object2 = (Object)((ArcCurveFit$Arc[])(object = this.mArcs)).length)) {
            arcCurveFit$Arc2 = object[n11];
            d11 = arcCurveFit$Arc2.mTime2;
            double d14 = d10 - d11;
            object2 = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
            if (object2 <= 0) {
                arcCurveFit$Arc2 = object[n11];
                object2 = arcCurveFit$Arc2.linear;
                if (object2 != false) {
                    if (n10 == 0) {
                        return object[n11].getLinearX(d10);
                    }
                    return object[n11].getLinearY(d10);
                }
                object = object[n11];
                ((ArcCurveFit$Arc)object).setPoint(d10);
                if (n10 == 0) {
                    return this.mArcs[n11].getX();
                }
                return this.mArcs[n11].getY();
            }
            ++n11;
        }
        return 0.0 / 0.0;
    }

    public void getPos(double d10, double[] dArray) {
        int n10;
        ArcCurveFit$Arc arcCurveFit$Arc;
        ArcCurveFit$Arc[] arcCurveFit$ArcArray = this.mArcs;
        ArcCurveFit$Arc[] arcCurveFit$ArcArray2 = arcCurveFit$ArcArray[0];
        double d11 = arcCurveFit$ArcArray2.mTime1;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object < 0) {
            arcCurveFit$Arc = arcCurveFit$ArcArray[0];
            d10 = arcCurveFit$Arc.mTime1;
        }
        object = arcCurveFit$ArcArray.length;
        int n11 = 1;
        arcCurveFit$ArcArray2 = arcCurveFit$ArcArray[object -= n11];
        double d13 = arcCurveFit$ArcArray2.mTime2;
        double d14 = d10 - d13;
        object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object > 0) {
            int n12 = arcCurveFit$ArcArray.length - n11;
            arcCurveFit$Arc = arcCurveFit$ArcArray[n12];
            d10 = arcCurveFit$Arc.mTime2;
        }
        arcCurveFit$ArcArray = null;
        for (int i10 = 0; i10 < (n10 = (arcCurveFit$ArcArray2 = this.mArcs).length); ++i10) {
            ArcCurveFit$Arc arcCurveFit$Arc2 = arcCurveFit$ArcArray2[i10];
            d13 = arcCurveFit$Arc2.mTime2;
            double d15 = d10 - d13;
            n10 = (int)(d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1));
            if (n10 > 0) continue;
            arcCurveFit$Arc2 = arcCurveFit$ArcArray2[i10];
            n10 = (int)(arcCurveFit$Arc2.linear ? 1 : 0);
            if (n10 != 0) {
                dArray[0] = d13 = arcCurveFit$ArcArray2[i10].getLinearX(d10);
                dArray[n11] = d10 = this.mArcs[i10].getLinearY(d10);
                return;
            }
            arcCurveFit$ArcArray2[i10].setPoint(d10);
            dArray[0] = d10 = this.mArcs[i10].getX();
            dArray[n11] = d10 = this.mArcs[i10].getY();
            return;
        }
    }

    public void getPos(double d10, float[] fArray) {
        int n10;
        double d11;
        ArcCurveFit$Arc arcCurveFit$Arc;
        ArcCurveFit$Arc[] arcCurveFit$ArcArray = this.mArcs;
        ArcCurveFit$Arc[] arcCurveFit$ArcArray2 = arcCurveFit$ArcArray[0];
        double d12 = arcCurveFit$ArcArray2.mTime1;
        Object object = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1);
        int n11 = 1;
        if (object < 0) {
            arcCurveFit$Arc = arcCurveFit$ArcArray[0];
            d10 = arcCurveFit$Arc.mTime1;
        } else {
            object = arcCurveFit$ArcArray.length - n11;
            arcCurveFit$ArcArray2 = arcCurveFit$ArcArray[object];
            d11 = arcCurveFit$ArcArray2.mTime2;
            double d13 = d10 - d11;
            object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object > 0) {
                int n12 = arcCurveFit$ArcArray.length - n11;
                arcCurveFit$Arc = arcCurveFit$ArcArray[n12];
                d10 = arcCurveFit$Arc.mTime2;
            }
        }
        arcCurveFit$ArcArray = null;
        for (int i10 = 0; i10 < (n10 = (arcCurveFit$ArcArray2 = this.mArcs).length); ++i10) {
            float f10;
            ArcCurveFit$Arc arcCurveFit$Arc2 = arcCurveFit$ArcArray2[i10];
            d11 = arcCurveFit$Arc2.mTime2;
            double d14 = d10 - d11;
            n10 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1));
            if (n10 > 0) continue;
            arcCurveFit$Arc2 = arcCurveFit$ArcArray2[i10];
            n10 = (int)(arcCurveFit$Arc2.linear ? 1 : 0);
            if (n10 != 0) {
                float f11;
                float f12;
                fArray[0] = f12 = (float)arcCurveFit$ArcArray2[i10].getLinearX(d10);
                fArray[n11] = f11 = (float)this.mArcs[i10].getLinearY(d10);
                return;
            }
            arcCurveFit$ArcArray2[i10].setPoint(d10);
            fArray[0] = f10 = (float)this.mArcs[i10].getX();
            fArray[n11] = f10 = (float)this.mArcs[i10].getY();
            return;
        }
    }

    public double getSlope(double d10, int n10) {
        ArcCurveFit$Arc arcCurveFit$Arc;
        Object object = this.mArcs;
        int n11 = 0;
        ArcCurveFit$Arc arcCurveFit$Arc2 = object[0];
        double d11 = arcCurveFit$Arc2.mTime1;
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object2 < 0) {
            arcCurveFit$Arc = object[0];
            d10 = arcCurveFit$Arc.mTime1;
        }
        object2 = ((ArcCurveFit$Arc[])object).length + -1;
        arcCurveFit$Arc2 = object[object2];
        d11 = arcCurveFit$Arc2.mTime2;
        double d13 = d10 - d11;
        object2 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object2 > 0) {
            int n12 = ((ArcCurveFit$Arc[])object).length + -1;
            arcCurveFit$Arc = object[n12];
            d10 = arcCurveFit$Arc.mTime2;
        }
        while (n11 < (object2 = (Object)((ArcCurveFit$Arc[])(object = this.mArcs)).length)) {
            arcCurveFit$Arc2 = object[n11];
            d11 = arcCurveFit$Arc2.mTime2;
            double d14 = d10 - d11;
            object2 = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
            if (object2 <= 0) {
                arcCurveFit$Arc2 = object[n11];
                object2 = arcCurveFit$Arc2.linear;
                if (object2 != false) {
                    if (n10 == 0) {
                        return object[n11].getLinearDX(d10);
                    }
                    return object[n11].getLinearDY(d10);
                }
                object = object[n11];
                ((ArcCurveFit$Arc)object).setPoint(d10);
                if (n10 == 0) {
                    return this.mArcs[n11].getDX();
                }
                return this.mArcs[n11].getDY();
            }
            ++n11;
        }
        return 0.0 / 0.0;
    }

    public void getSlope(double d10, double[] dArray) {
        int n10;
        double d11;
        ArcCurveFit$Arc arcCurveFit$Arc;
        ArcCurveFit$Arc[] arcCurveFit$ArcArray = this.mArcs;
        ArcCurveFit$Arc[] arcCurveFit$ArcArray2 = arcCurveFit$ArcArray[0];
        double d12 = arcCurveFit$ArcArray2.mTime1;
        Object object = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1);
        int n11 = 1;
        if (object < 0) {
            arcCurveFit$Arc = arcCurveFit$ArcArray[0];
            d10 = arcCurveFit$Arc.mTime1;
        } else {
            object = arcCurveFit$ArcArray.length - n11;
            arcCurveFit$ArcArray2 = arcCurveFit$ArcArray[object];
            d11 = arcCurveFit$ArcArray2.mTime2;
            double d13 = d10 - d11;
            object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object > 0) {
                int n12 = arcCurveFit$ArcArray.length - n11;
                arcCurveFit$Arc = arcCurveFit$ArcArray[n12];
                d10 = arcCurveFit$Arc.mTime2;
            }
        }
        arcCurveFit$ArcArray = null;
        for (int i10 = 0; i10 < (n10 = (arcCurveFit$ArcArray2 = this.mArcs).length); ++i10) {
            ArcCurveFit$Arc arcCurveFit$Arc2 = arcCurveFit$ArcArray2[i10];
            d11 = arcCurveFit$Arc2.mTime2;
            double d14 = d10 - d11;
            n10 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1));
            if (n10 > 0) continue;
            arcCurveFit$Arc2 = arcCurveFit$ArcArray2[i10];
            n10 = (int)(arcCurveFit$Arc2.linear ? 1 : 0);
            if (n10 != 0) {
                dArray[0] = d11 = arcCurveFit$ArcArray2[i10].getLinearDX(d10);
                dArray[n11] = d10 = this.mArcs[i10].getLinearDY(d10);
                return;
            }
            arcCurveFit$ArcArray2[i10].setPoint(d10);
            dArray[0] = d10 = this.mArcs[i10].getDX();
            dArray[n11] = d10 = this.mArcs[i10].getDY();
            return;
        }
    }

    public double[] getTimePoints() {
        return this.mTime;
    }
}

