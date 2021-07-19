/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import f.h2.t.f0;
import f.q1;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;

public final class CombinedContext$writeReplace$1
extends Lambda
implements p {
    public final /* synthetic */ CoroutineContext[] $elements;
    public final /* synthetic */ Ref$IntRef $index;

    public CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArray, Ref$IntRef ref$IntRef) {
        this.$elements = coroutineContextArray;
        this.$index = ref$IntRef;
        super(2);
    }

    public final void invoke(q1 coroutineContextArray, CoroutineContext$a coroutineContext$a) {
        int n10;
        f0.p(coroutineContextArray, "<anonymous parameter 0>");
        f0.p(coroutineContext$a, "element");
        coroutineContextArray = this.$elements;
        Ref$IntRef ref$IntRef = this.$index;
        int n11 = ref$IntRef.element;
        ref$IntRef.element = n10 = n11 + 1;
        coroutineContextArray[n11] = coroutineContext$a;
    }
}

