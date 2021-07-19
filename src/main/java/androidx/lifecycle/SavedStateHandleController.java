/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleController$1;
import androidx.lifecycle.SavedStateHandleController$OnRecreation;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;

public final class SavedStateHandleController
implements LifecycleEventObserver {
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final SavedStateHandle mHandle;
    private boolean mIsAttached = false;
    private final String mKey;

    public SavedStateHandleController(String string2, SavedStateHandle savedStateHandle) {
        this.mKey = string2;
        this.mHandle = savedStateHandle;
    }

    public static void attachHandleIfNeeded(ViewModel object, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        boolean bl2;
        String string2 = TAG_SAVED_STATE_HANDLE_CONTROLLER;
        if ((object = (SavedStateHandleController)((ViewModel)object).getTag(string2)) != null && !(bl2 = ((SavedStateHandleController)object).isAttached())) {
            ((SavedStateHandleController)object).attachToLifecycle(savedStateRegistry, lifecycle);
            SavedStateHandleController.tryToAddRecreator(savedStateRegistry, lifecycle);
        }
    }

    public static SavedStateHandleController create(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String string2, Bundle object) {
        object = SavedStateHandle.createHandle(savedStateRegistry.consumeRestoredStateForKey(string2), object);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(string2, (SavedStateHandle)object);
        savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
        SavedStateHandleController.tryToAddRecreator(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    private static void tryToAddRecreator(SavedStateRegistry savedStateRegistry, Lifecycle object) {
        boolean bl2;
        Lifecycle$State lifecycle$State;
        Object object2 = ((Lifecycle)object).getCurrentState();
        if (object2 != (lifecycle$State = Lifecycle$State.INITIALIZED) && !(bl2 = object2.isAtLeast(lifecycle$State = Lifecycle$State.STARTED))) {
            object2 = new SavedStateHandleController$1((Lifecycle)object, savedStateRegistry);
            ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        } else {
            object = SavedStateHandleController$OnRecreation.class;
            savedStateRegistry.runOnNextRecreation((Class)object);
        }
    }

    public void attachToLifecycle(SavedStateRegistry object, Lifecycle object2) {
        boolean bl2 = this.mIsAttached;
        if (!bl2) {
            this.mIsAttached = true;
            ((Lifecycle)object2).addObserver(this);
            object2 = this.mKey;
            SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider = this.mHandle.savedStateProvider();
            ((SavedStateRegistry)object).registerSavedStateProvider((String)object2, savedStateRegistry$SavedStateProvider);
            return;
        }
        object = new IllegalStateException("Already attached to lifecycleOwner");
        throw object;
    }

    public SavedStateHandle getHandle() {
        return this.mHandle;
    }

    public boolean isAttached() {
        return this.mIsAttached;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        Lifecycle$Event lifecycle$Event2 = Lifecycle$Event.ON_DESTROY;
        if (lifecycle$Event == lifecycle$Event2) {
            lifecycle$Event = null;
            this.mIsAttached = false;
            object = object.getLifecycle();
            ((Lifecycle)object).removeObserver(this);
        }
    }
}

