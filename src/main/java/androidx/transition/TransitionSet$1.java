/*
 * Decompiled with CFR 0.151.
 */
package androidx.transition;

import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionSet;

public class TransitionSet$1
extends TransitionListenerAdapter {
    public final /* synthetic */ TransitionSet this$0;
    public final /* synthetic */ Transition val$nextTransition;

    public TransitionSet$1(TransitionSet transitionSet, Transition transition) {
        this.this$0 = transitionSet;
        this.val$nextTransition = transition;
    }

    public void onTransitionEnd(Transition transition) {
        this.val$nextTransition.runAnimators();
        transition.removeListener(this);
    }
}

