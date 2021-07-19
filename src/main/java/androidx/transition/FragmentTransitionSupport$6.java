/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.transition;

import android.graphics.Rect;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import androidx.transition.Transition$EpicenterCallback;

public class FragmentTransitionSupport$6
extends Transition$EpicenterCallback {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ Rect val$epicenter;

    public FragmentTransitionSupport$6(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        this.this$0 = fragmentTransitionSupport;
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

