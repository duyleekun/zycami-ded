/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HelperReferences;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START;
    public static int index;
    public int direction;
    public boolean dual = false;
    public WidgetRun firstRun = null;
    public int groupIndex;
    public WidgetRun lastRun = null;
    public int position = 0;
    public ArrayList runs;

    public RunGroup(WidgetRun widgetRun, int n10) {
        int n11;
        ArrayList arrayList;
        this.runs = arrayList = new ArrayList();
        this.groupIndex = 0;
        this.groupIndex = n11 = index;
        index = n11 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = n10;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int n10) {
        WidgetRun widgetRun2;
        boolean bl2;
        Object object;
        boolean bl3;
        Dependency dependency;
        boolean bl4;
        Object object2 = widgetRun.widget.isTerminalWidget;
        boolean bl5 = object2[n10];
        if (!bl5) {
            return false;
        }
        object2 = widgetRun.start.dependencies.iterator();
        while (bl4 = object2.hasNext()) {
            dependency = (Dependency)object2.next();
            bl3 = dependency instanceof DependencyNode;
            if (!bl3) continue;
            dependency = (DependencyNode)dependency;
            object = ((DependencyNode)dependency).run;
            if (object == widgetRun || dependency != (object = ((WidgetRun)object).start)) continue;
            bl3 = widgetRun instanceof ChainRun;
            if (bl3) {
                object = widgetRun;
                object = ((ChainRun)widgetRun).widgets.iterator();
                while (bl2 = object.hasNext()) {
                    widgetRun2 = (WidgetRun)object.next();
                    this.defineTerminalWidget(widgetRun2, n10);
                }
            } else {
                bl3 = widgetRun instanceof HelperReferences;
                if (!bl3) {
                    object = widgetRun.widget.isTerminalWidget;
                    object[n10] = false;
                }
            }
            dependency = ((DependencyNode)dependency).run;
            this.defineTerminalWidget((WidgetRun)dependency, n10);
        }
        object2 = widgetRun.end.dependencies.iterator();
        while (bl4 = object2.hasNext()) {
            dependency = (Dependency)object2.next();
            bl3 = dependency instanceof DependencyNode;
            if (!bl3) continue;
            dependency = (DependencyNode)dependency;
            object = ((DependencyNode)dependency).run;
            if (object == widgetRun || dependency != (object = ((WidgetRun)object).start)) continue;
            bl3 = widgetRun instanceof ChainRun;
            if (bl3) {
                object = widgetRun;
                object = ((ChainRun)widgetRun).widgets.iterator();
                while (bl2 = object.hasNext()) {
                    widgetRun2 = (WidgetRun)object.next();
                    this.defineTerminalWidget(widgetRun2, n10);
                }
            } else {
                bl3 = widgetRun instanceof HelperReferences;
                if (!bl3) {
                    object = widgetRun.widget.isTerminalWidget;
                    object[n10] = false;
                }
            }
            dependency = ((DependencyNode)dependency).run;
            this.defineTerminalWidget((WidgetRun)dependency, n10);
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long l10) {
        WidgetRun widgetRun = dependencyNode.run;
        int n10 = widgetRun instanceof HelperReferences;
        if (n10 != 0) {
            return l10;
        }
        Object object = dependencyNode.dependencies;
        n10 = object.size();
        long l11 = l10;
        for (int i10 = 0; i10 < n10; ++i10) {
            Dependency dependency = (Dependency)dependencyNode.dependencies.get(i10);
            int n11 = dependency instanceof DependencyNode;
            if (n11 == 0) continue;
            dependency = (DependencyNode)dependency;
            WidgetRun widgetRun2 = ((DependencyNode)dependency).run;
            if (widgetRun2 == widgetRun) continue;
            n11 = ((DependencyNode)dependency).margin;
            long l12 = (long)n11 + l10;
            long l13 = this.traverseEnd((DependencyNode)dependency, l12);
            l11 = Math.min(l11, l13);
        }
        object = widgetRun.end;
        if (dependencyNode == object) {
            long l14 = widgetRun.getWrapDimension();
            dependencyNode = widgetRun.start;
            l10 -= l14;
            l14 = this.traverseEnd(dependencyNode, l10);
            l14 = Math.min(l11, l14);
            dependencyNode = widgetRun.start;
            int n12 = dependencyNode.margin;
            l11 = n12;
            l10 -= l11;
            l11 = Math.min(l14, l10);
        }
        return l11;
    }

    private long traverseStart(DependencyNode dependencyNode, long l10) {
        WidgetRun widgetRun = dependencyNode.run;
        int n10 = widgetRun instanceof HelperReferences;
        if (n10 != 0) {
            return l10;
        }
        Object object = dependencyNode.dependencies;
        n10 = object.size();
        long l11 = l10;
        for (int i10 = 0; i10 < n10; ++i10) {
            Dependency dependency = (Dependency)dependencyNode.dependencies.get(i10);
            int n11 = dependency instanceof DependencyNode;
            if (n11 == 0) continue;
            dependency = (DependencyNode)dependency;
            WidgetRun widgetRun2 = ((DependencyNode)dependency).run;
            if (widgetRun2 == widgetRun) continue;
            n11 = ((DependencyNode)dependency).margin;
            long l12 = (long)n11 + l10;
            long l13 = this.traverseStart((DependencyNode)dependency, l12);
            l11 = Math.max(l11, l13);
        }
        object = widgetRun.start;
        if (dependencyNode == object) {
            long l14 = widgetRun.getWrapDimension();
            dependencyNode = widgetRun.end;
            l10 += l14;
            l14 = this.traverseStart(dependencyNode, l10);
            l14 = Math.max(l11, l14);
            dependencyNode = widgetRun.end;
            int n12 = dependencyNode.margin;
            l11 = n12;
            l10 -= l11;
            l11 = Math.max(l14, l10);
        }
        return l11;
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long computeWrapSize(ConstraintWidgetContainer object, int n10) {
        long l10;
        long l11;
        Dependency dependency;
        Object object2 = this.firstRun;
        int n11 = object2 instanceof ChainRun;
        long l12 = 0L;
        if (n11 != 0) {
            dependency = object2;
            dependency = (ChainRun)object2;
            n11 = ((WidgetRun)dependency).orientation;
            if (n11 != n10) {
                return l12;
            }
        } else if (n10 == 0 ? (n11 = object2 instanceof HorizontalWidgetRun) == 0 : (n11 = object2 instanceof VerticalWidgetRun) == 0) {
            return l12;
        }
        dependency = n10 == 0 ? ((ConstraintWidget)object).horizontalRun : ((ConstraintWidget)object).verticalRun;
        dependency = ((WidgetRun)dependency).start;
        object = n10 == 0 ? ((ConstraintWidget)object).horizontalRun : ((ConstraintWidget)object).verticalRun;
        object = ((WidgetRun)object).end;
        object2 = object2.start.targets;
        int n12 = object2.contains(dependency);
        int n13 = this.firstRun.end.targets.contains(object);
        dependency = this.firstRun;
        long l13 = ((WidgetRun)dependency).getWrapDimension();
        if (n12 != 0 && n13 != 0) {
            float f10;
            float f11;
            long l14;
            object = this.firstRun.start;
            l11 = this.traverseStart((DependencyNode)object, l12);
            object = this.firstRun.end;
            long l15 = this.traverseEnd((DependencyNode)object, l12);
            object = this.firstRun;
            DependencyNode dependencyNode = ((WidgetRun)object).end;
            int n14 = dependencyNode.margin;
            long l16 = -n14;
            long l17 = (l11 -= l13) - l16;
            long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (l18 >= 0) {
                l14 = n14;
                l11 += l14;
            }
            l15 = -l15 - l13;
            dependencyNode = ((WidgetRun)object).start;
            n14 = dependencyNode.margin;
            l16 = n14;
            long l19 = (l15 -= l16) - (l16 = (long)n14);
            l18 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            if (l18 >= 0) {
                l14 = n14;
                l15 -= l14;
            }
            object = ((WidgetRun)object).widget;
            float f12 = ((ConstraintWidget)object).getBiasPercent(n10);
            float f13 = 0.0f;
            DependencyNode dependencyNode2 = null;
            float f14 = f12 - 0.0f;
            n10 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            n14 = 1065353216;
            float f15 = 1.0f;
            if (n10 > 0) {
                f13 = (float)l15 / f12;
                f11 = l11;
                f10 = f15 - f12;
                l12 = (long)(f13 += (f11 /= f10));
            }
            f13 = l12;
            f11 = f13 * f12;
            n11 = 0x3F000000;
            f10 = 0.5f;
            l12 = (long)(f11 += f10);
            f13 = f13 * (f15 -= f12) + f10;
            l10 = (long)f13;
            l12 = l12 + l13 + l10;
            object = this.firstRun;
            dependencyNode2 = ((WidgetRun)object).start;
            n10 = dependencyNode2.margin;
            l11 = (long)n10 + l12;
            object = ((WidgetRun)object).end;
            n13 = ((DependencyNode)object).margin;
        } else {
            if (n12 != 0) {
                object = this.firstRun.start;
                n10 = ((DependencyNode)object).margin;
                l11 = n10;
                long l20 = this.traverseStart((DependencyNode)object, l11);
                object2 = this.firstRun.start;
                n12 = ((DependencyNode)object2).margin;
                l11 = (long)n12 + l13;
                return Math.max(l20, l11);
            }
            if (n13 != 0) {
                object = this.firstRun.end;
                n10 = ((DependencyNode)object).margin;
                l11 = n10;
                long l21 = this.traverseEnd((DependencyNode)object, l11);
                object2 = this.firstRun.end;
                n12 = -((DependencyNode)object2).margin;
                l11 = (long)n12 + l13;
                l21 = -l21;
                return Math.max(l21, l11);
            }
            object = this.firstRun;
            DependencyNode dependencyNode = ((WidgetRun)object).start;
            n10 = dependencyNode.margin;
            l11 = n10;
            l10 = ((WidgetRun)object).getWrapDimension();
            l11 += l10;
            object = this.firstRun.end;
            n13 = ((DependencyNode)object).margin;
        }
        l10 = n13;
        l11 -= l10;
        return l11;
    }

    public void defineTerminalWidgets(boolean bl2, boolean bl3) {
        WidgetRun widgetRun;
        boolean bl4;
        if (bl2 && (bl4 = (widgetRun = this.firstRun) instanceof HorizontalWidgetRun)) {
            bl4 = false;
            this.defineTerminalWidget(widgetRun, 0);
        }
        if (bl3 && (bl3 = (widgetRun = this.firstRun) instanceof VerticalWidgetRun)) {
            bl3 = true;
            this.defineTerminalWidget(widgetRun, bl3 ? 1 : 0);
        }
    }
}

