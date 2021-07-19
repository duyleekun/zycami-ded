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

public class SolverVariableValues
implements ArrayRow$ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    private int HASH_SIZE;
    private final int NONE;
    private int SIZE;
    public int head;
    public int[] keys;
    public final Cache mCache;
    public int mCount;
    private final ArrayRow mRow;
    public int[] next;
    public int[] nextKeys;
    public int[] previous;
    public float[] values;
    public int[] variables;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        int n10;
        int n11;
        this.NONE = n11 = -1;
        this.SIZE = n10 = 16;
        this.HASH_SIZE = n10;
        Object[] objectArray = new int[n10];
        this.keys = objectArray;
        objectArray = new int[n10];
        this.nextKeys = objectArray;
        objectArray = new int[n10];
        this.variables = objectArray;
        objectArray = new float[n10];
        this.values = objectArray;
        objectArray = new int[n10];
        this.previous = objectArray;
        int[] nArray = new int[n10];
        this.next = nArray;
        this.mCount = 0;
        this.head = n11;
        this.mRow = arrayRow;
        this.mCache = cache;
        this.clear();
    }

    private void addToHashMap(SolverVariable object, int n10) {
        int n11 = ((SolverVariable)object).id;
        int[] nArray = this.keys;
        Object object2 = this.HASH_SIZE;
        Object object3 = nArray[n11 %= object2];
        int n12 = -1;
        if (object3 == n12) {
            nArray[n11] = n10;
        } else {
            while ((object2 = (Object)(object = (Object)this.nextKeys)[object3]) != n12) {
                object3 = object[object3];
            }
            object[object3] = n10;
        }
        this.nextKeys[n10] = n12;
    }

    private void addVariable(int n10, SolverVariable solverVariable, float f10) {
        int n11;
        int n12;
        int[] nArray = this.variables;
        nArray[n10] = n12 = solverVariable.id;
        this.values[n10] = f10;
        int[] nArray2 = this.previous;
        nArray2[n10] = n11 = -1;
        this.next[n10] = n11;
        ArrayRow arrayRow = this.mRow;
        solverVariable.addToRow(arrayRow);
        solverVariable.usageInRowCount = n10 = solverVariable.usageInRowCount + 1;
        this.mCount = n10 = this.mCount + 1;
    }

    private void displayHash() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.HASH_SIZE); ++i10) {
            Object object = this.keys;
            n10 = object[i10];
            int n11 = -1;
            if (n10 == n11) continue;
            object = new StringBuilder;
            object();
            Object object2 = this.hashCode();
            object.append((int)object2);
            object.append(" hash [");
            object.append(i10);
            object.append("] => ");
            object = object.toString();
            int[] nArray = this.keys;
            object2 = nArray[i10];
            boolean bl2 = false;
            while (!bl2) {
                Object object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(" ");
                n10 = this.variables[object2];
                ((StringBuilder)object3).append(n10);
                object = ((StringBuilder)object3).toString();
                object3 = this.nextKeys;
                Object object4 = object3[object2];
                if (object4 != n11) {
                    object2 = object3[object2];
                    continue;
                }
                bl2 = true;
            }
            PrintStream printStream = System.out;
            printStream.println((String)object);
        }
    }

    private int findEmptySlot() {
        int n10;
        int n11 = 0;
        while (true) {
            int n12 = this.SIZE;
            n10 = -1;
            if (n11 >= n12) break;
            int[] nArray = this.variables;
            n12 = nArray[n11];
            if (n12 == n10) {
                return n11;
            }
            ++n11;
        }
        return n10;
    }

    private void increaseSize() {
        int n10 = this.SIZE * 2;
        Object[] objectArray = Arrays.copyOf(this.variables, n10);
        this.variables = objectArray;
        objectArray = Arrays.copyOf(this.values, n10);
        this.values = objectArray;
        objectArray = Arrays.copyOf(this.previous, n10);
        this.previous = objectArray;
        objectArray = Arrays.copyOf(this.next, n10);
        this.next = objectArray;
        objectArray = Arrays.copyOf(this.nextKeys, n10);
        this.nextKeys = objectArray;
        for (int i10 = this.SIZE; i10 < n10; ++i10) {
            int n11;
            int[] nArray = this.variables;
            nArray[i10] = n11 = -1;
            nArray = this.nextKeys;
            nArray[i10] = n11;
        }
        this.SIZE = n10;
    }

    private void insertVariable(int n10, SolverVariable solverVariable, float f10) {
        int n11;
        int[] nArray;
        int n12 = this.findEmptySlot();
        this.addVariable(n12, solverVariable, f10);
        int n13 = -1;
        f10 = 0.0f / 0.0f;
        if (n10 != n13) {
            int n14;
            this.previous[n12] = n10;
            int[] nArray2 = this.next;
            nArray2[n12] = n14 = nArray2[n10];
            nArray2[n10] = n12;
        } else {
            nArray = this.previous;
            nArray[n12] = n13;
            n10 = this.mCount;
            if (n10 > 0) {
                nArray = this.next;
                nArray[n12] = n11 = this.head;
                this.head = n12;
            } else {
                nArray = this.next;
                nArray[n12] = n13;
            }
        }
        nArray = this.next;
        n11 = nArray[n12];
        if (n11 != n13) {
            int[] nArray3 = this.previous;
            n10 = nArray[n12];
            nArray3[n10] = n12;
        }
        this.addToHashMap(solverVariable, n12);
    }

    private void removeFromHashMap(SolverVariable object) {
        int n10 = ((SolverVariable)object).id;
        int n11 = this.HASH_SIZE;
        int[] nArray = this.keys;
        int n12 = nArray[n11 = n10 % n11];
        int n13 = -1;
        if (n12 == n13) {
            return;
        }
        int[] nArray2 = this.variables;
        Object object2 = nArray2[n12];
        if (object2 == n10) {
            object = this.nextKeys;
            nArray[n11] = object2 = (Object)object[n12];
            object[n12] = n13;
        } else {
            int[] nArray3;
            int n14;
            while ((n14 = (nArray3 = this.nextKeys)[n12]) != n13 && (n14 = (nArray = this.variables)[object2 = nArray3[n12]]) != n10) {
                n12 = nArray3[n12];
            }
            n14 = nArray3[n12];
            if (n14 != n13 && (object2 = (nArray2 = this.variables)[n14]) == n10) {
                nArray3[n12] = n10 = nArray3[n14];
                nArray3[n14] = n13;
            }
        }
    }

    public void add(SolverVariable solverVariable, float f10, boolean bl2) {
        float f11;
        float f12 = epsilon;
        float f13 = -f12;
        float f14 = f10 - f13;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object > 0 && (f11 = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) < 0) {
            return;
        }
        f11 = this.indexOf(solverVariable);
        object = -1;
        f13 = 0.0f / 0.0f;
        if (f11 == object) {
            this.put(solverVariable, f10);
        } else {
            float f15;
            float f16;
            float[] fArray = this.values;
            fArray[f11] = f16 = fArray[f11] + f10;
            f10 = fArray[f11];
            f16 = epsilon;
            float f17 = -f16;
            float f18 = f10 - f17;
            Object object2 = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
            if (object2 > 0 && (object2 = (f15 = (f10 = fArray[f11]) - f16) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) < 0) {
                object2 = false;
                f10 = 0.0f;
                fArray[f11] = 0.0f;
                this.remove(solverVariable, bl2);
            }
        }
    }

    public void clear() {
        int n10;
        int n11;
        int n12 = this.mCount;
        int[] nArray = null;
        for (n11 = 0; n11 < n12; ++n11) {
            SolverVariable solverVariable = this.getVariable(n11);
            if (solverVariable == null) continue;
            ArrayRow arrayRow = this.mRow;
            solverVariable.removeFromRow(arrayRow);
        }
        n12 = 0;
        while (true) {
            n11 = this.SIZE;
            n10 = -1;
            if (n12 >= n11) break;
            this.variables[n12] = n10;
            nArray = this.nextKeys;
            nArray[n12] = n10;
            ++n12;
        }
        for (n12 = 0; n12 < (n11 = this.HASH_SIZE); ++n12) {
            nArray = this.keys;
            nArray[n12] = n10;
        }
        this.mCount = 0;
        this.head = n10;
    }

    public boolean contains(SolverVariable solverVariable) {
        int n10;
        int n11 = this.indexOf(solverVariable);
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            solverVariable = null;
        }
        return n11 != 0;
    }

    public void display() {
        int n10 = this.mCount;
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
        int n10 = this.mCount;
        int n11 = this.head;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f11;
            Object[] objectArray = this.values;
            objectArray[n11] = f11 = objectArray[n11] / f10;
            objectArray = this.next;
            int n12 = -1;
            if ((n11 = (int)objectArray[n11]) == n12) break;
        }
    }

    public float get(SolverVariable solverVariable) {
        int n10;
        int n11 = this.indexOf(solverVariable);
        if (n11 != (n10 = -1)) {
            return this.values[n11];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCount;
    }

    public SolverVariable getVariable(int n10) {
        int n11 = this.mCount;
        if (n11 == 0) {
            return null;
        }
        int n12 = this.head;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13 = -1;
            if (i10 == n10 && n12 != n13) {
                SolverVariable[] solverVariableArray = this.mCache.mIndexedVariables;
                n11 = this.variables[n12];
                return solverVariableArray[n11];
            }
            int[] nArray = this.next;
            if ((n12 = nArray[n12]) == n13) break;
        }
        return null;
    }

    public float getVariableValue(int n10) {
        int n11 = this.mCount;
        int n12 = this.head;
        for (int i10 = 0; i10 < n11; ++i10) {
            if (i10 == n10) {
                return this.values[n12];
            }
            int[] nArray = this.next;
            int n13 = -1;
            if ((n12 = nArray[n12]) == n13) break;
        }
        return 0.0f;
    }

    public int indexOf(SolverVariable solverVariable) {
        int n10 = this.mCount;
        int n11 = -1;
        if (n10 != 0 && solverVariable != null) {
            int n12;
            int[] nArray;
            int n13;
            int n14 = solverVariable.id;
            n10 = this.HASH_SIZE;
            n10 = n14 % n10;
            int[] nArray2 = this.keys;
            if ((n10 = nArray2[n10]) == n11) {
                return n11;
            }
            nArray2 = this.variables;
            int n15 = nArray2[n10];
            if (n15 == n14) {
                return n10;
            }
            while ((n13 = (nArray2 = this.nextKeys)[n10]) != n11 && (n13 = (nArray = this.variables)[n12 = nArray2[n10]]) != n14) {
                n10 = nArray2[n10];
            }
            n13 = nArray2[n10];
            if (n13 == n11) {
                return n11;
            }
            nArray = this.variables;
            n12 = nArray2[n10];
            n13 = nArray[n12];
            if (n13 == n14) {
                return nArray2[n10];
            }
        }
        return n11;
    }

    public void invert() {
        int n10 = this.mCount;
        int n11 = this.head;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object[] objectArray = this.values;
            float f10 = objectArray[n11];
            float f11 = -1.0f;
            objectArray[n11] = f10 *= f11;
            objectArray = this.next;
            int n12 = -1;
            if ((n11 = (int)objectArray[n11]) == n12) break;
        }
    }

    public void put(SolverVariable object, float f10) {
        int n10;
        float f11 = epsilon;
        float f12 = -f11;
        float f13 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        int n11 = 1;
        if (f13 > 0 && (n10 = (int)(f10 == f11 ? 0 : (f10 < f11 ? -1 : 1))) < 0) {
            this.remove((SolverVariable)object, n11 != 0);
            return;
        }
        n10 = this.mCount;
        f13 = 0.0f;
        f12 = 0.0f;
        if (n10 == 0) {
            this.addVariable(0, (SolverVariable)object, f10);
            this.addToHashMap((SolverVariable)object, 0);
            this.head = 0;
        } else {
            int n12;
            n10 = this.indexOf((SolverVariable)object);
            if (n10 != (n12 = -1)) {
                object = this.values;
                object[n10] = f10;
            } else {
                n10 = this.mCount + n11;
                if (n10 >= (n11 = this.SIZE)) {
                    this.increaseSize();
                }
                n10 = this.mCount;
                n11 = this.head;
                int n13 = n12;
                while (f13 < n10) {
                    int[] nArray = this.variables;
                    int n14 = nArray[n11];
                    int n15 = ((SolverVariable)object).id;
                    if (n14 == n15) {
                        this.values[n11] = f10;
                        return;
                    }
                    int n16 = nArray[n11];
                    if (n16 < n15) {
                        n13 = n11;
                    }
                    if ((n11 = (nArray = this.next)[n11]) == n12) break;
                    ++f13;
                }
                this.insertVariable(n13, (SolverVariable)object, f10);
            }
        }
    }

    public float remove(SolverVariable solverVariable, boolean bl2) {
        int n10;
        int[] nArray;
        int[] nArray2;
        int n11;
        int n12 = this.indexOf(solverVariable);
        if (n12 == (n11 = -1)) {
            return 0.0f;
        }
        this.removeFromHashMap(solverVariable);
        float[] fArray = this.values;
        float f10 = fArray[n12];
        int n13 = this.head;
        if (n13 == n12) {
            nArray2 = this.next;
            this.head = n13 = nArray2[n12];
        }
        this.variables[n12] = n11;
        nArray2 = this.previous;
        int n14 = nArray2[n12];
        if (n14 != n11) {
            int n15;
            nArray = this.next;
            n10 = nArray2[n12];
            nArray[n10] = n15 = nArray[n12];
        }
        if ((n10 = (nArray = this.next)[n12]) != n11) {
            n11 = nArray[n12];
            nArray2[n11] = n12 = nArray2[n12];
        }
        this.mCount = n12 = this.mCount + -1;
        solverVariable.usageInRowCount = n12 = solverVariable.usageInRowCount + -1;
        if (bl2) {
            ArrayRow arrayRow = this.mRow;
            solverVariable.removeFromRow(arrayRow);
        }
        return f10;
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        Object object = new StringBuilder();
        int n10 = this.hashCode();
        object.append(n10);
        CharSequence charSequence = " { ";
        object.append((String)charSequence);
        object = object.toString();
        n10 = this.mCount;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = this.getVariable(i10);
            if (object2 == null) continue;
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(object2);
            ((StringBuilder)object3).append(" = ");
            float f10 = this.getVariableValue(i10);
            ((StringBuilder)object3).append(f10);
            ((StringBuilder)object3).append(" ");
            object = ((StringBuilder)object3).toString();
            Object object4 = this.indexOf((SolverVariable)object2);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("[p: ");
            object = ((StringBuilder)object3).toString();
            object3 = this.previous;
            Object object5 = object3[object4];
            Object object6 = "none";
            int n11 = -1;
            if (object5 != n11) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                object = this.mCache.mIndexedVariables;
                int[] nArray = this.variables;
                int[] nArray2 = this.previous;
                int n12 = nArray2[object4];
                int n13 = nArray[n12];
                object = object[n13];
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
            } else {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append((String)object6);
                object = ((StringBuilder)object3).toString();
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(", n: ");
            object = ((StringBuilder)object3).toString();
            object3 = this.next;
            object5 = object3[object4];
            if (object5 != n11) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                object = this.mCache.mIndexedVariables;
                object6 = this.variables;
                int[] nArray = this.next;
                object4 = nArray[object4];
                object4 = object6[object4];
                object = object[object4];
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append((String)object6);
                object = ((StringBuilder)object2).toString();
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("]");
            object = ((StringBuilder)object2).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" }");
        return ((StringBuilder)charSequence).toString();
    }

    public float use(ArrayRow object, boolean bl2) {
        SolverVariable solverVariable = ((ArrayRow)object).variable;
        float f10 = this.get(solverVariable);
        SolverVariable solverVariable2 = ((ArrayRow)object).variable;
        this.remove(solverVariable2, bl2);
        object = (SolverVariableValues)((ArrayRow)object).variables;
        int n10 = ((SolverVariableValues)object).getCurrentSize();
        int n11 = ((SolverVariableValues)object).head;
        n11 = 0;
        int n12 = 0;
        while (n11 < n10) {
            Object object2 = ((SolverVariableValues)object).variables;
            int n13 = object2[n12];
            int n14 = -1;
            if (n13 != n14) {
                float[] fArray = ((SolverVariableValues)object).values;
                float f11 = fArray[n12];
                SolverVariable[] solverVariableArray = this.mCache.mIndexedVariables;
                int n15 = object2[n12];
                object2 = solverVariableArray[n15];
                this.add((SolverVariable)object2, f11 *= f10, bl2);
                ++n11;
            }
            ++n12;
        }
        return f10;
    }
}

