/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.savedstate;

import android.view.View;
import androidx.savedstate.R$id;
import androidx.savedstate.SavedStateRegistryOwner;

public final class ViewTreeSavedStateRegistryOwner {
    private ViewTreeSavedStateRegistryOwner() {
    }

    public static SavedStateRegistryOwner get(View view) {
        boolean bl2;
        int n10 = R$id.view_tree_saved_state_registry_owner;
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner)view.getTag(n10);
        if (savedStateRegistryOwner != null) {
            return savedStateRegistryOwner;
        }
        view = view.getParent();
        while (savedStateRegistryOwner == null && (bl2 = view instanceof View)) {
            n10 = R$id.view_tree_saved_state_registry_owner;
            savedStateRegistryOwner = (SavedStateRegistryOwner)view.getTag(n10);
            view = view.getParent();
        }
        return savedStateRegistryOwner;
    }

    public static void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        int n10 = R$id.view_tree_saved_state_registry_owner;
        view.setTag(n10, (Object)savedStateRegistryOwner);
    }
}

