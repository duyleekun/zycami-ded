/*
 * Decompiled with CFR 0.151.
 */
package androidx.transition;

import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;

public class FragmentTransitionSupport$4
implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ FragmentTransitionSupport this$0;
    public final /* synthetic */ Transition val$realTransition;

    public FragmentTransitionSupport$4(FragmentTransitionSupport fragmentTransitionSupport, Transition transition) {
        this.this$0 = fragmentTransitionSupport;
        this.val$realTransition = transition;
    }

    public void onCancel() {
        this.val$realTransition.cancel();
    }
}

