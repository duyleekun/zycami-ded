/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.view.ViewGroup;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.ViewGroupUtils;

public class ChangeBounds$9
extends TransitionListenerAdapter {
    public boolean mCanceled = false;
    public final /* synthetic */ ChangeBounds this$0;
    public final /* synthetic */ ViewGroup val$parent;

    public ChangeBounds$9(ChangeBounds changeBounds, ViewGroup viewGroup) {
        this.this$0 = changeBounds;
        this.val$parent = viewGroup;
    }

    public void onTransitionCancel(Transition transition) {
        ViewGroupUtils.suppressLayout(this.val$parent, false);
        this.mCanceled = true;
    }

    public void onTransitionEnd(Transition transition) {
        boolean bl2 = this.mCanceled;
        if (!bl2) {
            ViewGroup viewGroup = this.val$parent;
            ViewGroupUtils.suppressLayout(viewGroup, false);
        }
        transition.removeListener(this);
    }

    public void onTransitionPause(Transition transition) {
        ViewGroupUtils.suppressLayout(this.val$parent, false);
    }

    public void onTransitionResume(Transition transition) {
        ViewGroupUtils.suppressLayout(this.val$parent, true);
    }
}

