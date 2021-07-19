/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import k.o;
import k.s;

public class s$a
implements InvocationHandler {
    private final o a;
    private final Object[] b;
    public final /* synthetic */ Class c;
    public final /* synthetic */ s d;

    public s$a(s objectArray, Class clazz) {
        this.d = objectArray;
        this.c = clazz;
        objectArray = o.g();
        this.a = objectArray;
        objectArray = new Object[]{};
        this.b = objectArray;
    }

    public Object invoke(Object object, Method method, Object[] objectArray) {
        Class clazz;
        Class<?> clazz2 = method.getDeclaringClass();
        if (clazz2 == (clazz = Object.class)) {
            return method.invoke(this, objectArray);
        }
        if (objectArray == null) {
            objectArray = this.b;
        }
        clazz2 = this.a;
        boolean bl2 = ((o)((Object)clazz2)).i(method);
        if (bl2) {
            clazz2 = this.a;
            clazz = this.c;
            object = ((o)((Object)clazz2)).h(method, clazz, object, objectArray);
        } else {
            object = this.d.h(method).a(objectArray);
        }
        return object;
    }
}

