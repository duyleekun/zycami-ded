/*
 * Decompiled with CFR 0.151.
 */
package androidx.transition;

import androidx.transition.Transition;

public interface Transition$TransitionListener {
    public void onTransitionCancel(Transition var1);

    public void onTransitionEnd(Transition var1);

    public void onTransitionPause(Transition var1);

    public void onTransitionResume(Transition var1);

    public void onTransitionStart(Transition var1);
}

