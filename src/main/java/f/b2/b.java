/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.h2.s.l;
import f.h2.t.f0;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;

public abstract class b
implements CoroutineContext$b {
    private final CoroutineContext$b a;
    private final l b;

    public b(CoroutineContext$b coroutineContext$b, l l10) {
        f0.p(coroutineContext$b, "baseKey");
        String string2 = "safeCast";
        f0.p(l10, string2);
        this.b = l10;
        boolean bl2 = coroutineContext$b instanceof b;
        if (bl2) {
            coroutineContext$b = ((b)coroutineContext$b).a;
        }
        this.a = coroutineContext$b;
    }

    public final boolean a(CoroutineContext$b coroutineContext$b) {
        boolean bl2;
        Object object = "key";
        f0.p(coroutineContext$b, (String)object);
        if (coroutineContext$b != this && (object = this.a) != coroutineContext$b) {
            bl2 = false;
            coroutineContext$b = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final CoroutineContext$a b(CoroutineContext$a coroutineContext$a) {
        f0.p(coroutineContext$a, "element");
        return (CoroutineContext$a)this.b.invoke(coroutineContext$a);
    }
}

