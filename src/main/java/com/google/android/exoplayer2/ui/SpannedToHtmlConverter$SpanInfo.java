/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.ui.SpannedToHtmlConverter$1;
import d.h.a.a.p0.f;
import d.h.a.a.p0.g;
import java.util.Comparator;

public final class SpannedToHtmlConverter$SpanInfo {
    private static final Comparator FOR_CLOSING_TAGS;
    private static final Comparator FOR_OPENING_TAGS;
    public final String closingTag;
    public final int end;
    public final String openingTag;
    public final int start;

    static {
        FOR_OPENING_TAGS = f.a;
        FOR_CLOSING_TAGS = g.a;
    }

    private SpannedToHtmlConverter$SpanInfo(int n10, int n11, String string2, String string3) {
        this.start = n10;
        this.end = n11;
        this.openingTag = string2;
        this.closingTag = string3;
    }

    public /* synthetic */ SpannedToHtmlConverter$SpanInfo(int n10, int n11, String string2, String string3, SpannedToHtmlConverter$1 spannedToHtmlConverter$1) {
        this(n10, n11, string2, string3);
    }

    public static /* synthetic */ int a(SpannedToHtmlConverter$SpanInfo object, SpannedToHtmlConverter$SpanInfo object2) {
        int n10 = ((SpannedToHtmlConverter$SpanInfo)object2).end;
        int n11 = ((SpannedToHtmlConverter$SpanInfo)object).end;
        if ((n10 = Integer.compare(n10, n11)) != 0) {
            return n10;
        }
        String string2 = ((SpannedToHtmlConverter$SpanInfo)object).openingTag;
        String string3 = ((SpannedToHtmlConverter$SpanInfo)object2).openingTag;
        n10 = string2.compareTo(string3);
        if (n10 != 0) {
            return n10;
        }
        object = ((SpannedToHtmlConverter$SpanInfo)object).closingTag;
        object2 = ((SpannedToHtmlConverter$SpanInfo)object2).closingTag;
        return ((String)object).compareTo((String)object2);
    }

    public static /* synthetic */ Comparator access$200() {
        return FOR_CLOSING_TAGS;
    }

    public static /* synthetic */ Comparator access$400() {
        return FOR_OPENING_TAGS;
    }

    public static /* synthetic */ int b(SpannedToHtmlConverter$SpanInfo object, SpannedToHtmlConverter$SpanInfo object2) {
        int n10 = ((SpannedToHtmlConverter$SpanInfo)object2).start;
        int n11 = ((SpannedToHtmlConverter$SpanInfo)object).start;
        if ((n10 = Integer.compare(n10, n11)) != 0) {
            return n10;
        }
        String string2 = ((SpannedToHtmlConverter$SpanInfo)object2).openingTag;
        String string3 = ((SpannedToHtmlConverter$SpanInfo)object).openingTag;
        n10 = string2.compareTo(string3);
        if (n10 != 0) {
            return n10;
        }
        object2 = ((SpannedToHtmlConverter$SpanInfo)object2).closingTag;
        object = ((SpannedToHtmlConverter$SpanInfo)object).closingTag;
        return ((String)object2).compareTo((String)object);
    }
}

