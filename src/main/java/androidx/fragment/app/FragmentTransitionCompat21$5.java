/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.transition.Transition
 *  android.transition.Transition$EpicenterCallback
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import androidx.fragment.app.FragmentTransitionCompat21;

public class FragmentTransitionCompat21$5
extends Transition.EpicenterCallback {
    public final /* synthetic */ FragmentTransitionCompat21 this$0;
    public final /* synthetic */ Rect val$epicenter;

    public FragmentTransitionCompat21$5(FragmentTransitionCompat21 fragmentTransitionCompat21, Rect rect) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$epicenter = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        boolean bl2;
        transition = this.val$epicenter;
        if (transition != null && !(bl2 = transition.isEmpty())) {
            return this.val$epicenter;
        }
        return null;
    }
}

