/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Function;
import com.google.common.escape.Escaper;

public class Escaper$1
implements Function {
    public final /* synthetic */ Escaper this$0;

    public Escaper$1(Escaper escaper) {
        this.this$0 = escaper;
    }

    public String apply(String string2) {
        return this.this$0.escape(string2);
    }
}

