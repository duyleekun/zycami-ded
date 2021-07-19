/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class b {
    public static final /* synthetic */ boolean a(Object[] objectArray, int n10, int n11, List list) {
        return b.h(objectArray, n10, n11, list);
    }

    public static final /* synthetic */ int b(Object[] objectArray, int n10, int n11) {
        return b.i(objectArray, n10, n11);
    }

    public static final /* synthetic */ String c(Object[] objectArray, int n10, int n11) {
        return b.j(objectArray, n10, n11);
    }

    public static final Object[] d(int n10) {
        String string2;
        boolean bl2;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        if (bl2) {
            return new Object[n10];
        }
        string2 = "capacity must be non-negative.".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static final Object[] e(Object[] objectArray, int n10) {
        f0.p(objectArray, "$this$copyOfUninitializedElements");
        objectArray = Arrays.copyOf(objectArray, n10);
        f0.o(objectArray, "java.util.Arrays.copyOf(this, newSize)");
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }

    public static final void f(Object[] objectArray, int n10) {
        f0.p(objectArray, "$this$resetAt");
        objectArray[n10] = null;
    }

    public static final void g(Object[] objectArray, int n10, int n11) {
        String string2 = "$this$resetRange";
        f0.p(objectArray, string2);
        while (n10 < n11) {
            b.f(objectArray, n10);
            ++n10;
        }
    }

    private static final boolean h(Object[] objectArray, int n10, int n11, List list) {
        int n12;
        int n13 = list.size();
        if (n11 != n13) {
            return false;
        }
        n13 = 0;
        while (true) {
            n12 = 1;
            if (n13 >= n11) break;
            int n14 = n10 + n13;
            Object object = objectArray[n14];
            Object e10 = list.get(n13);
            if ((n12 ^= (n14 = (int)(f0.g(object, e10) ? 1 : 0))) != 0) {
                return false;
            }
            ++n13;
        }
        return n12 != 0;
    }

    private static final int i(Object[] objectArray, int n10, int n11) {
        int n12 = 1;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13 = n10 + i10;
            Object object = objectArray[n13];
            n12 *= 31;
            if (object != null) {
                n13 = object.hashCode();
            } else {
                n13 = 0;
                object = null;
            }
            n12 += n13;
        }
        return n12;
    }

    private static final String j(Object[] object, int n10, int n11) {
        int n12 = n11 * 3 + 2;
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append("[");
        for (n12 = 0; n12 < n11; ++n12) {
            Object object2;
            if (n12 > 0) {
                object2 = ", ";
                stringBuilder.append((String)object2);
            }
            int n13 = n10 + n12;
            object2 = object[n13];
            stringBuilder.append(object2);
        }
        stringBuilder.append("]");
        object = stringBuilder.toString();
        f0.o(object, "sb.toString()");
        return object;
    }
}

