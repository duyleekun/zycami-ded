/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

public final class BaseEncoding$4
implements Appendable {
    public int charsUntilSeparator;
    public final /* synthetic */ int val$afterEveryChars;
    public final /* synthetic */ Appendable val$delegate;
    public final /* synthetic */ String val$separator;

    public BaseEncoding$4(int n10, Appendable appendable, String string2) {
        this.val$afterEveryChars = n10;
        this.val$delegate = appendable;
        this.val$separator = string2;
        this.charsUntilSeparator = n10;
    }

    public Appendable append(char c10) {
        int n10 = this.charsUntilSeparator;
        if (n10 == 0) {
            Appendable appendable = this.val$delegate;
            String string2 = this.val$separator;
            appendable.append(string2);
            this.charsUntilSeparator = n10 = this.val$afterEveryChars;
        }
        this.val$delegate.append(c10);
        c10 = (char)(this.charsUntilSeparator + -1);
        this.charsUntilSeparator = c10;
        return this;
    }

    public Appendable append(CharSequence object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Appendable append(CharSequence object, int n10, int n11) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

