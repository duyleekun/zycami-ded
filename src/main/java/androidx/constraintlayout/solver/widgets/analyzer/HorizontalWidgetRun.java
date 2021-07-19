/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType;
import java.util.List;

public class HorizontalWidgetRun
extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    public HorizontalWidgetRun(ConstraintWidget object) {
        super((ConstraintWidget)object);
        DependencyNode$Type dependencyNode$Type;
        object = this.start;
        ((DependencyNode)object).type = dependencyNode$Type = DependencyNode$Type.LEFT;
        object = this.end;
        ((DependencyNode)object).type = dependencyNode$Type = DependencyNode$Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] nArray, int n10, int n11, int n12, int n13, float f10, int n14) {
        n11 -= n10;
        n13 -= n12;
        n10 = -1;
        float f11 = 0.0f / 0.0f;
        n12 = 0;
        float f12 = 0.5f;
        int n15 = 1;
        if (n14 != n10) {
            if (n14 != 0) {
                if (n14 == n15) {
                    f11 = (float)n11 * f10 + f12;
                    n10 = (int)f11;
                    nArray[0] = n11;
                    nArray[n15] = n10;
                }
            } else {
                f11 = (float)n13 * f10 + f12;
                nArray[0] = n10 = (int)f11;
                nArray[n15] = n13;
            }
        } else {
            f11 = (float)n13 * f10 + f12;
            n10 = (int)f11;
            float f13 = (float)n11 / f10 + f12;
            int n16 = (int)f13;
            if (n10 <= n11 && n13 <= n13) {
                nArray[0] = n10;
                nArray[n15] = n13;
            } else if (n11 <= n11 && n16 <= n13) {
                nArray[0] = n11;
                nArray[n15] = n16;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void apply() {
        ConstraintAnchor constraintAnchor;
        int n10;
        int n11;
        Object object;
        int n12;
        int n13;
        block22: {
            ConstraintWidget constraintWidget;
            block25: {
                DimensionDependency dimensionDependency;
                block26: {
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
                    int n14;
                    block24: {
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3;
                        ConstraintWidget constraintWidget2;
                        block23: {
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4;
                            ConstraintWidget constraintWidget3 = this.widget;
                            n13 = constraintWidget3.measured;
                            if (n13 != 0) {
                                DimensionDependency dimensionDependency2 = this.dimension;
                                n12 = constraintWidget3.getWidth();
                                dimensionDependency2.resolve(n12);
                            }
                            DimensionDependency dimensionDependency3 = this.dimension;
                            n12 = (int)(dimensionDependency3.resolved ? 1 : 0);
                            if (n12 != 0) break block23;
                            this.dimensionBehavior = constraintWidget$DimensionBehaviour4 = this.widget.getHorizontalDimensionBehaviour();
                            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                            if (constraintWidget$DimensionBehaviour4 != constraintWidget$DimensionBehaviour5) {
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6;
                                ConstraintWidget constraintWidget4;
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                                if (constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour7 && ((constraintWidget4 = this.widget.getParent()) != null && (object = constraintWidget4.getHorizontalDimensionBehaviour()) == (constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.FIXED) || (object = constraintWidget4.getHorizontalDimensionBehaviour()) == constraintWidget$DimensionBehaviour7)) {
                                    n13 = constraintWidget4.getWidth();
                                    int n15 = this.widget.mLeft.getMargin();
                                    n13 -= n15;
                                    n15 = this.widget.mRight.getMargin();
                                    object = this.start;
                                    DependencyNode dependencyNode = constraintWidget4.horizontalRun.start;
                                    int n16 = this.widget.mLeft.getMargin();
                                    this.addTarget((DependencyNode)object, dependencyNode, n16);
                                    object = this.end;
                                    DependencyNode dependencyNode2 = constraintWidget4.horizontalRun.end;
                                    int n17 = -this.widget.mRight.getMargin();
                                    this.addTarget((DependencyNode)object, dependencyNode2, n17);
                                    this.dimension.resolve(n13 -= n15);
                                    return;
                                }
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour8 = this.dimensionBehavior;
                                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour9 = ConstraintWidget$DimensionBehaviour.FIXED;
                                if (constraintWidget$DimensionBehaviour8 == constraintWidget$DimensionBehaviour9) {
                                    DimensionDependency dimensionDependency4 = this.dimension;
                                    ConstraintWidget constraintWidget5 = this.widget;
                                    n13 = constraintWidget5.getWidth();
                                    dimensionDependency4.resolve(n13);
                                }
                            }
                            break block24;
                        }
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour10 = this.dimensionBehavior;
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour11 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                        if (constraintWidget$DimensionBehaviour10 == constraintWidget$DimensionBehaviour11 && ((constraintWidget2 = this.widget.getParent()) != null && (object = constraintWidget2.getHorizontalDimensionBehaviour()) == (constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.FIXED) || (object = constraintWidget2.getHorizontalDimensionBehaviour()) == constraintWidget$DimensionBehaviour11)) {
                            DependencyNode dependencyNode = this.start;
                            object = constraintWidget2.horizontalRun.start;
                            int n18 = this.widget.mLeft.getMargin();
                            this.addTarget(dependencyNode, (DependencyNode)object, n18);
                            DependencyNode dependencyNode3 = this.end;
                            DependencyNode dependencyNode4 = constraintWidget2.horizontalRun.end;
                            int n19 = -this.widget.mRight.getMargin();
                            this.addTarget(dependencyNode3, dependencyNode4, n19);
                            return;
                        }
                    }
                    dimensionDependency = this.dimension;
                    n13 = dimensionDependency.resolved;
                    n11 = 0;
                    object = null;
                    n10 = 1;
                    if (n13 != 0) {
                        ConstraintWidget constraintWidget6 = this.widget;
                        n14 = constraintWidget6.measured;
                        if (n14 != 0) {
                            ConstraintAnchor constraintAnchor2;
                            ConstraintAnchor[] constraintAnchorArray = constraintWidget6.mListAnchors;
                            ConstraintAnchor constraintAnchor3 = constraintAnchorArray[0].mTarget;
                            if (constraintAnchor3 != null && (constraintAnchor2 = constraintAnchorArray[n10].mTarget) != null) {
                                ConstraintAnchor constraintAnchor4;
                                DependencyNode dependencyNode;
                                n12 = (int)(constraintWidget6.isInHorizontalChain() ? 1 : 0);
                                if (n12 != 0) {
                                    DependencyNode dependencyNode5 = this.start;
                                    dependencyNode5.margin = n13 = this.widget.mListAnchors[0].getMargin();
                                    DependencyNode dependencyNode6 = this.end;
                                    ConstraintAnchor constraintAnchor5 = this.widget.mListAnchors[n10];
                                    dependencyNode6.margin = n13 = -constraintAnchor5.getMargin();
                                    return;
                                }
                                ConstraintAnchor constraintAnchor6 = this.widget.mListAnchors[0];
                                DependencyNode dependencyNode7 = this.getTarget(constraintAnchor6);
                                if (dependencyNode7 != null) {
                                    DependencyNode dependencyNode8 = this.start;
                                    ConstraintAnchor[] constraintAnchorArray2 = this.widget.mListAnchors;
                                    object = constraintAnchorArray2[0];
                                    n11 = ((ConstraintAnchor)object).getMargin();
                                    this.addTarget(dependencyNode8, dependencyNode7, n11);
                                }
                                if ((dependencyNode = this.getTarget(constraintAnchor4 = this.widget.mListAnchors[n10])) != null) {
                                    DependencyNode dependencyNode9 = this.end;
                                    object = this.widget.mListAnchors[n10];
                                    n11 = -((ConstraintAnchor)object).getMargin();
                                    this.addTarget(dependencyNode9, dependencyNode, n11);
                                }
                                this.start.delegateToWidgetRun = n10;
                                DependencyNode dependencyNode10 = this.end;
                                dependencyNode10.delegateToWidgetRun = n10;
                                return;
                            }
                            ConstraintAnchor constraintAnchor7 = constraintAnchorArray[0].mTarget;
                            if (constraintAnchor7 != null) {
                                ConstraintAnchor constraintAnchor8 = constraintAnchorArray[0];
                                DependencyNode dependencyNode = this.getTarget(constraintAnchor8);
                                if (dependencyNode == null) return;
                                DependencyNode dependencyNode11 = this.start;
                                ConstraintAnchor[] constraintAnchorArray3 = this.widget.mListAnchors;
                                n11 = constraintAnchorArray3[0].getMargin();
                                this.addTarget(dependencyNode11, dependencyNode, n11);
                                DependencyNode dependencyNode12 = this.end;
                                DependencyNode dependencyNode13 = this.start;
                                object = this.dimension;
                                n11 = ((DependencyNode)object).value;
                                this.addTarget(dependencyNode12, dependencyNode13, n11);
                                return;
                            }
                            object = constraintAnchorArray[n10].mTarget;
                            if (object != null) {
                                ConstraintAnchor constraintAnchor9 = constraintAnchorArray[n10];
                                DependencyNode dependencyNode = this.getTarget(constraintAnchor9);
                                if (dependencyNode == null) return;
                                DependencyNode dependencyNode14 = this.end;
                                n11 = -this.widget.mListAnchors[n10].getMargin();
                                this.addTarget(dependencyNode14, dependencyNode, n11);
                                DependencyNode dependencyNode15 = this.start;
                                DependencyNode dependencyNode16 = this.end;
                                object = this.dimension;
                                n11 = -((DependencyNode)object).value;
                                this.addTarget(dependencyNode15, dependencyNode16, n11);
                                return;
                            }
                            n12 = constraintWidget6 instanceof Helper;
                            if (n12 != 0) return;
                            ConstraintWidget constraintWidget7 = constraintWidget6.getParent();
                            if (constraintWidget7 == null) return;
                            ConstraintWidget constraintWidget8 = this.widget;
                            ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.CENTER;
                            ConstraintAnchor constraintAnchor10 = constraintWidget8.getAnchor((ConstraintAnchor$Type)constraintAnchor$Type).mTarget;
                            if (constraintAnchor10 != null) return;
                            DependencyNode dependencyNode = this.widget.getParent().horizontalRun.start;
                            DependencyNode dependencyNode17 = this.start;
                            n11 = this.widget.getX();
                            this.addTarget(dependencyNode17, dependencyNode, n11);
                            DependencyNode dependencyNode18 = this.end;
                            DependencyNode dependencyNode19 = this.start;
                            object = this.dimension;
                            n11 = ((DependencyNode)object).value;
                            this.addTarget(dependencyNode18, dependencyNode19, n11);
                            return;
                        }
                    }
                    if ((constraintWidget$DimensionBehaviour2 = this.dimensionBehavior) != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) break block22;
                    constraintWidget = this.widget;
                    n14 = constraintWidget.mMatchConstraintDefaultWidth;
                    int n20 = 2;
                    if (n14 == n20) break block25;
                    n20 = 3;
                    if (n14 != n20) break block22;
                    n14 = constraintWidget.mMatchConstraintDefaultHeight;
                    if (n14 != n20) break block26;
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                    DependencyNode dependencyNode = verticalWidgetRun.start;
                    dependencyNode.updateDelegate = this;
                    DependencyNode dependencyNode20 = verticalWidgetRun.end;
                    dependencyNode20.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    n12 = (int)(constraintWidget.isInVerticalChain() ? 1 : 0);
                    if (n12 != 0) {
                        List list = this.dimension.targets;
                        DimensionDependency dimensionDependency5 = this.widget.verticalRun.dimension;
                        list.add(dimensionDependency5);
                        List list2 = this.widget.verticalRun.dimension.dependencies;
                        DimensionDependency dimensionDependency6 = this.dimension;
                        list2.add(dimensionDependency6);
                        VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                        verticalWidgetRun2.dimension.updateDelegate = this;
                        List list3 = this.dimension.targets;
                        DependencyNode dependencyNode21 = verticalWidgetRun2.start;
                        list3.add(dependencyNode21);
                        List list4 = this.dimension.targets;
                        DependencyNode dependencyNode22 = this.widget.verticalRun.end;
                        list4.add(dependencyNode22);
                        List list5 = this.widget.verticalRun.start.dependencies;
                        DimensionDependency dimensionDependency7 = this.dimension;
                        list5.add(dimensionDependency7);
                        List list6 = this.widget.verticalRun.end.dependencies;
                        DimensionDependency dimensionDependency8 = this.dimension;
                        list6.add(dimensionDependency8);
                        break block22;
                    } else {
                        ConstraintWidget constraintWidget9 = this.widget;
                        n12 = (int)(constraintWidget9.isInHorizontalChain() ? 1 : 0);
                        if (n12 != 0) {
                            List list = this.widget.verticalRun.dimension.targets;
                            DimensionDependency dimensionDependency9 = this.dimension;
                            list.add(dimensionDependency9);
                            List list7 = this.dimension.dependencies;
                            DimensionDependency dimensionDependency10 = this.widget.verticalRun.dimension;
                            list7.add(dimensionDependency10);
                            break block22;
                        } else {
                            List list = this.widget.verticalRun.dimension.targets;
                            DimensionDependency dimensionDependency11 = this.dimension;
                            list.add(dimensionDependency11);
                        }
                    }
                    break block22;
                }
                DimensionDependency dimensionDependency12 = constraintWidget.verticalRun.dimension;
                dimensionDependency.targets.add(dimensionDependency12);
                List list = dimensionDependency12.dependencies;
                DimensionDependency dimensionDependency13 = this.dimension;
                list.add(dimensionDependency13);
                List list8 = this.widget.verticalRun.start.dependencies;
                DimensionDependency dimensionDependency14 = this.dimension;
                list8.add(dimensionDependency14);
                List list9 = this.widget.verticalRun.end.dependencies;
                DimensionDependency dimensionDependency15 = this.dimension;
                list9.add(dimensionDependency15);
                DimensionDependency dimensionDependency16 = this.dimension;
                dimensionDependency16.delegateToWidgetRun = n10;
                List list10 = dimensionDependency16.dependencies;
                DependencyNode dependencyNode = this.start;
                list10.add(dependencyNode);
                List list11 = this.dimension.dependencies;
                DependencyNode dependencyNode23 = this.end;
                list11.add(dependencyNode23);
                List list12 = this.start.targets;
                DimensionDependency dimensionDependency17 = this.dimension;
                list12.add(dimensionDependency17);
                List list13 = this.end.targets;
                DimensionDependency dimensionDependency18 = this.dimension;
                list13.add(dimensionDependency18);
                break block22;
            }
            ConstraintWidget constraintWidget10 = constraintWidget.getParent();
            if (constraintWidget10 != null) {
                DimensionDependency dimensionDependency = constraintWidget10.verticalRun.dimension;
                this.dimension.targets.add(dimensionDependency);
                List list = dimensionDependency.dependencies;
                DimensionDependency dimensionDependency19 = this.dimension;
                list.add(dimensionDependency19);
                DimensionDependency dimensionDependency20 = this.dimension;
                dimensionDependency20.delegateToWidgetRun = n10;
                List list14 = dimensionDependency20.dependencies;
                DependencyNode dependencyNode = this.start;
                list14.add(dependencyNode);
                List list15 = this.dimension.dependencies;
                DependencyNode dependencyNode24 = this.end;
                list15.add(dependencyNode24);
            }
        }
        ConstraintWidget constraintWidget = this.widget;
        ConstraintAnchor[] constraintAnchorArray = constraintWidget.mListAnchors;
        ConstraintAnchor constraintAnchor11 = constraintAnchorArray[0].mTarget;
        if (constraintAnchor11 != null && (constraintAnchor = constraintAnchorArray[n10].mTarget) != null) {
            WidgetRun$RunType widgetRun$RunType;
            n12 = (int)(constraintWidget.isInHorizontalChain() ? 1 : 0);
            if (n12 != 0) {
                DependencyNode dependencyNode = this.start;
                dependencyNode.margin = n13 = this.widget.mListAnchors[0].getMargin();
                DependencyNode dependencyNode25 = this.end;
                ConstraintAnchor constraintAnchor12 = this.widget.mListAnchors[n10];
                dependencyNode25.margin = n13 = -constraintAnchor12.getMargin();
                return;
            }
            ConstraintAnchor constraintAnchor13 = this.widget.mListAnchors[0];
            DependencyNode dependencyNode = this.getTarget(constraintAnchor13);
            ConstraintAnchor constraintAnchor14 = this.widget.mListAnchors[n10];
            DependencyNode dependencyNode26 = this.getTarget(constraintAnchor14);
            dependencyNode.addDependency(this);
            dependencyNode26.addDependency(this);
            this.mRunType = widgetRun$RunType = WidgetRun$RunType.CENTER;
            return;
        }
        ConstraintAnchor constraintAnchor15 = constraintAnchorArray[0].mTarget;
        if (constraintAnchor15 != null) {
            ConstraintAnchor constraintAnchor16 = constraintAnchorArray[0];
            DependencyNode dependencyNode = this.getTarget(constraintAnchor16);
            if (dependencyNode == null) return;
            DependencyNode dependencyNode27 = this.start;
            ConstraintAnchor[] constraintAnchorArray4 = this.widget.mListAnchors;
            n11 = constraintAnchorArray4[0].getMargin();
            this.addTarget(dependencyNode27, dependencyNode, n11);
            DependencyNode dependencyNode28 = this.end;
            DependencyNode dependencyNode29 = this.start;
            object = this.dimension;
            this.addTarget(dependencyNode28, dependencyNode29, n10, (DimensionDependency)object);
            return;
        }
        object = constraintAnchorArray[n10].mTarget;
        if (object != null) {
            ConstraintAnchor constraintAnchor17 = constraintAnchorArray[n10];
            DependencyNode dependencyNode = this.getTarget(constraintAnchor17);
            if (dependencyNode == null) return;
            DependencyNode dependencyNode30 = this.end;
            object = this.widget.mListAnchors[n10];
            n11 = -((ConstraintAnchor)object).getMargin();
            this.addTarget(dependencyNode30, dependencyNode, n11);
            DependencyNode dependencyNode31 = this.start;
            DependencyNode dependencyNode32 = this.end;
            n11 = -1;
            DimensionDependency dimensionDependency = this.dimension;
            this.addTarget(dependencyNode31, dependencyNode32, n11, dimensionDependency);
            return;
        }
        n13 = constraintWidget instanceof Helper;
        if (n13 != 0) return;
        ConstraintWidget constraintWidget11 = constraintWidget.getParent();
        if (constraintWidget11 == null) return;
        DependencyNode dependencyNode = this.widget.getParent().horizontalRun.start;
        DependencyNode dependencyNode33 = this.start;
        n11 = this.widget.getX();
        this.addTarget(dependencyNode33, dependencyNode, n11);
        DependencyNode dependencyNode34 = this.end;
        DependencyNode dependencyNode35 = this.start;
        object = this.dimension;
        this.addTarget(dependencyNode34, dependencyNode35, n10, (DimensionDependency)object);
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        boolean bl2 = dependencyNode.resolved;
        if (bl2) {
            ConstraintWidget constraintWidget = this.widget;
            int n10 = dependencyNode.value;
            constraintWidget.setX(n10);
        }
    }

    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    public boolean supportsWrapComputation() {
        Object object = this.dimensionBehavior;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        boolean bl2 = true;
        if (object == constraintWidget$DimensionBehaviour) {
            object = this.widget;
            int n10 = ((ConstraintWidget)object).mMatchConstraintDefaultWidth;
            if (n10 == 0) {
                return bl2;
            }
            return false;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HorizontalRun ");
        String string2 = this.widget.getDebugName();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void update(Dependency dependency) {
        float f10;
        int n10;
        Object object;
        Object object2;
        int n11;
        float f11;
        int n12;
        Object object3;
        int n13;
        float f12;
        int n14;
        float f13;
        int n15;
        Object object4;
        Object object5;
        Object object6;
        HorizontalWidgetRun horizontalWidgetRun;
        block39: {
            block40: {
                block52: {
                    float f14;
                    block53: {
                        block54: {
                            int n16;
                            int n17;
                            DependencyNode dependencyNode;
                            DependencyNode dependencyNode2;
                            block50: {
                                block51: {
                                    block48: {
                                        block49: {
                                            float f15;
                                            block41: {
                                                block45: {
                                                    block47: {
                                                        float f16;
                                                        block46: {
                                                            block42: {
                                                                block43: {
                                                                    block44: {
                                                                        horizontalWidgetRun = this;
                                                                        object6 = HorizontalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;
                                                                        object5 = this.mRunType;
                                                                        object4 = object5.ordinal();
                                                                        n15 = object6[object4];
                                                                        object4 = 2;
                                                                        f13 = 2.8E-45f;
                                                                        n14 = 3;
                                                                        f12 = 4.2E-45f;
                                                                        n13 = 1;
                                                                        f15 = Float.MIN_VALUE;
                                                                        if (n15 != n13) {
                                                                            if (n15 != object4) {
                                                                                if (n15 == n14) {
                                                                                    object6 = this.widget;
                                                                                    object5 = ((ConstraintWidget)object6).mLeft;
                                                                                    object6 = ((ConstraintWidget)object6).mRight;
                                                                                    Dependency dependency2 = dependency;
                                                                                    this.updateRunCenter(dependency, (ConstraintAnchor)object5, (ConstraintAnchor)object6, 0);
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                object3 = dependency;
                                                                                this.updateRunEnd(dependency);
                                                                            }
                                                                        } else {
                                                                            object3 = dependency;
                                                                            this.updateRunStart(dependency);
                                                                        }
                                                                        object6 = horizontalWidgetRun.dimension;
                                                                        n15 = (int)(((DependencyNode)object6).resolved ? 1 : 0);
                                                                        n12 = 0x3F000000;
                                                                        f11 = 0.5f;
                                                                        if (n15 != 0 || (object6 = (Object)((Object)horizontalWidgetRun.dimensionBehavior)) != (object3 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) break block39;
                                                                        object6 = horizontalWidgetRun.widget;
                                                                        n11 = ((ConstraintWidget)object6).mMatchConstraintDefaultWidth;
                                                                        if (n11 == object4) break block40;
                                                                        if (n11 != n14) break block39;
                                                                        object4 = ((ConstraintWidget)object6).mMatchConstraintDefaultHeight;
                                                                        n11 = -1;
                                                                        if (object4 == 0 || object4 == n14) break block41;
                                                                        n15 = ((ConstraintWidget)object6).getDimensionRatioSide();
                                                                        if (n15 == n11) break block42;
                                                                        if (n15 == 0) break block43;
                                                                        if (n15 == n13) break block44;
                                                                        n15 = 0;
                                                                        object6 = null;
                                                                        float f17 = 0.0f;
                                                                        break block45;
                                                                    }
                                                                    object6 = horizontalWidgetRun.widget;
                                                                    object5 = object6.verticalRun.dimension;
                                                                    object4 = ((DependencyNode)object5).value;
                                                                    f13 = object4;
                                                                    f16 = ((ConstraintWidget)object6).getDimensionRatio();
                                                                    break block46;
                                                                }
                                                                object6 = horizontalWidgetRun.widget;
                                                                object5 = object6.verticalRun.dimension;
                                                                object4 = ((DependencyNode)object5).value;
                                                                f13 = object4;
                                                                float f18 = ((ConstraintWidget)object6).getDimensionRatio();
                                                                f13 /= f18;
                                                                break block47;
                                                            }
                                                            object6 = horizontalWidgetRun.widget;
                                                            object5 = object6.verticalRun.dimension;
                                                            object4 = ((DependencyNode)object5).value;
                                                            f13 = object4;
                                                            f16 = ((ConstraintWidget)object6).getDimensionRatio();
                                                        }
                                                        f13 *= f16;
                                                    }
                                                    n15 = (int)(f13 += f11);
                                                }
                                                object5 = horizontalWidgetRun.dimension;
                                                ((DimensionDependency)object5).resolve(n15);
                                                break block39;
                                            }
                                            object5 = ((ConstraintWidget)object6).verticalRun;
                                            dependencyNode2 = ((WidgetRun)object5).start;
                                            dependencyNode = ((WidgetRun)object5).end;
                                            object5 = object6.mLeft.mTarget;
                                            if (object5 != null) {
                                                object4 = n13;
                                                f13 = f15;
                                            } else {
                                                object4 = 0;
                                                object5 = null;
                                                f13 = 0.0f;
                                            }
                                            object2 = object6.mTop.mTarget;
                                            if (object2 != null) {
                                                n14 = n13;
                                                f12 = f15;
                                            } else {
                                                n14 = 0;
                                                object2 = null;
                                                f12 = 0.0f;
                                            }
                                            object = object6.mRight.mTarget;
                                            if (object != null) {
                                                n10 = n13;
                                                f10 = f15;
                                            } else {
                                                n10 = 0;
                                                object = null;
                                                f10 = 0.0f;
                                            }
                                            ConstraintAnchor constraintAnchor = object6.mBottom.mTarget;
                                            if (constraintAnchor != null) {
                                                n17 = n13;
                                            } else {
                                                n17 = 0;
                                                constraintAnchor = null;
                                            }
                                            n16 = ((ConstraintWidget)object6).getDimensionRatioSide();
                                            if (object4 == 0 || n14 == 0 || n10 == 0 || n17 == 0) break block48;
                                            object6 = horizontalWidgetRun.widget;
                                            float f19 = ((ConstraintWidget)object6).getDimensionRatio();
                                            n15 = (int)(dependencyNode2.resolved ? 1 : 0);
                                            if (n15 != 0 && (n15 = (int)(dependencyNode.resolved ? 1 : 0)) != 0) {
                                                object6 = horizontalWidgetRun.start;
                                                object4 = ((DependencyNode)object6).readyToSolve;
                                                if (object4 != 0) {
                                                    object5 = horizontalWidgetRun.end;
                                                    object4 = ((DependencyNode)object5).readyToSolve;
                                                    if (object4 != 0) {
                                                        n15 = ((DependencyNode)object6.targets.get((int)0)).value;
                                                        object4 = horizontalWidgetRun.start.margin;
                                                        n14 = n15 + object4;
                                                        n15 = ((DependencyNode)horizontalWidgetRun.end.targets.get((int)0)).value;
                                                        object4 = horizontalWidgetRun.end.margin;
                                                        n11 = n15 - object4;
                                                        n15 = dependencyNode2.value;
                                                        object4 = dependencyNode2.margin;
                                                        n10 = n15 + object4;
                                                        n15 = dependencyNode.value;
                                                        object4 = dependencyNode.margin;
                                                        n17 = n15 - object4;
                                                        object5 = tempDimensions;
                                                        object6 = this;
                                                        this.computeInsetRatio((int[])object5, n14, n11, n10, n17, f19, n16);
                                                        object6 = horizontalWidgetRun.dimension;
                                                        object4 = tempDimensions[0];
                                                        ((DimensionDependency)object6).resolve((int)object4);
                                                        object6 = horizontalWidgetRun.widget.verticalRun.dimension;
                                                        object5 = tempDimensions;
                                                        object4 = (Object)object5[n13];
                                                        ((DimensionDependency)object6).resolve((int)object4);
                                                    }
                                                }
                                                return;
                                            }
                                            object6 = horizontalWidgetRun.start;
                                            object4 = ((DependencyNode)object6).resolved;
                                            if (object4 != 0) {
                                                object5 = horizontalWidgetRun.end;
                                                n14 = (int)(((DependencyNode)object5).resolved ? 1 : 0);
                                                if (n14 != 0) {
                                                    n14 = (int)(dependencyNode2.readyToSolve ? 1 : 0);
                                                    if (n14 != 0 && (n14 = (int)(dependencyNode.readyToSolve ? 1 : 0)) != 0) {
                                                        n14 = ((DependencyNode)object6).value;
                                                        n15 = ((DependencyNode)object6).margin;
                                                        n14 += n15;
                                                        n15 = ((DependencyNode)object5).value;
                                                        object4 = ((DependencyNode)object5).margin;
                                                        n11 = n15 - object4;
                                                        n15 = ((DependencyNode)dependencyNode2.targets.get((int)0)).value;
                                                        object4 = dependencyNode2.margin;
                                                        n10 = n15 + object4;
                                                        n15 = ((DependencyNode)dependencyNode.targets.get((int)0)).value;
                                                        object4 = dependencyNode.margin;
                                                        n17 = n15 - object4;
                                                        object5 = tempDimensions;
                                                        object6 = this;
                                                        this.computeInsetRatio((int[])object5, n14, n11, n10, n17, f19, n16);
                                                        object6 = horizontalWidgetRun.dimension;
                                                        object4 = tempDimensions[0];
                                                        ((DimensionDependency)object6).resolve((int)object4);
                                                        object6 = horizontalWidgetRun.widget.verticalRun.dimension;
                                                        object5 = tempDimensions;
                                                        object4 = (Object)object5[n13];
                                                        ((DimensionDependency)object6).resolve((int)object4);
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            }
                                            object6 = horizontalWidgetRun.start;
                                            object4 = ((DependencyNode)object6).readyToSolve;
                                            if (object4 == 0) break block49;
                                            object5 = horizontalWidgetRun.end;
                                            object4 = ((DependencyNode)object5).readyToSolve;
                                            if (object4 == 0 || (object4 = (Object)dependencyNode2.readyToSolve) == 0 || (object4 = (Object)dependencyNode.readyToSolve) == 0) break block49;
                                            n15 = ((DependencyNode)object6.targets.get((int)0)).value;
                                            object4 = horizontalWidgetRun.start.margin;
                                            n14 = n15 + object4;
                                            n15 = ((DependencyNode)horizontalWidgetRun.end.targets.get((int)0)).value;
                                            object4 = horizontalWidgetRun.end.margin;
                                            n11 = n15 - object4;
                                            n15 = ((DependencyNode)dependencyNode2.targets.get((int)0)).value;
                                            object4 = dependencyNode2.margin;
                                            n10 = n15 + object4;
                                            n15 = ((DependencyNode)dependencyNode.targets.get((int)0)).value;
                                            object4 = dependencyNode.margin;
                                            n17 = n15 - object4;
                                            object5 = tempDimensions;
                                            object6 = this;
                                            this.computeInsetRatio((int[])object5, n14, n11, n10, n17, f19, n16);
                                            object6 = horizontalWidgetRun.dimension;
                                            object4 = tempDimensions[0];
                                            ((DimensionDependency)object6).resolve((int)object4);
                                            object6 = horizontalWidgetRun.widget.verticalRun.dimension;
                                            object5 = tempDimensions;
                                            object4 = (Object)object5[n13];
                                            ((DimensionDependency)object6).resolve((int)object4);
                                            break block39;
                                        }
                                        return;
                                    }
                                    if (object4 == 0 || n10 == 0) break block50;
                                    object6 = horizontalWidgetRun.start;
                                    n15 = (int)(((DependencyNode)object6).readyToSolve ? 1 : 0);
                                    if (n15 == 0) break block51;
                                    object6 = horizontalWidgetRun.end;
                                    n15 = (int)(((DependencyNode)object6).readyToSolve ? 1 : 0);
                                    if (n15 == 0) break block51;
                                    object6 = horizontalWidgetRun.widget;
                                    float f20 = ((ConstraintWidget)object6).getDimensionRatio();
                                    object5 = (DependencyNode)horizontalWidgetRun.start.targets.get(0);
                                    object4 = ((DependencyNode)object5).value;
                                    n14 = horizontalWidgetRun.start.margin;
                                    object4 += n14;
                                    object2 = (DependencyNode)horizontalWidgetRun.end.targets.get(0);
                                    n14 = ((DependencyNode)object2).value;
                                    object = horizontalWidgetRun.end;
                                    n10 = ((DependencyNode)object).margin;
                                    n14 -= n10;
                                    if (n16 != n11 && n16 != 0) {
                                        if (n16 == n13) {
                                            n14 -= object4;
                                            object4 = horizontalWidgetRun.getLimitedDimension(n14, 0);
                                            f12 = (float)object4 / f20 + f11;
                                            if ((n14 = (int)f12) != (n11 = horizontalWidgetRun.getLimitedDimension(n14, n13))) {
                                                f13 = (float)n11 * f20 + f11;
                                                object4 = (int)f13;
                                            }
                                            horizontalWidgetRun.dimension.resolve((int)object4);
                                            object6 = horizontalWidgetRun.widget.verticalRun.dimension;
                                            ((DimensionDependency)object6).resolve(n11);
                                        }
                                    } else {
                                        n14 -= object4;
                                        object4 = horizontalWidgetRun.getLimitedDimension(n14, 0);
                                        f12 = (float)object4 * f20 + f11;
                                        if ((n14 = (int)f12) != (n11 = horizontalWidgetRun.getLimitedDimension(n14, n13))) {
                                            f13 = (float)n11 / f20 + f11;
                                            object4 = (int)f13;
                                        }
                                        horizontalWidgetRun.dimension.resolve((int)object4);
                                        object6 = horizontalWidgetRun.widget.verticalRun.dimension;
                                        ((DimensionDependency)object6).resolve(n11);
                                    }
                                    break block39;
                                }
                                return;
                            }
                            if (n14 == 0 || n17 == 0) break block39;
                            n15 = (int)(dependencyNode2.readyToSolve ? 1 : 0);
                            if (n15 == 0 || (n15 = (int)(dependencyNode.readyToSolve ? 1 : 0)) == 0) break block52;
                            object6 = horizontalWidgetRun.widget;
                            f14 = ((ConstraintWidget)object6).getDimensionRatio();
                            object5 = (DependencyNode)dependencyNode2.targets.get(0);
                            object4 = ((DependencyNode)object5).value;
                            n14 = dependencyNode2.margin;
                            object4 += n14;
                            object2 = (DependencyNode)dependencyNode.targets.get(0);
                            n14 = ((DependencyNode)object2).value;
                            n10 = dependencyNode.margin;
                            n14 -= n10;
                            if (n16 == n11) break block53;
                            if (n16 == 0) break block54;
                            if (n16 == n13) break block53;
                            break block39;
                        }
                        n14 -= object4;
                        object4 = horizontalWidgetRun.getLimitedDimension(n14, n13);
                        f12 = (float)object4 * f14 + f11;
                        if ((n14 = (int)f12) != (n11 = horizontalWidgetRun.getLimitedDimension(n14, 0))) {
                            f13 = (float)n11 / f14 + f11;
                            object4 = (int)f13;
                        }
                        horizontalWidgetRun.dimension.resolve(n11);
                        object6 = horizontalWidgetRun.widget.verticalRun.dimension;
                        ((DimensionDependency)object6).resolve((int)object4);
                        break block39;
                    }
                    n14 -= object4;
                    object4 = horizontalWidgetRun.getLimitedDimension(n14, n13);
                    f12 = (float)object4 / f14 + f11;
                    if ((n14 = (int)f12) != (n11 = horizontalWidgetRun.getLimitedDimension(n14, 0))) {
                        f13 = (float)n11 * f14 + f11;
                        object4 = (int)f13;
                    }
                    horizontalWidgetRun.dimension.resolve(n11);
                    object6 = horizontalWidgetRun.widget.verticalRun.dimension;
                    ((DimensionDependency)object6).resolve((int)object4);
                    break block39;
                }
                return;
            }
            if ((object6 = ((ConstraintWidget)object6).getParent()) != null) {
                object6 = object6.horizontalRun.dimension;
                object4 = ((DependencyNode)object6).resolved;
                if (object4 != 0) {
                    f13 = horizontalWidgetRun.widget.mMatchConstraintPercentWidth;
                    float f21 = (float)((DependencyNode)object6).value * f13 + f11;
                    n15 = (int)f21;
                    object5 = horizontalWidgetRun.dimension;
                    ((DimensionDependency)object5).resolve(n15);
                }
            }
        }
        object6 = horizontalWidgetRun.start;
        object4 = ((DependencyNode)object6).readyToSolve;
        if (object4 != 0) {
            object5 = horizontalWidgetRun.end;
            n14 = (int)(((DependencyNode)object5).readyToSolve ? 1 : 0);
            if (n14 != 0) {
                n15 = (int)(((DependencyNode)object6).resolved ? 1 : 0);
                if (n15 != 0 && (n15 = (int)(((DependencyNode)object5).resolved ? 1 : 0)) != 0) {
                    object6 = horizontalWidgetRun.dimension;
                    n15 = (int)(((DependencyNode)object6).resolved ? 1 : 0);
                    if (n15 != 0) {
                        return;
                    }
                }
                object6 = horizontalWidgetRun.dimension;
                n15 = (int)(((DependencyNode)object6).resolved ? 1 : 0);
                if (n15 == 0 && (object6 = horizontalWidgetRun.dimensionBehavior) == (object5 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                    object6 = horizontalWidgetRun.widget;
                    object4 = ((ConstraintWidget)object6).mMatchConstraintDefaultWidth;
                    if (object4 == 0 && (n15 = (int)(((ConstraintWidget)object6).isInHorizontalChain() ? 1 : 0)) == 0) {
                        object6 = (DependencyNode)horizontalWidgetRun.start.targets.get(0);
                        object5 = (DependencyNode)horizontalWidgetRun.end.targets.get(0);
                        n15 = ((DependencyNode)object6).value;
                        object2 = horizontalWidgetRun.start;
                        n11 = ((DependencyNode)object2).margin;
                        n15 += n11;
                        object4 = ((DependencyNode)object5).value;
                        n11 = horizontalWidgetRun.end.margin;
                        object4 += n11;
                        n11 = object4 - n15;
                        ((DependencyNode)object2).resolve(n15);
                        horizontalWidgetRun.end.resolve((int)object4);
                        horizontalWidgetRun.dimension.resolve(n11);
                        return;
                    }
                }
                object6 = horizontalWidgetRun.dimension;
                n15 = (int)(((DependencyNode)object6).resolved ? 1 : 0);
                if (n15 == 0 && (object6 = (Object)((Object)horizontalWidgetRun.dimensionBehavior)) == (object5 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && (n15 = horizontalWidgetRun.matchConstraintsType) == n13 && (n15 = (object6 = horizontalWidgetRun.start.targets).size()) > 0 && (n15 = (object6 = horizontalWidgetRun.end.targets).size()) > 0) {
                    object6 = (DependencyNode)horizontalWidgetRun.start.targets.get(0);
                    object5 = (DependencyNode)horizontalWidgetRun.end.targets.get(0);
                    n15 = ((DependencyNode)object6).value;
                    n14 = horizontalWidgetRun.start.margin;
                    n15 += n14;
                    object4 = ((DependencyNode)object5).value;
                    object2 = horizontalWidgetRun.end;
                    n14 = ((DependencyNode)object2).margin;
                    object4 = object4 + n14 - n15;
                    object6 = horizontalWidgetRun.dimension;
                    n15 = ((DimensionDependency)object6).wrapValue;
                    n15 = Math.min(object4, n15);
                    object5 = horizontalWidgetRun.widget;
                    n14 = ((ConstraintWidget)object5).mMatchConstraintMaxWidth;
                    object4 = ((ConstraintWidget)object5).mMatchConstraintMinWidth;
                    n15 = Math.max(object4, n15);
                    if (n14 > 0) {
                        n15 = Math.min(n14, n15);
                    }
                    object5 = horizontalWidgetRun.dimension;
                    ((DimensionDependency)object5).resolve(n15);
                }
                object6 = horizontalWidgetRun.dimension;
                n15 = (int)(((DependencyNode)object6).resolved ? 1 : 0);
                if (n15 == 0) {
                    return;
                }
                object6 = (DependencyNode)horizontalWidgetRun.start.targets.get(0);
                object5 = (DependencyNode)horizontalWidgetRun.end.targets.get(0);
                n14 = ((DependencyNode)object6).value;
                object3 = horizontalWidgetRun.start;
                n11 = ((DependencyNode)object3).margin;
                n14 += n11;
                n11 = ((DependencyNode)object5).value;
                n10 = horizontalWidgetRun.end.margin;
                n11 += n10;
                object = horizontalWidgetRun.widget;
                f10 = ((ConstraintWidget)object).getHorizontalBiasPercent();
                if (object6 == object5) {
                    n14 = ((DependencyNode)object6).value;
                    n11 = ((DependencyNode)object5).value;
                    n10 = n12;
                    f10 = f11;
                }
                n11 -= n14;
                n15 = horizontalWidgetRun.dimension.value;
                object6 = horizontalWidgetRun.start;
                f13 = (float)n14 + f11;
                f12 = (float)(n11 -= n15) * f10;
                object4 = (int)(f13 += f12);
                ((DependencyNode)object6).resolve((int)object4);
                object6 = horizontalWidgetRun.end;
                object5 = horizontalWidgetRun.start;
                object4 = ((DependencyNode)object5).value;
                object2 = horizontalWidgetRun.dimension;
                n14 = ((DependencyNode)object2).value;
                ((DependencyNode)object6).resolve((int)(object4 += n14));
            }
        }
    }
}

