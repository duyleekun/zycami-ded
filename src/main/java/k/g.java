/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import k.e;
import k.e$a;
import k.g$a;
import k.g$c;
import k.r;
import k.s;

public final class g
extends e$a {
    public static final e$a a;

    static {
        g g10 = new g();
        a = g10;
    }

    public e a(Type object, Annotation[] object2, s object3) {
        object2 = e$a.c((Type)object);
        if (object2 != (object3 = CompletableFuture.class)) {
            return null;
        }
        boolean bl2 = object instanceof ParameterizedType;
        if (bl2) {
            Class<r> clazz;
            object = (ParameterizedType)object;
            bl2 = false;
            object2 = null;
            object3 = e$a.c((Type)(object = e$a.b(0, (ParameterizedType)object)));
            if (object3 != (clazz = r.class)) {
                object2 = new g$a((Type)object);
                return object2;
            }
            boolean bl3 = object instanceof ParameterizedType;
            if (bl3) {
                object = (ParameterizedType)object;
                object = e$a.b(0, (ParameterizedType)object);
                object2 = new g$c((Type)object);
                return object2;
            }
            object = new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            throw object;
        }
        object = new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        throw object;
    }
}

