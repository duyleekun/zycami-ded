/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.n2.m;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$minus$2$iterator$1;

public final class SequencesKt___SequencesKt$minus$2
implements m {
    public final /* synthetic */ m a;
    public final /* synthetic */ Object[] b;

    public SequencesKt___SequencesKt$minus$2(m m10, Object[] objectArray) {
        this.a = m10;
        this.b = objectArray;
    }

    public Iterator iterator() {
        HashSet hashSet = ArraysKt___ArraysKt.ky(this.b);
        m m10 = this.a;
        SequencesKt___SequencesKt$minus$2$iterator$1 sequencesKt___SequencesKt$minus$2$iterator$1 = new SequencesKt___SequencesKt$minus$2$iterator$1(hashSet);
        return SequencesKt___SequencesKt.n0(m10, sequencesKt___SequencesKt$minus$2$iterator$1).iterator();
    }
}

