/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import f.h2.t.f0;
import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$DefaultImpls;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;
import kotlin.coroutines.EmptyCoroutineContext;

public final class CoroutineContext$a$a {
    public static Object a(CoroutineContext$a coroutineContext$a, Object object, p p10) {
        f0.p(p10, "operation");
        return p10.invoke(object, coroutineContext$a);
    }

    public static CoroutineContext$a b(CoroutineContext$a coroutineContext$a, CoroutineContext$b object) {
        f0.p(object, "key");
        CoroutineContext$b coroutineContext$b = coroutineContext$a.getKey();
        boolean bl2 = f0.g(coroutineContext$b, object);
        if (bl2) {
            object = "null cannot be cast to non-null type E";
            Objects.requireNonNull(coroutineContext$a, (String)object);
        } else {
            coroutineContext$a = null;
        }
        return coroutineContext$a;
    }

    public static CoroutineContext c(CoroutineContext$a coroutineContext, CoroutineContext$b coroutineContext$b) {
        f0.p(coroutineContext$b, "key");
        CoroutineContext$b coroutineContext$b2 = coroutineContext.getKey();
        boolean bl2 = f0.g(coroutineContext$b2, coroutineContext$b);
        if (bl2) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }

    public static CoroutineContext d(CoroutineContext$a coroutineContext$a, CoroutineContext coroutineContext) {
        f0.p(coroutineContext, "context");
        return CoroutineContext$DefaultImpls.a(coroutineContext$a, coroutineContext);
    }
}

