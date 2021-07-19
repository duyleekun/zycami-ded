/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.WindowIdImpl;

public class Transition$AnimationInfo {
    public String mName;
    public Transition mTransition;
    public TransitionValues mValues;
    public View mView;
    public WindowIdImpl mWindowId;

    public Transition$AnimationInfo(View view, String string2, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
        this.mView = view;
        this.mName = string2;
        this.mValues = transitionValues;
        this.mWindowId = windowIdImpl;
        this.mTransition = transition;
    }
}

