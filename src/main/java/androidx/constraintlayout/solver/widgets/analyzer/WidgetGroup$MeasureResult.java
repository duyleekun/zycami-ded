/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.lang.ref.WeakReference;

public class WidgetGroup$MeasureResult {
    public int baseline;
    public int bottom;
    public int left;
    public int orientation;
    public int right;
    public final /* synthetic */ WidgetGroup this$0;
    public int top;
    public WeakReference widgetRef;

    public WidgetGroup$MeasureResult(WidgetGroup object, ConstraintWidget constraintWidget, LinearSystem linearSystem, int n10) {
        int n11;
        this.this$0 = object;
        object = new WeakReference(constraintWidget);
        this.widgetRef = object;
        object = constraintWidget.mLeft;
        this.left = n11 = linearSystem.getObjectVariableValue(object);
        object = constraintWidget.mTop;
        this.top = n11 = linearSystem.getObjectVariableValue(object);
        object = constraintWidget.mRight;
        this.right = n11 = linearSystem.getObjectVariableValue(object);
        object = constraintWidget.mBottom;
        this.bottom = n11 = linearSystem.getObjectVariableValue(object);
        object = constraintWidget.mBaseline;
        this.baseline = n11 = linearSystem.getObjectVariableValue(object);
        this.orientation = n10;
    }

    public void apply() {
        Object t10 = this.widgetRef.get();
        Object object = t10;
        object = (ConstraintWidget)t10;
        if (object != null) {
            int n10 = this.left;
            int n11 = this.top;
            int n12 = this.right;
            int n13 = this.bottom;
            int n14 = this.baseline;
            int n15 = this.orientation;
            ((ConstraintWidget)object).setFinalFrame(n10, n11, n12, n13, n14, n15);
        }
    }
}

