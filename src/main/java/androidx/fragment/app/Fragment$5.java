/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class Fragment$5
implements LifecycleEventObserver {
    public final /* synthetic */ Fragment this$0;

    public Fragment$5(Fragment fragment) {
        this.this$0 = fragment;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        object = Lifecycle$Event.ON_STOP;
        if (lifecycle$Event == object && (object = this.this$0.mView) != null) {
            object.cancelPendingInputEvents();
        }
    }
}

