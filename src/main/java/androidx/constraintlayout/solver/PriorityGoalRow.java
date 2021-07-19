/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.PriorityGoalRow$1;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public class PriorityGoalRow
extends ArrayRow {
    private static final boolean DEBUG = false;
    public static final int NOT_FOUND = 255;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    public PriorityGoalRow$GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    public Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    public PriorityGoalRow(Cache cache) {
        super(cache);
        int n10;
        this.TABLE_SIZE = n10 = 128;
        SolverVariable[] solverVariableArray = new SolverVariable[n10];
        this.arrayGoals = solverVariableArray;
        Object object = new SolverVariable[n10];
        this.sortArray = object;
        this.numGoals = 0;
        super(this, this);
        this.accessor = object;
        this.mCache = cache;
    }

    public static /* synthetic */ void access$000(PriorityGoalRow priorityGoalRow, SolverVariable solverVariable) {
        priorityGoalRow.removeGoal(solverVariable);
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int n10;
        Object object;
        int n11 = this.numGoals;
        int n12 = 1;
        SolverVariable[] solverVariableArray = this.arrayGoals;
        int n13 = solverVariableArray.length;
        if ((n11 += n12) > n13) {
            n11 = solverVariableArray.length * 2;
            this.arrayGoals = object = Arrays.copyOf(solverVariableArray, n11);
            n10 = ((SolverVariable[])object).length * 2;
            object = Arrays.copyOf(object, n10);
            this.sortArray = object;
        }
        object = this.arrayGoals;
        n10 = this.numGoals;
        object[n10] = solverVariable;
        this.numGoals = n10 += n12;
        if (n10 > n12) {
            object = object[n10 -= n12];
            n11 = object.id;
            n10 = solverVariable.id;
            if (n11 > n10) {
                Object object2;
                Object object3;
                n11 = 0;
                object = null;
                solverVariableArray = null;
                for (n10 = 0; n10 < (n13 = this.numGoals); ++n10) {
                    object3 = this.sortArray;
                    object3[n10] = object2 = this.arrayGoals[n10];
                }
                solverVariableArray = this.sortArray;
                object2 = new PriorityGoalRow$1(this);
                Arrays.sort(solverVariableArray, 0, n13, object2);
                while (n11 < (n10 = this.numGoals)) {
                    solverVariableArray = this.arrayGoals;
                    solverVariableArray[n11] = object3 = this.sortArray[n11];
                    ++n11;
                }
            }
        }
        solverVariable.inGoal = n12;
        solverVariable.addToRow(this);
    }

    private final void removeGoal(SolverVariable solverVariable) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.numGoals); ++i10) {
            int n11;
            SolverVariable[] solverVariableArray = this.arrayGoals[i10];
            if (solverVariableArray != solverVariable) continue;
            while (i10 < (n11 = (n10 = this.numGoals) + -1)) {
                SolverVariable solverVariable2;
                solverVariableArray = this.arrayGoals;
                n11 = i10 + 1;
                solverVariableArray[i10] = solverVariable2 = solverVariableArray[n11];
                i10 = n11;
            }
            this.numGoals = n10 += -1;
            solverVariable.inGoal = false;
            return;
        }
    }

    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        float[] fArray = solverVariable.goalStrengthVector;
        int n10 = solverVariable.strength;
        fArray[n10] = 1.0f;
        this.addToGoal(solverVariable);
    }

    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] blArray) {
        int n10;
        int n11 = -1;
        int n12 = n11;
        for (int i10 = 0; i10 < (n10 = this.numGoals); ++i10) {
            Object object = this.arrayGoals[i10];
            int n13 = ((SolverVariable)object).id;
            if ((n13 = blArray[n13]) != 0) continue;
            Object object2 = this.accessor;
            ((PriorityGoalRow$GoalVariableAccessor)object2).init((SolverVariable)object);
            if (!(n12 == n11 ? (n10 = (int)(((PriorityGoalRow$GoalVariableAccessor)(object = this.accessor)).isNegative() ? 1 : 0)) != 0 : (n10 = (int)(((PriorityGoalRow$GoalVariableAccessor)(object = this.accessor)).isSmallerThan((SolverVariable)(object2 = this.arrayGoals[n12])) ? 1 : 0)) != 0)) continue;
            n12 = i10;
        }
        if (n12 == n11) {
            return null;
        }
        return this.arrayGoals[n12];
    }

    public boolean isEmpty() {
        int n10 = this.numGoals;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public String toString() {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("");
        ((StringBuilder)object).append(" goal -> (");
        float f10 = this.constantValue;
        ((StringBuilder)object).append(f10);
        ((StringBuilder)object).append(") : ");
        object = ((StringBuilder)object).toString();
        f10 = 0.0f;
        for (int i10 = 0; i10 < (n10 = this.numGoals); ++i10) {
            Object object2 = this.arrayGoals[i10];
            PriorityGoalRow$GoalVariableAccessor priorityGoalRow$GoalVariableAccessor = this.accessor;
            priorityGoalRow$GoalVariableAccessor.init((SolverVariable)object2);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            object = this.accessor;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" ");
            object = ((StringBuilder)object2).toString();
        }
        return object;
    }

    public void updateFromRow(LinearSystem object, ArrayRow arrayRow, boolean bl2) {
        object = arrayRow.variable;
        if (object == null) {
            return;
        }
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = arrayRow.variables;
        int n10 = arrayRow$ArrayRowVariables.getCurrentSize();
        for (int i10 = 0; i10 < n10; ++i10) {
            SolverVariable solverVariable = arrayRow$ArrayRowVariables.getVariable(i10);
            float f10 = arrayRow$ArrayRowVariables.getVariableValue(i10);
            this.accessor.init(solverVariable);
            PriorityGoalRow$GoalVariableAccessor priorityGoalRow$GoalVariableAccessor = this.accessor;
            boolean bl3 = priorityGoalRow$GoalVariableAccessor.addToGoal((SolverVariable)object, f10);
            if (bl3) {
                this.addToGoal(solverVariable);
            }
            float f11 = this.constantValue;
            float f12 = arrayRow.constantValue * f10;
            this.constantValue = f11 += f12;
        }
        this.removeGoal((SolverVariable)object);
    }
}

