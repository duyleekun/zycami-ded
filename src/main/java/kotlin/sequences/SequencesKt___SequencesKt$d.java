/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.n2.m;
import f.x1.x;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.SequencesKt___SequencesKt;

public final class SequencesKt___SequencesKt$d
implements m {
    public final /* synthetic */ m a;
    public final /* synthetic */ Comparator b;

    public SequencesKt___SequencesKt$d(m m10, Comparator comparator) {
        this.a = m10;
        this.b = comparator;
    }

    public Iterator iterator() {
        List list = SequencesKt___SequencesKt.W2(this.a);
        Comparator comparator = this.b;
        x.p0(list, comparator);
        return list.iterator();
    }
}

