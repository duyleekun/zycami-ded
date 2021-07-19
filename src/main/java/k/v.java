/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.annotation.Annotation;
import k.u;
import k.w;

public final class v
implements u {
    private static final u p2;

    static {
        v v10 = new v();
        p2 = v10;
    }

    public static Annotation[] a(Annotation[] annotationArray) {
        Annotation[] annotationArray2 = u.class;
        int n10 = w.l(annotationArray, annotationArray2);
        if (n10 != 0) {
            return annotationArray;
        }
        n10 = annotationArray.length;
        int n11 = 1;
        annotationArray2 = new Annotation[n10 + n11];
        u u10 = p2;
        annotationArray2[0] = u10;
        int n12 = annotationArray.length;
        System.arraycopy(annotationArray, 0, annotationArray2, n11, n12);
        return annotationArray2;
    }

    public Class annotationType() {
        return u.class;
    }

    public boolean equals(Object object) {
        return object instanceof u;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        String string2 = u.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append("()");
        return stringBuilder.toString();
    }
}

