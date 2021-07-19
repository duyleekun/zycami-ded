/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.b2.b;
import f.h2.t.f0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;
import kotlin.coroutines.EmptyCoroutineContext;

public final class f {
    public static final CoroutineContext$a a(CoroutineContext$a coroutineContext$a, CoroutineContext$b coroutineContext$b) {
        f0.p(coroutineContext$a, "$this$getPolymorphicElement");
        Object object = "key";
        f0.p(coroutineContext$b, (String)object);
        boolean bl2 = coroutineContext$b instanceof b;
        CoroutineContext$a coroutineContext$a2 = null;
        if (bl2) {
            boolean bl3;
            object = coroutineContext$a.getKey();
            bl2 = ((b)(coroutineContext$b = (b)coroutineContext$b)).a((CoroutineContext$b)object);
            if (bl2 && (bl3 = (coroutineContext$a = ((b)coroutineContext$b).b(coroutineContext$a)) instanceof CoroutineContext$a)) {
                coroutineContext$a2 = coroutineContext$a;
            }
            return coroutineContext$a2;
        }
        object = coroutineContext$a.getKey();
        if (object != coroutineContext$b) {
            coroutineContext$a = null;
        }
        return coroutineContext$a;
    }

    public static final CoroutineContext b(CoroutineContext$a coroutineContext, CoroutineContext$b object) {
        f0.p(coroutineContext, "$this$minusPolymorphicKey");
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
        object2 = coroutineContext.getKey();
        if (object2 == object) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }
}

