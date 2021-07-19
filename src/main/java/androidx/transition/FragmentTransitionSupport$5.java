/*
 * Decompiled with CFR 0.151.
 */
package androidx.transition;

import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;

public class FragmentTransitionSupport$5
implements Transition$TransitionListener {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ Runnable val$transitionCompleteRunnable;

    public FragmentTransitionSupport$5(FragmentTransitionSupport fragmentTransitionSupport, Runnable runnable) {
        this.this$0 = fragmentTransitionSupport;
        this.val$transitionCompleteRunnable = runnable;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        this.val$transitionCompleteRunnable.run();
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}

