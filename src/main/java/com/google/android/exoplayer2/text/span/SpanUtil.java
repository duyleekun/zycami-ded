/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Spannable
 */
package com.google.android.exoplayer2.text.span;

import android.text.Spannable;

public final class SpanUtil {
    private SpanUtil() {
    }

    public static void addOrReplaceSpan(Spannable spannable, Object object, int n10, int n11, int n12) {
        Object[] objectArray = object.getClass();
        for (Object object2 : spannable.getSpans(n10, n11, objectArray)) {
            int n13 = spannable.getSpanStart(object2);
            if (n13 != n10 || (n13 = spannable.getSpanEnd(object2)) != n11 || (n13 = spannable.getSpanFlags(object2)) != n12) continue;
            spannable.removeSpan(object2);
        }
        spannable.setSpan(object, n10, n11, n12);
    }
}

