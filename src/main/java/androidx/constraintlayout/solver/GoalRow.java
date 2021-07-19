/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;

public class GoalRow
extends ArrayRow {
    public GoalRow(Cache cache) {
        super(cache);
    }

    public void addError(SolverVariable solverVariable) {
        int n10;
        super.addError(solverVariable);
        solverVariable.usageInRowCount = n10 = solverVariable.usageInRowCount + -1;
    }
}

