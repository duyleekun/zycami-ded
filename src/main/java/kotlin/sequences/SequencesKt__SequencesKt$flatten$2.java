/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.h2.t.f0;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt__SequencesKt$flatten$2
extends Lambda
implements l {
    public static final SequencesKt__SequencesKt$flatten$2 INSTANCE;

    static {
        SequencesKt__SequencesKt$flatten$2 sequencesKt__SequencesKt$flatten$2;
        INSTANCE = sequencesKt__SequencesKt$flatten$2 = new SequencesKt__SequencesKt$flatten$2();
    }

    public SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    public final Iterator invoke(Iterable iterable) {
        f0.p(iterable, "it");
        return iterable.iterator();
    }
}

