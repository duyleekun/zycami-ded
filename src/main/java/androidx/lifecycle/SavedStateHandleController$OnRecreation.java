/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry$AutoRecreated;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Iterator;

public final class SavedStateHandleController$OnRecreation
implements SavedStateRegistry$AutoRecreated {
    public void onRecreated(SavedStateRegistryOwner object) {
        boolean bl2 = object instanceof ViewModelStoreOwner;
        if (bl2) {
            boolean bl3;
            Object object2 = object;
            object2 = ((ViewModelStoreOwner)object).getViewModelStore();
            SavedStateRegistry savedStateRegistry = ((SavedStateRegistryOwner)object).getSavedStateRegistry();
            Iterator iterator2 = ((ViewModelStore)object2).keys().iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object3 = (String)iterator2.next();
                object3 = ((ViewModelStore)object2).get((String)object3);
                Lifecycle lifecycle = ((LifecycleOwner)object).getLifecycle();
                SavedStateHandleController.attachHandleIfNeeded((ViewModel)object3, savedStateRegistry, lifecycle);
            }
            object = ((ViewModelStore)object2).keys();
            boolean bl4 = object.isEmpty();
            if (!bl4) {
                object = SavedStateHandleController$OnRecreation.class;
                savedStateRegistry.runOnNextRecreation((Class)object);
            }
            return;
        }
        object = new Object("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        throw object;
    }
}

