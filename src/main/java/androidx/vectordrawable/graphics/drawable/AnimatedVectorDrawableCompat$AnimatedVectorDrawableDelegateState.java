/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

public class AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState
extends Drawable.ConstantState {
    private final Drawable.ConstantState mDelegateState;

    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
        this.mDelegateState = constantState;
    }

    public boolean canApplyTheme() {
        return this.mDelegateState.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.mDelegateState.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        Drawable drawable2;
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        animatedVectorDrawableCompat.mDelegateDrawable = drawable2 = this.mDelegateState.newDrawable();
        Drawable.Callback callback = animatedVectorDrawableCompat.mCallback;
        drawable2.setCallback(callback);
        return animatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        resources = this.mDelegateState.newDrawable(resources);
        animatedVectorDrawableCompat.mDelegateDrawable = resources;
        Drawable.Callback callback = animatedVectorDrawableCompat.mCallback;
        resources.setCallback(callback);
        return animatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        resources = this.mDelegateState.newDrawable(resources, theme);
        animatedVectorDrawableCompat.mDelegateDrawable = resources;
        theme = animatedVectorDrawableCompat.mCallback;
        resources.setCallback((Drawable.Callback)theme);
        return animatedVectorDrawableCompat;
    }
}

