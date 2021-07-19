/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariableValues;

public class LinearSystem$ValuesRow
extends ArrayRow {
    public final /* synthetic */ LinearSystem this$0;

    public LinearSystem$ValuesRow(LinearSystem object, Cache cache) {
        this.this$0 = object;
        this.variables = object = new SolverVariableValues(this, cache);
    }
}

