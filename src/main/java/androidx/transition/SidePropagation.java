/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.VisibilityPropagation;

public class SidePropagation
extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /*
     * Unable to fully structure code
     */
    private int distance(View var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9) {
        block14: {
            var10_10 = this.mSide;
            var11_11 = 5;
            var12_12 = 3;
            var13_13 = 0;
            var14_14 = 1;
            var15_15 = 0x800003;
            if (var10_10 == var15_15) {
                var16_16 = ViewCompat.getLayoutDirection(var1_1);
                if (var16_16 != var14_14) {
                    var14_14 = 0;
                }
                if (var14_14 != 0) {
                    while (true) {
                        var10_10 = var11_11;
                        break block14;
                        break;
                    }
                }
lbl15:
                // 3 sources

                while (true) {
                    var10_10 = var12_12;
                    break block14;
                    break;
                }
            }
            var15_15 = 0x800005;
            if (var10_10 == var15_15) {
                var16_16 = ViewCompat.getLayoutDirection(var1_1);
                if (var16_16 != var14_14) {
                    var14_14 = 0;
                }
                if (var14_14 == 0) ** continue;
                ** continue;
            }
        }
        if (var10_10 != var12_12) {
            if (var10_10 != var11_11) {
                var16_16 = 48;
                if (var10_10 != var16_16) {
                    var16_16 = 80;
                    if (var10_10 == var16_16) {
                        var16_16 = Math.abs(var4_4 -= var2_2);
                        var13_13 = (var3_3 -= var7_7) + var16_16;
                    }
                } else {
                    var16_16 = Math.abs(var4_4 -= var2_2);
                    var13_13 = (var9_9 -= var3_3) + var16_16;
                }
            } else {
                var16_16 = Math.abs(var5_5 -= var3_3);
                var13_13 = (var2_2 -= var6_6) + var16_16;
            }
        } else {
            var16_16 = Math.abs(var5_5 -= var3_3);
            var13_13 = (var8_8 -= var2_2) + var16_16;
        }
        return var13_13;
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int n10 = this.mSide;
        int n11 = 3;
        if (n10 != n11 && n10 != (n11 = 5) && n10 != (n11 = 0x800003) && n10 != (n11 = 0x800005)) {
            return viewGroup.getHeight();
        }
        return viewGroup.getWidth();
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int n10;
        int n11;
        int n12;
        int n13;
        SidePropagation sidePropagation = this;
        Object object = transitionValues;
        long l10 = 0L;
        if (transitionValues == null && transitionValues2 == null) {
            return l10;
        }
        Rect rect = transition.getEpicenter();
        int n14 = 1;
        float f10 = Float.MIN_VALUE;
        if (transitionValues2 != null && (n13 = sidePropagation.getViewVisibility((TransitionValues)object)) != 0) {
            object = transitionValues2;
            n12 = n14;
        } else {
            n12 = n13 = -1;
        }
        n13 = sidePropagation.getViewX((TransitionValues)object);
        int n15 = sidePropagation.getViewY((TransitionValues)object);
        int n16 = 2;
        float f11 = 2.8E-45f;
        int[] nArray = new int[n16];
        viewGroup.getLocationOnScreen(nArray);
        int n17 = nArray[0];
        float f12 = viewGroup.getTranslationX();
        int n18 = Math.round(f12);
        n17 += n18;
        n14 = nArray[n14];
        float f13 = viewGroup.getTranslationY();
        int n19 = Math.round(f13);
        n18 = n14 + n19;
        n14 = viewGroup.getWidth();
        int n20 = n17 + n14;
        n14 = viewGroup.getHeight();
        int n21 = n18 + n14;
        if (rect != null) {
            n16 = rect.centerX();
            n11 = rect.centerY();
            n19 = n16;
            n10 = n11;
        } else {
            n11 = (n17 + n20) / n16;
            n14 = (n18 + n21) / n16;
            n19 = n11;
            n10 = n14;
        }
        object = this;
        rect = viewGroup;
        n14 = n13;
        n13 = n15;
        n15 = n19;
        n19 = n10;
        n16 = this.distance((View)viewGroup, n14, n13, n15, n10, n17, n18, n20, n21);
        f11 = n16;
        n11 = this.getMaxDistance(viewGroup);
        float f14 = n11;
        f11 /= f14;
        long l11 = transition.getDuration();
        n13 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        if (n13 < 0) {
            l11 = 300L;
        }
        long l12 = n12;
        f14 = l11 * l12;
        f10 = sidePropagation.mPropagationSpeed;
        return Math.round(f14 / f10 * f11);
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

    public void setSide(int n10) {
        this.mSide = n10;
    }
}

