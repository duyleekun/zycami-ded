/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager$MultiListener;
import java.util.ArrayList;

public class TransitionManager$MultiListener$1
extends TransitionListenerAdapter {
    public final /* synthetic */ TransitionManager$MultiListener this$0;
    public final /* synthetic */ ArrayMap val$runningTransitions;

    public TransitionManager$MultiListener$1(TransitionManager$MultiListener transitionManager$MultiListener, ArrayMap arrayMap) {
        this.this$0 = transitionManager$MultiListener;
        this.val$runningTransitions = arrayMap;
    }

    public void onTransitionEnd(Transition transition) {
        ArrayMap arrayMap = this.val$runningTransitions;
        ViewGroup viewGroup = this.this$0.mSceneRoot;
        ((ArrayList)arrayMap.get(viewGroup)).remove(transition);
        transition.removeListener(this);
    }
}

