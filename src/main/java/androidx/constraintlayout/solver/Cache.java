/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.Pools$Pool;
import androidx.constraintlayout.solver.Pools$SimplePool;
import androidx.constraintlayout.solver.SolverVariable;

public class Cache {
    public Pools$Pool arrayRowPool;
    public SolverVariable[] mIndexedVariables;
    public Pools$Pool optimizedArrayRowPool;
    public Pools$Pool solverVariablePool;

    public Cache() {
        int n10 = 256;
        SolverVariable[] solverVariableArray = new Pools$SimplePool(n10);
        this.optimizedArrayRowPool = solverVariableArray;
        solverVariableArray = new Pools$SimplePool(n10);
        this.arrayRowPool = solverVariableArray;
        solverVariableArray = new Pools$SimplePool(n10);
        this.solverVariablePool = solverVariableArray;
        solverVariableArray = new SolverVariable[32];
        this.mIndexedVariables = solverVariableArray;
    }
}

