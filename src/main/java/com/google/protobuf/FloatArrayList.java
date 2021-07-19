/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$FloatList;
import com.google.protobuf.PrimitiveNonBoxingCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class FloatArrayList
extends AbstractProtobufList
implements Internal$FloatList,
RandomAccess,
PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST;
    private float[] array;
    private int size;

    static {
        FloatArrayList floatArrayList;
        float[] fArray = new float[]{};
        EMPTY_LIST = floatArrayList = new FloatArrayList(fArray, 0);
        floatArrayList.makeImmutable();
    }

    public FloatArrayList() {
        float[] fArray = new float[10];
        this(fArray, 0);
    }

    private FloatArrayList(float[] fArray, int n10) {
        this.array = fArray;
        this.size = n10;
    }

    private void addFloat(int n10, float f10) {
        int n11;
        this.ensureIsMutable();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            float[] fArray = this.array;
            int n12 = fArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(fArray, n10, fArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                float[] fArray2 = new float[n11];
                System.arraycopy(fArray, 0, fArray2, 0, n10);
                fArray = this.array;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(fArray, n10, fArray2, n12, n13);
                this.array = fArray2;
            }
            this.array[n10] = f10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static FloatArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size)) {
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private String makeOutOfBoundsExceptionMessage(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index:");
        stringBuilder.append(n10);
        stringBuilder.append(", Size:");
        n10 = this.size;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public void add(int n10, Float f10) {
        float f11 = f10.floatValue();
        this.addFloat(n10, f11);
    }

    public boolean add(Float f10) {
        float f11 = f10.floatValue();
        this.addFloat(f11);
        return true;
    }

    public boolean addAll(Collection object) {
        this.ensureIsMutable();
        Internal.checkNotNull(object);
        int n10 = object instanceof FloatArrayList;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (FloatArrayList)object;
        n10 = ((FloatArrayList)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            float[] fArray = this.array;
            n12 = fArray.length;
            if ((n11 += n10) > n12) {
                this.array = fArray = Arrays.copyOf(fArray, n11);
            }
            fArray = ((FloatArrayList)object).array;
            float[] fArray2 = this.array;
            int n13 = this.size;
            int n14 = ((FloatArrayList)object).size;
            System.arraycopy(fArray, 0, fArray2, n13, n14);
            this.size = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public void addFloat(float f10) {
        this.ensureIsMutable();
        int n10 = this.size;
        float[] fArray = this.array;
        int n11 = fArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            float[] fArray2 = new float[n11];
            System.arraycopy(fArray, 0, fArray2, 0, n10);
            this.array = fArray2;
        }
        float[] fArray3 = this.array;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        fArray3[n12] = f10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof FloatArrayList;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (FloatArrayList)object;
        n10 = this.size;
        int n11 = ((FloatArrayList)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((FloatArrayList)object).array;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            Object object2;
            int n12;
            float[] fArray = this.array;
            float f10 = fArray[n10];
            n11 = Float.floatToIntBits(f10);
            if (n11 == (n12 = Float.floatToIntBits((float)(object2 = object[n10])))) continue;
            return false;
        }
        return bl2;
    }

    public Float get(int n10) {
        return Float.valueOf(this.getFloat(n10));
    }

    public float getFloat(int n10) {
        this.ensureIndexInRange(n10);
        return this.array[n10];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            float[] fArray = this.array;
            float f10 = fArray[i10];
            n10 = Float.floatToIntBits(f10);
            n11 += n10;
        }
        return n11;
    }

    public Internal$FloatList mutableCopyWithCapacity(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            float[] fArray = Arrays.copyOf(this.array, n10);
            int n12 = this.size;
            FloatArrayList floatArrayList = new FloatArrayList(fArray, n12);
            return floatArrayList;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public Float remove(int n10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        float[] fArray = this.array;
        float f10 = fArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(fArray, n12, fArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return Float.valueOf(f10);
    }

    public boolean remove(Object object) {
        int n10;
        this.ensureIsMutable();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            float f10 = this.array[i10];
            Float f11 = Float.valueOf(f10);
            n10 = (int)(object.equals(f11) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.array;
            n11 = i10 + 1;
            n10 = this.size - i10;
            int n13 = 1;
            System.arraycopy(object, n11, object, i10, n10 -= n13);
            this.size = n12 = this.size - n13;
            this.modCount = n12 = this.modCount + n13;
            return n13 != 0;
        }
        return false;
    }

    public void removeRange(int n10, int n11) {
        this.ensureIsMutable();
        if (n11 >= n10) {
            float[] fArray = this.array;
            int n12 = this.size - n11;
            System.arraycopy(fArray, n11, fArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public Float set(int n10, Float f10) {
        float f11 = f10.floatValue();
        return Float.valueOf(this.setFloat(n10, f11));
    }

    public float setFloat(int n10, float f10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        float[] fArray = this.array;
        float f11 = fArray[n10];
        fArray[n10] = f10;
        return f11;
    }

    public int size() {
        return this.size;
    }
}

