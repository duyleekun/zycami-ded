/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun
extends WidgetRun {
    private int chainStyle;
    public ArrayList widgets;

    public ChainRun(ConstraintWidget arrayList, int n10) {
        super((ConstraintWidget)((Object)arrayList));
        this.widgets = arrayList = new ArrayList();
        this.orientation = n10;
        this.build();
    }

    private void build() {
        Object object = this.widget;
        int n10 = this.orientation;
        Object object2 = ((ConstraintWidget)object).getPreviousChainMember(n10);
        while (true) {
            ConstraintWidget constraintWidget = object2;
            object2 = object;
            object = constraintWidget;
            if (constraintWidget == null) break;
            n10 = this.orientation;
            object2 = constraintWidget.getPreviousChainMember(n10);
        }
        this.widget = object2;
        object = this.widgets;
        int n11 = this.orientation;
        WidgetRun widgetRun = ((ConstraintWidget)object2).getRun(n11);
        ((ArrayList)object).add(widgetRun);
        int n12 = this.orientation;
        for (object = ((ConstraintWidget)object2).getNextChainMember(n12); object != null; object = ((ConstraintWidget)object).getNextChainMember(n10)) {
            object2 = this.widgets;
            n11 = this.orientation;
            widgetRun = ((ConstraintWidget)object).getRun(n11);
            ((ArrayList)object2).add(widgetRun);
            n10 = this.orientation;
        }
        object = this.widgets.iterator();
        while (true) {
            n10 = (int)(object.hasNext() ? 1 : 0);
            n11 = 1;
            if (n10 == 0) break;
            object2 = (WidgetRun)object.next();
            int n13 = this.orientation;
            if (n13 == 0) {
                object2 = ((WidgetRun)object2).widget;
                ((ConstraintWidget)object2).horizontalChainRun = this;
                continue;
            }
            if (n13 != n11) continue;
            object2 = ((WidgetRun)object2).widget;
            ((ConstraintWidget)object2).verticalChainRun = this;
        }
        n12 = this.orientation;
        if (n12 == 0 && (n12 = (int)(((ConstraintWidgetContainer)(object = (ConstraintWidgetContainer)this.widget.getParent())).isRtl() ? 1 : 0)) != 0) {
            n12 = n11;
        } else {
            n12 = 0;
            object = null;
        }
        if (n12 != 0 && (n12 = ((ArrayList)(object = this.widgets)).size()) > n11) {
            object = this.widgets;
            n10 = ((ArrayList)object).size() - n11;
            this.widget = object = ((WidgetRun)object.get((int)n10)).widget;
        }
        if ((n12 = this.orientation) == 0) {
            object = this.widget;
            n12 = ((ConstraintWidget)object).getHorizontalChainStyle();
        } else {
            object = this.widget;
            n12 = ((ConstraintWidget)object).getVerticalChainStyle();
        }
        this.chainStyle = n12;
    }

    private ConstraintWidget getFirstVisibleWidget() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.widgets)).size()); ++i10) {
            int n11;
            object = (WidgetRun)this.widgets.get(i10);
            ConstraintWidget constraintWidget = ((WidgetRun)object).widget;
            int n12 = constraintWidget.getVisibility();
            if (n12 == (n11 = 8)) continue;
            return ((WidgetRun)object).widget;
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        ArrayList arrayList = this.widgets;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            int n10;
            WidgetRun widgetRun = (WidgetRun)this.widgets.get(i10);
            ConstraintWidget constraintWidget = widgetRun.widget;
            int n11 = constraintWidget.getVisibility();
            if (n11 == (n10 = 8)) continue;
            return widgetRun.widget;
        }
        return null;
    }

    public void apply() {
        Object object;
        int n10;
        Object object2 = this.widgets.iterator();
        while ((n10 = object2.hasNext()) != 0) {
            object = (WidgetRun)object2.next();
            ((WidgetRun)object).apply();
        }
        object2 = this.widgets;
        int n11 = ((ArrayList)object2).size();
        if (n11 < (n10 = 1)) {
            return;
        }
        Object object3 = this.widgets;
        DependencyNode dependencyNode = null;
        object3 = ((WidgetRun)object3.get((int)0)).widget;
        Object object4 = this.widgets;
        object2 = ((WidgetRun)object4.get((int)(n11 -= n10))).widget;
        int n12 = this.orientation;
        if (n12 == 0) {
            object = ((ConstraintWidget)object3).mLeft;
            object2 = ((ConstraintWidget)object2).mRight;
            object3 = this.getTarget((ConstraintAnchor)object, 0);
            n10 = ((ConstraintAnchor)object).getMargin();
            object4 = this.getFirstVisibleWidget();
            if (object4 != null) {
                object = ((ConstraintWidget)object4).mLeft;
                n10 = ((ConstraintAnchor)object).getMargin();
            }
            if (object3 != null) {
                object4 = this.start;
                this.addTarget((DependencyNode)object4, (DependencyNode)object3, n10);
            }
            object = this.getTarget((ConstraintAnchor)object2, 0);
            n11 = ((ConstraintAnchor)object2).getMargin();
            object3 = this.getLastVisibleWidget();
            if (object3 != null) {
                object2 = ((ConstraintWidget)object3).mRight;
                n11 = ((ConstraintAnchor)object2).getMargin();
            }
            if (object != null) {
                object3 = this.end;
                n11 = -n11;
                this.addTarget((DependencyNode)object3, (DependencyNode)object, n11);
            }
        } else {
            object3 = ((ConstraintWidget)object3).mTop;
            object2 = ((ConstraintWidget)object2).mBottom;
            dependencyNode = this.getTarget((ConstraintAnchor)object3, n10);
            int n13 = ((ConstraintAnchor)object3).getMargin();
            object4 = this.getFirstVisibleWidget();
            if (object4 != null) {
                object3 = ((ConstraintWidget)object4).mTop;
                n13 = ((ConstraintAnchor)object3).getMargin();
            }
            if (dependencyNode != null) {
                object4 = this.start;
                this.addTarget((DependencyNode)object4, dependencyNode, n13);
            }
            object = this.getTarget((ConstraintAnchor)object2, n10);
            n11 = ((ConstraintAnchor)object2).getMargin();
            object3 = this.getLastVisibleWidget();
            if (object3 != null) {
                object2 = ((ConstraintWidget)object3).mBottom;
                n11 = ((ConstraintAnchor)object2).getMargin();
            }
            if (object != null) {
                object3 = this.end;
                n11 = -n11;
                this.addTarget((DependencyNode)object3, (DependencyNode)object, n11);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    public void applyToWidget() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.widgets)).size()); ++i10) {
            object = (WidgetRun)this.widgets.get(i10);
            ((WidgetRun)object).applyToWidget();
        }
    }

    public void clear() {
        boolean bl2;
        this.runGroup = null;
        Iterator iterator2 = this.widgets.iterator();
        while (bl2 = iterator2.hasNext()) {
            WidgetRun widgetRun = (WidgetRun)iterator2.next();
            widgetRun.clear();
        }
    }

    public long getWrapDimension() {
        ArrayList arrayList = this.widgets;
        int n10 = arrayList.size();
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            Dependency dependency = (WidgetRun)this.widgets.get(i10);
            DependencyNode dependencyNode = dependency.start;
            int n11 = dependencyNode.margin;
            long l11 = n11;
            l10 += l11;
            l11 = dependency.getWrapDimension();
            l10 += l11;
            dependency = dependency.end;
            int n12 = ((DependencyNode)dependency).margin;
            long l12 = n12;
            l10 += l12;
        }
        return l10;
    }

    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    public boolean supportsWrapComputation() {
        ArrayList arrayList = this.widgets;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            WidgetRun widgetRun = (WidgetRun)this.widgets.get(i10);
            boolean bl2 = widgetRun.supportsWrapComputation();
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        Object object = "ChainRun ";
        charSequence.append((String)object);
        int n10 = this.orientation;
        object = n10 == 0 ? "horizontal : " : "vertical : ";
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object = this.widgets.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (WidgetRun)object.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append("<");
            charSequence = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append(object2);
            charSequence = stringBuilder.toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)charSequence);
            ((StringBuilder)object2).append("> ");
            charSequence = ((StringBuilder)object2).toString();
        }
        return charSequence;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void update(Dependency var1_1) {
        block106: {
            block117: {
                block111: {
                    block110: {
                        block105: {
                            block104: {
                                var2_2 = this;
                                var3_3 = this.start;
                                var4_4 = var3_3.resolved;
                                if (var4_4 == 0) break block106;
                                var3_3 = this.end;
                                var4_4 = var3_3.resolved;
                                if (var4_4 == 0) break block106;
                                var3_3 = this.widget.getParent();
                                if (var3_3 != null && (var5_5 = var3_3 instanceof ConstraintWidgetContainer) != 0) {
                                    var3_3 = (ConstraintWidgetContainer)var3_3;
                                    var4_4 = var3_3.isRtl();
                                } else {
                                    var4_4 = 0;
                                    var3_3 = null;
                                }
                                var6_6 = var2_2.end;
                                var5_5 = var6_6.value;
                                var7_7 = var2_2.start.value;
                                var5_5 -= var7_7;
                                var8_8 = var2_2.widgets;
                                var7_7 = var8_8.size();
                                var9_9 = 0;
                                while (true) {
                                    var10_10 = -1;
                                    var11_11 = 8;
                                    var12_12 = 1.1E-44f;
                                    if (var9_9 >= var7_7) break;
                                    var13_13 = ((WidgetRun)var2_2.widgets.get((int)var9_9)).widget;
                                    var14_14 = var13_13.getVisibility();
                                    if (var14_14 == var11_11) {
                                        ++var9_9;
                                        continue;
                                    }
                                    break block104;
                                    break;
                                }
                                var9_9 = var10_10;
                            }
                            for (var15_15 = var14_14 = var7_7 + -1; var15_15 >= 0; var15_15 += -1) {
                                var16_16 /* !! */  = ((WidgetRun)var2_2.widgets.get((int)var15_15)).widget;
                                var17_17 = var16_16 /* !! */ .getVisibility();
                                if (var17_17 == var11_11) {
                                    continue;
                                }
                                var10_10 = var15_15;
                                break;
                            }
                            var15_15 = 0;
                            var18_18 = 0.0f;
                            var19_19 = null;
                            while (true) {
                                var20_20 = 2;
                                var21_21 = 2.8E-45f;
                                if (var15_15 >= var20_20) break block105;
                                var23_23 = 0;
                                var24_24 = 0.0f;
                                var25_25 /* !! */  = null;
                                var26_26 = 0;
                                var27_27 = 0;
                                var28_28 = 0.0f;
                                for (var22_22 = 0; var22_22 < var7_7; ++var22_22) {
                                    block107: {
                                        block109: {
                                            block108: {
                                                var29_29 = (WidgetRun)var2_2.widgets.get(var22_22);
                                                var30_30 /* !! */  = var29_29.widget;
                                                var20_20 = var30_30 /* !! */ .getVisibility();
                                                if (var20_20 == var11_11) break block107;
                                                ++var27_27;
                                                if (var22_22 > 0 && var22_22 >= var9_9) {
                                                    var30_30 /* !! */  = var29_29.start;
                                                    var20_20 = var30_30 /* !! */ .margin;
                                                    var23_23 += var20_20;
                                                }
                                                var30_30 /* !! */  = var29_29.dimension;
                                                var11_11 = var30_30 /* !! */ .value;
                                                var16_16 /* !! */  = var29_29.dimensionBehavior;
                                                var31_31 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                                                if (var16_16 /* !! */  != var31_31 /* !! */ ) {
                                                    var17_17 = 1;
                                                    var32_32 = 1.4E-45f;
                                                } else {
                                                    var17_17 = 0;
                                                    var32_32 = 0.0f;
                                                    var16_16 /* !! */  = null;
                                                }
                                                if (var17_17 == 0) break block108;
                                                var20_20 = var2_2.orientation;
                                                if (var20_20 == 0) {
                                                    var31_31 /* !! */  = var29_29.widget.horizontalRun.dimension;
                                                    var33_33 = (int)var31_31 /* !! */ .resolved;
                                                    if (var33_33 == 0) {
                                                        return;
                                                    }
                                                }
                                                if (var20_20 == (var33_33 = 1)) {
                                                    var30_30 /* !! */  = var29_29.widget.verticalRun.dimension;
                                                    var20_20 = (int)var30_30 /* !! */ .resolved;
                                                    if (var20_20 == 0) {
                                                        return;
                                                    }
                                                }
                                                var34_34 = var11_11;
                                                ** GOTO lbl-1000
                                            }
                                            var34_34 = var11_11;
                                            var11_11 = var29_29.matchConstraintsType;
                                            var33_33 = 1;
                                            if (var11_11 != var33_33 || var15_15 != 0) break block109;
                                            var11_11 = var30_30 /* !! */ .wrapValue;
                                            ++var26_26;
                                            ** GOTO lbl102
                                        }
                                        var11_11 = (int)var30_30 /* !! */ .resolved;
                                        if (var11_11 != 0) {
                                            var11_11 = var34_34;
lbl102:
                                            // 2 sources

                                            var17_17 = 1;
                                            var32_32 = 1.4E-45f;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var11_11 = var34_34;
                                        }
                                        if (var17_17 == 0) {
                                            ++var26_26;
                                            var35_35 = var29_29.widget.mWeight;
                                            var17_17 = var2_2.orientation;
                                            var12_12 = (float)var35_35[var17_17];
                                            var17_17 = 0;
                                            var32_32 = 0.0f;
                                            var16_16 /* !! */  = null;
                                            cfr_temp_0 = var12_12 - 0.0f;
                                            var20_20 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                            if (var20_20 >= 0) {
                                                var28_28 += var12_12;
                                            }
                                        } else {
                                            var23_23 += var11_11;
                                        }
                                        if (var22_22 < var14_14 && var22_22 < var10_10) {
                                            var29_29 = var29_29.end;
                                            var36_36 = -var29_29.margin;
                                            var23_23 += var36_36;
                                        }
                                    }
                                    var11_11 = 8;
                                    var12_12 = 1.1E-44f;
                                    var20_20 = 2;
                                    var21_21 = 2.8E-45f;
                                }
                                if (var23_23 < var5_5 || var26_26 == 0) break;
                                ++var15_15;
                                var11_11 = 8;
                                var12_12 = 1.1E-44f;
                            }
                            var36_36 = var27_27;
                            break block110;
                        }
                        var36_36 = 0;
                        var37_37 = 0.0f;
                        var29_29 = null;
                        var23_23 = 0;
                        var24_24 = 0.0f;
                        var25_25 /* !! */  = null;
                        var26_26 = 0;
                        var28_28 = 0.0f;
                    }
                    var35_35 = var2_2.start;
                    var11_11 = var35_35.value;
                    if (var4_4 != 0) {
                        var35_35 = var2_2.end;
                        var11_11 = var35_35.value;
                    }
                    var15_15 = 0x3F000000;
                    var18_18 = 0.5f;
                    if (var23_23 > var5_5) {
                        var17_17 = 0x40000000;
                        var32_32 = 2.0f;
                        if (var4_4 != 0) {
                            var20_20 = var23_23 - var5_5;
                            var21_21 = (float)var20_20 / var32_32 + var18_18;
                            var17_17 = (int)var21_21;
                            var11_11 += var17_17;
                        } else {
                            var20_20 = var23_23 - var5_5;
                            var21_21 = (float)var20_20 / var32_32 + var18_18;
                            var17_17 = (int)var21_21;
                            var11_11 -= var17_17;
                        }
                    }
                    if (var26_26 <= 0) break block111;
                    var17_17 = var5_5 - var23_23;
                    var32_32 = var17_17;
                    var21_21 = var26_26;
                    var21_21 = var32_32 / var21_21 + var18_18;
                    var20_20 = (int)var21_21;
                    var31_31 /* !! */  = null;
                    var22_22 = 0;
                    for (var33_33 = 0; var33_33 < var7_7; ++var33_33) {
                        block116: {
                            block112: {
                                block114: {
                                    block115: {
                                        block113: {
                                            var19_19 = (WidgetRun)var2_2.widgets.get(var33_33);
                                            var34_34 = var20_20;
                                            var30_30 /* !! */  = var19_19.widget;
                                            var20_20 = var30_30 /* !! */ .getVisibility();
                                            var38_38 = var23_23;
                                            var23_23 = 8;
                                            var24_24 = 1.1E-44f;
                                            if (var20_20 == var23_23 || (var30_30 /* !! */  = var19_19.dimensionBehavior) != (var25_25 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) break block112;
                                            var30_30 /* !! */  = var19_19.dimension;
                                            var23_23 = (int)var30_30 /* !! */ .resolved;
                                            if (var23_23 != 0) break block112;
                                            var23_23 = 0;
                                            var24_24 = 0.0f;
                                            var25_25 /* !! */  = null;
                                            cfr_temp_1 = var28_28 - 0.0f;
                                            var39_39 /* !! */  = (float)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                                            if (var39_39 /* !! */  > 0) {
                                                var25_25 /* !! */  = (ConstraintWidget$DimensionBehaviour)var19_19.widget.mWeight;
                                                var40_40 = var11_11;
                                                var11_11 = var2_2.orientation;
                                                var12_12 = (float)(var25_25 /* !! */ [var11_11] * var32_32 / var28_28);
                                                var23_23 = 0x3F000000;
                                                var24_24 = 0.5f;
                                                var11_11 = (int)(var12_12 += var24_24);
                                            } else {
                                                var40_40 = var11_11;
                                                var11_11 = var34_34;
                                            }
                                            var23_23 = var2_2.orientation;
                                            if (var23_23 != 0) break block113;
                                            var25_25 /* !! */  = var19_19.widget;
                                            var41_41 = var32_32;
                                            var17_17 = var25_25 /* !! */ .mMatchConstraintMaxWidth;
                                            var23_23 = var25_25 /* !! */ .mMatchConstraintMinWidth;
                                            var42_42 = var4_4;
                                            var4_4 = var19_19.matchConstraintsType;
                                            var43_43 = var36_36;
                                            var36_36 = 1;
                                            var37_37 = 1.4E-45f;
                                            if (var4_4 == var36_36) {
                                                var4_4 = var30_30 /* !! */ .wrapValue;
                                                var4_4 = Math.min(var11_11, var4_4);
                                            } else {
                                                var4_4 = var11_11;
                                            }
                                            var4_4 = Math.max(var23_23, var4_4);
                                            if (var17_17 > 0) {
                                                var4_4 = Math.min(var17_17, var4_4);
                                            }
                                            if (var4_4 == var11_11) break block114;
                                            break block115;
                                        }
                                        var42_42 = var4_4;
                                        var43_43 = var36_36;
                                        var41_41 = var32_32;
                                        var3_3 = var19_19.widget;
                                        var36_36 = var3_3.mMatchConstraintMaxHeight;
                                        var4_4 = var3_3.mMatchConstraintMinHeight;
                                        var17_17 = var19_19.matchConstraintsType;
                                        var23_23 = 1;
                                        var24_24 = 1.4E-45f;
                                        if (var17_17 == var23_23) {
                                            var17_17 = var30_30 /* !! */ .wrapValue;
                                            var17_17 = Math.min(var11_11, var17_17);
                                        } else {
                                            var17_17 = var11_11;
                                        }
                                        var4_4 = Math.max(var4_4, var17_17);
                                        if (var36_36 > 0) {
                                            var4_4 = Math.min(var36_36, var4_4);
                                        }
                                        if (var4_4 == var11_11) break block114;
                                    }
                                    ++var22_22;
                                    var11_11 = var4_4;
                                }
                                var3_3 = var19_19.dimension;
                                var3_3.resolve(var11_11);
                                break block116;
                            }
                            var42_42 = var4_4;
                            var43_43 = var36_36;
                            var40_40 = var11_11;
                            var41_41 = var32_32;
                        }
                        var20_20 = var34_34;
                        var23_23 = var38_38;
                        var11_11 = var40_40;
                        var32_32 = var41_41;
                        var4_4 = var42_42;
                        var36_36 = var43_43;
                        var15_15 = 0x3F000000;
                        var18_18 = 0.5f;
                    }
                    var42_42 = var4_4;
                    var43_43 = var36_36;
                    var40_40 = var11_11;
                    var38_38 = var23_23;
                    if (var22_22 > 0) {
                        var26_26 -= var22_22;
                        var3_3 = null;
                        var36_36 = 0;
                        var37_37 = 0.0f;
                        var29_29 = null;
                        for (var4_4 = 0; var4_4 < var7_7; ++var4_4) {
                            var35_35 = (WidgetRun)var2_2.widgets.get(var4_4);
                            var19_19 = var35_35.widget;
                            var15_15 = var19_19.getVisibility();
                            var17_17 = 8;
                            var32_32 = 1.1E-44f;
                            if (var15_15 == var17_17) continue;
                            if (var4_4 > 0 && var4_4 >= var9_9) {
                                var19_19 = var35_35.start;
                                var15_15 = var19_19.margin;
                                var36_36 += var15_15;
                            }
                            var19_19 = var35_35.dimension;
                            var15_15 = var19_19.value;
                            var36_36 += var15_15;
                            if (var4_4 >= var14_14 || var4_4 >= var10_10) continue;
                            var35_35 = var35_35.end;
                            var11_11 = -var35_35.margin;
                            var36_36 += var11_11;
                        }
                        var23_23 = var36_36;
                    }
                    var4_4 = var2_2.chainStyle;
                    var36_36 = 2;
                    var37_37 = 2.8E-45f;
                    if (var4_4 == var36_36 && var22_22 == 0) {
                        var4_4 = 0;
                        var3_3 = null;
                        var2_2.chainStyle = 0;
                    } else {
                        var4_4 = 0;
                        var3_3 = null;
                    }
                    break block117;
                }
                var42_42 = var4_4;
                var43_43 = var36_36;
                var40_40 = var11_11;
                var38_38 = var23_23;
                var4_4 = 0;
                var3_3 = null;
                var36_36 = 2;
                var37_37 = 2.8E-45f;
            }
            if (var23_23 > var5_5) {
                var2_2.chainStyle = var36_36;
            }
            if (var43_43 > 0 && var26_26 == 0 && var9_9 == var10_10) {
                var2_2.chainStyle = var36_36;
            }
            var36_36 = var2_2.chainStyle;
            var11_11 = 1;
            var12_12 = 1.4E-45f;
            if (var36_36 == var11_11) {
                var15_15 = var43_43;
                if (var43_43 > var11_11) {
                    var5_5 -= var23_23;
                    var36_36 = var43_43 + -1;
                    var5_5 /= var36_36;
                } else if (var43_43 == var11_11) {
                    var5_5 -= var23_23;
                    var36_36 = 2;
                    var37_37 = 2.8E-45f;
                    var5_5 /= var36_36;
                } else {
                    var5_5 = 0;
                    var6_6 = null;
                    var44_44 = 0.0f;
                }
                if (var26_26 > 0) {
                    var5_5 = 0;
                    var6_6 = null;
                    var44_44 = 0.0f;
                }
                var29_29 = null;
                var37_37 = 0.0f;
                var11_11 = var40_40;
                for (var36_36 = 0; var36_36 < var7_7; ++var36_36) {
                    if (var42_42 != 0) {
                        var4_4 = var36_36 + 1;
                        var4_4 = var7_7 - var4_4;
                    } else {
                        var4_4 = var36_36;
                    }
                    var3_3 = (WidgetRun)var2_2.widgets.get(var4_4);
                    var19_19 = var3_3.widget;
                    var15_15 = var19_19.getVisibility();
                    var17_17 = 8;
                    var32_32 = 1.1E-44f;
                    if (var15_15 == var17_17) {
                        var19_19 = var3_3.start;
                        var19_19.resolve(var11_11);
                        var3_3 = var3_3.end;
                        var3_3.resolve(var11_11);
                        continue;
                    }
                    if (var36_36 > 0) {
                        var11_11 = var42_42 != 0 ? (var11_11 -= var5_5) : (var11_11 += var5_5);
                    }
                    if (var36_36 > 0 && var36_36 >= var9_9) {
                        if (var42_42 != 0) {
                            var19_19 = var3_3.start;
                            var15_15 = var19_19.margin;
                            var11_11 -= var15_15;
                        } else {
                            var19_19 = var3_3.start;
                            var15_15 = var19_19.margin;
                            var11_11 += var15_15;
                        }
                    }
                    if (var42_42 != 0) {
                        var19_19 = var3_3.end;
                        var19_19.resolve(var11_11);
                    } else {
                        var19_19 = var3_3.start;
                        var19_19.resolve(var11_11);
                    }
                    var19_19 = var3_3.dimension;
                    var17_17 = var19_19.value;
                    var30_30 /* !! */  = var3_3.dimensionBehavior;
                    var31_31 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (var30_30 /* !! */  == var31_31 /* !! */  && (var20_20 = var3_3.matchConstraintsType) == (var33_33 = 1)) {
                        var17_17 = var19_19.wrapValue;
                    }
                    var11_11 = var42_42 != 0 ? (var11_11 -= var17_17) : (var11_11 += var17_17);
                    if (var42_42 != 0) {
                        var19_19 = var3_3.start;
                        var19_19.resolve(var11_11);
                    } else {
                        var19_19 = var3_3.end;
                        var19_19.resolve(var11_11);
                    }
                    var15_15 = 1;
                    var18_18 = 1.4E-45f;
                    var3_3.resolved = var15_15;
                    if (var36_36 >= var14_14 || var36_36 >= var10_10) continue;
                    if (var42_42 != 0) {
                        var3_3 = var3_3.end;
                        var4_4 = -var3_3.margin;
                        var11_11 -= var4_4;
                        continue;
                    }
                    var3_3 = var3_3.end;
                    var4_4 = -var3_3.margin;
                    var11_11 += var4_4;
                }
            } else {
                var15_15 = var43_43;
                if (var36_36 == 0) {
                    var5_5 -= var23_23;
                    var36_36 = 1;
                    var37_37 = 1.4E-45f;
                    var11_11 = var43_43 + 1;
                    var5_5 /= var11_11;
                    if (var26_26 > 0) {
                        var5_5 = 0;
                        var6_6 = null;
                        var44_45 = 0.0f;
                    }
                    var29_29 = null;
                    var37_37 = 0.0f;
                    var11_11 = var40_40;
                    for (var36_36 = 0; var36_36 < var7_7; ++var36_36) {
                        if (var42_42 != 0) {
                            var4_4 = var36_36 + 1;
                            var4_4 = var7_7 - var4_4;
                        } else {
                            var4_4 = var36_36;
                        }
                        var3_3 = (WidgetRun)var2_2.widgets.get(var4_4);
                        var19_19 = var3_3.widget;
                        var15_15 = var19_19.getVisibility();
                        var17_17 = 8;
                        var32_32 = 1.1E-44f;
                        if (var15_15 == var17_17) {
                            var19_19 = var3_3.start;
                            var19_19.resolve(var11_11);
                            var3_3 = var3_3.end;
                            var3_3.resolve(var11_11);
                            continue;
                        }
                        var11_11 = var42_42 != 0 ? (var11_11 -= var5_5) : (var11_11 += var5_5);
                        if (var36_36 > 0 && var36_36 >= var9_9) {
                            if (var42_42 != 0) {
                                var19_19 = var3_3.start;
                                var15_15 = var19_19.margin;
                                var11_11 -= var15_15;
                            } else {
                                var19_19 = var3_3.start;
                                var15_15 = var19_19.margin;
                                var11_11 += var15_15;
                            }
                        }
                        if (var42_42 != 0) {
                            var19_19 = var3_3.end;
                            var19_19.resolve(var11_11);
                        } else {
                            var19_19 = var3_3.start;
                            var19_19.resolve(var11_11);
                        }
                        var19_19 = var3_3.dimension;
                        var17_17 = var19_19.value;
                        var30_30 /* !! */  = var3_3.dimensionBehavior;
                        var31_31 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                        if (var30_30 /* !! */  == var31_31 /* !! */  && (var20_20 = var3_3.matchConstraintsType) == (var33_33 = 1)) {
                            var15_15 = var19_19.wrapValue;
                            var17_17 = Math.min(var17_17, var15_15);
                        }
                        var11_11 = var42_42 != 0 ? (var11_11 -= var17_17) : (var11_11 += var17_17);
                        if (var42_42 != 0) {
                            var19_19 = var3_3.start;
                            var19_19.resolve(var11_11);
                        } else {
                            var19_19 = var3_3.end;
                            var19_19.resolve(var11_11);
                        }
                        if (var36_36 >= var14_14 || var36_36 >= var10_10) continue;
                        if (var42_42 != 0) {
                            var3_3 = var3_3.end;
                            var4_4 = -var3_3.margin;
                            var11_11 -= var4_4;
                            continue;
                        }
                        var3_3 = var3_3.end;
                        var4_4 = -var3_3.margin;
                        var11_11 += var4_4;
                    }
                } else {
                    var11_11 = 2;
                    var12_12 = 2.8E-45f;
                    if (var36_36 == var11_11) {
                        var36_36 = var2_2.orientation;
                        if (var36_36 == 0) {
                            var29_29 = var2_2.widget;
                            var37_37 = var29_29.getHorizontalBiasPercent();
                        } else {
                            var29_29 = var2_2.widget;
                            var37_37 = var29_29.getVerticalBiasPercent();
                        }
                        if (var42_42 != 0) {
                            var11_11 = 1065353216;
                            var12_12 = 1.0f;
                            var37_37 = var12_12 - var37_37;
                        }
                        var44_46 = (float)(var5_5 -= var23_23) * var37_37;
                        var37_37 = 0.5f;
                        var36_36 = (int)(var44_46 += var37_37);
                        if (var36_36 < 0 || var26_26 > 0) {
                            var36_36 = 0;
                            var29_29 = null;
                            var37_37 = 0.0f;
                        }
                        var11_11 = var42_42 != 0 ? var40_40 - var36_36 : var40_40 + var36_36;
                        var29_29 = null;
                        var37_37 = 0.0f;
                        for (var36_36 = 0; var36_36 < var7_7; ++var36_36) {
                            if (var42_42 != 0) {
                                var4_4 = var36_36 + 1;
                                var4_4 = var7_7 - var4_4;
                            } else {
                                var4_4 = var36_36;
                            }
                            var3_3 = (WidgetRun)var2_2.widgets.get(var4_4);
                            var6_6 = var3_3.widget;
                            var5_5 = var6_6.getVisibility();
                            var15_15 = 8;
                            var18_18 = 1.1E-44f;
                            if (var5_5 == var15_15) {
                                var6_6 = var3_3.start;
                                var6_6.resolve(var11_11);
                                var3_3 = var3_3.end;
                                var3_3.resolve(var11_11);
                                var33_33 = 1;
                                continue;
                            }
                            if (var36_36 > 0 && var36_36 >= var9_9) {
                                if (var42_42 != 0) {
                                    var6_6 = var3_3.start;
                                    var5_5 = var6_6.margin;
                                    var11_11 -= var5_5;
                                } else {
                                    var6_6 = var3_3.start;
                                    var5_5 = var6_6.margin;
                                    var11_11 += var5_5;
                                }
                            }
                            if (var42_42 != 0) {
                                var6_6 = var3_3.end;
                                var6_6.resolve(var11_11);
                            } else {
                                var6_6 = var3_3.start;
                                var6_6.resolve(var11_11);
                            }
                            var6_6 = var3_3.dimension;
                            var17_17 = var6_6.value;
                            var30_30 /* !! */  = var3_3.dimensionBehavior;
                            var31_31 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                            if (var30_30 /* !! */  == var31_31 /* !! */ ) {
                                var20_20 = var3_3.matchConstraintsType;
                                var33_33 = 1;
                                if (var20_20 == var33_33) {
                                    var17_17 = var6_6.wrapValue;
                                }
                            } else {
                                var33_33 = 1;
                            }
                            var11_11 = var42_42 != 0 ? (var11_11 -= var17_17) : (var11_11 += var17_17);
                            if (var42_42 != 0) {
                                var6_6 = var3_3.start;
                                var6_6.resolve(var11_11);
                            } else {
                                var6_6 = var3_3.end;
                                var6_6.resolve(var11_11);
                            }
                            if (var36_36 >= var14_14 || var36_36 >= var10_10) continue;
                            if (var42_42 != 0) {
                                var3_3 = var3_3.end;
                                var4_4 = -var3_3.margin;
                                var11_11 -= var4_4;
                                continue;
                            }
                            var3_3 = var3_3.end;
                            var4_4 = -var3_3.margin;
                            var11_11 += var4_4;
                        }
                    }
                }
            }
        }
    }
}

