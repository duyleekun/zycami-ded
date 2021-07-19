/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.view.accessibility.CaptioningManager$CaptionStyle
 */
package com.google.android.exoplayer2.text;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;

public final class CaptionStyleCompat {
    public static final CaptionStyleCompat DEFAULT;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int USE_TRACK_COLOR_SETTINGS = 1;
    public final int backgroundColor;
    public final int edgeColor;
    public final int edgeType;
    public final int foregroundColor;
    public final Typeface typeface;
    public final int windowColor;

    static {
        CaptionStyleCompat captionStyleCompat;
        DEFAULT = captionStyleCompat = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    }

    public CaptionStyleCompat(int n10, int n11, int n12, int n13, int n14, Typeface typeface) {
        this.foregroundColor = n10;
        this.backgroundColor = n11;
        this.windowColor = n12;
        this.edgeType = n13;
        this.edgeColor = n14;
        this.typeface = typeface;
    }

    public static CaptionStyleCompat createFromCaptionStyle(CaptioningManager.CaptionStyle captionStyle) {
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return CaptionStyleCompat.createFromCaptionStyleV21(captionStyle);
        }
        return CaptionStyleCompat.createFromCaptionStyleV19(captionStyle);
    }

    private static CaptionStyleCompat createFromCaptionStyleV19(CaptioningManager.CaptionStyle captionStyle) {
        int n10 = captionStyle.foregroundColor;
        int n11 = captionStyle.backgroundColor;
        int n12 = captionStyle.edgeType;
        int n13 = captionStyle.edgeColor;
        Typeface typeface = captionStyle.getTypeface();
        CaptionStyleCompat captionStyleCompat = new CaptionStyleCompat(n10, n11, 0, n12, n13, typeface);
        return captionStyleCompat;
    }

    private static CaptionStyleCompat createFromCaptionStyleV21(CaptioningManager.CaptionStyle captionStyle) {
        CaptionStyleCompat captionStyleCompat;
        CaptionStyleCompat captionStyleCompat2;
        int n10 = captionStyle.hasForegroundColor();
        if (n10 != 0) {
            n10 = captionStyle.foregroundColor;
        } else {
            captionStyleCompat2 = DEFAULT;
            n10 = captionStyleCompat2.foregroundColor;
        }
        int n11 = n10;
        n10 = (int)(captionStyle.hasBackgroundColor() ? 1 : 0);
        if (n10 != 0) {
            n10 = captionStyle.backgroundColor;
        } else {
            captionStyleCompat2 = DEFAULT;
            n10 = captionStyleCompat2.backgroundColor;
        }
        int n12 = n10;
        n10 = (int)(captionStyle.hasWindowColor() ? 1 : 0);
        if (n10 != 0) {
            n10 = captionStyle.windowColor;
        } else {
            captionStyleCompat2 = DEFAULT;
            n10 = captionStyleCompat2.windowColor;
        }
        int n13 = n10;
        n10 = (int)(captionStyle.hasEdgeType() ? 1 : 0);
        if (n10 != 0) {
            n10 = captionStyle.edgeType;
        } else {
            captionStyleCompat2 = DEFAULT;
            n10 = captionStyleCompat2.edgeType;
        }
        int n14 = n10;
        n10 = (int)(captionStyle.hasEdgeColor() ? 1 : 0);
        if (n10 != 0) {
            n10 = captionStyle.edgeColor;
        } else {
            captionStyleCompat2 = DEFAULT;
            n10 = captionStyleCompat2.edgeColor;
        }
        Typeface typeface = captionStyle.getTypeface();
        captionStyleCompat2 = captionStyleCompat;
        captionStyleCompat = new CaptionStyleCompat(n11, n12, n13, n14, n10, typeface);
        return captionStyleCompat;
    }
}

