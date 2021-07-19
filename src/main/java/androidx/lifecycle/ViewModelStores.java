/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;

public class ViewModelStores {
    private ViewModelStores() {
    }

    public static ViewModelStore of(Fragment fragment) {
        return fragment.getViewModelStore();
    }

    public static ViewModelStore of(FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }
}

