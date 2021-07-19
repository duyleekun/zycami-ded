/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;

public interface BasicMeasure$Measurer {
    public void didMeasures();

    public void measure(ConstraintWidget var1, BasicMeasure$Measure var2);
}

