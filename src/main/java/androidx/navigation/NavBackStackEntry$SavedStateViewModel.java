/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class NavBackStackEntry$SavedStateViewModel
extends ViewModel {
    private SavedStateHandle mHandle;

    public NavBackStackEntry$SavedStateViewModel(SavedStateHandle savedStateHandle) {
        this.mHandle = savedStateHandle;
    }

    public SavedStateHandle getHandle() {
        return this.mHandle;
    }
}

