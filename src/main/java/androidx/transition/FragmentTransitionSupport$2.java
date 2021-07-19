/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;
import java.util.ArrayList;

public class FragmentTransitionSupport$2
implements Transition$TransitionListener {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ View val$fragmentView;

    public FragmentTransitionSupport$2(FragmentTransitionSupport fragmentTransitionSupport, View view, ArrayList arrayList) {
        this.this$0 = fragmentTransitionSupport;
        this.val$fragmentView = view;
        this.val$exitingViews = arrayList;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition cloneable) {
        ((Transition)cloneable).removeListener(this);
        this.val$fragmentView.setVisibility(8);
        cloneable = this.val$exitingViews;
        int n10 = ((ArrayList)cloneable).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = (View)this.val$exitingViews.get(i10);
            view.setVisibility(0);
        }
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
        transition.removeListener(this);
        transition.addListener(this);
    }
}

