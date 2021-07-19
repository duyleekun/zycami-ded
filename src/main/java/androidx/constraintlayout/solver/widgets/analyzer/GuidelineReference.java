/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public class GuidelineReference
extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        int n10;
        constraintWidget.horizontalRun.clear();
        constraintWidget.verticalRun.clear();
        this.orientation = n10 = ((Guideline)constraintWidget).getOrientation();
    }

    private void addDependency(DependencyNode object) {
        this.start.dependencies.add(object);
        object = ((DependencyNode)object).targets;
        DependencyNode dependencyNode = this.start;
        object.add(dependencyNode);
    }

    public void apply() {
        Object object = (Guideline)this.widget;
        int n10 = ((Guideline)object).getRelativeBegin();
        int n11 = ((Guideline)object).getRelativeEnd();
        ((Guideline)object).getRelativePercent();
        int n12 = ((Guideline)object).getOrientation();
        int n13 = 1;
        int n14 = -1;
        if (n12 == n13) {
            if (n10 != n14) {
                object = this.start.targets;
                DependencyNode dependencyNode = this.widget.mParent.horizontalRun.start;
                object.add(dependencyNode);
                object = this.widget.mParent.horizontalRun.start.dependencies;
                dependencyNode = this.start;
                object.add(dependencyNode);
                object = this.start;
                ((DependencyNode)object).margin = n10;
            } else if (n11 != n14) {
                object = this.start.targets;
                DependencyNode dependencyNode = this.widget.mParent.horizontalRun.end;
                object.add(dependencyNode);
                object = this.widget.mParent.horizontalRun.end.dependencies;
                dependencyNode = this.start;
                object.add(dependencyNode);
                object = this.start;
                ((DependencyNode)object).margin = n10 = -n11;
            } else {
                object = this.start;
                ((DependencyNode)object).delegateToWidgetRun = n13;
                object = ((DependencyNode)object).targets;
                DependencyNode dependencyNode = this.widget.mParent.horizontalRun.end;
                object.add(dependencyNode);
                object = this.widget.mParent.horizontalRun.end.dependencies;
                dependencyNode = this.start;
                object.add(dependencyNode);
            }
            object = this.widget.horizontalRun.start;
            this.addDependency((DependencyNode)object);
            object = this.widget.horizontalRun.end;
            this.addDependency((DependencyNode)object);
        } else {
            if (n10 != n14) {
                object = this.start.targets;
                DependencyNode dependencyNode = this.widget.mParent.verticalRun.start;
                object.add(dependencyNode);
                object = this.widget.mParent.verticalRun.start.dependencies;
                dependencyNode = this.start;
                object.add(dependencyNode);
                object = this.start;
                ((DependencyNode)object).margin = n10;
            } else if (n11 != n14) {
                object = this.start.targets;
                DependencyNode dependencyNode = this.widget.mParent.verticalRun.end;
                object.add(dependencyNode);
                object = this.widget.mParent.verticalRun.end.dependencies;
                dependencyNode = this.start;
                object.add(dependencyNode);
                object = this.start;
                ((DependencyNode)object).margin = n10 = -n11;
            } else {
                object = this.start;
                ((DependencyNode)object).delegateToWidgetRun = n13;
                object = ((DependencyNode)object).targets;
                DependencyNode dependencyNode = this.widget.mParent.verticalRun.end;
                object.add(dependencyNode);
                object = this.widget.mParent.verticalRun.end.dependencies;
                dependencyNode = this.start;
                object.add(dependencyNode);
            }
            object = this.widget.verticalRun.start;
            this.addDependency((DependencyNode)object);
            object = this.widget.verticalRun.end;
            this.addDependency((DependencyNode)object);
        }
    }

    public void applyToWidget() {
        int n10;
        ConstraintWidget constraintWidget = (Guideline)this.widget;
        int n11 = ((Guideline)constraintWidget).getOrientation();
        if (n11 == (n10 = 1)) {
            constraintWidget = this.widget;
            DependencyNode dependencyNode = this.start;
            n10 = dependencyNode.value;
            constraintWidget.setX(n10);
        } else {
            constraintWidget = this.widget;
            DependencyNode dependencyNode = this.start;
            n10 = dependencyNode.value;
            constraintWidget.setY(n10);
        }
    }

    public void clear() {
        this.start.clear();
    }

    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    public boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency dependency) {
        dependency = this.start;
        boolean bl2 = ((DependencyNode)dependency).readyToSolve;
        if (!bl2) {
            return;
        }
        bl2 = ((DependencyNode)dependency).resolved;
        if (bl2) {
            return;
        }
        dependency = (DependencyNode)((DependencyNode)dependency).targets.get(0);
        Guideline guideline = (Guideline)this.widget;
        float f10 = ((DependencyNode)dependency).value;
        float f11 = guideline.getRelativePercent();
        int n10 = (int)(f10 * f11 + 0.5f);
        this.start.resolve(n10);
    }
}

