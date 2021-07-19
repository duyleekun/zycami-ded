/*
 * Decompiled with CFR 0.151.
 */
package androidx.transition;

import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionSet;

public class TransitionSet$TransitionSetListener
extends TransitionListenerAdapter {
    public TransitionSet mTransitionSet;

    public TransitionSet$TransitionSetListener(TransitionSet transitionSet) {
        this.mTransitionSet = transitionSet;
    }

    public void onTransitionEnd(Transition transition) {
        int n10;
        TransitionSet transitionSet = this.mTransitionSet;
        transitionSet.mCurrentListeners = n10 = transitionSet.mCurrentListeners + -1;
        if (n10 == 0) {
            n10 = 0;
            transitionSet.mStarted = false;
            transitionSet.end();
        }
        transition.removeListener(this);
    }

    public void onTransitionStart(Transition transition) {
        transition = this.mTransitionSet;
        boolean bl2 = ((TransitionSet)transition).mStarted;
        if (!bl2) {
            transition.start();
            transition = this.mTransitionSet;
            ((TransitionSet)transition).mStarted = bl2 = true;
        }
    }
}

