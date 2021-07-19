/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.t.f0;
import java.io.Serializable;
import kotlin.coroutines.CombinedContext$Serialized$a;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public final class CombinedContext$Serialized
implements Serializable {
    public static final CombinedContext$Serialized$a Companion;
    private static final long serialVersionUID;
    private final CoroutineContext[] elements;

    static {
        CombinedContext$Serialized$a combinedContext$Serialized$a;
        Companion = combinedContext$Serialized$a = new CombinedContext$Serialized$a(null);
    }

    public CombinedContext$Serialized(CoroutineContext[] coroutineContextArray) {
        f0.p(coroutineContextArray, "elements");
        this.elements = coroutineContextArray;
    }

    private final Object readResolve() {
        CoroutineContext[] coroutineContextArray = this.elements;
        CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
        for (CoroutineContext coroutineContext2 : coroutineContextArray) {
            coroutineContext = coroutineContext.plus(coroutineContext2);
        }
        return coroutineContext;
    }

    public final CoroutineContext[] getElements() {
        return this.elements;
    }
}

