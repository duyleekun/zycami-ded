/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.Slide$CalculateSlideHorizontal;

public final class Slide$5
extends Slide$CalculateSlideHorizontal {
    public Slide$5() {
        super(null);
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        float f10;
        int n10;
        int n11 = ViewCompat.getLayoutDirection((View)viewGroup);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        if (n10 != 0) {
            f10 = view.getTranslationX();
            int n12 = viewGroup.getWidth();
            float f11 = n12;
            f10 -= f11;
        } else {
            f10 = view.getTranslationX();
            int n13 = viewGroup.getWidth();
            float f12 = n13;
            f10 += f12;
        }
        return f10;
    }
}

