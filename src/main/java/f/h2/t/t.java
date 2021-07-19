/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public final class t {
    private static final Object[] a = new Object[0];
    private static final int b = 0x7FFFFFFD;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static final Object[] a(Collection object) {
        void var0_7;
        Iterator iterator2;
        int n10;
        String string2 = "collection";
        f0.p(object, string2);
        int n11 = object.size();
        if (n11 == 0 || (n10 = (iterator2 = object.iterator()).hasNext()) == 0) {
            Object[] objectArray = a;
            return var0_7;
        }
        Object[] objectArray = new Object[n11];
        n10 = 0;
        String string3 = null;
        while (true) {
            void var1_10;
            Object e10;
            int n12 = n10 + 1;
            var1_10[n10] = e10 = iterator2.next();
            n10 = ((void)var1_10).length;
            if (n12 >= n10) {
                n10 = (int)(iterator2.hasNext() ? 1 : 0);
                if (n10 == 0) {
                    void var0_4 = var1_10;
                    return var0_7;
                }
                n10 = n12 * 3 + 1 >>> 1;
                int n13 = 0x7FFFFFFD;
                if (n10 <= n12) {
                    if (n12 >= n13) {
                        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
                        throw outOfMemoryError;
                    }
                    n10 = n13;
                }
                T[] TArray = Arrays.copyOf(var1_10, n10);
                string3 = "Arrays.copyOf(result, newSize)";
                f0.o(TArray, string3);
            } else {
                n10 = (int)(iterator2.hasNext() ? 1 : 0);
                if (n10 == 0) {
                    T[] TArray = Arrays.copyOf(var1_10, n12);
                    String string4 = "Arrays.copyOf(result, size)";
                    f0.o(TArray, string4);
                    return var0_7;
                }
            }
            n10 = n12;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Object[] b(Collection object, Object[] objectArray) {
        String string2 = "collection";
        f0.p(object, string2);
        Objects.requireNonNull(objectArray);
        int n10 = object.size();
        int n11 = 0;
        String string3 = null;
        if (n10 == 0) {
            int n12 = objectArray.length;
            if (n12 <= 0) return objectArray;
            objectArray[0] = null;
            return objectArray;
        }
        int n13 = (object = object.iterator()).hasNext();
        if (n13 == 0) {
            int n14 = objectArray.length;
            if (n14 <= 0) return objectArray;
            objectArray[0] = null;
            return objectArray;
        }
        n13 = objectArray.length;
        if (n10 <= n13) {
            Object[] objectArray2 = objectArray;
        } else {
            Object object2 = Array.newInstance(objectArray.getClass().getComponentType(), n10);
            String string4 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
            Objects.requireNonNull(object2, string4);
            Object[] objectArray3 = (Object[])object2;
        }
        while (true) {
            void var2_6;
            Object e10;
            n13 = n11 + 1;
            var2_6[n11] = e10 = object.next();
            n11 = ((void)var2_6).length;
            if (n13 >= n11) {
                n11 = (int)(object.hasNext() ? 1 : 0);
                if (n11 == 0) {
                    return var2_6;
                }
                n11 = n13 * 3 + 1 >>> 1;
                int n15 = 0x7FFFFFFD;
                if (n11 <= n13) {
                    if (n13 < n15) {
                        n11 = n15;
                    } else {
                        object = new OutOfMemoryError();
                        throw object;
                    }
                }
                T[] TArray = Arrays.copyOf(var2_6, n11);
                string3 = "Arrays.copyOf(result, newSize)";
                f0.o(TArray, string3);
            } else {
                n11 = (int)(object.hasNext() ? 1 : 0);
                if (n11 == 0) {
                    if (var2_6 == objectArray) {
                        objectArray[n13] = null;
                        return objectArray;
                    } else {
                        objectArray = Arrays.copyOf(var2_6, n13);
                        object = "Arrays.copyOf(result, size)";
                        f0.o(objectArray, (String)object);
                    }
                    return objectArray;
                }
            }
            n11 = n13;
        }
    }

    private static final Object[] c(Collection object, a objectArray, l object2, p p10) {
        int n10 = object.size();
        if (n10 == 0) {
            return (Object[])objectArray.invoke();
        }
        int n11 = (object = object.iterator()).hasNext();
        if (n11 == 0) {
            return (Object[])objectArray.invoke();
        }
        objectArray = n10;
        objectArray = (Object[])object2.invoke(objectArray);
        int n12 = 0;
        object2 = null;
        while (true) {
            n10 = n12 + 1;
            Object e10 = object.next();
            objectArray[n12] = e10;
            n12 = objectArray.length;
            if (n10 >= n12) {
                n12 = (int)(object.hasNext() ? 1 : 0);
                if (n12 == 0) {
                    return objectArray;
                }
                n12 = n10 * 3 + 1 >>> 1;
                n11 = 0x7FFFFFFD;
                if (n12 <= n10) {
                    if (n10 < n11) {
                        n12 = n11;
                    } else {
                        object = new OutOfMemoryError();
                        throw object;
                    }
                }
                objectArray = Arrays.copyOf(objectArray, n12);
                object2 = "Arrays.copyOf(result, newSize)";
                f0.o(objectArray, (String)object2);
            } else {
                n12 = (int)(object.hasNext() ? 1 : 0);
                if (n12 == 0) {
                    object = n10;
                    return (Object[])p10.invoke(objectArray, object);
                }
            }
            n12 = n10;
        }
    }
}

