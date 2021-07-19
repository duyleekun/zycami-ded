/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k.h;
import k.s;
import k.w;

public abstract class h$a {
    public static Type getParameterUpperBound(int n10, ParameterizedType parameterizedType) {
        return w.g(n10, parameterizedType);
    }

    public static Class getRawType(Type type) {
        return w.h(type);
    }

    public h requestBodyConverter(Type type, Annotation[] annotationArray, Annotation[] annotationArray2, s s10) {
        return null;
    }

    public h responseBodyConverter(Type type, Annotation[] annotationArray, s s10) {
        return null;
    }

    public h stringConverter(Type type, Annotation[] annotationArray, s s10) {
        return null;
    }
}

