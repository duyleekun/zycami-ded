/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;

public class FragmentManager$LifecycleAwareResultListener
implements FragmentResultListener {
    private final Lifecycle mLifecycle;
    private final FragmentResultListener mListener;
    private final LifecycleEventObserver mObserver;

    public FragmentManager$LifecycleAwareResultListener(Lifecycle lifecycle, FragmentResultListener fragmentResultListener, LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle = lifecycle;
        this.mListener = fragmentResultListener;
        this.mObserver = lifecycleEventObserver;
    }

    public boolean isAtLeast(Lifecycle$State lifecycle$State) {
        return this.mLifecycle.getCurrentState().isAtLeast(lifecycle$State);
    }

    public void onFragmentResult(String string2, Bundle bundle) {
        this.mListener.onFragmentResult(string2, bundle);
    }

    public void removeObserver() {
        Lifecycle lifecycle = this.mLifecycle;
        LifecycleEventObserver lifecycleEventObserver = this.mObserver;
        lifecycle.removeObserver(lifecycleEventObserver);
    }
}

