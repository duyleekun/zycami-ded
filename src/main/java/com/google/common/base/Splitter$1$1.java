/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1;
import com.google.common.base.Splitter$SplittingIterator;

public class Splitter$1$1
extends Splitter$SplittingIterator {
    public final /* synthetic */ Splitter$1 this$0;

    public Splitter$1$1(Splitter$1 splitter$1, Splitter splitter, CharSequence charSequence) {
        this.this$0 = splitter$1;
        super(splitter, charSequence);
    }

    public int separatorEnd(int n10) {
        return n10 + 1;
    }

    public int separatorStart(int n10) {
        CharMatcher charMatcher = this.this$0.val$separatorMatcher;
        CharSequence charSequence = this.toSplit;
        return charMatcher.indexIn(charSequence, n10);
    }
}

