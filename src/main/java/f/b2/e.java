/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.b2.c;
import f.b2.e$a;
import f.b2.h;
import f.b2.j.b;
import f.b2.k.a.f;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.c0;
import f.h2.t.f0;
import f.o0;
import f.q1;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

public final class e {
    private static final c a(CoroutineContext coroutineContext, l l10) {
        e$a e$a = new e$a(coroutineContext, l10);
        return e$a;
    }

    public static final c b(l object, c object2) {
        f0.p(object, "$this$createCoroutine");
        f0.p(object2, "completion");
        object = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b((l)object, (c)object2));
        object2 = b.h();
        h h10 = new h((c)object, object2);
        return h10;
    }

    public static final c c(p object, Object object2, c c10) {
        f0.p(object, "$this$createCoroutine");
        f0.p(c10, "completion");
        object = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c((p)object, object2, c10));
        object2 = b.h();
        h h10 = new h((c)object, object2);
        return h10;
    }

    private static final CoroutineContext d() {
        NotImplementedError notImplementedError = new NotImplementedError("Implemented as intrinsic");
        throw notImplementedError;
    }

    public static /* synthetic */ void e() {
    }

    private static final void f(c c10, Object object) {
        object = Result.constructor-impl(object);
        c10.resumeWith(object);
    }

    private static final void g(c c10, Throwable object) {
        object = Result.constructor-impl(o0.a((Throwable)object));
        c10.resumeWith(object);
    }

    public static final void h(l object, c object2) {
        f0.p(object, "$this$startCoroutine");
        f0.p(object2, "completion");
        object = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b((l)object, (c)object2));
        object2 = q1.a;
        object2 = Result.constructor-impl(object2);
        object.resumeWith(object2);
    }

    public static final void i(p object, Object object2, c object3) {
        f0.p(object, "$this$startCoroutine");
        f0.p(object3, "completion");
        object = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c((p)object, object2, (c)object3));
        object2 = q1.a;
        object3 = Result.Companion;
        object2 = Result.constructor-impl(object2);
        object.resumeWith(object2);
    }

    private static final Object j(l object, c c10) {
        c0.e(0);
        c c11 = IntrinsicsKt__IntrinsicsJvmKt.d(c10);
        Object object2 = new h(c11);
        object.invoke(object2);
        object = ((h)object2).a();
        object2 = b.h();
        if (object == object2) {
            f.c(c10);
        }
        c0.e(1);
        return object;
    }
}

