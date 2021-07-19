/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$3;
import com.google.common.base.Splitter$SplittingIterator;

public class Splitter$3$1
extends Splitter$SplittingIterator {
    public final /* synthetic */ Splitter$3 this$0;
    public final /* synthetic */ CommonMatcher val$matcher;

    public Splitter$3$1(Splitter$3 splitter$3, Splitter splitter, CharSequence charSequence, CommonMatcher commonMatcher) {
        this.this$0 = splitter$3;
        this.val$matcher = commonMatcher;
        super(splitter, charSequence);
    }

    public int separatorEnd(int n10) {
        return this.val$matcher.end();
    }

    public int separatorStart(int n10) {
        CommonMatcher commonMatcher = this.val$matcher;
        if ((n10 = (int)(commonMatcher.find(n10) ? 1 : 0)) != 0) {
            CommonMatcher commonMatcher2 = this.val$matcher;
            n10 = commonMatcher2.start();
        } else {
            n10 = -1;
        }
        return n10;
    }
}

