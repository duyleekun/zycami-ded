/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.x1.i0;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$filterIndexed$1
extends Lambda
implements l {
    public final /* synthetic */ p $predicate;

    public SequencesKt___SequencesKt$filterIndexed$1(p p10) {
        this.$predicate = p10;
        super(1);
    }

    public final boolean invoke(i0 object) {
        f0.p(object, "it");
        p p10 = this.$predicate;
        Integer n10 = ((i0)object).e();
        object = ((i0)object).f();
        return (Boolean)p10.invoke(n10, object);
    }
}

