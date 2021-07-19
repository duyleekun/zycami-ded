/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public class BaselineDimensionDependency
extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(DependencyNode dependency) {
        int n10;
        Dependency dependency2 = dependency = this.run;
        dependency2 = ((VerticalWidgetRun)dependency).baseline;
        dependency2.margin = n10 = ((WidgetRun)dependency).widget.getBaselineDistance();
        this.resolved = true;
    }
}

