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
import androidx.transition.Slide$CalculateSlideVertical;

public final class Slide$6
extends Slide$CalculateSlideVertical {
    public Slide$6() {
        super(null);
    }

    public float getGoneY(ViewGroup viewGroup, View view) {
        float f10 = view.getTranslationY();
        float f11 = viewGroup.getHeight();
        return f10 + f11;
    }
}

