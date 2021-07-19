/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public class PriorityGoalRow$GoalVariableAccessor
implements Comparable {
    public PriorityGoalRow row;
    public final /* synthetic */ PriorityGoalRow this$0;
    public SolverVariable variable;

    public PriorityGoalRow$GoalVariableAccessor(PriorityGoalRow priorityGoalRow, PriorityGoalRow priorityGoalRow2) {
        this.this$0 = priorityGoalRow;
        this.row = priorityGoalRow2;
    }

    public void add(SolverVariable solverVariable) {
        int n10 = 0;
        while (true) {
            int n11 = 9;
            float f10 = 1.3E-44f;
            if (n10 >= n11) break;
            float[] fArray = this.variable.goalStrengthVector;
            float f11 = fArray[n10];
            float[] fArray2 = solverVariable.goalStrengthVector;
            float f12 = fArray2[n10];
            fArray[n10] = f11 += f12;
            f10 = Math.abs(fArray[n10]);
            float f13 = f10 - (f11 = 1.0E-4f);
            n11 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (n11 < 0) {
                fArray = this.variable.goalStrengthVector;
                f11 = 0.0f;
                fArray[n10] = 0.0f;
            }
            ++n10;
        }
    }

    public boolean addToGoal(SolverVariable object, float f10) {
        Object object2 = this.variable;
        int n10 = ((SolverVariable)object2).inGoal;
        float f11 = 1.0E-4f;
        int n11 = 9;
        boolean bl2 = true;
        if (n10 != 0) {
            object2 = null;
            float f12 = 0.0f;
            for (n10 = 0; n10 < n11; ++n10) {
                float[] fArray = this.variable.goalStrengthVector;
                float f13 = fArray[n10];
                float[] fArray2 = ((SolverVariable)object).goalStrengthVector;
                float f14 = fArray2[n10] * f10;
                fArray[n10] = f13 += f14;
                float f15 = Math.abs(fArray[n10]);
                float f16 = f15 - f11;
                float f17 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                if (f17 < 0) {
                    fArray = this.variable.goalStrengthVector;
                    fArray[n10] = 0.0f;
                    continue;
                }
                bl2 = false;
            }
            if (bl2) {
                object = this.this$0;
                SolverVariable solverVariable = this.variable;
                PriorityGoalRow.access$000((PriorityGoalRow)object, solverVariable);
            }
            return false;
        }
        for (int i10 = 0; i10 < n11; ++i10) {
            object2 = ((SolverVariable)object).goalStrengthVector;
            reference var9_10 = object2[i10];
            reference cfr_temp_1 = var9_10 - 0.0f;
            Object object3 = cfr_temp_1 == 0 ? 0 : (cfr_temp_1 > 0 ? 1 : -1);
            if (object3 != false) {
                float f18 = Math.abs((float)(var9_10 *= f10));
                float f17 = f18 - f11;
                object3 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
                if (object3 < 0) {
                    n10 = 0;
                    object2 = null;
                    var9_10 = (reference)0.0f;
                }
                float[] fArray = this.variable.goalStrengthVector;
                fArray[i10] = (float)var9_10;
                continue;
            }
            object2 = this.variable.goalStrengthVector;
            object2[i10] = 0.0f;
        }
        return bl2;
    }

    public int compareTo(Object object) {
        object = (SolverVariable)object;
        int n10 = this.variable.id;
        int n11 = ((SolverVariable)object).id;
        return n10 - n11;
    }

    public void init(SolverVariable solverVariable) {
        this.variable = solverVariable;
    }

    public final boolean isNegative() {
        int n10 = 8;
        while (true) {
            int n11 = 0;
            if (n10 < 0) break;
            float[] fArray = this.variable.goalStrengthVector;
            float f10 = fArray[n10];
            float f11 = f10 - 0.0f;
            float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (f12 > 0) {
                return false;
            }
            float f13 = f10 - 0.0f;
            n11 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (n11 < 0) {
                return true;
            }
            n10 += -1;
        }
        return false;
    }

    public final boolean isNull() {
        int n10 = 0;
        while (true) {
            int n11 = 9;
            float f10 = 1.3E-44f;
            if (n10 >= n11) break;
            float[] fArray = this.variable.goalStrengthVector;
            f10 = fArray[n10];
            float f11 = f10 - 0.0f;
            n11 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (n11 != 0) {
                return false;
            }
            ++n10;
        }
        return true;
    }

    public final boolean isSmallerThan(SolverVariable solverVariable) {
        for (int i10 = 8; i10 >= 0; i10 += -1) {
            float[] fArray = this.variable.goalStrengthVector;
            float f10 = fArray[i10];
            float[] fArray2 = solverVariable.goalStrengthVector;
            float f11 = fArray2[i10];
            float f12 = f10 - f11;
            float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (f13 == false) {
                continue;
            }
            float f14 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
            if (f14 >= 0) break;
            return true;
        }
        return false;
    }

    public void reset() {
        Arrays.fill(this.variable.goalStrengthVector, 0.0f);
    }

    public String toString() {
        Object object = this.variable;
        Object object2 = "[ ";
        if (object != null) {
            int n10;
            object = null;
            for (int i10 = 0; i10 < (n10 = 9); ++i10) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                float f10 = this.variable.goalStrengthVector[i10];
                stringBuilder.append(f10);
                stringBuilder.append(" ");
                object2 = stringBuilder.toString();
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("] ");
        object2 = this.variable;
        ((StringBuilder)object).append(object2);
        return ((StringBuilder)object).toString();
    }
}

