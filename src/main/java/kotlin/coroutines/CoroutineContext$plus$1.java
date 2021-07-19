/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.b2.d;
import f.h2.s.p;
import f.h2.t.f0;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Lambda;

public final class CoroutineContext$plus$1
extends Lambda
implements p {
    public static final CoroutineContext$plus$1 INSTANCE;

    static {
        CoroutineContext$plus$1 coroutineContext$plus$1;
        INSTANCE = coroutineContext$plus$1 = new CoroutineContext$plus$1();
    }

    public CoroutineContext$plus$1() {
        super(2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext$a object) {
        f0.p(coroutineContext, "acc");
        f0.p(object, "element");
        Object object2 = object.getKey();
        coroutineContext = coroutineContext.minusKey((CoroutineContext$b)object2);
        object2 = EmptyCoroutineContext.INSTANCE;
        if (coroutineContext == object2) return object;
        Object object3 = d.g0;
        d d10 = (d)coroutineContext.get((CoroutineContext$b)object3);
        if (d10 == null) {
            object2 = new CombinedContext(coroutineContext, (CoroutineContext$a)object);
            return object2;
        }
        if ((coroutineContext = coroutineContext.minusKey((CoroutineContext$b)object3)) == object2) {
            coroutineContext = new CombinedContext((CoroutineContext)object, d10);
            return coroutineContext;
        }
        object3 = new CombinedContext(coroutineContext, (CoroutineContext$a)object);
        return new CombinedContext((CoroutineContext)object3, d10);
    }
}

