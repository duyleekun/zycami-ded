/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.h2.t.f0;
import kotlin.jvm.internal.Lambda;

public final class StringsKt___StringsKt$windowed$1
extends Lambda
implements l {
    public static final StringsKt___StringsKt$windowed$1 INSTANCE;

    static {
        StringsKt___StringsKt$windowed$1 stringsKt___StringsKt$windowed$1;
        INSTANCE = stringsKt___StringsKt$windowed$1 = new StringsKt___StringsKt$windowed$1();
    }

    public StringsKt___StringsKt$windowed$1() {
        super(1);
    }

    public final String invoke(CharSequence charSequence) {
        f0.p(charSequence, "it");
        return ((Object)charSequence).toString();
    }
}

