/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser$1;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser$StartTag;
import d.h.a.a.n0.c.a;
import java.util.Comparator;

public class WebvttCueParser$Element {
    private static final Comparator BY_START_POSITION_ASC = a.a;
    private final int endPosition;
    private final WebvttCueParser$StartTag startTag;

    private WebvttCueParser$Element(WebvttCueParser$StartTag webvttCueParser$StartTag, int n10) {
        this.startTag = webvttCueParser$StartTag;
        this.endPosition = n10;
    }

    public /* synthetic */ WebvttCueParser$Element(WebvttCueParser$StartTag startTag, int n10, WebvttCueParser$1 webvttCueParser$1) {
        this(startTag, n10);
    }

    public static /* synthetic */ int a(WebvttCueParser$Element webvttCueParser$Element, WebvttCueParser$Element webvttCueParser$Element2) {
        int n10 = webvttCueParser$Element.startTag.position;
        int n11 = webvttCueParser$Element2.startTag.position;
        return Integer.compare(n10, n11);
    }

    public static /* synthetic */ Comparator access$100() {
        return BY_START_POSITION_ASC;
    }

    public static /* synthetic */ WebvttCueParser$StartTag access$200(WebvttCueParser$Element webvttCueParser$Element) {
        return webvttCueParser$Element.startTag;
    }

    public static /* synthetic */ int access$300(WebvttCueParser$Element webvttCueParser$Element) {
        return webvttCueParser$Element.endPosition;
    }
}

