/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.x1.e0;
import java.util.Iterator;
import kotlin.text.StringsKt__StringsKt;

public final class StringsKt___StringsKt$c
implements e0 {
    public final /* synthetic */ CharSequence a;
    public final /* synthetic */ l b;

    public StringsKt___StringsKt$c(CharSequence charSequence, l l10) {
        this.a = charSequence;
        this.b = l10;
    }

    public Iterator b() {
        return StringsKt__StringsKt.t3(this.a);
    }

    public Object c(char c10) {
        l l10 = this.b;
        Character c11 = Character.valueOf(c10);
        return l10.invoke(c11);
    }
}

