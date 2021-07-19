/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;

public final class Splitter$1
implements Splitter$Strategy {
    public final /* synthetic */ CharMatcher val$separatorMatcher;

    public Splitter$1(CharMatcher charMatcher) {
        this.val$separatorMatcher = charMatcher;
    }

    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        Splitter$1$1 splitter$1$1 = new Splitter$1$1(this, splitter, charSequence);
        return splitter$1$1;
    }
}

