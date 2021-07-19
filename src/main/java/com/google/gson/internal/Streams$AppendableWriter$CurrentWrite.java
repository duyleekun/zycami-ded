/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

public class Streams$AppendableWriter$CurrentWrite
implements CharSequence {
    public char[] chars;

    public char charAt(int n10) {
        return this.chars[n10];
    }

    public int length() {
        return this.chars.length;
    }

    public CharSequence subSequence(int n10, int n11) {
        char[] cArray = this.chars;
        String string2 = new String(cArray, n10, n11 -= n10);
        return string2;
    }
}

