/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;

public final class MediaType$Tokenizer {
    public final String input;
    public int position = 0;

    public MediaType$Tokenizer(String string2) {
        this.input = string2;
    }

    public char consumeCharacter(char c10) {
        Preconditions.checkState(this.hasMore());
        int n10 = this.previewChar();
        int n11 = 1;
        n10 = n10 == c10 ? n11 : 0;
        Preconditions.checkState(n10 != 0);
        this.position = n10 = this.position + n11;
        return c10;
    }

    public char consumeCharacter(CharMatcher charMatcher) {
        int n10;
        Preconditions.checkState(this.hasMore());
        char c10 = this.previewChar();
        Preconditions.checkState(charMatcher.matches(c10));
        this.position = n10 = this.position + 1;
        return c10;
    }

    public String consumeToken(CharMatcher object) {
        int n10 = this.position;
        object = this.consumeTokenIfPresent((CharMatcher)object);
        int n11 = this.position;
        n10 = n11 != n10 ? 1 : 0;
        Preconditions.checkState(n10 != 0);
        return object;
    }

    public String consumeTokenIfPresent(CharMatcher object) {
        int n10;
        Preconditions.checkState(this.hasMore());
        int n11 = this.position;
        object = ((CharMatcher)object).negate();
        String string2 = this.input;
        this.position = n10 = ((CharMatcher)object).indexIn(string2, n11);
        n10 = (int)(this.hasMore() ? 1 : 0);
        if (n10 != 0) {
            object = this.input;
            int n12 = this.position;
            object = ((String)object).substring(n11, n12);
        } else {
            object = this.input.substring(n11);
        }
        return object;
    }

    public boolean hasMore() {
        String string2;
        int n10;
        int n11 = this.position;
        n11 = n11 >= 0 && n11 < (n10 = (string2 = this.input).length()) ? 1 : 0;
        return n11 != 0;
    }

    public char previewChar() {
        Preconditions.checkState(this.hasMore());
        String string2 = this.input;
        int n10 = this.position;
        return string2.charAt(n10);
    }
}

