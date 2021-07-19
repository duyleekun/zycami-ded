/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable
 */
package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Animatable;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition;

public class AnimatedStateListDrawableCompat$AnimatableTransition
extends AnimatedStateListDrawableCompat$Transition {
    private final Animatable mA;

    public AnimatedStateListDrawableCompat$AnimatableTransition(Animatable animatable) {
        super(null);
        this.mA = animatable;
    }

    public void start() {
        this.mA.start();
    }

    public void stop() {
        this.mA.stop();
    }
}

