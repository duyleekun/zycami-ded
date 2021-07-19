/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.b2.c;
import f.b2.j.b;
import f.d;
import f.e;
import f.f$a;
import f.h2.s.q;
import f.h2.t.f0;
import f.h2.t.t0;
import f.o0;
import java.util.Objects;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public final class f
extends e
implements c {
    private q a;
    private Object b;
    private c c;
    private Object d;

    public f(q object, Object object2) {
        f0.p(object, "block");
        super(null);
        this.a = object;
        this.b = object2;
        this.c = this;
        this.d = object = f.d.b();
    }

    public static final /* synthetic */ c d(f f10) {
        return f10.c;
    }

    public static final /* synthetic */ q e(f f10) {
        return f10.a;
    }

    public static final /* synthetic */ Object f(f f10) {
        return f10.d;
    }

    public static final /* synthetic */ void g(f f10, c c10) {
        f10.c = c10;
    }

    public static final /* synthetic */ void h(f f10, q q10) {
        f10.a = q10;
    }

    public static final /* synthetic */ void i(f f10, Object object) {
        f10.d = object;
    }

    private final c j(q q10, c c10) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        f$a f$a = new f$a(emptyCoroutineContext, this, q10, c10);
        return f$a;
    }

    public Object a(Object object, c c10) {
        Objects.requireNonNull(c10, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = c10;
        this.b = object;
        object = f.b2.j.b.h();
        Object object2 = f.b2.j.b.h();
        if (object == object2) {
            f.b2.k.a.f.c(c10);
        }
        return object;
    }

    public Object b(f.c object, Object object2, c c10) {
        object = ((f.c)object).a();
        Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.DeepRecursiveFunctionBlock /* = suspend kotlin.DeepRecursiveScope<*, *>.(kotlin.Any?) -> kotlin.Any? */");
        q q10 = this.a;
        String string2 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
        if (object != q10) {
            this.a = object;
            Objects.requireNonNull(c10, string2);
            this.c = object = this.j(q10, c10);
        } else {
            Objects.requireNonNull(c10, string2);
            this.c = c10;
        }
        this.b = object2;
        object = f.b2.j.b.h();
        object2 = f.b2.j.b.h();
        if (object == object2) {
            f.b2.k.a.f.c(c10);
        }
        return object;
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object k() {
        while (true) {
            Object object = this.d;
            c c10 = this.c;
            if (c10 == null) {
                o0.n(object);
                return object;
            }
            Object object2 = f.d.b();
            boolean bl2 = Result.equals-impl0(object2, object);
            if (bl2) {
                block6: {
                    object = this.a;
                    object2 = this.b;
                    if (object == null) break block6;
                    int n10 = 3;
                    object = t0.q(object, n10);
                    object = (q)object;
                    if ((object = object.invoke(this, object2, c10)) == (object2 = f.b2.j.b.h())) continue;
                    object2 = Result.Companion;
                    object = Result.constructor-impl(object);
                    c10.resumeWith(object);
                    continue;
                }
                try {
                    object2 = "null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?";
                    object = new NullPointerException((String)object2);
                    throw object;
                }
                catch (Throwable throwable) {
                    object2 = Result.Companion;
                    object = Result.constructor-impl(o0.a(throwable));
                    c10.resumeWith(object);
                }
                continue;
            }
            this.d = object2 = f.d.b();
            c10.resumeWith(object);
        }
    }

    public void resumeWith(Object object) {
        this.c = null;
        this.d = object;
    }
}

