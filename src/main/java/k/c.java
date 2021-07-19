/*
 * Decompiled with CFR 0.151.
 */
package k;

import f.q1;
import g.b0;
import g.d0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import k.c$a;
import k.c$b;
import k.c$c;
import k.c$e;
import k.c$f;
import k.h;
import k.h$a;
import k.s;
import k.z.w;

public final class c
extends h$a {
    private boolean a = true;

    public h requestBodyConverter(Type type, Annotation[] object, Annotation[] annotationArray, s s10) {
        object = b0.class;
        boolean bl2 = ((Class)object).isAssignableFrom((Class<?>)(type = k.w.h(type)));
        if (bl2) {
            return c$b.a;
        }
        return null;
    }

    public h responseBodyConverter(Type clazz, Annotation[] object, s clazz2) {
        clazz2 = d0.class;
        if (clazz == clazz2) {
            clazz = w.class;
            boolean bl2 = k.w.l(object, clazz);
            clazz = bl2 ? c$c.a : c$a.a;
            return clazz;
        }
        object = Void.class;
        if (clazz == object) {
            return c$f.a;
        }
        boolean bl3 = this.a;
        if (bl3 && clazz == (object = q1.class)) {
            try {
                return c$e.a;
            }
            catch (NoClassDefFoundError noClassDefFoundError) {
                boolean bl4 = false;
                clazz = null;
                this.a = false;
            }
        }
        return null;
    }
}

