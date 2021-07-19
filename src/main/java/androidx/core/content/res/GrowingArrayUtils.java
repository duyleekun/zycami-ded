/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content.res;

import java.lang.reflect.Array;

public final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    public static int[] append(int[] nArray, int n10, int n11) {
        int n12 = n10 + 1;
        int n13 = nArray.length;
        if (n12 > n13) {
            n12 = GrowingArrayUtils.growSize(n10);
            int[] nArray2 = new int[n12];
            n13 = 0;
            System.arraycopy(nArray, 0, nArray2, 0, n10);
            nArray = nArray2;
        }
        nArray[n10] = n11;
        return nArray;
    }

    public static long[] append(long[] lArray, int n10, long l10) {
        int n11 = n10 + 1;
        int n12 = lArray.length;
        if (n11 > n12) {
            n11 = GrowingArrayUtils.growSize(n10);
            long[] lArray2 = new long[n11];
            n12 = 0;
            System.arraycopy(lArray, 0, lArray2, 0, n10);
            lArray = lArray2;
        }
        lArray[n10] = l10;
        return lArray;
    }

    public static Object[] append(Object[] objectArray, int n10, Object object) {
        int n11 = n10 + 1;
        int n12 = objectArray.length;
        if (n11 > n12) {
            Object[] objectArray2 = objectArray.getClass().getComponentType();
            n12 = GrowingArrayUtils.growSize(n10);
            objectArray2 = (Object[])Array.newInstance(objectArray2, n12);
            n12 = 0;
            System.arraycopy(objectArray, 0, objectArray2, 0, n10);
            objectArray = objectArray2;
        }
        objectArray[n10] = object;
        return objectArray;
    }

    public static boolean[] append(boolean[] blArray, int n10, boolean bl2) {
        int n11 = n10 + 1;
        int n12 = blArray.length;
        if (n11 > n12) {
            n11 = GrowingArrayUtils.growSize(n10);
            boolean[] blArray2 = new boolean[n11];
            n12 = 0;
            System.arraycopy(blArray, 0, blArray2, 0, n10);
            blArray = blArray2;
        }
        blArray[n10] = bl2;
        return blArray;
    }

    public static int growSize(int n10) {
        int n11 = 4;
        n10 = n10 <= n11 ? 8 : (n10 *= 2);
        return n10;
    }

    public static int[] insert(int[] nArray, int n10, int n11, int n12) {
        int n13 = n10 + 1;
        int n14 = nArray.length;
        if (n13 <= n14) {
            n13 = n11 + 1;
            System.arraycopy(nArray, n11, nArray, n13, n10 -= n11);
            nArray[n11] = n12;
            return nArray;
        }
        int[] nArray2 = new int[GrowingArrayUtils.growSize(n10)];
        System.arraycopy(nArray, 0, nArray2, 0, n11);
        nArray2[n11] = n12;
        n12 = n11 + 1;
        n13 = nArray.length - n11;
        System.arraycopy(nArray, n11, nArray2, n12, n13);
        return nArray2;
    }

    public static long[] insert(long[] lArray, int n10, int n11, long l10) {
        int n12 = n10 + 1;
        int n13 = lArray.length;
        if (n12 <= n13) {
            n12 = n11 + 1;
            System.arraycopy(lArray, n11, lArray, n12, n10 -= n11);
            lArray[n11] = l10;
            return lArray;
        }
        long[] lArray2 = new long[GrowingArrayUtils.growSize(n10)];
        System.arraycopy(lArray, 0, lArray2, 0, n11);
        lArray2[n11] = l10;
        int n14 = n11 + 1;
        int n15 = lArray.length - n11;
        System.arraycopy(lArray, n11, lArray2, n14, n15);
        return lArray2;
    }

    public static Object[] insert(Object[] objectArray, int n10, int n11, Object object) {
        int n12 = n10 + 1;
        int n13 = objectArray.length;
        if (n12 <= n13) {
            n12 = n11 + 1;
            System.arraycopy(objectArray, n11, objectArray, n12, n10 -= n11);
            objectArray[n11] = object;
            return objectArray;
        }
        Class<?> clazz = objectArray.getClass().getComponentType();
        n10 = GrowingArrayUtils.growSize(n10);
        Object[] objectArray2 = (Object[])Array.newInstance(clazz, n10);
        System.arraycopy(objectArray, 0, objectArray2, 0, n11);
        objectArray2[n11] = object;
        int n14 = n11 + 1;
        n12 = objectArray.length - n11;
        System.arraycopy(objectArray, n11, objectArray2, n14, n12);
        return objectArray2;
    }

    public static boolean[] insert(boolean[] blArray, int n10, int n11, boolean bl2) {
        int n12 = n10 + 1;
        int n13 = blArray.length;
        if (n12 <= n13) {
            n12 = n11 + 1;
            System.arraycopy(blArray, n11, blArray, n12, n10 -= n11);
            blArray[n11] = bl2;
            return blArray;
        }
        boolean[] blArray2 = new boolean[GrowingArrayUtils.growSize(n10)];
        System.arraycopy(blArray, 0, blArray2, 0, n11);
        blArray2[n11] = bl2;
        int n14 = n11 + 1;
        n12 = blArray.length - n11;
        System.arraycopy(blArray, n11, blArray2, n14, n12);
        return blArray2;
    }
}

