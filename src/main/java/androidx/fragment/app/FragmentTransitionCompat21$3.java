/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.transition.Transition
 *  android.transition.Transition$TransitionListener
 */
package androidx.fragment.app;

import android.transition.Transition;
import androidx.fragment.app.FragmentTransitionCompat21;
import java.util.ArrayList;

public class FragmentTransitionCompat21$3
implements Transition.TransitionListener {
    public final /* synthetic */ FragmentTransitionCompat21 this$0;
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ ArrayList val$enteringViews;
    public final /* synthetic */ Object val$exitTransition;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ Object val$sharedElementTransition;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransitionCompat21$3(FragmentTransitionCompat21 fragmentTransitionCompat21, Object object, ArrayList arrayList, Object object2, ArrayList arrayList2, Object object3, ArrayList arrayList3) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$enterTransition = object;
        this.val$enteringViews = arrayList;
        this.val$exitTransition = object2;
        this.val$exitingViews = arrayList2;
        this.val$sharedElementTransition = object3;
        this.val$sharedElementsIn = arrayList3;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener((Transition.TransitionListener)this);
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition object) {
        ArrayList arrayList;
        FragmentTransitionCompat21 fragmentTransitionCompat21;
        object = this.val$enterTransition;
        if (object != null) {
            fragmentTransitionCompat21 = this.this$0;
            arrayList = this.val$enteringViews;
            fragmentTransitionCompat21.replaceTargets(object, arrayList, null);
        }
        if ((object = this.val$exitTransition) != null) {
            fragmentTransitionCompat21 = this.this$0;
            arrayList = this.val$exitingViews;
            fragmentTransitionCompat21.replaceTargets(object, arrayList, null);
        }
        if ((object = this.val$sharedElementTransition) != null) {
            fragmentTransitionCompat21 = this.this$0;
            arrayList = this.val$sharedElementsIn;
            fragmentTransitionCompat21.replaceTargets(object, arrayList, null);
        }
    }
}

