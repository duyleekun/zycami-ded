/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.intrinsics;

import f.b2.c;
import f.b2.k.a.f;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.s.q;
import f.h2.t.f0;
import f.h2.t.t0;
import java.io.Serializable;
import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public class IntrinsicsKt__IntrinsicsJvmKt {
    private static final c a(c c10, l l10) {
        CoroutineContext coroutineContext = c10.getContext();
        Serializable serializable = EmptyCoroutineContext.INSTANCE;
        Object object = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
        if (coroutineContext == serializable) {
            Objects.requireNonNull(c10, (String)object);
            serializable = new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(l10, c10, c10);
        } else {
            IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 intrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2;
            Objects.requireNonNull(c10, (String)object);
            serializable = intrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2;
            object = l10;
            intrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 = new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(l10, c10, coroutineContext, c10, coroutineContext);
        }
        return serializable;
    }

    public static final c b(l object, c object2) {
        f0.p(object, "$this$createCoroutineUnintercepted");
        String string2 = "completion";
        f0.p(object2, string2);
        c c10 = f.a((c)object2);
        boolean bl2 = object instanceof BaseContinuationImpl;
        if (bl2) {
            object = ((BaseContinuationImpl)object).create(c10);
        } else {
            CoroutineContext coroutineContext = c10.getContext();
            object2 = EmptyCoroutineContext.INSTANCE;
            string2 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
            if (coroutineContext == object2) {
                Objects.requireNonNull(c10, string2);
                object2 = new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(c10, c10, (l)object);
            } else {
                Objects.requireNonNull(c10, string2);
                object2 = new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(c10, coroutineContext, c10, coroutineContext, (l)object);
            }
            object = object2;
        }
        return object;
    }

    public static final c c(p object, Object object2, c object3) {
        f0.p(object, "$this$createCoroutineUnintercepted");
        String string2 = "completion";
        f0.p(object3, string2);
        c c10 = f.a((c)object3);
        boolean bl2 = object instanceof BaseContinuationImpl;
        if (bl2) {
            object = ((BaseContinuationImpl)object).create(object2, c10);
        } else {
            CoroutineContext coroutineContext = c10.getContext();
            object3 = EmptyCoroutineContext.INSTANCE;
            string2 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
            if (coroutineContext == object3) {
                Objects.requireNonNull(c10, string2);
                object3 = new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(c10, c10, (p)object, object2);
            } else {
                Objects.requireNonNull(c10, string2);
                object3 = new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(c10, coroutineContext, c10, coroutineContext, (p)object, object2);
            }
            object = object3;
        }
        return object;
    }

    public static final c d(c object) {
        Object object2 = "$this$intercepted";
        f0.p(object, (String)object2);
        boolean bl2 = object instanceof ContinuationImpl;
        if (!bl2) {
            bl2 = false;
            object2 = null;
        } else {
            object2 = object;
        }
        object2 = (ContinuationImpl)object2;
        if (object2 != null && (object2 = ((ContinuationImpl)object2).intercepted()) != null) {
            object = object2;
        }
        return object;
    }

    private static final Object e(l l10, c c10) {
        Objects.requireNonNull(l10, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((l)t0.q(l10, 1)).invoke(c10);
    }

    private static final Object f(p p10, Object object, c c10) {
        Objects.requireNonNull(p10, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((p)t0.q(p10, 2)).invoke(object, c10);
    }

    private static final Object g(q q10, Object object, Object object2, c c10) {
        Objects.requireNonNull(q10, "null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((q)t0.q(q10, 3)).invoke(object, object2, c10);
    }
}

