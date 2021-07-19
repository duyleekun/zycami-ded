/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt__SequencesKt$generateSequence$1
extends Lambda
implements l {
    public final /* synthetic */ a $nextFunction;

    public SequencesKt__SequencesKt$generateSequence$1(a a10) {
        this.$nextFunction = a10;
        super(1);
    }

    public final Object invoke(Object object) {
        f0.p(object, "it");
        return this.$nextFunction.invoke();
    }
}

