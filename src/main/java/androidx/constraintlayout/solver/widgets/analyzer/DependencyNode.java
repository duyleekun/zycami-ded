/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DependencyNode
implements Dependency {
    public boolean delegateToWidgetRun = false;
    public List dependencies;
    public int margin;
    public DimensionDependency marginDependency;
    public int marginFactor;
    public boolean readyToSolve = false;
    public boolean resolved;
    public WidgetRun run;
    public List targets;
    public DependencyNode$Type type;
    public Dependency updateDelegate = null;
    public int value;

    public DependencyNode(WidgetRun widgetRun) {
        ArrayList arrayList;
        DependencyNode$Type dependencyNode$Type;
        this.type = dependencyNode$Type = DependencyNode$Type.UNKNOWN;
        this.marginFactor = 1;
        this.marginDependency = null;
        this.resolved = false;
        this.dependencies = arrayList = new ArrayList();
        this.targets = arrayList = new ArrayList();
        this.run = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        List list = this.dependencies;
        list.add(dependency);
        boolean bl2 = this.resolved;
        if (bl2) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String string2 = this.run.widget.getDebugName();
        Object object = this.type;
        DependencyNode$Type dependencyNode$Type = DependencyNode$Type.LEFT;
        if (object != dependencyNode$Type && object != (dependencyNode$Type = DependencyNode$Type.RIGHT)) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("_VERTICAL");
            string2 = ((StringBuilder)object).toString();
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("_HORIZONTAL");
            string2 = ((StringBuilder)object).toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(":");
        string2 = this.type.name();
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.run.widget.getDebugName();
        stringBuilder.append((String)object);
        stringBuilder.append(":");
        object = this.type;
        stringBuilder.append(object);
        object = "(";
        stringBuilder.append((String)object);
        int n10 = this.resolved;
        if (n10 != 0) {
            n10 = this.value;
            object = n10;
        } else {
            object = "unresolved";
        }
        stringBuilder.append(object);
        stringBuilder.append(") <t=");
        n10 = this.targets.size();
        stringBuilder.append(n10);
        stringBuilder.append(":d=");
        n10 = this.dependencies.size();
        stringBuilder.append(n10);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public void update(Dependency object) {
        boolean bl2;
        Dependency dependency;
        int n10;
        object = this.targets.iterator();
        while ((n10 = object.hasNext()) != 0) {
            dependency = (DependencyNode)object.next();
            n10 = ((DependencyNode)dependency).resolved;
            if (n10 != 0) continue;
            return;
        }
        int n11 = 1;
        this.readyToSolve = n11;
        dependency = this.updateDelegate;
        if (dependency != null) {
            dependency.update(this);
        }
        if ((n10 = this.delegateToWidgetRun) != 0) {
            this.run.update(this);
            return;
        }
        n10 = 0;
        dependency = null;
        int n12 = 0;
        Iterator iterator2 = this.targets.iterator();
        while (bl2 = iterator2.hasNext()) {
            DependencyNode dependencyNode = (DependencyNode)iterator2.next();
            boolean bl3 = dependencyNode instanceof DimensionDependency;
            if (bl3) continue;
            ++n12;
            dependency = dependencyNode;
        }
        if (dependency != null && n12 == n11 && (n11 = ((DependencyNode)dependency).resolved) != 0) {
            object = this.marginDependency;
            if (object != null) {
                n12 = (int)(((DependencyNode)object).resolved ? 1 : 0);
                if (n12 != 0) {
                    n12 = this.marginFactor;
                    n11 = ((DependencyNode)object).value;
                    this.margin = n12 *= n11;
                } else {
                    return;
                }
            }
            n11 = ((DependencyNode)dependency).value;
            n10 = this.margin;
            this.resolve(n11 += n10);
        }
        if ((object = this.updateDelegate) != null) {
            object.update(this);
        }
    }
}

