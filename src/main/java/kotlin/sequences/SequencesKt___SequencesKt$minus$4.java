/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.n2.m;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$minus$4$iterator$1;

public final class SequencesKt___SequencesKt$minus$4
implements m {
    public final /* synthetic */ m a;
    public final /* synthetic */ m b;

    public SequencesKt___SequencesKt$minus$4(m m10, m m11) {
        this.a = m10;
        this.b = m11;
    }

    public Iterator iterator() {
        HashSet hashSet = SequencesKt___SequencesKt.U2(this.b);
        boolean bl2 = hashSet.isEmpty();
        if (bl2) {
            return this.a.iterator();
        }
        m m10 = this.a;
        SequencesKt___SequencesKt$minus$4$iterator$1 sequencesKt___SequencesKt$minus$4$iterator$1 = new SequencesKt___SequencesKt$minus$4$iterator$1(hashSet);
        return SequencesKt___SequencesKt.n0(m10, sequencesKt___SequencesKt$minus$4$iterator$1).iterator();
    }
}

