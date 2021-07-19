/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import java.util.Objects;

public final class l {
    private l() {
    }

    public static Object a(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static Object b(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static Object c(Object object, String string2, Object object2) {
        if (object == null) {
            object = "%s";
            int n10 = string2.contains((CharSequence)object);
            if (n10 != 0) {
                int n11;
                n10 = string2.indexOf((String)object);
                if (n10 == (n11 = string2.lastIndexOf((String)object))) {
                    n10 = object2 instanceof Class;
                    object2 = n10 != 0 ? ((Class)object2).getCanonicalName() : String.valueOf(object2);
                    object = string2.replace((CharSequence)object, (CharSequence)object2);
                    NullPointerException nullPointerException = new NullPointerException((String)object);
                    throw nullPointerException;
                }
                object = new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
                throw object;
            }
            object = new IllegalArgumentException("errorMessageTemplate has no format specifiers");
            throw object;
        }
        return object;
    }
}

