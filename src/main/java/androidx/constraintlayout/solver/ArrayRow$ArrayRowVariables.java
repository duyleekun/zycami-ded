/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.SolverVariable;

public interface ArrayRow$ArrayRowVariables {
    public void add(SolverVariable var1, float var2, boolean var3);

    public void clear();

    public boolean contains(SolverVariable var1);

    public void display();

    public void divideByAmount(float var1);

    public float get(SolverVariable var1);

    public int getCurrentSize();

    public SolverVariable getVariable(int var1);

    public float getVariableValue(int var1);

    public int indexOf(SolverVariable var1);

    public void invert();

    public void put(SolverVariable var1, float var2);

    public float remove(SolverVariable var1, boolean var2);

    public int sizeInBytes();

    public float use(ArrayRow var1, boolean var2);
}

