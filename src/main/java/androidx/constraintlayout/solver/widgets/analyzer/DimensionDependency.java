/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.Iterator;

public class DimensionDependency
extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun object) {
        super((WidgetRun)object);
        boolean bl2 = object instanceof HorizontalWidgetRun;
        if (bl2) {
            object = DependencyNode$Type.HORIZONTAL_DIMENSION;
            this.type = object;
        } else {
            object = DependencyNode$Type.VERTICAL_DIMENSION;
            this.type = object;
        }
    }

    public void resolve(int n10) {
        boolean bl2 = this.resolved;
        if (bl2) {
            return;
        }
        this.resolved = bl2 = true;
        this.value = n10;
        Iterator iterator2 = this.dependencies.iterator();
        while (bl2 = iterator2.hasNext()) {
            Dependency dependency = (Dependency)iterator2.next();
            dependency.update(dependency);
        }
    }
}

