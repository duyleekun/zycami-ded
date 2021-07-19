/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.h2.t.f0;
import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;

public final class SequencesKt___SequencesKt$flatMap$1
extends FunctionReferenceImpl
implements l {
    public static final SequencesKt___SequencesKt$flatMap$1 INSTANCE;

    static {
        SequencesKt___SequencesKt$flatMap$1 sequencesKt___SequencesKt$flatMap$1;
        INSTANCE = sequencesKt___SequencesKt$flatMap$1 = new SequencesKt___SequencesKt$flatMap$1();
    }

    public SequencesKt___SequencesKt$flatMap$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    public final Iterator invoke(Iterable iterable) {
        f0.p(iterable, "p1");
        return iterable.iterator();
    }
}

