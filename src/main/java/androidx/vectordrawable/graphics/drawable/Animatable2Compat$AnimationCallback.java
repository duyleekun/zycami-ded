/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable2$AnimationCallback
 *  android.graphics.drawable.Drawable
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback$1;

public abstract class Animatable2Compat$AnimationCallback {
    public Animatable2.AnimationCallback mPlatformCallback;

    public Animatable2.AnimationCallback getPlatformCallback() {
        Animatable2.AnimationCallback animationCallback = this.mPlatformCallback;
        if (animationCallback == null) {
            this.mPlatformCallback = animationCallback = new Animatable2Compat$AnimationCallback$1(this);
        }
        return this.mPlatformCallback;
    }

    public void onAnimationEnd(Drawable drawable2) {
    }

    public void onAnimationStart(Drawable drawable2) {
    }
}

