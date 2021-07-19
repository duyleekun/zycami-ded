/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonMatcher;
import com.google.common.base.CommonPattern;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$3$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;

public final class Splitter$3
implements Splitter$Strategy {
    public final /* synthetic */ CommonPattern val$separatorPattern;

    public Splitter$3(CommonPattern commonPattern) {
        this.val$separatorPattern = commonPattern;
    }

    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        CommonMatcher commonMatcher = this.val$separatorPattern.matcher(charSequence);
        Splitter$3$1 splitter$3$1 = new Splitter$3$1(this, splitter, charSequence, commonMatcher);
        return splitter$3$1;
    }
}

