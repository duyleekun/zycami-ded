/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams$Table;
import androidx.constraintlayout.widget.R$styleable;

public class ConstraintLayout$LayoutParams
extends ViewGroup.MarginLayoutParams {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = 255;
    public static final int VERTICAL = 1;
    public int baselineToBaseline;
    public int bottomToBottom;
    public int bottomToTop;
    public float circleAngle;
    public int circleConstraint;
    public int circleRadius;
    public boolean constrainedHeight;
    public boolean constrainedWidth;
    public String constraintTag;
    public String dimensionRatio;
    public int dimensionRatioSide;
    public float dimensionRatioValue;
    public int editorAbsoluteX;
    public int editorAbsoluteY;
    public int endToEnd;
    public int endToStart;
    public int goneBottomMargin;
    public int goneEndMargin;
    public int goneLeftMargin;
    public int goneRightMargin;
    public int goneStartMargin;
    public int goneTopMargin;
    public int guideBegin;
    public int guideEnd;
    public float guidePercent;
    public boolean helped;
    public float horizontalBias;
    public int horizontalChainStyle;
    public boolean horizontalDimensionFixed;
    public float horizontalWeight;
    public boolean isGuideline;
    public boolean isHelper;
    public boolean isInPlaceholder;
    public boolean isVirtualGroup;
    public int leftToLeft;
    public int leftToRight;
    public int matchConstraintDefaultHeight;
    public int matchConstraintDefaultWidth;
    public int matchConstraintMaxHeight;
    public int matchConstraintMaxWidth;
    public int matchConstraintMinHeight;
    public int matchConstraintMinWidth;
    public float matchConstraintPercentHeight;
    public float matchConstraintPercentWidth;
    public boolean needsBaseline;
    public int orientation;
    public int resolveGoneLeftMargin;
    public int resolveGoneRightMargin;
    public int resolvedGuideBegin;
    public int resolvedGuideEnd;
    public float resolvedGuidePercent;
    public float resolvedHorizontalBias;
    public int resolvedLeftToLeft;
    public int resolvedLeftToRight;
    public int resolvedRightToLeft;
    public int resolvedRightToRight;
    public int rightToLeft;
    public int rightToRight;
    public int startToEnd;
    public int startToStart;
    public int topToBottom;
    public int topToTop;
    public float verticalBias;
    public int verticalChainStyle;
    public boolean verticalDimensionFixed;
    public float verticalWeight;
    public ConstraintWidget widget;

    public ConstraintLayout$LayoutParams(int n10, int n11) {
        super(n10, n11);
        ConstraintWidget constraintWidget;
        int n12;
        float f10;
        float f11;
        this.guideBegin = n10 = -1;
        this.guideEnd = n10;
        this.guidePercent = f11 = -1.0f;
        this.leftToLeft = n10;
        this.leftToRight = n10;
        this.rightToLeft = n10;
        this.rightToRight = n10;
        this.topToTop = n10;
        this.topToBottom = n10;
        this.bottomToTop = n10;
        this.bottomToBottom = n10;
        this.baselineToBaseline = n10;
        this.circleConstraint = n10;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = n10;
        this.startToStart = n10;
        this.endToStart = n10;
        this.endToEnd = n10;
        this.goneLeftMargin = n10;
        this.goneTopMargin = n10;
        this.goneRightMargin = n10;
        this.goneBottomMargin = n10;
        this.goneStartMargin = n10;
        this.goneEndMargin = n10;
        this.horizontalBias = f10 = 0.5f;
        this.verticalBias = f10;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = n12 = 1;
        this.horizontalWeight = f11;
        this.verticalWeight = f11;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = f11 = 1.0f;
        this.matchConstraintPercentHeight = f11;
        this.editorAbsoluteX = n10;
        this.editorAbsoluteY = n10;
        this.orientation = n10;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = n12;
        this.verticalDimensionFixed = n12;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = n10;
        this.resolvedLeftToRight = n10;
        this.resolvedRightToLeft = n10;
        this.resolvedRightToRight = n10;
        this.resolveGoneLeftMargin = n10;
        this.resolveGoneRightMargin = n10;
        this.resolvedHorizontalBias = f10;
        this.widget = constraintWidget = new ConstraintWidget();
        this.helped = false;
    }

    /*
     * Unable to fully structure code
     */
    public ConstraintLayout$LayoutParams(Context var1_1, AttributeSet var2_2) {
        super(var1_1, var2_2);
        this.guideBegin = var3_3 = -1;
        this.guideEnd = var3_3;
        this.guidePercent = var4_4 = -1.0f;
        this.leftToLeft = var3_3;
        this.leftToRight = var3_3;
        this.rightToLeft = var3_3;
        this.rightToRight = var3_3;
        this.topToTop = var3_3;
        this.topToBottom = var3_3;
        this.bottomToTop = var3_3;
        this.bottomToBottom = var3_3;
        this.baselineToBaseline = var3_3;
        this.circleConstraint = var3_3;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = var3_3;
        this.startToStart = var3_3;
        this.endToStart = var3_3;
        this.endToEnd = var3_3;
        this.goneLeftMargin = var3_3;
        this.goneTopMargin = var3_3;
        this.goneRightMargin = var3_3;
        this.goneBottomMargin = var3_3;
        this.goneStartMargin = var3_3;
        this.goneEndMargin = var3_3;
        var5_5 = 0x3F000000;
        this.horizontalBias = var6_6 = 0.5f;
        this.verticalBias = var6_6;
        var7_7 = 0;
        var8_8 = 0.0f;
        var9_9 = null;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = var10_10 = 1;
        this.horizontalWeight = var4_4;
        this.verticalWeight = var4_4;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = var4_4 = 1.0f;
        this.matchConstraintPercentHeight = var4_4;
        this.editorAbsoluteX = var3_3;
        this.editorAbsoluteY = var3_3;
        this.orientation = var3_3;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = var10_10;
        this.verticalDimensionFixed = var10_10;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = var3_3;
        this.resolvedLeftToRight = var3_3;
        this.resolvedRightToLeft = var3_3;
        this.resolvedRightToRight = var3_3;
        this.resolveGoneLeftMargin = var3_3;
        this.resolveGoneRightMargin = var3_3;
        this.resolvedHorizontalBias = var6_6;
        var11_11 = new ConstraintWidget();
        this.widget = var11_11;
        this.helped = false;
        var11_11 = R$styleable.ConstraintLayout_Layout;
        var1_1 = var1_1.obtainStyledAttributes(var2_2, (int[])var11_11);
        var12_12 = var1_1.getIndexCount();
        var11_11 = null;
        var4_4 = 0.0f;
        block76: for (var13_13 = 0; var13_13 < var12_12; ++var13_13) {
            var5_5 = var1_1.getIndex(var13_13);
            var9_9 = ConstraintLayout$LayoutParams$Table.map;
            var7_7 = var9_9.get(var5_5);
            var14_14 = "ConstraintLayout";
            var15_15 = 2;
            var16_16 = -2;
            block21 : switch (var7_7) {
                default: {
                    switch (var7_7) {
                        default: {
                            break block21;
                        }
                        case 51: {
                            this.constraintTag = var17_17 = var1_1.getString(var5_5);
                            break block21;
                        }
                        case 50: {
                            var7_7 = this.editorAbsoluteY;
                            this.editorAbsoluteY = var5_5 = var1_1.getDimensionPixelOffset(var5_5, var7_7);
                            break block21;
                        }
                        case 49: {
                            var7_7 = this.editorAbsoluteX;
                            this.editorAbsoluteX = var5_5 = var1_1.getDimensionPixelOffset(var5_5, var7_7);
                            break block21;
                        }
                        case 48: {
                            this.verticalChainStyle = var5_5 = var1_1.getInt(var5_5, 0);
                            break block21;
                        }
                        case 47: {
                            this.horizontalChainStyle = var5_5 = var1_1.getInt(var5_5, 0);
                            break block21;
                        }
                        case 46: {
                            var8_8 = this.verticalWeight;
                            this.verticalWeight = var6_6 = var1_1.getFloat(var5_5, var8_8);
                            break block21;
                        }
                        case 45: {
                            var8_8 = this.horizontalWeight;
                            this.horizontalWeight = var6_6 = var1_1.getFloat(var5_5, var8_8);
                            break block21;
                        }
                        case 44: 
                    }
                    this.dimensionRatio = var17_17 = var1_1.getString(var5_5);
                    var7_7 = 2143289344;
                    this.dimensionRatioValue = var8_8 = 0.0f / 0.0f;
                    this.dimensionRatioSide = var3_3;
                    if (var17_17 == null) break;
                    var5_5 = var17_17.length();
                    var9_9 = this.dimensionRatio;
                    var18_18 = 44;
                    var7_7 = var9_9.indexOf((int)var18_18);
                    if (var7_7 > 0 && var7_7 < (var18_18 = (float)(var5_5 + -1))) {
                        var14_14 = this.dimensionRatio.substring(0, var7_7);
                        var15_15 = (int)var14_14.equalsIgnoreCase(var19_19 = "W");
                        if (var15_15 != 0) {
                            this.dimensionRatioSide = 0;
                        } else {
                            var19_19 = "H";
                            var18_18 = (float)var14_14.equalsIgnoreCase(var19_19);
                            if (var18_18 != false) {
                                this.dimensionRatioSide = var10_10;
                            }
                        }
                        ++var7_7;
                    } else {
                        var7_7 = 0;
                        var9_9 = null;
                        var8_8 = 0.0f;
                    }
                    var14_14 = this.dimensionRatio;
                    var15_15 = 58;
                    var18_18 = var14_14.indexOf(var15_15);
                    if (var18_18 < 0 || var18_18 >= (var5_5 += -1)) ** GOTO lbl169
                    var17_17 = this.dimensionRatio.substring(var7_7, (int)var18_18);
                    var9_9 = this.dimensionRatio;
                    var9_9 = var9_9.substring((int)(++var18_18));
                    var18_18 = var17_17.length();
                    if (var18_18 <= 0 || (var18_18 = (float)var9_9.length()) <= 0) break;
                    var6_6 = Float.parseFloat(var17_17);
                    var8_8 = Float.parseFloat((String)var9_9);
                    cfr_temp_0 = var6_6 - 0.0f;
                    var18_18 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
                    if (var18_18 <= 0 || (var18_18 = (cfr_temp_1 = var8_8 - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1)) <= 0) break;
                    var18_18 = this.dimensionRatioSide;
                    if (var18_18 != var10_10) ** GOTO lbl163
                    var8_8 /= var6_6;
                    var6_6 = Math.abs(var8_8);
                    this.dimensionRatioValue = var6_6;
                    break;
lbl163:
                    // 1 sources

                    var6_6 /= var8_8;
                    var6_6 = Math.abs(var6_6);
                    this.dimensionRatioValue = var6_6;
                    break;
lbl169:
                    // 1 sources

                    var17_17 = this.dimensionRatio.substring(var7_7);
                    if ((var7_7 = var17_17.length()) <= 0) break;
                    var6_6 = Float.parseFloat(var17_17);
                    this.dimensionRatioValue = var6_6;
                    break;
                }
                case 38: {
                    var8_8 = this.matchConstraintPercentHeight;
                    var6_6 = var1_1.getFloat(var5_5, var8_8);
                    this.matchConstraintPercentHeight = var6_6 = Math.max(0.0f, var6_6);
                    this.matchConstraintDefaultHeight = var15_15;
                    break;
                }
                case 37: {
                    var7_7 = this.matchConstraintMaxHeight;
                    var7_7 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    try {
                        this.matchConstraintMaxHeight = var7_7;
                    }
                    catch (Exception v0) {
                        var7_7 = this.matchConstraintMaxHeight;
                        var5_5 = var1_1.getInt(var5_5, var7_7);
                        if (var5_5 != var16_16) break;
                        this.matchConstraintMaxHeight = var16_16;
                    }
                    break;
                }
                case 36: {
                    var7_7 = this.matchConstraintMinHeight;
                    var7_7 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    try {
                        this.matchConstraintMinHeight = var7_7;
                    }
                    catch (Exception v1) {
                        var7_7 = this.matchConstraintMinHeight;
                        var5_5 = var1_1.getInt(var5_5, var7_7);
                        if (var5_5 != var16_16) break;
                        this.matchConstraintMinHeight = var16_16;
                    }
                    break;
                }
                case 35: {
                    var8_8 = this.matchConstraintPercentWidth;
                    var6_6 = var1_1.getFloat(var5_5, var8_8);
                    this.matchConstraintPercentWidth = var6_6 = Math.max(0.0f, var6_6);
                    this.matchConstraintDefaultWidth = var15_15;
                    break;
                }
                case 34: {
                    var7_7 = this.matchConstraintMaxWidth;
                    var7_7 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    try {
                        this.matchConstraintMaxWidth = var7_7;
                    }
                    catch (Exception v2) {
                        var7_7 = this.matchConstraintMaxWidth;
                        var5_5 = var1_1.getInt(var5_5, var7_7);
                        if (var5_5 != var16_16) break;
                        this.matchConstraintMaxWidth = var16_16;
                    }
                    break;
                }
                case 33: {
                    var7_7 = this.matchConstraintMinWidth;
                    var7_7 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    try {
                        this.matchConstraintMinWidth = var7_7;
                    }
                    catch (Exception v3) {
                        var7_7 = this.matchConstraintMinWidth;
                        var5_5 = var1_1.getInt(var5_5, var7_7);
                        if (var5_5 != var16_16) break;
                        this.matchConstraintMinWidth = var16_16;
                    }
                    break;
                }
                case 32: {
                    this.matchConstraintDefaultHeight = var5_5 = var1_1.getInt(var5_5, 0);
                    if (var5_5 != var10_10) break;
                    var17_17 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                    Log.e((String)var14_14, (String)var17_17);
                    break;
                }
                case 31: {
                    this.matchConstraintDefaultWidth = var5_5 = var1_1.getInt(var5_5, 0);
                    if (var5_5 != var10_10) break;
                    var17_17 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                    Log.e((String)var14_14, (String)var17_17);
                    break;
                }
                case 30: {
                    var8_8 = this.verticalBias;
                    this.verticalBias = var6_6 = var1_1.getFloat(var5_5, var8_8);
                    break;
                }
                case 29: {
                    var8_8 = this.horizontalBias;
                    this.horizontalBias = var6_6 = var1_1.getFloat(var5_5, var8_8);
                    break;
                }
                case 28: {
                    var7_7 = (int)this.constrainedHeight;
                    var5_5 = (int)var1_1.getBoolean(var5_5, (boolean)var7_7);
                    this.constrainedHeight = var5_5;
                    break;
                }
                case 27: {
                    var7_7 = (int)this.constrainedWidth;
                    var5_5 = (int)var1_1.getBoolean(var5_5, (boolean)var7_7);
                    this.constrainedWidth = var5_5;
                    break;
                }
                case 26: {
                    var7_7 = this.goneEndMargin;
                    this.goneEndMargin = var5_5 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    break;
                }
                case 25: {
                    var7_7 = this.goneStartMargin;
                    this.goneStartMargin = var5_5 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    break;
                }
                case 24: {
                    var7_7 = this.goneBottomMargin;
                    this.goneBottomMargin = var5_5 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    break;
                }
                case 23: {
                    var7_7 = this.goneRightMargin;
                    this.goneRightMargin = var5_5 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    break;
                }
                case 22: {
                    var7_7 = this.goneTopMargin;
                    this.goneTopMargin = var5_5 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    break;
                }
                case 21: {
                    var7_7 = this.goneLeftMargin;
                    this.goneLeftMargin = var5_5 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    break;
                }
                case 20: {
                    var7_7 = this.endToEnd;
                    this.endToEnd = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.endToEnd = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 19: {
                    var7_7 = this.endToStart;
                    this.endToStart = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.endToStart = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 18: {
                    var7_7 = this.startToStart;
                    this.startToStart = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.startToStart = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 17: {
                    var7_7 = this.startToEnd;
                    this.startToEnd = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.startToEnd = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 16: {
                    var7_7 = this.baselineToBaseline;
                    this.baselineToBaseline = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.baselineToBaseline = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 15: {
                    var7_7 = this.bottomToBottom;
                    this.bottomToBottom = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.bottomToBottom = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 14: {
                    var7_7 = this.bottomToTop;
                    this.bottomToTop = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.bottomToTop = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 13: {
                    var7_7 = this.topToBottom;
                    this.topToBottom = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.topToBottom = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 12: {
                    var7_7 = this.topToTop;
                    this.topToTop = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.topToTop = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 11: {
                    var7_7 = this.rightToRight;
                    this.rightToRight = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.rightToRight = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 10: {
                    var7_7 = this.rightToLeft;
                    this.rightToLeft = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.rightToLeft = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 9: {
                    var7_7 = this.leftToRight;
                    this.leftToRight = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.leftToRight = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 8: {
                    var7_7 = this.leftToLeft;
                    this.leftToLeft = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.leftToLeft = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 7: {
                    var8_8 = this.guidePercent;
                    this.guidePercent = var6_6 = var1_1.getFloat(var5_5, var8_8);
                    break;
                }
                case 6: {
                    var7_7 = this.guideEnd;
                    this.guideEnd = var5_5 = var1_1.getDimensionPixelOffset(var5_5, var7_7);
                    break;
                }
                case 5: {
                    var7_7 = this.guideBegin;
                    this.guideBegin = var5_5 = var1_1.getDimensionPixelOffset(var5_5, var7_7);
                    break;
                }
                case 4: {
                    var8_8 = this.circleAngle;
                    var6_6 = var1_1.getFloat(var5_5, var8_8);
                    var7_7 = 1135869952;
                    var8_8 = 360.0f;
                    this.circleAngle = var6_6 %= var8_8;
                    cfr_temp_2 = var6_6 - 0.0f;
                    var18_18 = cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1);
                    if (var18_18 >= 0) break;
                    this.circleAngle = var6_6 = (var8_8 - var6_6) % var8_8;
                    break;
                }
                case 3: {
                    var7_7 = this.circleRadius;
                    this.circleRadius = var5_5 = var1_1.getDimensionPixelSize(var5_5, var7_7);
                    break;
                }
                case 2: {
                    var7_7 = this.circleConstraint;
                    this.circleConstraint = var7_7 = var1_1.getResourceId(var5_5, var7_7);
                    if (var7_7 != var3_3) break;
                    this.circleConstraint = var5_5 = var1_1.getInt(var5_5, var3_3);
                    break;
                }
                case 1: {
                    var7_7 = this.orientation;
                    this.orientation = var5_5 = var1_1.getInt(var5_5, var7_7);
                }
            }
lbl414:
            // 79 sources

        }
        var1_1.recycle();
        this.validate();
        return;
        catch (NumberFormatException v4) {
            ** continue;
        }
    }

    public ConstraintLayout$LayoutParams(ViewGroup.LayoutParams object) {
        super(object);
        int n10;
        float f10;
        float f11;
        int n11;
        this.guideBegin = n11 = -1;
        this.guideEnd = n11;
        this.guidePercent = f11 = -1.0f;
        this.leftToLeft = n11;
        this.leftToRight = n11;
        this.rightToLeft = n11;
        this.rightToRight = n11;
        this.topToTop = n11;
        this.topToBottom = n11;
        this.bottomToTop = n11;
        this.bottomToBottom = n11;
        this.baselineToBaseline = n11;
        this.circleConstraint = n11;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = n11;
        this.startToStart = n11;
        this.endToStart = n11;
        this.endToEnd = n11;
        this.goneLeftMargin = n11;
        this.goneTopMargin = n11;
        this.goneRightMargin = n11;
        this.goneBottomMargin = n11;
        this.goneStartMargin = n11;
        this.goneEndMargin = n11;
        this.horizontalBias = f10 = 0.5f;
        this.verticalBias = f10;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = n10 = 1;
        this.horizontalWeight = f11;
        this.verticalWeight = f11;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = f11 = 1.0f;
        this.matchConstraintPercentHeight = f11;
        this.editorAbsoluteX = n11;
        this.editorAbsoluteY = n11;
        this.orientation = n11;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = n10;
        this.verticalDimensionFixed = n10;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = n11;
        this.resolvedLeftToRight = n11;
        this.resolvedRightToLeft = n11;
        this.resolvedRightToRight = n11;
        this.resolveGoneLeftMargin = n11;
        this.resolveGoneRightMargin = n11;
        this.resolvedHorizontalBias = f10;
        super();
        this.widget = object;
        this.helped = false;
    }

    public ConstraintLayout$LayoutParams(ConstraintLayout$LayoutParams object) {
        super((ViewGroup.MarginLayoutParams)object);
        float f10;
        int n10;
        float f11;
        float f12;
        int n11;
        this.guideBegin = n11 = -1;
        this.guideEnd = n11;
        this.guidePercent = f12 = -1.0f;
        this.leftToLeft = n11;
        this.leftToRight = n11;
        this.rightToLeft = n11;
        this.rightToRight = n11;
        this.topToTop = n11;
        this.topToBottom = n11;
        this.bottomToTop = n11;
        this.bottomToBottom = n11;
        this.baselineToBaseline = n11;
        this.circleConstraint = n11;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = n11;
        this.startToStart = n11;
        this.endToStart = n11;
        this.endToEnd = n11;
        this.goneLeftMargin = n11;
        this.goneTopMargin = n11;
        this.goneRightMargin = n11;
        this.goneBottomMargin = n11;
        this.goneStartMargin = n11;
        this.goneEndMargin = n11;
        this.horizontalBias = f11 = 0.5f;
        this.verticalBias = f11;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = n10 = 1;
        this.horizontalWeight = f12;
        this.verticalWeight = f12;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = f12 = 1.0f;
        this.matchConstraintPercentHeight = f12;
        this.editorAbsoluteX = n11;
        this.editorAbsoluteY = n11;
        this.orientation = n11;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.horizontalDimensionFixed = n10;
        this.verticalDimensionFixed = n10;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = n11;
        this.resolvedLeftToRight = n11;
        this.resolvedRightToLeft = n11;
        this.resolvedRightToRight = n11;
        this.resolveGoneLeftMargin = n11;
        this.resolveGoneRightMargin = n11;
        this.resolvedHorizontalBias = f11;
        Object object2 = new ConstraintWidget();
        this.widget = object2;
        this.helped = false;
        this.guideBegin = n11 = object.guideBegin;
        this.guideEnd = n11 = object.guideEnd;
        this.guidePercent = f10 = object.guidePercent;
        this.leftToLeft = n11 = object.leftToLeft;
        this.leftToRight = n11 = object.leftToRight;
        this.rightToLeft = n11 = object.rightToLeft;
        this.rightToRight = n11 = object.rightToRight;
        this.topToTop = n11 = object.topToTop;
        this.topToBottom = n11 = object.topToBottom;
        this.bottomToTop = n11 = object.bottomToTop;
        this.bottomToBottom = n11 = object.bottomToBottom;
        this.baselineToBaseline = n11 = object.baselineToBaseline;
        this.circleConstraint = n11 = object.circleConstraint;
        this.circleRadius = n11 = object.circleRadius;
        this.circleAngle = f10 = object.circleAngle;
        this.startToEnd = n11 = object.startToEnd;
        this.startToStart = n11 = object.startToStart;
        this.endToStart = n11 = object.endToStart;
        this.endToEnd = n11 = object.endToEnd;
        this.goneLeftMargin = n11 = object.goneLeftMargin;
        this.goneTopMargin = n11 = object.goneTopMargin;
        this.goneRightMargin = n11 = object.goneRightMargin;
        this.goneBottomMargin = n11 = object.goneBottomMargin;
        this.goneStartMargin = n11 = object.goneStartMargin;
        this.goneEndMargin = n11 = object.goneEndMargin;
        this.horizontalBias = f10 = object.horizontalBias;
        this.verticalBias = f10 = object.verticalBias;
        this.dimensionRatio = object2 = object.dimensionRatio;
        this.dimensionRatioValue = f10 = object.dimensionRatioValue;
        this.dimensionRatioSide = n11 = object.dimensionRatioSide;
        this.horizontalWeight = f10 = object.horizontalWeight;
        this.verticalWeight = f10 = object.verticalWeight;
        this.horizontalChainStyle = n11 = object.horizontalChainStyle;
        this.verticalChainStyle = n11 = object.verticalChainStyle;
        n11 = object.constrainedWidth ? 1 : 0;
        this.constrainedWidth = n11;
        n11 = object.constrainedHeight ? 1 : 0;
        this.constrainedHeight = n11;
        this.matchConstraintDefaultWidth = n11 = object.matchConstraintDefaultWidth;
        this.matchConstraintDefaultHeight = n11 = object.matchConstraintDefaultHeight;
        this.matchConstraintMinWidth = n11 = object.matchConstraintMinWidth;
        this.matchConstraintMaxWidth = n11 = object.matchConstraintMaxWidth;
        this.matchConstraintMinHeight = n11 = object.matchConstraintMinHeight;
        this.matchConstraintMaxHeight = n11 = object.matchConstraintMaxHeight;
        this.matchConstraintPercentWidth = f10 = object.matchConstraintPercentWidth;
        this.matchConstraintPercentHeight = f10 = object.matchConstraintPercentHeight;
        this.editorAbsoluteX = n11 = object.editorAbsoluteX;
        this.editorAbsoluteY = n11 = object.editorAbsoluteY;
        this.orientation = n11 = object.orientation;
        n11 = object.horizontalDimensionFixed ? 1 : 0;
        this.horizontalDimensionFixed = n11;
        n11 = object.verticalDimensionFixed ? 1 : 0;
        this.verticalDimensionFixed = n11;
        n11 = object.needsBaseline ? 1 : 0;
        this.needsBaseline = n11;
        n11 = object.isGuideline ? 1 : 0;
        this.isGuideline = n11;
        this.resolvedLeftToLeft = n11 = object.resolvedLeftToLeft;
        this.resolvedLeftToRight = n11 = object.resolvedLeftToRight;
        this.resolvedRightToLeft = n11 = object.resolvedRightToLeft;
        this.resolvedRightToRight = n11 = object.resolvedRightToRight;
        this.resolveGoneLeftMargin = n11 = object.resolveGoneLeftMargin;
        this.resolveGoneRightMargin = n11 = object.resolveGoneRightMargin;
        this.resolvedHorizontalBias = f10 = object.resolvedHorizontalBias;
        this.constraintTag = object2 = object.constraintTag;
        object = object.widget;
        this.widget = object;
    }

    public String getConstraintTag() {
        return this.constraintTag;
    }

    public ConstraintWidget getConstraintWidget() {
        return this.widget;
    }

    public void reset() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            constraintWidget.reset();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void resolveLayoutDirection(int var1_1) {
        var2_2 = this.leftMargin;
        var3_3 = this.rightMargin;
        var4_4 = Build.VERSION.SDK_INT;
        var5_5 = 0;
        var6_6 = 0.0f;
        var7_7 = 1;
        var8_8 = 1.4E-45f;
        var9_9 = 17;
        var10_10 = 2.4E-44f;
        if (var4_4 < var9_9) ** GOTO lbl-1000
        super.resolveLayoutDirection(var1_1);
        var1_1 = this.getLayoutDirection();
        if (var7_7 == var1_1) {
            var1_1 = var7_7;
            var11_11 = var8_8;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = 0;
            var11_11 = 0.0f;
        }
        this.resolvedRightToLeft = var4_4 = -1;
        this.resolvedRightToRight = var4_4;
        this.resolvedLeftToLeft = var4_4;
        this.resolvedLeftToRight = var4_4;
        this.resolveGoneLeftMargin = var4_4;
        this.resolveGoneRightMargin = var4_4;
        this.resolveGoneLeftMargin = var9_9 = this.goneLeftMargin;
        this.resolveGoneRightMargin = var9_9 = this.goneRightMargin;
        this.resolvedHorizontalBias = var10_10 = this.horizontalBias;
        this.resolvedGuideBegin = var12_12 = this.guideBegin;
        this.resolvedGuideEnd = var13_13 = this.guideEnd;
        this.resolvedGuidePercent = var14_14 = this.guidePercent;
        if (var1_1 != 0) {
            var1_1 = this.startToEnd;
            if (var1_1 != var4_4) {
                this.resolvedRightToLeft = var1_1;
lbl35:
                // 2 sources

                while (true) {
                    var5_5 = var7_7;
                    var6_6 = var8_8;
                    break;
                }
            } else {
                var1_1 = this.startToStart;
                if (var1_1 != var4_4) {
                    this.resolvedRightToRight = var1_1;
                    ** continue;
                }
            }
            var1_1 = this.endToStart;
            if (var1_1 != var4_4) {
                this.resolvedLeftToRight = var1_1;
                var5_5 = var7_7;
                var6_6 = var8_8;
            }
            if ((var1_1 = this.endToEnd) != var4_4) {
                this.resolvedLeftToLeft = var1_1;
                var5_5 = var7_7;
                var6_6 = var8_8;
            }
            if ((var1_1 = this.goneStartMargin) != var4_4) {
                this.resolveGoneRightMargin = var1_1;
            }
            if ((var1_1 = this.goneEndMargin) != var4_4) {
                this.resolveGoneLeftMargin = var1_1;
            }
            var1_1 = 1065353216;
            var11_11 = 1.0f;
            if (var5_5 != 0) {
                this.resolvedHorizontalBias = var6_6 = var11_11 - var10_10;
            }
            if ((var5_5 = (int)this.isGuideline) != 0 && (var5_5 = this.orientation) == var7_7) {
                var5_5 = -1082130432;
                var6_6 = -1.0f;
                cfr_temp_0 = var14_14 - var6_6;
                var7_7 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
                if (var7_7 != 0) {
                    this.resolvedGuidePercent = var11_11 -= var14_14;
                    this.resolvedGuideBegin = var4_4;
                    this.resolvedGuideEnd = var4_4;
                } else if (var12_12 != var4_4) {
                    this.resolvedGuideEnd = var12_12;
                    this.resolvedGuideBegin = var4_4;
                    this.resolvedGuidePercent = var6_6;
                } else if (var13_13 != var4_4) {
                    this.resolvedGuideBegin = var13_13;
                    this.resolvedGuideEnd = var4_4;
                    this.resolvedGuidePercent = var6_6;
                }
            }
        } else {
            var1_1 = this.startToEnd;
            if (var1_1 != var4_4) {
                this.resolvedLeftToRight = var1_1;
            }
            if ((var1_1 = this.startToStart) != var4_4) {
                this.resolvedLeftToLeft = var1_1;
            }
            if ((var1_1 = this.endToStart) != var4_4) {
                this.resolvedRightToLeft = var1_1;
            }
            if ((var1_1 = this.endToEnd) != var4_4) {
                this.resolvedRightToRight = var1_1;
            }
            if ((var1_1 = this.goneStartMargin) != var4_4) {
                this.resolveGoneLeftMargin = var1_1;
            }
            if ((var1_1 = this.goneEndMargin) != var4_4) {
                this.resolveGoneRightMargin = var1_1;
            }
        }
        if ((var1_1 = this.endToStart) == var4_4 && (var1_1 = this.endToEnd) == var4_4 && (var1_1 = this.startToStart) == var4_4 && (var1_1 = this.startToEnd) == var4_4) {
            var1_1 = this.rightToLeft;
            if (var1_1 != var4_4) {
                this.resolvedRightToLeft = var1_1;
                var1_1 = this.rightMargin;
                if (var1_1 <= 0 && var3_3 > 0) {
                    this.rightMargin = var3_3;
                }
            } else {
                var1_1 = this.rightToRight;
                if (var1_1 != var4_4) {
                    this.resolvedRightToRight = var1_1;
                    var1_1 = this.rightMargin;
                    if (var1_1 <= 0 && var3_3 > 0) {
                        this.rightMargin = var3_3;
                    }
                }
            }
            if ((var1_1 = this.leftToLeft) != var4_4) {
                this.resolvedLeftToLeft = var1_1;
                var1_1 = this.leftMargin;
                if (var1_1 <= 0 && var2_2 > 0) {
                    this.leftMargin = var2_2;
                }
            } else {
                var1_1 = this.leftToRight;
                if (var1_1 != var4_4) {
                    this.resolvedLeftToRight = var1_1;
                    var1_1 = this.leftMargin;
                    if (var1_1 <= 0 && var2_2 > 0) {
                        this.leftMargin = var2_2;
                    }
                }
            }
        }
    }

    public void setWidgetDebugName(String string2) {
        this.widget.setDebugName(string2);
    }

    public void validate() {
        int n10;
        int n11;
        int n12;
        int n13 = 0;
        float f10 = 0.0f;
        ConstraintWidget constraintWidget = null;
        this.isGuideline = false;
        this.horizontalDimensionFixed = n12 = 1;
        this.verticalDimensionFixed = n12;
        int n14 = this.width;
        int n15 = -2;
        if (n14 == n15 && (n11 = this.constrainedWidth) != 0) {
            this.horizontalDimensionFixed = false;
            n11 = this.matchConstraintDefaultWidth;
            if (n11 == 0) {
                this.matchConstraintDefaultWidth = n12;
            }
        }
        if ((n11 = this.height) == n15 && (n10 = (int)(this.constrainedHeight ? 1 : 0)) != 0) {
            this.verticalDimensionFixed = false;
            n10 = this.matchConstraintDefaultHeight;
            if (n10 == 0) {
                this.matchConstraintDefaultHeight = n12;
            }
        }
        n10 = -1;
        if (n14 == 0 || n14 == n10) {
            this.horizontalDimensionFixed = false;
            if (n14 == 0 && (n14 = this.matchConstraintDefaultWidth) == n12) {
                this.width = n15;
                this.constrainedWidth = n12;
            }
        }
        if (n11 == 0 || n11 == n10) {
            this.verticalDimensionFixed = false;
            if (n11 == 0 && (n13 = this.matchConstraintDefaultHeight) == n12) {
                this.height = n15;
                this.constrainedHeight = n12;
            }
        }
        f10 = this.guidePercent;
        n14 = -1082130432;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        n13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (n13 != 0 || (n13 = this.guideBegin) != n10 || (n13 = this.guideEnd) != n10) {
            this.isGuideline = n12;
            this.horizontalDimensionFixed = n12;
            this.verticalDimensionFixed = n12;
            constraintWidget = this.widget;
            n13 = constraintWidget instanceof Guideline;
            if (n13 == 0) {
                this.widget = constraintWidget = new Guideline();
            }
            constraintWidget = (Guideline)this.widget;
            n12 = this.orientation;
            ((Guideline)constraintWidget).setOrientation(n12);
        }
    }
}

