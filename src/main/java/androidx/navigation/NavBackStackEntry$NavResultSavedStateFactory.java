/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavBackStackEntry$SavedStateViewModel;
import androidx.savedstate.SavedStateRegistryOwner;

public class NavBackStackEntry$NavResultSavedStateFactory
extends AbstractSavedStateViewModelFactory {
    public NavBackStackEntry$NavResultSavedStateFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        super(savedStateRegistryOwner, bundle);
    }

    public ViewModel create(String object, Class clazz, SavedStateHandle savedStateHandle) {
        object = new NavBackStackEntry$SavedStateViewModel(savedStateHandle);
        return object;
    }
}

