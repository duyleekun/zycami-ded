/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;

public interface Animatable2Compat
extends Animatable {
    public void clearAnimationCallbacks();

    public void registerAnimationCallback(Animatable2Compat$AnimationCallback var1);

    public boolean unregisterAnimationCallback(Animatable2Compat$AnimationCallback var1);
}

