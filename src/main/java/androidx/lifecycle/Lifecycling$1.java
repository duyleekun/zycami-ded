/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class Lifecycling$1
implements GenericLifecycleObserver {
    public final /* synthetic */ LifecycleEventObserver val$observer;

    public Lifecycling$1(LifecycleEventObserver lifecycleEventObserver) {
        this.val$observer = lifecycleEventObserver;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        this.val$observer.onStateChanged(lifecycleOwner, lifecycle$Event);
    }
}

