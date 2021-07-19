/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;

public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public static WidgetGroup findDependents(ConstraintWidget object, int n10, ArrayList arrayList, WidgetGroup widgetGroup) {
        ConstraintAnchor constraintAnchor;
        Object object2;
        int n11;
        WidgetGroup widgetGroup2;
        int n12;
        int n13 = n10 == 0 ? ((ConstraintWidget)object).horizontalGroup : ((ConstraintWidget)object).verticalGroup;
        int n14 = 0;
        int n15 = -1;
        if (n13 != n15 && (widgetGroup == null || n13 != (n12 = widgetGroup.id))) {
            widgetGroup2 = null;
            for (n12 = 0; n12 < (n11 = arrayList.size()); ++n12) {
                WidgetGroup widgetGroup3 = (WidgetGroup)arrayList.get(n12);
                int n16 = widgetGroup3.getId();
                if (n16 != n13) continue;
                if (widgetGroup != null) {
                    widgetGroup.moveTo(n10, widgetGroup3);
                    arrayList.remove(widgetGroup);
                }
                widgetGroup = widgetGroup3;
                break;
            }
        } else if (n13 != n15) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            n13 = object instanceof HelperWidget;
            if (n13 != 0) {
                object2 = object;
                object2 = (HelperWidget)object;
                n13 = ((HelperWidget)object2).findGroupInDependents(n10);
                if (n13 != n15) {
                    constraintAnchor = null;
                    for (n15 = 0; n15 < (n12 = arrayList.size()); ++n15) {
                        widgetGroup2 = (WidgetGroup)arrayList.get(n15);
                        n11 = widgetGroup2.getId();
                        if (n11 != n13) continue;
                        widgetGroup = widgetGroup2;
                        break;
                    }
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(n10);
            }
            arrayList.add(widgetGroup);
        }
        if ((n13 = (int)(widgetGroup.add((ConstraintWidget)object) ? 1 : 0)) != 0) {
            n13 = object instanceof Guideline;
            if (n13 != 0) {
                object2 = object;
                object2 = (Guideline)object;
                constraintAnchor = ((Guideline)object2).getAnchor();
                n13 = ((Guideline)object2).getOrientation();
                if (n13 == 0) {
                    n14 = 1;
                }
                constraintAnchor.findDependents(n14, arrayList, widgetGroup);
            }
            if (n10 == 0) {
                ((ConstraintWidget)object).horizontalGroup = n13 = widgetGroup.getId();
                ((ConstraintWidget)object).mLeft.findDependents(n10, arrayList, widgetGroup);
                object2 = ((ConstraintWidget)object).mRight;
                ((ConstraintAnchor)object2).findDependents(n10, arrayList, widgetGroup);
            } else {
                ((ConstraintWidget)object).verticalGroup = n13 = widgetGroup.getId();
                ((ConstraintWidget)object).mTop.findDependents(n10, arrayList, widgetGroup);
                ((ConstraintWidget)object).mBaseline.findDependents(n10, arrayList, widgetGroup);
                object2 = ((ConstraintWidget)object).mBottom;
                ((ConstraintAnchor)object2).findDependents(n10, arrayList, widgetGroup);
            }
            object = ((ConstraintWidget)object).mCenter;
            ((ConstraintAnchor)object).findDependents(n10, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static WidgetGroup findGroup(ArrayList arrayList, int n10) {
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            WidgetGroup widgetGroup = (WidgetGroup)arrayList.get(i10);
            int n12 = widgetGroup.id;
            if (n10 != n12) continue;
            return widgetGroup;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean simpleSolvingPass(ConstraintWidgetContainer var0, BasicMeasure$Measurer var1_1) {
        block60: {
            block59: {
                block58: {
                    var2_2 = var0;
                    var3_3 /* !! */  = var0.getChildren();
                    var4_4 = var3_3 /* !! */ .size();
                    var5_5 = 0;
                    var6_6 = null;
                    var8_8 = null;
                    for (var7_7 = 0; var7_7 < var4_4; ++var7_7) {
                        var9_9 = (ConstraintWidget)var3_3 /* !! */ .get(var7_7);
                        var10_10 /* !! */  = var0.getHorizontalDimensionBehaviour();
                        var14_14 = Grouping.validInGroup(var10_10 /* !! */ , (ConstraintWidget$DimensionBehaviour)(var11_11 = var0.getVerticalDimensionBehaviour()), (ConstraintWidget$DimensionBehaviour)(var12_12 = var9_9.getHorizontalDimensionBehaviour()), (ConstraintWidget$DimensionBehaviour)(var13_13 = var9_9.getVerticalDimensionBehaviour()));
                        if (var14_14 == 0) {
                            return false;
                        }
                        var15_15 = var9_9 instanceof Flow;
                        if (var15_15 == 0) continue;
                        return false;
                    }
                    var8_8 = var2_2.mMetrics;
                    if (var8_8 != null) {
                        var16_16 = var8_8.grouping;
                        var18_17 = 1L;
                        var8_8.grouping = var16_16 += var18_17;
                    }
                    var15_15 = 0;
                    var9_9 = null;
                    var14_14 = 0;
                    var10_10 /* !! */  = null;
                    var20_18 = 0;
                    var11_11 = null;
                    var12_12 = null;
                    var13_13 = null;
                    var21_19 = null;
                    var22_20 = null;
                    while (true) {
                        var23_21 = 1;
                        if (var15_15 >= var4_4) break;
                        var24_22 = (ConstraintWidget)var3_3 /* !! */ .get(var15_15);
                        var25_23 /* !! */  = var0.getHorizontalDimensionBehaviour();
                        var5_5 = Grouping.validInGroup(var25_23 /* !! */ , var26_24 = var0.getVerticalDimensionBehaviour(), var6_6 = var24_22.getHorizontalDimensionBehaviour(), (ConstraintWidget$DimensionBehaviour)(var8_8 = var24_22.getVerticalDimensionBehaviour()));
                        if (var5_5 == 0) {
                            var6_6 = var2_2.mMeasure;
                            var7_7 = BasicMeasure$Measure.SELF_DIMENSIONS;
                            var25_23 /* !! */  = var1_1;
                            ConstraintWidgetContainer.measure(var24_22, var1_1, var6_6, var7_7);
                        } else {
                            var25_23 /* !! */  = var1_1;
                        }
                        var5_5 = var24_22 instanceof Guideline;
                        if (var5_5 != 0) {
                            var8_8 = var24_22;
                            var8_8 = (Guideline)var24_22;
                            var27_25 = var8_8.getOrientation();
                            if (var27_25 == 0) {
                                if (var12_12 == null) {
                                    var12_12 = new ArrayList();
                                }
                                var12_12.add(var8_8);
                            }
                            if ((var27_25 = var8_8.getOrientation()) == var23_21) {
                                if (var10_10 /* !! */  == null) {
                                    var10_10 /* !! */  = new ArrayList();
                                }
                                var10_10 /* !! */ .add(var8_8);
                            }
                        }
                        if ((var7_7 = var24_22 instanceof HelperWidget) != 0) {
                            var7_7 = var24_22 instanceof Barrier;
                            if (var7_7 != 0) {
                                var8_8 = var24_22;
                                var8_8 = (Barrier)var24_22;
                                var27_25 = var8_8.getOrientation();
                                if (var27_25 == 0) {
                                    if (var11_11 == null) {
                                        var11_11 = new ArrayList();
                                    }
                                    var11_11.add(var8_8);
                                }
                                if ((var27_25 = var8_8.getOrientation()) == var23_21) {
                                    if (var13_13 == null) {
                                        var13_13 = new ArrayList();
                                    }
                                    var13_13.add(var8_8);
                                }
                            } else {
                                var8_8 = var24_22;
                                var8_8 = (HelperWidget)var24_22;
                                if (var11_11 == null) {
                                    var11_11 = new ArrayList();
                                }
                                var11_11.add(var8_8);
                                if (var13_13 == null) {
                                    var13_13 = new ArrayList();
                                }
                                var13_13.add(var8_8);
                            }
                        }
                        if ((var8_8 = var24_22.mLeft.mTarget) == null && (var8_8 = var24_22.mRight.mTarget) == null && var5_5 == 0 && (var7_7 = var24_22 instanceof Barrier) == 0) {
                            if (var21_19 == null) {
                                var21_19 = new ArrayList<ConstraintWidget>();
                            }
                            var21_19.add(var24_22);
                        }
                        if ((var8_8 = var24_22.mTop.mTarget) == null && (var8_8 = var24_22.mBottom.mTarget) == null && (var8_8 = var24_22.mBaseline.mTarget) == null && var5_5 == 0 && (var5_5 = var24_22 instanceof Barrier) == 0) {
                            if (var22_20 == null) {
                                var6_6 = new ArrayList();
                                var22_20 = var6_6;
                            }
                            var22_20.add(var24_22);
                        }
                        ++var15_15;
                        var5_5 = 0;
                        var6_6 = null;
                    }
                    var6_6 = new ArrayList();
                    if (var10_10 /* !! */  != null) {
                        var8_8 = var10_10 /* !! */ .iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = (Guideline)var8_8.next();
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            var24_22 = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, 0, var6_6, null);
                        }
                    }
                    var14_14 = 0;
                    var10_10 /* !! */  = null;
                    var24_22 = null;
                    if (var11_11 != null) {
                        var8_8 = var11_11.iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = (HelperWidget)var8_8.next();
                            var11_11 = Grouping.findDependents((ConstraintWidget)var9_9, 0, var6_6, null);
                            var9_9.addDependents((ArrayList)var6_6, 0, (WidgetGroup)var11_11);
                            var11_11.cleanup((ArrayList)var6_6);
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            var24_22 = null;
                        }
                    }
                    var8_8 = ConstraintAnchor$Type.LEFT;
                    var9_9 = (var8_8 = var2_2.getAnchor((ConstraintAnchor$Type)var8_8)).getDependents();
                    if (var9_9 != null) {
                        var8_8 = var8_8.getDependents().iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = ((ConstraintAnchor)var8_8.next()).mOwner;
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            var20_18 = 0;
                            var11_11 = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, 0, var6_6, null);
                        }
                    }
                    var8_8 = ConstraintAnchor$Type.RIGHT;
                    var9_9 = (var8_8 = var2_2.getAnchor((ConstraintAnchor$Type)var8_8)).getDependents();
                    if (var9_9 != null) {
                        var8_8 = var8_8.getDependents().iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = ((ConstraintAnchor)var8_8.next()).mOwner;
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            var20_18 = 0;
                            var11_11 = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, 0, var6_6, null);
                        }
                    }
                    var8_8 = ConstraintAnchor$Type.CENTER;
                    var9_9 = (var8_8 = var2_2.getAnchor((ConstraintAnchor$Type)var8_8)).getDependents();
                    if (var9_9 != null) {
                        var8_8 = var8_8.getDependents().iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = ((ConstraintAnchor)var8_8.next()).mOwner;
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            var20_18 = 0;
                            var11_11 = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, 0, var6_6, null);
                        }
                    }
                    var14_14 = 0;
                    var10_10 /* !! */  = null;
                    var20_18 = 0;
                    var11_11 = null;
                    if (var21_19 != null) {
                        var8_8 = var21_19.iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = (ConstraintWidget)var8_8.next();
                            Grouping.findDependents((ConstraintWidget)var9_9, 0, var6_6, null);
                        }
                    }
                    if (var12_12 != null) {
                        var8_8 = var12_12.iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = (Guideline)var8_8.next();
                            Grouping.findDependents((ConstraintWidget)var9_9, var23_21, var6_6, null);
                        }
                    }
                    if (var13_13 != null) {
                        var8_8 = var13_13.iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = (HelperWidget)var8_8.next();
                            var10_10 /* !! */  = Grouping.findDependents((ConstraintWidget)var9_9, var23_21, var6_6, null);
                            var9_9.addDependents((ArrayList)var6_6, var23_21, (WidgetGroup)var10_10 /* !! */ );
                            var10_10 /* !! */ .cleanup((ArrayList)var6_6);
                            var20_18 = 0;
                            var11_11 = null;
                        }
                    }
                    var8_8 = ConstraintAnchor$Type.TOP;
                    var9_9 = (var8_8 = var2_2.getAnchor((ConstraintAnchor$Type)var8_8)).getDependents();
                    if (var9_9 != null) {
                        var8_8 = var8_8.getDependents().iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = ((ConstraintAnchor)var8_8.next()).mOwner;
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, var23_21, var6_6, null);
                        }
                    }
                    var8_8 = ConstraintAnchor$Type.BASELINE;
                    var9_9 = (var8_8 = var2_2.getAnchor((ConstraintAnchor$Type)var8_8)).getDependents();
                    if (var9_9 != null) {
                        var8_8 = var8_8.getDependents().iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = ((ConstraintAnchor)var8_8.next()).mOwner;
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, var23_21, var6_6, null);
                        }
                    }
                    var8_8 = ConstraintAnchor$Type.BOTTOM;
                    var9_9 = (var8_8 = var2_2.getAnchor((ConstraintAnchor$Type)var8_8)).getDependents();
                    if (var9_9 != null) {
                        var8_8 = var8_8.getDependents().iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = ((ConstraintAnchor)var8_8.next()).mOwner;
                            var14_14 = 0;
                            var10_10 /* !! */  = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, var23_21, var6_6, null);
                        }
                    }
                    var8_8 = ConstraintAnchor$Type.CENTER;
                    var9_9 = (var8_8 = var2_2.getAnchor((ConstraintAnchor$Type)var8_8)).getDependents();
                    if (var9_9 != null) {
                        var8_8 = var8_8.getDependents().iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = ((ConstraintAnchor)var8_8.next()).mOwner;
                            var24_22 = null;
                            Grouping.findDependents((ConstraintWidget)var9_9, var23_21, var6_6, null);
                        }
                    }
                    var24_22 = null;
                    if (var22_20 != null) {
                        var8_8 = var22_20.iterator();
                        while ((var15_15 = (int)var8_8.hasNext()) != 0) {
                            var9_9 = (ConstraintWidget)var8_8.next();
                            Grouping.findDependents((ConstraintWidget)var9_9, var23_21, var6_6, null);
                        }
                    }
                    var8_8 = null;
                    for (var7_7 = 0; var7_7 < var4_4; ++var7_7) {
                        var9_9 = (ConstraintWidget)var3_3 /* !! */ .get(var7_7);
                        var14_14 = var9_9.oppositeDimensionsTied();
                        if (var14_14 == 0) continue;
                        var14_14 = var9_9.horizontalGroup;
                        var10_10 /* !! */  = Grouping.findGroup(var6_6, var14_14);
                        var15_15 = var9_9.verticalGroup;
                        var9_9 = Grouping.findGroup(var6_6, var15_15);
                        if (var10_10 /* !! */  == null || var9_9 == null) continue;
                        var11_11 = null;
                        var10_10 /* !! */ .moveTo(0, (WidgetGroup)var9_9);
                        var20_18 = 2;
                        var9_9.setOrientation(var20_18);
                        var6_6.remove((Object)var10_10 /* !! */ );
                    }
                    var28_26 = var6_6.size();
                    if (var28_26 <= var23_21) {
                        return false;
                    }
                    var3_3 /* !! */  = var0.getHorizontalDimensionBehaviour();
                    if (var3_3 /* !! */  != (var29_27 /* !! */  = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) ** GOTO lbl-1000
                    var3_3 /* !! */  = var6_6.iterator();
                    var4_4 = 0;
                    var29_27 /* !! */  = null;
                    var14_14 = 0;
                    var10_10 /* !! */  = null;
                    while ((var7_7 = (int)var3_3 /* !! */ .hasNext()) != 0) {
                        var8_8 = (WidgetGroup)var3_3 /* !! */ .next();
                        var15_15 = var8_8.getOrientation();
                        if (var15_15 == var23_21) continue;
                        var15_15 = 0;
                        var9_9 = null;
                        var8_8.setAuthoritative(false);
                        var11_11 = var0.getSystem();
                        var20_18 = var8_8.measureWrap((LinearSystem)var11_11, 0);
                        if (var20_18 <= var14_14) continue;
                        var29_27 /* !! */  = var8_8;
                        var14_14 = var20_18;
                    }
                    if (var29_27 /* !! */  != null) {
                        var3_3 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                        var2_2.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var3_3 /* !! */ );
                        var2_2.setWidth(var14_14);
                        var29_27 /* !! */ .setAuthoritative((boolean)var23_21);
                    } else lbl-1000:
                    // 2 sources

                    {
                        var4_4 = 0;
                        var29_27 /* !! */  = null;
                    }
                    var3_3 /* !! */  = var0.getVerticalDimensionBehaviour();
                    var8_8 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    if (var3_3 /* !! */  != var8_8) break block58;
                    var3_3 /* !! */  = var6_6.iterator();
                    var5_5 = 0;
                    var6_6 = null;
                    var14_14 = 0;
                    var10_10 /* !! */  = null;
                    while ((var7_7 = (int)var3_3 /* !! */ .hasNext()) != 0) {
                        var8_8 = (WidgetGroup)var3_3 /* !! */ .next();
                        var15_15 = var8_8.getOrientation();
                        if (var15_15 == 0) continue;
                        var15_15 = 0;
                        var9_9 = null;
                        var8_8.setAuthoritative(false);
                        var11_11 = var0.getSystem();
                        var20_18 = var8_8.measureWrap((LinearSystem)var11_11, var23_21);
                        if (var20_18 <= var14_14) continue;
                        var6_6 = var8_8;
                        var14_14 = var20_18;
                    }
                    var15_15 = 0;
                    var9_9 = null;
                    if (var6_6 == null) break block59;
                    var3_3 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                    var2_2.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var3_3 /* !! */ );
                    var2_2.setHeight(var14_14);
                    var6_6.setAuthoritative((boolean)var23_21);
                    var8_8 = var6_6;
                    break block60;
                }
                var15_15 = 0;
                var9_9 = null;
            }
            var7_7 = 0;
            var8_8 = null;
        }
        if (var29_27 /* !! */  == null && var8_8 == null) {
            var5_5 = 0;
            var6_6 = null;
        } else {
            var5_5 = var23_21;
        }
        return (boolean)var5_5;
    }

    public static boolean validInGroup(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4) {
        boolean bl2;
        boolean bl3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.FIXED;
        boolean bl4 = true;
        if (constraintWidget$DimensionBehaviour3 != constraintWidget$DimensionBehaviour7 && constraintWidget$DimensionBehaviour3 != (constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (constraintWidget$DimensionBehaviour3 != (constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT) || constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour6)) {
            bl3 = false;
            constraintWidget$DimensionBehaviour = null;
        } else {
            bl3 = bl4;
        }
        if (constraintWidget$DimensionBehaviour4 != constraintWidget$DimensionBehaviour7 && constraintWidget$DimensionBehaviour4 != (constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (constraintWidget$DimensionBehaviour4 != (constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT) || constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3)) {
            bl2 = false;
            constraintWidget$DimensionBehaviour2 = null;
        } else {
            bl2 = bl4;
        }
        if (!bl3 && !bl2) {
            return false;
        }
        return bl4;
    }
}

