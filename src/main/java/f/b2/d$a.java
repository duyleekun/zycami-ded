/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.b2.b;
import f.b2.c;
import f.b2.d;
import f.h2.s.p;
import f.h2.t.f0;
import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$a$a;
import kotlin.coroutines.CoroutineContext$b;
import kotlin.coroutines.EmptyCoroutineContext;

public final class d$a {
    public static Object a(d d10, Object object, p p10) {
        f0.p(p10, "operation");
        return CoroutineContext$a$a.a(d10, object, p10);
    }

    public static CoroutineContext$a b(d coroutineContext$a, CoroutineContext$b object) {
        Object object2 = "key";
        f0.p(object, (String)object2);
        boolean bl2 = object instanceof b;
        CoroutineContext$a coroutineContext$a2 = null;
        if (bl2) {
            boolean bl3;
            object2 = coroutineContext$a.getKey();
            bl2 = ((b)(object = (b)object)).a((CoroutineContext$b)object2);
            if (bl2 && (bl3 = (coroutineContext$a = ((b)object).b(coroutineContext$a)) instanceof CoroutineContext$a)) {
                coroutineContext$a2 = coroutineContext$a;
            }
            return coroutineContext$a2;
        }
        object2 = d.g0;
        if (object2 == object) {
            object = "null cannot be cast to non-null type E";
            Objects.requireNonNull(coroutineContext$a, (String)object);
        } else {
            coroutineContext$a = null;
        }
        return coroutineContext$a;
    }

    public static CoroutineContext c(d coroutineContext, CoroutineContext$b object) {
        Object object2 = "key";
        f0.p(object, (String)object2);
        boolean bl2 = object instanceof b;
        if (bl2) {
            object2 = coroutineContext.getKey();
            bl2 = ((b)(object = (b)object)).a((CoroutineContext$b)object2);
            if (bl2 && (object = ((b)object).b((CoroutineContext$a)coroutineContext)) != null) {
                coroutineContext = EmptyCoroutineContext.INSTANCE;
            }
            return coroutineContext;
        }
        object2 = d.g0;
        if (object2 == object) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }

    public static CoroutineContext d(d d10, CoroutineContext coroutineContext) {
        f0.p(coroutineContext, "context");
        return CoroutineContext$a$a.d(d10, coroutineContext);
    }

    public static void e(d d10, c c10) {
        f0.p(c10, "continuation");
    }
}

