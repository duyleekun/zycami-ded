/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Comparator;

public class PriorityGoalRow$1
implements Comparator {
    public final /* synthetic */ PriorityGoalRow this$0;

    public PriorityGoalRow$1(PriorityGoalRow priorityGoalRow) {
        this.this$0 = priorityGoalRow;
    }

    public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
        int n10 = solverVariable.id;
        int n11 = solverVariable2.id;
        return n10 - n11;
    }
}

