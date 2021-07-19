/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;

public interface CoroutineContext {
    public Object fold(Object var1, p var2);

    public CoroutineContext$a get(CoroutineContext$b var1);

    public CoroutineContext minusKey(CoroutineContext$b var1);

    public CoroutineContext plus(CoroutineContext var1);
}

