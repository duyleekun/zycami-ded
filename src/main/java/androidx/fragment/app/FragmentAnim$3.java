/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition$Callback;

public class FragmentAnim$3
extends AnimatorListenerAdapter {
    public final /* synthetic */ FragmentTransition$Callback val$callback;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;
    public final /* synthetic */ CancellationSignal val$signal;
    public final /* synthetic */ View val$viewToAnimate;

    public FragmentAnim$3(ViewGroup viewGroup, View view, Fragment fragment, FragmentTransition$Callback fragmentTransition$Callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$fragment = fragment;
        this.val$callback = fragmentTransition$Callback;
        this.val$signal = cancellationSignal;
    }

    public void onAnimationEnd(Animator object) {
        int n10;
        object = this.val$container;
        Object object2 = this.val$viewToAnimate;
        object.endViewTransition((View)object2);
        object = this.val$fragment.getAnimator();
        object2 = this.val$fragment;
        CancellationSignal cancellationSignal = null;
        ((Fragment)object2).setAnimator(null);
        if (object != null && (n10 = (object = this.val$container).indexOfChild((View)(object2 = this.val$viewToAnimate))) < 0) {
            object = this.val$callback;
            object2 = this.val$fragment;
            cancellationSignal = this.val$signal;
            object.onComplete((Fragment)object2, cancellationSignal);
        }
    }
}

