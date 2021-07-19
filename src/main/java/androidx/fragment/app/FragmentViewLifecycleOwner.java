/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.ContextWrapper
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.app.Application;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

public class FragmentViewLifecycleOwner
implements HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
ViewModelStoreOwner {
    private ViewModelProvider$Factory mDefaultFactory;
    private final Fragment mFragment;
    private LifecycleRegistry mLifecycleRegistry = null;
    private SavedStateRegistryController mSavedStateRegistryController = null;
    private final ViewModelStore mViewModelStore;

    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.mFragment = fragment;
        this.mViewModelStore = viewModelStore;
    }

    public ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider$Factory viewModelProvider$Factory;
        ViewModelProvider$Factory viewModelProvider$Factory2 = this.mFragment.getDefaultViewModelProviderFactory();
        boolean bl2 = viewModelProvider$Factory2.equals(viewModelProvider$Factory = this.mFragment.mDefaultFactory);
        if (!bl2) {
            this.mDefaultFactory = viewModelProvider$Factory2;
            return viewModelProvider$Factory2;
        }
        viewModelProvider$Factory2 = this.mDefaultFactory;
        if (viewModelProvider$Factory2 == null) {
            boolean bl3;
            viewModelProvider$Factory2 = null;
            viewModelProvider$Factory = this.mFragment.requireContext().getApplicationContext();
            while (bl3 = viewModelProvider$Factory instanceof ContextWrapper) {
                bl3 = viewModelProvider$Factory instanceof Application;
                if (bl3) {
                    viewModelProvider$Factory2 = viewModelProvider$Factory;
                    viewModelProvider$Factory2 = (Application)viewModelProvider$Factory;
                    break;
                }
                viewModelProvider$Factory = ((ContextWrapper)viewModelProvider$Factory).getBaseContext();
            }
            Bundle bundle = this.mFragment.getArguments();
            this.mDefaultFactory = viewModelProvider$Factory = new SavedStateViewModelFactory((Application)viewModelProvider$Factory2, this, bundle);
        }
        return this.mDefaultFactory;
    }

    public Lifecycle getLifecycle() {
        this.initialize();
        return this.mLifecycleRegistry;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        this.initialize();
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        this.initialize();
        return this.mViewModelStore;
    }

    public void handleLifecycleEvent(Lifecycle$Event lifecycle$Event) {
        this.mLifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
    }

    public void initialize() {
        Object object = this.mLifecycleRegistry;
        if (object == null) {
            object = new LifecycleRegistry(this);
            this.mLifecycleRegistry = object;
            this.mSavedStateRegistryController = object = SavedStateRegistryController.create(this);
        }
    }

    public boolean isInitialized() {
        boolean bl2;
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        if (lifecycleRegistry != null) {
            bl2 = true;
        } else {
            bl2 = false;
            lifecycleRegistry = null;
        }
        return bl2;
    }

    public void performRestore(Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
    }

    public void performSave(Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    public void setCurrentState(Lifecycle$State lifecycle$State) {
        this.mLifecycleRegistry.setCurrentState(lifecycle$State);
    }
}

