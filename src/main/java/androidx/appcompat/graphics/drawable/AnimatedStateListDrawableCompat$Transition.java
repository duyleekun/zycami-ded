/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.graphics.drawable;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1;

public abstract class AnimatedStateListDrawableCompat$Transition {
    private AnimatedStateListDrawableCompat$Transition() {
    }

    public /* synthetic */ AnimatedStateListDrawableCompat$Transition(AnimatedStateListDrawableCompat$1 animatedStateListDrawableCompat$1) {
        this();
    }

    public boolean canReverse() {
        return false;
    }

    public void reverse() {
    }

    public abstract void start();

    public abstract void stop();
}

