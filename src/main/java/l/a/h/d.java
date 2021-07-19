/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.ConcurrentModificationException;
import java.util.Map;
import l.a.h.a;
import l.a.h.b;

public class d {
    private static final boolean d = false;
    private static final String e = "ArrayMap";
    private static final boolean f = true;
    private static final int g = 4;
    private static final int h = 10;
    public static Object[] i;
    public static int j;
    public static Object[] k;
    public static int l;
    public int[] a;
    public Object[] b;
    public int c;

    public d() {
        Object[] objectArray = l.a.h.b.a;
        this.a = objectArray;
        objectArray = l.a.h.b.c;
        this.b = objectArray;
        this.c = 0;
    }

    public d(int n10) {
        if (n10 == 0) {
            Object[] objectArray = l.a.h.b.a;
            this.a = objectArray;
            objectArray = l.a.h.b.c;
            this.b = objectArray;
        } else {
            this.b(n10);
        }
        this.c = 0;
    }

    public d(d d10) {
        this();
        if (d10 != null) {
            this.l(d10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(int n10) {
        int[] nArray = null;
        int n11 = 1;
        int n12 = 8;
        if (n10 == n12) {
            Class<a> clazz = a.class;
            synchronized (clazz) {
                Object[] objectArray = k;
                if (objectArray != null) {
                    this.b = objectArray;
                    Object object = objectArray[0];
                    object = object;
                    k = object;
                    object = objectArray[n11];
                    object = (int[])object;
                    this.a = (int[])object;
                    objectArray[n11] = null;
                    objectArray[0] = null;
                    l = n10 = l - n11;
                    return;
                }
            }
        } else {
            n12 = 4;
            if (n10 == n12) {
                Class<a> clazz = a.class;
                synchronized (clazz) {
                    Object[] objectArray = i;
                    if (objectArray != null) {
                        this.b = objectArray;
                        Object object = objectArray[0];
                        object = object;
                        i = object;
                        object = objectArray[n11];
                        object = (int[])object;
                        this.a = (int[])object;
                        objectArray[n11] = null;
                        objectArray[0] = null;
                        j = n10 = j - n11;
                        return;
                    }
                }
            }
        }
        nArray = new int[n10];
        this.a = nArray;
        Object[] objectArray = new Object[n10 << n11];
        this.b = objectArray;
    }

    private static int c(int[] object, int n10, int n11) {
        try {
            return l.a.h.b.a(object, n10, n11);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            object = new ConcurrentModificationException;
            object();
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void f(int[] nArray, Object[] objectArray, int n10) {
        int n11 = nArray.length;
        int n12 = 2;
        int n13 = 10;
        int n14 = 1;
        int n15 = 8;
        if (n11 == n15) {
            Class<a> clazz = a.class;
            synchronized (clazz) {
                Object[] objectArray2;
                n15 = l;
                if (n15 >= n13) return;
                objectArray[0] = objectArray2 = k;
                objectArray[n14] = nArray;
                int n16 = (n10 << 1) - n14;
                while (true) {
                    if (n16 < n12) {
                        k = objectArray;
                        l = n16 = l + n14;
                        return;
                    }
                    objectArray[n16] = null;
                    n16 += -1;
                }
            }
        }
        n11 = nArray.length;
        n15 = 4;
        if (n11 != n15) return;
        Class<a> clazz = a.class;
        synchronized (clazz) {
            Object[] objectArray3;
            n15 = j;
            if (n15 >= n13) return;
            objectArray[0] = objectArray3 = i;
            objectArray[n14] = nArray;
            int n17 = (n10 << 1) - n14;
            while (true) {
                if (n17 < n12) {
                    i = objectArray;
                    j = n17 = j + n14;
                    return;
                }
                objectArray[n17] = null;
                n17 += -1;
            }
        }
    }

    public void clear() {
        int n10 = this.c;
        if (n10 > 0) {
            int[] nArray = this.a;
            Object[] objectArray = this.b;
            Object[] objectArray2 = l.a.h.b.a;
            this.a = objectArray2;
            objectArray2 = l.a.h.b.c;
            this.b = objectArray2;
            objectArray2 = null;
            this.c = 0;
            l.a.h.d.f(nArray, objectArray, n10);
        }
        if ((n10 = this.c) <= 0) {
            return;
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public boolean containsKey(Object object) {
        int n10 = this.h(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean containsValue(Object object) {
        int n10 = this.j(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public void e(int n10) {
        Object[] objectArray;
        int n11 = this.c;
        int[] nArray = this.a;
        int n12 = nArray.length;
        if (n12 < n10) {
            Object[] objectArray2 = this.b;
            this.b(n10);
            n10 = this.c;
            if (n10 > 0) {
                objectArray = this.a;
                System.arraycopy(nArray, 0, objectArray, 0, n11);
                objectArray = this.b;
                int n13 = n11 << 1;
                System.arraycopy(objectArray2, 0, objectArray, 0, n13);
            }
            l.a.h.d.f(nArray, objectArray2, n11);
        }
        if ((n10 = this.c) == n11) {
            return;
        }
        objectArray = new ConcurrentModificationException();
        throw objectArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        block15: {
            int n12;
            int n10;
            boolean bl2;
            block16: {
                int n11;
                block14: {
                    block13: {
                        bl2 = true;
                        if (this == object) {
                            return bl2;
                        }
                        n10 = object instanceof d;
                        if (n10 == 0) break block13;
                        object = (d)object;
                        n10 = this.size();
                        if (n10 != (n11 = ((d)object).size())) {
                            return false;
                        }
                        break block14;
                    }
                    n10 = object instanceof Map;
                    if (n10 == 0) break block15;
                    object = (Map)object;
                    n10 = this.size();
                    if (n10 != (n12 = object.size())) {
                        return false;
                    }
                    break block16;
                }
                n10 = 0;
                try {
                    while (true) {
                        if (n10 >= (n11 = this.c)) {
                            return bl2;
                        }
                        Object object4 = this.k(n10);
                        Object object3 = this.o(n10);
                        Object object2 = ((d)object).get(object4);
                        if (object3 == null ? object2 != null || (n11 = (int)(((d)object).containsKey(object4) ? 1 : 0)) == 0 : (n11 = (int)(object3.equals(object2) ? 1 : 0)) == 0) {
                            return false;
                        }
                        ++n10;
                    }
                }
                catch (ClassCastException | NullPointerException runtimeException) {
                    return false;
                }
            }
            n10 = 0;
            try {
                while (true) {
                    if (n10 >= (n12 = this.c)) {
                        return bl2;
                    }
                    Object object6 = this.k(n10);
                    Object object5 = this.o(n10);
                    Object v10 = object.get(object6);
                    if (object5 == null ? v10 != null || (n12 = (int)(object.containsKey(object6) ? 1 : 0)) == 0 : (n12 = (int)(object5.equals(v10) ? 1 : 0)) == 0) {
                        return false;
                    }
                    ++n10;
                }
            }
            catch (ClassCastException | NullPointerException runtimeException) {}
        }
        return false;
    }

    public int g(Object object, int n10) {
        Object object2;
        Object object3;
        int n11 = this.c;
        if (n11 == 0) {
            return -1;
        }
        int[] nArray = this.a;
        int n12 = l.a.h.d.c(nArray, n11, n10);
        if (n12 < 0) {
            return n12;
        }
        Object object4 = this.b;
        int n13 = n12 << 1;
        int n14 = object.equals(object4 = object4[n13]);
        if (n14 != 0) {
            return n12;
        }
        for (n14 = n12 + 1; n14 < n11 && (n13 = (object3 = this.a)[n14]) == n10; ++n14) {
            object3 = this.b;
            int n15 = n14 << 1;
            n13 = (int)(object.equals(object3 = (Object)object3[n15]) ? 1 : 0);
            if (n13 == 0) continue;
            return n14;
        }
        n12 += -1;
        while (n12 >= 0 && (n11 = (object2 = this.a)[n12]) == n10) {
            object2 = this.b;
            n13 = n12 << 1;
            n11 = (int)(object.equals(object2 = (Object)object2[n13]) ? 1 : 0);
            if (n11 != 0) {
                return n12;
            }
            n12 += -1;
        }
        return ~n14;
    }

    public Object get(Object object) {
        int n10 = this.h(object);
        if (n10 >= 0) {
            Object[] objectArray = this.b;
            n10 = (n10 << 1) + 1;
            object = objectArray[n10];
        } else {
            n10 = 0;
            object = null;
        }
        return object;
    }

    public int h(Object object) {
        int n10;
        if (object == null) {
            n10 = this.i();
        } else {
            int n11 = object.hashCode();
            n10 = this.g(object, n11);
        }
        return n10;
    }

    public int hashCode() {
        int[] nArray = this.a;
        Object[] objectArray = this.b;
        int n10 = this.c;
        int n11 = 1;
        int n12 = 0;
        int n13 = 0;
        while (n12 < n10) {
            int n14;
            Object object = objectArray[n11];
            int n15 = nArray[n12];
            if (object == null) {
                n14 = 0;
                object = null;
            } else {
                n14 = object.hashCode();
            }
            n13 += (n14 ^= n15);
            ++n12;
            n11 += 2;
        }
        return n13;
    }

    public int i() {
        Object object;
        Object object2;
        int n10 = this.c;
        if (n10 == 0) {
            return -1;
        }
        int[] nArray = this.a;
        int n11 = 0;
        Object object3 = null;
        int n12 = l.a.h.d.c(nArray, n10, 0);
        if (n12 < 0) {
            return n12;
        }
        object3 = this.b;
        int n13 = n12 << 1;
        if ((object3 = object3[n13]) == null) {
            return n12;
        }
        for (n11 = n12 + 1; n11 < n10 && (n13 = (object2 = this.a)[n11]) == 0; ++n11) {
            object2 = this.b;
            int n14 = n11 << 1;
            if ((object2 = (Object)object2[n14]) != null) continue;
            return n11;
        }
        n12 += -1;
        while (n12 >= 0 && (n10 = (object = this.a)[n12]) == 0) {
            object = this.b;
            n13 = n12 << 1;
            if ((object = (Object)object[n13]) == null) {
                return n12;
            }
            n12 += -1;
        }
        return ~n11;
    }

    public boolean isEmpty() {
        int n10 = this.c;
        n10 = n10 <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public int j(Object object) {
        int n10 = this.c * 2;
        Object[] objectArray = this.b;
        int n11 = 1;
        if (object == null) {
            for (int i10 = n11; i10 < n10; i10 += 2) {
                Object object2 = objectArray[i10];
                if (object2 != null) continue;
                return i10 >> n11;
            }
        } else {
            for (int i11 = n11; i11 < n10; i11 += 2) {
                Object object3 = objectArray[i11];
                boolean bl2 = object.equals(object3);
                if (!bl2) continue;
                return i11 >> 1;
            }
        }
        return -1;
    }

    public Object k(int n10) {
        Object[] objectArray = this.b;
        return objectArray[n10 <<= 1];
    }

    public void l(d objectArray) {
        int n10 = objectArray.c;
        int n11 = this.c + n10;
        this.e(n11);
        n11 = this.c;
        if (n11 == 0) {
            if (n10 > 0) {
                Object[] objectArray2 = objectArray.a;
                int[] nArray = this.a;
                System.arraycopy(objectArray2, 0, nArray, 0, n10);
                objectArray = objectArray.b;
                objectArray2 = this.b;
                int n12 = n10 << 1;
                System.arraycopy(objectArray, 0, objectArray2, 0, n12);
                this.c = n10;
            }
        } else {
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object = objectArray.k(i10);
                Object object2 = objectArray.o(i10);
                this.put(object, object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public Object m(int n10) {
        Object[] objectArray = this.b;
        int n11 = n10 << 1;
        int n12 = n11 + 1;
        Object object = objectArray[n12];
        int n13 = this.c;
        int n14 = 0;
        Object[] objectArray2 = null;
        int n15 = 1;
        if (n13 <= n15) {
            l.a.h.d.f(this.a, objectArray, n13);
            int[] nArray = l.a.h.b.a;
            this.a = nArray;
            Object[] objectArray3 = l.a.h.b.c;
            this.b = objectArray3;
        } else {
            int n16 = n13 + -1;
            int[] nArray = this.a;
            int n17 = nArray.length;
            int n18 = 8;
            if (n17 > n18 && n13 < (n17 = nArray.length / 3)) {
                if (n13 > n18) {
                    n17 = n13 >> 1;
                    n18 = n13 + n17;
                }
                this.b(n18);
                n17 = this.c;
                if (n13 != n17) {
                    ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                    throw concurrentModificationException;
                }
                if (n10 > 0) {
                    int[] nArray2 = this.a;
                    System.arraycopy(nArray, 0, nArray2, 0, n10);
                    Object[] objectArray4 = this.b;
                    System.arraycopy(objectArray, 0, objectArray4, 0, n11);
                }
                if (n10 < n16) {
                    n14 = n10 + 1;
                    int[] nArray3 = this.a;
                    n18 = n16 - n10;
                    System.arraycopy(nArray, n14, nArray3, n10, n18);
                    n10 = n14 << 1;
                    objectArray2 = this.b;
                    n15 = n18 << 1;
                    System.arraycopy(objectArray, n10, objectArray2, n11, n15);
                }
            } else {
                int n19;
                if (n10 < n16) {
                    n19 = n10 + 1;
                    n14 = n16 - n10;
                    System.arraycopy(nArray, n19, nArray, n10, n14);
                    Object[] objectArray5 = this.b;
                    System.arraycopy(objectArray5, n19 <<= n15, objectArray5, n11, n14 <<= n15);
                }
                Object[] objectArray6 = this.b;
                n19 = n16 << 1;
                n11 = 0;
                objectArray6[n19] = null;
                objectArray6[n19 += n15] = null;
            }
            n14 = n16;
        }
        n10 = this.c;
        if (n13 == n10) {
            this.c = n14;
            return object;
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public Object n(int n10, Object object) {
        n10 = (n10 << 1) + 1;
        Object[] objectArray = this.b;
        Object object2 = objectArray[n10];
        objectArray[n10] = object;
        return object2;
    }

    public Object o(int n10) {
        Object[] objectArray = this.b;
        n10 = (n10 << 1) + 1;
        return objectArray[n10];
    }

    public Object put(Object object, Object object2) {
        Object[] objectArray;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14 = this.c;
        int n15 = 0;
        Object[] objectArray2 = null;
        if (object == null) {
            n13 = this.i();
            n12 = 0;
        } else {
            n13 = object.hashCode();
            int n16 = this.g(object, n13);
            n12 = n13;
            n13 = n16;
        }
        if (n13 >= 0) {
            int n17 = (n13 << 1) + 1;
            Object[] objectArray3 = this.b;
            objectArray2 = objectArray3[n17];
            objectArray3[n17] = object2;
            return objectArray2;
        }
        n13 ^= 0xFFFFFFFF;
        int[] nArray = this.a;
        int n18 = nArray.length;
        if (n14 >= n18) {
            n18 = 4;
            n11 = 8;
            if (n14 >= n11) {
                n18 = (n14 >> 1) + n14;
            } else if (n14 >= n18) {
                n18 = n11;
            }
            Object[] objectArray4 = this.b;
            this.b(n18);
            n18 = this.c;
            if (n14 == n18) {
                Object[] objectArray5 = this.a;
                int n19 = objectArray5.length;
                if (n19 > 0) {
                    n19 = nArray.length;
                    System.arraycopy(nArray, 0, objectArray5, 0, n19);
                    objectArray5 = this.b;
                    n19 = objectArray4.length;
                    System.arraycopy(objectArray4, 0, objectArray5, 0, n19);
                }
                l.a.h.d.f(nArray, objectArray4, n14);
            } else {
                object = new ConcurrentModificationException();
                throw object;
            }
        }
        if (n13 < n14) {
            objectArray2 = this.a;
            n10 = n13 + 1;
            n18 = n14 - n13;
            System.arraycopy(objectArray2, n13, objectArray2, n10, n18);
            objectArray2 = this.b;
            n18 = n13 << 1;
            n11 = this.c - n13 << 1;
            System.arraycopy(objectArray2, n18, objectArray2, n10 <<= 1, n11);
        }
        if (n14 == (n15 = this.c) && n13 < (n10 = (objectArray = this.a).length)) {
            objectArray[n13] = n12;
            objectArray = this.b;
            objectArray[n13 <<= 1] = (int)object;
            objectArray[++n13] = (int)object2;
            this.c = ++n15;
            return null;
        }
        object = new ConcurrentModificationException();
        throw object;
    }

    public Object remove(Object object) {
        int n10 = this.h(object);
        if (n10 >= 0) {
            return this.m(n10);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        char c10;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return "{}";
        }
        int n10 = this.c * 28;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('{');
        for (n10 = 0; n10 < (c10 = this.c); ++n10) {
            Object object;
            if (n10 > 0) {
                object = ", ";
                stringBuilder.append((String)object);
            }
            object = this.k(n10);
            String string2 = "(this Map)";
            if (object != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append(string2);
            }
            c10 = '=';
            stringBuilder.append(c10);
            object = this.o(n10);
            if (object != this) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

