/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import f.h2.t.f0;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;

public final class EmptyCoroutineContext
implements CoroutineContext,
Serializable {
    public static final EmptyCoroutineContext INSTANCE;
    private static final long serialVersionUID;

    static {
        EmptyCoroutineContext emptyCoroutineContext;
        INSTANCE = emptyCoroutineContext = new EmptyCoroutineContext();
    }

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public Object fold(Object object, p p10) {
        f0.p(p10, "operation");
        return object;
    }

    public CoroutineContext$a get(CoroutineContext$b coroutineContext$b) {
        f0.p(coroutineContext$b, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public CoroutineContext minusKey(CoroutineContext$b coroutineContext$b) {
        f0.p(coroutineContext$b, "key");
        return this;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        f0.p(coroutineContext, "context");
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}

