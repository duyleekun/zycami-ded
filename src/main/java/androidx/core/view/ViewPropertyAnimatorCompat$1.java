/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

public class ViewPropertyAnimatorCompat$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewPropertyAnimatorCompat this$0;
    public final /* synthetic */ ViewPropertyAnimatorListener val$listener;
    public final /* synthetic */ View val$view;

    public ViewPropertyAnimatorCompat$1(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
        this.this$0 = viewPropertyAnimatorCompat;
        this.val$listener = viewPropertyAnimatorListener;
        this.val$view = view;
    }

    public void onAnimationCancel(Animator object) {
        object = this.val$listener;
        View view = this.val$view;
        object.onAnimationCancel(view);
    }

    public void onAnimationEnd(Animator object) {
        object = this.val$listener;
        View view = this.val$view;
        object.onAnimationEnd(view);
    }

    public void onAnimationStart(Animator object) {
        object = this.val$listener;
        View view = this.val$view;
        object.onAnimationStart(view);
    }
}

