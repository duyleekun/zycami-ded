/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.h2.s.p;
import f.h2.t.f0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$a$a;
import kotlin.coroutines.CoroutineContext$b;

public abstract class a
implements CoroutineContext$a {
    private final CoroutineContext$b a;

    public a(CoroutineContext$b coroutineContext$b) {
        f0.p(coroutineContext$b, "key");
        this.a = coroutineContext$b;
    }

    public Object fold(Object object, p p10) {
        f0.p(p10, "operation");
        return CoroutineContext$a$a.a(this, object, p10);
    }

    public CoroutineContext$a get(CoroutineContext$b coroutineContext$b) {
        f0.p(coroutineContext$b, "key");
        return CoroutineContext$a$a.b(this, coroutineContext$b);
    }

    public CoroutineContext$b getKey() {
        return this.a;
    }

    public CoroutineContext minusKey(CoroutineContext$b coroutineContext$b) {
        f0.p(coroutineContext$b, "key");
        return CoroutineContext$a$a.c(this, coroutineContext$b);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        f0.p(coroutineContext, "context");
        return CoroutineContext$a$a.d(this, coroutineContext);
    }
}

