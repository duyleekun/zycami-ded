/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$4$1;
import androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo;

public class DefaultSpecialEffectsController$4
implements Animation.AnimationListener {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ DefaultSpecialEffectsController$AnimationInfo val$animationInfo;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ View val$viewToAnimate;

    public DefaultSpecialEffectsController$4(DefaultSpecialEffectsController defaultSpecialEffectsController, ViewGroup viewGroup, View view, DefaultSpecialEffectsController$AnimationInfo defaultSpecialEffectsController$AnimationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$animationInfo = defaultSpecialEffectsController$AnimationInfo;
    }

    public void onAnimationEnd(Animation animation) {
        animation = this.val$container;
        DefaultSpecialEffectsController$4$1 defaultSpecialEffectsController$4$1 = new DefaultSpecialEffectsController$4$1(this);
        animation.post((Runnable)defaultSpecialEffectsController$4$1);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

