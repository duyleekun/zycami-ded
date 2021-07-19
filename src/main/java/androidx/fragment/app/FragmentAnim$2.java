/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim$2$1;
import androidx.fragment.app.FragmentTransition$Callback;

public class FragmentAnim$2
implements Animation.AnimationListener {
    public final /* synthetic */ FragmentTransition$Callback val$callback;
    public final /* synthetic */ ViewGroup val$container;
    public final /* synthetic */ Fragment val$fragment;
    public final /* synthetic */ CancellationSignal val$signal;

    public FragmentAnim$2(ViewGroup viewGroup, Fragment fragment, FragmentTransition$Callback fragmentTransition$Callback, CancellationSignal cancellationSignal) {
        this.val$container = viewGroup;
        this.val$fragment = fragment;
        this.val$callback = fragmentTransition$Callback;
        this.val$signal = cancellationSignal;
    }

    public void onAnimationEnd(Animation animation) {
        animation = this.val$container;
        FragmentAnim$2$1 fragmentAnim$2$1 = new FragmentAnim$2$1(this);
        animation.post((Runnable)fragmentAnim$2$1);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

