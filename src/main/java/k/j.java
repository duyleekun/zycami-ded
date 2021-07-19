/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.c0;
import g.e$a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k.d;
import k.e;
import k.h;
import k.j$a;
import k.j$b;
import k.j$c;
import k.l;
import k.q;
import k.r;
import k.s;
import k.t;
import k.v;
import k.w;
import k.w$b;

public abstract class j
extends t {
    private final q a;
    private final e$a b;
    private final h c;

    public j(q q10, e$a e$a, h h10) {
        this.a = q10;
        this.b = e$a;
        this.c = h10;
    }

    private static e d(s s10, Method method, Type type, Annotation[] objectArray) {
        try {
            return s10.b(type, (Annotation[])objectArray);
        }
        catch (RuntimeException runtimeException) {
            objectArray = new Object[]{type};
            throw w.n(method, runtimeException, "Unable to create call adapter for %s", objectArray);
        }
    }

    private static h e(s s10, Method method, Type type) {
        Object[] objectArray = method.getAnnotations();
        try {
            return s10.n(type, (Annotation[])objectArray);
        }
        catch (RuntimeException runtimeException) {
            objectArray = new Object[]{type};
            throw w.n(method, runtimeException, "Unable to create converter for %s", objectArray);
        }
    }

    public static j f(s s10, Method method, q q10) {
        Type type;
        Object object;
        int n10;
        Object object2;
        Object object3 = r.class;
        boolean bl2 = q10.k;
        Object object4 = method.getAnnotations();
        e$a e$a = null;
        if (bl2) {
            object2 = method.getGenericParameterTypes();
            n10 = ((Type[])object2).length;
            int n11 = 1;
            object2 = (ParameterizedType)object2[n10 -= n11];
            Class clazz = w.h((Type)(object2 = w.f(0, (ParameterizedType)object2)));
            if (clazz == object3 && (n10 = object2 instanceof ParameterizedType) != 0) {
                object2 = (ParameterizedType)object2;
                object2 = w.g(0, (ParameterizedType)object2);
                n10 = n11;
            } else {
                n10 = 0;
                clazz = null;
            }
            Class<d> clazz2 = d.class;
            object = new Type[n11];
            object[0] = object2;
            type = new w$b(null, (Type)((Object)clazz2), (Type)object);
            object4 = v.a((Annotation[])object4);
        } else {
            type = method.getGenericReturnType();
            n10 = 0;
            Object var10_11 = null;
        }
        object4 = j.d(s10, method, type, (Annotation[])object4);
        object2 = object4.a();
        object = c0.class;
        if (object2 != object) {
            if (object2 != object3) {
                object3 = q10.c;
                object = "HEAD";
                boolean bl3 = ((String)object3).equals(object);
                if (bl3 && !(bl3 = (object3 = Void.class).equals(object2))) {
                    Object[] objectArray = new Object[]{};
                    throw w.m(method, "HEAD method must use Void as response type.", objectArray);
                }
                object3 = j.e(s10, method, (Type)object2);
                e$a = s10.b;
                if (!bl2) {
                    j$a j$a = new j$a(q10, e$a, (h)object3, (e)object4);
                    return j$a;
                }
                if (n10 != 0) {
                    j$c j$c = new j$c(q10, e$a, (h)object3, (e)object4);
                    return j$c;
                }
                Object object5 = object2;
                e$a e$a2 = e$a;
                object2 = new j$b(q10, e$a, (h)object3, (e)object4, false);
                return object2;
            }
            Object[] objectArray = new Object[]{};
            throw w.m(method, "Response must include generic type (e.g., Response<String>)", objectArray);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("'");
        Object[] objectArray = w.h((Type)object2).getName();
        charSequence.append((String)objectArray);
        charSequence.append("' is not a valid response body type. Did you mean ResponseBody?");
        charSequence = charSequence.toString();
        objectArray = new Object[]{};
        throw w.m(method, (String)charSequence, objectArray);
    }

    public final Object a(Object[] objectArray) {
        q q10 = this.a;
        e$a e$a = this.b;
        h h10 = this.c;
        l l10 = new l(q10, objectArray, e$a, h10);
        return this.c(l10, objectArray);
    }

    public abstract Object c(d var1, Object[] var2);
}

