/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public final class SavedStateRegistryController {
    private final SavedStateRegistryOwner mOwner;
    private final SavedStateRegistry mRegistry;

    private SavedStateRegistryController(SavedStateRegistryOwner object) {
        this.mOwner = object;
        this.mRegistry = object = new SavedStateRegistry();
    }

    public static SavedStateRegistryController create(SavedStateRegistryOwner savedStateRegistryOwner) {
        SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(savedStateRegistryOwner);
        return savedStateRegistryController;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.mRegistry;
    }

    public void performRestore(Bundle object) {
        Object object2;
        Lifecycle lifecycle = this.mOwner.getLifecycle();
        Object object3 = lifecycle.getCurrentState();
        if (object3 == (object2 = Lifecycle$State.INITIALIZED)) {
            object2 = this.mOwner;
            object3 = new Recreator((SavedStateRegistryOwner)object2);
            lifecycle.addObserver((LifecycleObserver)object3);
            this.mRegistry.performRestore(lifecycle, (Bundle)object);
            return;
        }
        object = new IllegalStateException("Restarter must be created only during owner's initialization stage");
        throw object;
    }

    public void performSave(Bundle bundle) {
        this.mRegistry.performSave(bundle);
    }
}

