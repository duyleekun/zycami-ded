/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.p;
import f.h2.t.f0;
import f.w0;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

public final class StringsKt__StringsKt$rangesDelimitedBy$4
extends Lambda
implements p {
    public final /* synthetic */ List $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    public StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean bl2) {
        this.$delimitersList = list;
        this.$ignoreCase = bl2;
        super(2);
    }

    public final Pair invoke(CharSequence object, int n10) {
        f0.p(object, "$receiver");
        List list = this.$delimitersList;
        boolean bl2 = this.$ignoreCase;
        object = StringsKt__StringsKt.G2((CharSequence)object, list, n10, bl2, false);
        if (object != null) {
            Object object2 = ((Pair)object).getFirst();
            int n11 = ((String)((Pair)object).getSecond()).length();
            object = n11;
            object = w0.a(object2, object);
        } else {
            boolean bl3 = false;
            object = null;
        }
        return object;
    }
}

