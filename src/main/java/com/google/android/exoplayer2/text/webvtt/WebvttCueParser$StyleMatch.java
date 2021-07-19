/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.webvtt.WebvttCssStyle;

public final class WebvttCueParser$StyleMatch
implements Comparable {
    public final int score;
    public final WebvttCssStyle style;

    public WebvttCueParser$StyleMatch(int n10, WebvttCssStyle webvttCssStyle) {
        this.score = n10;
        this.style = webvttCssStyle;
    }

    public int compareTo(WebvttCueParser$StyleMatch webvttCueParser$StyleMatch) {
        int n10 = this.score;
        int n11 = webvttCueParser$StyleMatch.score;
        return Integer.compare(n10, n11);
    }
}

