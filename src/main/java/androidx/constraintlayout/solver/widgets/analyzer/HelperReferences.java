/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.Iterator;

public class HelperReferences
extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void addDependency(DependencyNode object) {
        this.start.dependencies.add(object);
        object = ((DependencyNode)object).targets;
        DependencyNode dependencyNode = this.start;
        object.add(dependencyNode);
    }

    public void apply() {
        Object object = this.widget;
        int n10 = object instanceof Barrier;
        if (n10 != 0) {
            int n11;
            int n12;
            Object object2 = this.start;
            ((DependencyNode)object2).delegateToWidgetRun = n12 = 1;
            object = (Barrier)object;
            n10 = ((Barrier)object).getBarrierType();
            boolean bl2 = ((Barrier)object).allowsGoneWidget();
            int n13 = 8;
            if (n10 != 0) {
                if (n10 != n12) {
                    n12 = 2;
                    if (n10 != n12) {
                        n12 = 3;
                        if (n10 == n12) {
                            object2 = this.start;
                            Object object3 = DependencyNode$Type.BOTTOM;
                            ((DependencyNode)object2).type = object3;
                            for (n11 = 0; n11 < (n10 = ((HelperWidget)object).mWidgetsCount); ++n11) {
                                object2 = ((HelperWidget)object).mWidgets[n11];
                                if (!bl2 && (n12 = ((ConstraintWidget)object2).getVisibility()) == n13) continue;
                                object2 = object2.verticalRun.end;
                                object3 = ((DependencyNode)object2).dependencies;
                                DependencyNode dependencyNode = this.start;
                                object3.add(dependencyNode);
                                object3 = this.start.targets;
                                object3.add(object2);
                            }
                            object = this.widget.verticalRun.start;
                            this.addDependency((DependencyNode)object);
                            object = this.widget.verticalRun.end;
                            this.addDependency((DependencyNode)object);
                        }
                    } else {
                        object2 = this.start;
                        Object object4 = DependencyNode$Type.TOP;
                        ((DependencyNode)object2).type = object4;
                        while (n11 < (n10 = ((HelperWidget)object).mWidgetsCount)) {
                            object2 = ((HelperWidget)object).mWidgets[n11];
                            if (bl2 || (n12 = ((ConstraintWidget)object2).getVisibility()) != n13) {
                                object2 = object2.verticalRun.start;
                                object4 = ((DependencyNode)object2).dependencies;
                                DependencyNode dependencyNode = this.start;
                                object4.add(dependencyNode);
                                object4 = this.start.targets;
                                object4.add(object2);
                            }
                            ++n11;
                        }
                        object = this.widget.verticalRun.start;
                        this.addDependency((DependencyNode)object);
                        object = this.widget.verticalRun.end;
                        this.addDependency((DependencyNode)object);
                    }
                } else {
                    object2 = this.start;
                    Object object5 = DependencyNode$Type.RIGHT;
                    ((DependencyNode)object2).type = object5;
                    while (n11 < (n10 = ((HelperWidget)object).mWidgetsCount)) {
                        object2 = ((HelperWidget)object).mWidgets[n11];
                        if (bl2 || (n12 = ((ConstraintWidget)object2).getVisibility()) != n13) {
                            object2 = object2.horizontalRun.end;
                            object5 = ((DependencyNode)object2).dependencies;
                            DependencyNode dependencyNode = this.start;
                            object5.add(dependencyNode);
                            object5 = this.start.targets;
                            object5.add(object2);
                        }
                        ++n11;
                    }
                    object = this.widget.horizontalRun.start;
                    this.addDependency((DependencyNode)object);
                    object = this.widget.horizontalRun.end;
                    this.addDependency((DependencyNode)object);
                }
            } else {
                object2 = this.start;
                Object object6 = DependencyNode$Type.LEFT;
                ((DependencyNode)object2).type = object6;
                while (n11 < (n10 = ((HelperWidget)object).mWidgetsCount)) {
                    object2 = ((HelperWidget)object).mWidgets[n11];
                    if (bl2 || (n12 = ((ConstraintWidget)object2).getVisibility()) != n13) {
                        object2 = object2.horizontalRun.start;
                        object6 = ((DependencyNode)object2).dependencies;
                        DependencyNode dependencyNode = this.start;
                        object6.add(dependencyNode);
                        object6 = this.start.targets;
                        object6.add(object2);
                    }
                    ++n11;
                }
                object = this.widget.horizontalRun.start;
                this.addDependency((DependencyNode)object);
                object = this.widget.horizontalRun.end;
                this.addDependency((DependencyNode)object);
            }
        }
    }

    public void applyToWidget() {
        ConstraintWidget constraintWidget = this.widget;
        int n10 = constraintWidget instanceof Barrier;
        if (n10 != 0) {
            int n11 = ((Barrier)(constraintWidget = (Barrier)constraintWidget)).getBarrierType();
            if (n11 != 0 && n11 != (n10 = 1)) {
                constraintWidget = this.widget;
                DependencyNode dependencyNode = this.start;
                n10 = dependencyNode.value;
                constraintWidget.setY(n10);
            } else {
                constraintWidget = this.widget;
                DependencyNode dependencyNode = this.start;
                n10 = dependencyNode.value;
                constraintWidget.setX(n10);
            }
        }
    }

    public void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    public void reset() {
        this.start.resolved = false;
    }

    public boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency object) {
        int n10;
        int n11;
        object = (Barrier)this.widget;
        int n12 = ((Barrier)object).getBarrierType();
        Iterator iterator2 = this.start.targets.iterator();
        int n13 = -1;
        int n14 = 0;
        int n15 = n13;
        while ((n11 = iterator2.hasNext()) != 0) {
            DependencyNode dependencyNode = (DependencyNode)iterator2.next();
            n11 = dependencyNode.value;
            if (n15 == n13 || n11 < n15) {
                n15 = n11;
            }
            if (n14 >= n11) continue;
            n14 = n11;
        }
        if (n12 != 0 && n12 != (n10 = 2)) {
            DependencyNode dependencyNode = this.start;
            int n16 = ((Barrier)object).getMargin();
            dependencyNode.resolve(n14 += n16);
        } else {
            DependencyNode dependencyNode = this.start;
            int n17 = ((Barrier)object).getMargin();
            dependencyNode.resolve(n15 += n17);
        }
    }
}

