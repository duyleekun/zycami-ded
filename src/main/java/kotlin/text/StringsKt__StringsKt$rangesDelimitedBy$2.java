/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.p;
import f.h2.t.f0;
import f.w0;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

public final class StringsKt__StringsKt$rangesDelimitedBy$2
extends Lambda
implements p {
    public final /* synthetic */ char[] $delimiters;
    public final /* synthetic */ boolean $ignoreCase;

    public StringsKt__StringsKt$rangesDelimitedBy$2(char[] cArray, boolean bl2) {
        this.$delimiters = cArray;
        this.$ignoreCase = bl2;
        super(2);
    }

    public final Pair invoke(CharSequence object, int n10) {
        f0.p(object, "$receiver");
        char[] cArray = this.$delimiters;
        boolean bl2 = this.$ignoreCase;
        int n11 = StringsKt__StringsKt.l3((CharSequence)object, cArray, n10, bl2);
        if (n11 < 0) {
            n11 = 0;
            object = null;
        } else {
            object = n11;
            n10 = 1;
            Integer n12 = n10;
            object = w0.a(object, n12);
        }
        return object;
    }
}

