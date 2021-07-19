/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.m;
import java.util.Iterator;
import kotlin.jvm.internal.FunctionReferenceImpl;

public final class SequencesKt___SequencesKt$flatMap$2
extends FunctionReferenceImpl
implements l {
    public static final SequencesKt___SequencesKt$flatMap$2 INSTANCE;

    static {
        SequencesKt___SequencesKt$flatMap$2 sequencesKt___SequencesKt$flatMap$2;
        INSTANCE = sequencesKt___SequencesKt$flatMap$2 = new SequencesKt___SequencesKt$flatMap$2();
    }

    public SequencesKt___SequencesKt$flatMap$2() {
        super(1, m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    public final Iterator invoke(m m10) {
        f0.p(m10, "p1");
        return m10.iterator();
    }
}

