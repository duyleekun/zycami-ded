/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.text.TextUtils
 */
package d.v.e.l;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;

public final class d2 {
    private d2() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static float a(Paint paint) {
        paint = paint.getFontMetrics();
        float f10 = paint.descent;
        float f11 = paint.ascent;
        return f10 - f11;
    }

    public static float b(Paint paint) {
        return d2.c(paint, "\u5de5");
    }

    public static float c(Paint paint, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return d2.a(paint);
        }
        Rect rect = new Rect();
        int n10 = string2.length();
        paint.getTextBounds(string2, 0, n10, rect);
        return rect.height();
    }

    public static float d(Paint paint, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return 0.0f;
        }
        return paint.measureText(string2);
    }
}

