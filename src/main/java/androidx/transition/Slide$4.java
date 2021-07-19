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
import androidx.transition.Slide$CalculateSlideHorizontal;

public final class Slide$4
extends Slide$CalculateSlideHorizontal {
    public Slide$4() {
        super(null);
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        float f10 = view.getTranslationX();
        float f11 = viewGroup.getWidth();
        return f10 + f11;
    }
}

