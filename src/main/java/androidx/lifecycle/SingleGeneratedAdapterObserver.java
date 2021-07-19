/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class SingleGeneratedAdapterObserver
implements LifecycleEventObserver {
    private final GeneratedAdapter mGeneratedAdapter;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.mGeneratedAdapter = generatedAdapter;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        this.mGeneratedAdapter.callMethods(lifecycleOwner, lifecycle$Event, false, null);
        this.mGeneratedAdapter.callMethods(lifecycleOwner, lifecycle$Event, true, null);
    }
}

