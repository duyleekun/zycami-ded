/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import kotlin.jvm.internal.Lambda;

public final class StringsKt___StringsKt$windowedSequence$2
extends Lambda
implements l {
    public final /* synthetic */ int $size;
    public final /* synthetic */ CharSequence $this_windowedSequence;
    public final /* synthetic */ l $transform;

    public StringsKt___StringsKt$windowedSequence$2(CharSequence charSequence, int n10, l l10) {
        this.$this_windowedSequence = charSequence;
        this.$size = n10;
        this.$transform = l10;
        super(1);
    }

    public final Object invoke(int n10) {
        Object object;
        int n11;
        int n12 = this.$size + n10;
        if (n12 < 0 || n12 > (n11 = (object = this.$this_windowedSequence).length())) {
            CharSequence charSequence = this.$this_windowedSequence;
            n12 = charSequence.length();
        }
        object = this.$transform;
        CharSequence charSequence = this.$this_windowedSequence.subSequence(n10, n12);
        return object.invoke(charSequence);
    }
}

