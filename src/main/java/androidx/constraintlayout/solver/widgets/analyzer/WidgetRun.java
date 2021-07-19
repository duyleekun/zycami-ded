/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.RunGroup;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType;
import java.util.List;

public abstract class WidgetRun
implements Dependency {
    public DimensionDependency dimension;
    public ConstraintWidget$DimensionBehaviour dimensionBehavior;
    public DependencyNode end;
    public WidgetRun$RunType mRunType;
    public int matchConstraintsType;
    public int orientation;
    public boolean resolved;
    public RunGroup runGroup;
    public DependencyNode start;
    public ConstraintWidget widget;

    public WidgetRun(ConstraintWidget constraintWidget) {
        Object object;
        this.dimension = object = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        super(this);
        this.start = object;
        super(this);
        this.end = object;
        object = WidgetRun$RunType.NONE;
        this.mRunType = object;
        this.widget = constraintWidget;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void resolveDimension(int n10, int n11) {
        int n12 = this.matchConstraintsType;
        if (n12 != 0) {
            int n13 = 1;
            if (n12 != n13) {
                n11 = 2;
                float f10 = 2.8E-45f;
                float f11 = 0.5f;
                if (n12 != n11) {
                    void var8_13;
                    int n14;
                    n11 = 3;
                    f10 = 4.2E-45f;
                    if (n12 != n11) return;
                    ConstraintWidget constraintWidget = this.widget;
                    HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = horizontalWidgetRun.dimensionBehavior;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && (n14 = horizontalWidgetRun.matchConstraintsType) == n11) {
                        VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = verticalWidgetRun.dimensionBehavior;
                        if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour2 && (n14 = verticalWidgetRun.matchConstraintsType) == n11) return;
                    }
                    if (n10 == 0) {
                        VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                    }
                    DimensionDependency dimensionDependency = var8_13.dimension;
                    n11 = (int)(dimensionDependency.resolved ? 1 : 0);
                    if (n11 == 0) return;
                    f10 = constraintWidget.getDimensionRatio();
                    if (n10 == n13) {
                        DimensionDependency dimensionDependency2 = var8_13.dimension;
                        float f12 = (float)dimensionDependency2.value / f10 + f11;
                        n10 = (int)f12;
                    } else {
                        DimensionDependency dimensionDependency3 = var8_13.dimension;
                        float f13 = dimensionDependency3.value;
                        f10 = f10 * f13 + f11;
                        n10 = (int)f10;
                    }
                    dimensionDependency = this.dimension;
                    dimensionDependency.resolve(n10);
                    return;
                } else {
                    Object object = this.widget.getParent();
                    if (object == null) return;
                    object = n10 == 0 ? ((ConstraintWidget)object).horizontalRun : ((ConstraintWidget)object).verticalRun;
                    object = ((WidgetRun)object).dimension;
                    n12 = (int)(((DependencyNode)object).resolved ? 1 : 0);
                    if (n12 == 0) return;
                    Object object2 = this.widget;
                    float f14 = n10 == 0 ? ((ConstraintWidget)object2).mMatchConstraintPercentWidth : ((ConstraintWidget)object2).mMatchConstraintPercentHeight;
                    f10 = (float)((DependencyNode)object).value * f14 + f11;
                    n11 = (int)f10;
                    object2 = this.dimension;
                    n10 = this.getLimitedDimension(n11, n10);
                    ((DimensionDependency)object2).resolve(n10);
                }
                return;
            } else {
                n12 = this.dimension.wrapValue;
                n10 = this.getLimitedDimension(n12, n10);
                DimensionDependency dimensionDependency = this.dimension;
                n10 = Math.min(n10, n11);
                dimensionDependency.resolve(n10);
            }
            return;
        } else {
            DimensionDependency dimensionDependency = this.dimension;
            n10 = this.getLimitedDimension(n11, n10);
            dimensionDependency.resolve(n10);
        }
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int n10) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = n10;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int n10, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        List list = dependencyNode.targets;
        DimensionDependency dimensionDependency2 = this.dimension;
        list.add(dimensionDependency2);
        dependencyNode.marginFactor = n10;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int n10, int n11) {
        block6: {
            block7: {
                block5: {
                    if (n11 != 0) break block5;
                    ConstraintWidget constraintWidget = this.widget;
                    int n12 = constraintWidget.mMatchConstraintMaxWidth;
                    n11 = Math.max(constraintWidget.mMatchConstraintMinWidth, n10);
                    if (n12 > 0) {
                        n11 = Math.min(n12, n10);
                    }
                    if (n11 == n10) break block6;
                    break block7;
                }
                ConstraintWidget constraintWidget = this.widget;
                int n13 = constraintWidget.mMatchConstraintMaxHeight;
                n11 = Math.max(constraintWidget.mMatchConstraintMinHeight, n10);
                if (n13 > 0) {
                    n11 = Math.min(n13, n10);
                }
                if (n11 == n10) break block6;
            }
            n10 = n11;
        }
        return n10;
    }

    public final DependencyNode getTarget(ConstraintAnchor object) {
        object = ((ConstraintAnchor)object).mTarget;
        DependencyNode dependencyNode = null;
        if (object == null) {
            return null;
        }
        ConstraintWidget constraintWidget = ((ConstraintAnchor)object).mOwner;
        object = ((ConstraintAnchor)object).mType;
        int[] nArray = WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 == n11) {
                            object = constraintWidget.verticalRun;
                            dependencyNode = ((WidgetRun)object).end;
                        }
                    } else {
                        object = constraintWidget.verticalRun;
                        dependencyNode = ((VerticalWidgetRun)object).baseline;
                    }
                } else {
                    object = constraintWidget.verticalRun;
                    dependencyNode = ((WidgetRun)object).start;
                }
            } else {
                object = constraintWidget.horizontalRun;
                dependencyNode = ((WidgetRun)object).end;
            }
        } else {
            object = constraintWidget.horizontalRun;
            dependencyNode = ((WidgetRun)object).start;
        }
        return dependencyNode;
    }

    public final DependencyNode getTarget(ConstraintAnchor object, int n10) {
        DependencyNode dependencyNode;
        block5: {
            WidgetRun widgetRun;
            block3: {
                block4: {
                    object = ((ConstraintAnchor)object).mTarget;
                    dependencyNode = null;
                    if (object == null) {
                        return null;
                    }
                    Object object2 = ((ConstraintAnchor)object).mOwner;
                    widgetRun = n10 == 0 ? ((ConstraintWidget)object2).horizontalRun : ((ConstraintWidget)object2).verticalRun;
                    object = ((ConstraintAnchor)object).mType;
                    object2 = WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
                    Object object3 = ((Enum)object).ordinal();
                    Object object4 = 1;
                    if ((object3 = (Object)object2[object3]) == object4) break block3;
                    object4 = 2;
                    if (object3 == object4) break block4;
                    object4 = 3;
                    if (object3 == object4) break block3;
                    object4 = 5;
                    if (object3 != object4) break block5;
                }
                dependencyNode = widgetRun.end;
                break block5;
            }
            dependencyNode = widgetRun.start;
        }
        return dependencyNode;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.dimension;
        boolean bl2 = dimensionDependency.resolved;
        if (bl2) {
            return dimensionDependency.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        WidgetRun widgetRun;
        int n10;
        List list = this.start.targets;
        int n11 = list.size();
        boolean bl2 = false;
        int n12 = 0;
        for (n10 = 0; n10 < n11; ++n10) {
            widgetRun = ((DependencyNode)this.start.targets.get((int)n10)).run;
            if (widgetRun == this) continue;
            ++n12;
        }
        list = this.end.targets;
        n11 = list.size();
        for (n10 = 0; n10 < n11; ++n10) {
            widgetRun = ((DependencyNode)this.end.targets.get((int)n10)).run;
            if (widgetRun == this) continue;
            ++n12;
        }
        n11 = 2;
        if (n12 >= n11) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    public void update(Dependency dependency) {
    }

    public void updateRunCenter(Dependency dependency, ConstraintAnchor object, ConstraintAnchor object2, int n10) {
        dependency = this.getTarget((ConstraintAnchor)object);
        DependencyNode dependencyNode = this.getTarget((ConstraintAnchor)object2);
        int n11 = ((DependencyNode)dependency).resolved;
        if (n11 != 0 && (n11 = dependencyNode.resolved) != 0) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            n11 = ((DependencyNode)dependency).value;
            int n12 = ((ConstraintAnchor)object).getMargin();
            n11 += n12;
            n12 = dependencyNode.value;
            int n13 = ((ConstraintAnchor)object2).getMargin();
            n12 -= n13;
            n13 = n12 - n11;
            Object object3 = this.dimension;
            int n14 = object3.resolved;
            if (n14 == 0 && (object3 = this.dimensionBehavior) == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                this.resolveDimension(n10, n13);
            }
            object3 = this.dimension;
            boolean bl2 = object3.resolved;
            if (!bl2) {
                return;
            }
            n14 = object3.value;
            if (n14 == n13) {
                this.start.resolve(n11);
                this.end.resolve(n12);
                return;
            }
            object2 = this.widget;
            float f10 = n10 == 0 ? ((ConstraintWidget)object2).getHorizontalBiasPercent() : ((ConstraintWidget)object2).getVerticalBiasPercent();
            n10 = 0x3F000000;
            float f11 = 0.5f;
            if (dependency == dependencyNode) {
                n11 = ((DependencyNode)dependency).value;
                n12 = dependencyNode.value;
                n13 = n10;
                f10 = f11;
            }
            n12 -= n11;
            int n15 = this.dimension.value;
            dependency = this.start;
            float f12 = (float)n11 + f11;
            float f13 = (float)(n12 -= n15) * f10;
            n12 = (int)(f12 += f13);
            ((DependencyNode)dependency).resolve(n12);
            dependency = this.end;
            object = this.start;
            n12 = ((DependencyNode)object).value;
            object2 = this.dimension;
            n13 = ((DependencyNode)object2).value;
            ((DependencyNode)dependency).resolve(n12 += n13);
        }
    }

    public void updateRunEnd(Dependency dependency) {
    }

    public void updateRunStart(Dependency dependency) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public long wrapSize(int n10) {
        DimensionDependency dimensionDependency = this.dimension;
        boolean bl2 = dimensionDependency.resolved;
        if (!bl2) return 0L;
        int n11 = dimensionDependency.value;
        long l10 = n11;
        int n12 = this.isCenterConnection();
        if (n12 != 0) {
            DependencyNode dependencyNode = this.start;
            n10 = dependencyNode.margin;
            DependencyNode dependencyNode2 = this.end;
            n12 = dependencyNode2.margin;
            n10 -= n12;
        } else {
            if (n10 != 0) {
                DependencyNode dependencyNode = this.end;
                n10 = dependencyNode.margin;
                long l11 = n10;
                l10 -= l11;
                return l10;
            }
            DependencyNode dependencyNode = this.start;
            n10 = dependencyNode.margin;
        }
        long l12 = n10;
        return l10 += l12;
    }
}

