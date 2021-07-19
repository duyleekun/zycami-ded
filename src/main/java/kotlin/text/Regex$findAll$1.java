/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.s.a;
import f.q2.k;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

public final class Regex$findAll$1
extends Lambda
implements a {
    public final /* synthetic */ CharSequence $input;
    public final /* synthetic */ int $startIndex;
    public final /* synthetic */ Regex this$0;

    public Regex$findAll$1(Regex regex, CharSequence charSequence, int n10) {
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = n10;
        super(0);
    }

    public final k invoke() {
        Regex regex = this.this$0;
        CharSequence charSequence = this.$input;
        int n10 = this.$startIndex;
        return regex.find(charSequence, n10);
    }
}

