/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class l {
    public static final Object[] a(Object[] objectArray, int n10) {
        f0.p(objectArray, "reference");
        objectArray = Array.newInstance(objectArray.getClass().getComponentType(), n10);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }

    public static final int b(Object[] objectArray) {
        return Arrays.deepHashCode(objectArray);
    }

    public static final void c(int n10, int n11) {
        if (n10 <= n11) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex (");
        stringBuilder.append(n10);
        stringBuilder.append(") is greater than size (");
        stringBuilder.append(n11);
        stringBuilder.append(").");
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static final /* synthetic */ Object[] d(Object[] objectArray) {
        if (objectArray == null) {
            String string2 = "T?";
            f0.y(0, string2);
            objectArray = new Object[]{};
        }
        return objectArray;
    }

    private static final String e(byte[] byArray, Charset charset) {
        String string2 = new String(byArray, charset);
        return string2;
    }

    public static final /* synthetic */ Object[] f(Collection objectArray) {
        f0.p(objectArray, "$this$toTypedArray");
        f0.y(0, "T?");
        Object[] objectArray2 = new Object[]{};
        objectArray = objectArray.toArray(objectArray2);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }
}

