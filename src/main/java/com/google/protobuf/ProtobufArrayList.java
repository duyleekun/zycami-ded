/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import java.util.Arrays;
import java.util.RandomAccess;

public final class ProtobufArrayList
extends AbstractProtobufList
implements RandomAccess {
    private static final ProtobufArrayList EMPTY_LIST;
    private Object[] array;
    private int size;

    static {
        ProtobufArrayList protobufArrayList;
        Object[] objectArray = new Object[]{};
        EMPTY_LIST = protobufArrayList = new ProtobufArrayList(objectArray, 0);
        protobufArrayList.makeImmutable();
    }

    public ProtobufArrayList() {
        Object[] objectArray = new Object[10];
        this(objectArray, 0);
    }

    private ProtobufArrayList(Object[] objectArray, int n10) {
        this.array = objectArray;
        this.size = n10;
    }

    private static Object[] createArray(int n10) {
        return new Object[n10];
    }

    public static ProtobufArrayList emptyList() {
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

    public void add(int n10, Object object) {
        int n11;
        this.ensureIsMutable();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            Object[] objectArray = this.array;
            int n12 = objectArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(objectArray, n10, objectArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                Object[] objectArray2 = ProtobufArrayList.createArray(n11);
                System.arraycopy(this.array, 0, objectArray2, 0, n10);
                objectArray = this.array;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(objectArray, n10, objectArray2, n12, n13);
                this.array = objectArray2;
            }
            this.array[n10] = object;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public boolean add(Object object) {
        int n10;
        Object[] objectArray;
        this.ensureIsMutable();
        int n11 = this.size;
        Object[] objectArray2 = this.array;
        int n12 = objectArray2.length;
        int n13 = 1;
        if (n11 == n12) {
            n11 = n11 * 3 / 2 + n13;
            this.array = objectArray = Arrays.copyOf(objectArray2, n11);
        }
        objectArray = this.array;
        int n14 = this.size;
        this.size = n12 = n14 + 1;
        objectArray[n14] = object;
        this.modCount = n10 = this.modCount + n13;
        return n13 != 0;
    }

    public Object get(int n10) {
        this.ensureIndexInRange(n10);
        return this.array[n10];
    }

    public ProtobufArrayList mutableCopyWithCapacity(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            Object[] objectArray = Arrays.copyOf(this.array, n10);
            int n12 = this.size;
            ProtobufArrayList protobufArrayList = new ProtobufArrayList(objectArray, n12);
            return protobufArrayList;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public Object remove(int n10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        Object[] objectArray = this.array;
        Object object = objectArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(objectArray, n12, objectArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return object;
    }

    public Object set(int n10, Object object) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        Object[] objectArray = this.array;
        Object object2 = objectArray[n10];
        objectArray[n10] = object;
        this.modCount = n10 = this.modCount + 1;
        return object2;
    }

    public int size() {
        return this.size;
    }
}

