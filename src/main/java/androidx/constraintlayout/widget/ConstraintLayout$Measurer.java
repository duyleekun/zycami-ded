/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 */
package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$1;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.ArrayList;

public class ConstraintLayout$Measurer
implements BasicMeasure$Measurer {
    public ConstraintLayout layout;
    public int layoutHeightSpec;
    public int layoutWidthSpec;
    public int paddingBottom;
    public int paddingHeight;
    public int paddingTop;
    public int paddingWidth;
    public final /* synthetic */ ConstraintLayout this$0;

    public ConstraintLayout$Measurer(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.this$0 = constraintLayout;
        this.layout = constraintLayout2;
    }

    private boolean isSimilarSpec(int n10, int n11, int n12) {
        boolean bl2 = true;
        if (n10 == n11) {
            return bl2;
        }
        int n13 = View.MeasureSpec.getMode((int)n10);
        View.MeasureSpec.getSize((int)n10);
        n10 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        int n14 = 0x40000000;
        if (n10 == n14 && (n13 == (n10 = -1 << -1) || n13 == 0) && n12 == n11) {
            return bl2;
        }
        return false;
    }

    public void captureLayoutInfos(int n10, int n11, int n12, int n13, int n14, int n15) {
        this.paddingTop = n12;
        this.paddingBottom = n13;
        this.paddingWidth = n14;
        this.paddingHeight = n15;
        this.layoutWidthSpec = n10;
        this.layoutHeightSpec = n11;
    }

    public final void didMeasures() {
        Object object;
        Object object2 = this.layout;
        int n10 = object2.getChildCount();
        int n11 = 0;
        ConstraintHelper constraintHelper = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object = this.layout.getChildAt(i10);
            boolean bl2 = object instanceof Placeholder;
            if (!bl2) continue;
            object = (Placeholder)((Object)object);
            ConstraintLayout constraintLayout = this.layout;
            object.updatePostMeasure(constraintLayout);
        }
        object2 = ConstraintLayout.access$100(this.layout);
        n10 = ((ArrayList)object2).size();
        if (n10 > 0) {
            while (n11 < n10) {
                constraintHelper = (ConstraintHelper)((Object)ConstraintLayout.access$100(this.layout).get(n11));
                object = this.layout;
                constraintHelper.updatePostMeasure((ConstraintLayout)((Object)object));
                ++n11;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void measure(ConstraintWidget var1_1, BasicMeasure$Measure var2_2) {
        block74: {
            var3_3 = this;
            var4_4 = var1_1;
            var5_5 = var2_2;
            if (var1_1 == null) {
                return;
            }
            var6_6 = var1_1.getVisibility();
            var7_7 = 8;
            var8_8 = 1.1E-44f;
            var9_9 = 0;
            var10_10 = 0.0f;
            if (var6_6 == var7_7 && (var6_6 = (int)var1_1.isInPlaceholder()) == 0) {
                var2_2.measuredWidth = 0;
                var2_2.measuredHeight = 0;
                var2_2.measuredBaseline = 0;
                return;
            }
            var11_11 = var1_1.getParent();
            if (var11_11 == null) {
                return;
            }
            var11_11 = var5_5.horizontalBehavior;
            var12_12 = var5_5.verticalBehavior;
            var13_13 = var5_5.horizontalDimension;
            var14_14 = var5_5.verticalDimension;
            var15_15 = var3_3.paddingTop;
            var16_16 = var3_3.paddingBottom;
            var15_15 += var16_16;
            var16_16 = var3_3.paddingWidth;
            var17_17 = (View)var1_1.getCompanionWidget();
            var18_18 /* !! */  = ConstraintLayout$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            var19_19 = var11_11.ordinal();
            var19_19 = var18_18 /* !! */ [var19_19];
            var20_20 = 4;
            var21_21 = 5.6E-45f;
            var22_22 = 3;
            var23_23 = 2;
            var9_9 = 1;
            var10_10 = 1.4E-45f;
            if (var19_19 != var9_9) {
                if (var19_19 != var23_23) {
                    if (var19_19 != var22_22) {
                        if (var19_19 != var20_20) {
                            var13_13 = 0;
                            var24_24 = null;
                        } else {
                            var13_13 = var3_3.layoutWidthSpec;
                            var19_19 = -2;
                            var25_25 = 0.0f / 0.0f;
                            var13_13 = ViewGroup.getChildMeasureSpec((int)var13_13, (int)var16_16, (int)var19_19);
                            var16_16 = var4_4.mMatchConstraintDefaultWidth;
                            if (var16_16 == var9_9) {
                                var16_16 = var9_9;
                            } else {
                                var16_16 = 0;
                                var26_26 = null;
                            }
                            var19_19 = var5_5.measureStrategy;
                            var20_20 = BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS;
                            if (var19_19 == var20_20 || var19_19 == (var20_20 = BasicMeasure$Measure.USE_GIVEN_DIMENSIONS)) {
                                var19_19 = var17_17.getMeasuredHeight();
                                if (var19_19 == (var20_20 = var1_1.getHeight())) {
                                    var19_19 = var9_9;
                                    var25_25 = var10_10;
                                } else {
                                    var19_19 = 0;
                                    var25_25 = 0.0f;
                                    var27_27 = null;
                                }
                                var20_20 = var5_5.measureStrategy;
                                var22_22 = BasicMeasure$Measure.USE_GIVEN_DIMENSIONS;
                                if (var20_20 != var22_22 && var16_16 != 0 && (var16_16 == 0 || var19_19 == 0) && (var16_16 = var17_17 instanceof Placeholder) == 0 && (var16_16 = (int)var1_1.isResolvedHorizontally()) == 0) {
                                    var16_16 = 0;
                                    var26_26 = null;
                                } else {
                                    var16_16 = var9_9;
                                }
                                if (var16_16 != 0) {
                                    var13_13 = var1_1.getWidth();
                                    var16_16 = 0x40000000;
                                    var13_13 = View.MeasureSpec.makeMeasureSpec((int)var13_13, (int)var16_16);
                                }
                            }
                        }
                    } else {
                        var13_13 = var3_3.layoutWidthSpec;
                        var19_19 = var1_1.getHorizontalMargin();
                        var16_16 += var19_19;
                        var19_19 = -1;
                        var25_25 = 0.0f / 0.0f;
                        var13_13 = ViewGroup.getChildMeasureSpec((int)var13_13, (int)var16_16, (int)var19_19);
                    }
                } else {
                    var13_13 = var3_3.layoutWidthSpec;
                    var19_19 = -2;
                    var25_25 = 0.0f / 0.0f;
                    var13_13 = ViewGroup.getChildMeasureSpec((int)var13_13, (int)var16_16, (int)var19_19);
                }
            } else {
                var16_16 = 0x40000000;
                var13_13 = View.MeasureSpec.makeMeasureSpec((int)var13_13, (int)var16_16);
            }
            var16_16 = var12_12.ordinal();
            var16_16 = var18_18 /* !! */ [var16_16];
            if (var16_16 != var9_9) {
                if (var16_16 != var23_23) {
                    var14_14 = 3;
                    if (var16_16 != var14_14) {
                        var14_14 = 4;
                        if (var16_16 != var14_14) {
                            var14_14 = 0;
                        } else {
                            var14_14 = var3_3.layoutHeightSpec;
                            var16_16 = -2;
                            var14_14 = ViewGroup.getChildMeasureSpec((int)var14_14, (int)var15_15, (int)var16_16);
                            var15_15 = var4_4.mMatchConstraintDefaultHeight;
                            if (var15_15 == var9_9) {
                                var15_15 = var9_9;
                            } else {
                                var15_15 = 0;
                                var28_28 = null;
                            }
                            var16_16 = var5_5.measureStrategy;
                            var29_29 = BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS;
                            if (var16_16 == var29_29 || var16_16 == (var29_29 = BasicMeasure$Measure.USE_GIVEN_DIMENSIONS)) {
                                var16_16 = var17_17.getMeasuredWidth();
                                if (var16_16 == (var29_29 = var1_1.getWidth())) {
                                    var16_16 = var9_9;
                                } else {
                                    var16_16 = 0;
                                    var26_26 = null;
                                }
                                var29_29 = var5_5.measureStrategy;
                                var19_19 = BasicMeasure$Measure.USE_GIVEN_DIMENSIONS;
                                if (var29_29 != var19_19 && var15_15 != 0 && (var15_15 == 0 || var16_16 == 0) && (var15_15 = var17_17 instanceof Placeholder) == 0 && (var15_15 = (int)var1_1.isResolvedVertically()) == 0) {
                                    var15_15 = 0;
                                    var28_28 = null;
                                } else {
                                    var15_15 = var9_9;
                                }
                                if (var15_15 != 0) {
                                    var14_14 = var1_1.getHeight();
                                    var15_15 = 0x40000000;
                                    var14_14 = View.MeasureSpec.makeMeasureSpec((int)var14_14, (int)var15_15);
                                }
                            }
                        }
                    } else {
                        var14_14 = var3_3.layoutHeightSpec;
                        var16_16 = var1_1.getVerticalMargin();
                        var15_15 += var16_16;
                        var16_16 = -1;
                        var14_14 = ViewGroup.getChildMeasureSpec((int)var14_14, (int)var15_15, (int)var16_16);
                    }
                } else {
                    var14_14 = var3_3.layoutHeightSpec;
                    var16_16 = -2;
                    var14_14 = ViewGroup.getChildMeasureSpec((int)var14_14, (int)var15_15, (int)var16_16);
                }
            } else {
                var15_15 = 0x40000000;
                var14_14 = View.MeasureSpec.makeMeasureSpec((int)var14_14, (int)var15_15);
            }
            var28_28 = (ConstraintWidgetContainer)var1_1.getParent();
            if (var28_28 == null) break block74;
            var26_26 = var3_3.this$0;
            var16_16 = ConstraintLayout.access$000((ConstraintLayout)var26_26);
            var29_29 = 256;
            if ((var16_16 = (int)Optimizer.enabled(var16_16, var29_29)) == 0 || (var16_16 = var17_17.getMeasuredWidth()) != (var29_29 = var1_1.getWidth()) || (var16_16 = var17_17.getMeasuredWidth()) >= (var29_29 = var28_28.getWidth()) || (var16_16 = var17_17.getMeasuredHeight()) != (var29_29 = var1_1.getHeight()) || (var16_16 = var17_17.getMeasuredHeight()) >= (var15_15 = var28_28.getHeight()) || (var15_15 = var17_17.getBaseline()) != (var16_16 = var1_1.getBaselineDistance()) || (var15_15 = (int)var1_1.isMeasureRequested()) != 0) break block74;
            var15_15 = var1_1.getLastHorizontalMeasureSpec();
            var16_16 = var1_1.getWidth();
            if ((var15_15 = (int)var3_3.isSimilarSpec(var15_15, var13_13, var16_16)) == 0) ** GOTO lbl-1000
            var15_15 = var1_1.getLastVerticalMeasureSpec();
            var16_16 = var1_1.getHeight();
            if ((var15_15 = (int)var3_3.isSimilarSpec(var15_15, var14_14, var16_16)) != 0) {
                var15_15 = var9_9;
            } else lbl-1000:
            // 2 sources

            {
                var15_15 = 0;
                var28_28 = null;
            }
            if (var15_15 != 0) {
                var5_5.measuredWidth = var6_6 = var1_1.getWidth();
                var5_5.measuredHeight = var6_6 = var1_1.getHeight();
                var5_5.measuredBaseline = var30_30 = var1_1.getBaselineDistance();
                return;
            }
        }
        if (var11_11 == (var28_28 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
            var16_16 = var9_9;
        } else {
            var16_16 = 0;
            var26_26 = null;
        }
        if (var12_12 == var28_28) {
            var15_15 = var9_9;
        } else {
            var15_15 = 0;
            var28_28 = null;
        }
        var18_18 /* !! */  = (int[])ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
        if (var12_12 != var18_18 /* !! */  && var12_12 != (var27_27 = ConstraintWidget$DimensionBehaviour.FIXED)) {
            var7_7 = 0;
            var8_8 = 0.0f;
            var12_12 = null;
        } else {
            var7_7 = var9_9;
            var8_8 = var10_10;
        }
        if (var11_11 != var18_18 /* !! */  && var11_11 != (var18_18 /* !! */  = (int[])ConstraintWidget$DimensionBehaviour.FIXED)) {
            var6_6 = 0;
            var31_32 = 0.0f;
            var11_11 = null;
        } else {
            var6_6 = var9_9;
            var31_32 = var10_10;
        }
        var29_29 = 0;
        var18_18 /* !! */  = null;
        if (var16_16 != 0 && (var19_19 = (int)((cfr_temp_0 = (var25_25 = var4_4.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1))) > 0) {
            var19_19 = var9_9;
            var25_25 = var10_10;
        } else {
            var19_19 = 0;
            var25_25 = 0.0f;
            var27_27 = null;
        }
        if (var15_15 != 0 && (var29_29 = (int)((cfr_temp_1 = (var21_21 = var4_4.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) > 0) {
            var29_29 = var9_9;
        } else {
            var29_29 = 0;
            var18_18 /* !! */  = null;
        }
        if (var17_17 == null) {
            return;
        }
        var32_33 = (ConstraintLayout$LayoutParams)var17_17.getLayoutParams();
        var22_22 = var5_5.measureStrategy;
        var23_23 = BasicMeasure$Measure.TRY_GIVEN_DIMENSIONS;
        if (var22_22 != var23_23 && var22_22 != (var23_23 = BasicMeasure$Measure.USE_GIVEN_DIMENSIONS) && var16_16 != 0 && (var16_16 = var4_4.mMatchConstraintDefaultWidth) == 0 && var15_15 != 0 && (var15_15 = var4_4.mMatchConstraintDefaultHeight) == 0) {
            var33_34 = -1;
            var34_35 = 0.0f / 0.0f;
            var9_9 = 0;
            var10_10 = 0.0f;
            var22_22 = 0;
            var23_23 = 0;
        } else {
            var15_15 = var17_17 instanceof VirtualLayout;
            if (var15_15 != 0 && (var15_15 = var4_4 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) != 0) {
                var28_28 = var4_4;
                var28_28 = (androidx.constraintlayout.solver.widgets.VirtualLayout)var4_4;
                var26_26 = var17_17;
                var26_26 = (VirtualLayout)var17_17;
                var26_26.onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout)var28_28, var13_13, var14_14);
            } else {
                var17_17.measure(var13_13, var14_14);
            }
            var4_4.setLastMeasureSpec(var13_13, var14_14);
            var15_15 = var17_17.getMeasuredWidth();
            var16_16 = var17_17.getMeasuredHeight();
            var22_22 = var17_17.getBaseline();
            var23_23 = var4_4.mMatchConstraintMinWidth;
            var23_23 = var23_23 > 0 ? Math.max(var23_23, var15_15) : var15_15;
            var9_9 = var4_4.mMatchConstraintMaxWidth;
            if (var9_9 > 0) {
                var23_23 = Math.min(var9_9, var23_23);
            }
            if ((var9_9 = var4_4.mMatchConstraintMinHeight) > 0) {
                var9_9 = Math.max(var9_9, var16_16);
                var35_36 = var13_13;
            } else {
                var35_36 = var13_13;
                var9_9 = var16_16;
            }
            var13_13 = var4_4.mMatchConstraintMaxHeight;
            if (var13_13 > 0) {
                var9_9 = Math.min(var13_13, var9_9);
            }
            var24_24 = var3_3.this$0;
            var13_13 = ConstraintLayout.access$000(var24_24);
            var33_34 = 1;
            var34_35 = 1.4E-45f;
            if ((var13_13 = (int)Optimizer.enabled(var13_13, var33_34)) == 0) {
                var33_34 = 0x3F000000;
                var34_35 = 0.5f;
                if (var19_19 != 0 && var7_7 != 0) {
                    var31_32 = var4_4.mDimensionRatio;
                    var8_8 = (float)var9_9 * var31_32 + var34_35;
                    var23_23 = (int)var8_8;
                } else if (var29_29 != 0 && var6_6 != 0) {
                    var31_32 = var4_4.mDimensionRatio;
                    var8_8 = (float)var23_23 / var31_32 + var34_35;
                    var9_9 = (int)var8_8;
                }
            }
            if (var15_15 == var23_23 && var16_16 == var9_9) lbl-1000:
            // 2 sources

            {
                while (true) {
                    var33_34 = -1;
                    var34_35 = 0.0f / 0.0f;
                    break;
                }
            } else {
                var33_34 = 0x40000000;
                var34_35 = 2.0f;
                var13_13 = var15_15 != var23_23 ? View.MeasureSpec.makeMeasureSpec((int)var23_23, (int)var33_34) : var35_36;
                if (var16_16 != var9_9) {
                    var14_14 = View.MeasureSpec.makeMeasureSpec((int)var9_9, (int)var33_34);
                }
                var17_17.measure(var13_13, var14_14);
                var4_4.setLastMeasureSpec(var13_13, var14_14);
                var23_23 = var17_17.getMeasuredWidth();
                var9_9 = var17_17.getMeasuredHeight();
                var22_22 = var17_17.getBaseline();
                ** continue;
            }
        }
        if (var22_22 != var33_34) {
            var33_34 = 1;
            var34_35 = 1.4E-45f;
        } else {
            var33_34 = 0;
            var34_35 = 0.0f;
            var3_3 = null;
        }
        var6_6 = var5_5.horizontalDimension;
        if (var23_23 == var6_6 && var9_9 == (var6_6 = var5_5.verticalDimension)) {
            var6_6 = 0;
            var31_32 = 0.0f;
            var11_11 = null;
        } else {
            var6_6 = 1;
            var31_32 = 1.4E-45f;
        }
        var5_5.measuredNeedsSolverPass = var6_6;
        var6_6 = (int)var32_33.needsBaseline;
        if (var6_6 != 0) {
            var33_34 = 1;
            var34_35 = 1.4E-45f;
        }
        if (var33_34 != 0) {
            var6_6 = -1;
            var31_32 = 0.0f / 0.0f;
            if (var22_22 != var6_6 && (var30_31 = var1_1.getBaselineDistance()) != var22_22) {
                var30_31 = 1;
                var5_5.measuredNeedsSolverPass = var30_31;
            }
        }
        var5_5.measuredWidth = var23_23;
        var5_5.measuredHeight = var9_9;
        var5_5.measuredHasBaseline = var33_34;
        var5_5.measuredBaseline = var22_22;
    }
}

