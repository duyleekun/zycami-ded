/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;

public interface Helper {
    public void add(ConstraintWidget var1);

    public void removeAllIds();

    public void updateConstraints(ConstraintWidgetContainer var1);
}

