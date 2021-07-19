/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import f.h2.t.f0;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$plus$1;
import kotlin.coroutines.EmptyCoroutineContext;

public final class CoroutineContext$DefaultImpls {
    public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        f0.p(coroutineContext2, "context");
        Serializable serializable = EmptyCoroutineContext.INSTANCE;
        if (coroutineContext2 != serializable) {
            serializable = CoroutineContext$plus$1.INSTANCE;
            coroutineContext = (CoroutineContext)coroutineContext2.fold(coroutineContext, (p)((Object)serializable));
        }
        return coroutineContext;
    }
}

