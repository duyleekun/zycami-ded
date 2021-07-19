/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Floats;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class Floats$FloatArrayAsList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final float[] array;
    public final int end;
    public final int start;

    public Floats$FloatArrayAsList(float[] fArray) {
        int n10 = fArray.length;
        this(fArray, 0, n10);
    }

    public Floats$FloatArrayAsList(float[] fArray, int n10, int n11) {
        this.array = fArray;
        this.start = n10;
        this.end = n11;
    }

    public boolean contains(Object object) {
        int n10;
        int n11;
        float f10;
        float[] fArray;
        int n12;
        int n13 = object instanceof Float;
        if (n13 != 0 && (n12 = Floats.access$000(fArray = this.array, f10 = ((Float)(object = (Float)object)).floatValue(), n11 = this.start, n10 = this.end)) != (n13 = -1)) {
            n12 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n12 = 0;
            f10 = 0.0f;
            object = null;
        }
        return n12 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Floats$FloatArrayAsList;
        if (n10 != 0) {
            object = (Floats$FloatArrayAsList)object;
            n10 = this.size();
            int n11 = ((Floats$FloatArrayAsList)object).size();
            if (n11 != n10) {
                return false;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                float[] fArray = this.array;
                int n12 = this.start + n11;
                float f10 = fArray[n12];
                float[] fArray2 = ((Floats$FloatArrayAsList)object).array;
                int n13 = ((Floats$FloatArrayAsList)object).start + n11;
                float f11 = fArray2[n13];
                float f12 = f10 - f11;
                Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                if (object2 == false) continue;
                return false;
            }
            return bl2;
        }
        return super.equals(object);
    }

    public Float get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        float[] fArray = this.array;
        int n12 = this.start + n10;
        return Float.valueOf(fArray[n12]);
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            n11 *= 31;
            float[] fArray = this.array;
            float f10 = fArray[i10];
            n10 = Floats.hashCode(f10);
            n11 += n10;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10;
        int n11;
        float f10;
        float[] fArray;
        int n12;
        int n13 = object instanceof Float;
        if (n13 != 0 && (n12 = Floats.access$000(fArray = this.array, f10 = ((Float)(object = (Float)object)).floatValue(), n11 = this.start, n10 = this.end)) >= 0) {
            n13 = this.start;
            return n12 - n13;
        }
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public int lastIndexOf(Object object) {
        int n10;
        int n11;
        float f10;
        float[] fArray;
        int n12;
        int n13 = object instanceof Float;
        if (n13 != 0 && (n12 = Floats.access$100(fArray = this.array, f10 = ((Float)(object = (Float)object)).floatValue(), n11 = this.start, n10 = this.end)) >= 0) {
            n13 = this.start;
            return n12 - n13;
        }
        return -1;
    }

    public Float set(int n10, Float f10) {
        float f11;
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        float[] fArray = this.array;
        int n12 = this.start;
        int n13 = n12 + n10;
        float f12 = fArray[n13];
        fArray[n12 += n10] = f11 = ((Float)Preconditions.checkNotNull(f10)).floatValue();
        return Float.valueOf(f12);
    }

    public int size() {
        int n10 = this.end;
        int n11 = this.start;
        return n10 - n11;
    }

    public List subList(int n10, int n11) {
        int n12 = this.size();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        if (n10 == n11) {
            return Collections.emptyList();
        }
        float[] fArray = this.array;
        int n13 = this.start;
        n10 += n13;
        Floats$FloatArrayAsList floats$FloatArrayAsList = new Floats$FloatArrayAsList(fArray, n10, n13 += n11);
        return floats$FloatArrayAsList;
    }

    public float[] toFloatArray() {
        float[] fArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(fArray, n10, n11);
    }

    public String toString() {
        int n10 = this.size() * 12;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('[');
        float[] fArray = this.array;
        int n11 = this.start;
        float f10 = fArray[n11];
        stringBuilder.append(f10);
        n10 = this.start;
        while (++n10 < (n11 = this.end)) {
            stringBuilder.append(", ");
            float[] fArray2 = this.array;
            float f11 = fArray2[n10];
            stringBuilder.append(f11);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

