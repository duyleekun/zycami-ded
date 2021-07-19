/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveData$ObserverWrapper;
import androidx.lifecycle.Observer;

public class LiveData$LifecycleBoundObserver
extends LiveData$ObserverWrapper
implements LifecycleEventObserver {
    public final LifecycleOwner mOwner;
    public final /* synthetic */ LiveData this$0;

    public LiveData$LifecycleBoundObserver(LiveData liveData, LifecycleOwner lifecycleOwner, Observer observer) {
        this.this$0 = liveData;
        super(liveData, observer);
        this.mOwner = lifecycleOwner;
    }

    public void detachObserver() {
        this.mOwner.getLifecycle().removeObserver(this);
    }

    public boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
        boolean bl2;
        LifecycleOwner lifecycleOwner2 = this.mOwner;
        if (lifecycleOwner2 == lifecycleOwner) {
            bl2 = true;
        } else {
            bl2 = false;
            lifecycleOwner = null;
        }
        return bl2;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event object2) {
        object = this.mOwner.getLifecycle().getCurrentState();
        if (object == (object2 = Lifecycle$State.DESTROYED)) {
            object = this.this$0;
            object2 = this.mObserver;
            ((LiveData)object).removeObserver((Observer)object2);
            return;
        }
        boolean bl2 = false;
        object2 = null;
        while (object2 != object) {
            bl2 = this.shouldBeActive();
            this.activeStateChanged(bl2);
            Lifecycle$State lifecycle$State = this.mOwner.getLifecycle().getCurrentState();
            object2 = object;
            object = lifecycle$State;
        }
    }

    public boolean shouldBeActive() {
        Lifecycle$State lifecycle$State = this.mOwner.getLifecycle().getCurrentState();
        Lifecycle$State lifecycle$State2 = Lifecycle$State.STARTED;
        return lifecycle$State.isAtLeast(lifecycle$State2);
    }
}

