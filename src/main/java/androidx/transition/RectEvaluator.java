/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Rect
 */
package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public class RectEvaluator
implements TypeEvaluator {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    public Rect evaluate(float f10, Rect rect, Rect rect2) {
        int n10 = rect.left;
        float f11 = (float)(rect2.left - n10) * f10;
        int n11 = (int)f11;
        n10 += n11;
        n11 = rect.top;
        float f12 = (float)(rect2.top - n11) * f10;
        int n12 = (int)f12;
        n11 += n12;
        n12 = rect.right;
        float f13 = (float)(rect2.right - n12) * f10;
        int n13 = (int)f13;
        n12 += n13;
        int n14 = rect.bottom;
        int n15 = rect2.bottom - n14;
        float f14 = (float)n15 * f10;
        int n16 = (int)f14;
        n14 += n16;
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            rect3 = new Rect(n10, n11, n12, n14);
            return rect3;
        }
        rect3.set(n10, n11, n12, n14);
        return this.mRect;
    }
}

