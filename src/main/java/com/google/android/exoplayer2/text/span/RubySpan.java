/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.span;

public final class RubySpan {
    public static final int POSITION_OVER = 1;
    public static final int POSITION_UNDER = 2;
    public static final int POSITION_UNKNOWN = 255;
    public final int position;
    public final String rubyText;

    public RubySpan(String string2, int n10) {
        this.rubyText = string2;
        this.position = n10;
    }
}

