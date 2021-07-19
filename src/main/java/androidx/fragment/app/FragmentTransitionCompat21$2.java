/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.transition.Transition
 *  android.transition.Transition$TransitionListener
 *  android.view.View
 */
package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import androidx.fragment.app.FragmentTransitionCompat21;
import java.util.ArrayList;

public class FragmentTransitionCompat21$2
implements Transition.TransitionListener {
    public final /* synthetic */ FragmentTransitionCompat21 this$0;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ View val$fragmentView;

    public FragmentTransitionCompat21$2(FragmentTransitionCompat21 fragmentTransitionCompat21, View view, ArrayList arrayList) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$fragmentView = view;
        this.val$exitingViews = arrayList;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition object) {
        object.removeListener((Transition.TransitionListener)this);
        this.val$fragmentView.setVisibility(8);
        object = this.val$exitingViews;
        int n10 = ((ArrayList)object).size();
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
        transition.removeListener((Transition.TransitionListener)this);
        transition.addListener((Transition.TransitionListener)this);
    }
}

