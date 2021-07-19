/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

public class WidgetContainer
extends ConstraintWidget {
    public ArrayList mChildren;

    public WidgetContainer() {
        ArrayList arrayList;
        this.mChildren = arrayList = new ArrayList();
    }

    public WidgetContainer(int n10, int n11) {
        super(n10, n11);
        ArrayList arrayList;
        this.mChildren = arrayList = new ArrayList();
    }

    public WidgetContainer(int n10, int n11, int n12, int n13) {
        super(n10, n11, n12, n13);
        ArrayList arrayList;
        this.mChildren = arrayList = new ArrayList();
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        ConstraintWidget constraintWidget2 = constraintWidget.getParent();
        if (constraintWidget2 != null) {
            constraintWidget2 = (WidgetContainer)constraintWidget.getParent();
            ((WidgetContainer)constraintWidget2).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public void add(ConstraintWidget ... constraintWidgetArray) {
        for (ConstraintWidget constraintWidget : constraintWidgetArray) {
            this.add(constraintWidget);
        }
    }

    public ArrayList getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.getParent();
        boolean bl2 = this instanceof ConstraintWidgetContainer;
        if (bl2) {
            constraintWidget = this;
            constraintWidget = (ConstraintWidgetContainer)this;
        } else {
            bl2 = false;
            constraintWidget = null;
        }
        while (constraintWidget2 != null) {
            ConstraintWidget constraintWidget3 = constraintWidget2.getParent();
            boolean bl3 = constraintWidget2 instanceof ConstraintWidgetContainer;
            if (bl3) {
                constraintWidget = constraintWidget2;
                constraintWidget = (ConstraintWidgetContainer)constraintWidget2;
            }
            constraintWidget2 = constraintWidget3;
        }
        return constraintWidget;
    }

    public void layout() {
        ArrayList arrayList = this.mChildren;
        if (arrayList == null) {
            return;
        }
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i10);
            boolean bl2 = constraintWidget instanceof WidgetContainer;
            if (!bl2) continue;
            constraintWidget = (WidgetContainer)constraintWidget;
            ((WidgetContainer)constraintWidget).layout();
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.reset();
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        ArrayList arrayList = this.mChildren;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i10);
            constraintWidget.resetSolverVariables(cache);
        }
    }

    public void setOffset(int n10, int n11) {
        super.setOffset(n10, n11);
        ArrayList arrayList = this.mChildren;
        n10 = arrayList.size();
        for (n11 = 0; n11 < n10; ++n11) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(n11);
            int n12 = this.getRootX();
            int n13 = this.getRootY();
            constraintWidget.setOffset(n12, n13);
        }
    }
}

