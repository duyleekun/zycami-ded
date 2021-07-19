/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandleController$OnRecreation;
import androidx.savedstate.SavedStateRegistry;

public class SavedStateHandleController$1
implements LifecycleEventObserver {
    public final /* synthetic */ Lifecycle val$lifecycle;
    public final /* synthetic */ SavedStateRegistry val$registry;

    public SavedStateHandleController$1(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        this.val$lifecycle = lifecycle;
        this.val$registry = savedStateRegistry;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event object2) {
        object = Lifecycle$Event.ON_START;
        if (object2 == object) {
            this.val$lifecycle.removeObserver(this);
            object = this.val$registry;
            object2 = SavedStateHandleController$OnRecreation.class;
            ((SavedStateRegistry)object).runOnNextRecreation((Class)object2);
        }
    }
}

