/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Lifecycling;

public class LifecycleRegistry$ObserverWithState {
    public LifecycleEventObserver mLifecycleObserver;
    public Lifecycle$State mState;

    public LifecycleRegistry$ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle$State lifecycle$State) {
        lifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
        this.mLifecycleObserver = lifecycleObserver;
        this.mState = lifecycle$State;
    }

    public void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        Lifecycle$State lifecycle$State;
        Lifecycle$State lifecycle$State2 = lifecycle$Event.getTargetState();
        this.mState = lifecycle$State = LifecycleRegistry.min(this.mState, lifecycle$State2);
        this.mLifecycleObserver.onStateChanged(lifecycleOwner, lifecycle$Event);
        this.mState = lifecycle$State2;
    }
}

