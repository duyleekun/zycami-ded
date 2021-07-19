/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 0x40000000;
    public static final int FIXED = 253;
    public static final int MATCH_PARENT = 255;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = 254;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private BasicMeasure$Measure mMeasure;
    private final ArrayList mVariableDimensionsWidgets;

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        Object object = new ArrayList();
        this.mVariableDimensionsWidgets = object;
        this.mMeasure = object = new BasicMeasure$Measure();
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(BasicMeasure$Measurer object, ConstraintWidget constraintWidget, int object2) {
        int n10;
        float f10;
        float f11;
        float f12;
        int n11;
        float f13;
        int n12;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        BasicMeasure$Measure basicMeasure$Measure = this.mMeasure;
        basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        basicMeasure$Measure = this.mMeasure;
        basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        basicMeasure$Measure = this.mMeasure;
        basicMeasure$Measure.horizontalDimension = n12 = constraintWidget.getWidth();
        basicMeasure$Measure = this.mMeasure;
        basicMeasure$Measure.verticalDimension = n12 = constraintWidget.getHeight();
        basicMeasure$Measure = this.mMeasure;
        n12 = 0;
        constraintWidget$DimensionBehaviour = null;
        basicMeasure$Measure.measuredNeedsSolverPass = false;
        basicMeasure$Measure.measureStrategy = object2;
        Object object3 = basicMeasure$Measure.horizontalBehavior;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        int n13 = 1;
        float f14 = Float.MIN_VALUE;
        if (object3 == constraintWidget$DimensionBehaviour2) {
            object2 = n13;
            f13 = f14;
        } else {
            object2 = 0;
            object3 = null;
            f13 = 0.0f;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = basicMeasure$Measure.verticalBehavior;
        if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour2) {
            n11 = n13;
            f12 = f14;
        } else {
            n11 = 0;
            constraintWidget$DimensionBehaviour2 = null;
            f12 = 0.0f;
        }
        Object object4 = 0;
        constraintWidget$DimensionBehaviour3 = null;
        if (object2 != 0 && (object2 = (Object)((f11 = (f13 = constraintWidget.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) > 0) {
            object2 = n13;
            f13 = f14;
        } else {
            object2 = 0;
            object3 = null;
            f13 = 0.0f;
        }
        if (n11 != 0 && (n11 = (int)((f10 = (f12 = constraintWidget.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) > 0) {
            n11 = n13;
            f12 = f14;
        } else {
            n11 = 0;
            constraintWidget$DimensionBehaviour2 = null;
            f12 = 0.0f;
        }
        object4 = 4;
        if (object2 != 0 && (object2 = (Object)((Object)(object3 = (Object)constraintWidget.mResolvedMatchConstraintDefault)[0])) == object4) {
            basicMeasure$Measure.horizontalBehavior = object3 = ConstraintWidget$DimensionBehaviour.FIXED;
        }
        if (n11 != 0 && (object2 = (Object)((Object)(object3 = (Object)constraintWidget.mResolvedMatchConstraintDefault)[n13])) == object4) {
            basicMeasure$Measure.verticalBehavior = object3 = ConstraintWidget$DimensionBehaviour.FIXED;
        }
        object.measure(constraintWidget, basicMeasure$Measure);
        int n14 = this.mMeasure.measuredWidth;
        constraintWidget.setWidth(n14);
        n14 = this.mMeasure.measuredHeight;
        constraintWidget.setHeight(n14);
        n14 = this.mMeasure.measuredHasBaseline ? 1 : 0;
        constraintWidget.setHasBaseline(n14 != 0);
        n14 = this.mMeasure.measuredBaseline;
        constraintWidget.setBaselineDistance(n14);
        object = this.mMeasure;
        ((BasicMeasure$Measure)object).measureStrategy = n10 = BasicMeasure$Measure.SELF_DIMENSIONS;
        return ((BasicMeasure$Measure)object).measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        ArrayList arrayList = constraintWidgetContainer.mChildren;
        int n10 = arrayList.size();
        boolean bl2 = constraintWidgetContainer.optimizeFor(64);
        BasicMeasure$Measurer basicMeasure$Measurer = constraintWidgetContainer.getMeasurer();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12;
            Object object;
            block11: {
                float f10;
                int n13;
                float f11;
                block10: {
                    int n14;
                    VerticalWidgetRun verticalWidgetRun;
                    Object object2;
                    object = (ConstraintWidget)constraintWidgetContainer.mChildren.get(i10);
                    n12 = object instanceof Guideline;
                    if (n12 != 0 || (n12 = object instanceof Barrier) != 0 || (n12 = ((ConstraintWidget)object).isInVirtualLayout()) != 0) continue;
                    if (bl2 && (object2 = ((ConstraintWidget)object).horizontalRun) != null && (verticalWidgetRun = ((ConstraintWidget)object).verticalRun) != null) {
                        object2 = object2.dimension;
                        n12 = ((DependencyNode)object2).resolved;
                        if (n12 != 0) {
                            object2 = verticalWidgetRun.dimension;
                            n12 = ((DependencyNode)object2).resolved;
                            if (n12 != 0) continue;
                        }
                    }
                    object2 = ((ConstraintWidget)object).getDimensionBehaviour(0);
                    n11 = 1;
                    f11 = Float.MIN_VALUE;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ((ConstraintWidget)object).getDimensionBehaviour(n11);
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (object2 == constraintWidget$DimensionBehaviour2 && (n13 = ((ConstraintWidget)object).mMatchConstraintDefaultWidth) != n11 && constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && (n13 = ((ConstraintWidget)object).mMatchConstraintDefaultHeight) != n11) {
                        n13 = n11;
                        f10 = f11;
                    } else {
                        n13 = 0;
                        f10 = 0.0f;
                    }
                    if (n13 != 0 || (n14 = constraintWidgetContainer.optimizeFor(n11)) == 0 || (n14 = object instanceof VirtualLayout) != 0) break block10;
                    if (object2 == constraintWidget$DimensionBehaviour2 && (n14 = ((ConstraintWidget)object).mMatchConstraintDefaultWidth) == 0 && constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour2 && (n14 = (int)(((ConstraintWidget)object).isInHorizontalChain() ? 1 : 0)) == 0) {
                        n13 = n11;
                        f10 = f11;
                    }
                    if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && (n14 = ((ConstraintWidget)object).mMatchConstraintDefaultHeight) == 0 && object2 != constraintWidget$DimensionBehaviour2 && (n14 = (int)(((ConstraintWidget)object).isInHorizontalChain() ? 1 : 0)) == 0) {
                        n13 = n11;
                        f10 = f11;
                    }
                    if (object2 != constraintWidget$DimensionBehaviour2 && constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour2) break block10;
                    float f12 = ((ConstraintWidget)object).mDimensionRatio;
                    constraintWidget$DimensionBehaviour = null;
                    float f13 = f12 - 0.0f;
                    n12 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                    if (n12 > 0) break block11;
                }
                n11 = n13;
                f11 = f10;
            }
            if (n11 != 0) continue;
            n12 = BasicMeasure$Measure.SELF_DIMENSIONS;
            this.measure(basicMeasure$Measurer, (ConstraintWidget)object, n12);
            object = constraintWidgetContainer.mMetrics;
            if (object == null) continue;
            long l10 = ((Metrics)object).measuredWidgets;
            long l11 = 1L;
            ((Metrics)object).measuredWidgets = l10 += l11;
        }
        basicMeasure$Measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String string2, int n10, int n11) {
        int n12 = constraintWidgetContainer.getMinWidth();
        int n13 = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(n10);
        constraintWidgetContainer.setHeight(n11);
        constraintWidgetContainer.setMinWidth(n12);
        constraintWidgetContainer.setMinHeight(n13);
        this.constraintWidgetContainer.layout();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public long solverMeasure(ConstraintWidgetContainer var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9, int var10_10) {
        block60: {
            block63: {
                block61: {
                    block59: {
                        var11_11 = this;
                        var12_12 = var1_1;
                        var13_13 = var2_2;
                        var14_14 = var5_5;
                        var15_15 = var7_7;
                        var16_16 = var1_1.getMeasurer();
                        var17_17 /* !! */  = var1_1.mChildren;
                        var18_18 = var17_17 /* !! */ .size();
                        var19_19 = var1_1.getWidth();
                        var20_20 = var1_1.getHeight();
                        var21_21 = Optimizer.enabled(var2_2, 128);
                        var22_22 = 0;
                        var23_23 = 0.0f;
                        var24_24 = null;
                        if (var21_21 == 0 && (var13_13 = (int)Optimizer.enabled(var2_2, var25_25 = 64)) == 0) {
                            var13_13 = 0;
                            var26_26 = null;
                        } else {
                            var13_13 = 1;
                        }
                        if (var13_13 == 0) break block59;
                        var27_27 = null;
                        block0: for (var25_25 = 0; var25_25 < var18_18; ++var25_25) {
                            var28_28 = (ConstraintWidget)var12_12.mChildren.get(var25_25);
                            var29_29 = var28_28.getHorizontalDimensionBehaviour();
                            if (var29_29 == (var30_30 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                                var31_31 = 1;
                            } else {
                                var31_31 = 0;
                                var29_29 = null;
                            }
                            var32_32 = var28_28.getVerticalDimensionBehaviour();
                            if (var32_32 == var30_30) {
                                var33_33 = 1;
                                var34_34 = 1.4E-45f;
                            } else {
                                var33_33 = 0;
                                var32_32 = null;
                                var34_34 = 0.0f;
                            }
                            if (var31_31 == 0 || var33_33 == 0) ** GOTO lbl-1000
                            var34_34 = var28_28.getDimensionRatio();
                            var31_31 = 0;
                            var29_29 = null;
                            cfr_temp_0 = var34_34 - 0.0f;
                            var33_33 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
                            if (var33_33 > 0) {
                                var33_33 = 1;
                                var34_34 = 1.4E-45f;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var33_33 = 0;
                                var32_32 = null;
                                var34_34 = 0.0f;
                            }
                            var31_31 = (int)var28_28.isInHorizontalChain();
                            if (var31_31 != 0 && var33_33 != 0) {
                                while (true) {
                                    var13_13 = 0;
                                    var26_26 = null;
                                    break block0;
                                    break;
                                }
                            }
                            if ((var31_31 = (int)var28_28.isInVerticalChain()) != 0 && var33_33 != 0 || (var33_33 = var28_28 instanceof VirtualLayout) != 0 || (var33_33 = (int)var28_28.isInHorizontalChain()) != 0 || (var33_33 = (int)var28_28.isInVerticalChain()) != 0) ** continue;
                        }
                    }
                    var35_35 = 1L;
                    if (var13_13 != 0 && (var28_28 = LinearSystem.sMetrics) != null) {
                        var28_28.measures = var37_36 = var28_28.measures + var35_35;
                    }
                    if (var14_14 == (var39_37 = 0x40000000) && var15_15 == var39_37 || var21_21 != 0) {
                        var31_31 = 1;
                    } else {
                        var31_31 = 0;
                        var29_29 = null;
                    }
                    var13_13 &= var31_31;
                    var31_31 = 2;
                    if (var13_13 != 0) {
                        var40_38 = var1_1.getMaxWidth();
                        var33_33 = var6_6;
                        var33_33 = Math.min(var40_38, var6_6);
                        var25_25 = var1_1.getMaxHeight();
                        var40_38 = var8_8;
                        var25_25 = Math.min(var25_25, var8_8);
                        if (var14_14 == var39_37 && (var40_38 = var1_1.getWidth()) != var33_33) {
                            var12_12.setWidth(var33_33);
                            var1_1.invalidateGraph();
                        }
                        if (var15_15 == var39_37 && (var33_33 = var1_1.getHeight()) != var25_25) {
                            var12_12.setHeight(var25_25);
                            var1_1.invalidateGraph();
                        }
                        if (var14_14 == var39_37 && var15_15 == var39_37) {
                            var21_21 = var12_12.directMeasure((boolean)var21_21);
                            var25_25 = var31_31;
                        } else {
                            var33_33 = (int)var12_12.directMeasureSetup((boolean)var21_21);
                            if (var14_14 == var39_37) {
                                var25_25 = (int)var12_12.directMeasureWithOrientation((boolean)var21_21, 0);
                                var33_33 &= var25_25;
                                var25_25 = 1;
                            } else {
                                var25_25 = 0;
                                var27_27 = null;
                            }
                            if (var15_15 == var39_37) {
                                var40_38 = 1;
                                var21_21 = var12_12.directMeasureWithOrientation((boolean)var21_21, var40_38) & var33_33;
                                ++var25_25;
                            } else {
                                var21_21 = var33_33;
                            }
                        }
                        if (var21_21 != 0) {
                            if (var14_14 == var39_37) {
                                var40_38 = 1;
                            } else {
                                var40_38 = 0;
                                var30_30 = null;
                            }
                            var14_14 = var15_15 == var39_37 ? 1 : 0;
                            var12_12.updateFromRuns((boolean)var40_38, (boolean)var14_14);
                        }
                    } else {
                        var21_21 = 0;
                        var41_39 = null;
                        var25_25 = 0;
                        var27_27 = null;
                    }
                    if (var21_21 != 0 && var25_25 == var31_31) break block60;
                    var14_14 = var1_1.getOptimizationLevel();
                    if (var18_18 > 0) {
                        this.measureChildren(var1_1);
                    }
                    this.updateHierarchy(var1_1);
                    var42_40 = var11_11.mVariableDimensionsWidgets;
                    var15_15 = var42_40.size();
                    if (var18_18 > 0) {
                        var17_17 /* !! */  = "First pass";
                        var11_11.solveLinearSystem(var12_12, (String)var17_17 /* !! */ , var19_19, var20_20);
                    }
                    if (var15_15 <= 0) break block61;
                    var17_17 /* !! */  = var1_1.getHorizontalDimensionBehaviour();
                    if (var17_17 /* !! */  == (var41_39 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                        var40_38 = 1;
                    } else {
                        var40_38 = 0;
                        var30_30 = null;
                    }
                    var17_17 /* !! */  = var1_1.getVerticalDimensionBehaviour();
                    if (var17_17 /* !! */  == var41_39) {
                        var18_18 = 1;
                    } else {
                        var18_18 = 0;
                        var17_17 /* !! */  = null;
                    }
                    var21_21 = var1_1.getWidth();
                    var32_32 = var11_11.constraintWidgetContainer;
                    var33_33 = var32_32.getMinWidth();
                    var21_21 = Math.max(var21_21, var33_33);
                    var33_33 = var1_1.getHeight();
                    var25_25 = var11_11.constraintWidgetContainer.getMinHeight();
                    var33_33 = Math.max(var33_33, var25_25);
                    var27_27 = null;
                    var39_37 = 0;
                    var28_28 = null;
                    for (var25_25 = 0; var25_25 < var15_15; ++var25_25) {
                        var24_24 = (ConstraintWidget)var11_11.mVariableDimensionsWidgets.get(var25_25);
                        var31_31 = var24_24 instanceof VirtualLayout;
                        if (var31_31 == 0) {
                            var5_5 = var14_14;
                            var43_41 = var19_19;
                            var44_42 = var20_20;
                        } else {
                            var31_31 = var24_24.getWidth();
                            var5_5 = var14_14;
                            var14_14 = var24_24.getHeight();
                            var43_41 = var19_19;
                            var19_19 = BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS;
                            var19_19 = var11_11.measure(var16_16, var24_24, var19_19) | var39_37;
                            var28_28 = var12_12.mMetrics;
                            var6_6 = var19_19;
                            var44_42 = var20_20;
                            if (var28_28 != null) {
                                var45_43 = var28_28.measuredMatchWidgets;
                                var47_44 = 1L;
                                var28_28.measuredMatchWidgets = var45_43 += var47_44;
                            }
                            var19_19 = var24_24.getWidth();
                            var20_20 = var24_24.getHeight();
                            if (var19_19 != var31_31) {
                                var24_24.setWidth(var19_19);
                                if (var40_38 && (var19_19 = var24_24.getRight()) > var21_21) {
                                    var19_19 = var24_24.getRight();
                                    var28_28 = ConstraintAnchor$Type.RIGHT;
                                    var28_28 = var24_24.getAnchor((ConstraintAnchor$Type)var28_28);
                                    var39_37 = var28_28.getMargin();
                                    var19_19 += var39_37;
                                    var21_21 = var19_19 = Math.max(var21_21, var19_19);
                                }
                                var19_19 = 1;
                            } else {
                                var19_19 = var6_6;
                            }
                            if (var20_20 != var14_14) {
                                var24_24.setHeight(var20_20);
                                if (var18_18 != 0 && (var14_14 = var24_24.getBottom()) > var33_33) {
                                    var14_14 = var24_24.getBottom();
                                    var49_45 = ConstraintAnchor$Type.BOTTOM;
                                    var49_45 = var24_24.getAnchor((ConstraintAnchor$Type)var49_45);
                                    var19_19 = var49_45.getMargin();
                                    var14_14 += var19_19;
                                    var33_33 = var14_14 = Math.max(var33_33, var14_14);
                                }
                                var19_19 = 1;
                            }
                            var24_24 = (VirtualLayout)var24_24;
                            var14_14 = (int)var24_24.needSolverPass();
                            var39_37 = var19_19 | var14_14;
                        }
                        var14_14 = var5_5;
                        var19_19 = var43_41;
                        var20_20 = var44_42;
                        var22_22 = 0;
                        var23_23 = 0.0f;
                        var24_24 = null;
                        var31_31 = 2;
                    }
                    var5_5 = var14_14;
                    var43_41 = var19_19;
                    var44_42 = var20_20;
                    var19_19 = var31_31;
                    for (var14_14 = 0; var14_14 < var19_19; ++var14_14) {
                        for (var20_20 = 0; var20_20 < var15_15; ++var20_20) {
                            block62: {
                                var24_24 = (ConstraintWidget)var11_11.mVariableDimensionsWidgets.get(var20_20);
                                var25_25 = var24_24 instanceof Helper;
                                if (var25_25 != 0 && (var25_25 = var24_24 instanceof VirtualLayout) == 0 || (var25_25 = var24_24 instanceof Guideline) != 0 || (var25_25 = var24_24.getVisibility()) == (var31_31 = 8)) ** GOTO lbl-1000
                                if (var13_13 == 0) break block62;
                                var27_27 = var24_24.horizontalRun.dimension;
                                var25_25 = (int)var27_27.resolved;
                                if (var25_25 == 0) break block62;
                                var27_27 = var24_24.verticalRun.dimension;
                                var25_25 = (int)var27_27.resolved;
                                if (var25_25 != 0) ** GOTO lbl-1000
                            }
                            if ((var25_25 = var24_24 instanceof VirtualLayout) != 0) lbl-1000:
                            // 3 sources

                            {
                                var50_46 = var13_13;
                                var6_6 = var15_15;
                                var51_47 = var16_16;
                                var52_48 = 1L;
                            } else {
                                var25_25 = var24_24.getWidth();
                                var31_31 = var24_24.getHeight();
                                var19_19 = var24_24.getBaselineDistance();
                                var54_49 = BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS;
                                var50_46 = var13_13;
                                var13_13 = 1;
                                if (var14_14 == var13_13) {
                                    var54_49 = BasicMeasure$Measure.USE_GIVEN_DIMENSIONS;
                                }
                                var13_13 = var54_49;
                                var13_13 = var11_11.measure(var16_16, var24_24, var54_49) | var39_37;
                                var28_28 = var12_12.mMetrics;
                                var6_6 = var15_15;
                                var51_47 = var16_16;
                                if (var28_28 != null) {
                                    var55_50 = var28_28.measuredMatchWidgets;
                                    var52_48 = 1L;
                                    var28_28.measuredMatchWidgets = var55_50 += var52_48;
                                } else {
                                    var52_48 = 1L;
                                }
                                var15_15 = var24_24.getWidth();
                                var57_51 = var24_24.getHeight();
                                if (var15_15 != var25_25) {
                                    var24_24.setWidth(var15_15);
                                    if (var40_38 && (var13_13 = var24_24.getRight()) > var21_21) {
                                        var13_13 = var24_24.getRight();
                                        var42_40 = ConstraintAnchor$Type.RIGHT;
                                        var42_40 = var24_24.getAnchor((ConstraintAnchor$Type)var42_40);
                                        var15_15 = var42_40.getMargin();
                                        var21_21 = Math.max(var21_21, var13_13 += var15_15);
                                    }
                                    var13_13 = 1;
                                }
                                if (var57_51 != var31_31) {
                                    var24_24.setHeight(var57_51);
                                    if (var18_18 != 0 && (var13_13 = var24_24.getBottom()) > var33_33) {
                                        var13_13 = var24_24.getBottom();
                                        var42_40 = ConstraintAnchor$Type.BOTTOM;
                                        var42_40 = var24_24.getAnchor((ConstraintAnchor$Type)var42_40);
                                        var15_15 = var42_40.getMargin();
                                        var13_13 += var15_15;
                                        var33_33 = var13_13 = Math.max(var33_33, var13_13);
                                    }
                                    var13_13 = 1;
                                }
                                var39_37 = (var15_15 = (int)var24_24.hasBaseline()) != 0 && var19_19 != (var15_15 = var24_24.getBaselineDistance()) ? 1 : var13_13;
                            }
                            var15_15 = var6_6;
                            var16_16 = var51_47;
                            var13_13 = var50_46;
                            var19_19 = 2;
                        }
                        var50_46 = var13_13;
                        var6_6 = var15_15;
                        var51_47 = var16_16;
                        var52_48 = 1L;
                        if (var39_37 == 0) break;
                        var26_26 = "intermediate pass";
                        var15_15 = var43_41;
                        var57_51 = var44_42;
                        var11_11.solveLinearSystem(var12_12, var26_26, var43_41, var44_42);
                        var19_19 = 2;
                        var39_37 = 0;
                        var28_28 = null;
                        var15_15 = var6_6;
                    }
                    var15_15 = var43_41;
                    var57_51 = var44_42;
                    if (var39_37 != 0) {
                        var26_26 = "2nd pass";
                        var11_11.solveLinearSystem(var12_12, var26_26, var43_41, var44_42);
                        var13_13 = var1_1.getWidth();
                        if (var13_13 < var21_21) {
                            var12_12.setWidth(var21_21);
                            var22_22 = 1;
                            var23_23 = 1.4E-45f;
                        } else {
                            var22_22 = 0;
                            var23_23 = 0.0f;
                            var24_24 = null;
                        }
                        var13_13 = var1_1.getHeight();
                        if (var13_13 < var33_33) {
                            var12_12.setHeight(var33_33);
                            var33_33 = 1;
                            var34_34 = 1.4E-45f;
                        } else {
                            var33_33 = var22_22;
                            var34_34 = var23_23;
                        }
                        if (var33_33 != 0) {
                            var26_26 = "3rd pass";
                            var11_11.solveLinearSystem(var12_12, var26_26, var15_15, var57_51);
                        }
                    }
                    var13_13 = var5_5;
                    break block63;
                }
                var13_13 = var14_14;
            }
            var12_12.setOptimizationLevel(var13_13);
        }
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        ArrayList arrayList = constraintWidgetContainer.mChildren;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            ConstraintWidget constraintWidget = (ConstraintWidget)constraintWidgetContainer.mChildren.get(i10);
            Object object = constraintWidget.getHorizontalDimensionBehaviour();
            if (object != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && (object = constraintWidget.getVerticalDimensionBehaviour()) != constraintWidget$DimensionBehaviour) continue;
            object = this.mVariableDimensionsWidgets;
            ((ArrayList)object).add(constraintWidget);
        }
        constraintWidgetContainer.invalidateGraph();
    }
}

