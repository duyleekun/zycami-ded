/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.n2.m;
import java.util.Iterator;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$minus$1$iterator$1;

public final class SequencesKt___SequencesKt$minus$1
implements m {
    public final /* synthetic */ m a;
    public final /* synthetic */ Object b;

    public SequencesKt___SequencesKt$minus$1(m m10, Object object) {
        this.a = m10;
        this.b = object;
    }

    public Iterator iterator() {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        m m10 = this.a;
        SequencesKt___SequencesKt$minus$1$iterator$1 sequencesKt___SequencesKt$minus$1$iterator$1 = new SequencesKt___SequencesKt$minus$1$iterator$1(this, ref$BooleanRef);
        return SequencesKt___SequencesKt.i0(m10, sequencesKt___SequencesKt$minus$1$iterator$1).iterator();
    }
}

