/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$elementAt$1
extends Lambda
implements l {
    public final /* synthetic */ int $index;

    public SequencesKt___SequencesKt$elementAt$1(int n10) {
        this.$index = n10;
        super(1);
    }

    public final Object invoke(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Sequence doesn't contain element at index ");
        int n11 = this.$index;
        charSequence.append(n11);
        charSequence.append('.');
        charSequence = charSequence.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)charSequence);
        throw indexOutOfBoundsException;
    }
}

