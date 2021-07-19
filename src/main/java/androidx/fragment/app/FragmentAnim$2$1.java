/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim$2;
import androidx.fragment.app.FragmentTransition$Callback;

public class FragmentAnim$2$1
implements Runnable {
    public final /* synthetic */ FragmentAnim$2 this$0;

    public FragmentAnim$2$1(FragmentAnim$2 var1_1) {
        this.this$0 = var1_1;
    }

    public void run() {
        Object object = this.this$0.val$fragment.getAnimatingAway();
        if (object != null) {
            this.this$0.val$fragment.setAnimatingAway(null);
            object = this.this$0;
            FragmentTransition$Callback fragmentTransition$Callback = object.val$callback;
            Fragment fragment = object.val$fragment;
            object = object.val$signal;
            fragmentTransition$Callback.onComplete(fragment, (CancellationSignal)object);
        }
    }
}

