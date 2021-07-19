/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayLinkedVariables;
import androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.LinearSystem$Row;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.SolverVariable$Type;
import java.util.ArrayList;

public class ArrayRow
implements LinearSystem$Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public float constantValue = 0.0f;
    public boolean isSimpleDefinition;
    public boolean used = false;
    public SolverVariable variable = null;
    public ArrayRow$ArrayRowVariables variables;
    public ArrayList variablesToUpdate;

    public ArrayRow() {
        ArrayList arrayList;
        this.variablesToUpdate = arrayList = new ArrayList();
        this.isSimpleDefinition = false;
    }

    public ArrayRow(Cache cache) {
        ArrayList arrayList;
        this.variablesToUpdate = arrayList = new ArrayList();
        this.isSimpleDefinition = false;
        ArrayLinkedVariables arrayLinkedVariables = new ArrayLinkedVariables(this, cache);
        this.variables = arrayLinkedVariables;
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        int n10 = solverVariable.usageInRowCount;
        int n11 = 1;
        if (n10 > n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private SolverVariable pickPivotInVariables(boolean[] blArray, SolverVariable solverVariable) {
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        int n10 = arrayRow$ArrayRowVariables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < n10; ++i10) {
            SolverVariable$Type solverVariable$Type;
            SolverVariable$Type solverVariable$Type2;
            int n11;
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables2 = this.variables;
            float f11 = arrayRow$ArrayRowVariables2.getVariableValue(i10);
            float f12 = f11 - 0.0f;
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object >= 0) continue;
            SolverVariable solverVariable3 = this.variables.getVariable(i10);
            if (blArray != null) {
                n11 = solverVariable3.id;
                if ((n11 = blArray[n11]) != 0) continue;
            }
            if (solverVariable3 == solverVariable || (solverVariable$Type2 = solverVariable3.mType) != (solverVariable$Type = SolverVariable$Type.SLACK) && solverVariable$Type2 != (solverVariable$Type = SolverVariable$Type.ERROR) || (n11 = (int)(f11 == f10 ? 0 : (f11 < f10 ? -1 : 1))) >= 0) continue;
            f10 = f11;
            solverVariable2 = solverVariable3;
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem object, int n10) {
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        SolverVariable solverVariable = ((LinearSystem)object).createErrorVariable(n10, "ep");
        arrayRow$ArrayRowVariables.put(solverVariable, 1.0f);
        arrayRow$ArrayRowVariables = this.variables;
        object = ((LinearSystem)object).createErrorVariable(n10, "em");
        arrayRow$ArrayRowVariables.put((SolverVariable)object, -1.0f);
        return this;
    }

    public void addError(SolverVariable solverVariable) {
        int n10 = solverVariable.strength;
        float f10 = 1.0f;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11) {
                f10 = 1000.0f;
            } else {
                n11 = 3;
                if (n10 == n11) {
                    f10 = 1000000.0f;
                } else {
                    n11 = 4;
                    if (n10 == n11) {
                        f10 = 1.0E9f;
                    } else {
                        n11 = 5;
                        if (n10 == n11) {
                            f10 = 1.0E12f;
                        }
                    }
                }
            }
        }
        this.variables.put(solverVariable, f10);
    }

    public ArrayRow addSingleError(SolverVariable solverVariable, int n10) {
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        float f10 = n10;
        arrayRow$ArrayRowVariables.put(solverVariable, f10);
        return this;
    }

    public boolean chooseSubject(LinearSystem object) {
        boolean bl2;
        object = this.chooseSubjectInVariables((LinearSystem)object);
        boolean bl3 = true;
        if (object == null) {
            bl2 = bl3;
        } else {
            this.pivot((SolverVariable)object);
            bl2 = false;
            object = null;
        }
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        int n10 = arrayRow$ArrayRowVariables.getCurrentSize();
        if (n10 == 0) {
            this.isSimpleDefinition = bl3;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        int n10 = arrayRow$ArrayRowVariables.getCurrentSize();
        boolean bl2 = false;
        SolverVariable solverVariable = null;
        boolean bl3 = false;
        boolean bl4 = false;
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean bl5 = false;
        SolverVariable solverVariable2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            boolean bl6;
            SolverVariable solverVariable3;
            float f12;
            block14: {
                block13: {
                    block12: {
                        float f13;
                        block8: {
                            block11: {
                                block10: {
                                    block9: {
                                        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables2 = this.variables;
                                        f12 = arrayRow$ArrayRowVariables2.getVariableValue(i10);
                                        solverVariable3 = this.variables.getVariable(i10);
                                        SolverVariable$Type solverVariable$Type = solverVariable3.mType;
                                        SolverVariable$Type solverVariable$Type2 = SolverVariable$Type.UNRESTRICTED;
                                        bl6 = true;
                                        if (solverVariable$Type != solverVariable$Type2) break block8;
                                        if (solverVariable != null) break block9;
                                        bl2 = this.isNew(solverVariable3, linearSystem);
                                        break block10;
                                    }
                                    object = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
                                    if (object <= 0) break block11;
                                    bl2 = this.isNew(solverVariable3, linearSystem);
                                }
                                bl3 = bl2;
                                f10 = f12;
                                solverVariable = solverVariable3;
                                continue;
                            }
                            if (bl3 || (object = (Object)this.isNew(solverVariable3, linearSystem)) == false) continue;
                            f10 = f12;
                            solverVariable = solverVariable3;
                            bl3 = bl6;
                            continue;
                        }
                        if (solverVariable != null || (object = (f13 = f12 - 0.0f) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) >= 0) continue;
                        if (solverVariable2 != null) break block12;
                        bl5 = this.isNew(solverVariable3, linearSystem);
                        break block13;
                    }
                    object = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1);
                    if (object <= 0) break block14;
                    bl5 = this.isNew(solverVariable3, linearSystem);
                }
                bl4 = bl5;
                f11 = f12;
                solverVariable2 = solverVariable3;
                continue;
            }
            if (bl4 || (object = (Object)this.isNew(solverVariable3, linearSystem)) == false) continue;
            f11 = f12;
            solverVariable2 = solverVariable3;
            bl4 = bl6;
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }

    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    public ArrayRow createRowCentering(SolverVariable object, SolverVariable solverVariable, int n10, float f10, SolverVariable solverVariable2, SolverVariable solverVariable3, int n11) {
        float f11 = 1.0f;
        if (solverVariable == solverVariable2) {
            this.variables.put((SolverVariable)object, f11);
            this.variables.put(solverVariable3, f11);
            this.variables.put(solverVariable, -2.0f);
            return this;
        }
        float f12 = 0.5f;
        Object object2 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        float f13 = -1.0f;
        if (object2 == false) {
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f11);
            this.variables.put(solverVariable, f13);
            this.variables.put(solverVariable2, f13);
            object = this.variables;
            object.put(solverVariable3, f11);
            if (n10 > 0 || n11 > 0) {
                float f14;
                int n12 = -n10 + n11;
                this.constantValue = f14 = (float)n12;
            }
        } else {
            f12 = 0.0f;
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = null;
            float f15 = f10 - 0.0f;
            object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                float f16;
                ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables2 = this.variables;
                arrayRow$ArrayRowVariables2.put((SolverVariable)object, f13);
                object = this.variables;
                object.put(solverVariable, f11);
                this.constantValue = f16 = (float)n10;
            } else {
                object2 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
                if (object2 >= 0) {
                    float f17;
                    this.variables.put(solverVariable3, f13);
                    object = this.variables;
                    object.put(solverVariable2, f11);
                    int n13 = -n11;
                    this.constantValue = f17 = (float)n13;
                } else {
                    arrayRow$ArrayRowVariables = this.variables;
                    float f18 = f11 - f10;
                    float f19 = f18 * f11;
                    arrayRow$ArrayRowVariables.put((SolverVariable)object, f19);
                    object = this.variables;
                    f12 = f18 * f13;
                    object.put(solverVariable, f12);
                    object = this.variables;
                    object.put(solverVariable2, f13 *= f10);
                    object = this.variables;
                    object.put(solverVariable3, f11 *= f10);
                    if (n10 > 0 || n11 > 0) {
                        int n14 = -n10;
                        float f20 = (float)n14 * f18;
                        float f21 = (float)n11 * f10;
                        this.constantValue = f20 += f21;
                    }
                }
            }
        }
        return this;
    }

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int n10) {
        float f10;
        this.variable = solverVariable;
        solverVariable.computedValue = f10 = (float)n10;
        this.constantValue = f10;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f10);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable object, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f10) {
        this.variables.put((SolverVariable)object, -1.0f);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, f10);
        object = this.variables;
        float f11 = -f10;
        object.put(solverVariable3, f11);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f10, float f11, float f12, SolverVariable solverVariable, int n10, SolverVariable solverVariable2, int n11, SolverVariable solverVariable3, int n12, SolverVariable solverVariable4, int n13) {
        float f13 = f11 - 0.0f;
        float f14 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        float f15 = -1.0f;
        float f16 = 1.0f;
        if (f14 != false && (f14 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1)) != false) {
            f10 /= f11;
            f10 /= (f12 /= f11);
            int n14 = -n10 - n11;
            f11 = n14;
            f12 = (float)n12 * f10;
            f11 += f12;
            f12 = (float)n13 * f10;
            this.constantValue = f11 += f12;
            this.variables.put(solverVariable, f16);
            this.variables.put(solverVariable2, f15);
            this.variables.put(solverVariable4, f10);
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            f10 = -f10;
            arrayRow$ArrayRowVariables.put(solverVariable3, f10);
        } else {
            int n15 = -n10 - n11 + n12 + n13;
            this.constantValue = f10 = (float)n15;
            this.variables.put(solverVariable, f16);
            this.variables.put(solverVariable2, f15);
            this.variables.put(solverVariable4, f16);
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put(solverVariable3, f15);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f10, float f11, float f12, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        Object object = false;
        this.constantValue = 0.0f;
        float f13 = f11 - 0.0f;
        Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        float f14 = -1.0f;
        float f15 = 1.0f;
        if (object2 != false && (object2 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1)) != false) {
            float f16 = f10 - 0.0f;
            object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object2 == false) {
                this.variables.put(solverVariable, f15);
                ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
                arrayRow$ArrayRowVariables.put(solverVariable2, f14);
            } else {
                float f17 = f12 - 0.0f;
                object = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
                if (!object) {
                    this.variables.put(solverVariable3, f15);
                    ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
                    arrayRow$ArrayRowVariables.put(solverVariable4, f14);
                } else {
                    f10 /= f11;
                    this.variables.put(solverVariable, f15);
                    this.variables.put(solverVariable2, f14);
                    this.variables.put(solverVariable4, f10 /= (f12 /= f11));
                    ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
                    f10 = -f10;
                    arrayRow$ArrayRowVariables.put(solverVariable3, f10);
                }
            }
        } else {
            this.variables.put(solverVariable, f15);
            this.variables.put(solverVariable2, f14);
            this.variables.put(solverVariable4, f15);
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put(solverVariable3, f14);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int n10) {
        if (n10 < 0) {
            float f10;
            this.constantValue = f10 = (float)(n10 *= -1);
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            float f11 = 1.0f;
            arrayRow$ArrayRowVariables.put(solverVariable, f11);
        } else {
            float f12;
            this.constantValue = f12 = (float)n10;
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            float f13 = -1.0f;
            arrayRow$ArrayRowVariables.put(solverVariable, f13);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable object, SolverVariable solverVariable, int n10) {
        float f10;
        boolean bl2 = false;
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = null;
        if (n10 != 0) {
            if (n10 < 0) {
                n10 *= -1;
                bl2 = true;
            }
            this.constantValue = f10 = (float)n10;
        }
        n10 = -1082130432;
        f10 = -1.0f;
        float f11 = 1.0f;
        if (!bl2) {
            arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f10);
            object = this.variables;
            object.put(solverVariable, f11);
        } else {
            arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f11);
            object = this.variables;
            object.put(solverVariable, f10);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int n10, SolverVariable solverVariable2) {
        float f10;
        this.constantValue = f10 = (float)n10;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable object, SolverVariable solverVariable, SolverVariable solverVariable2, int n10) {
        float f10;
        boolean bl2 = false;
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = null;
        if (n10 != 0) {
            if (n10 < 0) {
                n10 *= -1;
                bl2 = true;
            }
            this.constantValue = f10 = (float)n10;
        }
        n10 = -1082130432;
        f10 = -1.0f;
        float f11 = 1.0f;
        if (!bl2) {
            arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f10);
            this.variables.put(solverVariable, f11);
            object = this.variables;
            object.put(solverVariable2, f11);
        } else {
            arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f11);
            this.variables.put(solverVariable, f10);
            object = this.variables;
            object.put(solverVariable2, f10);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable object, SolverVariable solverVariable, SolverVariable solverVariable2, int n10) {
        float f10;
        boolean bl2 = false;
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = null;
        if (n10 != 0) {
            if (n10 < 0) {
                n10 *= -1;
                bl2 = true;
            }
            this.constantValue = f10 = (float)n10;
        }
        n10 = -1082130432;
        f10 = -1.0f;
        float f11 = 1.0f;
        if (!bl2) {
            arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f10);
            this.variables.put(solverVariable, f11);
            object = this.variables;
            object.put(solverVariable2, f10);
        } else {
            arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f11);
            this.variables.put(solverVariable, f10);
            object = this.variables;
            object.put(solverVariable2, f11);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable object, SolverVariable solverVariable3, float f10) {
        float f11;
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        float f12 = 0.5f;
        arrayRow$ArrayRowVariables.put((SolverVariable)object, f12);
        this.variables.put(solverVariable3, f12);
        object = this.variables;
        float f13 = -0.5f;
        object.put(solverVariable, f13);
        this.variables.put(solverVariable2, f13);
        this.constantValue = f11 = -f10;
        return this;
    }

    public void ensurePositiveConstant() {
        float f10 = this.constantValue;
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = -1082130432;
            f11 = -1.0f;
            this.constantValue = f10 *= f11;
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.invert();
        }
    }

    public SolverVariable getKey() {
        return this.variable;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] blArray) {
        return this.pickPivotInVariables(blArray, null);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean hasKeyVariable() {
        void var4_9;
        block2: {
            block3: {
                SolverVariable solverVariable = this.variable;
                if (solverVariable == null) break block2;
                SolverVariable$Type solverVariable$Type = solverVariable.mType;
                SolverVariable$Type solverVariable$Type2 = SolverVariable$Type.UNRESTRICTED;
                if (solverVariable$Type == solverVariable$Type2) break block3;
                float f10 = this.constantValue;
                solverVariable$Type2 = null;
                float f11 = f10 - 0.0f;
                Object object = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
                if (object < 0) break block2;
            }
            boolean bl2 = true;
            return (boolean)var4_9;
        }
        boolean bl3 = false;
        return (boolean)var4_9;
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    public void initFromRow(LinearSystem$Row linearSystem$Row) {
        int n10 = linearSystem$Row instanceof ArrayRow;
        if (n10 != 0) {
            Object object;
            int n11;
            linearSystem$Row = (ArrayRow)linearSystem$Row;
            this.variable = null;
            this.variables.clear();
            for (n10 = 0; n10 < (n11 = (object = ((ArrayRow)linearSystem$Row).variables).getCurrentSize()); ++n10) {
                object = ((ArrayRow)linearSystem$Row).variables.getVariable(n10);
                ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = ((ArrayRow)linearSystem$Row).variables;
                float f10 = arrayRow$ArrayRowVariables.getVariableValue(n10);
                ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables2 = this.variables;
                boolean bl2 = true;
                arrayRow$ArrayRowVariables2.add((SolverVariable)object, f10, bl2);
            }
        }
    }

    public boolean isEmpty() {
        float f10;
        float f11;
        int n10;
        Object object = this.variable;
        if (object == null && (n10 = (f11 = (f10 = this.constantValue) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) == 0 && (n10 = (object = this.variables).getCurrentSize()) == 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
            object = null;
        }
        return n10 != 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return this.pickPivotInVariables(null, solverVariable);
    }

    public void pivot(SolverVariable solverVariable) {
        float f10;
        int n10;
        Object object = this.variable;
        float f11 = -1.0f;
        if (object != null) {
            ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
            arrayRow$ArrayRowVariables.put((SolverVariable)object, f11);
            object = this.variable;
            ((SolverVariable)object).definitionId = n10 = -1;
            f10 = 0.0f;
            object = null;
            this.variable = null;
        }
        object = this.variables;
        n10 = 1;
        f10 = object.remove(solverVariable, n10 != 0) * f11;
        this.variable = solverVariable;
        float f12 = 1.0f;
        float f13 = f10 - f12;
        Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object2 == false) {
            return;
        }
        this.constantValue = f12 = this.constantValue / f10;
        this.variables.divideByAmount(f10);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    public int sizeInBytes() {
        int n10;
        SolverVariable solverVariable = this.variable;
        int n11 = 4;
        if (solverVariable != null) {
            n10 = n11;
        } else {
            n10 = 0;
            solverVariable = null;
        }
        n10 = n10 + n11 + n11;
        n11 = this.variables.sizeInBytes();
        return n10 + n11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String toReadableString() {
        var1_1 = this.variable;
        var2_2 = "";
        if (var1_1 == null) {
            var1_1 = new StringBuilder();
            var1_1.append((String)var2_2);
            var2_2 = "0";
            var1_1.append((String)var2_2);
            var1_1 = var1_1.toString();
        } else {
            var1_1 = new StringBuilder();
            var1_1.append((String)var2_2);
            var2_2 = this.variable;
            var1_1.append(var2_2);
            var1_1 = var1_1.toString();
        }
        var2_2 = new StringBuilder();
        var2_2.append((String)var1_1);
        var2_2.append(" = ");
        var1_1 = var2_2.toString();
        var3_3 = this.constantValue;
        cfr_temp_0 = var3_3 - 0.0f;
        var4_4 /* !! */  = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
        var5_5 = 0;
        var6_6 = true;
        var7_7 = 1.4E-45f;
        if (var4_4 /* !! */  != false) {
            var2_2 = new StringBuilder();
            var2_2.append((String)var1_1);
            var8_8 = this.constantValue;
            var2_2.append(var8_8);
            var1_1 = var2_2.toString();
            var4_4 /* !! */  = (float)var6_6;
            var3_3 = var7_7;
        } else {
            var4_4 /* !! */  = (float)false;
            var2_2 = null;
            var3_3 = 0.0f;
        }
        var9_9 = this.variables;
        var10_10 = var9_9.getCurrentSize();
        while (var5_5 < var10_10) {
            block10: {
                block12: {
                    block11: {
                        var11_11 = this.variables.getVariable(var5_5);
                        if (var11_11 == null || (var14_14 = (cfr_temp_1 = (var13_13 = (var12_12 = this.variables).getVariableValue(var5_5)) - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1)) == false) break block10;
                        var11_11 = var11_11.toString();
                        var15_15 = -1.0f;
                        if (var4_4 /* !! */  != false) break block11;
                        cfr_temp_2 = var13_13 - 0.0f;
                        var4_4 /* !! */  = (float)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1));
                        if (var4_4 /* !! */  >= 0) break block12;
                        var2_2 = new StringBuilder();
                        var2_2.append((String)var1_1);
                        var2_2.append("- ");
                        var1_1 = var2_2.toString();
                        ** GOTO lbl78
                    }
                    if (var14_14 > 0) {
                        var2_2 = new StringBuilder();
                        var2_2.append((String)var1_1);
                        var2_2.append(" + ");
                        var1_1 = var2_2.toString();
                    } else {
                        var2_2 = new StringBuilder();
                        var2_2.append((String)var1_1);
                        var2_2.append(" - ");
                        var1_1 = var2_2.toString();
lbl78:
                        // 2 sources

                        var13_13 *= var15_15;
                    }
                }
                if ((var4_4 /* !! */  = (cfr_temp_3 = var13_13 - (var3_3 = 1.0f)) == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1)) == false) {
                    var2_2 = new StringBuilder();
                    var2_2.append((String)var1_1);
                    var2_2.append((String)var11_11);
                    var1_1 = var2_2.toString();
                } else {
                    var2_2 = new StringBuilder();
                    var2_2.append((String)var1_1);
                    var2_2.append(var13_13);
                    var2_2.append(" ");
                    var2_2.append((String)var11_11);
                    var1_1 = var2_2.toString();
                }
                var4_4 /* !! */  = (float)var6_6;
                var3_3 = var7_7;
            }
            ++var5_5;
        }
        if (var4_4 /* !! */  == false) {
            var2_2 = new StringBuilder();
            var2_2.append((String)var1_1);
            var2_2.append("0.0");
            var1_1 = var2_2.toString();
        }
        return var1_1;
    }

    public String toString() {
        return this.toReadableString();
    }

    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable object, boolean bl2) {
        int n10;
        boolean bl3 = ((SolverVariable)object).isFinalValue;
        if (!bl3) {
            return;
        }
        float f10 = this.variables.get((SolverVariable)object);
        float f11 = this.constantValue;
        float f12 = ((SolverVariable)object).computedValue * f10;
        this.constantValue = f11 += f12;
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        arrayRow$ArrayRowVariables.remove((SolverVariable)object, bl2);
        if (bl2) {
            ((SolverVariable)object).removeFromRow(this);
        }
        if ((bl2 = LinearSystem.SIMPLIFY_SYNONYMS) && object != null && (n10 = (object = this.variables).getCurrentSize()) == 0) {
            n10 = 1;
            this.isSimpleDefinition = n10;
            linearSystem.hasSimpleDefinition = n10;
        }
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow object, boolean bl2) {
        int n10;
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        float f10 = arrayRow$ArrayRowVariables.use((ArrayRow)object, bl2);
        float f11 = this.constantValue;
        float f12 = ((ArrayRow)object).constantValue * f10;
        this.constantValue = f11 += f12;
        if (bl2) {
            object = ((ArrayRow)object).variable;
            ((SolverVariable)object).removeFromRow(this);
        }
        if ((n10 = LinearSystem.SIMPLIFY_SYNONYMS) != 0 && (object = this.variable) != null && (n10 = (object = this.variables).getCurrentSize()) == 0) {
            n10 = 1;
            this.isSimpleDefinition = n10;
            linearSystem.hasSimpleDefinition = n10;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable object, boolean bl2) {
        int n10;
        boolean bl3 = ((SolverVariable)object).isSynonym;
        if (!bl3) {
            return;
        }
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables = this.variables;
        float f10 = arrayRow$ArrayRowVariables.get((SolverVariable)object);
        float f11 = this.constantValue;
        float f12 = ((SolverVariable)object).synonymDelta * f10;
        this.constantValue = f11 += f12;
        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables2 = this.variables;
        arrayRow$ArrayRowVariables2.remove((SolverVariable)object, bl2);
        if (bl2) {
            ((SolverVariable)object).removeFromRow(this);
        }
        arrayRow$ArrayRowVariables2 = this.variables;
        Object object2 = linearSystem.mCache.mIndexedVariables;
        int n11 = ((SolverVariable)object).synonym;
        object2 = object2[n11];
        arrayRow$ArrayRowVariables2.add((SolverVariable)object2, f10, bl2);
        bl2 = LinearSystem.SIMPLIFY_SYNONYMS;
        if (bl2 && object != null && (n10 = (object = this.variables).getCurrentSize()) == 0) {
            n10 = 1;
            this.isSimpleDefinition = n10;
            linearSystem.hasSimpleDefinition = n10;
        }
    }

    public void updateFromSystem(LinearSystem linearSystem) {
        boolean bl2;
        Object object = linearSystem.mRows;
        int n10 = ((ArrayRow[])object).length;
        if (n10 == 0) {
            return;
        }
        n10 = 0;
        object = null;
        boolean bl3 = false;
        while (true) {
            ArrayRow[] arrayRowArray;
            int n11;
            Object object2;
            int n12;
            bl2 = true;
            if (bl3) break;
            Object object3 = this.variables;
            int n13 = object3.getCurrentSize();
            for (n12 = 0; n12 < n13; ++n12) {
                object2 = this.variables.getVariable(n12);
                n11 = ((SolverVariable)object2).definitionId;
                int n14 = -1;
                if (n11 == n14 && (n11 = (int)(((SolverVariable)object2).isFinalValue ? 1 : 0)) == 0 && (n11 = (int)(((SolverVariable)object2).isSynonym ? 1 : 0)) == 0) continue;
                arrayRowArray = this.variablesToUpdate;
                arrayRowArray.add(object2);
            }
            object3 = this.variablesToUpdate;
            n13 = ((ArrayList)object3).size();
            if (n13 > 0) {
                for (n12 = 0; n12 < n13; ++n12) {
                    object2 = (SolverVariable)this.variablesToUpdate.get(n12);
                    n11 = (int)(((SolverVariable)object2).isFinalValue ? 1 : 0);
                    if (n11 != 0) {
                        this.updateFromFinalVariable(linearSystem, (SolverVariable)object2, bl2);
                        continue;
                    }
                    n11 = (int)(((SolverVariable)object2).isSynonym ? 1 : 0);
                    if (n11 != 0) {
                        this.updateFromSynonymVariable(linearSystem, (SolverVariable)object2, bl2);
                        continue;
                    }
                    arrayRowArray = linearSystem.mRows;
                    int n15 = ((SolverVariable)object2).definitionId;
                    object2 = arrayRowArray[n15];
                    this.updateFromRow(linearSystem, (ArrayRow)object2, bl2);
                }
                ArrayList arrayList = this.variablesToUpdate;
                arrayList.clear();
                continue;
            }
            bl3 = bl2;
        }
        n10 = (int)(LinearSystem.SIMPLIFY_SYNONYMS ? 1 : 0);
        if (n10 != 0 && (object = this.variable) != null && (n10 = (object = this.variables).getCurrentSize()) == 0) {
            this.isSimpleDefinition = bl2;
            linearSystem.hasSimpleDefinition = bl2;
        }
    }
}

