/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables
implements ArrayRow$ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public static final int NONE = 255;
    private static float epsilon = 0.001f;
    private int ROW_SIZE;
    private SolverVariable candidate;
    public int currentSize = 0;
    private int[] mArrayIndices;
    private int[] mArrayNextIndices;
    private float[] mArrayValues;
    public final Cache mCache;
    private boolean mDidFillOnce;
    private int mHead;
    private int mLast;
    private final ArrayRow mRow;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        int n10;
        this.ROW_SIZE = n10 = 8;
        this.candidate = null;
        int[] nArray = new int[n10];
        this.mArrayIndices = nArray;
        nArray = new int[n10];
        this.mArrayNextIndices = nArray;
        float[] fArray = new float[n10];
        this.mArrayValues = fArray;
        this.mHead = n10 = -1;
        this.mLast = n10;
        this.mDidFillOnce = false;
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    public void add(SolverVariable solverVariable, float f10, boolean n10) {
        int n11;
        int n12;
        Object object;
        Object[] objectArray;
        int n13;
        int n14;
        int n15;
        float f11 = epsilon;
        float f12 = -f11;
        float f13 = f10 - f12;
        Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object2 > 0 && (n15 = (int)(f10 == f11 ? 0 : (f10 < f11 ? -1 : 1))) < 0) {
            return;
        }
        n15 = this.mHead;
        object2 = false;
        f12 = 0.0f;
        float[] fArray = null;
        int n16 = -1;
        float f14 = 0.0f / 0.0f;
        int n17 = 1;
        if (n15 == n16) {
            int n18;
            int n19;
            this.mHead = 0;
            float[] fArray2 = this.mArrayValues;
            fArray2[0] = f10;
            Object object3 = this.mArrayIndices;
            n10 = solverVariable.id;
            object3[0] = n10;
            this.mArrayNextIndices[0] = n16;
            solverVariable.usageInRowCount = n19 = solverVariable.usageInRowCount + n17;
            object3 = this.mRow;
            solverVariable.addToRow((ArrayRow)object3);
            this.currentSize = n18 = this.currentSize + n17;
            n18 = (int)(this.mDidFillOnce ? 1 : 0);
            if (n18 == 0) {
                this.mLast = n18 = this.mLast + n17;
                object3 = this.mArrayIndices;
                n10 = ((int[])object3).length;
                if (n18 >= n10) {
                    this.mDidFillOnce = n17;
                    this.mLast = n18 = ((int[])object3).length - n17;
                }
            }
            return;
        }
        int[] nArray = null;
        float f15 = 0.0f;
        int n20 = n16;
        for (n14 = 0; n15 != n16 && n14 < (n13 = this.currentSize); ++n14) {
            int[] nArray2 = this.mArrayIndices;
            int n21 = nArray2[n15];
            int n22 = solverVariable.id;
            if (n21 == n22) {
                Object object4;
                fArray = this.mArrayValues;
                f14 = fArray[n15] + f10;
                f10 = epsilon;
                f15 = -f10;
                n14 = (int)(f14 == f15 ? 0 : (f14 > f15 ? 1 : -1));
                n13 = 0;
                nArray2 = null;
                if (n14 > 0 && (object4 = f14 == f10 ? 0 : (f14 < f10 ? -1 : 1)) < 0) {
                    n16 = 0;
                    f14 = 0.0f;
                }
                fArray[n15] = f14;
                float f16 = f14 - 0.0f;
                object4 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
                if (object4 == false) {
                    int n23;
                    Object object5;
                    object4 = this.mHead;
                    if (n15 == object4) {
                        object5 = this.mArrayNextIndices;
                        object4 = object5[n15];
                        this.mHead = (int)object4;
                    } else {
                        object5 = this.mArrayNextIndices;
                        object2 = object5[n15];
                        object5[n20] = (int)object2;
                    }
                    if (n10 != 0) {
                        object5 = this.mRow;
                        solverVariable.removeFromRow((ArrayRow)object5);
                    }
                    if ((object4 = (Object)this.mDidFillOnce) != false) {
                        this.mLast = n15;
                    }
                    object4 = solverVariable.usageInRowCount - n17;
                    solverVariable.usageInRowCount = (int)object4;
                    this.currentSize = n23 = this.currentSize - n17;
                }
                return;
            }
            n13 = nArray2[n15];
            if (n13 < n22) {
                n20 = n15;
            }
            nArray2 = this.mArrayNextIndices;
            n15 = nArray2[n15];
        }
        n10 = this.mLast;
        n15 = n10 + 1;
        n14 = (int)(this.mDidFillOnce ? 1 : 0);
        if (n14 != 0) {
            objectArray = this.mArrayIndices;
            n14 = objectArray[n10];
            if (n14 != n16) {
                n10 = objectArray.length;
            }
        } else {
            n10 = n15;
        }
        objectArray = this.mArrayIndices;
        n14 = objectArray.length;
        if (n10 >= n14 && (n14 = this.currentSize) < (n15 = objectArray.length)) {
            objectArray = null;
            f11 = 0.0f;
            for (n15 = 0; n15 < (n13 = (nArray = this.mArrayIndices).length); ++n15) {
                n14 = nArray[n15];
                if (n14 != n16) continue;
                n10 = n15;
                break;
            }
        }
        if (n10 >= (n14 = (objectArray = this.mArrayIndices).length)) {
            n10 = objectArray.length;
            this.ROW_SIZE = n15 = this.ROW_SIZE * 2;
            this.mDidFillOnce = false;
            object2 = n10 + -1;
            this.mLast = (int)object2;
            fArray = this.mArrayValues;
            objectArray = Arrays.copyOf(fArray, n15);
            this.mArrayValues = objectArray;
            objectArray = this.mArrayIndices;
            object2 = this.ROW_SIZE;
            this.mArrayIndices = objectArray = Arrays.copyOf(objectArray, (int)object2);
            objectArray = this.mArrayNextIndices;
            object2 = this.ROW_SIZE;
            objectArray = Arrays.copyOf(objectArray, (int)object2);
            this.mArrayNextIndices = objectArray;
        }
        objectArray = this.mArrayIndices;
        object2 = solverVariable.id;
        objectArray[n10] = (int)object2;
        objectArray = this.mArrayValues;
        objectArray[n10] = (int)f10;
        if (n20 != n16) {
            object = this.mArrayNextIndices;
            object[n10] = n15 = object[n20];
            object[n20] = n10;
        } else {
            object = this.mArrayNextIndices;
            object[n10] = n15 = this.mHead;
            this.mHead = n10;
        }
        solverVariable.usageInRowCount = n12 = solverVariable.usageInRowCount + n17;
        object = this.mRow;
        solverVariable.addToRow((ArrayRow)object);
        this.currentSize = n11 = this.currentSize + n17;
        n11 = (int)(this.mDidFillOnce ? 1 : 0);
        if (n11 == 0) {
            this.mLast = n11 = this.mLast + n17;
        }
        if ((n11 = this.mLast) >= (n10 = ((int[])(object = this.mArrayIndices)).length)) {
            this.mDidFillOnce = n17;
            this.mLast = n11 = ((int[])object).length - n17;
        }
    }

    public final void clear() {
        int n10;
        int n11;
        Object object = this.mHead;
        for (int i10 = 0; object != (n11 = -1) && i10 < (n10 = this.currentSize); ++i10) {
            Object object2 = this.mCache.mIndexedVariables;
            Object object3 = this.mArrayIndices;
            n10 = object3[object];
            if ((object2 = object2[n10]) != null) {
                object3 = this.mRow;
                ((SolverVariable)object2).removeFromRow((ArrayRow)object3);
            }
            object2 = this.mArrayNextIndices;
            object = object2[object];
        }
        this.mHead = n11;
        this.mLast = n11;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    public boolean contains(SolverVariable solverVariable) {
        int n10;
        int n11 = this.mHead;
        int n12 = -1;
        if (n11 == n12) {
            return false;
        }
        for (int i10 = 0; n11 != n12 && i10 < (n10 = this.currentSize); ++i10) {
            int[] nArray = this.mArrayIndices;
            n10 = nArray[n11];
            int n13 = solverVariable.id;
            if (n10 == n13) {
                return true;
            }
            nArray = this.mArrayNextIndices;
            n11 = nArray[n11];
        }
        return false;
    }

    public void display() {
        int n10 = this.currentSize;
        PrintStream printStream = System.out;
        Object object = "{ ";
        printStream.print((String)object);
        printStream = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object = this.getVariable(i10);
            if (object == null) continue;
            PrintStream printStream2 = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object);
            stringBuilder.append(" = ");
            float f10 = this.getVariableValue(i10);
            stringBuilder.append(f10);
            stringBuilder.append(" ");
            object = stringBuilder.toString();
            printStream2.print((String)object);
        }
        System.out.println(" }");
    }

    public void divideByAmount(float f10) {
        int n10;
        int n11 = this.mHead;
        for (int i10 = 0; n11 != (n10 = -1) && i10 < (n10 = this.currentSize); ++i10) {
            float f11;
            Object[] objectArray = this.mArrayValues;
            objectArray[n11] = f11 = objectArray[n11] / f10;
            objectArray = this.mArrayNextIndices;
            n11 = (int)objectArray[n11];
        }
    }

    public final float get(SolverVariable solverVariable) {
        int n10;
        int n11 = this.mHead;
        for (int i10 = 0; n11 != (n10 = -1) && i10 < (n10 = this.currentSize); ++i10) {
            int[] nArray = this.mArrayIndices;
            n10 = nArray[n11];
            int n12 = solverVariable.id;
            if (n10 == n12) {
                return this.mArrayValues[n11];
            }
            nArray = this.mArrayNextIndices;
            n11 = nArray[n11];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int n10) {
        return this.mArrayIndices[n10];
    }

    public final int getNextIndice(int n10) {
        return this.mArrayNextIndices[n10];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable == null) {
            int n10 = this.mHead;
            int n11 = 0;
            Object object = null;
            while (true) {
                int n12 = -1;
                float f10 = 0.0f / 0.0f;
                if (n10 == n12 || n11 >= (n12 = this.currentSize)) break;
                Object object2 = this.mArrayValues;
                f10 = object2[n10];
                int n13 = 0;
                int[] nArray = null;
                float f11 = f10 - 0.0f;
                n12 = (int)(f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1));
                if (n12 < 0) {
                    int n14;
                    object2 = this.mCache.mIndexedVariables;
                    nArray = this.mArrayIndices;
                    n13 = nArray[n10];
                    object2 = object2[n13];
                    if (object == null || (n13 = object.strength) < (n14 = object2.strength)) {
                        object = object2;
                    }
                }
                object2 = this.mArrayNextIndices;
                n10 = (int)object2[n10];
                ++n11;
            }
            return object;
        }
        return solverVariable;
    }

    public final float getValue(int n10) {
        return this.mArrayValues[n10];
    }

    public SolverVariable getVariable(int n10) {
        int n11;
        int n12 = this.mHead;
        for (int i10 = 0; n12 != (n11 = -1) && i10 < (n11 = this.currentSize); ++i10) {
            if (i10 == n10) {
                SolverVariable[] solverVariableArray = this.mCache.mIndexedVariables;
                n12 = this.mArrayIndices[n12];
                return solverVariableArray[n12];
            }
            int[] nArray = this.mArrayNextIndices;
            n12 = nArray[n12];
        }
        return null;
    }

    public float getVariableValue(int n10) {
        int n11;
        int n12 = this.mHead;
        for (int i10 = 0; n12 != (n11 = -1) && i10 < (n11 = this.currentSize); ++i10) {
            if (i10 == n10) {
                return this.mArrayValues[n12];
            }
            int[] nArray = this.mArrayNextIndices;
            n12 = nArray[n12];
        }
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int n10 = this.mHead;
        int n11 = 0;
        while (true) {
            int n12 = -1;
            float f10 = 0.0f / 0.0f;
            if (n10 == n12 || n11 >= (n12 = this.currentSize)) break;
            Object[] objectArray = this.mArrayValues;
            f10 = objectArray[n10];
            float f11 = f10 - 0.0f;
            n12 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
            if (n12 > 0) {
                return true;
            }
            objectArray = this.mArrayNextIndices;
            n10 = (int)objectArray[n10];
            ++n11;
        }
        return false;
    }

    public int indexOf(SolverVariable solverVariable) {
        int n10;
        int n11 = this.mHead;
        int n12 = -1;
        if (n11 == n12) {
            return n12;
        }
        for (int i10 = 0; n11 != n12 && i10 < (n10 = this.currentSize); ++i10) {
            int[] nArray = this.mArrayIndices;
            n10 = nArray[n11];
            int n13 = solverVariable.id;
            if (n10 == n13) {
                return n11;
            }
            nArray = this.mArrayNextIndices;
            n11 = nArray[n11];
        }
        return n12;
    }

    public void invert() {
        int n10;
        int n11 = this.mHead;
        for (int i10 = 0; n11 != (n10 = -1) && i10 < (n10 = this.currentSize); ++i10) {
            Object[] objectArray = this.mArrayValues;
            float f10 = objectArray[n11];
            float f11 = -1.0f;
            objectArray[n11] = f10 *= f11;
            objectArray = this.mArrayNextIndices;
            n11 = (int)objectArray[n11];
        }
    }

    public final void put(SolverVariable solverVariable, float f10) {
        int n10;
        int n11;
        Object object;
        int n12;
        int[] nArray;
        int n13;
        int n14;
        float[] fArray = null;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        int n15 = 1;
        if (f12 == false) {
            this.remove(solverVariable, n15 != 0);
            return;
        }
        f12 = this.mHead;
        int n16 = 0;
        Object[] objectArray = null;
        int n17 = -1;
        if (f12 == n17) {
            int n18;
            int n19;
            this.mHead = 0;
            fArray = this.mArrayValues;
            fArray[0] = f10;
            Object object2 = this.mArrayIndices;
            f12 = solverVariable.id;
            object2[0] = (int)f12;
            this.mArrayNextIndices[0] = n17;
            solverVariable.usageInRowCount = n19 = solverVariable.usageInRowCount + n15;
            object2 = this.mRow;
            solverVariable.addToRow((ArrayRow)object2);
            this.currentSize = n18 = this.currentSize + n15;
            n18 = (int)(this.mDidFillOnce ? 1 : 0);
            if (n18 == 0) {
                this.mLast = n18 = this.mLast + n15;
                object2 = this.mArrayIndices;
                f12 = ((int[])object2).length;
                if (n18 >= f12) {
                    this.mDidFillOnce = n15;
                    this.mLast = n18 = ((int[])object2).length - n15;
                }
            }
            return;
        }
        int[] nArray2 = null;
        int n20 = n17;
        for (n14 = 0; f12 != n17 && n14 < (n13 = this.currentSize); ++n14) {
            nArray = this.mArrayIndices;
            n12 = nArray[f12];
            int n21 = solverVariable.id;
            if (n12 == n21) {
                this.mArrayValues[f12] = f10;
                return;
            }
            n13 = nArray[f12];
            if (n13 < n21) {
                n20 = (int)f12;
            }
            nArray = this.mArrayNextIndices;
            f12 = nArray[f12];
        }
        f12 = this.mLast;
        n14 = (int)(f12 + true);
        n13 = (int)(this.mDidFillOnce ? 1 : 0);
        if (n13 != 0) {
            nArray2 = this.mArrayIndices;
            n13 = nArray2[f12];
            if (n13 != n17) {
                f12 = nArray2.length;
            }
        } else {
            f12 = n14;
        }
        nArray2 = this.mArrayIndices;
        n13 = nArray2.length;
        if (f12 >= n13 && (n13 = this.currentSize) < (n14 = nArray2.length)) {
            nArray2 = null;
            for (n14 = 0; n14 < (n12 = (nArray = this.mArrayIndices).length); ++n14) {
                n13 = nArray[n14];
                if (n13 != n17) continue;
                f12 = n14;
                break;
            }
        }
        if (f12 >= (n13 = (nArray2 = this.mArrayIndices).length)) {
            f12 = nArray2.length;
            this.ROW_SIZE = n14 = this.ROW_SIZE * 2;
            this.mDidFillOnce = false;
            this.mLast = n16 = f12 + -1;
            objectArray = Arrays.copyOf(this.mArrayValues, n14);
            this.mArrayValues = objectArray;
            objectArray = this.mArrayIndices;
            n14 = this.ROW_SIZE;
            this.mArrayIndices = objectArray = Arrays.copyOf(objectArray, n14);
            objectArray = this.mArrayNextIndices;
            n14 = this.ROW_SIZE;
            objectArray = Arrays.copyOf(objectArray, n14);
            this.mArrayNextIndices = objectArray;
        }
        objectArray = this.mArrayIndices;
        objectArray[f12] = n14 = solverVariable.id;
        objectArray = this.mArrayValues;
        objectArray[f12] = (int)f10;
        if (n20 != n17) {
            object = this.mArrayNextIndices;
            object[f12] = n16 = object[n20];
            object[n20] = (int)f12;
        } else {
            object = this.mArrayNextIndices;
            object[f12] = n16 = this.mHead;
            this.mHead = (int)f12;
        }
        solverVariable.usageInRowCount = n11 = solverVariable.usageInRowCount + n15;
        object = this.mRow;
        solverVariable.addToRow((ArrayRow)object);
        this.currentSize = n10 = this.currentSize + n15;
        n11 = (int)(this.mDidFillOnce ? 1 : 0);
        if (n11 == 0) {
            this.mLast = n11 = this.mLast + n15;
        }
        if (n10 >= (f12 = (float)((int[])(object = this.mArrayIndices)).length)) {
            this.mDidFillOnce = n15;
        }
        if ((n10 = this.mLast) >= (f12 = (float)((int[])object).length)) {
            this.mDidFillOnce = n15;
            this.mLast = n10 = ((int[])object).length - n15;
        }
    }

    public final float remove(SolverVariable object, boolean bl2) {
        int n10;
        int n11;
        SolverVariable solverVariable = this.candidate;
        if (solverVariable == object) {
            n11 = 0;
            solverVariable = null;
            this.candidate = null;
        }
        n11 = this.mHead;
        int n12 = 0;
        int[] nArray = null;
        int n13 = -1;
        if (n11 == n13) {
            return 0.0f;
        }
        int n14 = n13;
        for (int i10 = 0; n11 != n13 && i10 < (n10 = this.currentSize); ++i10) {
            int[] nArray2 = this.mArrayIndices;
            n10 = nArray2[n11];
            int n15 = ((SolverVariable)object).id;
            if (n10 == n15) {
                int n16;
                int n17;
                n12 = this.mHead;
                if (n11 == n12) {
                    nArray = this.mArrayNextIndices;
                    this.mHead = n12 = nArray[n11];
                } else {
                    nArray = this.mArrayNextIndices;
                    nArray[n14] = i10 = nArray[n11];
                }
                if (bl2) {
                    ArrayRow arrayRow = this.mRow;
                    ((SolverVariable)object).removeFromRow(arrayRow);
                }
                ((SolverVariable)object).usageInRowCount = n17 = ((SolverVariable)object).usageInRowCount + -1;
                this.currentSize = n16 = this.currentSize + -1;
                object = this.mArrayIndices;
                object[n11] = n13;
                n16 = (int)(this.mDidFillOnce ? 1 : 0);
                if (n16 != 0) {
                    this.mLast = n11;
                }
                return this.mArrayValues[n11];
            }
            int[] nArray3 = this.mArrayNextIndices;
            n14 = nArray3[n11];
            int n18 = n14;
            n14 = n11;
            n11 = n18;
        }
        return 0.0f;
    }

    public int sizeInBytes() {
        return this.mArrayIndices.length * 4 * 3 + 0 + 36;
    }

    public String toString() {
        int n10;
        Object object = this.mHead;
        Object object2 = "";
        for (int i10 = 0; object != (n10 = -1) && i10 < (n10 = this.currentSize); ++i10) {
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" -> ");
            object2 = ((StringBuilder)object3).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            float f10 = this.mArrayValues[object];
            ((StringBuilder)object3).append(f10);
            ((StringBuilder)object3).append(" : ");
            object2 = ((StringBuilder)object3).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            object2 = this.mCache.mIndexedVariables;
            int[] nArray = this.mArrayIndices;
            int n11 = nArray[object];
            object2 = object2[n11];
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object3 = this.mArrayNextIndices;
            object = object3[object];
        }
        return object2;
    }

    public float use(ArrayRow object, boolean bl2) {
        SolverVariable solverVariable = ((ArrayRow)object).variable;
        float f10 = this.get(solverVariable);
        SolverVariable solverVariable2 = ((ArrayRow)object).variable;
        this.remove(solverVariable2, bl2);
        object = ((ArrayRow)object).variables;
        int n10 = object.getCurrentSize();
        for (int i10 = 0; i10 < n10; ++i10) {
            SolverVariable solverVariable3 = object.getVariable(i10);
            float f11 = object.get(solverVariable3) * f10;
            this.add(solverVariable3, f11, bl2);
        }
        return f10;
    }
}

