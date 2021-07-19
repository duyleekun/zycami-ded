/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BlendMode
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 */
package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.BlendModeUtils;
import androidx.core.util.Pair;

public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udb3f\udffd";
    private static final ThreadLocal sRectThreadLocal;

    static {
        ThreadLocal threadLocal;
        sRectThreadLocal = threadLocal = new ThreadLocal();
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(Paint paint, String object) {
        float f10;
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return paint.hasGlyph((String)object);
        }
        n10 = ((String)object).length();
        if (n10 == (n11 = 1) && (bl2 = Character.isWhitespace(((String)object).charAt(0)))) {
            return n11 != 0;
        }
        String string2 = TOFU_STRING;
        float f11 = paint.measureText(string2);
        String string3 = EM_STRING;
        float f12 = paint.measureText(string3);
        float f13 = paint.measureText((String)object);
        float f14 = 0.0f;
        float f15 = f13 - 0.0f;
        Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object2 == false) {
            return false;
        }
        object2 = ((String)object).length();
        if ((object2 = (Object)((String)object).codePointCount(0, (int)object2)) > n11) {
            object2 = 0x40000000;
            float f16 = 2.0f;
            float f17 = f13 - (f12 *= f16);
            Object object3 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
            if (object3 > 0) {
                return false;
            }
            object3 = false;
            string3 = null;
            f12 = 0.0f;
            while (object3 < n10) {
                object2 = Character.charCount(((String)object).codePointAt((int)object3)) + object3;
                f12 = paint.measureText((String)object, (int)object3, (int)object2);
                f14 += f12;
                object3 = object2;
            }
            object3 = f13 == f14 ? 0 : (f13 > f14 ? 1 : -1);
            if (object3 >= 0) {
                return false;
            }
        }
        if ((f10 = f13 == f11 ? 0 : (f13 > f11 ? 1 : -1)) != false) {
            return n11 != 0;
        }
        Pair pair = PaintCompat.obtainEmptyRects();
        Rect rect = (Rect)pair.first;
        paint.getTextBounds(string2, 0, 2, rect);
        string2 = (Rect)pair.second;
        paint.getTextBounds((String)object, 0, n10, (Rect)string2);
        paint = (Rect)pair.first;
        object = pair.second;
        return (paint.equals(object) ^ n11) != 0;
    }

    private static Pair obtainEmptyRects() {
        ThreadLocal threadLocal = sRectThreadLocal;
        Pair pair = (Pair)threadLocal.get();
        if (pair == null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            pair = new Pair(rect, rect2);
            threadLocal.set(pair);
        } else {
            ((Rect)pair.first).setEmpty();
            threadLocal = (Rect)pair.second;
            threadLocal.setEmpty();
        }
        return pair;
    }

    public static boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        BlendMode blendMode = null;
        int n11 = 29;
        if (n10 >= n11) {
            if (blendModeCompat != null) {
                blendMode = BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat);
            }
            paint.setBlendMode(blendMode);
            return bl2;
        }
        if (blendModeCompat != null) {
            if ((blendModeCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat)) != null) {
                blendMode = new PorterDuffXfermode((PorterDuff.Mode)blendModeCompat);
            }
            paint.setXfermode((Xfermode)blendMode);
            if (blendModeCompat == null) {
                bl2 = false;
            }
            return bl2;
        }
        paint.setXfermode(null);
        return bl2;
    }
}

