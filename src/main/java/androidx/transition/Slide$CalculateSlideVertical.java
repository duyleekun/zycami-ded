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

public abstract class Slide$CalculateSlideVertical
implements Slide$CalculateSlide {
    private Slide$CalculateSlideVertical() {
    }

    public /* synthetic */ Slide$CalculateSlideVertical(Slide$1 slide$1) {
        this();
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        return view.getTranslationX();
    }
}

