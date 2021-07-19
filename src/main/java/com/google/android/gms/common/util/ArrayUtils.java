/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static Object[] appendToArray(Object[] objectArray, Object object) {
        int n10;
        if (objectArray == null && object == null) {
            objectArray = new IllegalArgumentException("Cannot generate array of generic type w/o class info");
            throw objectArray;
        }
        int n11 = 1;
        if (objectArray == null) {
            objectArray = (Object[])Array.newInstance(object.getClass(), n11);
        } else {
            n10 = objectArray.length + n11;
            objectArray = Arrays.copyOf(objectArray, n10);
        }
        n10 = objectArray.length - n11;
        objectArray[n10] = object;
        return objectArray;
    }

    public static Object[] concat(Object[] ... objectArray) {
        int n10;
        int n11;
        int n12 = objectArray.length;
        if (n12 == 0) {
            return (Object[])Array.newInstance(objectArray.getClass(), 0);
        }
        Object[] objectArray2 = null;
        int n13 = 0;
        Object[] objectArray3 = null;
        for (n12 = 0; n12 < (n11 = objectArray.length); ++n12) {
            Object[] objectArray4 = objectArray[n12];
            n11 = objectArray4.length;
            n13 += n11;
        }
        objectArray2 = Arrays.copyOf(objectArray[0], n13);
        objectArray3 = objectArray[0];
        n13 = objectArray3.length;
        for (n11 = 1; n11 < (n10 = objectArray.length); ++n11) {
            Object[] objectArray5 = objectArray[n11];
            int n14 = objectArray5.length;
            System.arraycopy(objectArray5, 0, objectArray2, n13, n14);
            n10 = objectArray5.length;
            n13 += n10;
        }
        return objectArray2;
    }

    public static byte[] concatByteArrays(byte[] ... byArray) {
        int n10;
        int n11;
        int n12 = byArray.length;
        if (n12 == 0) {
            return new byte[0];
        }
        byte[] byArray2 = null;
        int n13 = 0;
        byte[] byArray3 = null;
        for (n12 = 0; n12 < (n11 = byArray.length); ++n12) {
            byte[] byArray4 = byArray[n12];
            n11 = byArray4.length;
            n13 += n11;
        }
        byArray2 = Arrays.copyOf(byArray[0], n13);
        byArray3 = byArray[0];
        n13 = byArray3.length;
        for (n11 = 1; n11 < (n10 = byArray.length); ++n11) {
            byte[] byArray5 = byArray[n11];
            int n14 = byArray5.length;
            System.arraycopy(byArray5, 0, byArray2, n13, n14);
            n10 = byArray5.length;
            n13 += n10;
        }
        return byArray2;
    }

    public static boolean contains(int[] nArray, int n10) {
        if (nArray == null) {
            return false;
        }
        for (int n11 : nArray) {
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(Object[] objectArray, Object object) {
        int n10;
        block2: {
            int n11 = objectArray != null ? objectArray.length : 0;
            for (n10 = 0; n10 < n11; ++n10) {
                Object object2 = objectArray[n10];
                boolean bl2 = Objects.equal(object2, object);
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10 >= 0;
    }

    public static ArrayList newArrayList() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public static Object[] removeAll(Object[] objectArray, Object ... objectArray2) {
        int n10;
        if (objectArray == null) {
            return null;
        }
        if (objectArray2 != null && (n10 = objectArray2.length) != 0) {
            int n11;
            Object[] objectArray3 = objectArray2.getClass().getComponentType();
            int n12 = objectArray.length;
            objectArray3 = (Object[])Array.newInstance(objectArray3, n12);
            n12 = objectArray2.length;
            int n13 = 1;
            if (n12 == n13) {
                n12 = objectArray.length;
                n11 = 0;
                Object var8_8 = null;
                for (n13 = 0; n13 < n12; ++n13) {
                    Object object = objectArray2[0];
                    Object object2 = objectArray[n13];
                    int n14 = Objects.equal(object, object2);
                    if (n14 != 0) continue;
                    n14 = n11 + 1;
                    objectArray3[n11] = object2;
                    n11 = n14;
                }
            } else {
                n12 = objectArray.length;
                n13 = 0;
                for (int i10 = 0; i10 < n12; ++i10) {
                    Object object = objectArray[i10];
                    int n15 = ArrayUtils.contains(objectArray2, object);
                    if (n15 != 0) continue;
                    n15 = n13 + 1;
                    objectArray3[n13] = object;
                    n13 = n15;
                }
                n11 = n13;
            }
            if (objectArray3 == null) {
                return null;
            }
            int n16 = objectArray3.length;
            if (n11 != n16) {
                objectArray3 = Arrays.copyOf(objectArray3, n11);
            }
            return objectArray3;
        }
        int n17 = objectArray.length;
        return Arrays.copyOf(objectArray, n17);
    }

    public static ArrayList toArrayList(Object[] objectArray) {
        int n10 = objectArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            arrayList.add(object);
        }
        return arrayList;
    }

    public static int[] toPrimitiveArray(Collection object) {
        int n10;
        int n11 = 0;
        if (object != null && (n10 = object.size()) != 0) {
            int n12;
            n10 = object.size();
            int[] nArray = new int[n10];
            object = object.iterator();
            while ((n12 = object.hasNext()) != 0) {
                Integer n13 = (Integer)object.next();
                int n14 = n11 + 1;
                nArray[n11] = n12 = n13.intValue();
                n11 = n14;
            }
            return nArray;
        }
        return new int[0];
    }

    public static Integer[] toWrapperArray(int[] nArray) {
        if (nArray == null) {
            return null;
        }
        int n10 = nArray.length;
        Integer[] integerArray = new Integer[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Integer n11;
            int n12 = nArray[i10];
            integerArray[i10] = n11 = Integer.valueOf(n12);
        }
        return integerArray;
    }

    public static void writeArray(StringBuilder stringBuilder, double[] dArray) {
        int n10 = dArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                stringBuilder.append(string2);
            }
            double d10 = dArray[i10];
            string2 = Double.toString(d10);
            stringBuilder.append(string2);
        }
    }

    public static void writeArray(StringBuilder stringBuilder, float[] fArray) {
        int n10 = fArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                stringBuilder.append(string2);
            }
            float f10 = fArray[i10];
            string2 = Float.toString(f10);
            stringBuilder.append(string2);
        }
    }

    public static void writeArray(StringBuilder stringBuilder, int[] nArray) {
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                stringBuilder.append(string2);
            }
            int n11 = nArray[i10];
            string2 = Integer.toString(n11);
            stringBuilder.append(string2);
        }
    }

    public static void writeArray(StringBuilder stringBuilder, long[] lArray) {
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                stringBuilder.append(string2);
            }
            long l10 = lArray[i10];
            string2 = Long.toString(l10);
            stringBuilder.append(string2);
        }
    }

    public static void writeArray(StringBuilder stringBuilder, Object[] objectArray) {
        int n10 = objectArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                stringBuilder.append(string2);
            }
            string2 = objectArray[i10].toString();
            stringBuilder.append(string2);
        }
    }

    public static void writeArray(StringBuilder stringBuilder, boolean[] blArray) {
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                stringBuilder.append(string2);
            }
            boolean bl2 = blArray[i10];
            string2 = Boolean.toString(bl2);
            stringBuilder.append(string2);
        }
    }

    public static void writeStringArray(StringBuilder stringBuilder, String[] stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                stringBuilder.append(string2);
            }
            string2 = "\"";
            stringBuilder.append(string2);
            String string3 = stringArray[i10];
            stringBuilder.append(string3);
            stringBuilder.append(string2);
        }
    }
}

