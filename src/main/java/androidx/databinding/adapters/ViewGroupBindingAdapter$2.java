/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.databinding.adapters;

import android.view.animation.Animation;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationEnd;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationRepeat;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationStart;

public final class ViewGroupBindingAdapter$2
implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroupBindingAdapter$OnAnimationEnd val$end;
    public final /* synthetic */ ViewGroupBindingAdapter$OnAnimationRepeat val$repeat;
    public final /* synthetic */ ViewGroupBindingAdapter$OnAnimationStart val$start;

    public ViewGroupBindingAdapter$2(ViewGroupBindingAdapter$OnAnimationStart onAnimationStart, ViewGroupBindingAdapter$OnAnimationEnd onAnimationEnd, ViewGroupBindingAdapter$OnAnimationRepeat onAnimationRepeat) {
        this.val$start = onAnimationStart;
        this.val$end = onAnimationEnd;
        this.val$repeat = onAnimationRepeat;
    }

    public void onAnimationEnd(Animation animation) {
        ViewGroupBindingAdapter$OnAnimationEnd viewGroupBindingAdapter$OnAnimationEnd = this.val$end;
        if (viewGroupBindingAdapter$OnAnimationEnd != null) {
            viewGroupBindingAdapter$OnAnimationEnd.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        ViewGroupBindingAdapter$OnAnimationRepeat viewGroupBindingAdapter$OnAnimationRepeat = this.val$repeat;
        if (viewGroupBindingAdapter$OnAnimationRepeat != null) {
            viewGroupBindingAdapter$OnAnimationRepeat.onAnimationRepeat(animation);
        }
    }

    public void onAnimationStart(Animation animation) {
        ViewGroupBindingAdapter$OnAnimationStart viewGroupBindingAdapter$OnAnimationStart = this.val$start;
        if (viewGroupBindingAdapter$OnAnimationStart != null) {
            viewGroupBindingAdapter$OnAnimationStart.onAnimationStart(animation);
        }
    }
}

