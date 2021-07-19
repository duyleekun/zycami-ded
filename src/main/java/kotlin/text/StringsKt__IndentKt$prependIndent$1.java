/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.l;
import f.h2.t.f0;
import f.q2.u;
import kotlin.jvm.internal.Lambda;

public final class StringsKt__IndentKt$prependIndent$1
extends Lambda
implements l {
    public final /* synthetic */ String $indent;

    public StringsKt__IndentKt$prependIndent$1(String string2) {
        this.$indent = string2;
        super(1);
    }

    public final String invoke(String string2) {
        CharSequence charSequence = "it";
        f0.p(string2, (String)charSequence);
        int n10 = u.S1(string2);
        if (n10 != 0) {
            String string3;
            int n11;
            n10 = string2.length();
            if (n10 < (n11 = (string3 = this.$indent).length())) {
                string2 = this.$indent;
            }
        } else {
            charSequence = new StringBuilder();
            String string4 = this.$indent;
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        }
        return string2;
    }
}

