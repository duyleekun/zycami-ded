/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.GuidelineReference;
import androidx.constraintlayout.solver.widgets.analyzer.HelperReferences;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.RunGroup;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    public ArrayList mGroups;
    private BasicMeasure$Measure mMeasure;
    private BasicMeasure$Measurer mMeasurer;
    private boolean mNeedBuildGraph;
    private boolean mNeedRedoMeasures;
    private ArrayList mRuns;
    private ArrayList runGroups;

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        boolean bl2;
        this.mNeedBuildGraph = bl2 = true;
        this.mNeedRedoMeasures = bl2;
        ArrayList arrayList = new ArrayList();
        this.mRuns = arrayList;
        arrayList = new ArrayList();
        this.runGroups = arrayList;
        this.mMeasurer = null;
        arrayList = new ArrayList();
        this.mMeasure = arrayList;
        this.mGroups = arrayList = new ArrayList();
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode object, int n10, int n11, DependencyNode dependencyNode, ArrayList arrayList, RunGroup runGroup) {
        object = ((DependencyNode)object).run;
        Object object2 = ((WidgetRun)object).runGroup;
        if (object2 == null) {
            object2 = this.container;
            Object object3 = ((ConstraintWidget)object2).horizontalRun;
            if (object != object3 && object != (object2 = ((ConstraintWidget)object2).verticalRun)) {
                Iterator iterator2;
                int n12;
                boolean bl2;
                boolean bl3;
                if (runGroup == null) {
                    runGroup = new RunGroup((WidgetRun)object, n11);
                    arrayList.add(runGroup);
                }
                ((WidgetRun)object).runGroup = runGroup;
                runGroup.add((WidgetRun)object);
                Iterator iterator3 = object.start.dependencies.iterator();
                while (bl3 = iterator3.hasNext()) {
                    object2 = (Dependency)iterator3.next();
                    bl2 = object2 instanceof DependencyNode;
                    if (!bl2) continue;
                    object3 = object2;
                    object3 = (DependencyNode)object2;
                    n12 = 0;
                    object2 = this;
                    this.applyGroup((DependencyNode)object3, n10, 0, dependencyNode, arrayList, runGroup);
                }
                iterator3 = object.end.dependencies.iterator();
                while (bl3 = iterator3.hasNext()) {
                    object2 = (Dependency)iterator3.next();
                    bl2 = object2 instanceof DependencyNode;
                    if (!bl2) continue;
                    object3 = object2;
                    object3 = (DependencyNode)object2;
                    n12 = 1;
                    object2 = this;
                    this.applyGroup((DependencyNode)object3, n10, n12, dependencyNode, arrayList, runGroup);
                }
                n11 = 1;
                if (n10 == n11 && (bl3 = object instanceof VerticalWidgetRun)) {
                    object2 = object;
                    object2 = ((VerticalWidgetRun)object).baseline.dependencies;
                    iterator2 = object2.iterator();
                    while (bl3 = iterator2.hasNext()) {
                        object2 = (Dependency)iterator2.next();
                        bl2 = object2 instanceof DependencyNode;
                        if (!bl2) continue;
                        object3 = object2;
                        object3 = (DependencyNode)object2;
                        n12 = 2;
                        object2 = this;
                        this.applyGroup((DependencyNode)object3, n10, n12, dependencyNode, arrayList, runGroup);
                    }
                }
                object2 = ((WidgetRun)object).start.targets;
                iterator2 = object2.iterator();
                while (bl3 = iterator2.hasNext()) {
                    object3 = object2 = iterator2.next();
                    object3 = (DependencyNode)object2;
                    if (object3 == dependencyNode) {
                        runGroup.dual = n11;
                    }
                    n12 = 0;
                    object2 = this;
                    this.applyGroup((DependencyNode)object3, n10, 0, dependencyNode, arrayList, runGroup);
                }
                object2 = ((WidgetRun)object).end.targets;
                iterator2 = object2.iterator();
                while (bl3 = iterator2.hasNext()) {
                    object3 = object2 = iterator2.next();
                    object3 = (DependencyNode)object2;
                    if (object3 == dependencyNode) {
                        runGroup.dual = n11;
                    }
                    n12 = 1;
                    object2 = this;
                    this.applyGroup((DependencyNode)object3, n10, n12, dependencyNode, arrayList, runGroup);
                }
                if (n10 == n11 && (n11 = object instanceof VerticalWidgetRun) != 0) {
                    object = ((VerticalWidgetRun)object).baseline.targets.iterator();
                    while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        iterator3 = object.next();
                        object3 = iterator3;
                        object3 = (DependencyNode)((Object)iterator3);
                        n12 = 2;
                        object2 = this;
                        this.applyGroup((DependencyNode)object3, n10, n12, dependencyNode, arrayList, runGroup);
                    }
                }
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        Iterator iterator2 = constraintWidgetContainer.mChildren.iterator();
        while (true) {
            int n10;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            int n11;
            int n12;
            int n13;
            Object object;
            float f10;
            Object object2;
            int n14;
            int n15 = iterator2.hasNext();
            int n16 = 0;
            float f11 = 0.0f;
            Object object3 = null;
            if (n15 == 0) break;
            ConstraintWidget constraintWidget = (ConstraintWidget)iterator2.next();
            Object object4 = constraintWidget.mListDimensionBehaviors;
            Object object5 = object4[0];
            int n17 = 1;
            object4 = object4[n17];
            int n18 = constraintWidget.getVisibility();
            if (n18 == (n14 = 8)) {
                constraintWidget.measured = n17;
                continue;
            }
            float f12 = constraintWidget.mMatchConstraintPercentWidth;
            float f13 = 1.0f;
            n18 = f12 == f13 ? 0 : (f12 < f13 ? -1 : 1);
            n14 = 2;
            if (n18 < 0 && object5 == (object2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                constraintWidget.mMatchConstraintDefaultWidth = n14;
            }
            if ((n18 = (int)((f10 = (f12 = constraintWidget.mMatchConstraintPercentHeight) - f13) == 0.0f ? 0 : (f10 < 0.0f ? -1 : 1))) < 0 && object4 == (object2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                constraintWidget.mMatchConstraintDefaultHeight = n14;
            }
            f12 = constraintWidget.getDimensionRatio();
            Object object6 = null;
            float f14 = f12 - 0.0f;
            n18 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            int n19 = 3;
            if (n18 > 0) {
                object2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (object5 == object2 && (object4 == (object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || object4 == (object = ConstraintWidget$DimensionBehaviour.FIXED))) {
                    constraintWidget.mMatchConstraintDefaultWidth = n19;
                } else if (object4 == object2 && (object5 == (object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || object5 == (object = ConstraintWidget$DimensionBehaviour.FIXED))) {
                    constraintWidget.mMatchConstraintDefaultHeight = n19;
                } else if (object5 == object2 && object4 == object2) {
                    n18 = constraintWidget.mMatchConstraintDefaultWidth;
                    if (n18 == 0) {
                        constraintWidget.mMatchConstraintDefaultWidth = n19;
                    }
                    if ((n18 = constraintWidget.mMatchConstraintDefaultHeight) == 0) {
                        constraintWidget.mMatchConstraintDefaultHeight = n19;
                    }
                }
            }
            if (object5 == (object2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && (n13 = constraintWidget.mMatchConstraintDefaultWidth) == n17 && ((object = constraintWidget.mLeft.mTarget) == null || (object = constraintWidget.mRight.mTarget) == null)) {
                object5 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            }
            object = object5;
            if (object4 == object2 && (n12 = constraintWidget.mMatchConstraintDefaultHeight) == n17 && ((object5 = constraintWidget.mTop.mTarget) == null || (object5 = constraintWidget.mBottom.mTarget) == null)) {
                object4 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            }
            Object object7 = object4;
            object4 = constraintWidget.horizontalRun;
            object4.dimensionBehavior = object;
            object4.matchConstraintsType = n12 = constraintWidget.mMatchConstraintDefaultWidth;
            object4 = constraintWidget.verticalRun;
            object4.dimensionBehavior = object7;
            object4.matchConstraintsType = n11 = constraintWidget.mMatchConstraintDefaultHeight;
            object4 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
            if (object != object4 && object != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED) && object != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || object7 != object4 && object7 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED) && object7 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                float f15;
                float f16;
                Object object8;
                Object object9;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
                float f17 = 0.5f;
                if (object == object2 && (object7 == (constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || object7 == (object9 = ConstraintWidget$DimensionBehaviour.FIXED))) {
                    if (n12 == n19) {
                        if (object7 == constraintWidget$DimensionBehaviour2) {
                            n14 = 0;
                            object8 = null;
                            n13 = 0;
                            object = null;
                            object4 = this;
                            object5 = constraintWidget;
                            object2 = constraintWidget$DimensionBehaviour2;
                            object6 = constraintWidget$DimensionBehaviour2;
                            this.measure(constraintWidget, constraintWidget$DimensionBehaviour2, 0, constraintWidget$DimensionBehaviour2, 0);
                        }
                        n13 = constraintWidget.getHeight();
                        f11 = n13;
                        f16 = constraintWidget.mDimensionRatio;
                        f11 = f11 * f16 + f17;
                        n14 = (int)f11;
                        object6 = ConstraintWidget$DimensionBehaviour.FIXED;
                        object4 = this;
                        object5 = constraintWidget;
                        object2 = object6;
                        this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object6), n14, (ConstraintWidget$DimensionBehaviour)((Object)object6), n13);
                        object3 = constraintWidget.horizontalRun.dimension;
                        n10 = constraintWidget.getWidth();
                        ((DimensionDependency)object3).resolve(n10);
                        object3 = constraintWidget.verticalRun.dimension;
                        n10 = constraintWidget.getHeight();
                        ((DimensionDependency)object3).resolve(n10);
                        constraintWidget.measured = n17;
                        continue;
                    }
                    if (n12 == n17) {
                        n14 = 0;
                        object8 = null;
                        n13 = 0;
                        object = null;
                        object4 = this;
                        object5 = constraintWidget;
                        object2 = constraintWidget$DimensionBehaviour2;
                        object6 = object7;
                        this.measure(constraintWidget, constraintWidget$DimensionBehaviour2, 0, (ConstraintWidget$DimensionBehaviour)((Object)object7), 0);
                        object3 = constraintWidget.horizontalRun.dimension;
                        ((DimensionDependency)object3).wrapValue = n15 = constraintWidget.getWidth();
                        continue;
                    }
                    if (n12 == n14) {
                        object9 = constraintWidgetContainer2.mListDimensionBehaviors;
                        constraintWidget$DimensionBehaviour2 = object9[0];
                        object8 = ConstraintWidget$DimensionBehaviour.FIXED;
                        if (constraintWidget$DimensionBehaviour2 == object8 || (object9 = object9[0]) == object4) {
                            f11 = constraintWidget.mMatchConstraintPercentWidth;
                            f16 = constraintWidgetContainer.getWidth();
                            f11 = f11 * f16 + f17;
                            n16 = (int)f11;
                            n13 = constraintWidget.getHeight();
                            object4 = this;
                            object5 = constraintWidget;
                            object2 = object8;
                            n14 = n16;
                            object6 = object7;
                            this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object8), n16, (ConstraintWidget$DimensionBehaviour)((Object)object7), n13);
                            object3 = constraintWidget.horizontalRun.dimension;
                            n10 = constraintWidget.getWidth();
                            ((DimensionDependency)object3).resolve(n10);
                            object3 = constraintWidget.verticalRun.dimension;
                            n10 = constraintWidget.getHeight();
                            ((DimensionDependency)object3).resolve(n10);
                            constraintWidget.measured = n17;
                            continue;
                        }
                    } else {
                        object8 = constraintWidget.mListAnchors;
                        object9 = object8[0].mTarget;
                        if (object9 == null || (object8 = object8[n17].mTarget) == null) {
                            n14 = 0;
                            object8 = null;
                            n13 = 0;
                            object = null;
                            object4 = this;
                            object5 = constraintWidget;
                            object2 = constraintWidget$DimensionBehaviour2;
                            object6 = object7;
                            this.measure(constraintWidget, constraintWidget$DimensionBehaviour2, 0, (ConstraintWidget$DimensionBehaviour)((Object)object7), 0);
                            object3 = constraintWidget.horizontalRun.dimension;
                            n10 = constraintWidget.getWidth();
                            ((DimensionDependency)object3).resolve(n10);
                            object3 = constraintWidget.verticalRun.dimension;
                            n10 = constraintWidget.getHeight();
                            ((DimensionDependency)object3).resolve(n10);
                            constraintWidget.measured = n17;
                            continue;
                        }
                    }
                }
                if (object7 == object2 && (object == (object9 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || object == (object8 = ConstraintWidget$DimensionBehaviour.FIXED))) {
                    if (n11 == n19) {
                        if (object == object9) {
                            n14 = 0;
                            object8 = null;
                            n13 = 0;
                            object = null;
                            object4 = this;
                            object5 = constraintWidget;
                            object2 = object9;
                            object6 = object9;
                            this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object9), 0, (ConstraintWidget$DimensionBehaviour)((Object)object9), 0);
                        }
                        n14 = constraintWidget.getWidth();
                        f11 = constraintWidget.mDimensionRatio;
                        n10 = constraintWidget.getDimensionRatioSide();
                        n12 = -1;
                        f15 = 0.0f / 0.0f;
                        if (n10 == n12) {
                            n10 = 1065353216;
                            f16 = 1.0f;
                            f11 = f16 / f11;
                        }
                        f16 = (float)n14 * f11 + f17;
                        n13 = (int)f16;
                        object6 = ConstraintWidget$DimensionBehaviour.FIXED;
                        object4 = this;
                        object5 = constraintWidget;
                        object2 = object6;
                        this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object6), n14, (ConstraintWidget$DimensionBehaviour)((Object)object6), n13);
                        object3 = constraintWidget.horizontalRun.dimension;
                        n10 = constraintWidget.getWidth();
                        ((DimensionDependency)object3).resolve(n10);
                        object3 = constraintWidget.verticalRun.dimension;
                        n10 = constraintWidget.getHeight();
                        ((DimensionDependency)object3).resolve(n10);
                        constraintWidget.measured = n17;
                        continue;
                    }
                    if (n11 == n17) {
                        n14 = 0;
                        object8 = null;
                        n16 = 0;
                        f11 = 0.0f;
                        object4 = this;
                        object5 = constraintWidget;
                        object2 = object;
                        object6 = object9;
                        n13 = 0;
                        object = null;
                        this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object2), 0, (ConstraintWidget$DimensionBehaviour)((Object)object9), 0);
                        object3 = constraintWidget.verticalRun.dimension;
                        ((DimensionDependency)object3).wrapValue = n15 = constraintWidget.getHeight();
                        continue;
                    }
                    n14 = 2;
                    if (n11 == n14) {
                        object8 = constraintWidgetContainer2.mListDimensionBehaviors;
                        object6 = object8[n17];
                        object9 = ConstraintWidget$DimensionBehaviour.FIXED;
                        if (object6 == object9 || (object8 = object8[n17]) == object4) {
                            f11 = constraintWidget.mMatchConstraintPercentHeight;
                            n14 = constraintWidget.getWidth();
                            f16 = constraintWidgetContainer.getHeight();
                            f11 = f11 * f16 + f17;
                            n16 = (int)f11;
                            object4 = this;
                            object5 = constraintWidget;
                            object2 = object;
                            object6 = object9;
                            n13 = n16;
                            this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object), n14, (ConstraintWidget$DimensionBehaviour)((Object)object9), n16);
                            object3 = constraintWidget.horizontalRun.dimension;
                            n10 = constraintWidget.getWidth();
                            ((DimensionDependency)object3).resolve(n10);
                            object3 = constraintWidget.verticalRun.dimension;
                            n10 = constraintWidget.getHeight();
                            ((DimensionDependency)object3).resolve(n10);
                            constraintWidget.measured = n17;
                            continue;
                        }
                    } else {
                        object4 = constraintWidget.mListAnchors;
                        n14 = 2;
                        constraintWidget$DimensionBehaviour2 = object4[n14];
                        object8 = ((ConstraintAnchor)constraintWidget$DimensionBehaviour2).mTarget;
                        if (object8 == null || (object4 = ((ConstraintAnchor)object4[n19]).mTarget) == null) {
                            n14 = 0;
                            object8 = null;
                            n13 = 0;
                            object = null;
                            object4 = this;
                            object5 = constraintWidget;
                            object2 = object9;
                            object6 = object7;
                            this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object9), 0, (ConstraintWidget$DimensionBehaviour)((Object)object7), 0);
                            object3 = constraintWidget.horizontalRun.dimension;
                            n10 = constraintWidget.getWidth();
                            ((DimensionDependency)object3).resolve(n10);
                            object3 = constraintWidget.verticalRun.dimension;
                            n10 = constraintWidget.getHeight();
                            ((DimensionDependency)object3).resolve(n10);
                            constraintWidget.measured = n17;
                            continue;
                        }
                    }
                }
                if (object != object2 || object7 != object2) continue;
                if (n12 != n17 && n11 != n17) {
                    n10 = 2;
                    f16 = 2.8E-45f;
                    if (n11 != n10 || n12 != n10 || (object5 = (object4 = constraintWidgetContainer2.mListDimensionBehaviors)[0]) != (object6 = ConstraintWidget$DimensionBehaviour.FIXED) && (object3 = object4[0]) != object6 || (object3 = object4[n17]) != object6 && (object3 = object4[n17]) != object6) continue;
                    f11 = constraintWidget.mMatchConstraintPercentWidth;
                    f16 = constraintWidget.mMatchConstraintPercentHeight;
                    n12 = constraintWidgetContainer.getWidth();
                    f15 = n12;
                    n14 = (int)(f11 * f15 + f17);
                    n16 = constraintWidgetContainer.getHeight();
                    f11 = n16;
                    f16 = f16 * f11 + f17;
                    n13 = (int)f16;
                    object4 = this;
                    object5 = constraintWidget;
                    object2 = object6;
                    this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object6), n14, (ConstraintWidget$DimensionBehaviour)((Object)object6), n13);
                    object3 = constraintWidget.horizontalRun.dimension;
                    n10 = constraintWidget.getWidth();
                    ((DimensionDependency)object3).resolve(n10);
                    object3 = constraintWidget.verticalRun.dimension;
                    n10 = constraintWidget.getHeight();
                    ((DimensionDependency)object3).resolve(n10);
                    constraintWidget.measured = n17;
                    continue;
                }
                object6 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                n14 = 0;
                object8 = null;
                n13 = 0;
                object = null;
                object4 = this;
                object5 = constraintWidget;
                object2 = object6;
                this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object6), 0, (ConstraintWidget$DimensionBehaviour)((Object)object6), 0);
                object3 = constraintWidget.horizontalRun.dimension;
                ((DimensionDependency)object3).wrapValue = n10 = constraintWidget.getWidth();
                object3 = constraintWidget.verticalRun.dimension;
                ((DimensionDependency)object3).wrapValue = n15 = constraintWidget.getHeight();
                continue;
            }
            n16 = constraintWidget.getWidth();
            if (object == object4) {
                n16 = constraintWidgetContainer.getWidth();
                n12 = constraintWidget.mLeft.mMargin;
                n16 -= n12;
                n12 = constraintWidget.mRight.mMargin;
                object5 = ConstraintWidget$DimensionBehaviour.FIXED;
                n14 = n16 -= n12;
                object2 = object5;
            } else {
                n14 = n16;
                object2 = object;
            }
            n16 = constraintWidget.getHeight();
            if (object7 == object4) {
                n16 = constraintWidgetContainer.getHeight();
                n10 = constraintWidget.mTop.mMargin;
                n16 -= n10;
                n10 = constraintWidget.mBottom.mMargin;
                object4 = ConstraintWidget$DimensionBehaviour.FIXED;
                n13 = n16 -= n10;
                object6 = object4;
            } else {
                n13 = n16;
                object6 = object7;
            }
            object4 = this;
            object5 = constraintWidget;
            this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object2), n14, (ConstraintWidget$DimensionBehaviour)((Object)object6), n13);
            object3 = constraintWidget.horizontalRun.dimension;
            n10 = constraintWidget.getWidth();
            ((DimensionDependency)object3).resolve(n10);
            object3 = constraintWidget.verticalRun.dimension;
            n10 = constraintWidget.getHeight();
            ((DimensionDependency)object3).resolve(n10);
            constraintWidget.measured = n17;
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int n10) {
        ArrayList arrayList = this.mGroups;
        int n11 = arrayList.size();
        long l10 = 0L;
        for (int i10 = 0; i10 < n11; ++i10) {
            RunGroup runGroup = (RunGroup)this.mGroups.get(i10);
            long l11 = runGroup.computeWrapSize(constraintWidgetContainer, n10);
            l10 = Math.max(l10, l11);
        }
        return (int)l10;
    }

    private void displayGraph() {
        Object object;
        boolean bl2;
        Object object2 = this.mRuns.iterator();
        Object object3 = "digraph {\n";
        while (bl2 = object2.hasNext()) {
            object = (WidgetRun)object2.next();
            object3 = this.generateDisplayGraph((WidgetRun)object, (String)object3);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append("\n}\n");
        object2 = ((StringBuilder)object2).toString();
        object3 = System.out;
        object = new StringBuilder();
        ((StringBuilder)object).append("content:<<\n");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("\n>>");
        object2 = ((StringBuilder)object).toString();
        ((PrintStream)object3).println((String)object2);
    }

    private void findGroup(WidgetRun object, int n10, ArrayList arrayList) {
        int n11;
        Object object2;
        Object object3;
        DependencyNode dependencyNode;
        int n12;
        Dependency dependency;
        boolean bl2;
        Dependency dependency2;
        boolean bl3;
        Object object4 = object.start.dependencies.iterator();
        while (bl3 = object4.hasNext()) {
            dependency2 = (Dependency)object4.next();
            bl2 = dependency2 instanceof DependencyNode;
            if (bl2) {
                dependency = dependency2;
                dependency = (DependencyNode)dependency2;
                n12 = 0;
                dependencyNode = null;
                object3 = ((WidgetRun)object).end;
                object2 = this;
                n11 = n10;
                this.applyGroup((DependencyNode)dependency, n10, 0, (DependencyNode)object3, arrayList, null);
                continue;
            }
            bl2 = dependency2 instanceof WidgetRun;
            if (!bl2) continue;
            dependency2 = (WidgetRun)dependency2;
            object2 = ((WidgetRun)dependency2).start;
            n11 = 0;
            dependencyNode = ((WidgetRun)object).end;
            object3 = arrayList;
            this.applyGroup((DependencyNode)object2, n10, 0, dependencyNode, arrayList, null);
        }
        object4 = object.end.dependencies.iterator();
        while (bl3 = object4.hasNext()) {
            dependency2 = (Dependency)object4.next();
            bl2 = dependency2 instanceof DependencyNode;
            if (bl2) {
                dependency = dependency2;
                dependency = (DependencyNode)dependency2;
                n12 = 1;
                object3 = ((WidgetRun)object).start;
                object2 = this;
                n11 = n10;
                this.applyGroup((DependencyNode)dependency, n10, n12, (DependencyNode)object3, arrayList, null);
                continue;
            }
            bl2 = dependency2 instanceof WidgetRun;
            if (!bl2) continue;
            dependency2 = (WidgetRun)dependency2;
            object2 = ((WidgetRun)dependency2).end;
            n11 = 1;
            dependencyNode = ((WidgetRun)object).start;
            object3 = arrayList;
            this.applyGroup((DependencyNode)object2, n10, n11, dependencyNode, arrayList, null);
        }
        int n13 = 1;
        if (n10 == n13) {
            object = ((VerticalWidgetRun)object).baseline.dependencies.iterator();
            while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object4 = (Dependency)object.next();
                bl3 = object4 instanceof DependencyNode;
                if (!bl3) continue;
                object2 = object4;
                object2 = (DependencyNode)object4;
                n11 = 2;
                n12 = 0;
                dependencyNode = null;
                object3 = arrayList;
                this.applyGroup((DependencyNode)object2, n10, n11, null, arrayList, null);
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun object, String string2) {
        boolean bl2;
        int n10 = ((WidgetRun)object).orientation;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("cluster_");
        CharSequence charSequence2 = ((WidgetRun)object).widget.getDebugName();
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        if (n10 == 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append("_h");
            charSequence = ((StringBuilder)charSequence2).toString();
        } else {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append("_v");
            charSequence = ((StringBuilder)charSequence2).toString();
        }
        charSequence2 = new StringBuilder();
        Object object2 = "subgraph ";
        ((StringBuilder)charSequence2).append((String)object2);
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(" {\n");
        charSequence = ((StringBuilder)charSequence2).toString();
        object = ((ChainRun)object).widgets.iterator();
        charSequence2 = "";
        while (bl2 = object.hasNext()) {
            StringBuilder stringBuilder;
            object2 = (WidgetRun)object.next();
            String string3 = ((WidgetRun)object2).widget.getDebugName();
            if (n10 == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append("_HORIZONTAL");
                string3 = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append("_VERTICAL");
                string3 = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append(string3);
            stringBuilder.append(";\n");
            charSequence = stringBuilder.toString();
            charSequence2 = this.generateDisplayGraph((WidgetRun)object2, (String)charSequence2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append("}\n");
        object = ((StringBuilder)object).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append((String)charSequence2);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String string2) {
        int n10;
        block21: {
            String string3;
            String string4;
            Object object;
            Object object2;
            int n11;
            Object object3;
            Object object4;
            block18: {
                block20: {
                    int n12;
                    block19: {
                        Dependency dependency;
                        object4 = widgetRun.start;
                        object3 = widgetRun.end;
                        n11 = widgetRun instanceof HelperReferences;
                        if (n11 == 0 && (n11 = (object2 = object4.dependencies).isEmpty()) != 0) {
                            object2 = ((DependencyNode)object3).dependencies;
                            n11 = object2.isEmpty();
                            object = object4.targets;
                            n12 = object.isEmpty();
                            if ((n11 &= n12) != 0 && (n11 = (object2 = ((DependencyNode)object3).targets).isEmpty()) != 0) {
                                return string2;
                            }
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string2);
                        string2 = this.nodeDefinition(widgetRun);
                        ((StringBuilder)object2).append(string2);
                        string2 = ((StringBuilder)object2).toString();
                        n11 = this.isCenteredConnection((DependencyNode)object4, (DependencyNode)object3);
                        string2 = this.generateDisplayNode((DependencyNode)object4, n11 != 0, string2);
                        string2 = this.generateDisplayNode((DependencyNode)object3, n11 != 0, string2);
                        n12 = widgetRun instanceof VerticalWidgetRun;
                        if (n12 != 0) {
                            dependency = widgetRun;
                            dependency = ((VerticalWidgetRun)widgetRun).baseline;
                            string2 = this.generateDisplayNode((DependencyNode)dependency, n11 != 0, string2);
                        }
                        n11 = widgetRun instanceof HorizontalWidgetRun;
                        dependency = null;
                        string4 = " -> ";
                        string3 = "\n";
                        if (n11 != 0) break block18;
                        n11 = widgetRun instanceof ChainRun;
                        if (n11 == 0) break block19;
                        WidgetRun widgetRun2 = widgetRun;
                        widgetRun2 = (ChainRun)widgetRun;
                        int n13 = widgetRun2.orientation;
                        if (n13 == 0) break block18;
                    }
                    if (n12 != 0) break block20;
                    if (n11 == 0) break block21;
                    object2 = widgetRun;
                    object2 = (ChainRun)widgetRun;
                    n11 = ((WidgetRun)object2).orientation;
                    n12 = 1;
                    if (n11 != n12) break block21;
                }
                if ((object2 = widgetRun.widget.getVerticalDimensionBehaviour()) != (object = ConstraintWidget$DimensionBehaviour.FIXED) && object2 != (object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                    float f10;
                    float f11;
                    object4 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (object2 == object4 && (n10 = (int)((f11 = (f10 = ((ConstraintWidget)(object4 = widgetRun.widget)).getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) > 0) {
                        object4 = widgetRun.widget.getDebugName();
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string3);
                        ((StringBuilder)object3).append((String)object4);
                        object2 = "_VERTICAL -> ";
                        ((StringBuilder)object3).append((String)object2);
                        ((StringBuilder)object3).append((String)object4);
                        object4 = "_HORIZONTAL;\n";
                        ((StringBuilder)object3).append((String)object4);
                        ((StringBuilder)object3).toString();
                    }
                } else {
                    object2 = object4.targets;
                    n11 = object2.isEmpty() ? 1 : 0;
                    if (n11 == 0 && (n11 = (int)((object2 = ((DependencyNode)object3).targets).isEmpty() ? 1 : 0)) != 0) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string3);
                        object3 = ((DependencyNode)object3).name();
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append(string4);
                        object4 = object4.name();
                        ((StringBuilder)object2).append((String)object4);
                        ((StringBuilder)object2).append(string3);
                        object4 = ((StringBuilder)object2).toString();
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string2);
                        ((StringBuilder)object3).append((String)object4);
                        string2 = ((StringBuilder)object3).toString();
                    } else {
                        object2 = object4.targets;
                        n11 = object2.isEmpty() ? 1 : 0;
                        if (n11 != 0 && (n11 = (int)((object2 = ((DependencyNode)object3).targets).isEmpty() ? 1 : 0)) == 0) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append(string3);
                            object4 = object4.name();
                            ((StringBuilder)object2).append((String)object4);
                            ((StringBuilder)object2).append(string4);
                            object4 = ((DependencyNode)object3).name();
                            ((StringBuilder)object2).append((String)object4);
                            ((StringBuilder)object2).append(string3);
                            object4 = ((StringBuilder)object2).toString();
                            object3 = new StringBuilder();
                            ((StringBuilder)object3).append(string2);
                            ((StringBuilder)object3).append((String)object4);
                            string2 = ((StringBuilder)object3).toString();
                        }
                    }
                }
                break block21;
            }
            if ((object2 = widgetRun.widget.getHorizontalDimensionBehaviour()) != (object = ConstraintWidget$DimensionBehaviour.FIXED) && object2 != (object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                float f12;
                float f13;
                object4 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (object2 == object4 && (n10 = (f13 = (f12 = ((ConstraintWidget)(object4 = widgetRun.widget)).getDimensionRatio()) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0) {
                    object4 = widgetRun.widget.getDebugName();
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append((String)object4);
                    object2 = "_HORIZONTAL -> ";
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append((String)object4);
                    object4 = "_VERTICAL;\n";
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).toString();
                }
            } else {
                object2 = object4.targets;
                n11 = object2.isEmpty();
                if (n11 == 0 && (n11 = (int)((object2 = ((DependencyNode)object3).targets).isEmpty() ? 1 : 0)) != 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string3);
                    object3 = ((DependencyNode)object3).name();
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append(string4);
                    object4 = object4.name();
                    ((StringBuilder)object2).append((String)object4);
                    ((StringBuilder)object2).append(string3);
                    object4 = ((StringBuilder)object2).toString();
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append((String)object4);
                    string2 = ((StringBuilder)object3).toString();
                } else {
                    object2 = object4.targets;
                    n11 = object2.isEmpty() ? 1 : 0;
                    if (n11 != 0 && (n11 = (int)((object2 = ((DependencyNode)object3).targets).isEmpty() ? 1 : 0)) == 0) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string3);
                        object4 = object4.name();
                        ((StringBuilder)object2).append((String)object4);
                        ((StringBuilder)object2).append(string4);
                        object4 = ((DependencyNode)object3).name();
                        ((StringBuilder)object2).append((String)object4);
                        ((StringBuilder)object2).append(string3);
                        object4 = ((StringBuilder)object2).toString();
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append(string2);
                        ((StringBuilder)object3).append((String)object4);
                        string2 = ((StringBuilder)object3).toString();
                    }
                }
            }
        }
        if ((n10 = widgetRun instanceof ChainRun) != 0) {
            widgetRun = (ChainRun)widgetRun;
            return this.generateChainDisplayGraph((ChainRun)widgetRun, string2);
        }
        return string2;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean bl2, String string2) {
        int n10;
        Iterator iterator2 = dependencyNode.targets.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = (DependencyNode)iterator2.next();
            Object object2 = new StringBuilder();
            String string3 = "\n";
            ((StringBuilder)object2).append(string3);
            CharSequence charSequence = dependencyNode.name();
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object2);
            object2 = " -> ";
            ((StringBuilder)charSequence).append((String)object2);
            object = ((DependencyNode)object).name();
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            int n11 = dependencyNode.margin;
            if (n11 > 0 || bl2 || (n11 = (object2 = dependencyNode.run) instanceof HelperReferences) != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append("[");
                object = ((StringBuilder)object2).toString();
                n11 = dependencyNode.margin;
                if (n11 > 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append("label=\"");
                    n10 = dependencyNode.margin;
                    ((StringBuilder)object2).append(n10);
                    ((StringBuilder)object2).append("\"");
                    object = ((StringBuilder)object2).toString();
                    if (bl2) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append((String)object);
                        ((StringBuilder)object2).append(",");
                        object = ((StringBuilder)object2).toString();
                    }
                }
                if (bl2) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(" style=dashed ");
                    object = ((StringBuilder)object2).toString();
                }
                if ((n11 = (object2 = dependencyNode.run) instanceof HelperReferences) != 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(" style=bold,color=gray ");
                    object = ((StringBuilder)object2).toString();
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append("]");
                object = ((StringBuilder)object2).toString();
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string3);
            object = ((StringBuilder)object2).toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object);
            string2 = ((StringBuilder)object2).toString();
        }
        return string2;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode object) {
        DependencyNode dependencyNode2;
        boolean bl2;
        Iterator iterator2 = dependencyNode.targets.iterator();
        boolean bl3 = false;
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            dependencyNode2 = (DependencyNode)iterator2.next();
            if (dependencyNode2 == object) continue;
            ++n10;
        }
        object = ((DependencyNode)object).targets.iterator();
        int n11 = 0;
        iterator2 = null;
        while (bl2 = object.hasNext()) {
            dependencyNode2 = (DependencyNode)object.next();
            if (dependencyNode2 == dependencyNode) continue;
            ++n11;
        }
        if (n10 > 0 && n11 > 0) {
            bl3 = true;
        }
        return bl3;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int n10, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int n11) {
        BasicMeasure$Measure basicMeasure$Measure = this.mMeasure;
        basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour;
        basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour2;
        basicMeasure$Measure.horizontalDimension = n10;
        basicMeasure$Measure.verticalDimension = n11;
        this.mMeasurer.measure(constraintWidget, basicMeasure$Measure);
        int n12 = this.mMeasure.measuredWidth;
        constraintWidget.setWidth(n12);
        n12 = this.mMeasure.measuredHeight;
        constraintWidget.setHeight(n12);
        n12 = this.mMeasure.measuredHasBaseline ? 1 : 0;
        constraintWidget.setHasBaseline(n12 != 0);
        n12 = this.mMeasure.measuredBaseline;
        constraintWidget.setBaselineDistance(n12);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String nodeDefinition(WidgetRun var1_1) {
        block20: {
            block19: {
                var2_2 = var1_1 instanceof VerticalWidgetRun;
                var3_3 = var1_1.widget.getDebugName();
                var4_4 /* !! */  = var1_1.widget;
                var4_4 /* !! */  = var2_2 == false ? var4_4 /* !! */ .getHorizontalDimensionBehaviour() : var4_4 /* !! */ .getVerticalDimensionBehaviour();
                var5_5 = var1_1.runGroup;
                if (!var2_2) {
                    var6_6 /* !! */  = new StringBuilder();
                    var6_6 /* !! */ .append((String)var3_3);
                    var7_7 = "_HORIZONTAL";
                    var6_6 /* !! */ .append((String)var7_7);
                    var6_6 /* !! */  = var6_6 /* !! */ .toString();
                } else {
                    var6_6 /* !! */  = new StringBuilder();
                    var6_6 /* !! */ .append((String)var3_3);
                    var7_7 = "_VERTICAL";
                    var6_6 /* !! */ .append((String)var7_7);
                    var6_6 /* !! */  = var6_6 /* !! */ .toString();
                }
                var7_7 = new StringBuilder();
                var7_7.append((String)var6_6 /* !! */ );
                var7_7.append(" [shape=none, label=<");
                var6_6 /* !! */  = var7_7.toString();
                var7_7 = new StringBuilder();
                var7_7.append((String)var6_6 /* !! */ );
                var7_7.append("<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">");
                var6_6 /* !! */  = var7_7.toString();
                var7_7 = new StringBuilder();
                var7_7.append((String)var6_6 /* !! */ );
                var7_7.append("  <TR>");
                var6_6 /* !! */  = var7_7.toString();
                var7_7 = " BGCOLOR=\"green\"";
                var8_8 = "    <TD ";
                if (!var2_2) {
                    var9_9 = new StringBuilder();
                    var9_9.append((String)var6_6 /* !! */ );
                    var9_9.append(var8_8);
                    var6_6 /* !! */  = var9_9.toString();
                    var9_9 = var1_1.start;
                    var10_10 = var9_9.resolved;
                    if (var10_10) {
                        var9_9 = new StringBuilder();
                        var9_9.append((String)var6_6 /* !! */ );
                        var9_9.append((String)var7_7);
                        var6_6 /* !! */  = var9_9.toString();
                    }
                    var9_9 = new StringBuilder();
                    var9_9.append((String)var6_6 /* !! */ );
                    var9_9.append(" PORT=\"LEFT\" BORDER=\"1\">L</TD>");
                    var6_6 /* !! */  = var9_9.toString();
                } else {
                    var9_9 = new StringBuilder();
                    var9_9.append((String)var6_6 /* !! */ );
                    var9_9.append(var8_8);
                    var6_6 /* !! */  = var9_9.toString();
                    var9_9 = var1_1.start;
                    var10_10 = var9_9.resolved;
                    if (var10_10) {
                        var9_9 = new StringBuilder();
                        var9_9.append((String)var6_6 /* !! */ );
                        var9_9.append((String)var7_7);
                        var6_6 /* !! */  = var9_9.toString();
                    }
                    var9_9 = new StringBuilder();
                    var9_9.append((String)var6_6 /* !! */ );
                    var9_9.append(" PORT=\"TOP\" BORDER=\"1\">T</TD>");
                    var6_6 /* !! */  = var9_9.toString();
                }
                var9_9 = new StringBuilder();
                var9_9.append((String)var6_6 /* !! */ );
                var9_9.append("    <TD BORDER=\"1\" ");
                var6_6 /* !! */  = var9_9.toString();
                var9_9 = var1_1.dimension;
                var10_10 = var9_9.resolved;
                if (!var10_10) break block19;
                var11_11 = var1_1.widget;
                var12_12 = var11_11.measured;
                if (var12_12) break block19;
                var9_9 = new StringBuilder();
                var9_9.append((String)var6_6 /* !! */ );
                var9_9.append(" BGCOLOR=\"green\" ");
                var6_6 /* !! */  = var9_9.toString();
                break block20;
            }
            if (!var10_10) ** GOTO lbl-1000
            var11_11 = var1_1.widget;
            var12_12 = var11_11.measured;
            if (var12_12) {
                var9_9 = new StringBuilder();
                var9_9.append((String)var6_6 /* !! */ );
                var9_9.append(" BGCOLOR=\"lightgray\" ");
                var6_6 /* !! */  = var9_9.toString();
            } else if (!var10_10) {
                var9_9 = var1_1.widget;
                var10_10 = var9_9.measured;
                if (var10_10) {
                    var9_9 = new StringBuilder();
                    var9_9.append((String)var6_6 /* !! */ );
                    var9_9.append(" BGCOLOR=\"yellow\" ");
                    var6_6 /* !! */  = var9_9.toString();
                }
            }
        }
        var9_9 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (var4_4 /* !! */  == var9_9) {
            var4_4 /* !! */  = new StringBuilder();
            var4_4 /* !! */ .append((String)var6_6 /* !! */ );
            var4_4 /* !! */ .append("style=\"dashed\"");
            var6_6 /* !! */  = var4_4 /* !! */ .toString();
        }
        if (var5_5 != null) {
            var4_4 /* !! */  = new StringBuilder();
            var9_9 = " [";
            var4_4 /* !! */ .append((String)var9_9);
            var13_13 = var5_5.groupIndex + 1;
            var4_4 /* !! */ .append(var13_13);
            var4_4 /* !! */ .append("/");
            var13_13 = RunGroup.index;
            var4_4 /* !! */ .append(var13_13);
            var5_5 = "]";
            var4_4 /* !! */ .append((String)var5_5);
            var4_4 /* !! */  = var4_4 /* !! */ .toString();
        } else {
            var4_4 /* !! */  = "";
        }
        var5_5 = new StringBuilder();
        var5_5.append((String)var6_6 /* !! */ );
        var6_6 /* !! */  = ">";
        var5_5.append((String)var6_6 /* !! */ );
        var5_5.append((String)var3_3);
        var5_5.append((String)var4_4 /* !! */ );
        var5_5.append(" </TD>");
        var3_3 = var5_5.toString();
        if (!var2_2) {
            var14_14 = new StringBuilder();
            var14_14.append((String)var3_3);
            var14_14.append(var8_8);
            var14_14 = var14_14.toString();
            var1_1 = var1_1.end;
            var15_15 = var1_1.resolved;
            if (var15_15) {
                var1_1 = new StringBuilder();
                var1_1.append((String)var14_14);
                var1_1.append((String)var7_7);
                var14_14 = var1_1.toString();
            }
            var1_1 = new StringBuilder();
            var1_1.append((String)var14_14);
            var14_14 = " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
            var1_1.append((String)var14_14);
            var1_1 = var1_1.toString();
        } else {
            var4_4 /* !! */  = new StringBuilder();
            var4_4 /* !! */ .append((String)var3_3);
            var4_4 /* !! */ .append(var8_8);
            var3_3 = var4_4 /* !! */ .toString();
            if (var2_2) {
                var14_14 = var1_1;
                var14_14 = ((VerticalWidgetRun)var1_1).baseline;
                var2_2 = var14_14.resolved;
                if (var2_2) {
                    var14_14 = new StringBuilder();
                    var14_14.append((String)var3_3);
                    var14_14.append((String)var7_7);
                    var3_3 = var14_14.toString();
                }
            }
            var14_14 = new StringBuilder();
            var14_14.append((String)var3_3);
            var14_14.append(" PORT=\"BASELINE\" BORDER=\"1\">b</TD>");
            var14_14 = var14_14.toString();
            var3_3 = new StringBuilder();
            var3_3.append((String)var14_14);
            var3_3.append(var8_8);
            var14_14 = var3_3.toString();
            var1_1 = var1_1.end;
            var15_16 = var1_1.resolved;
            if (var15_16) {
                var1_1 = new StringBuilder();
                var1_1.append((String)var14_14);
                var1_1.append((String)var7_7);
                var14_14 = var1_1.toString();
            }
            var1_1 = new StringBuilder();
            var1_1.append((String)var14_14);
            var14_14 = " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
            var1_1.append((String)var14_14);
            var1_1 = var1_1.toString();
        }
        var14_14 = new StringBuilder();
        var14_14.append((String)var1_1);
        var14_14.append("  </TR></TABLE>");
        var1_1 = var14_14.toString();
        var14_14 = new StringBuilder();
        var14_14.append((String)var1_1);
        var14_14.append(">];\n");
        return var14_14.toString();
    }

    public void buildGraph() {
        ArrayList arrayList = this.mRuns;
        this.buildGraph(arrayList);
        this.mGroups.clear();
        RunGroup.index = 0;
        WidgetRun widgetRun = this.container.horizontalRun;
        ArrayList arrayList2 = this.mGroups;
        this.findGroup(widgetRun, 0, arrayList2);
        widgetRun = this.container.verticalRun;
        arrayList2 = this.mGroups;
        this.findGroup(widgetRun, 1, arrayList2);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList object) {
        boolean bl2;
        ConstraintWidget constraintWidget;
        boolean bl3;
        ((ArrayList)object).clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        Object object2 = this.mContainer.horizontalRun;
        ((ArrayList)object).add(object2);
        object2 = this.mContainer.verticalRun;
        ((ArrayList)object).add(object2);
        object2 = this.mContainer.mChildren.iterator();
        boolean bl4 = false;
        Object object3 = null;
        while (bl3 = object2.hasNext()) {
            int n10;
            WidgetRun widgetRun;
            constraintWidget = (ConstraintWidget)object2.next();
            boolean bl5 = constraintWidget instanceof Guideline;
            if (bl5) {
                widgetRun = new GuidelineReference(constraintWidget);
                ((ArrayList)object).add(widgetRun);
                continue;
            }
            bl5 = constraintWidget.isInHorizontalChain();
            if (bl5) {
                widgetRun = constraintWidget.horizontalChainRun;
                if (widgetRun == null) {
                    n10 = 0;
                    widgetRun = new ChainRun(constraintWidget, 0);
                    constraintWidget.horizontalChainRun = widgetRun;
                }
                if (object3 == null) {
                    object3 = new Object();
                }
                widgetRun = constraintWidget.horizontalChainRun;
                ((HashSet)object3).add(widgetRun);
            } else {
                widgetRun = constraintWidget.horizontalRun;
                ((ArrayList)object).add(widgetRun);
            }
            bl5 = constraintWidget.isInVerticalChain();
            if (bl5) {
                widgetRun = constraintWidget.verticalChainRun;
                if (widgetRun == null) {
                    n10 = 1;
                    widgetRun = new ChainRun(constraintWidget, n10);
                    constraintWidget.verticalChainRun = widgetRun;
                }
                if (object3 == null) {
                    object3 = new Object();
                }
                widgetRun = constraintWidget.verticalChainRun;
                ((HashSet)object3).add(widgetRun);
            } else {
                widgetRun = constraintWidget.verticalRun;
                ((ArrayList)object).add(widgetRun);
            }
            if (!(bl5 = constraintWidget instanceof HelperWidget)) continue;
            widgetRun = new HelperReferences(constraintWidget);
            ((ArrayList)object).add(widgetRun);
        }
        if (object3 != null) {
            ((ArrayList)object).addAll(object3);
        }
        object2 = ((ArrayList)object).iterator();
        while (bl4 = object2.hasNext()) {
            object3 = (WidgetRun)object2.next();
            ((WidgetRun)object3).clear();
        }
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (WidgetRun)object.next();
            object3 = ((WidgetRun)object2).widget;
            constraintWidget = this.mContainer;
            if (object3 == constraintWidget) continue;
            ((WidgetRun)object2).apply();
        }
    }

    public void defineTerminalWidgets(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2) {
        boolean bl2 = this.mNeedBuildGraph;
        if (bl2) {
            boolean[] blArray;
            Object object;
            boolean bl3;
            boolean bl4;
            this.buildGraph();
            Iterator iterator2 = this.container.mChildren.iterator();
            boolean bl5 = false;
            RunGroup runGroup = null;
            while (true) {
                bl4 = iterator2.hasNext();
                bl3 = true;
                if (!bl4) break;
                object = (ConstraintWidget)iterator2.next();
                blArray = object.isTerminalWidget;
                blArray[0] = bl3;
                blArray[bl3] = bl3;
                bl4 = object instanceof Barrier;
                if (!bl4) continue;
                bl5 = bl3;
            }
            if (!bl5) {
                iterator2 = this.mGroups.iterator();
                while (bl5 = iterator2.hasNext()) {
                    boolean bl6;
                    runGroup = (RunGroup)iterator2.next();
                    object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    if (constraintWidget$DimensionBehaviour == object) {
                        bl6 = bl3;
                    } else {
                        bl6 = false;
                        blArray = null;
                    }
                    if (constraintWidget$DimensionBehaviour2 == object) {
                        bl4 = bl3;
                    } else {
                        bl4 = false;
                        object = null;
                    }
                    runGroup.defineTerminalWidgets(bl6, bl4);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public boolean directMeasure(boolean bl2) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        int n10;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl3 = true;
        boolean bl4 = bl2 & bl3;
        boolean bl5 = this.mNeedBuildGraph;
        if (bl5 || (bl5 = this.mNeedRedoMeasures)) {
            boolean bl6;
            object4 = this.container.mChildren.iterator();
            while (bl6 = object4.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget)object4.next();
                constraintWidget.ensureWidgetRuns();
                constraintWidget.measured = false;
                object3 = constraintWidget.horizontalRun;
                ((HorizontalWidgetRun)object3).reset();
                VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                verticalWidgetRun.reset();
            }
            this.container.ensureWidgetRuns();
            object4 = this.container;
            ((ConstraintWidget)object4).measured = false;
            ((ConstraintWidget)object4).horizontalRun.reset();
            object4 = this.container.verticalRun;
            ((VerticalWidgetRun)object4).reset();
            this.mNeedRedoMeasures = false;
        }
        if (bl5 = this.basicMeasureWidgets((ConstraintWidgetContainer)(object4 = this.mContainer))) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        object4 = this.container.getDimensionBehaviour(0);
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = this.container.getDimensionBehaviour(bl3 ? 1 : 0);
        int n11 = this.mNeedBuildGraph;
        if (n11 != 0) {
            this.buildGraph();
        }
        object3 = this.container;
        n11 = ((ConstraintWidget)object3).getX();
        Object object5 = this.container;
        int n12 = ((ConstraintWidget)object5).getY();
        this.container.horizontalRun.start.resolve(n11);
        this.container.verticalRun.start.resolve(n12);
        this.measureWidgets();
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (object4 == constraintWidget$DimensionBehaviour3 || constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4;
            boolean bl7;
            int n13;
            if (bl4) {
                Iterator iterator2 = this.mRuns.iterator();
                while ((n13 = iterator2.hasNext()) != 0) {
                    object2 = (WidgetRun)iterator2.next();
                    n13 = ((WidgetRun)object2).supportsWrapComputation();
                    if (n13 != 0) continue;
                    bl7 = false;
                    object = null;
                    break;
                }
            }
            if (bl7 && object4 == (constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                ConstraintWidgetContainer constraintWidgetContainer = this.container;
                object2 = ConstraintWidget$DimensionBehaviour.FIXED;
                constraintWidgetContainer.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object2));
                ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                n13 = this.computeWrap(constraintWidgetContainer2, 0);
                constraintWidgetContainer2.setWidth(n13);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                object2 = constraintWidgetContainer3.horizontalRun.dimension;
                n10 = constraintWidgetContainer3.getWidth();
                ((DimensionDependency)object2).resolve(n10);
            }
            if (bl7 && constraintWidget$DimensionBehaviour2 == (object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                object = this.container;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.FIXED;
                ((ConstraintWidget)object).setVerticalDimensionBehaviour(constraintWidget$DimensionBehaviour5);
                object = this.container;
                n10 = this.computeWrap((ConstraintWidgetContainer)object, bl3 ? 1 : 0);
                ((ConstraintWidget)object).setHeight(n10);
                object = this.container;
                DimensionDependency dimensionDependency = object.verticalRun.dimension;
                int n14 = ((ConstraintWidget)object).getHeight();
                dimensionDependency.resolve(n14);
            }
        }
        object = this.container;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArray = ((ConstraintWidget)object).mListDimensionBehaviors;
        object2 = constraintWidget$DimensionBehaviourArray[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (object2 != constraintWidget$DimensionBehaviour6 && (constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArray[0]) != (object2 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT)) {
            boolean bl8 = false;
            object = null;
        } else {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7;
            int n15 = ((ConstraintWidget)object).getWidth() + n11;
            this.container.horizontalRun.end.resolve(n15);
            DimensionDependency dimensionDependency = this.container.horizontalRun.dimension;
            int n16 = n15 - n11;
            dimensionDependency.resolve(n16);
            this.measureWidgets();
            object = this.container;
            object3 = ((ConstraintWidget)object).mListDimensionBehaviors;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour8 = object3[bl3];
            if (constraintWidget$DimensionBehaviour8 == constraintWidget$DimensionBehaviour6 || (object3 = object3[bl3]) == (constraintWidget$DimensionBehaviour7 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT)) {
                int n17 = ((ConstraintWidget)object).getHeight() + n12;
                this.container.verticalRun.end.resolve(n17);
                object3 = this.container.verticalRun.dimension;
                int n18 = n17 - n12;
                ((DimensionDependency)object3).resolve(n18);
            }
            this.measureWidgets();
            boolean bl9 = bl3;
        }
        object3 = this.mRuns.iterator();
        while ((n12 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            object5 = (WidgetRun)object3.next();
            ConstraintWidget constraintWidget = ((WidgetRun)object5).widget;
            object2 = this.container;
            if (constraintWidget == object2 && (n10 = (int)(((WidgetRun)object5).resolved ? 1 : 0)) == 0) continue;
            ((WidgetRun)object5).applyToWidget();
        }
        object3 = this.mRuns.iterator();
        while ((n12 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            ConstraintWidget constraintWidget;
            void var1_11;
            object5 = (WidgetRun)object3.next();
            if (var1_11 == false && (constraintWidget = ((WidgetRun)object5).widget) == (object2 = this.container)) continue;
            DependencyNode dependencyNode = ((WidgetRun)object5).start;
            n10 = dependencyNode.resolved ? 1 : 0;
            if (n10 != 0) {
                DependencyNode dependencyNode2 = ((WidgetRun)object5).end;
                n10 = dependencyNode2.resolved ? 1 : 0;
                if (n10 != 0 || (n10 = object5 instanceof GuidelineReference) != 0) {
                    DimensionDependency dimensionDependency = ((WidgetRun)object5).dimension;
                    n10 = dimensionDependency.resolved ? 1 : 0;
                    if (n10 != 0 || (n10 = object5 instanceof ChainRun) != 0 || (n12 = object5 instanceof GuidelineReference) != 0) continue;
                }
            }
            bl3 = false;
            break;
        }
        this.container.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object4));
        this.container.setVerticalDimensionBehaviour(constraintWidget$DimensionBehaviour2);
        return bl3;
    }

    public boolean directMeasureSetup(boolean bl2) {
        Object object;
        bl2 = this.mNeedBuildGraph;
        if (bl2) {
            Object object2;
            boolean bl3;
            object = this.container.mChildren.iterator();
            while (bl3 = object.hasNext()) {
                object2 = (ConstraintWidget)object.next();
                ((ConstraintWidget)object2).ensureWidgetRuns();
                ((ConstraintWidget)object2).measured = false;
                Dependency dependency = ((ConstraintWidget)object2).horizontalRun;
                DimensionDependency dimensionDependency = dependency.dimension;
                dimensionDependency.resolved = false;
                dependency.resolved = false;
                dependency.reset();
                object2 = ((ConstraintWidget)object2).verticalRun;
                dependency = ((WidgetRun)object2).dimension;
                ((DependencyNode)dependency).resolved = false;
                ((WidgetRun)object2).resolved = false;
                ((VerticalWidgetRun)object2).reset();
            }
            this.container.ensureWidgetRuns();
            object = this.container;
            ((ConstraintWidget)object).measured = false;
            object = ((ConstraintWidget)object).horizontalRun;
            object.dimension.resolved = false;
            ((WidgetRun)object).resolved = false;
            ((HorizontalWidgetRun)object).reset();
            object = this.container.verticalRun;
            object2 = ((WidgetRun)object).dimension;
            ((DependencyNode)object2).resolved = false;
            ((WidgetRun)object).resolved = false;
            ((VerticalWidgetRun)object).reset();
            this.buildGraph();
        }
        if (bl2 = this.basicMeasureWidgets((ConstraintWidgetContainer)(object = this.mContainer))) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean directMeasureWithOrientation(boolean var1_1, int var2_2) {
        block12: {
            var3_3 = true;
            var4_4 = this.container.getDimensionBehaviour(0);
            var5_5 = this.container.getDimensionBehaviour((int)var3_3);
            var6_6 = this.container;
            var7_7 = var6_6.getX();
            var8_8 = this.container;
            var9_9 = var8_8.getY();
            if ((var1_1 &= var3_3) && (var4_4 == (var10_10 /* !! */  = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) || var5_5 == var10_10 /* !! */ )) {
                var10_10 /* !! */  = this.mRuns.iterator();
                while (var11_11 = var10_10 /* !! */ .hasNext()) {
                    var12_12 /* !! */  = (WidgetRun)var10_10 /* !! */ .next();
                    var13_13 = var12_12 /* !! */ .orientation;
                    if (var13_13 != var2_2 || (var11_11 = var12_12 /* !! */ .supportsWrapComputation())) continue;
                    var1_1 = false;
                    var14_14 = null;
                    break;
                }
                if (var2_2 == 0) {
                    if (var1_1 && var4_4 == (var14_14 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                        var14_14 = this.container;
                        var10_10 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                        var14_14.setHorizontalDimensionBehaviour(var10_10 /* !! */ );
                        var14_14 = this.container;
                        var15_15 = this.computeWrap((ConstraintWidgetContainer)var14_14, 0);
                        var14_14.setWidth(var15_15);
                        var14_14 = this.container;
                        var10_10 /* !! */  = var14_14.horizontalRun.dimension;
                        var1_1 = var14_14.getWidth();
                        var10_10 /* !! */ .resolve((int)var1_1);
                    }
                } else if (var1_1 && var5_5 == (var14_14 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                    var14_14 = this.container;
                    var10_10 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                    var14_14.setVerticalDimensionBehaviour(var10_10 /* !! */ );
                    var14_14 = this.container;
                    var15_15 = this.computeWrap((ConstraintWidgetContainer)var14_14, (int)var3_3);
                    var14_14.setHeight(var15_15);
                    var14_14 = this.container;
                    var10_10 /* !! */  = var14_14.verticalRun.dimension;
                    var1_1 = var14_14.getHeight();
                    var10_10 /* !! */ .resolve((int)var1_1);
                }
            }
            if (var2_2 != 0) break block12;
            var14_14 = this.container;
            var8_8 = var14_14.mListDimensionBehaviors;
            var10_10 /* !! */  = var8_8[0];
            var12_12 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
            if (var10_10 /* !! */  != var12_12 /* !! */  && (var8_8 = var8_8[0]) != (var10_10 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_PARENT)) ** GOTO lbl-1000
            var1_1 = var14_14.getWidth() + var7_7;
            this.container.horizontalRun.end.resolve((int)var1_1);
            var8_8 = this.container.horizontalRun.dimension;
            var8_8.resolve((int)(var1_1 -= var7_7));
            ** GOTO lbl65
        }
        var14_14 = this.container;
        var6_6 = var14_14.mListDimensionBehaviors;
        var10_10 /* !! */  = var6_6[var3_3];
        var12_12 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
        if (var10_10 /* !! */  != var12_12 /* !! */  && (var6_6 = var6_6[var3_3]) != (var10_10 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_PARENT)) lbl-1000:
        // 2 sources

        {
            var1_1 = false;
            var14_14 = null;
        } else {
            var1_1 = var14_14.getHeight() + var9_9;
            this.container.verticalRun.end.resolve((int)var1_1);
            var6_6 = this.container.verticalRun.dimension;
            var6_6.resolve((int)(var1_1 -= var9_9));
lbl65:
            // 2 sources

            var1_1 = var3_3;
        }
        this.measureWidgets();
        var6_6 = this.mRuns.iterator();
        while ((var9_9 = (int)var6_6.hasNext()) != 0) {
            var8_8 = (WidgetRun)var6_6.next();
            var15_15 = var8_8.orientation;
            if (var15_15 != var2_2 || (var10_10 /* !! */  = var8_8.widget) == (var12_12 /* !! */  = this.container) && (var15_15 = (int)var8_8.resolved) == 0) continue;
            var8_8.applyToWidget();
        }
        var6_6 = this.mRuns.iterator();
        block2: while ((var9_9 = (int)var6_6.hasNext()) != 0) {
            var8_8 = (WidgetRun)var6_6.next();
            var15_15 = var8_8.orientation;
            if (var15_15 != var2_2 || !var1_1 && (var10_10 /* !! */  = var8_8.widget) == (var12_12 /* !! */  = this.container)) continue;
            var10_10 /* !! */  = var8_8.start;
            var15_15 = (int)var10_10 /* !! */ .resolved;
            if (var15_15 == 0) lbl-1000:
            // 3 sources

            {
                while (true) {
                    var3_3 = false;
                    break block2;
                    break;
                }
            }
            var10_10 /* !! */  = var8_8.end;
            var15_15 = (int)var10_10 /* !! */ .resolved;
            if (var15_15 == 0) ** GOTO lbl-1000
            var15_15 = var8_8 instanceof ChainRun;
            if (var15_15 != 0) continue;
            var8_8 = var8_8.dimension;
            var9_9 = (int)var8_8.resolved;
            if (var9_9 != 0) continue;
            ** continue;
        }
        this.container.setHorizontalDimensionBehaviour(var4_4);
        this.container.setVerticalDimensionBehaviour(var5_5);
        return var3_3;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        int n10;
        Iterator iterator2 = this.container.mChildren.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            int n11;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            ConstraintWidget constraintWidget = (ConstraintWidget)iterator2.next();
            int n12 = constraintWidget.measured;
            if (n12 != 0) continue;
            Object object = constraintWidget.mListDimensionBehaviors;
            int n13 = 0;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = object[0];
            int n14 = 1;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = object[n14];
            n12 = constraintWidget.mMatchConstraintDefaultWidth;
            int n15 = constraintWidget.mMatchConstraintDefaultHeight;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (constraintWidget$DimensionBehaviour2 != constraintWidget$DimensionBehaviour4 && (constraintWidget$DimensionBehaviour2 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) || n12 != n14)) {
                n12 = 0;
                object = null;
            } else {
                n12 = n14;
            }
            if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour3 == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && n15 == n14) {
                n13 = n14;
            }
            Object object2 = constraintWidget.horizontalRun.dimension;
            int n16 = object2.resolved;
            DimensionDependency dimensionDependency = constraintWidget.verticalRun.dimension;
            boolean bl2 = dimensionDependency.resolved;
            if (n16 != 0 && bl2) {
                constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.FIXED;
                n16 = object2.value;
                n11 = dimensionDependency.value;
                object = this;
                object2 = constraintWidget$DimensionBehaviour4;
                this.measure(constraintWidget, constraintWidget$DimensionBehaviour4, n16, constraintWidget$DimensionBehaviour4, n11);
                constraintWidget.measured = n14;
            } else if (n16 != 0 && n13 != 0) {
                constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
                int n17 = object2.value;
                n11 = dimensionDependency.value;
                object = this;
                object2 = constraintWidget$DimensionBehaviour;
                n16 = n17;
                this.measure(constraintWidget, constraintWidget$DimensionBehaviour, n17, constraintWidget$DimensionBehaviour4, n11);
                object = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (constraintWidget$DimensionBehaviour3 == object) {
                    object = constraintWidget.verticalRun.dimension;
                    ((DimensionDependency)object).wrapValue = n13 = constraintWidget.getHeight();
                } else {
                    object = constraintWidget.verticalRun.dimension;
                    n13 = constraintWidget.getHeight();
                    ((DimensionDependency)object).resolve(n13);
                    constraintWidget.measured = n14;
                }
            } else if (bl2 && n12 != 0) {
                n16 = object2.value;
                constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.FIXED;
                n11 = dimensionDependency.value;
                object = this;
                object2 = constraintWidget$DimensionBehaviour4;
                constraintWidget$DimensionBehaviour4 = constraintWidget$DimensionBehaviour3;
                this.measure(constraintWidget, (ConstraintWidget$DimensionBehaviour)((Object)object2), n16, constraintWidget$DimensionBehaviour3, n11);
                object = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (constraintWidget$DimensionBehaviour2 == object) {
                    object = constraintWidget.horizontalRun.dimension;
                    ((DimensionDependency)object).wrapValue = n13 = constraintWidget.getWidth();
                } else {
                    object = constraintWidget.horizontalRun.dimension;
                    n13 = constraintWidget.getWidth();
                    ((DimensionDependency)object).resolve(n13);
                    constraintWidget.measured = n14;
                }
            }
            if ((n12 = (int)(constraintWidget.measured ? 1 : 0)) == 0 || (object = constraintWidget.verticalRun.baselineDimension) == null) continue;
            n10 = constraintWidget.getBaselineDistance();
            ((DimensionDependency)object).resolve(n10);
        }
    }

    public void setMeasurer(BasicMeasure$Measurer basicMeasure$Measurer) {
        this.mMeasurer = basicMeasure$Measurer;
    }
}

