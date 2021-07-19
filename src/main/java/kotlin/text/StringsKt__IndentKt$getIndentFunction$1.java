/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.h2.t.f0;
import kotlin.jvm.internal.Lambda;

public final class StringsKt__IndentKt$getIndentFunction$1
extends Lambda
implements l {
    public static final StringsKt__IndentKt$getIndentFunction$1 INSTANCE;

    static {
        StringsKt__IndentKt$getIndentFunction$1 stringsKt__IndentKt$getIndentFunction$1;
        INSTANCE = stringsKt__IndentKt$getIndentFunction$1 = new StringsKt__IndentKt$getIndentFunction$1();
    }

    public StringsKt__IndentKt$getIndentFunction$1() {
        super(1);
    }

    public final String invoke(String string2) {
        f0.p(string2, "line");
        return string2;
    }
}

