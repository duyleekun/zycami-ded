/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import k.d;
import k.e;
import k.e$a;
import k.i$a;
import k.s;
import k.u;
import k.w;

public final class i
extends e$a {
    private final Executor a;

    public i(Executor executor) {
        this.a = executor;
    }

    public e a(Type object, Annotation[] object2, s clazz) {
        clazz = e$a.c((Type)object);
        Class<d> clazz2 = d.class;
        Executor executor = null;
        if (clazz != clazz2) {
            return null;
        }
        boolean bl2 = object instanceof ParameterizedType;
        if (bl2) {
            bl2 = false;
            object = (ParameterizedType)object;
            object = w.g(0, (ParameterizedType)object);
            clazz = u.class;
            boolean bl3 = w.l(object2, clazz);
            if (!bl3) {
                executor = this.a;
            }
            object2 = new i$a(this, (Type)object, executor);
            return object2;
        }
        object = new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        throw object;
    }
}

