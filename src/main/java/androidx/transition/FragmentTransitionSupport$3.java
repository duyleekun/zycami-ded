/*
 * Decompiled with CFR 0.151.
 */
package androidx.transition;

import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import java.util.ArrayList;

public class FragmentTransitionSupport$3
extends TransitionListenerAdapter {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ Object val$enterTransition;
    public final /* synthetic */ ArrayList val$enteringViews;
    public final /* synthetic */ Object val$exitTransition;
    public final /* synthetic */ ArrayList val$exitingViews;
    public final /* synthetic */ Object val$sharedElementTransition;
    public final /* synthetic */ ArrayList val$sharedElementsIn;

    public FragmentTransitionSupport$3(FragmentTransitionSupport fragmentTransitionSupport, Object object, ArrayList arrayList, Object object2, ArrayList arrayList2, Object object3, ArrayList arrayList3) {
        this.this$0 = fragmentTransitionSupport;
        this.val$enterTransition = object;
        this.val$enteringViews = arrayList;
        this.val$exitTransition = object2;
        this.val$exitingViews = arrayList2;
        this.val$sharedElementTransition = object3;
        this.val$sharedElementsIn = arrayList3;
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    public void onTransitionStart(Transition object) {
        ArrayList arrayList;
        FragmentTransitionSupport fragmentTransitionSupport;
        object = this.val$enterTransition;
        if (object != null) {
            fragmentTransitionSupport = this.this$0;
            arrayList = this.val$enteringViews;
            fragmentTransitionSupport.replaceTargets(object, arrayList, null);
        }
        if ((object = this.val$exitTransition) != null) {
            fragmentTransitionSupport = this.this$0;
            arrayList = this.val$exitingViews;
            fragmentTransitionSupport.replaceTargets(object, arrayList, null);
        }
        if ((object = this.val$sharedElementTransition) != null) {
            fragmentTransitionSupport = this.this$0;
            arrayList = this.val$sharedElementsIn;
            fragmentTransitionSupport.replaceTargets(object, arrayList, null);
        }
    }
}

