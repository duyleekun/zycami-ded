/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$KeyedFactory;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory
extends ViewModelProvider$KeyedFactory {
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final Bundle mDefaultArgs;
    private final Lifecycle mLifecycle;
    private final SavedStateRegistry mSavedStateRegistry;

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner object, Bundle bundle) {
        SavedStateRegistry savedStateRegistry;
        this.mSavedStateRegistry = savedStateRegistry = object.getSavedStateRegistry();
        this.mLifecycle = object = object.getLifecycle();
        this.mDefaultArgs = bundle;
    }

    public final ViewModel create(Class serializable) {
        String string2 = serializable.getCanonicalName();
        if (string2 != null) {
            return this.create(string2, (Class)serializable);
        }
        serializable = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        throw serializable;
    }

    public final ViewModel create(String object, Class clazz) {
        Object object2 = this.mSavedStateRegistry;
        Object object3 = this.mLifecycle;
        Bundle bundle = this.mDefaultArgs;
        object2 = SavedStateHandleController.create((SavedStateRegistry)object2, (Lifecycle)object3, (String)object, bundle);
        object3 = ((SavedStateHandleController)object2).getHandle();
        object = this.create((String)object, clazz, (SavedStateHandle)object3);
        ((ViewModel)object).setTagIfAbsent(TAG_SAVED_STATE_HANDLE_CONTROLLER, object2);
        return object;
    }

    public abstract ViewModel create(String var1, Class var2, SavedStateHandle var3);

    public void onRequery(ViewModel viewModel) {
        SavedStateRegistry savedStateRegistry = this.mSavedStateRegistry;
        Lifecycle lifecycle = this.mLifecycle;
        SavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
    }
}

