/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;

public interface LinearSystem$Row {
    public void addError(SolverVariable var1);

    public void clear();

    public SolverVariable getKey();

    public SolverVariable getPivotCandidate(LinearSystem var1, boolean[] var2);

    public void initFromRow(LinearSystem$Row var1);

    public boolean isEmpty();

    public void updateFromFinalVariable(LinearSystem var1, SolverVariable var2, boolean var3);

    public void updateFromRow(LinearSystem var1, ArrayRow var2, boolean var3);

    public void updateFromSystem(LinearSystem var1);
}

