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
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;

public class Animatable2Compat$AnimationCallback$1
extends Animatable2.AnimationCallback {
    public final /* synthetic */ Animatable2Compat$AnimationCallback this$0;

    public Animatable2Compat$AnimationCallback$1(Animatable2Compat$AnimationCallback animationCallback) {
        this.this$0 = animationCallback;
    }

    public void onAnimationEnd(Drawable drawable2) {
        this.this$0.onAnimationEnd(drawable2);
    }

    public void onAnimationStart(Drawable drawable2) {
        this.this$0.onAnimationStart(drawable2);
    }
}

