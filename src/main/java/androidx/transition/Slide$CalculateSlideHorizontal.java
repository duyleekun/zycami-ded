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
import androidx.transition.Slide$1;
import androidx.transition.Slide$CalculateSlide;

public abstract class Slide$CalculateSlideHorizontal
implements Slide$CalculateSlide {
    private Slide$CalculateSlideHorizontal() {
    }

    public /* synthetic */ Slide$CalculateSlideHorizontal(Slide.1 var1_1) {
        this();
    }

    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY();
    }
}

