/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import java.util.ArrayList;

public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static BasicMeasure$Measure measure;

    static {
        BasicMeasure$Measure basicMeasure$Measure;
        measure = basicMeasure$Measure = new BasicMeasure$Measure();
    }

    private static boolean canMeasure(ConstraintWidget constraintWidget) {
        float f10;
        float f11;
        int n10;
        float f12;
        float f13;
        int n11;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = constraintWidget.getVerticalDimensionBehaviour();
        Object object = constraintWidget.getParent();
        object = object != null ? (ConstraintWidgetContainer)constraintWidget.getParent() : null;
        if (object != null) {
            object.getHorizontalDimensionBehaviour();
        }
        if (object != null) {
            object = object.getVerticalDimensionBehaviour();
        }
        object = ConstraintWidget$DimensionBehaviour.FIXED;
        int n12 = 0;
        int n13 = 1;
        float f14 = Float.MIN_VALUE;
        if (constraintWidget$DimensionBehaviour2 != object && constraintWidget$DimensionBehaviour2 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (constraintWidget$DimensionBehaviour2 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) || (n11 = constraintWidget.mMatchConstraintDefaultWidth) != 0 || (n11 = (int)((f13 = (f12 = constraintWidget.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) != 0 || (n11 = constraintWidget.hasDanglingDimension(0)) == 0) && (n11 = (int)(constraintWidget.isResolvedHorizontally() ? 1 : 0)) == 0) {
            n11 = 0;
            constraintWidget$DimensionBehaviour2 = null;
            f12 = 0.0f;
        } else {
            n11 = n13;
            f12 = f14;
        }
        if (constraintWidget$DimensionBehaviour3 != object && constraintWidget$DimensionBehaviour3 != (object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (constraintWidget$DimensionBehaviour3 != (object = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) || (n10 = constraintWidget.mMatchConstraintDefaultHeight) != 0 || (n10 = (f11 = (f10 = constraintWidget.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != 0 || (n10 = (int)(constraintWidget.hasDanglingDimension(n13) ? 1 : 0)) == 0) && (n10 = (int)(constraintWidget.isResolvedVertically() ? 1 : 0)) == 0) {
            n10 = 0;
            constraintWidget$DimensionBehaviour3 = null;
            f10 = 0.0f;
        } else {
            n10 = n13;
            f10 = f14;
        }
        float f15 = constraintWidget.mDimensionRatio;
        float f16 = f15 - 0.0f;
        float f17 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (f17 > 0 && (n11 != 0 || n10 != 0)) {
            return n13 != 0;
        }
        if (n11 != 0 && n10 != 0) {
            n12 = n13;
        }
        return n12 != 0;
    }

    private static void horizontalSolvingPass(ConstraintWidget constraintWidget, BasicMeasure$Measurer basicMeasure$Measurer, boolean bl2) {
        Object object;
        Object object2;
        Object object3;
        int n11;
        int n12;
        Object object4;
        boolean bl3 = constraintWidget instanceof ConstraintWidgetContainer;
        if (!bl3 && (bl3 = constraintWidget.isMeasureRequested()) && (bl3 = Direct.canMeasure(constraintWidget))) {
            object4 = new BasicMeasure$Measure();
            n12 = BasicMeasure$Measure.SELF_DIMENSIONS;
            ConstraintWidgetContainer.measure(constraintWidget, basicMeasure$Measurer, (BasicMeasure$Measure)object4, n12);
        }
        object4 = ConstraintAnchor$Type.LEFT;
        object4 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object4));
        Object object5 = ConstraintAnchor$Type.RIGHT;
        object5 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object5));
        int n13 = ((ConstraintAnchor)object4).getFinalValue();
        int n14 = ((ConstraintAnchor)object5).getFinalValue();
        Object object6 = ((ConstraintAnchor)object4).getDependents();
        int n15 = 8;
        boolean bl4 = true;
        if (object6 != null && (n11 = ((ConstraintAnchor)object4).hasFinalValue()) != 0) {
            object4 = ((ConstraintAnchor)object4).getDependents().iterator();
            while ((n11 = object4.hasNext()) != 0) {
                Object object7;
                object6 = (ConstraintAnchor)object4.next();
                object3 = ((ConstraintAnchor)object6).mOwner;
                int n10 = Direct.canMeasure((ConstraintWidget)object3);
                boolean bl5 = ((ConstraintWidget)object3).isMeasureRequested();
                if (bl5 && n10 != 0) {
                    object2 = new BasicMeasure$Measure();
                    int n16 = BasicMeasure$Measure.SELF_DIMENSIONS;
                    ConstraintWidgetContainer.measure((ConstraintWidget)object3, basicMeasure$Measurer, (BasicMeasure$Measure)object2, n16);
                }
                if ((object2 = ((ConstraintWidget)object3).getHorizontalDimensionBehaviour()) == (object7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && n10 == 0) {
                    float f10;
                    float f11;
                    object = ((ConstraintWidget)object3).getHorizontalDimensionBehaviour();
                    if (object != object7 || (n10 = ((ConstraintWidget)object3).mMatchConstraintMaxWidth) < 0 || (n10 = ((ConstraintWidget)object3).mMatchConstraintMinWidth) < 0 || (n10 = ((ConstraintWidget)object3).getVisibility()) != n15 && ((n10 = ((ConstraintWidget)object3).mMatchConstraintDefaultWidth) != 0 || (n10 = (int)((f11 = (f10 = ((ConstraintWidget)object3).getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) || (n10 = (int)(((ConstraintWidget)object3).isInHorizontalChain() ? 1 : 0)) != 0 || (n10 = (int)(((ConstraintWidget)object3).isInVirtualLayout() ? 1 : 0)) != 0) continue;
                    object = ((ConstraintWidget)object3).mLeft;
                    if (object6 == object && (object = object3.mRight.mTarget) != null && (n10 = (int)(((ConstraintAnchor)object).hasFinalValue() ? 1 : 0)) != 0 || object6 == (object = ((ConstraintWidget)object3).mRight) && (object6 = object3.mLeft.mTarget) != null && (n11 = (int)(((ConstraintAnchor)object6).hasFinalValue() ? 1 : 0)) != 0) {
                        n11 = bl4 ? 1 : 0;
                    } else {
                        n11 = 0;
                        object6 = null;
                    }
                    if (n11 == 0 || (n11 = (int)(((ConstraintWidget)object3).isInHorizontalChain() ? 1 : 0)) != 0) continue;
                    Direct.solveHorizontalMatchConstraint(constraintWidget, basicMeasure$Measurer, (ConstraintWidget)object3, bl2);
                    continue;
                }
                n10 = ((ConstraintWidget)object3).isMeasureRequested();
                if (n10 != 0) continue;
                object = ((ConstraintWidget)object3).mLeft;
                if (object6 == object && (object2 = object3.mRight.mTarget) == null) {
                    n11 = ((ConstraintAnchor)object).getMargin() + n13;
                    n10 = ((ConstraintWidget)object3).getWidth() + n11;
                    ((ConstraintWidget)object3).setFinalHorizontal(n11, n10);
                    Direct.horizontalSolvingPass((ConstraintWidget)object3, basicMeasure$Measurer, bl2);
                    continue;
                }
                object2 = ((ConstraintWidget)object3).mRight;
                if (object6 == object2 && (object7 = ((ConstraintAnchor)object).mTarget) == null) {
                    n11 = ((ConstraintAnchor)object2).getMargin();
                    n11 = n13 - n11;
                    int n10 = ((ConstraintWidget)object3).getWidth();
                    n10 = n11 - n10;
                    ((ConstraintWidget)object3).setFinalHorizontal(n10, n11);
                    Direct.horizontalSolvingPass((ConstraintWidget)object3, basicMeasure$Measurer, bl2);
                    continue;
                }
                if (object6 != object || (object6 = ((ConstraintAnchor)object2).mTarget) == null || (n11 = (int)(((ConstraintAnchor)object6).hasFinalValue() ? 1 : 0)) == 0 || (n11 = (int)(((ConstraintWidget)object3).isInHorizontalChain() ? 1 : 0)) != 0) continue;
                Direct.solveHorizontalCenterConstraints(basicMeasure$Measurer, (ConstraintWidget)object3, bl2);
            }
        }
        if (bl3 = constraintWidget instanceof Guideline) {
            return;
        }
        object4 = ((ConstraintAnchor)object5).getDependents();
        if (object4 != null && (bl3 = ((ConstraintAnchor)object5).hasFinalValue())) {
            object4 = ((ConstraintAnchor)object5).getDependents().iterator();
            while ((n12 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                object5 = (ConstraintAnchor)object4.next();
                ConstraintWidget constraintWidget2 = ((ConstraintAnchor)object5).mOwner;
                n11 = Direct.canMeasure(constraintWidget2);
                boolean bl6 = constraintWidget2.isMeasureRequested();
                if (bl6 && n11 != 0) {
                    object3 = new BasicMeasure$Measure();
                    int n17 = BasicMeasure$Measure.SELF_DIMENSIONS;
                    ConstraintWidgetContainer.measure(constraintWidget2, basicMeasure$Measurer, (BasicMeasure$Measure)object3, n17);
                }
                if (object5 == (object3 = constraintWidget2.mLeft) && (object3 = constraintWidget2.mRight.mTarget) != null && (bl6 = ((ConstraintAnchor)object3).hasFinalValue()) || object5 == (object3 = constraintWidget2.mRight) && (object3 = constraintWidget2.mLeft.mTarget) != null && (bl6 = ((ConstraintAnchor)object3).hasFinalValue())) {
                    bl6 = bl4;
                } else {
                    bl6 = false;
                    object3 = null;
                }
                object = constraintWidget2.getHorizontalDimensionBehaviour();
                object2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (object == object2 && n11 == 0) {
                    float f12;
                    float f13;
                    object5 = constraintWidget2.getHorizontalDimensionBehaviour();
                    if (object5 != object2 || (n12 = constraintWidget2.mMatchConstraintMaxWidth) < 0 || (n12 = constraintWidget2.mMatchConstraintMinWidth) < 0 || (n12 = constraintWidget2.getVisibility()) != n15 && ((n12 = constraintWidget2.mMatchConstraintDefaultWidth) != 0 || (n12 = (int)((f13 = (f12 = constraintWidget2.getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) != 0) || (n12 = (int)(constraintWidget2.isInHorizontalChain() ? 1 : 0)) != 0 || (n12 = (int)(constraintWidget2.isInVirtualLayout() ? 1 : 0)) != 0 || !bl6 || (n12 = (int)(constraintWidget2.isInHorizontalChain() ? 1 : 0)) != 0) continue;
                    Direct.solveHorizontalMatchConstraint(constraintWidget, basicMeasure$Measurer, constraintWidget2, bl2);
                    continue;
                }
                n11 = constraintWidget2.isMeasureRequested() ? 1 : 0;
                if (n11 != 0) continue;
                object6 = constraintWidget2.mLeft;
                if (object5 == object6 && (object = constraintWidget2.mRight.mTarget) == null) {
                    n12 = ((ConstraintAnchor)object6).getMargin() + n14;
                    n11 = constraintWidget2.getWidth() + n12;
                    constraintWidget2.setFinalHorizontal(n12, n11);
                    Direct.horizontalSolvingPass(constraintWidget2, basicMeasure$Measurer, bl2);
                    continue;
                }
                object = constraintWidget2.mRight;
                if (object5 == object && (object5 = ((ConstraintAnchor)object6).mTarget) == null) {
                    n12 = ((ConstraintAnchor)object).getMargin();
                    n12 = n14 - n12;
                    n11 = constraintWidget2.getWidth();
                    n11 = n12 - n11;
                    constraintWidget2.setFinalHorizontal(n11, n12);
                    Direct.horizontalSolvingPass(constraintWidget2, basicMeasure$Measurer, bl2);
                    continue;
                }
                if (!bl6 || (n12 = (int)(constraintWidget2.isInHorizontalChain() ? 1 : 0)) != 0) continue;
                Direct.solveHorizontalCenterConstraints(basicMeasure$Measurer, constraintWidget2, bl2);
            }
        }
    }

    private static void solveBarrier(Barrier barrier, BasicMeasure$Measurer basicMeasure$Measurer, int n10, boolean bl2) {
        boolean bl3 = barrier.allSolved();
        if (bl3) {
            if (n10 == 0) {
                Direct.horizontalSolvingPass(barrier, basicMeasure$Measurer, bl2);
            } else {
                Direct.verticalSolvingPass(barrier, basicMeasure$Measurer);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean solveChain(ConstraintWidgetContainer var0, LinearSystem var1_1, int var2_2, int var3_3, ChainHead var4_4, boolean var5_5, boolean var6_6, boolean var7_7) {
        block36: {
            block40: {
                block37: {
                    var8_8 = 0;
                    var9_9 = 0.0f;
                    var10_10 = null;
                    if (var7_7) {
                        return false;
                    }
                    if (var2_2 == 0 ? (var11_11 = var0.isResolvedHorizontally()) == false : (var11_11 = var0.isResolvedVertically()) == false) {
                        return false;
                    }
                    var11_11 = var0.isRtl();
                    var12_12 /* !! */  = var4_4.getFirst();
                    var13_13 = var4_4.getLast();
                    var14_14 = var4_4.getFirstVisibleWidget();
                    var15_15 = var4_4.getLastVisibleWidget();
                    var16_16 /* !! */  = var4_4.getHead();
                    var17_17 = var12_12 /* !! */ .mListAnchors[var3_3];
                    var13_13 = var13_13.mListAnchors;
                    var18_18 = var3_3 + 1;
                    var13_13 = var13_13[var18_18];
                    var19_19 = var17_17.mTarget;
                    if (var19_19 == null || (var20_20 = var13_13.mTarget) == null || (var21_21 = var19_19.hasFinalValue()) == 0 || (var21_21 = (var19_19 = var13_13.mTarget).hasFinalValue()) == 0 || var14_14 == null || var15_15 == null) break block36;
                    var17_17 = var17_17.mTarget;
                    var22_22 = var17_17.getFinalValue();
                    var21_21 = var14_14.mListAnchors[var3_3].getMargin();
                    var22_22 += var21_21;
                    var13_13 = var13_13.mTarget;
                    var23_23 = var13_13.getFinalValue();
                    var19_19 = var15_15.mListAnchors[var18_18];
                    var21_21 = var19_19.getMargin();
                    if ((var21_21 = (var23_23 -= var21_21) - var22_22) <= 0) {
                        return false;
                    }
                    var20_20 = new BasicMeasure$Measure();
                    var24_24 = false;
                    var25_25 = 0;
                    var26_26 = 0;
                    var27_27 = 0;
                    var28_28 = var12_12 /* !! */ ;
                    while (true) {
                        var29_29 = null;
                        if (var24_24) break;
                        var10_10 = var28_28.mListAnchors[var3_3];
                        var8_8 = Direct.canMeasure(var28_28);
                        if (var8_8 == 0) {
                            return false;
                        }
                        var10_10 = var28_28.mListDimensionBehaviors[var2_2];
                        var30_30 = var12_12 /* !! */ ;
                        var12_12 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                        if (var10_10 == var12_12 /* !! */ ) {
                            return false;
                        }
                        var8_8 = (int)var28_28.isMeasureRequested();
                        if (var8_8 != 0) {
                            var10_10 = var0.getMeasurer();
                            var31_31 = BasicMeasure$Measure.SELF_DIMENSIONS;
                            ConstraintWidgetContainer.measure(var28_28, (BasicMeasure$Measurer)var10_10, (BasicMeasure$Measure)var20_20, var31_31);
                        }
                        var10_10 = var28_28.mListAnchors[var3_3];
                        var8_8 = var10_10.getMargin();
                        var27_27 += var8_8;
                        var8_8 = var2_2 == 0 ? var28_28.getWidth() : var28_28.getHeight();
                        var27_27 += var8_8;
                        var10_10 = var28_28.mListAnchors[var18_18];
                        var8_8 = var10_10.getMargin();
                        var27_27 += var8_8;
                        ++var26_26;
                        var8_8 = var28_28.getVisibility();
                        var31_31 = 8;
                        var32_32 = 1.1E-44f;
                        if (var8_8 != var31_31) {
                            ++var25_25;
                        }
                        if ((var10_10 = var28_28.mListAnchors[var18_18].mTarget) != null) {
                            var10_10 = var10_10.mOwner;
                            var12_12 /* !! */  = var10_10.mListAnchors;
                            var4_4 = var10_10;
                            var10_10 = var12_12 /* !! */ [var3_3].mTarget;
                            if (var10_10 != null && (var10_10 = var12_12 /* !! */ [var3_3].mTarget.mOwner) == var28_28) {
                                var29_29 = var4_4;
                            }
                        }
                        if (var29_29 != null) {
                            var28_28 = var29_29;
                        } else {
                            var24_24 = true;
                        }
                        var12_12 /* !! */  = var30_30;
                    }
                    var30_30 = var12_12 /* !! */ ;
                    if (var25_25 == 0) {
                        return false;
                    }
                    var8_8 = 0;
                    var9_9 = 0.0f;
                    var10_10 = null;
                    if (var25_25 != var26_26) {
                        return false;
                    }
                    if (var21_21 < var27_27) {
                        return false;
                    }
                    var21_21 -= var27_27;
                    var8_8 = 2;
                    var9_9 = 2.8E-45f;
                    if (var5_5) {
                        var31_31 = var25_25 + 1;
                        var21_21 /= var31_31;
                        while (true) {
                            var31_31 = 1;
                            var32_32 = 1.4E-45f;
                            break;
                        }
                    } else {
                        if (!var6_6 || var25_25 <= var8_8) ** continue;
                        var21_21 /= var25_25;
                        var31_31 = 1;
                        var32_32 = 1.4E-45f;
                        var21_21 -= var31_31;
                    }
                    if (var25_25 == var31_31) {
                        var9_9 = var2_2 == 0 ? var16_16 /* !! */ .getHorizontalBiasPercent() : var16_16 /* !! */ .getVerticalBiasPercent();
                        var31_31 = 0x3F000000;
                        var33_33 = (float)var22_22 + 0.5f;
                        var32_32 = (float)var21_21 * var9_9;
                        var8_8 = (int)(var33_33 += var32_32);
                        if (var2_2 == 0) {
                            var31_31 = var14_14.getWidth() + var8_8;
                            var14_14.setFinalHorizontal(var8_8, var31_31);
                        } else {
                            var31_31 = var14_14.getHeight() + var8_8;
                            var14_14.setFinalVertical(var8_8, var31_31);
                        }
                        var10_10 = var0.getMeasurer();
                        Direct.horizontalSolvingPass(var14_14, (BasicMeasure$Measurer)var10_10, var11_11);
                        return true;
                    }
                    if (!var5_5) break block37;
                    var22_22 += var21_21;
                    var12_12 /* !! */  = var30_30;
                    var8_8 = 0;
                    var9_9 = 0.0f;
                    var10_10 = null;
                    while (var8_8 == 0) {
                        block39: {
                            block38: {
                                var13_13 = var12_12 /* !! */ .mListAnchors[var3_3];
                                var23_23 = var12_12 /* !! */ .getVisibility();
                                if (var23_23 == (var34_34 = 8)) {
                                    if (var2_2 == 0) {
                                        var12_12 /* !! */ .setFinalHorizontal(var22_22, var22_22);
                                        var13_13 = var0.getMeasurer();
                                        Direct.horizontalSolvingPass(var12_12 /* !! */ , (BasicMeasure$Measurer)var13_13, var11_11);
                                    } else {
                                        var12_12 /* !! */ .setFinalVertical(var22_22, var22_22);
                                        var13_13 = var0.getMeasurer();
                                        Direct.verticalSolvingPass(var12_12 /* !! */ , (BasicMeasure$Measurer)var13_13);
                                    }
lbl139:
                                    // 3 sources

                                    while (true) {
                                        continue;
                                        break;
                                    }
                                }
                                var13_13 = var12_12 /* !! */ .mListAnchors[var3_3];
                                var23_23 = var13_13.getMargin();
                                var22_22 += var23_23;
                                if (var2_2 == 0) {
                                    var23_23 = var12_12 /* !! */ .getWidth() + var22_22;
                                    var12_12 /* !! */ .setFinalHorizontal(var22_22, var23_23);
                                    var13_13 = var0.getMeasurer();
                                    Direct.horizontalSolvingPass(var12_12 /* !! */ , (BasicMeasure$Measurer)var13_13, var11_11);
                                    var23_23 = var12_12 /* !! */ .getWidth();
                                } else {
                                    var23_23 = var12_12 /* !! */ .getHeight() + var22_22;
                                    var12_12 /* !! */ .setFinalVertical(var22_22, var23_23);
                                    var13_13 = var0.getMeasurer();
                                    Direct.verticalSolvingPass(var12_12 /* !! */ , (BasicMeasure$Measurer)var13_13);
                                    var23_23 = var12_12 /* !! */ .getHeight();
                                }
                                var22_22 += var23_23;
                                var13_13 = var12_12 /* !! */ .mListAnchors[var18_18];
                                var23_23 = var13_13.getMargin();
                                var22_22 = var22_22 + var23_23 + var21_21;
                                ** continue;
                                var13_13 = var1_1;
                                var15_15 = null;
                                var12_12 /* !! */ .addToSolver(var1_1, false);
                                var15_15 = var12_12 /* !! */ .mListAnchors[var18_18].mTarget;
                                if (var15_15 == null) break block38;
                                var15_15 = var15_15.mOwner;
                                var16_16 /* !! */  = var15_15.mListAnchors;
                                var20_20 = var16_16 /* !! */ [var3_3].mTarget;
                                if (var20_20 != null && (var16_16 /* !! */  = var16_16 /* !! */ [var3_3].mTarget.mOwner) == var12_12 /* !! */ ) break block39;
                            }
                            var15_15 = null;
                        }
                        if (var15_15 != null) {
                            var12_12 /* !! */  = var15_15;
                            continue;
                        }
                        var8_8 = 1;
                        var9_9 = 1.4E-45f;
                    }
                    break block40;
                }
                if (var6_6) {
                    if (var25_25 == var8_8) {
                        if (var2_2 == 0) {
                            var8_8 = var14_14.getWidth() + var22_22;
                            var14_14.setFinalHorizontal(var22_22, var8_8);
                            var8_8 = var15_15.getWidth();
                            var8_8 = var23_23 - var8_8;
                            var15_15.setFinalHorizontal(var8_8, var23_23);
                            var10_10 = var0.getMeasurer();
                            Direct.horizontalSolvingPass(var14_14, (BasicMeasure$Measurer)var10_10, var11_11);
                            var10_10 = var0.getMeasurer();
                            Direct.horizontalSolvingPass((ConstraintWidget)var15_15, (BasicMeasure$Measurer)var10_10, var11_11);
                        } else {
                            var8_8 = var14_14.getHeight() + var22_22;
                            var14_14.setFinalVertical(var22_22, var8_8);
                            var8_8 = var15_15.getHeight();
                            var8_8 = var23_23 - var8_8;
                            var15_15.setFinalVertical(var8_8, var23_23);
                            var10_10 = var0.getMeasurer();
                            Direct.verticalSolvingPass(var14_14, (BasicMeasure$Measurer)var10_10);
                            var10_10 = var0.getMeasurer();
                            Direct.verticalSolvingPass((ConstraintWidget)var15_15, (BasicMeasure$Measurer)var10_10);
                        }
                        return true;
                    }
                    return false;
                }
            }
            var8_8 = 1;
            var9_9 = 1.4E-45f;
        }
        return (boolean)var8_8;
    }

    private static void solveHorizontalCenterConstraints(BasicMeasure$Measurer basicMeasure$Measurer, ConstraintWidget constraintWidget, boolean bl2) {
        int n10;
        float f10 = constraintWidget.getHorizontalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget.mLeft.mTarget;
        int n11 = constraintAnchor.getFinalValue();
        ConstraintAnchor constraintAnchor2 = constraintWidget.mRight.mTarget;
        int n12 = constraintAnchor2.getFinalValue();
        ConstraintAnchor constraintAnchor3 = constraintWidget.mLeft;
        int n13 = constraintAnchor3.getMargin() + n11;
        ConstraintAnchor constraintAnchor4 = constraintWidget.mRight;
        int n14 = constraintAnchor4.getMargin();
        n14 = n12 - n14;
        int n15 = 0x3F000000;
        float f11 = 0.5f;
        if (n11 == n12) {
            n10 = n15;
            f10 = f11;
        } else {
            n11 = n13;
            n12 = n14;
        }
        n13 = constraintWidget.getWidth();
        n14 = n12 - n11 - n13;
        if (n11 > n12) {
            n14 = n11 - n12 - n13;
        }
        float f12 = n14;
        f10 = f10 * f12 + f11;
        n10 = (int)f10 + n11;
        n14 = n10 + n13;
        if (n11 > n12) {
            n14 = n10 - n13;
        }
        constraintWidget.setFinalHorizontal(n10, n14);
        Direct.horizontalSolvingPass(constraintWidget, basicMeasure$Measurer, bl2);
    }

    private static void solveHorizontalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure$Measurer basicMeasure$Measurer, ConstraintWidget constraintWidget2, boolean bl2) {
        float f10 = constraintWidget2.getHorizontalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget2.mLeft.mTarget;
        int n10 = constraintAnchor.getFinalValue();
        int n11 = constraintWidget2.mLeft.getMargin();
        n10 += n11;
        ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight.mTarget;
        n11 = constraintAnchor2.getFinalValue();
        ConstraintAnchor constraintAnchor3 = constraintWidget2.mRight;
        int n12 = constraintAnchor3.getMargin();
        if ((n11 -= n12) >= n10) {
            float f11;
            int n13;
            n12 = constraintWidget2.getWidth();
            int n14 = constraintWidget2.getVisibility();
            int n15 = 8;
            float f12 = 0.5f;
            if (n14 != n15) {
                n14 = constraintWidget2.mMatchConstraintDefaultWidth;
                n15 = 2;
                if (n14 == n15) {
                    n12 = constraintWidget instanceof ConstraintWidgetContainer;
                    if (n12 != 0) {
                        n13 = constraintWidget.getWidth();
                    } else {
                        constraintWidget = constraintWidget.getParent();
                        n13 = constraintWidget.getWidth();
                    }
                    float f13 = constraintWidget2.getHorizontalBiasPercent() * f12;
                    f11 = n13;
                    n12 = (int)(f13 *= f11);
                } else if (n14 == 0) {
                    n12 = n11 - n10;
                }
                n12 = Math.max(constraintWidget2.mMatchConstraintMinWidth, n12);
                n13 = constraintWidget2.mMatchConstraintMaxWidth;
                if (n13 > 0) {
                    n12 = Math.min(n13, n12);
                }
            }
            n11 = n11 - n10 - n12;
            f11 = n11;
            f10 = f10 * f11 + f12;
            n13 = (int)f10;
            constraintWidget2.setFinalHorizontal(n10, n12 += (n10 += n13));
            Direct.horizontalSolvingPass(constraintWidget2, basicMeasure$Measurer, bl2);
        }
    }

    private static void solveVerticalCenterConstraints(BasicMeasure$Measurer basicMeasure$Measurer, ConstraintWidget constraintWidget) {
        int n10;
        float f10 = constraintWidget.getVerticalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget.mTop.mTarget;
        int n11 = constraintAnchor.getFinalValue();
        ConstraintAnchor constraintAnchor2 = constraintWidget.mBottom.mTarget;
        int n12 = constraintAnchor2.getFinalValue();
        ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
        int n13 = constraintAnchor3.getMargin() + n11;
        ConstraintAnchor constraintAnchor4 = constraintWidget.mBottom;
        int n14 = constraintAnchor4.getMargin();
        n14 = n12 - n14;
        int n15 = 0x3F000000;
        float f11 = 0.5f;
        if (n11 == n12) {
            n10 = n15;
            f10 = f11;
        } else {
            n11 = n13;
            n12 = n14;
        }
        n13 = constraintWidget.getHeight();
        n14 = n12 - n11 - n13;
        if (n11 > n12) {
            n14 = n11 - n12 - n13;
        }
        float f12 = n14;
        f10 = f10 * f12 + f11;
        n10 = (int)f10;
        n14 = n11 + n10;
        n15 = n14 + n13;
        if (n11 > n12) {
            n14 = n11 - n10;
            n15 = n14 - n13;
        }
        constraintWidget.setFinalVertical(n14, n15);
        Direct.verticalSolvingPass(constraintWidget, basicMeasure$Measurer);
    }

    private static void solveVerticalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure$Measurer basicMeasure$Measurer, ConstraintWidget constraintWidget2) {
        float f10 = constraintWidget2.getVerticalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget2.mTop.mTarget;
        int n10 = constraintAnchor.getFinalValue();
        int n11 = constraintWidget2.mTop.getMargin();
        n10 += n11;
        ConstraintAnchor constraintAnchor2 = constraintWidget2.mBottom.mTarget;
        n11 = constraintAnchor2.getFinalValue();
        ConstraintAnchor constraintAnchor3 = constraintWidget2.mBottom;
        int n12 = constraintAnchor3.getMargin();
        if ((n11 -= n12) >= n10) {
            float f11;
            int n13;
            n12 = constraintWidget2.getHeight();
            int n14 = constraintWidget2.getVisibility();
            int n15 = 8;
            float f12 = 0.5f;
            if (n14 != n15) {
                n14 = constraintWidget2.mMatchConstraintDefaultHeight;
                n15 = 2;
                if (n14 == n15) {
                    n12 = constraintWidget instanceof ConstraintWidgetContainer;
                    if (n12 != 0) {
                        n13 = constraintWidget.getHeight();
                    } else {
                        constraintWidget = constraintWidget.getParent();
                        n13 = constraintWidget.getHeight();
                    }
                    float f13 = f10 * f12;
                    f11 = n13;
                    n12 = (int)(f13 *= f11);
                } else if (n14 == 0) {
                    n12 = n11 - n10;
                }
                n12 = Math.max(constraintWidget2.mMatchConstraintMinHeight, n12);
                n13 = constraintWidget2.mMatchConstraintMaxHeight;
                if (n13 > 0) {
                    n12 = Math.min(n13, n12);
                }
            }
            n11 = n11 - n10 - n12;
            f11 = n11;
            f10 = f10 * f11 + f12;
            n13 = (int)f10;
            constraintWidget2.setFinalVertical(n10, n12 += (n10 += n13));
            Direct.verticalSolvingPass(constraintWidget2, basicMeasure$Measurer);
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidget, BasicMeasure$Measurer basicMeasure$Measurer) {
        int n10;
        float f10;
        int n11;
        int n12;
        float f11;
        int n13;
        Object object;
        int n14;
        Object object2 = constraintWidget.getHorizontalDimensionBehaviour();
        Object object3 = constraintWidget.getVerticalDimensionBehaviour();
        constraintWidget.resetFinalResolution();
        ArrayList arrayList = ((WidgetContainer)constraintWidget).getChildren();
        int n15 = arrayList.size();
        int n16 = 0;
        for (n14 = 0; n14 < n15; n14 += 1) {
            object = (ConstraintWidget)arrayList.get(n14);
            object.resetFinalResolution();
        }
        n14 = ((ConstraintWidgetContainer)constraintWidget).isRtl() ? 1 : 0;
        object = ConstraintWidget$DimensionBehaviour.FIXED;
        if (object2 == object) {
            n13 = constraintWidget.getWidth();
            constraintWidget.setFinalHorizontal(0, n13);
        } else {
            constraintWidget.setFinalLeft(0);
        }
        n13 = 0;
        object2 = null;
        int n17 = 0;
        object = null;
        float f12 = 0.0f;
        int n18 = 0;
        ConstraintWidget constraintWidget2 = null;
        while (true) {
            int n19 = 0x3F000000;
            f11 = 0.5f;
            n12 = -1;
            float f13 = 0.0f / 0.0f;
            n11 = 1;
            f10 = Float.MIN_VALUE;
            if (n13 >= n15) break;
            ConstraintWidget constraintWidget3 = (ConstraintWidget)arrayList.get(n13);
            int n20 = constraintWidget3 instanceof Guideline;
            if (n20 != 0) {
                n20 = ((Guideline)(constraintWidget3 = (Guideline)constraintWidget3)).getOrientation();
                if (n20 == n11) {
                    n17 = ((Guideline)constraintWidget3).getRelativeBegin();
                    if (n17 != n12) {
                        n17 = ((Guideline)constraintWidget3).getRelativeBegin();
                        ((Guideline)constraintWidget3).setFinalValue(n17);
                    } else {
                        n17 = ((Guideline)constraintWidget3).getRelativeEnd();
                        if (n17 != n12 && (n17 = (int)(constraintWidget.isResolvedHorizontally() ? 1 : 0)) != 0) {
                            n17 = constraintWidget.getWidth();
                            n19 = ((Guideline)constraintWidget3).getRelativeEnd();
                            ((Guideline)constraintWidget3).setFinalValue(n17 -= n19);
                        } else {
                            n17 = constraintWidget.isResolvedHorizontally() ? 1 : 0;
                            if (n17 != 0) {
                                f12 = ((Guideline)constraintWidget3).getRelativePercent();
                                n12 = constraintWidget.getWidth();
                                f13 = n12;
                                f12 = f12 * f13 + f11;
                                n17 = (int)f12;
                                ((Guideline)constraintWidget3).setFinalValue(n17);
                            }
                        }
                    }
                    n17 = n11;
                    f12 = f10;
                }
            } else {
                n19 = constraintWidget3 instanceof Barrier;
                if (n19 != 0 && (n19 = ((Barrier)(constraintWidget3 = (Barrier)constraintWidget3)).getOrientation()) == 0) {
                    n18 = n11;
                }
            }
            n13 += 1;
        }
        if (n17 != 0) {
            object2 = null;
            for (n13 = 0; n13 < n15; n13 += 1) {
                object = (ConstraintWidget)arrayList.get(n13);
                n10 = object instanceof Guideline;
                if (n10 == 0 || (n10 = ((Guideline)(object = (Guideline)object)).getOrientation()) != n11) continue;
                Direct.horizontalSolvingPass(object, basicMeasure$Measurer, n14 != 0);
            }
        }
        Direct.horizontalSolvingPass(constraintWidget, basicMeasure$Measurer, n14 != 0);
        if (n18 != 0) {
            object2 = null;
            for (n13 = 0; n13 < n15; n13 += 1) {
                object = (ConstraintWidget)arrayList.get(n13);
                n18 = object instanceof Barrier;
                if (n18 == 0 || (n18 = ((Barrier)(object = (Barrier)object)).getOrientation()) != 0) continue;
                Direct.solveBarrier((Barrier)object, basicMeasure$Measurer, 0, n14 != 0);
            }
        }
        if (object3 == (object2 = ConstraintWidget$DimensionBehaviour.FIXED)) {
            n13 = constraintWidget.getHeight();
            constraintWidget.setFinalVertical(0, n13);
        } else {
            constraintWidget.setFinalTop(0);
        }
        object2 = null;
        int n21 = 0;
        object3 = null;
        float f14 = 0.0f;
        n17 = 0;
        object = null;
        f12 = 0.0f;
        for (n13 = 0; n13 < n15; n13 += 1) {
            constraintWidget2 = (ConstraintWidget)arrayList.get(n13);
            n10 = constraintWidget2 instanceof Guideline;
            if (n10 != 0) {
                n10 = ((Guideline)(constraintWidget2 = (Guideline)constraintWidget2)).getOrientation();
                if (n10 != 0) continue;
                n21 = ((Guideline)constraintWidget2).getRelativeBegin();
                if (n21 != n12) {
                    n21 = ((Guideline)constraintWidget2).getRelativeBegin();
                    ((Guideline)constraintWidget2).setFinalValue(n21);
                } else {
                    n21 = ((Guideline)constraintWidget2).getRelativeEnd();
                    if (n21 != n12 && (n21 = (int)(constraintWidget.isResolvedVertically() ? 1 : 0)) != 0) {
                        n21 = constraintWidget.getHeight();
                        n10 = ((Guideline)constraintWidget2).getRelativeEnd();
                        ((Guideline)constraintWidget2).setFinalValue(n21 -= n10);
                    } else {
                        n21 = constraintWidget.isResolvedVertically() ? 1 : 0;
                        if (n21 != 0) {
                            f14 = ((Guideline)constraintWidget2).getRelativePercent();
                            n10 = constraintWidget.getHeight();
                            float f15 = n10;
                            f14 = f14 * f15 + f11;
                            n21 = (int)f14;
                            ((Guideline)constraintWidget2).setFinalValue(n21);
                        }
                    }
                }
                n21 = n11;
                f14 = f10;
                continue;
            }
            n10 = constraintWidget2 instanceof Barrier;
            if (n10 == 0 || (n18 = ((Barrier)(constraintWidget2 = (Barrier)constraintWidget2)).getOrientation()) != n11) continue;
            n17 = n11;
            f12 = f10;
        }
        if (n21 != 0) {
            object2 = null;
            for (n13 = 0; n13 < n15; n13 += 1) {
                object3 = (ConstraintWidget)arrayList.get(n13);
                n18 = object3 instanceof Guideline;
                if (n18 == 0 || (n18 = ((Guideline)(object3 = (Guideline)object3)).getOrientation()) != 0) continue;
                Direct.verticalSolvingPass((ConstraintWidget)object3, basicMeasure$Measurer);
            }
        }
        Direct.verticalSolvingPass(constraintWidget, basicMeasure$Measurer);
        if (n17 != 0) {
            constraintWidget = null;
            for (int i10 = 0; i10 < n15; i10 += 1) {
                object2 = (ConstraintWidget)arrayList.get(i10);
                n21 = object2 instanceof Barrier;
                if (n21 == 0 || (n21 = ((Barrier)(object2 = (Barrier)object2)).getOrientation()) != n11) continue;
                Direct.solveBarrier((Barrier)object2, basicMeasure$Measurer, n11, n14 != 0);
            }
        }
        while (n16 < n15) {
            constraintWidget = (ConstraintWidget)arrayList.get(n16);
            n13 = constraintWidget.isMeasureRequested() ? 1 : 0;
            if (n13 && (n13 = (int)(Direct.canMeasure(constraintWidget) ? 1 : 0))) {
                object2 = measure;
                n21 = BasicMeasure$Measure.SELF_DIMENSIONS;
                ConstraintWidgetContainer.measure(constraintWidget, basicMeasure$Measurer, (BasicMeasure$Measure)object2, n21);
                Direct.horizontalSolvingPass(constraintWidget, basicMeasure$Measurer, n14 != 0);
                Direct.verticalSolvingPass(constraintWidget, basicMeasure$Measurer);
            }
            n16 += 1;
        }
    }

    private static void verticalSolvingPass(ConstraintWidget iterator2, BasicMeasure$Measurer basicMeasure$Measurer) {
        ConstraintWidget constraintWidget;
        Object object;
        Object object2;
        Object object3;
        int n11;
        int n12;
        Object object4;
        int n13 = iterator2 instanceof ConstraintWidgetContainer;
        if (n13 == 0 && (n13 = ((ConstraintWidget)((Object)iterator2)).isMeasureRequested()) != 0 && (n13 = Direct.canMeasure(iterator2)) != 0) {
            object4 = new BasicMeasure$Measure();
            n12 = BasicMeasure$Measure.SELF_DIMENSIONS;
            ConstraintWidgetContainer.measure(iterator2, basicMeasure$Measurer, (BasicMeasure$Measure)object4, n12);
        }
        object4 = ConstraintAnchor$Type.TOP;
        object4 = ((ConstraintWidget)((Object)iterator2)).getAnchor((ConstraintAnchor$Type)((Object)object4));
        Object object5 = ConstraintAnchor$Type.BOTTOM;
        object5 = ((ConstraintWidget)((Object)iterator2)).getAnchor((ConstraintAnchor$Type)((Object)object5));
        int n14 = ((ConstraintAnchor)object4).getFinalValue();
        int n15 = ((ConstraintAnchor)object5).getFinalValue();
        Object object6 = ((ConstraintAnchor)object4).getDependents();
        int n16 = 0;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = null;
        int n17 = 8;
        boolean bl2 = true;
        if (object6 != null && (n11 = ((ConstraintAnchor)object4).hasFinalValue()) != 0) {
            object4 = ((ConstraintAnchor)object4).getDependents().iterator();
            while ((n11 = object4.hasNext()) != 0) {
                Object object7;
                object6 = (ConstraintAnchor)object4.next();
                object3 = ((ConstraintAnchor)object6).mOwner;
                int n10 = Direct.canMeasure((ConstraintWidget)object3);
                boolean bl3 = ((ConstraintWidget)object3).isMeasureRequested();
                if (bl3 && n10 != 0) {
                    object2 = new BasicMeasure$Measure();
                    int n18 = BasicMeasure$Measure.SELF_DIMENSIONS;
                    ConstraintWidgetContainer.measure((ConstraintWidget)object3, basicMeasure$Measurer, (BasicMeasure$Measure)object2, n18);
                }
                if ((object2 = ((ConstraintWidget)object3).getVerticalDimensionBehaviour()) == (object7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && n10 == 0) {
                    float f10;
                    float f11;
                    object = ((ConstraintWidget)object3).getVerticalDimensionBehaviour();
                    if (object != object7 || (n10 = ((ConstraintWidget)object3).mMatchConstraintMaxHeight) < 0 || (n10 = ((ConstraintWidget)object3).mMatchConstraintMinHeight) < 0 || (n10 = ((ConstraintWidget)object3).getVisibility()) != n17 && ((n10 = ((ConstraintWidget)object3).mMatchConstraintDefaultHeight) != 0 || (n10 = (int)((f11 = (f10 = ((ConstraintWidget)object3).getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) || (n10 = (int)(((ConstraintWidget)object3).isInVerticalChain() ? 1 : 0)) != 0 || (n10 = (int)(((ConstraintWidget)object3).isInVirtualLayout() ? 1 : 0)) != 0) continue;
                    object = ((ConstraintWidget)object3).mTop;
                    if (object6 == object && (object = object3.mBottom.mTarget) != null && (n10 = (int)(((ConstraintAnchor)object).hasFinalValue() ? 1 : 0)) != 0 || object6 == (object = ((ConstraintWidget)object3).mBottom) && (object6 = object3.mTop.mTarget) != null && (n11 = (int)(((ConstraintAnchor)object6).hasFinalValue() ? 1 : 0)) != 0) {
                        n11 = bl2 ? 1 : 0;
                    } else {
                        n11 = 0;
                        object6 = null;
                    }
                    if (n11 == 0 || (n11 = (int)(((ConstraintWidget)object3).isInVerticalChain() ? 1 : 0)) != 0) continue;
                    Direct.solveVerticalMatchConstraint((ConstraintWidget)((Object)iterator2), basicMeasure$Measurer, (ConstraintWidget)object3);
                    continue;
                }
                n10 = ((ConstraintWidget)object3).isMeasureRequested();
                if (n10 != 0) continue;
                object = ((ConstraintWidget)object3).mTop;
                if (object6 == object && (object2 = object3.mBottom.mTarget) == null) {
                    n11 = ((ConstraintAnchor)object).getMargin() + n14;
                    n10 = ((ConstraintWidget)object3).getHeight() + n11;
                    ((ConstraintWidget)object3).setFinalVertical(n11, n10);
                    Direct.verticalSolvingPass((ConstraintWidget)object3, basicMeasure$Measurer);
                    continue;
                }
                object2 = ((ConstraintWidget)object3).mBottom;
                if (object6 == object2 && (object7 = ((ConstraintAnchor)object2).mTarget) == null) {
                    n11 = ((ConstraintAnchor)object2).getMargin();
                    n11 = n14 - n11;
                    int n10 = ((ConstraintWidget)object3).getHeight();
                    n10 = n11 - n10;
                    ((ConstraintWidget)object3).setFinalVertical(n10, n11);
                    Direct.verticalSolvingPass((ConstraintWidget)object3, basicMeasure$Measurer);
                    continue;
                }
                if (object6 != object || (object6 = ((ConstraintAnchor)object2).mTarget) == null || (n11 = (int)(((ConstraintAnchor)object6).hasFinalValue() ? 1 : 0)) == 0) continue;
                Direct.solveVerticalCenterConstraints(basicMeasure$Measurer, (ConstraintWidget)object3);
            }
        }
        if ((n13 = iterator2 instanceof Guideline) != 0) {
            return;
        }
        object4 = ((ConstraintAnchor)object5).getDependents();
        if (object4 != null && (n13 = ((ConstraintAnchor)object5).hasFinalValue()) != 0) {
            object4 = ((ConstraintAnchor)object5).getDependents().iterator();
            while ((n12 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                object5 = (ConstraintAnchor)object4.next();
                constraintWidget = ((ConstraintAnchor)object5).mOwner;
                n11 = Direct.canMeasure(constraintWidget);
                boolean bl4 = constraintWidget.isMeasureRequested();
                if (bl4 && n11 != 0) {
                    object3 = new BasicMeasure$Measure();
                    int n19 = BasicMeasure$Measure.SELF_DIMENSIONS;
                    ConstraintWidgetContainer.measure(constraintWidget, basicMeasure$Measurer, (BasicMeasure$Measure)object3, n19);
                }
                if (object5 == (object3 = constraintWidget.mTop) && (object3 = constraintWidget.mBottom.mTarget) != null && (bl4 = ((ConstraintAnchor)object3).hasFinalValue()) || object5 == (object3 = constraintWidget.mBottom) && (object3 = constraintWidget.mTop.mTarget) != null && (bl4 = ((ConstraintAnchor)object3).hasFinalValue())) {
                    bl4 = bl2;
                } else {
                    bl4 = false;
                    object3 = null;
                }
                object = constraintWidget.getVerticalDimensionBehaviour();
                object2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (object == object2 && n11 == 0) {
                    float f12;
                    float f13;
                    object5 = constraintWidget.getVerticalDimensionBehaviour();
                    if (object5 != object2 || (n12 = constraintWidget.mMatchConstraintMaxHeight) < 0 || (n12 = constraintWidget.mMatchConstraintMinHeight) < 0 || (n12 = constraintWidget.getVisibility()) != n17 && ((n12 = constraintWidget.mMatchConstraintDefaultHeight) != 0 || (n12 = (int)((f13 = (f12 = constraintWidget.getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) != 0) || (n12 = (int)(constraintWidget.isInVerticalChain() ? 1 : 0)) != 0 || (n12 = (int)(constraintWidget.isInVirtualLayout() ? 1 : 0)) != 0 || !bl4 || (n12 = (int)(constraintWidget.isInVerticalChain() ? 1 : 0)) != 0) continue;
                    Direct.solveVerticalMatchConstraint((ConstraintWidget)((Object)iterator2), basicMeasure$Measurer, constraintWidget);
                    continue;
                }
                n11 = constraintWidget.isMeasureRequested() ? 1 : 0;
                if (n11 != 0) continue;
                object6 = constraintWidget.mTop;
                if (object5 == object6 && (object = constraintWidget.mBottom.mTarget) == null) {
                    n12 = ((ConstraintAnchor)object6).getMargin() + n15;
                    n11 = constraintWidget.getHeight() + n12;
                    constraintWidget.setFinalVertical(n12, n11);
                    Direct.verticalSolvingPass(constraintWidget, basicMeasure$Measurer);
                    continue;
                }
                object = constraintWidget.mBottom;
                if (object5 == object && (object5 = ((ConstraintAnchor)object6).mTarget) == null) {
                    n12 = ((ConstraintAnchor)object).getMargin();
                    n12 = n15 - n12;
                    n11 = constraintWidget.getHeight();
                    n11 = n12 - n11;
                    constraintWidget.setFinalVertical(n11, n12);
                    Direct.verticalSolvingPass(constraintWidget, basicMeasure$Measurer);
                    continue;
                }
                if (!bl4 || (n12 = (int)(constraintWidget.isInVerticalChain() ? 1 : 0)) != 0) continue;
                Direct.solveVerticalCenterConstraints(basicMeasure$Measurer, constraintWidget);
            }
        }
        object4 = ConstraintAnchor$Type.BASELINE;
        if ((object4 = ((ConstraintAnchor)((Object)(iterator2 = ((ConstraintWidget)((Object)iterator2)).getAnchor((ConstraintAnchor$Type)((Object)object4))))).getDependents()) != null && (n13 = ((ConstraintAnchor)((Object)iterator2)).hasFinalValue()) != 0) {
            n13 = ((ConstraintAnchor)((Object)iterator2)).getFinalValue();
            iterator2 = ((ConstraintAnchor)((Object)iterator2)).getDependents().iterator();
            while ((n12 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                ConstraintAnchor constraintAnchor;
                object5 = (ConstraintAnchor)iterator2.next();
                constraintWidget = ((ConstraintAnchor)object5).mOwner;
                n15 = Direct.canMeasure(constraintWidget) ? 1 : 0;
                n11 = constraintWidget.isMeasureRequested();
                if (n11 != 0 && n15 != 0) {
                    object6 = new BasicMeasure$Measure();
                    n16 = BasicMeasure$Measure.SELF_DIMENSIONS;
                    ConstraintWidgetContainer.measure(constraintWidget, basicMeasure$Measurer, (BasicMeasure$Measure)object6, n16);
                }
                if ((object6 = constraintWidget.getVerticalDimensionBehaviour()) == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && n15 == 0 || (n15 = (int)(constraintWidget.isMeasureRequested() ? 1 : 0)) != 0 || object5 != (constraintAnchor = constraintWidget.mBaseline)) continue;
                constraintWidget.setFinalBaseline(n13);
                Direct.verticalSolvingPass(constraintWidget, basicMeasure$Measurer);
            }
        }
    }
}

