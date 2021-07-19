/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem$Row;
import androidx.constraintlayout.solver.LinearSystem$ValuesRow;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.Pools$Pool;
import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.SolverVariable$Type;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0L;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0L;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition = false;
    private boolean[] mAlreadyTestedCandidates;
    public final Cache mCache;
    private LinearSystem$Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    public int mNumColumns;
    public int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    public ArrayRow[] mRows;
    private LinearSystem$Row mTempGoal;
    private HashMap mVariables = null;
    public int mVariablesID = 0;
    public boolean newgraphOptimizer;

    public LinearSystem() {
        int n10;
        this.TABLE_SIZE = n10 = 32;
        this.mMaxColumns = n10;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        Object object = new boolean[n10];
        this.mAlreadyTestedCandidates = object;
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = n10;
        object = new SolverVariable[POOL_SIZE];
        this.mPoolVariables = (SolverVariable[])object;
        this.mPoolVariablesCount = 0;
        Object object2 = new ArrayRow[n10];
        this.mRows = object2;
        this.releaseRows();
        this.mCache = object2;
        object = new PriorityGoalRow;
        super((Cache)object2);
        this.mGoal = object;
        boolean bl2 = OPTIMIZED_ENGINE;
        if (bl2) {
            object = new LinearSystem$ValuesRow;
            super(this, (Cache)object2);
            this.mTempGoal = object;
        } else {
            object = new ArrayRow;
            super((Cache)object2);
            this.mTempGoal = object;
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable$Type solverVariableArray, String string2) {
        int n10;
        SolverVariable solverVariable = (SolverVariable)this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable((SolverVariable$Type)solverVariableArray, string2);
            solverVariable.setType((SolverVariable$Type)solverVariableArray, string2);
        } else {
            solverVariable.reset();
            solverVariable.setType((SolverVariable$Type)solverVariableArray, string2);
        }
        int n11 = this.mPoolVariablesCount;
        int n12 = POOL_SIZE;
        if (n11 >= n12) {
            POOL_SIZE = n12 *= 2;
            this.mPoolVariables = solverVariableArray = Arrays.copyOf(this.mPoolVariables, n12);
        }
        solverVariableArray = this.mPoolVariables;
        n12 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = n10 = n12 + 1;
        solverVariableArray[n12] = solverVariable;
        return solverVariable;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        int n10;
        float f10;
        Object object;
        int n11 = SIMPLIFY_SYNONYMS;
        if (n11 != 0 && (n11 = arrayRow.isSimpleDefinition) != 0) {
            object = arrayRow.variable;
            f10 = arrayRow.constantValue;
            ((SolverVariable)object).setFinalValue(this, f10);
        } else {
            object = this.mRows;
            n10 = this.mNumRows;
            object[n10] = arrayRow;
            object = arrayRow.variable;
            ((SolverVariable)object).definitionId = n10++;
            this.mNumRows = n10;
            ((SolverVariable)object).updateReferencesWithNewDefinition(this, arrayRow);
        }
        boolean bl2 = SIMPLIFY_SYNONYMS;
        if (bl2 && (bl2 = this.hasSimpleDefinition)) {
            bl2 = false;
            f10 = 0.0f;
            arrayRow = null;
            object = null;
            for (n11 = 0; n11 < (n10 = this.mNumRows); ++n11) {
                int n12;
                Object object2;
                Object object3 = this.mRows[n11];
                if (object3 == null) {
                    object3 = System.out;
                    object2 = "WTF";
                    object3.println((String)object2);
                }
                if ((object2 = (object3 = this.mRows)[n11]) == null) continue;
                object2 = object3[n11];
                boolean bl3 = ((ArrayRow)object2).isSimpleDefinition;
                if (!bl3) continue;
                object3 = object3[n11];
                object2 = object3.variable;
                float f11 = object3.constantValue;
                ((SolverVariable)object2).setFinalValue(this, f11);
                bl3 = OPTIMIZED_ENGINE;
                if (bl3) {
                    object2 = this.mCache.optimizedArrayRowPool;
                    object2.release(object3);
                } else {
                    object2 = this.mCache.arrayRowPool;
                    object2.release(object3);
                }
                object3 = this.mRows;
                bl3 = false;
                object2 = null;
                object3[n11] = null;
                int n13 = n10 = n11 + 1;
                while (n10 < (n12 = this.mNumRows)) {
                    Object object4 = this.mRows;
                    n12 = n10 + -1;
                    Object object5 = object4[n10];
                    object4[n12] = object5;
                    object5 = object4[n12].variable;
                    int n14 = ((SolverVariable)object5).definitionId;
                    if (n14 == n10) {
                        object4 = object4[n12].variable;
                        object4.definitionId = n12;
                    }
                    int n15 = n10 + 1;
                    n13 = n10;
                    n10 = n15;
                }
                if (n13 < n12) {
                    object3 = this.mRows;
                    object3[n13] = null;
                }
                this.mNumRows = n12 += -1;
                n11 += -1;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void addSingleError(ArrayRow arrayRow, int n10) {
        this.addSingleError(arrayRow, n10, 0);
    }

    private void computeValues() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.mNumRows); ++i10) {
            float f10;
            ArrayRow arrayRow = this.mRows[i10];
            SolverVariable solverVariable = arrayRow.variable;
            solverVariable.computedValue = f10 = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f10);
    }

    private SolverVariable createVariable(String solverVariableArray, SolverVariable$Type object) {
        int n10;
        int n11;
        Object object2 = sMetrics;
        if (object2 != null) {
            long l10 = ((Metrics)object2).variables;
            long l11 = 1L;
            ((Metrics)object2).variables = l10 += l11;
        }
        if ((n11 = this.mNumColumns + 1) >= (n10 = this.mMaxColumns)) {
            this.increaseTableSize();
        }
        object = this.acquireSolverVariable((SolverVariable$Type)((Object)object), null);
        ((SolverVariable)object).setName((String)solverVariableArray);
        this.mVariablesID = n11 = this.mVariablesID + 1;
        this.mNumColumns = n10 = this.mNumColumns + 1;
        ((SolverVariable)object).id = n11;
        object2 = this.mVariables;
        if (object2 == null) {
            this.mVariables = object2 = new Object();
        }
        this.mVariables.put(solverVariableArray, object);
        solverVariableArray = this.mCache.mIndexedVariables;
        n11 = this.mVariablesID;
        solverVariableArray[n11] = object;
        return object;
    }

    private void displayRows() {
        String string2;
        this.displaySolverVariables();
        Object object = "";
        int n10 = 0;
        StringBuilder stringBuilder = null;
        while (true) {
            int n11 = this.mNumRows;
            string2 = "\n";
            if (n10 >= n11) break;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String)object);
            object = this.mRows[n10];
            stringBuilder2.append(object);
            object = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String)object);
            stringBuilder2.append(string2);
            object = stringBuilder2.toString();
            ++n10;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        object = this.mGoal;
        stringBuilder.append(object);
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        System.out.println((String)object);
    }

    private void displaySolverVariables() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Display Rows (");
        int n10 = this.mNumRows;
        charSequence.append(n10);
        charSequence.append("x");
        n10 = this.mNumColumns;
        charSequence.append(n10);
        charSequence.append(")\n");
        charSequence = charSequence.toString();
        System.out.println((String)charSequence);
    }

    private int enforceBFS(LinearSystem$Row linearSystem$Row) {
        int n10;
        float f10;
        Object object;
        Object object2;
        Object object3;
        int n11;
        int n12;
        LinearSystem linearSystem;
        block19: {
            linearSystem = this;
            for (n12 = 0; n12 < (n11 = linearSystem.mNumRows); ++n12) {
                object3 = linearSystem.mRows;
                object2 = object3[n12].variable.mType;
                object = SolverVariable$Type.UNRESTRICTED;
                if (object2 == object) continue;
                object3 = object3[n12];
                f10 = object3.constantValue;
                float f11 = f10 - 0.0f;
                n11 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
                if (n11 >= 0) continue;
                n12 = 1;
                break block19;
            }
            n12 = 0;
        }
        if (n12 != 0) {
            n12 = 0;
            n11 = 0;
            f10 = 0.0f;
            object3 = null;
            while (n12 == 0) {
                Object object4;
                float f12;
                Object object5;
                int n13;
                object2 = sMetrics;
                long l10 = 1L;
                if (object2 != null) {
                    long l11;
                    ((Metrics)object2).bfs = l11 = ((Metrics)object2).bfs + l10;
                }
                ++n11;
                float f13 = Float.MAX_VALUE;
                int n14 = -1;
                int n15 = -1;
                int n16 = 0;
                for (int i10 = 0; i10 < (n13 = linearSystem.mNumRows); ++i10) {
                    float f14;
                    ArrayRow arrayRow = linearSystem.mRows[i10];
                    Object object6 = arrayRow.variable.mType;
                    object5 = SolverVariable$Type.UNRESTRICTED;
                    if (object6 != object5 && (n10 = (int)(arrayRow.isSimpleDefinition ? 1 : 0)) == 0 && (n10 = (int)((f14 = (f12 = arrayRow.constantValue) - 0.0f) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1))) < 0) {
                        int n17;
                        float f15;
                        ArrayRow$ArrayRowVariables arrayRow$ArrayRowVariables;
                        int n18;
                        n10 = SKIP_COLUMNS ? 1 : 0;
                        int n19 = 9;
                        float f16 = 1.3E-44f;
                        if (n10 != 0) {
                            object5 = arrayRow.variables;
                            n10 = object5.getCurrentSize();
                            object4 = null;
                            for (n18 = 0; n18 < n10; ++n18) {
                                arrayRow$ArrayRowVariables = arrayRow.variables;
                                object = arrayRow.variables.getVariable(n18);
                                f15 = arrayRow$ArrayRowVariables.get((SolverVariable)object);
                                float f17 = f15 - 0.0f;
                                float f18 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
                                if (f18 > 0) {
                                    for (n17 = 0; n17 < n19; ++n17) {
                                        object6 = ((SolverVariable)object).strengthVector;
                                        f16 = (float)(object6[n17] / f15);
                                        float f19 = f16 - f13;
                                        float f20 = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
                                        if (f20 < 0 && n17 == n16 || n17 > n16) {
                                            n15 = ((SolverVariable)object).id;
                                            n16 = n17;
                                            n14 = i10;
                                            f13 = f16;
                                        }
                                        n19 = 9;
                                        f16 = 1.3E-44f;
                                    }
                                }
                                l10 = 1L;
                                n19 = 9;
                                f16 = 1.3E-44f;
                            }
                        } else {
                            f12 = Float.MIN_VALUE;
                            for (n10 = 1; n10 < (n18 = linearSystem.mNumColumns); ++n10) {
                                object = arrayRow.variables;
                                object4 = linearSystem.mCache.mIndexedVariables[n10];
                                float f21 = object.get((SolverVariable)object4);
                                float f22 = f21 - 0.0f;
                                float f23 = f22 == 0.0f ? 0 : (f22 < 0.0f ? -1 : 1);
                                if (f23 <= 0) {
                                    n17 = 9;
                                    continue;
                                }
                                f15 = 0.0f;
                                arrayRow$ArrayRowVariables = null;
                                n17 = 9;
                                for (f23 = 0.0f; f23 < n17; ++f23) {
                                    object6 = ((SolverVariable)object4).strengthVector;
                                    f16 = (float)(object6[f23] / f21);
                                    float f24 = f16 - f13;
                                    float f25 = f24 == 0.0f ? 0 : (f24 < 0.0f ? -1 : 1);
                                    if ((f25 >= 0 || f23 != n16) && f23 <= n16) continue;
                                    n15 = n10;
                                    n16 = (int)f23;
                                    n14 = i10;
                                    f13 = f16;
                                }
                            }
                        }
                    }
                    l10 = 1L;
                }
                n10 = -1;
                f12 = 0.0f / 0.0f;
                if (n14 != n10) {
                    object4 = linearSystem.mRows[n14];
                    object2 = ((ArrayRow)object4).variable;
                    ((SolverVariable)object2).definitionId = n10;
                    object5 = sMetrics;
                    if (object5 != null) {
                        long l12 = ((Metrics)object5).pivots;
                        long l13 = 1L;
                        ((Metrics)object5).pivots = l12 += l13;
                    }
                    object5 = linearSystem.mCache.mIndexedVariables[n15];
                    ((ArrayRow)object4).pivot((SolverVariable)object5);
                    object5 = ((ArrayRow)object4).variable;
                    ((SolverVariable)object5).definitionId = n14;
                    ((SolverVariable)object5).updateReferencesWithNewDefinition(linearSystem, (ArrayRow)object4);
                } else {
                    n12 = 1;
                }
                if (n11 <= (n10 = linearSystem.mNumColumns / 2)) continue;
                n12 = 1;
            }
            n10 = n11;
        } else {
            n10 = 0;
            float f26 = 0.0f;
            Object var21_20 = null;
        }
        return n10;
    }

    private String getDisplaySize(int n10) {
        int n11 = (n10 *= 4) / 1024;
        int n12 = n11 / 1024;
        String string2 = "";
        if (n12 > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(n12);
            stringBuilder.append(" Mb");
            return stringBuilder.toString();
        }
        if (n11 > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(n11);
            stringBuilder.append(" Kb");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append(" bytes");
        return stringBuilder.toString();
    }

    private String getDisplayStrength(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            return "LOW";
        }
        n11 = 2;
        if (n10 == n11) {
            return "MEDIUM";
        }
        n11 = 3;
        if (n10 == n11) {
            return "HIGH";
        }
        n11 = 4;
        if (n10 == n11) {
            return "HIGHEST";
        }
        n11 = 5;
        if (n10 == n11) {
            return "EQUALITY";
        }
        n11 = 8;
        if (n10 == n11) {
            return "FIXED";
        }
        n11 = 6;
        if (n10 == n11) {
            return "BARRIER";
        }
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int n10;
        this.TABLE_SIZE = n10 = this.TABLE_SIZE * 2;
        Object object = Arrays.copyOf(this.mRows, n10);
        this.mRows = object;
        object = this.mCache;
        Object object2 = object.mIndexedVariables;
        int n11 = this.TABLE_SIZE;
        object.mIndexedVariables = object2 = Arrays.copyOf(object2, n11);
        n10 = this.TABLE_SIZE;
        object2 = new boolean[n10];
        this.mAlreadyTestedCandidates = (boolean[])object2;
        this.mMaxColumns = n10;
        this.mMaxRows = n10;
        object2 = sMetrics;
        if (object2 != null) {
            long l10;
            long l11;
            object2.tableSizeIncrease = l11 = object2.tableSizeIncrease + 1L;
            l11 = object2.maxTableSize;
            long l12 = n10;
            object2.maxTableSize = l11 = Math.max(l11, l12);
            object = sMetrics;
            object.lastTableSize = l10 = object.maxTableSize;
        }
    }

    private final int optimize(LinearSystem$Row linearSystem$Row, boolean bl2) {
        boolean[] blArray;
        int n10;
        int n11;
        Metrics metrics = sMetrics;
        long l10 = 1L;
        if (metrics != null) {
            long l11;
            metrics.optimize = l11 = metrics.optimize + l10;
        }
        metrics = null;
        for (n11 = 0; n11 < (n10 = this.mNumColumns); ++n11) {
            blArray = this.mAlreadyTestedCandidates;
            blArray[n11] = false;
        }
        n11 = 0;
        n10 = 0;
        blArray = null;
        while (n11 == 0) {
            Object object;
            int n12;
            int n13;
            Object object2;
            int n14;
            Object object3 = sMetrics;
            if (object3 != null) {
                long l12;
                ((Metrics)object3).iterations = l12 = ((Metrics)object3).iterations + l10;
            }
            if (++n10 >= (n14 = this.mNumColumns * 2)) {
                return n10;
            }
            object3 = linearSystem$Row.getKey();
            int n15 = 1;
            float f10 = Float.MIN_VALUE;
            if (object3 != null) {
                object3 = this.mAlreadyTestedCandidates;
                object2 = linearSystem$Row.getKey();
                n13 = ((SolverVariable)object2).id;
                object3[n13] = n15;
            }
            object3 = this.mAlreadyTestedCandidates;
            if ((object3 = linearSystem$Row.getPivotCandidate(this, (boolean[])object3)) != null) {
                object2 = this.mAlreadyTestedCandidates;
                n12 = ((SolverVariable)object3).id;
                object = object2[n12];
                if (object != false) {
                    return n10;
                }
                object2[n12] = n15;
            }
            if (object3 != null) {
                int n16;
                n15 = 0x7F7FFFFF;
                f10 = Float.MAX_VALUE;
                n13 = -1;
                SolverVariable solverVariable = null;
                object = n13;
                for (n12 = 0; n12 < (n16 = this.mNumRows); ++n12) {
                    float f11;
                    float f12;
                    int n17;
                    ArrayRow arrayRow = this.mRows[n12];
                    Object object4 = arrayRow.variable.mType;
                    SolverVariable$Type solverVariable$Type = SolverVariable$Type.UNRESTRICTED;
                    if (object4 == solverVariable$Type || (n17 = arrayRow.isSimpleDefinition) != 0 || (n17 = arrayRow.hasVariable((SolverVariable)object3)) == 0) continue;
                    object4 = arrayRow.variables;
                    float f13 = object4.get((SolverVariable)object3);
                    solverVariable$Type = null;
                    float f14 = f13 - 0.0f;
                    float f15 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                    if (f15 >= 0 || (n17 = (f12 = (f11 = -arrayRow.constantValue / f13) - f10) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) >= 0) continue;
                    object = n12;
                    f10 = f11;
                }
                if (object <= n13) continue;
                ArrayRow arrayRow = this.mRows[object];
                solverVariable = arrayRow.variable;
                solverVariable.definitionId = n13;
                object2 = sMetrics;
                if (object2 != null) {
                    long l13;
                    ((Metrics)object2).pivots = l13 = ((Metrics)object2).pivots + l10;
                }
                arrayRow.pivot((SolverVariable)object3);
                object3 = arrayRow.variable;
                ((SolverVariable)object3).definitionId = (int)object;
                ((SolverVariable)object3).updateReferencesWithNewDefinition(this, arrayRow);
                continue;
            }
            n11 = n15;
        }
        return n10;
    }

    private void releaseRows() {
        int n10;
        int n11 = OPTIMIZED_ENGINE;
        if (n11 != 0) {
            for (n10 = 0; n10 < (n11 = this.mNumRows); ++n10) {
                ArrayRow[] arrayRowArray = this.mRows[n10];
                if (arrayRowArray != null) {
                    Pools$Pool pools$Pool = this.mCache.optimizedArrayRowPool;
                    pools$Pool.release(arrayRowArray);
                }
                arrayRowArray = this.mRows;
                arrayRowArray[n10] = null;
            }
        } else {
            while (n10 < (n11 = this.mNumRows)) {
                ArrayRow[] arrayRowArray = this.mRows[n10];
                if (arrayRowArray != null) {
                    Pools$Pool pools$Pool = this.mCache.arrayRowPool;
                    pools$Pool.release(arrayRowArray);
                }
                arrayRowArray = this.mRows;
                arrayRowArray[n10] = null;
                ++n10;
            }
        }
    }

    public void addCenterPoint(ConstraintWidget object, ConstraintWidget constraintWidget, float f10, int n10) {
        Object object2 = object;
        Object object3 = constraintWidget;
        Object object4 = ConstraintAnchor$Type.LEFT;
        Object object5 = object.getAnchor((ConstraintAnchor$Type)((Object)object4));
        SolverVariable solverVariable = this.createObjectVariable(object5);
        object5 = ConstraintAnchor$Type.TOP;
        Object object6 = object.getAnchor((ConstraintAnchor$Type)((Object)object5));
        Object object7 = this.createObjectVariable(object6);
        object6 = ConstraintAnchor$Type.RIGHT;
        Object object8 = object.getAnchor((ConstraintAnchor$Type)((Object)object6));
        SolverVariable solverVariable2 = this.createObjectVariable(object8);
        object8 = ConstraintAnchor$Type.BOTTOM;
        object2 = object.getAnchor((ConstraintAnchor$Type)((Object)object8));
        Object object9 = this.createObjectVariable(object2);
        object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object4));
        object2 = this.createObjectVariable(object2);
        object4 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object5));
        SolverVariable solverVariable3 = this.createObjectVariable(object4);
        object4 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object6));
        object4 = this.createObjectVariable(object4);
        object3 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object8));
        SolverVariable solverVariable4 = this.createObjectVariable(object3);
        object3 = this.createRow();
        double d10 = f10;
        double d11 = Math.sin(d10);
        object = object4;
        double d12 = n10;
        float f11 = (float)(d11 * d12);
        object8 = object3;
        ((ArrayRow)object3).createRowWithAngle((SolverVariable)object7, (SolverVariable)object9, solverVariable3, solverVariable4, f11);
        this.addConstraint((ArrayRow)object3);
        object3 = this.createRow();
        float f12 = (float)(Math.cos(d10) * d12);
        object6 = object3;
        object8 = solverVariable2;
        object7 = object2;
        object9 = object4;
        ((ArrayRow)object3).createRowWithAngle(solverVariable, solverVariable2, (SolverVariable)object2, (SolverVariable)object4, f12);
        this.addConstraint((ArrayRow)object3);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int n10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int n11, int n12) {
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowCentering(solverVariable, solverVariable2, n10, f10, solverVariable3, solverVariable4, n11);
        int n13 = 8;
        if (n12 != n13) {
            arrayRow.addError(this, n12);
        }
        this.addConstraint(arrayRow);
    }

    /*
     * Unable to fully structure code
     */
    public void addConstraint(ArrayRow var1_1) {
        block15: {
            if (var1_1 == null) {
                return;
            }
            var2_2 = LinearSystem.sMetrics;
            var3_3 = 1L;
            if (var2_2 != null) {
                var2_2.constraints = var5_4 = var2_2.constraints + var3_3;
                var7_5 = (int)var1_1.isSimpleDefinition;
                if (var7_5 != 0) {
                    var2_2.simpleconstraints = var5_4 = var2_2.simpleconstraints + var3_3;
                }
            }
            var8_6 = this.mNumRows;
            var7_5 = 1;
            var9_7 = this.mMaxRows;
            if ((var8_6 += var7_5) >= var9_7 || (var8_6 = this.mNumColumns + var7_5) >= (var9_7 = this.mMaxColumns)) {
                this.increaseTableSize();
            }
            var8_6 = 0;
            var2_2 = null;
            var9_7 = (int)var1_1.isSimpleDefinition;
            if (var9_7 != 0) break block15;
            var1_1.updateFromSystem(this);
            var9_7 = (int)var1_1.isEmpty();
            if (var9_7 != 0) {
                return;
            }
            var1_1.ensurePositiveConstant();
            var9_7 = (int)var1_1.chooseSubject(this);
            if (var9_7 == 0) ** GOTO lbl-1000
            var10_8 = this.createExtraVariable();
            var1_1.variable = var10_8;
            var11_9 = this.mNumRows;
            this.addRow(var1_1);
            var12_10 = this.mNumRows;
            if (var12_10 == (var11_9 += var7_5)) {
                this.mTempGoal.initFromRow(var1_1);
                var2_2 = this.mTempGoal;
                this.optimize((LinearSystem$Row)var2_2, (boolean)var7_5);
                var8_6 = var10_8.definitionId;
                var11_9 = -1;
                if (var8_6 == var11_9) {
                    var2_2 = var1_1.variable;
                    if (var2_2 == var10_8 && (var2_2 = var1_1.pickPivot((SolverVariable)var10_8)) != null) {
                        var10_8 = LinearSystem.sMetrics;
                        if (var10_8 != null) {
                            var10_8.pivots = var13_11 = var10_8.pivots + var3_3;
                        }
                        var1_1.pivot((SolverVariable)var2_2);
                    }
                    if ((var8_6 = (int)var1_1.isSimpleDefinition) == 0) {
                        var2_2 = var1_1.variable;
                        var2_2.updateReferencesWithNewDefinition(this, var1_1);
                    }
                    if ((var8_6 = (int)LinearSystem.OPTIMIZED_ENGINE) != 0) {
                        var2_2 = this.mCache.optimizedArrayRowPool;
                        var2_2.release(var1_1);
                    } else {
                        var2_2 = this.mCache.arrayRowPool;
                        var2_2.release(var1_1);
                    }
                    this.mNumRows = var8_6 = this.mNumRows - var7_5;
                }
            } else lbl-1000:
            // 2 sources

            {
                var7_5 = 0;
            }
            if ((var8_6 = (int)var1_1.hasKeyVariable()) == 0) {
                return;
            }
            var8_6 = var7_5;
        }
        if (var8_6 == 0) {
            this.addRow(var1_1);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int n10, int n11) {
        int n12;
        int n13 = USE_BASIC_SYNONYMS;
        int n14 = 8;
        if (n13 != 0 && n11 == n14 && (n13 = solverVariable2.isFinalValue) != 0 && (n13 = solverVariable.definitionId) == (n12 = -1)) {
            float f10 = solverVariable2.computedValue;
            float f11 = n10;
            solverVariable.setFinalValue(this, f10 += f11);
            return null;
        }
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowEquals(solverVariable, solverVariable2, n10);
        if (n11 != n14) {
            arrayRow.addError(this, n11);
        }
        this.addConstraint(arrayRow);
        return arrayRow;
    }

    public void addEquality(SolverVariable solverVariable, int n10) {
        int n11 = USE_BASIC_SYNONYMS;
        int n12 = -1;
        int n13 = 1;
        if (n11 != 0 && (n11 = solverVariable.definitionId) == n12) {
            float f10 = n10;
            solverVariable.setFinalValue(this, f10);
            Object var7_7 = null;
            for (n11 = 0; n11 < (n12 = this.mVariablesID + n13); ++n11) {
                int n14;
                int n15;
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[n11];
                if (solverVariable2 == null || (n15 = solverVariable2.isSynonym) == 0 || (n15 = solverVariable2.synonym) != (n14 = solverVariable.id)) continue;
                float f11 = solverVariable2.synonymDelta + f10;
                solverVariable2.setFinalValue(this, f11);
            }
            return;
        }
        n11 = solverVariable.definitionId;
        if (n11 != n12) {
            Object object = this.mRows;
            ArrayRow arrayRow = object[n11];
            n12 = arrayRow.isSimpleDefinition ? 1 : 0;
            if (n12 != 0) {
                float f12;
                arrayRow.constantValue = f12 = (float)n10;
            } else {
                object = arrayRow.variables;
                n12 = object.getCurrentSize();
                if (n12 == 0) {
                    float f13;
                    arrayRow.isSimpleDefinition = n13;
                    arrayRow.constantValue = f13 = (float)n10;
                } else {
                    arrayRow = this.createRow();
                    arrayRow.createRowEquals(solverVariable, n10);
                    this.addConstraint(arrayRow);
                }
            }
        } else {
            ArrayRow arrayRow = this.createRow();
            arrayRow.createRowDefinition(solverVariable, n10);
            this.addConstraint(arrayRow);
        }
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int n10, boolean bl2) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariable3, n10);
        this.addConstraint(arrayRow);
    }

    public void addGreaterThan(SolverVariable object, SolverVariable solverVariable, int n10, int n11) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable2 = this.createSlackVariable();
        solverVariable2.strength = 0;
        arrayRow.createRowGreaterThan((SolverVariable)object, solverVariable, solverVariable2, n10);
        int n12 = 8;
        float f10 = 1.1E-44f;
        if (n11 != n12) {
            object = arrayRow.variables;
            f10 = object.get(solverVariable2);
            float f11 = -1.0f;
            n12 = (int)(f10 *= f11);
            this.addSingleError(arrayRow, n12, n11);
        }
        this.addConstraint(arrayRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int n10, boolean bl2) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowLowerThan(solverVariable, solverVariable2, solverVariable3, n10);
        this.addConstraint(arrayRow);
    }

    public void addLowerThan(SolverVariable object, SolverVariable solverVariable, int n10, int n11) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable2 = this.createSlackVariable();
        solverVariable2.strength = 0;
        arrayRow.createRowLowerThan((SolverVariable)object, solverVariable, solverVariable2, n10);
        int n12 = 8;
        float f10 = 1.1E-44f;
        if (n11 != n12) {
            object = arrayRow.variables;
            f10 = object.get(solverVariable2);
            float f11 = -1.0f;
            n12 = (int)(f10 *= f11);
            this.addSingleError(arrayRow, n12, n11);
        }
        this.addConstraint(arrayRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int n10) {
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        int n11 = 8;
        if (n10 != n11) {
            arrayRow.addError(this, n10);
        }
        this.addConstraint(arrayRow);
    }

    public void addSingleError(ArrayRow arrayRow, int n10, int n11) {
        SolverVariable solverVariable = this.createErrorVariable(n11, null);
        arrayRow.addSingleError(solverVariable, n10);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable object, int n10) {
        int n11 = solverVariable.definitionId;
        int n12 = -1;
        if (n11 == n12 && n10 == 0) {
            SolverVariable[] solverVariableArray;
            n10 = object.isSynonym ? 1 : 0;
            if (n10 != 0) {
                solverVariableArray = this.mCache.mIndexedVariables;
                int n13 = object.synonym;
                object = solverVariableArray[n13];
            }
            if ((n10 = (int)(solverVariable.isSynonym ? 1 : 0)) != 0) {
                object = this.mCache.mIndexedVariables;
                int n14 = solverVariable.synonym;
                solverVariable = object[n14];
            } else {
                n10 = 0;
                solverVariableArray = null;
                solverVariable.setSynonym(this, (SolverVariable)object, 0.0f);
            }
        } else {
            n11 = 8;
            this.addEquality(solverVariable, (SolverVariable)object, n10, n11);
        }
    }

    public final void cleanupRows() {
        int n10;
        int n11;
        for (int i10 = 0; i10 < (n10 = this.mNumRows); i10 += n11) {
            ArrayRow arrayRow;
            int n12;
            int n13;
            float f10;
            ArrayRow arrayRow2 = this.mRows[i10];
            Object object = arrayRow2.variables;
            int n14 = object.getCurrentSize();
            n11 = 1;
            if (n14 == 0) {
                arrayRow2.isSimpleDefinition = n11;
            }
            if ((n14 = (int)(arrayRow2.isSimpleDefinition ? 1 : 0)) == 0) continue;
            object = arrayRow2.variable;
            ((SolverVariable)object).computedValue = f10 = arrayRow2.constantValue;
            ((SolverVariable)object).removeFromRow(arrayRow2);
            n14 = i10;
            while (n14 < (n13 = (n12 = this.mNumRows) + -1)) {
                ArrayRow[] arrayRowArray = this.mRows;
                n13 = n14 + 1;
                arrayRowArray[n14] = arrayRow = arrayRowArray[n13];
                n14 = n13;
            }
            object = this.mRows;
            n13 = n12 + -1;
            arrayRow = null;
            object[n13] = null;
            this.mNumRows = n12 += -1;
            i10 += -1;
            n14 = OPTIMIZED_ENGINE ? 1 : 0;
            if (n14 != 0) {
                object = this.mCache.optimizedArrayRowPool;
                object.release(arrayRow2);
                continue;
            }
            object = this.mCache.arrayRowPool;
            object.release(arrayRow2);
        }
    }

    public SolverVariable createErrorVariable(int n10, String object) {
        int n11;
        int n12;
        Object object2 = sMetrics;
        if (object2 != null) {
            long l10 = object2.errors;
            long l11 = 1L;
            object2.errors = l10 += l11;
        }
        if ((n12 = this.mNumColumns + 1) >= (n11 = this.mMaxColumns)) {
            this.increaseTableSize();
        }
        object2 = SolverVariable$Type.ERROR;
        object = this.acquireSolverVariable((SolverVariable$Type)((Object)object2), (String)object);
        this.mVariablesID = n12 = this.mVariablesID + 1;
        this.mNumColumns = n11 = this.mNumColumns + 1;
        ((SolverVariable)object).id = n12;
        ((SolverVariable)object).strength = n10;
        this.mCache.mIndexedVariables[n12] = object;
        this.mGoal.addError((SolverVariable)object);
        return object;
    }

    public SolverVariable createExtraVariable() {
        int n10;
        int n11;
        int n12;
        Object object = sMetrics;
        if (object != null) {
            long l10 = object.extravariables;
            long l11 = 1L;
            object.extravariables = l10 += l11;
        }
        if ((n12 = this.mNumColumns + 1) >= (n11 = this.mMaxColumns)) {
            this.increaseTableSize();
        }
        object = SolverVariable$Type.SLACK;
        object = this.acquireSolverVariable((SolverVariable$Type)((Object)object), null);
        this.mVariablesID = n11 = this.mVariablesID + 1;
        this.mNumColumns = n10 = this.mNumColumns + 1;
        ((SolverVariable)object).id = n11;
        this.mCache.mIndexedVariables[n11] = object;
        return object;
    }

    public SolverVariable createObjectVariable(Object object) {
        Object object2 = null;
        if (object == null) {
            return null;
        }
        int n10 = this.mNumColumns + 1;
        int n11 = this.mMaxColumns;
        if (n10 >= n11) {
            this.increaseTableSize();
        }
        if ((n10 = object instanceof ConstraintAnchor) != 0) {
            SolverVariable solverVariable;
            int n12;
            object2 = ((ConstraintAnchor)(object = (ConstraintAnchor)object)).getSolverVariable();
            if (object2 == null) {
                object2 = this.mCache;
                ((ConstraintAnchor)object).resetSolverVariable((Cache)object2);
                object2 = object = ((ConstraintAnchor)object).getSolverVariable();
            }
            if ((n12 = ((SolverVariable)object2).id) == (n10 = -1) || n12 > (n11 = this.mVariablesID) || (solverVariable = this.mCache.mIndexedVariables[n12]) == null) {
                if (n12 != n10) {
                    ((SolverVariable)object2).reset();
                }
                this.mVariablesID = n12 = this.mVariablesID + 1;
                this.mNumColumns = n10 = this.mNumColumns + 1;
                ((SolverVariable)object2).id = n12;
                SolverVariable[] solverVariableArray = SolverVariable$Type.UNRESTRICTED;
                ((SolverVariable)object2).mType = solverVariableArray;
                solverVariableArray = this.mCache.mIndexedVariables;
                solverVariableArray[n12] = object2;
            }
        }
        return object2;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        boolean bl2 = OPTIMIZED_ENGINE;
        long l10 = 1L;
        if (bl2) {
            arrayRow = (ArrayRow)this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRow == null) {
                long l11;
                Cache cache = this.mCache;
                arrayRow = new LinearSystem$ValuesRow(this, cache);
                OPTIMIZED_ARRAY_ROW_CREATION = l11 = OPTIMIZED_ARRAY_ROW_CREATION + l10;
            } else {
                arrayRow.reset();
            }
        } else {
            arrayRow = (ArrayRow)this.mCache.arrayRowPool.acquire();
            if (arrayRow == null) {
                long l12;
                Cache cache = this.mCache;
                arrayRow = new ArrayRow(cache);
                ARRAY_ROW_CREATION = l12 = ARRAY_ROW_CREATION + l10;
            } else {
                arrayRow.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        int n10;
        int n11;
        int n12;
        Object object = sMetrics;
        if (object != null) {
            long l10 = object.slackvariables;
            long l11 = 1L;
            object.slackvariables = l10 += l11;
        }
        if ((n12 = this.mNumColumns + 1) >= (n11 = this.mMaxColumns)) {
            this.increaseTableSize();
        }
        object = SolverVariable$Type.SLACK;
        object = this.acquireSolverVariable((SolverVariable$Type)((Object)object), null);
        this.mVariablesID = n11 = this.mVariablesID + 1;
        this.mNumColumns = n10 = this.mNumColumns + 1;
        ((SolverVariable)object).id = n11;
        this.mCache.mIndexedVariables[n11] = object;
        return object;
    }

    public void displayReadableRows() {
        float f10;
        Object object;
        Object object2;
        String string2;
        String string3;
        int n10;
        this.displaySolverVariables();
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append(" num vars ");
        int n11 = this.mVariablesID;
        ((StringBuilder)object3).append(n11);
        String string4 = "\n";
        ((StringBuilder)object3).append(string4);
        object3 = ((StringBuilder)object3).toString();
        int n12 = 0;
        Object object4 = null;
        int n13 = 0;
        StringBuilder stringBuilder = null;
        while (true) {
            boolean bl2;
            n10 = this.mVariablesID + 1;
            string3 = " = ";
            string2 = "] => ";
            if (n13 >= n10) break;
            object2 = this.mCache.mIndexedVariables[n13];
            if (object2 != null && (bl2 = object2.isFinalValue)) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(" $[");
                ((StringBuilder)object).append(n13);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(object2);
                ((StringBuilder)object).append(string3);
                f10 = object2.computedValue;
                ((StringBuilder)object).append(f10);
                ((StringBuilder)object).append(string4);
                object3 = ((StringBuilder)object).toString();
            }
            ++n13;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)object3);
        stringBuilder.append(string4);
        object3 = stringBuilder.toString();
        stringBuilder = null;
        for (n13 = 0; n13 < (n10 = this.mVariablesID + 1); ++n13) {
            int n14;
            object2 = this.mCache.mIndexedVariables;
            object = object2[n13];
            if (object == null || (n14 = ((SolverVariable)object).isSynonym) == 0) continue;
            n14 = ((SolverVariable)object).synonym;
            object2 = object2[n14];
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String)object3);
            stringBuilder2.append(" ~[");
            stringBuilder2.append(n13);
            stringBuilder2.append(string2);
            stringBuilder2.append(object);
            stringBuilder2.append(string3);
            stringBuilder2.append(object2);
            stringBuilder2.append(" + ");
            f10 = ((SolverVariable)object).synonymDelta;
            stringBuilder2.append(f10);
            stringBuilder2.append(string4);
            object3 = stringBuilder2.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)object3);
        stringBuilder.append("\n\n #  ");
        object3 = stringBuilder.toString();
        while (n12 < (n13 = this.mNumRows)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object3);
            object3 = this.mRows[n12].toReadableString();
            stringBuilder.append((String)object3);
            object3 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object3);
            stringBuilder.append("\n #  ");
            object3 = stringBuilder.toString();
            ++n12;
        }
        object4 = this.mGoal;
        if (object4 != null) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object3);
            ((StringBuilder)object4).append("Goal: ");
            object3 = this.mGoal;
            ((StringBuilder)object4).append(object3);
            ((StringBuilder)object4).append(string4);
            object3 = ((StringBuilder)object4).toString();
        }
        System.out.println((String)object3);
    }

    public void displaySystemInformations() {
        Object object;
        int n10;
        Object object2;
        Object object3;
        int n11;
        int n12;
        String string2 = null;
        PrintStream printStream = null;
        int n13 = 0;
        String string3 = null;
        for (n12 = 0; n12 < (n11 = this.TABLE_SIZE); ++n12) {
            object3 = this.mRows;
            object2 = object3[n12];
            if (object2 == null) continue;
            object3 = object3[n12];
            n11 = ((ArrayRow)object3).sizeInBytes();
            n13 += n11;
        }
        printStream = null;
        n11 = 0;
        object3 = null;
        for (n12 = 0; n12 < (n10 = this.mNumRows); ++n12) {
            object2 = this.mRows;
            object = object2[n12];
            if (object == null) continue;
            object2 = object2[n12];
            n10 = ((ArrayRow)object2).sizeInBytes();
            n11 += n10;
        }
        printStream = System.out;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Linear System -> Table size: ");
        int n14 = this.TABLE_SIZE;
        ((StringBuilder)object2).append(n14);
        ((StringBuilder)object2).append(" (");
        n14 = this.TABLE_SIZE;
        n14 *= n14;
        object = this.getDisplaySize(n14);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(") -- row sizes: ");
        string3 = this.getDisplaySize(n13);
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(", actual size: ");
        string3 = this.getDisplaySize(n11);
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(" rows: ");
        n13 = this.mNumRows;
        ((StringBuilder)object2).append(n13);
        string3 = "/";
        ((StringBuilder)object2).append(string3);
        n11 = this.mMaxRows;
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append(" cols: ");
        n11 = this.mNumColumns;
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append(string3);
        n13 = this.mMaxColumns;
        ((StringBuilder)object2).append(n13);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(0);
        ((StringBuilder)object2).append(" occupied cells, ");
        string2 = this.getDisplaySize(0);
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        printStream.println(string2);
    }

    public void displayVariablesReadableRows() {
        String string2;
        this.displaySolverVariables();
        Object object = "";
        int n10 = 0;
        StringBuilder stringBuilder = null;
        while (true) {
            int n11 = this.mNumRows;
            string2 = "\n";
            if (n10 >= n11) break;
            Object object2 = this.mRows[n10].variable.mType;
            SolverVariable$Type solverVariable$Type = SolverVariable$Type.UNRESTRICTED;
            if (object2 == solverVariable$Type) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                object = this.mRows[n10].toReadableString();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
            }
            ++n10;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        object = this.mGoal;
        stringBuilder.append(object);
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        System.out.println((String)object);
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public LinearSystem$Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.mNumRows); ++i10) {
            Object object = this.mRows;
            ArrayRow arrayRow = object[i10];
            if (arrayRow == null) continue;
            object = object[i10];
            n10 = ((ArrayRow)object).sizeInBytes();
            n11 += n10;
        }
        return n11;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object object) {
        if ((object = ((ConstraintAnchor)object).getSolverVariable()) != null) {
            return (int)(((SolverVariable)object).computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int n10) {
        return this.mRows[n10];
    }

    public float getValueFor(String object) {
        SolverVariable$Type solverVariable$Type = SolverVariable$Type.UNRESTRICTED;
        if ((object = this.getVariable((String)object, solverVariable$Type)) == null) {
            return 0.0f;
        }
        return ((SolverVariable)object).computedValue;
    }

    public SolverVariable getVariable(String string2, SolverVariable$Type solverVariable$Type) {
        HashMap hashMap = this.mVariables;
        if (hashMap == null) {
            hashMap = new HashMap();
            this.mVariables = hashMap;
        }
        if ((hashMap = (SolverVariable)this.mVariables.get(string2)) == null) {
            hashMap = this.createVariable(string2, solverVariable$Type);
        }
        return hashMap;
    }

    public void minimize() {
        boolean bl2;
        long l10;
        Object object = sMetrics;
        long l11 = 1L;
        if (object != null) {
            ((Metrics)object).minimize = l10 = ((Metrics)object).minimize + l11;
        }
        if (bl2 = (object = this.mGoal).isEmpty()) {
            this.computeValues();
            return;
        }
        bl2 = this.graphOptimizer;
        if (!bl2 && !(bl2 = this.newgraphOptimizer)) {
            object = this.mGoal;
            this.minimizeGoal((LinearSystem$Row)object);
        } else {
            block10: {
                int n10;
                object = sMetrics;
                if (object != null) {
                    ((Metrics)object).graphOptimizer = l10 = ((Metrics)object).graphOptimizer + l11;
                }
                bl2 = false;
                object = null;
                for (int i10 = 0; i10 < (n10 = this.mNumRows); ++i10) {
                    ArrayRow arrayRow = this.mRows[i10];
                    n10 = arrayRow.isSimpleDefinition ? 1 : 0;
                    if (n10 != 0) {
                        continue;
                    }
                    break block10;
                }
                bl2 = true;
            }
            if (!bl2) {
                object = this.mGoal;
                this.minimizeGoal((LinearSystem$Row)object);
            } else {
                object = sMetrics;
                if (object != null) {
                    ((Metrics)object).fullySolved = l10 = ((Metrics)object).fullySolved + l11;
                }
                this.computeValues();
            }
        }
    }

    public void minimizeGoal(LinearSystem$Row linearSystem$Row) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            long l10;
            metrics.minimizeGoal = l10 = metrics.minimizeGoal + 1L;
            l10 = metrics.maxVariables;
            long l11 = this.mNumColumns;
            metrics.maxVariables = l10 = Math.max(l10, l11);
            metrics = sMetrics;
            l10 = metrics.maxRows;
            int n10 = this.mNumRows;
            l11 = n10;
            metrics.maxRows = l10 = Math.max(l10, l11);
        }
        this.enforceBFS(linearSystem$Row);
        this.optimize(linearSystem$Row, false);
        this.computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        Object object;
        int n10 = arrayRow.isSimpleDefinition;
        if (n10 != 0 && (object = arrayRow.variable) != null) {
            n10 = ((SolverVariable)object).definitionId;
            int n11 = -1;
            float f10 = 0.0f / 0.0f;
            if (n10 != n11) {
                int n12;
                while (n10 < (n12 = (n11 = this.mNumRows) + -1)) {
                    ArrayRow[] arrayRowArray = this.mRows;
                    n12 = n10 + 1;
                    Object object2 = arrayRowArray[n12].variable;
                    int n13 = ((SolverVariable)object2).definitionId;
                    if (n13 == n12) {
                        ((SolverVariable)object2).definitionId = n10;
                    }
                    arrayRowArray[n10] = object2 = arrayRowArray[n12];
                    n10 = n12;
                }
                this.mNumRows = n11 += -1;
            }
            object = arrayRow.variable;
            n11 = ((SolverVariable)object).isFinalValue ? 1 : 0;
            if (n11 == 0) {
                f10 = arrayRow.constantValue;
                ((SolverVariable)object).setFinalValue(this, f10);
            }
            if ((n10 = (int)(OPTIMIZED_ENGINE ? 1 : 0)) != 0) {
                object = this.mCache.optimizedArrayRowPool;
                object.release(arrayRow);
            } else {
                object = this.mCache.arrayRowPool;
                object.release(arrayRow);
            }
        }
    }

    public void reset() {
        Object object;
        Object object2;
        boolean bl2 = false;
        ArrayRow arrayRow = null;
        int n10 = 0;
        Object object3 = null;
        while (true) {
            object2 = this.mCache;
            object = object2.mIndexedVariables;
            int n11 = ((SolverVariable[])object).length;
            if (n10 >= n11) break;
            object2 = object[n10];
            if (object2 != null) {
                object2.reset();
            }
            ++n10;
        }
        object3 = object2.solverVariablePool;
        object2 = this.mPoolVariables;
        int n12 = this.mPoolVariablesCount;
        object3.releaseAll((Object[])object2, n12);
        this.mPoolVariablesCount = 0;
        object3 = this.mCache.mIndexedVariables;
        int n13 = 0;
        object2 = null;
        Arrays.fill((Object[])object3, null);
        object3 = this.mVariables;
        if (object3 != null) {
            ((HashMap)object3).clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        object3 = null;
        for (n10 = 0; n10 < (n13 = this.mNumRows); ++n10) {
            object2 = this.mRows;
            object = object2[n10];
            if (object == null) continue;
            object2 = object2[n10];
            object2.used = false;
        }
        this.releaseRows();
        this.mNumRows = 0;
        bl2 = OPTIMIZED_ENGINE;
        if (bl2) {
            object3 = this.mCache;
            arrayRow = new LinearSystem$ValuesRow(this, (Cache)object3);
            this.mTempGoal = arrayRow;
        } else {
            object3 = this.mCache;
            arrayRow = new ArrayRow((Cache)object3);
            this.mTempGoal = arrayRow;
        }
    }
}

