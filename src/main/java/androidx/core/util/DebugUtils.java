/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.util;

public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object object, StringBuilder stringBuilder) {
        if (object == null) {
            object = "null";
            stringBuilder.append((String)object);
        } else {
            int n10;
            String string2 = object.getClass().getSimpleName();
            if ((string2 == null || (n10 = string2.length()) <= 0) && (n10 = (string2 = object.getClass().getName()).lastIndexOf(46)) > 0) {
                string2 = string2.substring(++n10);
            }
            stringBuilder.append(string2);
            char c10 = '{';
            stringBuilder.append(c10);
            int n11 = System.identityHashCode(object);
            object = Integer.toHexString(n11);
            stringBuilder.append((String)object);
        }
    }
}

