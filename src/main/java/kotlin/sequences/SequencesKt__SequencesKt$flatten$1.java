/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.m;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt__SequencesKt$flatten$1
extends Lambda
implements l {
    public static final SequencesKt__SequencesKt$flatten$1 INSTANCE;

    static {
        SequencesKt__SequencesKt$flatten$1 sequencesKt__SequencesKt$flatten$1;
        INSTANCE = sequencesKt__SequencesKt$flatten$1 = new SequencesKt__SequencesKt$flatten$1();
    }

    public SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    public final Iterator invoke(m m10) {
        f0.p(m10, "it");
        return m10.iterator();
    }
}

