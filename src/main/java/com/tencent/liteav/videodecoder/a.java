/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videodecoder;

public class a {
    private char[] a;
    private int b;

    public a(int n10) {
        char[] cArray = new char[n10];
        this.a = cArray;
    }

    public String toString() {
        char[] cArray = this.a;
        int n10 = this.b;
        String string2 = new String(cArray, 0, n10);
        return string2;
    }
}

