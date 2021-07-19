/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$4;
import com.google.common.base.Splitter$SplittingIterator;

public class Splitter$4$1
extends Splitter$SplittingIterator {
    public final /* synthetic */ Splitter$4 this$0;

    public Splitter$4$1(Splitter$4 splitter$4, Splitter splitter, CharSequence charSequence) {
        this.this$0 = splitter$4;
        super(splitter, charSequence);
    }

    public int separatorEnd(int n10) {
        return n10;
    }

    public int separatorStart(int n10) {
        int n11 = this.this$0.val$length;
        CharSequence charSequence = this.toSplit;
        if ((n10 += n11) >= (n11 = charSequence.length())) {
            n10 = -1;
        }
        return n10;
    }
}

