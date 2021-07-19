/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition$Callback;

public class FragmentTransition$1
implements Runnable {
    public final /* synthetic */ FragmentTransition$Callback val$callback;
    public final /* synthetic */ Fragment val$outFragment;
    public final /* synthetic */ CancellationSignal val$signal;

    public FragmentTransition$1(FragmentTransition$Callback fragmentTransition$Callback, Fragment fragment, CancellationSignal cancellationSignal) {
        this.val$callback = fragmentTransition$Callback;
        this.val$outFragment = fragment;
        this.val$signal = cancellationSignal;
    }

    public void run() {
        FragmentTransition$Callback fragmentTransition$Callback = this.val$callback;
        Fragment fragment = this.val$outFragment;
        CancellationSignal cancellationSignal = this.val$signal;
        fragmentTransition$Callback.onComplete(fragment, cancellationSignal);
    }
}

