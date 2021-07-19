/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import com.google.android.exoplayer2.util.Util;

public final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String cssAllClassDescendantsSelector(String string2) {
        int n10 = String.valueOf(string2).length() + 5;
        int n11 = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(".");
        stringBuilder.append(string2);
        stringBuilder.append(",.");
        stringBuilder.append(string2);
        stringBuilder.append(" *");
        return stringBuilder.toString();
    }

    public static String toCssRgba(int n10) {
        Object[] objectArray = new Object[4];
        Integer n11 = Color.red((int)n10);
        objectArray[0] = n11;
        n11 = Color.green((int)n10);
        objectArray[1] = n11;
        n11 = Color.blue((int)n10);
        objectArray[2] = n11;
        Double d10 = (double)Color.alpha((int)n10) / 255.0;
        objectArray[3] = d10;
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", objectArray);
    }
}

