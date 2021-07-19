/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$2;
import com.google.common.base.Splitter$SplittingIterator;

public class Splitter$2$1
extends Splitter$SplittingIterator {
    public final /* synthetic */ Splitter$2 this$0;

    public Splitter$2$1(Splitter$2 splitter$2, Splitter splitter, CharSequence charSequence) {
        this.this$0 = splitter$2;
        super(splitter, charSequence);
    }

    public int separatorEnd(int n10) {
        int n11 = this.this$0.val$separator.length();
        return n10 + n11;
    }

    public int separatorStart(int n10) {
        String string2 = this.this$0.val$separator;
        int n11 = string2.length();
        CharSequence charSequence = this.toSplit;
        int n12 = charSequence.length() - n11;
        block0: while (n10 <= n12) {
            for (int i10 = 0; i10 < n11; ++i10) {
                String string3;
                CharSequence charSequence2 = this.toSplit;
                int n13 = i10 + n10;
                char c10 = charSequence2.charAt(n13);
                if (c10 == (n13 = (int)(string3 = this.this$0.val$separator).charAt(i10))) continue;
                ++n10;
                continue block0;
            }
            return n10;
        }
        return -1;
    }
}

