/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.a;
import e.a.h0;
import e.a.i0;
import e.a.j;
import e.a.q;
import e.a.z;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import k.e;
import k.e$a;
import k.r;
import k.s;
import k.x.a.d;
import k.x.a.f;

public final class g
extends e$a {
    private final h0 a;
    private final boolean b;

    private g(h0 h02, boolean bl2) {
        this.a = h02;
        this.b = bl2;
    }

    public static g d() {
        g g10 = new g(null, false);
        return g10;
    }

    public static g e() {
        g g10 = new g(null, true);
        return g10;
    }

    public static g f(h0 h02) {
        Objects.requireNonNull(h02, "scheduler == null");
        g g10 = new g(h02, false);
        return g10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public e a(Type object, Annotation[] object2, s clazz) {
        boolean bl2;
        boolean bl3;
        Object object3;
        Class clazz2;
        Class clazz3 = e$a.c((Type)object);
        if (clazz3 == (clazz2 = a.class)) {
            h0 h02 = this.a;
            boolean bl4 = this.b;
            return new f((Type)((Object)Void.class), h02, bl4, false, true, false, false, false, true);
        }
        clazz2 = j.class;
        boolean bl5 = true;
        boolean bl6 = clazz3 == clazz2 ? bl5 : false;
        clazz2 = i0.class;
        boolean bl7 = clazz3 == clazz2 ? bl5 : false;
        clazz2 = q.class;
        boolean bl8 = clazz3 == clazz2 ? bl5 : false;
        clazz2 = z.class;
        if (!(clazz3 == clazz2 || bl6 || bl7 || bl8)) {
            return null;
        }
        boolean bl9 = object instanceof ParameterizedType;
        if (!bl9) {
            object = !bl6 ? (!bl7 ? (bl8 ? "Maybe" : "Observable") : "Single") : "Flowable";
            clazz2 = new StringBuilder();
            ((StringBuilder)((Object)clazz2)).append((String)object);
            ((StringBuilder)((Object)clazz2)).append(" return type must be parameterized as ");
            ((StringBuilder)((Object)clazz2)).append((String)object);
            ((StringBuilder)((Object)clazz2)).append("<Foo> or ");
            ((StringBuilder)((Object)clazz2)).append((String)object);
            ((StringBuilder)((Object)clazz2)).append("<? extends Foo>");
            object = ((StringBuilder)((Object)clazz2)).toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
        object = (ParameterizedType)object;
        Class clazz4 = e$a.c((Type)(object = e$a.b(0, (ParameterizedType)object)));
        if (clazz4 == (clazz2 = r.class)) {
            bl9 = object instanceof ParameterizedType;
            if (!bl9) {
                object = new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                throw object;
            }
            object = (ParameterizedType)object;
            object3 = object = e$a.b(0, (ParameterizedType)object);
            bl3 = false;
            bl2 = false;
        } else {
            clazz2 = d.class;
            if (clazz4 == clazz2) {
                bl9 = object instanceof ParameterizedType;
                if (!bl9) {
                    object = new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                    throw object;
                }
                object = (ParameterizedType)object;
                object3 = object = e$a.b(0, (ParameterizedType)object);
                bl3 = bl5;
                bl2 = false;
            } else {
                object3 = object;
                bl2 = bl5;
                bl3 = false;
            }
        }
        h0 h03 = this.a;
        boolean bl10 = this.b;
        Object object4 = object;
        return new f((Type)object3, h03, bl10, bl3, bl2, bl6, bl7, bl8, false);
    }
}

