/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.Html
 *  android.text.Html$ImageGetter
 *  android.text.Html$TagHandler
 *  android.text.Spanned
 */
package androidx.core.text;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    private HtmlCompat() {
    }

    public static Spanned fromHtml(String string2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            return Html.fromHtml((String)string2, (int)n10);
        }
        return Html.fromHtml((String)string2);
    }

    public static Spanned fromHtml(String string2, int n10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            return Html.fromHtml((String)string2, (int)n10, (Html.ImageGetter)imageGetter, (Html.TagHandler)tagHandler);
        }
        return Html.fromHtml((String)string2, (Html.ImageGetter)imageGetter, (Html.TagHandler)tagHandler);
    }

    public static String toHtml(Spanned spanned, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            return Html.toHtml((Spanned)spanned, (int)n10);
        }
        return Html.toHtml((Spanned)spanned);
    }
}

