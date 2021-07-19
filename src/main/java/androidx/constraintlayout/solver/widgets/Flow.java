/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow$WidgetsList;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Flow
extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE;
    private ConstraintWidget[] mAlignedBiggestElementsInCols;
    private ConstraintWidget[] mAlignedBiggestElementsInRows;
    private int[] mAlignedDimensions;
    private ArrayList mChainList;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount;
    private float mFirstHorizontalBias;
    private int mFirstHorizontalStyle;
    private float mFirstVerticalBias;
    private int mFirstVerticalStyle;
    private int mHorizontalAlign;
    private float mHorizontalBias;
    private int mHorizontalGap;
    private int mHorizontalStyle;
    private float mLastHorizontalBias;
    private int mLastHorizontalStyle;
    private float mLastVerticalBias;
    private int mLastVerticalStyle;
    private int mMaxElementsWrap;
    private int mOrientation;
    private int mVerticalAlign;
    private float mVerticalBias;
    private int mVerticalGap;
    private int mVerticalStyle;
    private int mWrapMode;

    public Flow() {
        ArrayList arrayList;
        int n10;
        float f10;
        int n11;
        this.mHorizontalStyle = n11 = -1;
        this.mVerticalStyle = n11;
        this.mFirstHorizontalStyle = n11;
        this.mFirstVerticalStyle = n11;
        this.mLastHorizontalStyle = n11;
        this.mLastVerticalStyle = n11;
        this.mHorizontalBias = f10 = 0.5f;
        this.mVerticalBias = f10;
        this.mFirstHorizontalBias = f10;
        this.mFirstVerticalBias = f10;
        this.mLastHorizontalBias = f10;
        this.mLastVerticalBias = f10;
        this.mHorizontalGap = 0;
        this.mVerticalGap = 0;
        this.mHorizontalAlign = n10 = 2;
        this.mVerticalAlign = n10;
        this.mWrapMode = 0;
        this.mMaxElementsWrap = n11;
        this.mOrientation = 0;
        this.mChainList = arrayList = new ArrayList();
        this.mAlignedBiggestElementsInRows = null;
        this.mAlignedBiggestElementsInCols = null;
        this.mAlignedDimensions = null;
        this.mDisplayedWidgetsCount = 0;
    }

    public static /* synthetic */ int access$000(Flow flow) {
        return flow.mHorizontalGap;
    }

    public static /* synthetic */ int access$100(Flow flow) {
        return flow.mVerticalGap;
    }

    public static /* synthetic */ int access$1000(Flow flow) {
        return flow.mFirstHorizontalStyle;
    }

    public static /* synthetic */ float access$1100(Flow flow) {
        return flow.mFirstHorizontalBias;
    }

    public static /* synthetic */ int access$1200(Flow flow) {
        return flow.mLastHorizontalStyle;
    }

    public static /* synthetic */ float access$1300(Flow flow) {
        return flow.mLastHorizontalBias;
    }

    public static /* synthetic */ float access$1400(Flow flow) {
        return flow.mVerticalBias;
    }

    public static /* synthetic */ int access$1500(Flow flow) {
        return flow.mFirstVerticalStyle;
    }

    public static /* synthetic */ float access$1600(Flow flow) {
        return flow.mFirstVerticalBias;
    }

    public static /* synthetic */ int access$1700(Flow flow) {
        return flow.mLastVerticalStyle;
    }

    public static /* synthetic */ float access$1800(Flow flow) {
        return flow.mLastVerticalBias;
    }

    public static /* synthetic */ int access$1900(Flow flow) {
        return flow.mHorizontalAlign;
    }

    public static /* synthetic */ int access$200(Flow flow, ConstraintWidget constraintWidget, int n10) {
        return flow.getWidgetWidth(constraintWidget, n10);
    }

    public static /* synthetic */ int access$300(Flow flow, ConstraintWidget constraintWidget, int n10) {
        return flow.getWidgetHeight(constraintWidget, n10);
    }

    public static /* synthetic */ int access$400(Flow flow) {
        return flow.mDisplayedWidgetsCount;
    }

    public static /* synthetic */ ConstraintWidget[] access$500(Flow flow) {
        return flow.mDisplayedWidgets;
    }

    public static /* synthetic */ int access$600(Flow flow) {
        return flow.mVerticalStyle;
    }

    public static /* synthetic */ int access$700(Flow flow) {
        return flow.mVerticalAlign;
    }

    public static /* synthetic */ int access$800(Flow flow) {
        return flow.mHorizontalStyle;
    }

    public static /* synthetic */ float access$900(Flow flow) {
        return flow.mHorizontalBias;
    }

    private void createAlignedConstraints(boolean n10) {
        Object[] objectArray = this.mAlignedDimensions;
        if (objectArray != null && (objectArray = (Object[])this.mAlignedBiggestElementsInCols) != null && (objectArray = (Object[])this.mAlignedBiggestElementsInRows) != null) {
            int n11;
            int n12;
            Object object;
            int n13;
            Object object2;
            int n14;
            int n15;
            int n16;
            objectArray = null;
            int[] nArray = null;
            for (n16 = 0; n16 < (n15 = this.mDisplayedWidgetsCount); ++n16) {
                ConstraintWidget constraintWidget = this.mDisplayedWidgets[n16];
                constraintWidget.resetAnchors();
            }
            nArray = this.mAlignedDimensions;
            n15 = nArray[0];
            int n17 = 1;
            n16 = nArray[n17];
            int n18 = 0;
            Object object3 = null;
            int n19 = 0;
            ConstraintWidget constraintWidget = null;
            while (true) {
                n14 = 8;
                float f10 = 1.1E-44f;
                if (n19 >= n15) break;
                object2 = this.mAlignedBiggestElementsInCols;
                n13 = n10 != 0 ? n15 - n19 - n17 : n19;
                object = object2[n13];
                if (object != null && (n12 = object.getVisibility()) != n14) {
                    ConstraintAnchor constraintAnchor;
                    if (n19 == 0) {
                        constraintAnchor = object.mLeft;
                        object2 = this.mLeft;
                        n11 = this.getPaddingLeft();
                        object.connect(constraintAnchor, (ConstraintAnchor)object2, n11);
                        n14 = this.mHorizontalStyle;
                        object.setHorizontalChainStyle(n14);
                        f10 = this.mHorizontalBias;
                        object.setHorizontalBiasPercent(f10);
                    }
                    if (n19 == (n14 = n15 + -1)) {
                        constraintAnchor = object.mRight;
                        object2 = this.mRight;
                        n11 = this.getPaddingRight();
                        object.connect(constraintAnchor, (ConstraintAnchor)object2, n11);
                    }
                    if (n19 > 0) {
                        constraintAnchor = object.mLeft;
                        object2 = ((ConstraintWidget)object3).mRight;
                        n11 = this.mHorizontalGap;
                        object.connect(constraintAnchor, (ConstraintAnchor)object2, n11);
                        constraintAnchor = ((ConstraintWidget)object3).mRight;
                        object2 = object.mLeft;
                        ((ConstraintWidget)object3).connect(constraintAnchor, (ConstraintAnchor)object2, 0);
                    }
                    object3 = object;
                }
                ++n19;
            }
            for (n10 = 0; n10 < n16; ++n10) {
                constraintWidget = this.mAlignedBiggestElementsInRows[n10];
                if (constraintWidget == null || (n13 = constraintWidget.getVisibility()) == n14) continue;
                if (n10 == 0) {
                    object = constraintWidget.mTop;
                    object2 = this.mTop;
                    n11 = this.getPaddingTop();
                    constraintWidget.connect((ConstraintAnchor)object, (ConstraintAnchor)object2, n11);
                    n13 = this.mVerticalStyle;
                    constraintWidget.setVerticalChainStyle(n13);
                    float f11 = this.mVerticalBias;
                    constraintWidget.setVerticalBiasPercent(f11);
                }
                if (n10 == (n13 = n16 + -1)) {
                    object = constraintWidget.mBottom;
                    object2 = this.mBottom;
                    n11 = this.getPaddingBottom();
                    constraintWidget.connect((ConstraintAnchor)object, (ConstraintAnchor)object2, n11);
                }
                if (n10 > 0) {
                    object = constraintWidget.mTop;
                    object2 = ((ConstraintWidget)object3).mBottom;
                    n11 = this.mVerticalGap;
                    constraintWidget.connect((ConstraintAnchor)object, (ConstraintAnchor)object2, n11);
                    object = ((ConstraintWidget)object3).mBottom;
                    object2 = constraintWidget.mTop;
                    ((ConstraintWidget)object3).connect((ConstraintAnchor)object, (ConstraintAnchor)object2, 0);
                }
                object3 = constraintWidget;
            }
            for (n10 = 0; n10 < n15; ++n10) {
                object3 = null;
                for (n18 = 0; n18 < n16; ++n18) {
                    ConstraintAnchor constraintAnchor;
                    n19 = n18 * n15 + n10;
                    n13 = this.mOrientation;
                    if (n13 == n17) {
                        n19 = n10 * n16 + n18;
                    }
                    if (n19 >= (n12 = ((ConstraintWidget[])(object = this.mDisplayedWidgets)).length) || (constraintWidget = object[n19]) == null || (n13 = constraintWidget.getVisibility()) == n14) continue;
                    object = this.mAlignedBiggestElementsInCols[n10];
                    object2 = this.mAlignedBiggestElementsInRows[n18];
                    if (constraintWidget != object) {
                        constraintAnchor = constraintWidget.mLeft;
                        ConstraintAnchor constraintAnchor2 = object.mLeft;
                        constraintWidget.connect(constraintAnchor, constraintAnchor2, 0);
                        constraintAnchor = constraintWidget.mRight;
                        object = object.mRight;
                        constraintWidget.connect(constraintAnchor, (ConstraintAnchor)object, 0);
                    }
                    if (constraintWidget == object2) continue;
                    object = constraintWidget.mTop;
                    constraintAnchor = object2.mTop;
                    constraintWidget.connect((ConstraintAnchor)object, constraintAnchor, 0);
                    object = constraintWidget.mBottom;
                    object2 = object2.mBottom;
                    constraintWidget.connect((ConstraintAnchor)object, (ConstraintAnchor)object2, 0);
                }
            }
        }
    }

    private final int getWidgetHeight(ConstraintWidget constraintWidget, int n10) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        int n11 = 0;
        float f10 = 0.0f;
        if (constraintWidget == null) {
            return 0;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget.getVerticalDimensionBehaviour();
        if (constraintWidget$DimensionBehaviour2 == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
            int n12 = constraintWidget.mMatchConstraintDefaultHeight;
            if (!n12) {
                return 0;
            }
            n11 = 2;
            f10 = 2.8E-45f;
            int n13 = 1;
            if (n12 == n11) {
                f10 = constraintWidget.mMatchConstraintPercentHeight;
                float f11 = n10;
                n11 = constraintWidget.getHeight();
                if ((n10 = (int)(f10 *= f11)) != n11) {
                    constraintWidget.setMeasureRequested(n13 != 0);
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = constraintWidget.getHorizontalDimensionBehaviour();
                    int n14 = constraintWidget.getWidth();
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.FIXED;
                    this.measure(constraintWidget, constraintWidget$DimensionBehaviour3, n14, constraintWidget$DimensionBehaviour4, n10);
                }
                return n10;
            }
            if (n12 == n13) {
                return constraintWidget.getHeight();
            }
            n10 = 3;
            float f12 = 4.2E-45f;
            if (n12 == n10) {
                f12 = constraintWidget.getWidth();
                float f13 = constraintWidget.mDimensionRatio;
                return (int)(f12 * f13 + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    private final int getWidgetWidth(ConstraintWidget constraintWidget, int n10) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        int n11 = 0;
        float f10 = 0.0f;
        if (constraintWidget == null) {
            return 0;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget.getHorizontalDimensionBehaviour();
        if (constraintWidget$DimensionBehaviour2 == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
            int n12 = constraintWidget.mMatchConstraintDefaultWidth;
            if (!n12) {
                return 0;
            }
            n11 = 2;
            f10 = 2.8E-45f;
            int n13 = 1;
            if (n12 == n11) {
                f10 = constraintWidget.mMatchConstraintPercentWidth;
                float f11 = n10;
                n11 = constraintWidget.getWidth();
                if ((n10 = (int)(f10 *= f11)) != n11) {
                    constraintWidget.setMeasureRequested(n13 != 0);
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.FIXED;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = constraintWidget.getVerticalDimensionBehaviour();
                    int n14 = constraintWidget.getHeight();
                    this.measure(constraintWidget, constraintWidget$DimensionBehaviour3, n10, constraintWidget$DimensionBehaviour4, n14);
                }
                return n10;
            }
            if (n12 == n13) {
                return constraintWidget.getWidth();
            }
            n10 = 3;
            float f12 = 4.2E-45f;
            if (n12 == n10) {
                f12 = constraintWidget.getHeight();
                float f13 = constraintWidget.mDimensionRatio;
                return (int)(f12 * f13 + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void measureAligned(ConstraintWidget[] var1_1, int var2_2, int var3_3, int var4_4, int[] var5_5) {
        var6_6 = this;
        var7_7 /* !! */  = var1_1;
        var8_8 = var2_2;
        var9_9 = var3_3;
        var10_10 = var4_4;
        if (var3_3 == 0) {
            var11_11 = this.mMaxElementsWrap;
            if (var11_11 <= 0) {
                var11_11 = 0;
                var12_12 = 0.0f;
                var14_14 = 0.0f;
                var15_15 = 0;
                var16_16 = null;
                for (var13_13 = 0; var13_13 < var8_8; ++var13_13) {
                    if (var13_13 > 0) {
                        var17_17 = var6_6.mHorizontalGap;
                        var15_15 += var17_17;
                    }
                    if ((var18_18 = var7_7 /* !! */ [var13_13]) == null) continue;
                    var17_17 = var6_6.getWidgetWidth(var18_18, var10_10);
                    if ((var15_15 += var17_17) > var10_10) break;
                    ++var11_11;
                }
            }
            var13_13 = var11_11;
            var11_11 = 0;
            var12_12 = 0.0f;
        } else {
            var11_11 = this.mMaxElementsWrap;
            if (var11_11 <= 0) {
                var11_11 = 0;
                var12_12 = 0.0f;
                var14_14 = 0.0f;
                var15_15 = 0;
                var16_16 = null;
                for (var13_13 = 0; var13_13 < var8_8; ++var13_13) {
                    if (var13_13 > 0) {
                        var17_17 = var6_6.mVerticalGap;
                        var15_15 += var17_17;
                    }
                    if ((var18_18 = var7_7 /* !! */ [var13_13]) == null) continue;
                    var17_17 = var6_6.getWidgetHeight(var18_18, var10_10);
                    if ((var15_15 += var17_17) > var10_10) break;
                    ++var11_11;
                }
            }
            var13_13 = 0;
            var14_14 = 0.0f;
        }
        var16_16 = var6_6.mAlignedDimensions;
        if (var16_16 == null) {
            var15_15 = 2;
            var6_6.mAlignedDimensions = var16_16 = new int[var15_15];
        }
        var15_15 = 1;
        if (var11_11 == 0 && var9_9 == var15_15 || var13_13 == 0 && var9_9 == 0) lbl-1000:
        // 3 sources

        {
            while (true) {
                var17_17 = var15_15;
                break;
            }
        } else {
            var17_17 = 0;
            var18_18 = null;
        }
        while (var17_17 == 0) {
            block27: {
                if (var9_9 == 0) {
                    var12_12 = var8_8;
                    var19_19 = var13_13;
                    var20_20 = Math.ceil(var12_12 /= var19_19);
                    var11_11 = (int)var20_20;
                } else {
                    var14_14 = var8_8;
                    var19_19 = var11_11;
                    var20_20 = Math.ceil(var14_14 /= var19_19);
                    var13_13 = (int)var20_20;
                }
                var22_21 = var6_6.mAlignedBiggestElementsInCols;
                var23_22 = 0;
                if (var22_21 != null && (var24_23 = var22_21.length) >= var13_13) {
                    Arrays.fill(var22_21, null);
                } else {
                    var22_21 = new ConstraintWidget[var13_13];
                    var6_6.mAlignedBiggestElementsInCols = var22_21;
                }
                var22_21 = var6_6.mAlignedBiggestElementsInRows;
                if (var22_21 != null && (var24_23 = var22_21.length) >= var11_11) {
                    Arrays.fill(var22_21, null);
                } else {
                    var22_21 = new ConstraintWidget[var11_11];
                    var6_6.mAlignedBiggestElementsInRows = var22_21;
                }
                var22_21 = null;
                var19_19 = 0.0f;
                for (var25_24 = 0; var25_24 < var13_13; ++var25_24) {
                    for (var23_22 = 0; var23_22 < var11_11; ++var23_22) {
                        var24_23 = var23_22 * var13_13 + var25_24;
                        if (var9_9 == var15_15) {
                            var24_23 = var25_24 * var11_11 + var23_22;
                        }
                        if (var24_23 >= (var26_25 = var7_7 /* !! */ .length) || (var27_26 = var7_7 /* !! */ [var24_23]) == null) continue;
                        var26_25 = var6_6.getWidgetWidth(var27_26, var10_10);
                        var28_27 = var6_6.mAlignedBiggestElementsInCols;
                        var29_28 = var28_27[var25_24];
                        if (var29_28 == null || (var30_29 = (var28_27 = var28_27[var25_24]).getWidth()) < var26_25) {
                            var31_30 = var6_6.mAlignedBiggestElementsInCols;
                            var31_30[var25_24] = var27_26;
                        }
                        var26_25 = var6_6.getWidgetHeight(var27_26, var10_10);
                        var28_27 = var6_6.mAlignedBiggestElementsInRows;
                        var29_28 = var28_27[var23_22];
                        if (var29_28 != null && (var30_29 = (var28_27 = var28_27[var23_22]).getHeight()) >= var26_25) continue;
                        var31_30 = var6_6.mAlignedBiggestElementsInRows;
                        var31_30[var23_22] = var27_26;
                    }
                }
                var22_21 = null;
                var19_19 = 0.0f;
                var23_22 = 0;
                for (var25_24 = 0; var25_24 < var13_13; ++var25_24) {
                    var27_26 = var6_6.mAlignedBiggestElementsInCols[var25_24];
                    if (var27_26 == null) continue;
                    if (var25_24 > 0) {
                        var26_25 = var6_6.mHorizontalGap;
                        var23_22 += var26_25;
                    }
                    var24_23 = var6_6.getWidgetWidth(var27_26, var10_10);
                    var23_22 += var24_23;
                }
                var22_21 = null;
                var19_19 = 0.0f;
                var24_23 = 0;
                var27_26 = null;
                for (var25_24 = 0; var25_24 < var11_11; ++var25_24) {
                    var31_30 = var6_6.mAlignedBiggestElementsInRows[var25_24];
                    if (var31_30 == null) continue;
                    if (var25_24 > 0) {
                        var30_29 = var6_6.mVerticalGap;
                        var24_23 += var30_29;
                    }
                    var26_25 = var6_6.getWidgetHeight((ConstraintWidget)var31_30, var10_10);
                    var24_23 += var26_25;
                }
                var5_5[0] = var23_22;
                var5_5[var15_15] = var24_23;
                if (var9_9 != 0) break block27;
                if (var23_22 <= var10_10 || var13_13 <= var15_15) ** GOTO lbl-1000
                var13_13 += -1;
                continue;
            }
            if (var24_23 > var10_10 && var11_11 > var15_15) ** break;
            ** continue;
            var11_11 += -1;
        }
        var7_7 /* !! */  = (ConstraintWidget[])var6_6.mAlignedDimensions;
        var7_7 /* !! */ [0] = (ConstraintWidget)var13_13;
        var7_7 /* !! */ [var15_15] = (ConstraintWidget)var11_11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void measureChainWrap(ConstraintWidget[] var1_1, int var2_2, int var3_3, int var4_4, int[] var5_5) {
        var6_6 = this;
        var7_7 = var2_2;
        var8_8 = var4_4;
        if (var2_2 == 0) {
            return;
        }
        this.mChainList.clear();
        var10_10 /* !! */  = this.mLeft;
        var11_11 = this.mTop;
        var12_12 = this.mRight;
        var13_13 = this.mBottom;
        var14_14 = var9_9;
        var15_15 = this;
        var16_16 = var3_3;
        var17_17 = var4_4;
        var9_9 = new Flow$WidgetsList(this, var3_3, (ConstraintAnchor)var10_10 /* !! */ , (ConstraintAnchor)var11_11, (ConstraintAnchor)var12_12, (ConstraintAnchor)var13_13, var4_4);
        var14_14 = this.mChainList;
        var14_14.add(var9_9);
        var18_18 = 1;
        if (var3_3 == 0) {
            var19_19 = 0;
            var14_14 = null;
            var20_20 = 0;
            var15_15 = null;
            var22_22 /* !! */  = null;
            for (var21_21 = 0; var21_21 < var7_7; ++var21_21) {
                var23_23 /* !! */  = var1_1 /* !! */ [var21_21];
                var24_24 = var6_6.getWidgetWidth(var23_23 /* !! */ , var8_8);
                var25_25 /* !! */  = var23_23 /* !! */ .getHorizontalDimensionBehaviour();
                if (var25_25 /* !! */  == (var10_10 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                    // empty if block
                }
                var26_26 = ++var19_19;
                if ((var20_20 == var8_8 || (var19_19 = var6_6.mHorizontalGap + var20_20 + var24_24) > var8_8) && (var14_14 = Flow$WidgetsList.access$2000(var9_9)) != null) {
                    var19_19 = var18_18;
                } else {
                    var19_19 = 0;
                    var14_14 = null;
                }
                if (var19_19 == 0 && var21_21 > 0 && (var16_16 = var6_6.mMaxElementsWrap) > 0 && (var16_16 = var21_21 % var16_16) == 0) {
                    var19_19 = var18_18;
                }
                if (var19_19 != 0) {
                    var10_10 /* !! */  = var6_6.mLeft;
                    var11_11 = var6_6.mTop;
                    var12_12 = var6_6.mRight;
                    var13_13 = var6_6.mBottom;
                    var14_14 = var9_9;
                    var15_15 = this;
                    var16_16 = var3_3;
                    var17_17 = var4_4;
                    var9_9 = new Flow$WidgetsList(this, var3_3, (ConstraintAnchor)var10_10 /* !! */ , (ConstraintAnchor)var11_11, (ConstraintAnchor)var12_12, (ConstraintAnchor)var13_13, var4_4);
                    var9_9.setStartIndex(var21_21);
                    var14_14 = var6_6.mChainList;
                    var14_14.add(var9_9);
                    while (true) {
                        var20_20 = var24_24;
                        break;
                    }
                } else {
                    if (var21_21 <= 0) ** continue;
                    var19_19 = var6_6.mHorizontalGap + var24_24;
                    var20_20 += var19_19;
                }
                var9_9.add(var23_23 /* !! */ );
                var19_19 = var26_26;
            }
        } else {
            var19_19 = 0;
            var14_14 = null;
            var20_20 = 0;
            var15_15 = null;
            var22_22 /* !! */  = null;
            for (var21_21 = 0; var21_21 < var7_7; ++var21_21) {
                var23_23 /* !! */  = var1_1 /* !! */ [var21_21];
                var24_24 = var6_6.getWidgetHeight(var23_23 /* !! */ , var8_8);
                var25_25 /* !! */  = var23_23 /* !! */ .getVerticalDimensionBehaviour();
                if (var25_25 /* !! */  == (var10_10 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                    // empty if block
                }
                var26_26 = ++var19_19;
                if ((var20_20 == var8_8 || (var19_19 = var6_6.mVerticalGap + var20_20 + var24_24) > var8_8) && (var14_14 = Flow$WidgetsList.access$2000(var9_9)) != null) {
                    var19_19 = var18_18;
                } else {
                    var19_19 = 0;
                    var14_14 = null;
                }
                if (var19_19 == 0 && var21_21 > 0 && (var16_16 = var6_6.mMaxElementsWrap) > 0 && (var16_16 = var21_21 % var16_16) == 0) {
                    var19_19 = var18_18;
                }
                if (var19_19 != 0) {
                    var10_10 /* !! */  = var6_6.mLeft;
                    var11_11 = var6_6.mTop;
                    var12_12 = var6_6.mRight;
                    var13_13 = var6_6.mBottom;
                    var14_14 = var9_9;
                    var15_15 = this;
                    var16_16 = var3_3;
                    var17_17 = var4_4;
                    var9_9 = new Flow$WidgetsList(this, var3_3, (ConstraintAnchor)var10_10 /* !! */ , (ConstraintAnchor)var11_11, (ConstraintAnchor)var12_12, (ConstraintAnchor)var13_13, var4_4);
                    var9_9.setStartIndex(var21_21);
                    var14_14 = var6_6.mChainList;
                    var14_14.add(var9_9);
                    while (true) {
                        var20_20 = var24_24;
                        break;
                    }
                } else {
                    if (var21_21 <= 0) ** continue;
                    var19_19 = var6_6.mVerticalGap + var24_24;
                    var20_20 += var19_19;
                }
                var9_9.add(var23_23 /* !! */ );
                var19_19 = var26_26;
            }
        }
        var15_15 = var6_6.mChainList;
        var20_20 = var15_15.size();
        var25_25 /* !! */  = var6_6.mLeft;
        var10_10 /* !! */  = var6_6.mTop;
        var11_11 = var6_6.mRight;
        var12_12 = var6_6.mBottom;
        var27_27 = this.getPaddingLeft();
        var17_17 = this.getPaddingTop();
        var7_7 = this.getPaddingRight();
        var28_28 = this.getPaddingBottom();
        var22_22 /* !! */  = this.getHorizontalDimensionBehaviour();
        if (var22_22 /* !! */  != (var23_23 /* !! */  = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (var22_22 /* !! */  = this.getVerticalDimensionBehaviour()) != var23_23 /* !! */ ) {
            var21_21 = 0;
            var22_22 /* !! */  = null;
        } else {
            var21_21 = var18_18;
        }
        if (var19_19 > 0 && var21_21 != 0) {
            var14_14 = null;
            for (var19_19 = 0; var19_19 < var20_20; ++var19_19) {
                var22_22 /* !! */  = (Flow$WidgetsList)var6_6.mChainList.get(var19_19);
                if (var3_3 == 0) {
                    var29_29 = var22_22 /* !! */ .getWidth();
                    var29_29 = var8_8 - var29_29;
                    var22_22 /* !! */ .measureMatchConstraints(var29_29);
                    continue;
                }
                var29_29 = var22_22 /* !! */ .getHeight();
                var29_29 = var8_8 - var29_29;
                var22_22 /* !! */ .measureMatchConstraints(var29_29);
            }
        }
        var30_30 = var17_17;
        var19_19 = var7_7;
        var29_29 = 0;
        var23_23 /* !! */  = null;
        var24_24 = 0;
        var26_26 = 0;
        var17_17 = var27_27;
        var13_13 = var10_10 /* !! */ ;
        var10_10 /* !! */  = var25_25 /* !! */ ;
        var16_16 = var28_28;
        while (var26_26 < var20_20) {
            var31_31 /* !! */  = var6_6.mChainList.get(var26_26);
            var32_32 = var31_31 /* !! */ ;
            var32_32 = (Flow$WidgetsList)var31_31 /* !! */ ;
            if (var3_3 == 0) {
                var16_16 = var20_20 + -1;
                if (var26_26 < var16_16) {
                    var25_25 /* !! */  = var6_6.mChainList;
                    var33_33 = var26_26 + 1;
                    var25_25 /* !! */  = Flow$WidgetsList.access$2000((Flow$WidgetsList)((Flow$WidgetsList)var25_25 /* !! */ .get((int)var33_33))).mTop;
                    var33_33 = 0;
                    var12_12 = null;
                } else {
                    var25_25 /* !! */  = var6_6.mBottom;
                    var33_33 = this.getPaddingBottom();
                }
                var22_22 /* !! */  = Flow$WidgetsList.access$2000(var32_32).mBottom;
                var31_31 /* !! */  = var32_32;
                var28_28 = var3_3;
                var34_34 = var22_22 /* !! */ ;
                var22_22 /* !! */  = var10_10 /* !! */ ;
                var1_1 /* !! */  = var10_10 /* !! */ ;
                var35_35 = var29_29;
                var23_23 /* !! */  = var13_13;
                var27_27 = var24_24;
                var36_36 = var11_11;
                var37_37 = var26_26;
                var8_8 = var17_17;
                var32_32.setup(var3_3, (ConstraintAnchor)var10_10 /* !! */ , (ConstraintAnchor)var13_13, (ConstraintAnchor)var11_11, var25_25 /* !! */ , var17_17, var30_30, var19_19, var33_33, var4_4);
                var7_7 = var32_32.getWidth();
                var27_27 = Math.max(var24_24, var7_7);
                var7_7 = var32_32.getHeight();
                var29_29 += var7_7;
                if (var26_26 > 0) {
                    var35_35 = var6_6.mVerticalGap;
                    var29_29 += var35_35;
                }
                var10_10 /* !! */  = var1_1 /* !! */ ;
                var24_24 = var27_27;
                var30_30 = 0;
                var13_13 = var34_34;
                var34_34 = var36_36;
                var12_12 = var25_25 /* !! */ ;
                var16_16 = var33_33;
            } else {
                var1_1 /* !! */  = var10_10 /* !! */ ;
                var35_35 = var29_29;
                var19_19 = var24_24;
                var37_37 = var26_26;
                var7_7 = var20_20 + -1;
                if (var26_26 < var7_7) {
                    var31_31 /* !! */  = var6_6.mChainList;
                    var31_31 /* !! */  = Flow$WidgetsList.access$2000((Flow$WidgetsList)((Flow$WidgetsList)var31_31 /* !! */ .get((int)(++var26_26)))).mLeft;
                    var34_34 = var31_31 /* !! */ ;
                    var38_38 = 0;
                } else {
                    var31_31 /* !! */  = var6_6.mRight;
                    var28_28 = this.getPaddingRight();
                    var34_34 = var31_31 /* !! */ ;
                    var38_38 = var28_28;
                }
                var39_39 = Flow$WidgetsList.access$2000(var32_32).mRight;
                var31_31 /* !! */  = var32_32;
                var28_28 = var3_3;
                var22_22 /* !! */  = var1_1 /* !! */ ;
                var23_23 /* !! */  = var13_13;
                var40_40 = var39_39;
                var8_8 = var17_17;
                var32_32.setup(var3_3, (ConstraintAnchor)var1_1 /* !! */ , (ConstraintAnchor)var13_13, (ConstraintAnchor)var34_34, (ConstraintAnchor)var12_12, var17_17, var30_30, var38_38, var16_16, var4_4);
                var17_17 = var32_32.getWidth();
                var24_24 = var19_19 + var17_17;
                var19_19 = var32_32.getHeight();
                var19_19 = Math.max(var35_35, var19_19);
                if (var37_37 > 0) {
                    var35_35 = var6_6.mHorizontalGap;
                    var24_24 += var35_35;
                }
                var29_29 = var19_19;
                var17_17 = 0;
                var19_19 = var38_38;
                var10_10 /* !! */  = var40_40;
            }
            var26_26 = var37_37 + 1;
            var8_8 = var4_4;
            var11_11 = var34_34;
        }
        var35_35 = var29_29;
        var19_19 = var24_24;
        var5_5[0] = var24_24;
        var5_5[var18_18] = var29_29;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArray, int n10, int n11, int n12, int[] nArray) {
        Object object;
        Object object2;
        int n13 = n10;
        if (n10 == 0) {
            return;
        }
        Object object3 = this.mChainList;
        int n14 = ((ArrayList)object3).size();
        if (n14 == 0) {
            ConstraintAnchor constraintAnchor = this.mLeft;
            ConstraintAnchor constraintAnchor2 = this.mTop;
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = this.mBottom;
            object3 = object2;
            object = this;
            object2 = new Flow$WidgetsList(this, n11, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, n12);
            object3 = this.mChainList;
            ((ArrayList)object3).add(object2);
        } else {
            object3 = (Flow$WidgetsList)this.mChainList.get(0);
            ((Flow$WidgetsList)object3).clear();
            ConstraintAnchor constraintAnchor = this.mLeft;
            ConstraintAnchor constraintAnchor5 = this.mTop;
            ConstraintAnchor constraintAnchor6 = this.mRight;
            object = this.mBottom;
            int n15 = this.getPaddingLeft();
            int n16 = this.getPaddingTop();
            int n17 = this.getPaddingRight();
            int n18 = this.getPaddingBottom();
            object2 = object3;
            ((Flow$WidgetsList)object3).setup(n11, constraintAnchor, constraintAnchor5, constraintAnchor6, (ConstraintAnchor)object, n15, n16, n17, n18, n12);
        }
        object3 = null;
        for (n14 = 0; n14 < n13; ++n14) {
            object = constraintWidgetArray[n14];
            ((Flow$WidgetsList)object2).add((ConstraintWidget)object);
        }
        nArray[0] = n14 = ((Flow$WidgetsList)object2).getWidth();
        nArray[1] = n14 = ((Flow$WidgetsList)object2).getHeight();
    }

    public void addToSolver(LinearSystem object, boolean bl2) {
        boolean bl3;
        super.addToSolver((LinearSystem)object, bl2);
        object = this.getParent();
        bl2 = false;
        if (object != null) {
            object = (ConstraintWidgetContainer)this.getParent();
            bl3 = ((ConstraintWidgetContainer)object).isRtl();
        } else {
            bl3 = false;
            object = null;
        }
        int n10 = this.mWrapMode;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    this.createAlignedConstraints(bl3);
                }
            } else {
                ArrayList arrayList = this.mChainList;
                n10 = arrayList.size();
                for (int i10 = 0; i10 < n10; ++i10) {
                    Flow$WidgetsList flow$WidgetsList = (Flow$WidgetsList)this.mChainList.get(i10);
                    int n12 = n10 + -1;
                    n12 = i10 == n12 ? n11 : 0;
                    flow$WidgetsList.createConstraints(bl3, i10, n12 != 0);
                }
            }
        } else {
            Object object2 = this.mChainList;
            n10 = ((ArrayList)object2).size();
            if (n10 > 0) {
                object2 = (Flow$WidgetsList)this.mChainList.get(0);
                ((Flow$WidgetsList)object2).createConstraints(bl3, 0, n11 != 0);
            }
        }
        this.needsCallbackFromSolver(false);
    }

    public void copy(ConstraintWidget constraintWidget, HashMap hashMap) {
        int n10;
        float f10;
        int n11;
        super.copy(constraintWidget, hashMap);
        constraintWidget = (Flow)constraintWidget;
        this.mHorizontalStyle = n11 = ((Flow)constraintWidget).mHorizontalStyle;
        this.mVerticalStyle = n11 = ((Flow)constraintWidget).mVerticalStyle;
        this.mFirstHorizontalStyle = n11 = ((Flow)constraintWidget).mFirstHorizontalStyle;
        this.mFirstVerticalStyle = n11 = ((Flow)constraintWidget).mFirstVerticalStyle;
        this.mLastHorizontalStyle = n11 = ((Flow)constraintWidget).mLastHorizontalStyle;
        this.mLastVerticalStyle = n11 = ((Flow)constraintWidget).mLastVerticalStyle;
        this.mHorizontalBias = f10 = ((Flow)constraintWidget).mHorizontalBias;
        this.mVerticalBias = f10 = ((Flow)constraintWidget).mVerticalBias;
        this.mFirstHorizontalBias = f10 = ((Flow)constraintWidget).mFirstHorizontalBias;
        this.mFirstVerticalBias = f10 = ((Flow)constraintWidget).mFirstVerticalBias;
        this.mLastHorizontalBias = f10 = ((Flow)constraintWidget).mLastHorizontalBias;
        this.mLastVerticalBias = f10 = ((Flow)constraintWidget).mLastVerticalBias;
        this.mHorizontalGap = n11 = ((Flow)constraintWidget).mHorizontalGap;
        this.mVerticalGap = n11 = ((Flow)constraintWidget).mVerticalGap;
        this.mHorizontalAlign = n11 = ((Flow)constraintWidget).mHorizontalAlign;
        this.mVerticalAlign = n11 = ((Flow)constraintWidget).mVerticalAlign;
        this.mWrapMode = n11 = ((Flow)constraintWidget).mWrapMode;
        this.mMaxElementsWrap = n11 = ((Flow)constraintWidget).mMaxElementsWrap;
        this.mOrientation = n10 = ((Flow)constraintWidget).mOrientation;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void measure(int n10, int n11, int n12, int n13) {
        int[] nArray;
        int n14;
        ConstraintWidget[] constraintWidgetArray;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        int n20;
        int n21;
        ConstraintWidget constraintWidget;
        int n22;
        int n23;
        int n24;
        int n25;
        int n26;
        int n27;
        Flow flow;
        block29: {
            int n28;
            int[] nArray2;
            block30: {
                flow = this;
                n27 = n10;
                n26 = n11;
                n25 = n12;
                n24 = n13;
                n23 = this.mWidgetsCount;
                n22 = 0;
                constraintWidget = null;
                if (n23 > 0 && (n23 = (int)(this.measureChildren() ? 1 : 0)) == 0) {
                    this.setMeasure(0, 0);
                    this.needsCallbackFromSolver(false);
                    return;
                }
                n21 = this.getPaddingLeft();
                n20 = this.getPaddingRight();
                n19 = this.getPaddingTop();
                n18 = this.getPaddingBottom();
                n23 = 2;
                nArray2 = new int[n23];
                n17 = n26 - n21 - n20;
                n16 = flow.mOrientation;
                n15 = 1;
                if (n16 == n15) {
                    n17 = n24 - n19 - n18;
                }
                n28 = n17;
                n17 = -1;
                if (n16 == 0) {
                    n16 = flow.mHorizontalStyle;
                    if (n16 == n17) {
                        flow.mHorizontalStyle = 0;
                    }
                    if ((n16 = flow.mVerticalStyle) == n17) {
                        flow.mVerticalStyle = 0;
                    }
                } else {
                    n16 = flow.mHorizontalStyle;
                    if (n16 == n17) {
                        flow.mHorizontalStyle = 0;
                    }
                    if ((n16 = flow.mVerticalStyle) == n17) {
                        flow.mVerticalStyle = 0;
                    }
                }
                constraintWidgetArray = flow.mWidgets;
                n16 = 0;
                n14 = 0;
                while (true) {
                    n22 = flow.mWidgetsCount;
                    n23 = 8;
                    if (n16 >= n22) break;
                    constraintWidget = flow.mWidgets[n16];
                    n22 = constraintWidget.getVisibility();
                    if (n22 == n23) {
                        ++n14;
                    }
                    ++n16;
                    n23 = 2;
                }
                if (n14 > 0) {
                    constraintWidgetArray = new ConstraintWidget[n22 -= n14];
                    n14 = 0;
                    for (n16 = 0; n16 < (n22 = flow.mWidgetsCount); ++n16) {
                        constraintWidget = flow.mWidgets[n16];
                        n15 = constraintWidget.getVisibility();
                        if (n15 != n23) {
                            constraintWidgetArray[n14] = constraintWidget;
                            ++n14;
                        }
                        n15 = 1;
                    }
                    n16 = n14;
                } else {
                    n16 = n22;
                }
                flow.mDisplayedWidgets = constraintWidgetArray;
                flow.mDisplayedWidgetsCount = n16;
                n23 = flow.mWrapMode;
                if (n23 == 0) break block30;
                n15 = 1;
                if (n23 != n15) {
                    n14 = 2;
                    if (n23 != n14) {
                        n22 = n15;
                        nArray = nArray2;
                        break block29;
                    } else {
                        n14 = flow.mOrientation;
                        n22 = n15;
                        n15 = n28;
                        nArray = nArray2;
                        this.measureAligned(constraintWidgetArray, n16, n14, n28, nArray2);
                    }
                    break block29;
                } else {
                    n22 = n15;
                    nArray = nArray2;
                    n14 = flow.mOrientation;
                    n15 = n28;
                    this.measureChainWrap(constraintWidgetArray, n16, n14, n28, nArray2);
                }
                break block29;
            }
            nArray = nArray2;
            n22 = 1;
            n14 = flow.mOrientation;
            n15 = n28;
            this.measureNoWrap(constraintWidgetArray, n16, n14, n28, nArray2);
        }
        n23 = 0;
        n17 = nArray[0] + n21 + n20;
        n16 = nArray[n22] + n19 + n18;
        n14 = -1 << -1;
        n15 = 0x40000000;
        if (n27 == n15) {
            n17 = n26;
        } else if (n27 == n14) {
            n17 = Math.min(n17, n26);
        } else if (n27 != 0) {
            n17 = 0;
            constraintWidgetArray = null;
        }
        if (n25 == n15) {
            n16 = n24;
        } else if (n25 == n14) {
            n16 = Math.min(n16, n24);
        } else if (n25 != 0) {
            n16 = 0;
        }
        flow.setMeasure(n17, n16);
        flow.setWidth(n17);
        flow.setHeight(n16);
        n17 = flow.mWidgetsCount;
        if (n17 <= 0) {
            n22 = 0;
            constraintWidget = null;
        }
        flow.needsCallbackFromSolver(n22 != 0);
    }

    public void setFirstHorizontalBias(float f10) {
        this.mFirstHorizontalBias = f10;
    }

    public void setFirstHorizontalStyle(int n10) {
        this.mFirstHorizontalStyle = n10;
    }

    public void setFirstVerticalBias(float f10) {
        this.mFirstVerticalBias = f10;
    }

    public void setFirstVerticalStyle(int n10) {
        this.mFirstVerticalStyle = n10;
    }

    public void setHorizontalAlign(int n10) {
        this.mHorizontalAlign = n10;
    }

    public void setHorizontalBias(float f10) {
        this.mHorizontalBias = f10;
    }

    public void setHorizontalGap(int n10) {
        this.mHorizontalGap = n10;
    }

    public void setHorizontalStyle(int n10) {
        this.mHorizontalStyle = n10;
    }

    public void setLastHorizontalBias(float f10) {
        this.mLastHorizontalBias = f10;
    }

    public void setLastHorizontalStyle(int n10) {
        this.mLastHorizontalStyle = n10;
    }

    public void setLastVerticalBias(float f10) {
        this.mLastVerticalBias = f10;
    }

    public void setLastVerticalStyle(int n10) {
        this.mLastVerticalStyle = n10;
    }

    public void setMaxElementsWrap(int n10) {
        this.mMaxElementsWrap = n10;
    }

    public void setOrientation(int n10) {
        this.mOrientation = n10;
    }

    public void setVerticalAlign(int n10) {
        this.mVerticalAlign = n10;
    }

    public void setVerticalBias(float f10) {
        this.mVerticalBias = f10;
    }

    public void setVerticalGap(int n10) {
        this.mVerticalGap = n10;
    }

    public void setVerticalStyle(int n10) {
        this.mVerticalStyle = n10;
    }

    public void setWrapMode(int n10) {
        this.mWrapMode = n10;
    }
}

