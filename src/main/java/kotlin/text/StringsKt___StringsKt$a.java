/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.x0.a;
import java.util.Iterator;
import kotlin.text.StringsKt__StringsKt;

public final class StringsKt___StringsKt$a
implements Iterable,
a {
    public final /* synthetic */ CharSequence a;

    public StringsKt___StringsKt$a(CharSequence charSequence) {
        this.a = charSequence;
    }

    public Iterator iterator() {
        return StringsKt__StringsKt.t3(this.a);
    }
}

