/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$2$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;

public final class Splitter$2
implements Splitter$Strategy {
    public final /* synthetic */ String val$separator;

    public Splitter$2(String string2) {
        this.val$separator = string2;
    }

    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        Splitter$2$1 splitter$2$1 = new Splitter$2$1(this, splitter, charSequence);
        return splitter$2$1;
    }
}

