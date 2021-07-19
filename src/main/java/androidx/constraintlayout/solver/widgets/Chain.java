/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void applyChainConstraints(ConstraintWidgetContainer var0, LinearSystem var1_1, int var2_2, int var3_3, ChainHead var4_4) {
        block128: {
            block127: {
                block126: {
                    block125: {
                        var5_5 = var0;
                        var6_6 = var1_1;
                        var7_7 = var4_4;
                        var8_8 = var4_4.mFirst;
                        var9_9 = var4_4.mLast;
                        var10_10 = var4_4.mFirstVisibleWidget;
                        var11_11 = var4_4.mLastVisibleWidget;
                        var12_12 /* !! */  = var4_4.mHead;
                        var13_13 = var4_4.mTotalWeight;
                        var14_14 = var4_4.mFirstMatchConstraintWidget;
                        var14_14 = var4_4.mLastMatchConstraintWidget;
                        var14_14 = var0.mListDimensionBehaviors[var2_2];
                        var15_15 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                        var16_16 = 1;
                        var17_17 = 1.4E-45f;
                        if (var14_14 == var15_15) {
                            var18_18 = var16_16;
                            var19_19 = var17_17;
                        } else {
                            var18_18 = 0;
                            var19_19 = 0.0f;
                            var14_14 = null;
                        }
                        var20_20 = 2;
                        var21_21 = 2.8E-45f;
                        if (var2_2 != 0) break block125;
                        var22_22 = var12_12 /* !! */ .mHorizontalChainStyle;
                        if (var22_22 == 0) {
                            var23_23 = var16_16;
                            var24_24 = var17_17;
                        } else {
                            var23_23 = 0;
                            var24_24 = 0.0f;
                            var25_25 /* !! */  = null;
                        }
                        if (var22_22 == var16_16) {
                            var26_26 = var16_16;
                            var27_27 = var17_17;
                        } else {
                            var26_26 = 0;
                            var27_27 = 0.0f;
                            var28_28 = null;
                        }
                        if (var22_22 != var20_20) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                    }
                    var22_22 = var12_12 /* !! */ .mVerticalChainStyle;
                    if (var22_22 == 0) {
                        var23_23 = var16_16;
                        var24_24 = var17_17;
                    } else {
                        var23_23 = 0;
                        var24_24 = 0.0f;
                        var25_25 /* !! */  = null;
                    }
                    if (var22_22 == var16_16) {
                        var26_26 = var16_16;
                        var27_27 = var17_17;
                    } else {
                        var26_26 = 0;
                        var27_27 = 0.0f;
                        var28_28 = null;
                    }
                    if (var22_22 == var20_20) lbl-1000:
                    // 2 sources

                    {
                        var20_20 = var16_16;
                        var21_21 = var17_17;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var20_20 = 0;
                        var21_21 = 0.0f;
                        var15_15 = null;
                    }
                    var29_29 /* !! */  = var8_8;
                    var22_22 = 0;
                    var30_30 = 0.0f;
                    var31_31 = null;
                    while (true) {
                        var32_32 /* !! */  = null;
                        if (var22_22 != 0) break;
                        var33_33 /* !! */  = var29_29 /* !! */ .mListAnchors[var3_3];
                        if (var20_20 != 0) {
                            var34_34 = 1;
                            var35_35 = 1.4E-45f;
                        } else {
                            var34_34 = 4;
                            var35_35 = 5.6E-45f;
                        }
                        var36_36 = var33_33 /* !! */ .getMargin();
                        var37_37 = var13_13;
                        var38_38 = var29_29 /* !! */ .mListDimensionBehaviors[var2_2];
                        var39_39 = var22_22;
                        var40_40 = var30_30;
                        var31_31 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                        if (var38_38 == var31_31 && (var41_41 /* !! */  = (int)(var38_38 = (Object)var29_29 /* !! */ .mResolvedMatchConstraintDefault)[var2_2]) == 0) {
                            var42_42 = var26_26;
                            var43_43 = var27_27;
                            var41_41 /* !! */  = 1;
                            var13_13 = 1.4E-45f;
                        } else {
                            var42_42 = var26_26;
                            var43_43 = var27_27;
                            var41_41 /* !! */  = 0;
                            var13_13 = 0.0f;
                            var38_38 = null;
                        }
                        var28_28 = var33_33 /* !! */ .mTarget;
                        if (var28_28 != null && var29_29 /* !! */  != var8_8) {
                            var26_26 = var28_28.getMargin();
                            var36_36 += var26_26;
                        }
                        var26_26 = var36_36;
                        if (var20_20 != 0 && var29_29 /* !! */  != var8_8 && var29_29 /* !! */  != var10_10) {
                            var36_36 = var23_23;
                            var44_44 = var24_24;
                            var34_34 = 8;
                            var35_35 = 1.1E-44f;
                        } else {
                            var36_36 = var23_23;
                            var44_44 = var24_24;
                        }
                        var25_25 /* !! */  = var33_33 /* !! */ .mTarget;
                        if (var25_25 /* !! */  != null) {
                            if (var29_29 /* !! */  == var10_10) {
                                var45_45 /* !! */  = var12_12 /* !! */ ;
                                var12_12 /* !! */  = var33_33 /* !! */ .mSolverVariable;
                                var25_25 /* !! */  = var25_25 /* !! */ .mSolverVariable;
                                var46_46 = var8_8;
                                var47_47 = 6;
                                var48_48 = 8.4E-45f;
                                var6_6.addGreaterThan((SolverVariable)var12_12 /* !! */ , (SolverVariable)var25_25 /* !! */ , var26_26, var47_47);
                            } else {
                                var45_45 /* !! */  = var12_12 /* !! */ ;
                                var46_46 = var8_8;
                                var12_12 /* !! */  = var33_33 /* !! */ .mSolverVariable;
                                var8_8 = var25_25 /* !! */ .mSolverVariable;
                                var23_23 = 8;
                                var24_24 = 1.1E-44f;
                                var6_6.addGreaterThan((SolverVariable)var12_12 /* !! */ , (SolverVariable)var8_8, var26_26, var23_23);
                            }
                            if (var41_41 /* !! */  != 0 && var20_20 == 0) {
                                var49_49 = 5;
                                var50_50 = 7.0E-45f;
                            } else {
                                var49_49 = var34_34;
                                var50_50 = var35_35;
                            }
                            var38_38 = var33_33 /* !! */ .mSolverVariable;
                            var33_33 /* !! */  = var33_33 /* !! */ .mTarget.mSolverVariable;
                            var6_6.addEquality((SolverVariable)var38_38, (SolverVariable)var33_33 /* !! */ , var26_26, var49_49);
                        } else {
                            var45_45 /* !! */  = var12_12 /* !! */ ;
                            var46_46 = var8_8;
                        }
                        if (var18_18 != 0) {
                            var49_49 = var29_29 /* !! */ .getVisibility();
                            var41_41 /* !! */  = 8;
                            var13_13 = 1.1E-44f;
                            if (var49_49 != var41_41 /* !! */  && (var12_12 /* !! */  = var29_29 /* !! */ .mListDimensionBehaviors[var2_2]) == var31_31) {
                                var12_12 /* !! */  = var29_29 /* !! */ .mListAnchors;
                                var41_41 /* !! */  = var3_3 + 1;
                                var38_38 = var12_12 /* !! */ [var41_41 /* !! */ ].mSolverVariable;
                                var12_12 /* !! */  = var12_12 /* !! */ [var3_3].mSolverVariable;
                                var51_51 = 5;
                                var52_52 = 7.0E-45f;
                                var22_22 = 0;
                                var30_30 = 0.0f;
                                var31_31 = null;
                                var6_6.addGreaterThan((SolverVariable)var38_38, (SolverVariable)var12_12 /* !! */ , 0, var51_51);
                            } else {
                                var22_22 = 0;
                                var30_30 = 0.0f;
                                var31_31 = null;
                            }
                            var12_12 /* !! */  = var29_29 /* !! */ .mListAnchors[var3_3].mSolverVariable;
                            var38_38 = var5_5.mListAnchors[var3_3].mSolverVariable;
                            var51_51 = 8;
                            var52_52 = 1.1E-44f;
                            var6_6.addGreaterThan((SolverVariable)var12_12 /* !! */ , (SolverVariable)var38_38, 0, var51_51);
                        }
                        var12_12 /* !! */  = var29_29 /* !! */ .mListAnchors;
                        var41_41 /* !! */  = var3_3 + 1;
                        var12_12 /* !! */  = var12_12 /* !! */ [var41_41 /* !! */ ].mTarget;
                        if (var12_12 /* !! */  != null) {
                            var12_12 /* !! */  = var12_12 /* !! */ .mOwner;
                            var38_38 = var12_12 /* !! */ .mListAnchors;
                            var33_33 /* !! */  = var38_38[var3_3].mTarget;
                            if (var33_33 /* !! */  != null && (var38_38 = var38_38[var3_3].mTarget.mOwner) == var29_29 /* !! */ ) {
                                var32_32 /* !! */  = var12_12 /* !! */ ;
                            }
                        }
                        if (var32_32 /* !! */  != null) {
                            var29_29 /* !! */  = var32_32 /* !! */ ;
                            var22_22 = var39_39;
                            var30_30 = var40_40;
                        } else {
                            var22_22 = 1;
                            var30_30 = 1.4E-45f;
                        }
                        var23_23 = var36_36;
                        var24_24 = var44_44;
                        var13_13 = var37_37;
                        var26_26 = var42_42;
                        var27_27 = var43_43;
                        var12_12 /* !! */  = var45_45 /* !! */ ;
                        var8_8 = var46_46;
                    }
                    var45_45 /* !! */  = var12_12 /* !! */ ;
                    var37_37 = var13_13;
                    var46_46 = var8_8;
                    var36_36 = var23_23;
                    var44_44 = var24_24;
                    var42_42 = var26_26;
                    var43_43 = var27_27;
                    if (var11_11 == null) break block126;
                    var12_12 /* !! */  = var9_9.mListAnchors;
                    var41_41 /* !! */  = var3_3 + 1;
                    var12_12 /* !! */  = var12_12 /* !! */ [var41_41 /* !! */ ].mTarget;
                    if (var12_12 /* !! */  == null) break block126;
                    var12_12 /* !! */  = var11_11.mListAnchors[var41_41 /* !! */ ];
                    var33_33 /* !! */  = var11_11.mListDimensionBehaviors[var2_2];
                    var29_29 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (var33_33 /* !! */  == var29_29 /* !! */  && (var51_51 = (var33_33 /* !! */  = (ConstraintAnchor[])var11_11.mResolvedMatchConstraintDefault)[var2_2]) == 0) {
                        var51_51 = true;
                        var52_52 = 1.4E-45f;
                    } else {
                        var51_51 = false;
                        var52_52 = 0.0f;
                        var33_33 /* !! */  = null;
                    }
                    if (var51_51 == false || var20_20 != 0) ** GOTO lbl-1000
                    var33_33 /* !! */  = var12_12 /* !! */ .mTarget;
                    var29_29 /* !! */  = var33_33 /* !! */ .mOwner;
                    if (var29_29 /* !! */  == var5_5) {
                        var29_29 /* !! */  = var12_12 /* !! */ .mSolverVariable;
                        var33_33 /* !! */  = var33_33 /* !! */ .mSolverVariable;
                        var22_22 = -var12_12 /* !! */ .getMargin();
                        var47_47 = 5;
                        var48_48 = 7.0E-45f;
                        var6_6.addEquality((SolverVariable)var29_29 /* !! */ , (SolverVariable)var33_33 /* !! */ , var22_22, var47_47);
                    } else lbl-1000:
                    // 2 sources

                    {
                        var47_47 = 5;
                        var48_48 = 7.0E-45f;
                        if (var20_20 != 0) {
                            var33_33 /* !! */  = var12_12 /* !! */ .mTarget;
                            var29_29 /* !! */  = var33_33 /* !! */ .mOwner;
                            if (var29_29 /* !! */  == var5_5) {
                                var29_29 /* !! */  = var12_12 /* !! */ .mSolverVariable;
                                var33_33 /* !! */  = var33_33 /* !! */ .mSolverVariable;
                                var22_22 = -var12_12 /* !! */ .getMargin();
                                var23_23 = 4;
                                var24_24 = 5.6E-45f;
                                var6_6.addEquality((SolverVariable)var29_29 /* !! */ , (SolverVariable)var33_33 /* !! */ , var22_22, var23_23);
                            }
                        }
                    }
                    var33_33 /* !! */  = var12_12 /* !! */ .mSolverVariable;
                    var29_29 /* !! */  = var9_9.mListAnchors;
                    var38_38 = var29_29 /* !! */ [var41_41 /* !! */ ].mTarget.mSolverVariable;
                    var49_49 = -var12_12 /* !! */ .getMargin();
                    var16_16 = 6;
                    var17_17 = 8.4E-45f;
                    var6_6.addLowerThan((SolverVariable)var33_33 /* !! */ , (SolverVariable)var38_38, var49_49, var16_16);
                    break block127;
                }
                var47_47 = 5;
                var48_48 = 7.0E-45f;
            }
            if (var18_18 != 0) {
                var5_5 = var5_5.mListAnchors;
                var49_49 = var3_3 + 1;
                var5_5 = var5_5[var49_49].mSolverVariable;
                var38_38 = var9_9.mListAnchors;
                var14_14 = var38_38[var49_49].mSolverVariable;
                var12_12 /* !! */  = var38_38[var49_49];
                var49_49 = var12_12 /* !! */ .getMargin();
                var41_41 /* !! */  = 8;
                var13_13 = 1.1E-44f;
                var6_6.addGreaterThan((SolverVariable)var5_5, (SolverVariable)var14_14, var49_49, var41_41 /* !! */ );
            }
            if ((var5_5 = var7_7.mWeightedMatchConstraintsWidgets) == null) break block128;
            var49_49 = var5_5.size();
            var41_41 /* !! */  = 1;
            var13_13 = 1.4E-45f;
            if (var49_49 <= var41_41 /* !! */ ) break block128;
            var18_18 = (int)var7_7.mHasUndefinedWeights;
            if (var18_18 != 0 && (var18_18 = (int)var7_7.mHasComplexMatchWeights) == 0) {
                var18_18 = var7_7.mWidgetsMatchCount;
                var19_19 = var18_18;
            } else {
                var19_19 = var37_37;
            }
            var51_51 = false;
            var52_52 = 0.0f;
            var33_33 /* !! */  = null;
            var53_53 = 0.0f;
            var16_16 = 0;
            var29_29 /* !! */  = null;
            var17_17 = 0.0f;
            var30_30 = 0.0f;
            var31_31 = null;
            for (var22_22 = 0; var22_22 < var49_49; ++var22_22) {
                block131: {
                    block129: {
                        block130: {
                            var25_25 /* !! */  = (ConstraintWidget)var5_5.get(var22_22);
                            var28_28 = var25_25 /* !! */ .mWeight;
                            var27_27 = (float)var28_28[var2_2];
                            cfr_temp_0 = var27_27 - 0.0f;
                            var54_54 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1);
                            if (var54_54 >= 0) break block129;
                            var26_26 = (int)var7_7.mHasComplexMatchWeights;
                            if (var26_26 == 0) break block130;
                            var25_25 /* !! */  = var25_25 /* !! */ .mListAnchors;
                            var26_26 = var3_3 + 1;
                            var28_28 = var25_25 /* !! */ [var26_26].mSolverVariable;
                            var25_25 /* !! */  = var25_25 /* !! */ [var3_3].mSolverVariable;
                            var41_41 /* !! */  = 0;
                            var13_13 = 0.0f;
                            var38_38 = null;
                            var47_47 = 4;
                            var48_48 = 5.6E-45f;
                            var6_6.addEquality((SolverVariable)var28_28, (SolverVariable)var25_25 /* !! */ , 0, var47_47);
                            var51_51 = 0;
                            var33_33 /* !! */  = null;
                            var52_52 = 0.0f;
                            ** GOTO lbl326
                        }
                        var47_47 = 4;
                        var48_48 = 5.6E-45f;
                        var26_26 = 1065353216;
                        var27_27 = 1.0f;
                        break block131;
                    }
                    var47_47 = 4;
                    var48_48 = 5.6E-45f;
                }
                var41_41 /* !! */  = (cfr_temp_1 = var27_27 - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1);
                if (var41_41 /* !! */  == 0) {
                    var38_38 = var25_25 /* !! */ .mListAnchors;
                    var23_23 = var3_3 + 1;
                    var25_25 /* !! */  = var38_38[var23_23].mSolverVariable;
                    var38_38 = var38_38[var3_3].mSolverVariable;
                    var51_51 = 0;
                    var52_52 = 0.0f;
                    var33_33 /* !! */  = null;
                    var26_26 = 8;
                    var27_27 = 1.1E-44f;
                    var6_6.addEquality((SolverVariable)var25_25 /* !! */ , (SolverVariable)var38_38, 0, var26_26);
lbl326:
                    // 2 sources

                    var55_55 = var5_5;
                } else {
                    var51_51 = 0;
                    var52_52 = 0.0f;
                    var33_33 /* !! */  = null;
                    if (var29_29 /* !! */  != null) {
                        var38_38 = var29_29 /* !! */ .mListAnchors;
                        var29_29 /* !! */  = var38_38[var3_3].mSolverVariable;
                        var56_56 = var3_3 + 1;
                        var38_38 = var38_38[var56_56].mSolverVariable;
                        var33_33 /* !! */  = var25_25 /* !! */ .mListAnchors;
                        var8_8 = var33_33 /* !! */ [var3_3].mSolverVariable;
                        var33_33 /* !! */  = var33_33 /* !! */ [var56_56].mSolverVariable;
                        var55_55 = var5_5;
                        var5_5 = var1_1.createRow();
                        var5_5.createRowEqualMatchDimensions(var53_53, var19_19, var27_27, (SolverVariable)var29_29 /* !! */ , (SolverVariable)var38_38, (SolverVariable)var8_8, (SolverVariable)var33_33 /* !! */ );
                        var6_6.addConstraint((ArrayRow)var5_5);
                    } else {
                        var55_55 = var5_5;
                    }
                    var29_29 /* !! */  = var25_25 /* !! */ ;
                    var53_53 = var27_27;
                }
                var5_5 = var55_55;
                var41_41 /* !! */  = 1;
                var13_13 = 1.4E-45f;
                var51_51 = 0;
                var52_52 = 0.0f;
                var33_33 /* !! */  = null;
                var47_47 = 5;
                var48_48 = 7.0E-45f;
            }
        }
        if (var10_10 != null && (var10_10 == var11_11 || var20_20 != 0)) {
            var8_8 = var46_46;
            var5_5 = var46_46.mListAnchors[var3_3];
            var7_7 = var9_9.mListAnchors;
            var49_49 = var3_3 + 1;
            var7_7 = var7_7[var49_49];
            var5_5 = var5_5.mTarget;
            if (var5_5 != null) {
                var38_38 = var5_5 = var5_5.mSolverVariable;
            } else {
                var41_41 /* !! */  = 0;
                var38_38 = null;
                var13_13 = 0.0f;
            }
            var5_5 = var7_7.mTarget;
            if (var5_5 != null) {
                var15_15 = var5_5 = var5_5.mSolverVariable;
            } else {
                var20_20 = 0;
                var15_15 = null;
                var21_21 = 0.0f;
            }
            var5_5 = var10_10.mListAnchors[var3_3];
            var7_7 = var11_11.mListAnchors[var49_49];
            if (var38_38 != null && var15_15 != null) {
                if (var2_2 == 0) {
                    var12_12 /* !! */  = var45_45 /* !! */ ;
                    var50_50 = var45_45 /* !! */ .mHorizontalBiasPercent;
                } else {
                    var12_12 /* !! */  = var45_45 /* !! */ ;
                    var50_50 = var45_45 /* !! */ .mVerticalBiasPercent;
                }
                var19_19 = var50_50;
                var51_51 = var5_5.getMargin();
                var16_16 = var7_7.getMargin();
                var12_12 /* !! */  = var5_5.mSolverVariable;
                var31_31 = var7_7.mSolverVariable;
                var47_47 = 7;
                var48_48 = 9.8E-45f;
                var5_5 = var1_1;
                var7_7 = var12_12 /* !! */ ;
                var12_12 /* !! */  = var38_38;
                var41_41 /* !! */  = var51_51;
                var33_33 /* !! */  = var31_31;
                var22_22 = var47_47;
                var30_30 = var48_48;
                var1_1.addCentering((SolverVariable)var7_7, (SolverVariable)var38_38, var51_51, var50_50, (SolverVariable)var15_15, (SolverVariable)var31_31, var16_16, var47_47);
            }
        } else {
            var8_8 = var46_46;
            if (var36_36 != 0 && var10_10 != null) {
                var57_57 = var7_7.mWidgetsMatchCount;
                if (var57_57 > 0 && (var58_59 = var7_7.mWidgetsCount) == var57_57) {
                    var54_54 = 1;
                    var59_61 = 1.4E-45f;
                } else {
                    var54_54 = 0;
                    var59_61 = 0.0f;
                }
                var25_25 /* !! */  = var10_10;
                var28_28 = var10_10;
                while (var25_25 /* !! */  != null) {
                    block124: {
                        var31_31 = var5_5 = var25_25 /* !! */ .mNextChainWidget[var2_2];
                        while (var31_31 != null) {
                            var57_57 = var31_31.getVisibility();
                            var51_51 = 8;
                            var52_52 = 1.1E-44f;
                            if (var57_57 == var51_51) {
                                var5_5 = var31_31.mNextChainWidget;
                                var31_31 = var5_5[var2_2];
                                continue;
                            }
                            break block124;
                        }
                        var51_51 = 8;
                        var52_52 = 1.1E-44f;
                    }
                    if (var31_31 == null && var25_25 /* !! */  != var11_11) {
                        while (true) {
                            var55_55 = var31_31;
                            break;
                        }
                    } else {
                        var5_5 = var25_25 /* !! */ .mListAnchors[var3_3];
                        var7_7 = var5_5.mSolverVariable;
                        var12_12 /* !! */  = var5_5.mTarget;
                        if (var12_12 /* !! */  != null) {
                            var12_12 /* !! */  = var12_12 /* !! */ .mSolverVariable;
                        } else {
                            var49_49 = 0;
                            var12_12 /* !! */  = null;
                            var50_50 = 0.0f;
                        }
                        if (var28_28 != var25_25 /* !! */ ) {
                            var12_12 /* !! */  = var28_28.mListAnchors;
                            var41_41 /* !! */  = var3_3 + 1;
                            var12_12 /* !! */  = var12_12 /* !! */ [var41_41 /* !! */ ].mSolverVariable;
                        } else if (var25_25 /* !! */  == var10_10 && var28_28 == var25_25 /* !! */ ) {
                            var12_12 /* !! */  = var8_8.mListAnchors;
                            var38_38 = var12_12 /* !! */ [var3_3].mTarget;
                            if (var38_38 != null) {
                                var12_12 /* !! */  = var12_12 /* !! */ [var3_3].mTarget.mSolverVariable;
                            } else {
                                var49_49 = 0;
                                var12_12 /* !! */  = null;
                                var50_50 = 0.0f;
                            }
                        }
                        var57_57 = var5_5.getMargin();
                        var38_38 = var25_25 /* !! */ .mListAnchors;
                        var18_18 = var3_3 + 1;
                        var38_38 = var38_38[var18_18];
                        var41_41 /* !! */  = var38_38.getMargin();
                        if (var31_31 != null) {
                            var15_15 = var31_31.mListAnchors[var3_3];
                            var29_29 /* !! */  = var15_15.mSolverVariable;
                            var33_33 /* !! */  = var25_25 /* !! */ .mListAnchors[var18_18].mSolverVariable;
                            var60_63 /* !! */  = var29_29 /* !! */ ;
                            var29_29 /* !! */  = var33_33 /* !! */ ;
                            var33_33 /* !! */  = var60_63 /* !! */ ;
                        } else {
                            var15_15 = var9_9.mListAnchors[var18_18].mTarget;
                            if (var15_15 != null) {
                                var33_33 /* !! */  = var15_15.mSolverVariable;
                            } else {
                                var51_51 = 0;
                                var33_33 /* !! */  = null;
                                var52_52 = 0.0f;
                            }
                            var29_29 /* !! */  = var25_25 /* !! */ .mListAnchors[var18_18].mSolverVariable;
                        }
                        if (var15_15 != null) {
                            var20_20 = var15_15.getMargin();
                            var41_41 /* !! */  += var20_20;
                        }
                        if (var28_28 != null) {
                            var15_15 = var28_28.mListAnchors[var18_18];
                            var20_20 = var15_15.getMargin();
                            var57_57 += var20_20;
                        }
                        if (var7_7 == null || var12_12 /* !! */  == null || var33_33 /* !! */  == null || var29_29 /* !! */  == null) ** continue;
                        if (var25_25 /* !! */  == var10_10) {
                            var5_5 = var10_10.mListAnchors[var3_3];
                            var57_57 = var5_5.getMargin();
                        }
                        var20_20 = var57_57;
                        if (var25_25 /* !! */  == var11_11) {
                            var5_5 = var11_11.mListAnchors[var18_18];
                            var56_56 = var57_57 = var5_5.getMargin();
                        } else {
                            var56_56 = var41_41 /* !! */ ;
                        }
                        if (var54_54 != 0) {
                            var61_64 = 8;
                            var62_66 = 1.1E-44f;
                        } else {
                            var61_64 = 5;
                            var62_66 = 7.0E-45f;
                        }
                        var18_18 = 0x3F000000;
                        var19_19 = 0.5f;
                        var5_5 = var1_1;
                        var41_41 /* !! */  = var20_20;
                        var15_15 = var33_33 /* !! */ ;
                        var33_33 /* !! */  = var29_29 /* !! */ ;
                        var16_16 = var56_56;
                        var55_55 = var31_31;
                        var22_22 = var61_64;
                        var30_30 = var62_66;
                        var1_1.addCentering((SolverVariable)var7_7, (SolverVariable)var12_12 /* !! */ , var20_20, var19_19, (SolverVariable)var15_15, (SolverVariable)var29_29 /* !! */ , var56_56, var61_64);
                    }
                    var57_57 = var25_25 /* !! */ .getVisibility();
                    var22_22 = 8;
                    var30_30 = 1.1E-44f;
                    if (var57_57 != var22_22) {
                        var28_28 = var25_25 /* !! */ ;
                    }
                    var25_25 /* !! */  = var55_55;
                }
            } else {
                var22_22 = 8;
                var30_30 = 1.1E-44f;
                if (var42_42 != 0 && var10_10 != null) {
                    var57_58 = var7_7.mWidgetsMatchCount;
                    if (var57_58 > 0 && (var58_60 = var7_7.mWidgetsCount) == var57_58) {
                        var54_54 = 1;
                        var59_62 = 1.4E-45f;
                    } else {
                        var54_54 = 0;
                        var59_62 = 0.0f;
                    }
                    var25_25 /* !! */  = var10_10;
                    var28_28 = var10_10;
                    while (var25_25 /* !! */  != null) {
                        var5_5 = var25_25 /* !! */ .mNextChainWidget[var2_2];
                        while (var5_5 != null && (var58_60 = var5_5.getVisibility()) == var22_22) {
                            var5_5 = var5_5.mNextChainWidget[var2_2];
                        }
                        if (var25_25 /* !! */  != var10_10 && var25_25 /* !! */  != var11_11 && var5_5 != null) {
                            if (var5_5 == var11_11) {
                                var16_16 = 0;
                                var29_29 /* !! */  = null;
                                var17_17 = 0.0f;
                            } else {
                                var29_29 /* !! */  = var5_5;
                            }
                            var5_5 = var25_25 /* !! */ .mListAnchors[var3_3];
                            var7_7 = var5_5.mSolverVariable;
                            var12_12 /* !! */  = var5_5.mTarget;
                            if (var12_12 /* !! */  != null) {
                                var12_12 /* !! */  = var12_12 /* !! */ .mSolverVariable;
                            }
                            var12_12 /* !! */  = var28_28.mListAnchors;
                            var41_41 /* !! */  = var3_3 + 1;
                            var12_12 /* !! */  = var12_12 /* !! */ [var41_41 /* !! */ ].mSolverVariable;
                            var57_58 = var5_5.getMargin();
                            var14_14 = var25_25 /* !! */ .mListAnchors[var41_41 /* !! */ ];
                            var18_18 = var14_14.getMargin();
                            if (var29_29 /* !! */  != null) {
                                var15_15 = var29_29 /* !! */ .mListAnchors[var3_3];
                                var33_33 /* !! */  = var15_15.mSolverVariable;
                                var31_31 = var15_15.mTarget;
                                if (var31_31 != null) {
                                    var31_31 = var31_31.mSolverVariable;
                                } else {
                                    var22_22 = 0;
                                    var31_31 = null;
                                    var30_30 = 0.0f;
                                }
                            } else {
                                var15_15 = var11_11.mListAnchors[var3_3];
                                if (var15_15 != null) {
                                    var33_33 /* !! */  = var15_15.mSolverVariable;
                                } else {
                                    var51_51 = 0;
                                    var33_33 /* !! */  = null;
                                    var52_52 = 0.0f;
                                }
                                var31_31 = var25_25 /* !! */ .mListAnchors[var41_41 /* !! */ ].mSolverVariable;
                            }
                            if (var15_15 != null) {
                                var20_20 = var15_15.getMargin();
                                var18_18 += var20_20;
                            }
                            var56_56 = var18_18;
                            if (var28_28 != null) {
                                var14_14 = var28_28.mListAnchors;
                                var38_38 = var14_14[var41_41 /* !! */ ];
                                var41_41 /* !! */  = var38_38.getMargin();
                                var57_58 += var41_41 /* !! */ ;
                            }
                            var41_41 /* !! */  = var57_58;
                            if (var54_54 != 0) {
                                var61_65 = 8;
                                var62_67 = 1.1E-44f;
                            } else {
                                var61_65 = 4;
                                var62_67 = 5.6E-45f;
                            }
                            if (var7_7 != null && var12_12 /* !! */  != null && var33_33 /* !! */  != null && var31_31 != null) {
                                var18_18 = 0x3F000000;
                                var19_19 = 0.5f;
                                var5_5 = var1_1;
                                var15_15 = var33_33 /* !! */ ;
                                var34_34 = 4;
                                var35_35 = 5.6E-45f;
                                var33_33 /* !! */  = var31_31;
                                var63_68 /* !! */  = var29_29 /* !! */ ;
                                var16_16 = var56_56;
                                var55_55 = var28_28;
                                var26_26 = 8;
                                var27_27 = 1.1E-44f;
                                var22_22 = var61_65;
                                var30_30 = var62_67;
                                var1_1.addCentering((SolverVariable)var7_7, (SolverVariable)var12_12 /* !! */ , var41_41 /* !! */ , var19_19, (SolverVariable)var15_15, (SolverVariable)var31_31, var56_56, var61_65);
                            } else {
                                var63_68 /* !! */  = var29_29 /* !! */ ;
                                var55_55 = var28_28;
                                var26_26 = 8;
                                var27_27 = 1.1E-44f;
                                var34_34 = 4;
                                var35_35 = 5.6E-45f;
                            }
                            var5_5 = var63_68 /* !! */ ;
                        } else {
                            var55_55 = var28_28;
                            var34_34 = 4;
                            var35_35 = 5.6E-45f;
                            var26_26 = var22_22;
                            var27_27 = var30_30;
                        }
                        var58_60 = var25_25 /* !! */ .getVisibility();
                        if (var58_60 == var26_26) {
                            var25_25 /* !! */  = var55_55;
                        }
                        var22_22 = var26_26;
                        var30_30 = var27_27;
                        var28_28 = var25_25 /* !! */ ;
                        var25_25 /* !! */  = var5_5;
                    }
                    var5_5 = var10_10.mListAnchors[var3_3];
                    var7_7 = var8_8.mListAnchors[var3_3].mTarget;
                    var12_12 /* !! */  = var11_11.mListAnchors;
                    var41_41 /* !! */  = var3_3 + 1;
                    var8_8 = var12_12 /* !! */ [var41_41 /* !! */ ];
                    var12_12 /* !! */  = var9_9.mListAnchors[var41_41 /* !! */ ];
                    var25_25 /* !! */  = var12_12 /* !! */ .mTarget;
                    if (var7_7 != null) {
                        if (var10_10 != var11_11) {
                            var12_12 /* !! */  = var5_5.mSolverVariable;
                            var7_7 = var7_7.mSolverVariable;
                            var57_58 = var5_5.getMargin();
                            var26_26 = 5;
                            var27_27 = 7.0E-45f;
                            var6_6.addEquality((SolverVariable)var12_12 /* !! */ , (SolverVariable)var7_7, var57_58, var26_26);
                        } else {
                            var26_26 = 5;
                            var27_27 = 7.0E-45f;
                            if (var25_25 /* !! */  != null) {
                                var12_12 /* !! */  = var5_5.mSolverVariable;
                                var38_38 = var7_7.mSolverVariable;
                                var18_18 = var5_5.getMargin();
                                var20_20 = 0x3F000000;
                                var21_21 = 0.5f;
                                var33_33 /* !! */  = var8_8.mSolverVariable;
                                var29_29 /* !! */  = var25_25 /* !! */ .mSolverVariable;
                                var22_22 = var8_8.getMargin();
                                var54_54 = 5;
                                var59_62 = 7.0E-45f;
                                var5_5 = var1_1;
                                var7_7 = var12_12 /* !! */ ;
                                var12_12 /* !! */  = var38_38;
                                var41_41 /* !! */  = var18_18;
                                var18_18 = var20_20;
                                var19_19 = var21_21;
                                var15_15 = var33_33 /* !! */ ;
                                var33_33 /* !! */  = var29_29 /* !! */ ;
                                var16_16 = var22_22;
                                var22_22 = var54_54;
                                var30_30 = var59_62;
                                var1_1.addCentering((SolverVariable)var7_7, (SolverVariable)var38_38, var41_41 /* !! */ , var21_21, (SolverVariable)var15_15, (SolverVariable)var29_29 /* !! */ , var16_16, var54_54);
                            }
                        }
                    } else {
                        var26_26 = 5;
                        var27_27 = 7.0E-45f;
                    }
                    if (var25_25 /* !! */  != null && var10_10 != var11_11) {
                        var5_5 = var8_8.mSolverVariable;
                        var7_7 = var25_25 /* !! */ .mSolverVariable;
                        var49_49 = -var8_8.getMargin();
                        var6_6.addEquality((SolverVariable)var5_5, (SolverVariable)var7_7, var49_49, var26_26);
                    }
                }
            }
        }
        if ((var36_36 != 0 || var42_42 != 0) && var10_10 != null && var10_10 != var11_11) {
            var5_5 = var10_10.mListAnchors;
            var7_7 = var5_5[var3_3];
            var12_12 /* !! */  = var11_11.mListAnchors;
            var41_41 /* !! */  = var3_3 + 1;
            var12_12 /* !! */  = var12_12 /* !! */ [var41_41 /* !! */ ];
            var14_14 = var7_7.mTarget;
            if (var14_14 != null) {
                var14_14 = var14_14.mSolverVariable;
            } else {
                var18_18 = 0;
                var14_14 = null;
                var19_19 = 0.0f;
            }
            var15_15 = var12_12 /* !! */ .mTarget;
            if (var15_15 != null) {
                var15_15 = var15_15.mSolverVariable;
            } else {
                var20_20 = 0;
                var15_15 = null;
                var21_21 = 0.0f;
            }
            if (var9_9 != var11_11) {
                var15_15 = var9_9.mListAnchors[var41_41 /* !! */ ].mTarget;
                if (var15_15 != null) {
                    var15_15 = var15_15.mSolverVariable;
                    var32_32 /* !! */  = var15_15;
                }
                var15_15 = var32_32 /* !! */ ;
            }
            if (var10_10 == var11_11) {
                var7_7 = var5_5[var3_3];
                var12_12 /* !! */  = var5_5[var41_41 /* !! */ ];
            }
            if (var14_14 != null && var15_15 != null) {
                var51_51 = 0x3F000000;
                var52_52 = 0.5f;
                var16_16 = var7_7.getMargin();
                if (var11_11 != null) {
                    var9_9 = var11_11;
                }
                var22_22 = var9_9.mListAnchors[var41_41 /* !! */ ].getMargin();
                var7_7 = var7_7.mSolverVariable;
                var8_8 = var12_12 /* !! */ .mSolverVariable;
                var64_69 = 5;
                var65_70 = 7.0E-45f;
                var5_5 = var1_1;
                var12_12 /* !! */  = var14_14;
                var41_41 /* !! */  = var16_16;
                var18_18 = var51_51;
                var19_19 = var52_52;
                var33_33 /* !! */  = var8_8;
                var16_16 = var22_22;
                var22_22 = var64_69;
                var30_30 = var65_70;
                var1_1.addCentering((SolverVariable)var7_7, (SolverVariable)var14_14, var41_41 /* !! */ , var52_52, (SolverVariable)var15_15, (SolverVariable)var8_8, var16_16, var64_69);
            }
        }
    }

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList arrayList, int n10) {
        int n11;
        ChainHead[] chainHeadArray;
        int n12;
        int n13 = 0;
        if (n10 == 0) {
            n12 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArray = constraintWidgetContainer.mHorizontalChainsArray;
            n11 = 0;
        } else {
            n11 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArray = constraintWidgetContainer.mVerticalChainsArray;
            int n14 = n11;
            n11 = 2;
            n12 = n14;
        }
        while (n13 < n12) {
            ConstraintWidget constraintWidget;
            boolean bl2;
            ChainHead chainHead = chainHeadArray[n13];
            chainHead.define();
            if (arrayList == null || arrayList != null && (bl2 = arrayList.contains(constraintWidget = chainHead.mFirst))) {
                Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, n10, n11, chainHead);
            }
            ++n13;
        }
    }
}

