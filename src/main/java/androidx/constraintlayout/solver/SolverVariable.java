/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable$1;
import androidx.constraintlayout.solver.SolverVariable$Type;
import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    public static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    public int definitionId;
    public float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    public HashSet inRows;
    public boolean isFinalValue;
    public boolean isSynonym;
    public ArrayRow[] mClientEquations;
    public int mClientEquationsCount;
    private String mName;
    public SolverVariable$Type mType;
    public int strength;
    public float[] strengthVector;
    public int synonym;
    public float synonymDelta;
    public int usageInRowCount;

    public SolverVariable(SolverVariable$Type solverVariable$Type, String string2) {
        int n10;
        this.id = n10 = -1;
        this.definitionId = n10;
        this.strength = 0;
        this.isFinalValue = false;
        int n11 = 9;
        float[] fArray = new float[n11];
        this.strengthVector = fArray;
        Object[] objectArray = new float[n11];
        this.goalStrengthVector = objectArray;
        objectArray = new ArrayRow[16];
        this.mClientEquations = (ArrayRow[])objectArray;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = n10;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = solverVariable$Type;
    }

    public SolverVariable(String string2, SolverVariable$Type solverVariable$Type) {
        int n10;
        this.id = n10 = -1;
        this.definitionId = n10;
        this.strength = 0;
        this.isFinalValue = false;
        int n11 = 9;
        float[] fArray = new float[n11];
        this.strengthVector = fArray;
        Object[] objectArray = new float[n11];
        this.goalStrengthVector = objectArray;
        objectArray = new ArrayRow[16];
        this.mClientEquations = (ArrayRow[])objectArray;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = n10;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = string2;
        this.mType = solverVariable$Type;
    }

    private static String getUniqueName(SolverVariable$Type object, String object2) {
        if (object2 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            int n10 = uniqueErrorId;
            ((StringBuilder)object).append(n10);
            return ((StringBuilder)object).toString();
        }
        object2 = SolverVariable$1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;
        int n11 = ((Enum)object).ordinal();
        Object object3 = object2[n11];
        if (object3 != (n11 = 1)) {
            int n12 = 2;
            if (object3 != n12) {
                n12 = 3;
                if (object3 != n12) {
                    n12 = 4;
                    if (object3 != n12) {
                        n12 = 5;
                        if (object3 == n12) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("V");
                            object3 = uniqueId + n11;
                            uniqueId = (int)object3;
                            ((StringBuilder)object).append((int)object3);
                            return ((StringBuilder)object).toString();
                        }
                        object = ((Enum)object).name();
                        object2 = new AssertionError(object);
                        throw object2;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("e");
                    object3 = uniqueErrorId + n11;
                    uniqueErrorId = (int)object3;
                    ((StringBuilder)object).append((int)object3);
                    return ((StringBuilder)object).toString();
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("S");
                object3 = uniqueSlackId + n11;
                uniqueSlackId = (int)object3;
                ((StringBuilder)object).append((int)object3);
                return ((StringBuilder)object).toString();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("C");
            object3 = uniqueConstantId + n11;
            uniqueConstantId = (int)object3;
            ((StringBuilder)object).append((int)object3);
            return ((StringBuilder)object).toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("U");
        object3 = uniqueUnrestrictedId + n11;
        uniqueUnrestrictedId = (int)object3;
        ((StringBuilder)object).append((int)object3);
        return ((StringBuilder)object).toString();
    }

    public static void increaseErrorId() {
        ++uniqueErrorId;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int n10;
        ArrayRow[] arrayRowArray = null;
        for (int i10 = 0; i10 < (n10 = this.mClientEquationsCount); ++i10) {
            ArrayRow arrayRow2 = this.mClientEquations[i10];
            if (arrayRow2 != arrayRow) continue;
            return;
        }
        arrayRowArray = this.mClientEquations;
        int n11 = arrayRowArray.length;
        if (n10 >= n11) {
            n10 = arrayRowArray.length * 2;
            this.mClientEquations = arrayRowArray = Arrays.copyOf(arrayRowArray, n10);
        }
        arrayRowArray = this.mClientEquations;
        n10 = this.mClientEquationsCount;
        arrayRowArray[n10] = arrayRow;
        this.mClientEquationsCount = ++n10;
    }

    public void clearStrengths() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 9); ++i10) {
            float[] fArray = this.strengthVector;
            fArray[i10] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRowArray) {
        int n10 = this.mClientEquationsCount;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            ArrayRow arrayRow = this.mClientEquations[i10];
            if (arrayRow != arrayRowArray) continue;
            while (i10 < (n11 = n10 + -1)) {
                ArrayRow arrayRow2;
                arrayRowArray = this.mClientEquations;
                int n12 = i10 + 1;
                arrayRowArray[i10] = arrayRow2 = arrayRowArray[n12];
                i10 = n12;
            }
            this.mClientEquationsCount = n11 = this.mClientEquationsCount + -1;
            return;
        }
    }

    public void reset() {
        int n10;
        SolverVariable$Type solverVariable$Type;
        this.mName = null;
        this.mType = solverVariable$Type = SolverVariable$Type.UNKNOWN;
        solverVariable$Type = null;
        this.strength = 0;
        this.id = n10 = -1;
        this.definitionId = n10;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = n10;
        this.synonymDelta = 0.0f;
        n10 = this.mClientEquationsCount;
        for (int i10 = 0; i10 < n10; ++i10) {
            ArrayRow[] arrayRowArray = this.mClientEquations;
            arrayRowArray[i10] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f10) {
        int n10;
        this.computedValue = f10;
        this.isFinalValue = true;
        f10 = 0.0f;
        this.isSynonym = false;
        this.synonym = n10 = -1;
        this.synonymDelta = 0.0f;
        int n11 = this.mClientEquationsCount;
        this.definitionId = n10;
        for (n10 = 0; n10 < n11; ++n10) {
            ArrayRow arrayRow = this.mClientEquations[n10];
            arrayRow.updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String string2) {
        this.mName = string2;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f10) {
        int n10;
        this.isSynonym = true;
        this.synonym = n10 = solverVariable.id;
        this.synonymDelta = f10;
        n10 = this.mClientEquationsCount;
        this.definitionId = -1;
        f10 = 0.0f;
        for (int i10 = 0; i10 < n10; ++i10) {
            ArrayRow arrayRow = this.mClientEquations[i10];
            arrayRow.updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(SolverVariable$Type solverVariable$Type, String string2) {
        this.mType = solverVariable$Type;
    }

    public String strengthsToString() {
        Object object;
        int n10;
        int n11;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(this);
        CharSequence charSequence2 = "[";
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        int n12 = n11 = 1;
        int n13 = 0;
        for (int i10 = 0; i10 < (n10 = ((float[])(object = this.strengthVector)).length); ++i10) {
            object = new StringBuilder;
            ((StringBuilder)object)();
            ((StringBuilder)object).append((String)charSequence);
            float f10 = this.strengthVector[i10];
            ((StringBuilder)object).append(f10);
            charSequence = ((StringBuilder)object).toString();
            object = this.strengthVector;
            float f11 = object[i10];
            float f12 = f11 - 0.0f;
            float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (f13 > 0) {
                n13 = 0;
            } else {
                f11 = object[i10];
                float f14 = f11 - 0.0f;
                f13 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                if (f13 < 0) {
                    n13 = n11;
                }
            }
            f11 = object[i10];
            float f15 = f11 - 0.0f;
            f13 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (f13 != false) {
                n12 = 0;
            }
            if (i10 < (n10 = ((float[])object).length - n11)) {
                object = new StringBuilder;
                ((StringBuilder)object)();
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(", ");
                charSequence = ((StringBuilder)object).toString();
                continue;
            }
            object = new StringBuilder;
            ((StringBuilder)object)();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append("] ");
            charSequence = ((StringBuilder)object).toString();
        }
        if (n13 != 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(" (-)");
            charSequence = ((StringBuilder)charSequence2).toString();
        }
        if (n12 != 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(" (*)");
            charSequence = ((StringBuilder)charSequence2).toString();
        }
        return charSequence;
    }

    public String toString() {
        CharSequence charSequence = this.mName;
        String string2 = "";
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            string2 = this.mName;
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            int n10 = this.id;
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int n10 = this.mClientEquationsCount;
        for (int i10 = 0; i10 < n10; ++i10) {
            ArrayRow arrayRow2 = this.mClientEquations[i10];
            arrayRow2.updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}

