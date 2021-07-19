/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget
extends ConstraintWidget
implements Helper {
    public ConstraintWidget[] mWidgets;
    public int mWidgetsCount;

    public HelperWidget() {
        ConstraintWidget[] constraintWidgetArray = new ConstraintWidget[4];
        this.mWidgets = constraintWidgetArray;
        this.mWidgetsCount = 0;
    }

    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            ConstraintWidget[] constraintWidgetArray;
            int n10 = this.mWidgetsCount + 1;
            ConstraintWidget[] constraintWidgetArray2 = this.mWidgets;
            int n11 = constraintWidgetArray2.length;
            if (n10 > n11) {
                n10 = constraintWidgetArray2.length * 2;
                this.mWidgets = constraintWidgetArray = Arrays.copyOf(constraintWidgetArray2, n10);
            }
            constraintWidgetArray = this.mWidgets;
            int n12 = this.mWidgetsCount;
            constraintWidgetArray[n12] = constraintWidget;
            this.mWidgetsCount = ++n12;
        }
    }

    public void addDependents(ArrayList arrayList, int n10, WidgetGroup widgetGroup) {
        int n11;
        int n12;
        int n13 = 0;
        ConstraintWidget constraintWidget = null;
        for (n12 = 0; n12 < (n11 = this.mWidgetsCount); ++n12) {
            ConstraintWidget constraintWidget2 = this.mWidgets[n12];
            widgetGroup.add(constraintWidget2);
        }
        while (n13 < (n12 = this.mWidgetsCount)) {
            constraintWidget = this.mWidgets[n13];
            Grouping.findDependents(constraintWidget, n10, arrayList, widgetGroup);
            ++n13;
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap hashMap) {
        super.copy(constraintWidget, hashMap);
        constraintWidget = (HelperWidget)constraintWidget;
        this.mWidgetsCount = 0;
        int n10 = ((HelperWidget)constraintWidget).mWidgetsCount;
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget constraintWidget2 = ((HelperWidget)constraintWidget).mWidgets[i10];
            constraintWidget2 = (ConstraintWidget)hashMap.get(constraintWidget2);
            this.add(constraintWidget2);
        }
    }

    public int findGroupInDependents(int n10) {
        int n11;
        int n12 = 0;
        while (true) {
            int n13;
            int n14 = this.mWidgetsCount;
            n11 = -1;
            if (n12 >= n14) break;
            ConstraintWidget constraintWidget = this.mWidgets[n12];
            if (n10 == 0 && (n13 = constraintWidget.horizontalGroup) != n11) {
                return n13;
            }
            n13 = 1;
            if (n10 == n13 && (n14 = constraintWidget.verticalGroup) != n11) {
                return n14;
            }
            ++n12;
        }
        return n11;
    }

    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, null);
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}

