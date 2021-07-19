/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.n2.m;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$requireNoNulls$1
extends Lambda
implements l {
    public final /* synthetic */ m $this_requireNoNulls;

    public SequencesKt___SequencesKt$requireNoNulls$1(m m10) {
        this.$this_requireNoNulls = m10;
        super(1);
    }

    public final Object invoke(Object object) {
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("null element found in ");
        m m10 = this.$this_requireNoNulls;
        charSequence.append(m10);
        charSequence.append('.');
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }
}

