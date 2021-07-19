/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;

public class ActionBarOverlayLayout$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ ActionBarOverlayLayout this$0;

    public ActionBarOverlayLayout$1(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.this$0 = actionBarOverlayLayout;
    }

    public void onAnimationCancel(Animator object) {
        object = this.this$0;
        object.mCurrentActionBarTopAnimator = null;
        object.mAnimatingForFling = false;
    }

    public void onAnimationEnd(Animator object) {
        object = this.this$0;
        object.mCurrentActionBarTopAnimator = null;
        object.mAnimatingForFling = false;
    }
}

