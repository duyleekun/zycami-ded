/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.graphics.drawable;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

public class AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition
extends AnimatedStateListDrawableCompat$Transition {
    private final AnimatedVectorDrawableCompat mAvd;

    public AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        super(null);
        this.mAvd = animatedVectorDrawableCompat;
    }

    public void start() {
        this.mAvd.start();
    }

    public void stop() {
        this.mAvd.stop();
    }
}

