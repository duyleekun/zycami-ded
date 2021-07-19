/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.BaselineDimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType;
import java.util.List;

public class VerticalWidgetRun
extends WidgetRun {
    public DependencyNode baseline;
    public DimensionDependency baselineDimension;

    public VerticalWidgetRun(ConstraintWidget object) {
        super((ConstraintWidget)object);
        DependencyNode$Type dependencyNode$Type;
        this.baseline = object = new DependencyNode(this);
        this.baselineDimension = null;
        Object object2 = this.start;
        object2.type = dependencyNode$Type = DependencyNode$Type.TOP;
        object2 = this.end;
        object2.type = dependencyNode$Type = DependencyNode$Type.BOTTOM;
        object2 = DependencyNode$Type.BASELINE;
        ((DependencyNode)object).type = object2;
        this.orientation = 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void apply() {
        List list;
        int n10;
        int n11;
        block41: {
            int n12;
            ConstraintAnchor constraintAnchor;
            ConstraintAnchor[] constraintAnchorArray;
            ConstraintWidget constraintWidget;
            int n13;
            int n14;
            int n15;
            block43: {
                int n16;
                block42: {
                    ConstraintWidget constraintWidget2;
                    float f10;
                    float f11;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
                    boolean bl2;
                    Object object;
                    int n17;
                    block40: {
                        block39: {
                            DimensionDependency dimensionDependency;
                            block37: {
                                ConstraintWidget constraintWidget3;
                                block38: {
                                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3;
                                    block36: {
                                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4;
                                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5;
                                        ConstraintWidget constraintWidget4;
                                        block35: {
                                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6;
                                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7;
                                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour8;
                                            ConstraintWidget constraintWidget5 = this.widget;
                                            n15 = constraintWidget5.measured;
                                            if (n15 != 0) {
                                                DimensionDependency dimensionDependency2 = this.dimension;
                                                n11 = constraintWidget5.getHeight();
                                                dimensionDependency2.resolve(n11);
                                            }
                                            DimensionDependency dimensionDependency3 = this.dimension;
                                            n11 = (int)(dimensionDependency3.resolved ? 1 : 0);
                                            if (n11 != 0) break block35;
                                            this.dimensionBehavior = constraintWidget$DimensionBehaviour8 = this.widget.getVerticalDimensionBehaviour();
                                            ConstraintWidget constraintWidget6 = this.widget;
                                            n11 = (int)(constraintWidget6.hasBaseline() ? 1 : 0);
                                            if (n11 != 0) {
                                                BaselineDimensionDependency baselineDimensionDependency = new BaselineDimensionDependency(this);
                                                this.baselineDimension = baselineDimensionDependency;
                                            }
                                            if ((constraintWidget$DimensionBehaviour7 = this.dimensionBehavior) != (constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour9;
                                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour10;
                                                ConstraintWidget constraintWidget7;
                                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour11 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                                                if (constraintWidget$DimensionBehaviour7 == constraintWidget$DimensionBehaviour11 && (constraintWidget7 = this.widget.getParent()) != null && (constraintWidget$DimensionBehaviour10 = constraintWidget7.getVerticalDimensionBehaviour()) == (constraintWidget$DimensionBehaviour9 = ConstraintWidget$DimensionBehaviour.FIXED)) {
                                                    n15 = constraintWidget7.getHeight();
                                                    int n18 = this.widget.mTop.getMargin();
                                                    n15 -= n18;
                                                    n18 = this.widget.mBottom.getMargin();
                                                    DependencyNode dependencyNode = this.start;
                                                    DependencyNode dependencyNode2 = constraintWidget7.verticalRun.start;
                                                    int n19 = this.widget.mTop.getMargin();
                                                    this.addTarget(dependencyNode, dependencyNode2, n19);
                                                    DependencyNode dependencyNode3 = this.end;
                                                    DependencyNode dependencyNode4 = constraintWidget7.verticalRun.end;
                                                    int n20 = -this.widget.mBottom.getMargin();
                                                    this.addTarget(dependencyNode3, dependencyNode4, n20);
                                                    this.dimension.resolve(n15 -= n18);
                                                    return;
                                                }
                                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour12 = this.dimensionBehavior;
                                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour13 = ConstraintWidget$DimensionBehaviour.FIXED;
                                                if (constraintWidget$DimensionBehaviour12 == constraintWidget$DimensionBehaviour13) {
                                                    DimensionDependency dimensionDependency4 = this.dimension;
                                                    ConstraintWidget constraintWidget8 = this.widget;
                                                    n15 = constraintWidget8.getHeight();
                                                    dimensionDependency4.resolve(n15);
                                                }
                                            }
                                            break block36;
                                        }
                                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour14 = this.dimensionBehavior;
                                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour15 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                                        if (constraintWidget$DimensionBehaviour14 == constraintWidget$DimensionBehaviour15 && (constraintWidget4 = this.widget.getParent()) != null && (constraintWidget$DimensionBehaviour5 = constraintWidget4.getVerticalDimensionBehaviour()) == (constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.FIXED)) {
                                            DependencyNode dependencyNode = this.start;
                                            DependencyNode dependencyNode5 = constraintWidget4.verticalRun.start;
                                            int n21 = this.widget.mTop.getMargin();
                                            this.addTarget(dependencyNode, dependencyNode5, n21);
                                            DependencyNode dependencyNode6 = this.end;
                                            DependencyNode dependencyNode7 = constraintWidget4.verticalRun.end;
                                            int n22 = -this.widget.mBottom.getMargin();
                                            this.addTarget(dependencyNode6, dependencyNode7, n22);
                                            return;
                                        }
                                    }
                                    dimensionDependency = this.dimension;
                                    n15 = dimensionDependency.resolved;
                                    n14 = 0;
                                    Object var5_192 = null;
                                    n13 = 4;
                                    n10 = 1;
                                    n17 = 2;
                                    n16 = 3;
                                    if (n15 != 0) {
                                        object = this.widget;
                                        bl2 = ((ConstraintWidget)object).measured;
                                        if (bl2) {
                                            ConstraintAnchor constraintAnchor2;
                                            ConstraintAnchor[] constraintAnchorArray2 = ((ConstraintWidget)object).mListAnchors;
                                            ConstraintAnchor constraintAnchor3 = constraintAnchorArray2[n17].mTarget;
                                            if (constraintAnchor3 != null && (constraintAnchor2 = constraintAnchorArray2[n16].mTarget) != null) {
                                                n11 = (int)(((ConstraintWidget)object).isInVerticalChain() ? 1 : 0);
                                                if (n11 != 0) {
                                                    DependencyNode dependencyNode = this.start;
                                                    dependencyNode.margin = n15 = this.widget.mListAnchors[n17].getMargin();
                                                    DependencyNode dependencyNode8 = this.end;
                                                    ConstraintAnchor constraintAnchor4 = this.widget.mListAnchors[n16];
                                                    dependencyNode8.margin = n15 = -constraintAnchor4.getMargin();
                                                } else {
                                                    ConstraintAnchor constraintAnchor5;
                                                    DependencyNode dependencyNode;
                                                    ConstraintAnchor constraintAnchor6 = this.widget.mListAnchors[n17];
                                                    DependencyNode dependencyNode9 = this.getTarget(constraintAnchor6);
                                                    if (dependencyNode9 != null) {
                                                        DependencyNode dependencyNode10 = this.start;
                                                        ConstraintAnchor constraintAnchor7 = this.widget.mListAnchors[n17];
                                                        n14 = constraintAnchor7.getMargin();
                                                        this.addTarget(dependencyNode10, dependencyNode9, n14);
                                                    }
                                                    if ((dependencyNode = this.getTarget(constraintAnchor5 = this.widget.mListAnchors[n16])) != null) {
                                                        DependencyNode dependencyNode11 = this.end;
                                                        ConstraintAnchor constraintAnchor8 = this.widget.mListAnchors[n16];
                                                        n14 = -constraintAnchor8.getMargin();
                                                        this.addTarget(dependencyNode11, dependencyNode, n14);
                                                    }
                                                    this.start.delegateToWidgetRun = n10;
                                                    DependencyNode dependencyNode12 = this.end;
                                                    dependencyNode12.delegateToWidgetRun = n10;
                                                }
                                                ConstraintWidget constraintWidget9 = this.widget;
                                                n11 = (int)(constraintWidget9.hasBaseline() ? 1 : 0);
                                                if (n11 == 0) return;
                                                DependencyNode dependencyNode = this.baseline;
                                                DependencyNode dependencyNode13 = this.start;
                                                ConstraintWidget constraintWidget10 = this.widget;
                                                n14 = constraintWidget10.getBaselineDistance();
                                                this.addTarget(dependencyNode, dependencyNode13, n14);
                                                return;
                                            }
                                            ConstraintAnchor constraintAnchor9 = constraintAnchorArray2[n17].mTarget;
                                            if (constraintAnchor9 != null) {
                                                ConstraintAnchor constraintAnchor10 = constraintAnchorArray2[n17];
                                                DependencyNode dependencyNode = this.getTarget(constraintAnchor10);
                                                if (dependencyNode == null) return;
                                                DependencyNode dependencyNode14 = this.start;
                                                n14 = this.widget.mListAnchors[n17].getMargin();
                                                this.addTarget(dependencyNode14, dependencyNode, n14);
                                                DependencyNode dependencyNode15 = this.end;
                                                DependencyNode dependencyNode16 = this.start;
                                                DimensionDependency dimensionDependency5 = this.dimension;
                                                n14 = dimensionDependency5.value;
                                                this.addTarget(dependencyNode15, dependencyNode16, n14);
                                                ConstraintWidget constraintWidget11 = this.widget;
                                                n11 = (int)(constraintWidget11.hasBaseline() ? 1 : 0);
                                                if (n11 == 0) return;
                                                DependencyNode dependencyNode17 = this.baseline;
                                                DependencyNode dependencyNode18 = this.start;
                                                ConstraintWidget constraintWidget12 = this.widget;
                                                n14 = constraintWidget12.getBaselineDistance();
                                                this.addTarget(dependencyNode17, dependencyNode18, n14);
                                                return;
                                            }
                                            ConstraintAnchor constraintAnchor11 = constraintAnchorArray2[n16].mTarget;
                                            if (constraintAnchor11 != null) {
                                                ConstraintWidget constraintWidget13;
                                                ConstraintAnchor constraintAnchor12 = constraintAnchorArray2[n16];
                                                DependencyNode dependencyNode = this.getTarget(constraintAnchor12);
                                                if (dependencyNode != null) {
                                                    DependencyNode dependencyNode19 = this.end;
                                                    n14 = -this.widget.mListAnchors[n16].getMargin();
                                                    this.addTarget(dependencyNode19, dependencyNode, n14);
                                                    DependencyNode dependencyNode20 = this.start;
                                                    DependencyNode dependencyNode21 = this.end;
                                                    DimensionDependency dimensionDependency6 = this.dimension;
                                                    n14 = -dimensionDependency6.value;
                                                    this.addTarget(dependencyNode20, dependencyNode21, n14);
                                                }
                                                if ((n11 = (int)((constraintWidget13 = this.widget).hasBaseline() ? 1 : 0)) == 0) return;
                                                DependencyNode dependencyNode22 = this.baseline;
                                                DependencyNode dependencyNode23 = this.start;
                                                ConstraintWidget constraintWidget14 = this.widget;
                                                n14 = constraintWidget14.getBaselineDistance();
                                                this.addTarget(dependencyNode22, dependencyNode23, n14);
                                                return;
                                            }
                                            ConstraintAnchor constraintAnchor13 = constraintAnchorArray2[n13].mTarget;
                                            if (constraintAnchor13 != null) {
                                                ConstraintAnchor constraintAnchor14 = constraintAnchorArray2[n13];
                                                DependencyNode dependencyNode = this.getTarget(constraintAnchor14);
                                                if (dependencyNode == null) return;
                                                DependencyNode dependencyNode24 = this.baseline;
                                                this.addTarget(dependencyNode24, dependencyNode, 0);
                                                DependencyNode dependencyNode25 = this.start;
                                                DependencyNode dependencyNode26 = this.baseline;
                                                n14 = -this.widget.getBaselineDistance();
                                                this.addTarget(dependencyNode25, dependencyNode26, n14);
                                                DependencyNode dependencyNode27 = this.end;
                                                DependencyNode dependencyNode28 = this.start;
                                                DimensionDependency dimensionDependency7 = this.dimension;
                                                n14 = dimensionDependency7.value;
                                                this.addTarget(dependencyNode27, dependencyNode28, n14);
                                                return;
                                            }
                                            n11 = object instanceof Helper;
                                            if (n11 != 0) return;
                                            ConstraintWidget constraintWidget15 = ((ConstraintWidget)object).getParent();
                                            if (constraintWidget15 == null) return;
                                            ConstraintWidget constraintWidget16 = this.widget;
                                            ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.CENTER;
                                            ConstraintAnchor constraintAnchor15 = constraintWidget16.getAnchor((ConstraintAnchor$Type)constraintAnchor$Type).mTarget;
                                            if (constraintAnchor15 != null) return;
                                            DependencyNode dependencyNode = this.widget.getParent().verticalRun.start;
                                            DependencyNode dependencyNode29 = this.start;
                                            n14 = this.widget.getY();
                                            this.addTarget(dependencyNode29, dependencyNode, n14);
                                            DependencyNode dependencyNode30 = this.end;
                                            DependencyNode dependencyNode31 = this.start;
                                            DimensionDependency dimensionDependency8 = this.dimension;
                                            n14 = dimensionDependency8.value;
                                            this.addTarget(dependencyNode30, dependencyNode31, n14);
                                            ConstraintWidget constraintWidget17 = this.widget;
                                            n11 = (int)(constraintWidget17.hasBaseline() ? 1 : 0);
                                            if (n11 == 0) return;
                                            DependencyNode dependencyNode32 = this.baseline;
                                            DependencyNode dependencyNode33 = this.start;
                                            ConstraintWidget constraintWidget18 = this.widget;
                                            n14 = constraintWidget18.getBaselineDistance();
                                            this.addTarget(dependencyNode32, dependencyNode33, n14);
                                            return;
                                        }
                                    }
                                    if (n15 != 0 || (constraintWidget$DimensionBehaviour3 = this.dimensionBehavior) != (object = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) break block37;
                                    constraintWidget3 = this.widget;
                                    n15 = constraintWidget3.mMatchConstraintDefaultHeight;
                                    if (n15 == n17) break block38;
                                    if (n15 == n16 && (n11 = (int)(constraintWidget3.isInVerticalChain() ? 1 : 0)) == 0) {
                                        ConstraintWidget constraintWidget19 = this.widget;
                                        n15 = constraintWidget19.mMatchConstraintDefaultWidth;
                                        if (n15 != n16) {
                                            DimensionDependency dimensionDependency9 = constraintWidget19.horizontalRun.dimension;
                                            this.dimension.targets.add(dimensionDependency9);
                                            List list2 = dimensionDependency9.dependencies;
                                            DimensionDependency dimensionDependency10 = this.dimension;
                                            list2.add(dimensionDependency10);
                                            DimensionDependency dimensionDependency11 = this.dimension;
                                            dimensionDependency11.delegateToWidgetRun = n10;
                                            List list3 = dimensionDependency11.dependencies;
                                            DependencyNode dependencyNode = this.start;
                                            list3.add(dependencyNode);
                                            List list4 = this.dimension.dependencies;
                                            DependencyNode dependencyNode34 = this.end;
                                            list4.add(dependencyNode34);
                                        }
                                    }
                                    break block39;
                                }
                                ConstraintWidget constraintWidget20 = constraintWidget3.getParent();
                                if (constraintWidget20 != null) {
                                    DimensionDependency dimensionDependency12 = constraintWidget20.verticalRun.dimension;
                                    this.dimension.targets.add(dimensionDependency12);
                                    List list5 = dimensionDependency12.dependencies;
                                    DimensionDependency dimensionDependency13 = this.dimension;
                                    list5.add(dimensionDependency13);
                                    DimensionDependency dimensionDependency14 = this.dimension;
                                    dimensionDependency14.delegateToWidgetRun = n10;
                                    List list6 = dimensionDependency14.dependencies;
                                    DependencyNode dependencyNode = this.start;
                                    list6.add(dependencyNode);
                                    List list7 = this.dimension.dependencies;
                                    DependencyNode dependencyNode35 = this.end;
                                    list7.add(dependencyNode35);
                                }
                                break block39;
                            }
                            dimensionDependency.addDependency(this);
                        }
                        constraintWidget = this.widget;
                        constraintAnchorArray = constraintWidget.mListAnchors;
                        object = constraintAnchorArray[n17].mTarget;
                        if (object == null || (object = constraintAnchorArray[n16].mTarget) == null) break block40;
                        n11 = (int)(constraintWidget.isInVerticalChain() ? 1 : 0);
                        if (n11 != 0) {
                            DependencyNode dependencyNode = this.start;
                            dependencyNode.margin = n15 = this.widget.mListAnchors[n17].getMargin();
                            DependencyNode dependencyNode36 = this.end;
                            ConstraintAnchor constraintAnchor16 = this.widget.mListAnchors[n16];
                            dependencyNode36.margin = n15 = -constraintAnchor16.getMargin();
                        } else {
                            WidgetRun$RunType widgetRun$RunType;
                            ConstraintAnchor constraintAnchor17 = this.widget.mListAnchors[n17];
                            DependencyNode dependencyNode = this.getTarget(constraintAnchor17);
                            ConstraintAnchor constraintAnchor18 = this.widget.mListAnchors[n16];
                            DependencyNode dependencyNode37 = this.getTarget(constraintAnchor18);
                            dependencyNode.addDependency(this);
                            dependencyNode37.addDependency(this);
                            this.mRunType = widgetRun$RunType = WidgetRun$RunType.CENTER;
                        }
                        ConstraintWidget constraintWidget21 = this.widget;
                        n11 = (int)(constraintWidget21.hasBaseline() ? 1 : 0);
                        if (n11 != 0) {
                            DependencyNode dependencyNode = this.baseline;
                            DependencyNode dependencyNode38 = this.start;
                            DimensionDependency dimensionDependency = this.baselineDimension;
                            this.addTarget(dependencyNode, dependencyNode38, n10, dimensionDependency);
                        }
                        break block41;
                    }
                    object = constraintAnchorArray[n17].mTarget;
                    bl2 = false;
                    if (object == null) break block42;
                    ConstraintAnchor constraintAnchor19 = constraintAnchorArray[n17];
                    DependencyNode dependencyNode = this.getTarget(constraintAnchor19);
                    if (dependencyNode == null) break block41;
                    DependencyNode dependencyNode39 = this.start;
                    n14 = this.widget.mListAnchors[n17].getMargin();
                    this.addTarget(dependencyNode39, dependencyNode, n14);
                    DependencyNode dependencyNode40 = this.end;
                    DependencyNode dependencyNode41 = this.start;
                    DimensionDependency dimensionDependency = this.dimension;
                    this.addTarget(dependencyNode40, dependencyNode41, n10, dimensionDependency);
                    ConstraintWidget constraintWidget22 = this.widget;
                    n11 = (int)(constraintWidget22.hasBaseline() ? 1 : 0);
                    if (n11 != 0) {
                        DependencyNode dependencyNode42 = this.baseline;
                        DependencyNode dependencyNode43 = this.start;
                        DimensionDependency dimensionDependency15 = this.baselineDimension;
                        this.addTarget(dependencyNode42, dependencyNode43, n10, dimensionDependency15);
                    }
                    if ((constraintWidget$DimensionBehaviour2 = this.dimensionBehavior) == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && (n11 = (int)((f11 = (f10 = (constraintWidget2 = this.widget).getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) > 0) {
                        HorizontalWidgetRun horizontalWidgetRun = this.widget.horizontalRun;
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour16 = horizontalWidgetRun.dimensionBehavior;
                        if (constraintWidget$DimensionBehaviour16 == constraintWidget$DimensionBehaviour) {
                            List list8 = horizontalWidgetRun.dimension.dependencies;
                            DimensionDependency dimensionDependency16 = this.dimension;
                            list8.add(dimensionDependency16);
                            List list9 = this.dimension.targets;
                            DimensionDependency dimensionDependency17 = this.widget.horizontalRun.dimension;
                            list9.add(dimensionDependency17);
                            DimensionDependency dimensionDependency18 = this.dimension;
                            dimensionDependency18.updateDelegate = this;
                        }
                    }
                    break block41;
                }
                constraintAnchor = constraintAnchorArray[n16].mTarget;
                n12 = -1;
                if (constraintAnchor == null) break block43;
                ConstraintAnchor constraintAnchor20 = constraintAnchorArray[n16];
                DependencyNode dependencyNode = this.getTarget(constraintAnchor20);
                if (dependencyNode != null) {
                    DependencyNode dependencyNode44 = this.end;
                    n14 = -this.widget.mListAnchors[n16].getMargin();
                    this.addTarget(dependencyNode44, dependencyNode, n14);
                    DependencyNode dependencyNode45 = this.start;
                    DependencyNode dependencyNode46 = this.end;
                    DimensionDependency dimensionDependency = this.dimension;
                    this.addTarget(dependencyNode45, dependencyNode46, n12, dimensionDependency);
                    ConstraintWidget constraintWidget23 = this.widget;
                    n11 = (int)(constraintWidget23.hasBaseline() ? 1 : 0);
                    if (n11 != 0) {
                        DependencyNode dependencyNode47 = this.baseline;
                        DependencyNode dependencyNode48 = this.start;
                        DimensionDependency dimensionDependency19 = this.baselineDimension;
                        this.addTarget(dependencyNode47, dependencyNode48, n10, dimensionDependency19);
                    }
                }
                break block41;
            }
            constraintAnchor = constraintAnchorArray[n13].mTarget;
            if (constraintAnchor != null) {
                ConstraintAnchor constraintAnchor21 = constraintAnchorArray[n13];
                DependencyNode dependencyNode = this.getTarget(constraintAnchor21);
                if (dependencyNode != null) {
                    DependencyNode dependencyNode49 = this.baseline;
                    this.addTarget(dependencyNode49, dependencyNode, 0);
                    DependencyNode dependencyNode50 = this.start;
                    DependencyNode dependencyNode51 = this.baseline;
                    DimensionDependency dimensionDependency = this.baselineDimension;
                    this.addTarget(dependencyNode50, dependencyNode51, n12, dimensionDependency);
                    DependencyNode dependencyNode52 = this.end;
                    DependencyNode dependencyNode53 = this.start;
                    DimensionDependency dimensionDependency20 = this.dimension;
                    this.addTarget(dependencyNode52, dependencyNode53, n10, dimensionDependency20);
                }
            } else {
                ConstraintWidget constraintWidget24;
                n15 = constraintWidget instanceof Helper;
                if (n15 == 0 && (constraintWidget24 = constraintWidget.getParent()) != null) {
                    ConstraintWidget constraintWidget25;
                    float f12;
                    float f13;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour17;
                    DependencyNode dependencyNode = this.widget.getParent().verticalRun.start;
                    DependencyNode dependencyNode54 = this.start;
                    n14 = this.widget.getY();
                    this.addTarget(dependencyNode54, dependencyNode, n14);
                    DependencyNode dependencyNode55 = this.end;
                    DependencyNode dependencyNode56 = this.start;
                    DimensionDependency dimensionDependency = this.dimension;
                    this.addTarget(dependencyNode55, dependencyNode56, n10, dimensionDependency);
                    ConstraintWidget constraintWidget26 = this.widget;
                    n11 = (int)(constraintWidget26.hasBaseline() ? 1 : 0);
                    if (n11 != 0) {
                        DependencyNode dependencyNode57 = this.baseline;
                        DependencyNode dependencyNode58 = this.start;
                        DimensionDependency dimensionDependency21 = this.baselineDimension;
                        this.addTarget(dependencyNode57, dependencyNode58, n10, dimensionDependency21);
                    }
                    if ((constraintWidget$DimensionBehaviour17 = this.dimensionBehavior) == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && (n11 = (int)((f13 = (f12 = (constraintWidget25 = this.widget).getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) > 0) {
                        HorizontalWidgetRun horizontalWidgetRun = this.widget.horizontalRun;
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour18 = horizontalWidgetRun.dimensionBehavior;
                        if (constraintWidget$DimensionBehaviour18 == constraintWidget$DimensionBehaviour) {
                            List list10 = horizontalWidgetRun.dimension.dependencies;
                            DimensionDependency dimensionDependency22 = this.dimension;
                            list10.add(dimensionDependency22);
                            List list11 = this.dimension.targets;
                            DimensionDependency dimensionDependency23 = this.widget.horizontalRun.dimension;
                            list11.add(dimensionDependency23);
                            DimensionDependency dimensionDependency24 = this.dimension;
                            dimensionDependency24.updateDelegate = this;
                        }
                    }
                }
            }
        }
        if ((n11 = (list = this.dimension.targets).size()) != 0) return;
        DimensionDependency dimensionDependency = this.dimension;
        dimensionDependency.readyToSolve = n10;
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        boolean bl2 = dependencyNode.resolved;
        if (bl2) {
            ConstraintWidget constraintWidget = this.widget;
            int n10 = dependencyNode.value;
            constraintWidget.setY(n10);
        }
    }

    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    public boolean supportsWrapComputation() {
        Object object = this.dimensionBehavior;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        boolean bl2 = true;
        if (object == constraintWidget$DimensionBehaviour) {
            object = this.widget;
            int n10 = ((ConstraintWidget)object).mMatchConstraintDefaultHeight;
            if (n10 == 0) {
                return bl2;
            }
            return false;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerticalRun ");
        String string2 = this.widget.getDebugName();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void update(Dependency object) {
        float f10;
        int n10;
        float f11;
        int n11;
        float f12;
        int n12;
        int n13;
        float f13;
        int n14;
        int n15;
        Object object2;
        Object object3;
        block19: {
            block20: {
                block24: {
                    block26: {
                        float f14;
                        block25: {
                            block21: {
                                block22: {
                                    block23: {
                                        object3 = VerticalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;
                                        object2 = this.mRunType;
                                        n15 = ((Enum)object2).ordinal();
                                        n14 = object3[n15];
                                        n15 = 3;
                                        f13 = 4.2E-45f;
                                        n13 = 2;
                                        n12 = 1;
                                        f12 = Float.MIN_VALUE;
                                        if (n14 != n12) {
                                            if (n14 != n13) {
                                                if (n14 == n15) {
                                                    object3 = this.widget;
                                                    object2 = ((ConstraintWidget)object3).mTop;
                                                    object3 = ((ConstraintWidget)object3).mBottom;
                                                    this.updateRunCenter((Dependency)object, (ConstraintAnchor)object2, (ConstraintAnchor)object3, n12);
                                                    return;
                                                }
                                            } else {
                                                this.updateRunEnd((Dependency)object);
                                            }
                                        } else {
                                            this.updateRunStart((Dependency)object);
                                        }
                                        object = this.dimension;
                                        n14 = (int)(((DependencyNode)object).readyToSolve ? 1 : 0);
                                        n11 = 0x3F000000;
                                        f11 = 0.5f;
                                        if (n14 == 0 || (n10 = ((DependencyNode)object).resolved) != 0 || (object = this.dimensionBehavior) != (object3 = (Object)((Object)ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT))) break block19;
                                        object = this.widget;
                                        n14 = ((ConstraintWidget)object).mMatchConstraintDefaultHeight;
                                        if (n14 == n13) break block20;
                                        if (n14 != n15) break block19;
                                        object3 = object.horizontalRun.dimension;
                                        n14 = (int)(((DependencyNode)object3).resolved ? 1 : 0);
                                        if (n14 == 0) break block19;
                                        n10 = ((ConstraintWidget)object).getDimensionRatioSide();
                                        n14 = -1;
                                        f10 = 0.0f / 0.0f;
                                        if (n10 == n14) break block21;
                                        if (n10 == 0) break block22;
                                        if (n10 == n12) break block23;
                                        n10 = 0;
                                        object = null;
                                        float f15 = 0.0f;
                                        break block24;
                                    }
                                    object = this.widget;
                                    object3 = object.horizontalRun.dimension;
                                    n14 = ((DependencyNode)object3).value;
                                    f10 = n14;
                                    f14 = ((ConstraintWidget)object).getDimensionRatio();
                                    break block25;
                                }
                                object = this.widget;
                                object3 = object.horizontalRun.dimension;
                                n14 = ((DependencyNode)object3).value;
                                f10 = n14;
                                float f16 = ((ConstraintWidget)object).getDimensionRatio();
                                f10 *= f16;
                                break block26;
                            }
                            object = this.widget;
                            object3 = object.horizontalRun.dimension;
                            n14 = ((DependencyNode)object3).value;
                            f10 = n14;
                            f14 = ((ConstraintWidget)object).getDimensionRatio();
                        }
                        f10 /= f14;
                    }
                    n10 = (int)(f10 += f11);
                }
                object3 = this.dimension;
                ((DimensionDependency)object3).resolve(n10);
                break block19;
            }
            if ((object = ((ConstraintWidget)object).getParent()) != null) {
                object = object.verticalRun.dimension;
                n14 = (int)(((DependencyNode)object).resolved ? 1 : 0);
                if (n14 != 0) {
                    f10 = this.widget.mMatchConstraintPercentHeight;
                    float f17 = (float)((DependencyNode)object).value * f10 + f11;
                    n10 = (int)f17;
                    object3 = this.dimension;
                    ((DimensionDependency)object3).resolve(n10);
                }
            }
        }
        object = this.start;
        n14 = (int)(((DependencyNode)object).readyToSolve ? 1 : 0);
        if (n14 != 0) {
            object3 = this.end;
            n15 = (int)(((DependencyNode)object3).readyToSolve ? 1 : 0);
            if (n15 != 0) {
                n10 = ((DependencyNode)object).resolved;
                if (n10 != 0 && (n10 = ((DependencyNode)object3).resolved) != 0) {
                    object = this.dimension;
                    n10 = ((DependencyNode)object).resolved;
                    if (n10 != 0) {
                        return;
                    }
                }
                object = this.dimension;
                n10 = ((DependencyNode)object).resolved;
                if (n10 == 0 && (object = this.dimensionBehavior) == (object3 = (Object)((Object)ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT))) {
                    object = this.widget;
                    n14 = ((ConstraintWidget)object).mMatchConstraintDefaultWidth;
                    if (n14 == 0 && (n10 = (int)(((ConstraintWidget)object).isInVerticalChain() ? 1 : 0)) == 0) {
                        object = (DependencyNode)this.start.targets.get(0);
                        object3 = (DependencyNode)this.end.targets.get(0);
                        n10 = ((DependencyNode)object).value;
                        object2 = this.start;
                        n13 = ((DependencyNode)object2).margin;
                        n10 += n13;
                        n14 = ((DependencyNode)object3).value;
                        n13 = this.end.margin;
                        n14 += n13;
                        n13 = n14 - n10;
                        ((DependencyNode)object2).resolve(n10);
                        this.end.resolve(n14);
                        this.dimension.resolve(n13);
                        return;
                    }
                }
                object = this.dimension;
                n10 = ((DependencyNode)object).resolved;
                if (n10 == 0 && (object = this.dimensionBehavior) == (object3 = (Object)((Object)ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) && (n10 = this.matchConstraintsType) == n12 && (n10 = (object = this.start.targets).size()) > 0 && (n10 = (object = this.end.targets).size()) > 0) {
                    object = (DependencyNode)this.start.targets.get(0);
                    object3 = (DependencyNode)this.end.targets.get(0);
                    n10 = ((DependencyNode)object).value;
                    n15 = this.start.margin;
                    n10 += n15;
                    n14 = ((DependencyNode)object3).value;
                    object2 = this.end;
                    n15 = ((DependencyNode)object2).margin;
                    n14 = n14 + n15 - n10;
                    object = this.dimension;
                    n15 = ((DimensionDependency)object).wrapValue;
                    if (n14 < n15) {
                        ((DimensionDependency)object).resolve(n14);
                    } else {
                        ((DimensionDependency)object).resolve(n15);
                    }
                }
                object = this.dimension;
                n10 = (int)(((DependencyNode)object).resolved ? 1 : 0);
                if (n10 == 0) {
                    return;
                }
                object = this.start.targets;
                n10 = object.size();
                if (n10 > 0 && (n10 = (object = this.end.targets).size()) > 0) {
                    object = (DependencyNode)this.start.targets.get(0);
                    object3 = (DependencyNode)this.end.targets.get(0);
                    n15 = ((DependencyNode)object).value;
                    DependencyNode dependencyNode = this.start;
                    n13 = dependencyNode.margin;
                    n15 += n13;
                    n13 = ((DependencyNode)object3).value;
                    n12 = this.end.margin;
                    n13 += n12;
                    ConstraintWidget constraintWidget = this.widget;
                    f12 = constraintWidget.getVerticalBiasPercent();
                    if (object == object3) {
                        n15 = ((DependencyNode)object).value;
                        n13 = ((DependencyNode)object3).value;
                        n12 = n11;
                        f12 = f11;
                    }
                    n13 -= n15;
                    n10 = this.dimension.value;
                    object = this.start;
                    f10 = (float)n15 + f11;
                    f13 = (float)(n13 -= n10) * f12;
                    n14 = (int)(f10 += f13);
                    ((DependencyNode)object).resolve(n14);
                    object = this.end;
                    object3 = this.start;
                    n14 = ((DependencyNode)object3).value;
                    object2 = this.dimension;
                    n15 = ((DependencyNode)object2).value;
                    ((DependencyNode)object).resolve(n14 += n15);
                }
            }
        }
    }
}

