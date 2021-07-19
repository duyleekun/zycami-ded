/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$4$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;

public final class Splitter$4
implements Splitter$Strategy {
    public final /* synthetic */ int val$length;

    public Splitter$4(int n10) {
        this.val$length = n10;
    }

    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        Splitter$4$1 splitter$4$1 = new Splitter$4$1(this, splitter, charSequence);
        return splitter$4$1;
    }
}

