/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$b;

public interface CoroutineContext$a
extends CoroutineContext {
    public Object fold(Object var1, p var2);

    public CoroutineContext$a get(CoroutineContext$b var1);

    public CoroutineContext$b getKey();

    public CoroutineContext minusKey(CoroutineContext$b var1);
}

