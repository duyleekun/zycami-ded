/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.p;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$onEachIndexed$1
extends Lambda
implements p {
    public final /* synthetic */ p $action;

    public SequencesKt___SequencesKt$onEachIndexed$1(p p10) {
        this.$action = p10;
        super(2);
    }

    public final Object invoke(int n10, Object object) {
        p p10 = this.$action;
        Integer n11 = n10;
        p10.invoke(n11, object);
        return object;
    }
}

