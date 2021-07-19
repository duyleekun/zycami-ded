/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.h2.t.f0;
import f.l2.k;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

public final class StringsKt__StringsKt$splitToSequence$2
extends Lambda
implements l {
    public final /* synthetic */ CharSequence $this_splitToSequence;

    public StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        this.$this_splitToSequence = charSequence;
        super(1);
    }

    public final String invoke(k k10) {
        f0.p(k10, "it");
        return StringsKt__StringsKt.W4(this.$this_splitToSequence, k10);
    }
}

