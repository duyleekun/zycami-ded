/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

public final class StringsKt___StringsKt$withIndex$1
extends Lambda
implements a {
    public final /* synthetic */ CharSequence $this_withIndex;

    public StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        this.$this_withIndex = charSequence;
        super(0);
    }

    public final Iterator invoke() {
        return StringsKt__StringsKt.t3(this.$this_withIndex);
    }
}

