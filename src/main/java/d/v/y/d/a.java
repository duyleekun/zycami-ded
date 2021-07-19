/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

import java.util.Arrays;

public class a {
    private static final int[] a = new int[0];
    private static final byte[] b = new byte[0];

    public static byte[] a(byte[] byArray, byte[] ... byArray2) {
        int n10;
        int n11 = byArray.length;
        for (byte[] byArray3 : byArray2) {
            n10 = byArray3.length;
            n11 += n10;
        }
        byte[] byArray4 = Arrays.copyOf(byArray, n11);
        int n12 = byArray.length;
        for (byte[] byArray3 : byArray2) {
            int n13 = byArray3.length;
            System.arraycopy(byArray3, 0, byArray4, n12, n13);
            n10 = byArray3.length;
            n12 += n10;
        }
        return byArray4;
    }

    public static byte[] b() {
        return b;
    }

    public static int[] c() {
        return a;
    }

    public static byte[] d(byte[] byArray, int n10) {
        int n11 = byArray.length;
        return Arrays.copyOfRange(byArray, n10, n11);
    }

    public static byte[] e(byte[] byArray, int n10, int n11) {
        return Arrays.copyOfRange(byArray, n10, n11 += n10);
    }

    public static int[] f(int[] nArray, int n10, int n11) {
        return Arrays.copyOfRange(nArray, n10, n11 += n10);
    }

    public static Object[] g(Object[] objectArray, int n10, int n11) {
        return Arrays.copyOfRange(objectArray, n10, n11 += n10);
    }

    public static String h(byte[] byArray) {
        if (byArray == null) {
            return "null";
        }
        int n10 = byArray.length;
        int n11 = 1;
        int n12 = -1;
        if ((n10 -= n11) == n12) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int n13 = 0;
        while (true) {
            Object object;
            Object object2 = new Object[n11];
            int n14 = byArray[n13] & 0xFF;
            object2[0] = object = Integer.valueOf(n14);
            object = "%02x";
            object2 = String.format((String)object, object2);
            stringBuilder.append((String)object2);
            if (n13 == n10) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            object2 = ",";
            stringBuilder.append((String)object2);
            ++n13;
        }
    }
}

