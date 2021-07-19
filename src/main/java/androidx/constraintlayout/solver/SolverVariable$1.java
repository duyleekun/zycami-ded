/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable$Type;

public class SolverVariable$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        SolverVariable$Type solverVariable$Type;
        int n12 = SolverVariable$Type.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = nArray;
        try {
            solverVariable$Type = SolverVariable$Type.UNRESTRICTED;
            n11 = solverVariable$Type.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
            solverVariable$Type = SolverVariable$Type.CONSTANT;
            n11 = solverVariable$Type.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
            solverVariable$Type = SolverVariable$Type.SLACK;
            n11 = solverVariable$Type.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
            solverVariable$Type = SolverVariable$Type.ERROR;
            n11 = solverVariable$Type.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
            solverVariable$Type = SolverVariable$Type.UNKNOWN;
            n11 = solverVariable$Type.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

