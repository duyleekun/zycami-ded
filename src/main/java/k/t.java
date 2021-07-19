/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import k.j;
import k.q;
import k.s;
import k.w;

public abstract class t {
    public static t b(s objectArray, Method method) {
        q q10 = q.b((s)objectArray, method);
        Type type = method.getGenericReturnType();
        boolean bl2 = w.j(type);
        if (!bl2) {
            Class<Void> clazz = Void.TYPE;
            if (type != clazz) {
                return j.f((s)objectArray, method, q10);
            }
            objectArray = new Object[]{};
            throw w.m(method, "Service methods cannot return void.", objectArray);
        }
        objectArray = new Object[]{type};
        throw w.m(method, "Method return type must not include a type variable or wildcard: %s", objectArray);
    }

    public abstract Object a(Object[] var1);
}

