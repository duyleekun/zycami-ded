/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.AbstractIterator;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public abstract class Splitter$SplittingIterator
extends AbstractIterator {
    public int limit;
    public int offset = 0;
    public final boolean omitEmptyStrings;
    public final CharSequence toSplit;
    public final CharMatcher trimmer;

    public Splitter$SplittingIterator(Splitter splitter, CharSequence charSequence) {
        int n10;
        boolean bl2;
        CharMatcher charMatcher;
        this.trimmer = charMatcher = Splitter.access$200(splitter);
        this.omitEmptyStrings = bl2 = Splitter.access$300(splitter);
        this.limit = n10 = Splitter.access$400(splitter);
        this.toSplit = charSequence;
    }

    public String computeNext() {
        int n10;
        int n11;
        int n12 = this.offset;
        while ((n11 = this.offset) != (n10 = -1)) {
            int n13;
            CharSequence charSequence;
            int n14;
            Object object;
            int n15;
            CharSequence charSequence2;
            if ((n11 = this.separatorStart(n11)) == n10) {
                charSequence2 = this.toSplit;
                n11 = charSequence2.length();
                this.offset = n10;
            } else {
                this.offset = n15 = this.separatorEnd(n11);
            }
            n15 = this.offset;
            if (n15 == n12) {
                this.offset = ++n15;
                charSequence2 = this.toSplit;
                n11 = charSequence2.length();
                if (n15 <= n11) continue;
                this.offset = n10;
                continue;
            }
            while (n12 < n11 && (n15 = (int)(((CharMatcher)(object = this.trimmer)).matches((char)(n14 = (charSequence = this.toSplit).charAt(n12))) ? 1 : 0)) != 0) {
                ++n12;
            }
            while (n11 > n12 && (n15 = (int)(((CharMatcher)(object = this.trimmer)).matches((char)(n14 = (charSequence = this.toSplit).charAt(n13 = n11 + -1))) ? 1 : 0)) != 0) {
                n11 += -1;
            }
            n15 = (int)(this.omitEmptyStrings ? 1 : 0);
            if (n15 != 0 && n12 == n11) {
                n12 = this.offset;
                continue;
            }
            n15 = this.limit;
            n14 = 1;
            if (n15 == n14) {
                CharMatcher charMatcher;
                charSequence2 = this.toSplit;
                this.offset = n10;
                for (n11 = charSequence2.length(); n11 > n12 && (n10 = (int)((charMatcher = this.trimmer).matches((char)(n15 = (int)(object = this.toSplit).charAt(n14 = n11 + -1))) ? 1 : 0)) != 0; n11 += -1) {
                }
            } else {
                this.limit = n15 -= n14;
            }
            return this.toSplit.subSequence(n12, n11).toString();
        }
        return (String)this.endOfData();
    }

    public abstract int separatorEnd(int var1);

    public abstract int separatorStart(int var1);
}

