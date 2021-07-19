/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k.e;
import k.s;
import k.w;

public abstract class e$a {
    public static Type b(int n10, ParameterizedType parameterizedType) {
        return w.g(n10, parameterizedType);
    }

    public static Class c(Type type) {
        return w.h(type);
    }

    public abstract e a(Type var1, Annotation[] var2, s var3);
}

