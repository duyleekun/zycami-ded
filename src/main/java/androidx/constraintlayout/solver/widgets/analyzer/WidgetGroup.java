/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup$MeasureResult;
import java.util.ArrayList;
import java.util.Iterator;

public class WidgetGroup {
    private static final boolean DEBUG = false;
    public static int count;
    public boolean authoritative;
    public int id;
    private int moveTo;
    public int orientation;
    public ArrayList results;
    public ArrayList widgets;

    public WidgetGroup(int n10) {
        int n11;
        ArrayList arrayList;
        this.widgets = arrayList = new ArrayList();
        this.id = n11 = -1;
        this.authoritative = false;
        this.orientation = 0;
        this.results = null;
        this.moveTo = n11;
        n11 = count;
        count = n11 + 1;
        this.id = n11;
        this.orientation = n10;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        return this.widgets.contains(constraintWidget);
    }

    private String getOrientationString() {
        int n10 = this.orientation;
        if (n10 == 0) {
            return "Horizontal";
        }
        int n11 = 1;
        if (n10 == n11) {
            return "Vertical";
        }
        n11 = 2;
        if (n10 == n11) {
            return "Both";
        }
        return "Unknown";
    }

    private int measureWrap(int n10, ConstraintWidget constraintWidget) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget.getDimensionBehaviour(n10);
        if (constraintWidget$DimensionBehaviour2 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && constraintWidget$DimensionBehaviour2 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_PARENT) && constraintWidget$DimensionBehaviour2 != (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED)) {
            return -1;
        }
        n10 = n10 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight();
        return n10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int solverMeasure(LinearSystem linearSystem, ArrayList object, int n10) {
        int n11;
        Object object2;
        int n12;
        int n13;
        int n14 = 0;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer)((ConstraintWidget)((ArrayList)object).get(0)).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        Object object3 = null;
        for (n13 = 0; n13 < (n12 = ((ArrayList)object).size()); ++n13) {
            object2 = (ConstraintWidget)((ArrayList)object).get(n13);
            ((ConstraintWidget)object2).addToSolver(linearSystem, false);
        }
        if (n10 == 0 && (n13 = constraintWidgetContainer.mHorizontalChainsSize) > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, (ArrayList)object, 0);
        }
        if (n10 == (n13 = 1) && (n12 = constraintWidgetContainer.mVerticalChainsSize) > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, (ArrayList)object, n13);
        }
        try {
            linearSystem.minimize();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        object3 = new ArrayList();
        this.results = object3;
        while (n14 < (n13 = ((ArrayList)object).size())) {
            object3 = (ConstraintWidget)((ArrayList)object).get(n14);
            object2 = new WidgetGroup$MeasureResult(this, (ConstraintWidget)object3, linearSystem, n10);
            object3 = this.results;
            ((ArrayList)object3).add(object2);
            ++n14;
        }
        if (n10 == 0) {
            object = constraintWidgetContainer.mLeft;
            n11 = linearSystem.getObjectVariableValue(object);
            ConstraintAnchor constraintAnchor = constraintWidgetContainer.mRight;
            n10 = linearSystem.getObjectVariableValue(constraintAnchor);
            linearSystem.reset();
            return n10 - n11;
        }
        object = constraintWidgetContainer.mTop;
        n11 = linearSystem.getObjectVariableValue(object);
        ConstraintAnchor constraintAnchor = constraintWidgetContainer.mBottom;
        n10 = linearSystem.getObjectVariableValue(constraintAnchor);
        linearSystem.reset();
        return n10 - n11;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        ArrayList arrayList = this.widgets;
        boolean bl2 = arrayList.contains(constraintWidget);
        if (bl2) {
            return false;
        }
        this.widgets.add(constraintWidget);
        return true;
    }

    public void apply() {
        Object object;
        int n10;
        ArrayList arrayList = this.results;
        if (arrayList == null) {
            return;
        }
        int n11 = this.authoritative;
        if (n11 == 0) {
            return;
        }
        arrayList = null;
        for (n11 = 0; n11 < (n10 = ((ArrayList)(object = this.results)).size()); ++n11) {
            object = (WidgetGroup$MeasureResult)this.results.get(n11);
            ((WidgetGroup$MeasureResult)object).apply();
        }
    }

    public void cleanup(ArrayList arrayList) {
        ArrayList arrayList2 = this.widgets;
        int n10 = arrayList2.size();
        int n11 = this.moveTo;
        int n12 = -1;
        if (n11 != n12 && n10 > 0) {
            for (n11 = 0; n11 < (n12 = arrayList.size()); ++n11) {
                WidgetGroup widgetGroup = (WidgetGroup)arrayList.get(n11);
                int n13 = this.moveTo;
                int n14 = widgetGroup.id;
                if (n13 != n14) continue;
                n13 = this.orientation;
                this.moveTo(n13, widgetGroup);
            }
        }
        if (n10 == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.widgets.clear();
    }

    public int getId() {
        return this.id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.widgets)).size()); ++i10) {
            object = (ConstraintWidget)this.widgets.get(i10);
            n10 = widgetGroup.contains((ConstraintWidget)object) ? 1 : 0;
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public int measureWrap(LinearSystem linearSystem, int n10) {
        ArrayList arrayList = this.widgets;
        int n11 = arrayList.size();
        if (n11 == 0) {
            return 0;
        }
        arrayList = this.widgets;
        return this.solverMeasure(linearSystem, arrayList, n10);
    }

    public void moveTo(int n10, WidgetGroup widgetGroup) {
        boolean bl2;
        Iterator iterator2 = this.widgets.iterator();
        while (bl2 = iterator2.hasNext()) {
            int n11;
            ConstraintWidget constraintWidget = (ConstraintWidget)iterator2.next();
            widgetGroup.add(constraintWidget);
            if (n10 == 0) {
                constraintWidget.horizontalGroup = n11 = widgetGroup.getId();
                continue;
            }
            constraintWidget.verticalGroup = n11 = widgetGroup.getId();
        }
        this.moveTo = n10 = widgetGroup.id;
    }

    public void setAuthoritative(boolean bl2) {
        this.authoritative = bl2;
    }

    public void setOrientation(int n10) {
        this.orientation = n10;
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        Object object = this.getOrientationString();
        charSequence.append((String)object);
        charSequence.append(" [");
        int n10 = this.id;
        charSequence.append(n10);
        charSequence.append("] <");
        charSequence = charSequence.toString();
        object = this.widgets.iterator();
        while (bl2 = object.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget)object.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append(" ");
            charSequence = constraintWidget.getDebugName();
            stringBuilder.append((String)charSequence);
            charSequence = stringBuilder.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append(" >");
        return ((StringBuilder)object).toString();
    }
}

