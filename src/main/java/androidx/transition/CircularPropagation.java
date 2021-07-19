/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.VisibilityPropagation;

public class CircularPropagation
extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f10, float f11, float f12, float f13) {
        f12 -= f10;
        f13 -= f11;
        f12 *= f12;
        f13 *= f13;
        return (float)Math.sqrt(f12 + f13);
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f10;
        int n10;
        int n11;
        int n12;
        long l10 = 0L;
        if (transitionValues == null && transitionValues2 == null) {
            return l10;
        }
        int n13 = 1;
        float f11 = Float.MIN_VALUE;
        if (transitionValues2 != null && (n12 = this.getViewVisibility(transitionValues)) != 0) {
            transitionValues = transitionValues2;
            n11 = n13;
        } else {
            n11 = -1;
        }
        n12 = this.getViewX(transitionValues);
        int n14 = this.getViewY(transitionValues);
        Rect rect = transition.getEpicenter();
        if (rect != null) {
            n13 = rect.centerX();
            n10 = rect.centerY();
        } else {
            n10 = 2;
            int[] nArray = new int[n10];
            viewGroup.getLocationOnScreen(nArray);
            int n15 = nArray[0];
            int n16 = viewGroup.getWidth() / n10;
            float f12 = n15 + n16;
            float f13 = viewGroup.getTranslationX();
            n15 = Math.round(f12 += f13);
            n13 = nArray[n13];
            int n17 = viewGroup.getHeight() / n10;
            f11 = n13 + n17;
            f10 = viewGroup.getTranslationY();
            n10 = Math.round(f11 += f10);
            n13 = n15;
        }
        float f14 = n12;
        float f15 = n14;
        f11 = n13;
        f10 = n10;
        f15 = CircularPropagation.distance(f14, f15, f11, f10);
        n13 = viewGroup.getWidth();
        f11 = n13;
        int n18 = viewGroup.getHeight();
        float f16 = n18;
        n12 = 0;
        f14 = 0.0f;
        f16 = CircularPropagation.distance(0.0f, 0.0f, f11, f16);
        f15 /= f16;
        long l11 = transition.getDuration();
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (l12 < 0) {
            l11 = 300L;
        }
        l10 = n11;
        f16 = l11 * l10;
        float f17 = this.mPropagationSpeed;
        return Math.round(f16 / f17 * f15);
    }

    public void setPropagationSpeed(float f10) {
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mPropagationSpeed = f10;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("propagationSpeed may not be 0");
        throw illegalArgumentException;
    }
}

