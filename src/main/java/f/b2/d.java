/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.b2.c;
import f.b2.d$b;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;

public interface d
extends CoroutineContext$a {
    public static final d$b g0 = d$b.a;

    public void a(c var1);

    public c b(c var1);

    public CoroutineContext$a get(CoroutineContext$b var1);

    public CoroutineContext minusKey(CoroutineContext$b var1);
}

