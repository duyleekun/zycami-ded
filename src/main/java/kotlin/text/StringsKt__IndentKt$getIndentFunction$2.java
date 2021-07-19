/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.h2.t.f0;
import kotlin.jvm.internal.Lambda;

public final class StringsKt__IndentKt$getIndentFunction$2
extends Lambda
implements l {
    public final /* synthetic */ String $indent;

    public StringsKt__IndentKt$getIndentFunction$2(String string2) {
        this.$indent = string2;
        super(1);
    }

    public final String invoke(String string2) {
        f0.p(string2, "line");
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = this.$indent;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

