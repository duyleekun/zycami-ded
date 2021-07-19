/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;

public class Optimizer {
    public static final int FLAG_CHAIN_DANGLING = 1;
    public static final int FLAG_RECOMPUTE_BOUNDS = 2;
    public static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CACHE_MEASURES = 256;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DEPENDENCY_ORDERING = 512;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GRAPH = 64;
    public static final int OPTIMIZATION_GRAPH_WRAP = 128;
    public static final int OPTIMIZATION_GROUPING = 1024;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 257;
    public static boolean[] flags = new boolean[3];

    public static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        int n10;
        constraintWidget.mHorizontalResolution = n10 = -1;
        constraintWidget.mVerticalResolution = n10;
        Object object = constraintWidgetContainer.mListDimensionBehaviors;
        int n11 = 0;
        Object object2 = null;
        object = object[0];
        Object object3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        int n12 = 2;
        if (object != object3 && (object = constraintWidget.mListDimensionBehaviors[0]) == (object2 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT)) {
            SolverVariable solverVariable;
            object = constraintWidget.mLeft;
            n10 = object.mMargin;
            n11 = constraintWidgetContainer.getWidth();
            int n13 = constraintWidget.mRight.mMargin;
            Object object4 = constraintWidget.mLeft;
            ((ConstraintAnchor)object4).mSolverVariable = solverVariable = linearSystem.createObjectVariable(object4);
            object4 = constraintWidget.mRight;
            ((ConstraintAnchor)object4).mSolverVariable = solverVariable = linearSystem.createObjectVariable(object4);
            object4 = constraintWidget.mLeft.mSolverVariable;
            linearSystem.addEquality((SolverVariable)object4, n10);
            object4 = constraintWidget.mRight.mSolverVariable;
            linearSystem.addEquality((SolverVariable)object4, n11 -= n13);
            constraintWidget.mHorizontalResolution = n12;
            constraintWidget.setHorizontalDimension(n10, n11);
        }
        object = constraintWidgetContainer.mListDimensionBehaviors;
        n11 = 1;
        if ((object = object[n11]) != object3 && (object = constraintWidget.mListDimensionBehaviors[n11]) == (object2 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT)) {
            int n14;
            object = constraintWidget.mTop;
            n10 = object.mMargin;
            int n15 = constraintWidgetContainer.getHeight();
            n11 = constraintWidget.mBottom.mMargin;
            object2 = constraintWidget.mTop;
            object3 = linearSystem.createObjectVariable(object2);
            ((ConstraintAnchor)object2).mSolverVariable = object3;
            object2 = constraintWidget.mBottom;
            object3 = linearSystem.createObjectVariable(object2);
            ((ConstraintAnchor)object2).mSolverVariable = object3;
            object2 = constraintWidget.mTop.mSolverVariable;
            linearSystem.addEquality((SolverVariable)object2, n10);
            object2 = constraintWidget.mBottom.mSolverVariable;
            linearSystem.addEquality((SolverVariable)object2, n15 -= n11);
            n11 = constraintWidget.mBaselineDistance;
            if (n11 > 0 || (n11 = constraintWidget.getVisibility()) == (n14 = 8)) {
                object2 = constraintWidget.mBaseline;
                object3 = linearSystem.createObjectVariable(object2);
                ((ConstraintAnchor)object2).mSolverVariable = object3;
                object2 = constraintWidget.mBaseline.mSolverVariable;
                n14 = constraintWidget.mBaselineDistance + n10;
                linearSystem.addEquality((SolverVariable)object2, n14);
            }
            constraintWidget.mVerticalResolution = n12;
            constraintWidget.setVerticalDimension(n10, n15);
        }
    }

    public static final boolean enabled(int n10, int n11) {
        n10 = (n10 &= n11) == n11 ? 1 : 0;
        return n10 != 0;
    }
}

