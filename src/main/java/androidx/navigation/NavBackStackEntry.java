/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.os.Bundle
 */
package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry$1;
import androidx.navigation.NavBackStackEntry$NavResultSavedStateFactory;
import androidx.navigation.NavBackStackEntry$SavedStateViewModel;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;

public final class NavBackStackEntry
implements LifecycleOwner,
ViewModelStoreOwner,
HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner {
    private Bundle mArgs;
    private final Context mContext;
    private ViewModelProvider$Factory mDefaultFactory;
    private final NavDestination mDestination;
    private Lifecycle$State mHostLifecycle;
    public final UUID mId;
    private final LifecycleRegistry mLifecycle;
    private Lifecycle$State mMaxLifecycle;
    private NavControllerViewModel mNavControllerViewModel;
    private SavedStateHandle mSavedStateHandle;
    private final SavedStateRegistryController mSavedStateRegistryController;

    public NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel) {
        UUID uUID = UUID.randomUUID();
        this(context, navDestination, bundle, lifecycleOwner, navControllerViewModel, uUID, null);
    }

    public NavBackStackEntry(Context object, NavDestination navDestination, Bundle bundle, LifecycleOwner lifecycleOwner, NavControllerViewModel navControllerViewModel, UUID uUID, Bundle bundle2) {
        Lifecycle$State lifecycle$State;
        Object object2 = new LifecycleRegistry(this);
        this.mLifecycle = object2;
        this.mSavedStateRegistryController = object2 = SavedStateRegistryController.create(this);
        this.mHostLifecycle = lifecycle$State = Lifecycle$State.CREATED;
        this.mMaxLifecycle = lifecycle$State = Lifecycle$State.RESUMED;
        this.mContext = object;
        this.mId = uUID;
        this.mDestination = navDestination;
        this.mArgs = bundle;
        this.mNavControllerViewModel = navControllerViewModel;
        ((SavedStateRegistryController)object2).performRestore(bundle2);
        if (lifecycleOwner != null) {
            object = lifecycleOwner.getLifecycle().getCurrentState();
            this.mHostLifecycle = object;
        }
    }

    private static Lifecycle$State getStateAfter(Lifecycle$Event object) {
        Object object2 = NavBackStackEntry$1.$SwitchMap$androidx$lifecycle$Lifecycle$Event;
        int n10 = object.ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                object2 = new IllegalArgumentException;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected event value ");
                stringBuilder.append(object);
                object = stringBuilder.toString();
                object2((String)object);
                throw object2;
            }
            case 6: {
                return Lifecycle$State.DESTROYED;
            }
            case 5: {
                return Lifecycle$State.RESUMED;
            }
            case 3: 
            case 4: {
                return Lifecycle$State.STARTED;
            }
            case 1: 
            case 2: 
        }
        return Lifecycle$State.CREATED;
    }

    public Bundle getArguments() {
        return this.mArgs;
    }

    public ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        ViewModelProvider$Factory viewModelProvider$Factory = this.mDefaultFactory;
        if (viewModelProvider$Factory == null) {
            Application application = (Application)this.mContext.getApplicationContext();
            Bundle bundle = this.mArgs;
            this.mDefaultFactory = viewModelProvider$Factory = new SavedStateViewModelFactory(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    public NavDestination getDestination() {
        return this.mDestination;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    public Lifecycle$State getMaxLifecycle() {
        return this.mMaxLifecycle;
    }

    public SavedStateHandle getSavedStateHandle() {
        Object object = this.mSavedStateHandle;
        if (object == null) {
            Object object2 = new NavBackStackEntry$NavResultSavedStateFactory(this, null);
            object = new ViewModelProvider(this, (ViewModelProvider$Factory)object2);
            object2 = NavBackStackEntry$SavedStateViewModel.class;
            this.mSavedStateHandle = object = ((NavBackStackEntry$SavedStateViewModel)((ViewModelProvider)object).get((Class)object2)).getHandle();
        }
        return this.mSavedStateHandle;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public ViewModelStore getViewModelStore() {
        Object object = this.mNavControllerViewModel;
        if (object != null) {
            UUID uUID = this.mId;
            return ((NavControllerViewModel)object).getViewModelStore(uUID);
        }
        object = new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
        throw object;
    }

    public void handleLifecycleEvent(Lifecycle$Event enum_) {
        this.mHostLifecycle = enum_ = NavBackStackEntry.getStateAfter((Lifecycle$Event)enum_);
        this.updateState();
    }

    public void replaceArguments(Bundle bundle) {
        this.mArgs = bundle;
    }

    public void saveState(Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    public void setMaxLifecycle(Lifecycle$State lifecycle$State) {
        this.mMaxLifecycle = lifecycle$State;
        this.updateState();
    }

    public void updateState() {
        Lifecycle$State lifecycle$State;
        int n10;
        Object object = this.mHostLifecycle;
        int n11 = object.ordinal();
        if (n11 < (n10 = (lifecycle$State = this.mMaxLifecycle).ordinal())) {
            object = this.mLifecycle;
            lifecycle$State = this.mHostLifecycle;
            ((LifecycleRegistry)object).setCurrentState(lifecycle$State);
        } else {
            object = this.mLifecycle;
            lifecycle$State = this.mMaxLifecycle;
            ((LifecycleRegistry)object).setCurrentState(lifecycle$State);
        }
    }
}

