/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Platform;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public final class ObjectArrays {
    private ObjectArrays() {
    }

    public static Object checkElementNotNull(Object object, int n10) {
        if (object != null) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("at index ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new NullPointerException(string2);
        throw object;
    }

    public static Object[] checkElementsNotNull(Object ... objectArray) {
        int n10 = objectArray.length;
        return ObjectArrays.checkElementsNotNull(objectArray, n10);
    }

    public static Object[] checkElementsNotNull(Object[] objectArray, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            ObjectArrays.checkElementNotNull(object, i10);
        }
        return objectArray;
    }

    public static Object[] concat(Object object, Object[] objectArray) {
        int n10 = objectArray.length;
        int n11 = 1;
        Object[] objectArray2 = ObjectArrays.newArray(objectArray, n10 += n11);
        objectArray2[0] = object;
        int n12 = objectArray.length;
        System.arraycopy(objectArray, 0, objectArray2, n11, n12);
        return objectArray2;
    }

    public static Object[] concat(Object[] objectArray, Object object) {
        int n10 = objectArray.length + 1;
        Object[] objectArray2 = Arrays.copyOf(objectArray, n10);
        int n11 = objectArray.length;
        objectArray2[n11] = object;
        return objectArray2;
    }

    public static Object[] concat(Object[] objectArray, Object[] objectArray2, Class objectArray3) {
        int n10 = objectArray.length;
        int n11 = objectArray2.length;
        objectArray3 = ObjectArrays.newArray((Class)objectArray3, n10 += n11);
        n10 = objectArray.length;
        System.arraycopy(objectArray, 0, objectArray3, 0, n10);
        int n12 = objectArray.length;
        n10 = objectArray2.length;
        System.arraycopy(objectArray2, 0, objectArray3, n12, n10);
        return objectArray3;
    }

    public static Object[] copyAsObjectArray(Object[] objectArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = objectArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        n12 = 0;
        if (n11 == 0) {
            return new Object[0];
        }
        Object[] objectArray2 = new Object[n11];
        System.arraycopy(objectArray, n10, objectArray2, 0, n11);
        return objectArray2;
    }

    private static Object[] fillArray(Iterable object, Object[] objectArray) {
        boolean bl2;
        object = object.iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            objectArray[n10] = e10;
            n10 = n11;
        }
        return objectArray;
    }

    public static Object[] newArray(Class clazz, int n10) {
        return (Object[])Array.newInstance(clazz, n10);
    }

    public static Object[] newArray(Object[] objectArray, int n10) {
        return Platform.newArray(objectArray, n10);
    }

    public static void swap(Object[] objectArray, int n10, int n11) {
        Object object;
        Object object2 = objectArray[n10];
        objectArray[n10] = object = objectArray[n11];
        objectArray[n11] = object2;
    }

    public static Object[] toArrayImpl(Collection collection) {
        Object[] objectArray = new Object[collection.size()];
        return ObjectArrays.fillArray(collection, objectArray);
    }

    public static Object[] toArrayImpl(Collection collection, Object[] objectArray) {
        int n10 = objectArray.length;
        int n11 = collection.size();
        if (n10 < n11) {
            objectArray = ObjectArrays.newArray(objectArray, n11);
        }
        ObjectArrays.fillArray(collection, objectArray);
        int n12 = objectArray.length;
        if (n12 > n11) {
            n12 = 0;
            collection = null;
            objectArray[n11] = null;
        }
        return objectArray;
    }

    public static Object[] toArrayImpl(Object[] objectArray, int n10, int n11, Object[] objectArray2) {
        int n12 = n10 + n11;
        int n13 = objectArray.length;
        Preconditions.checkPositionIndexes(n10, n12, n13);
        n12 = objectArray2.length;
        if (n12 < n11) {
            objectArray2 = ObjectArrays.newArray(objectArray2, n11);
        } else {
            n12 = objectArray2.length;
            if (n12 > n11) {
                n12 = 0;
                objectArray2[n11] = null;
            }
        }
        System.arraycopy(objectArray, n10, objectArray2, 0, n11);
        return objectArray2;
    }
}

