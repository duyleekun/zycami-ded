/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.n2.m;
import f.x1.u;
import java.util.Collection;
import java.util.Iterator;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$minus$3$iterator$1;

public final class SequencesKt___SequencesKt$minus$3
implements m {
    public final /* synthetic */ m a;
    public final /* synthetic */ Iterable b;

    public SequencesKt___SequencesKt$minus$3(m m10, Iterable iterable) {
        this.a = m10;
        this.b = iterable;
    }

    public Iterator iterator() {
        Collection collection = u.a0(this.b);
        boolean bl2 = collection.isEmpty();
        if (bl2) {
            return this.a.iterator();
        }
        m m10 = this.a;
        SequencesKt___SequencesKt$minus$3$iterator$1 sequencesKt___SequencesKt$minus$3$iterator$1 = new SequencesKt___SequencesKt$minus$3$iterator$1(collection);
        return SequencesKt___SequencesKt.n0(m10, sequencesKt___SequencesKt$minus$3$iterator$1).iterator();
    }
}

