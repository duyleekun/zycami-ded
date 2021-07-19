/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.GhostView;
import androidx.transition.GhostViewUtils;
import androidx.transition.R$id;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;

public class ChangeTransform$GhostListener
extends TransitionListenerAdapter {
    private GhostView mGhostView;
    private View mView;

    public ChangeTransform$GhostListener(View view, GhostView ghostView) {
        this.mView = view;
        this.mGhostView = ghostView;
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        GhostViewUtils.removeGhost(this.mView);
        transition = this.mView;
        int n10 = R$id.transition_transform;
        transition.setTag(n10, null);
        transition = this.mView;
        n10 = R$id.parent_matrix;
        transition.setTag(n10, null);
    }

    public void onTransitionPause(Transition transition) {
        this.mGhostView.setVisibility(4);
    }

    public void onTransitionResume(Transition transition) {
        this.mGhostView.setVisibility(0);
    }
}

