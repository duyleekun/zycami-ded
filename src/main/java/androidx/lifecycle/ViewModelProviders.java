/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;

public class ViewModelProviders {
    public static ViewModelProvider of(Fragment fragment) {
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragment);
        return viewModelProvider;
    }

    public static ViewModelProvider of(Fragment object, ViewModelProvider$Factory viewModelProvider$Factory) {
        if (viewModelProvider$Factory == null) {
            viewModelProvider$Factory = ((Fragment)object).getDefaultViewModelProviderFactory();
        }
        object = ((Fragment)object).getViewModelStore();
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStore)object, viewModelProvider$Factory);
        return viewModelProvider;
    }

    public static ViewModelProvider of(FragmentActivity fragmentActivity) {
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragmentActivity);
        return viewModelProvider;
    }

    public static ViewModelProvider of(FragmentActivity object, ViewModelProvider$Factory viewModelProvider$Factory) {
        if (viewModelProvider$Factory == null) {
            viewModelProvider$Factory = ((ComponentActivity)object).getDefaultViewModelProviderFactory();
        }
        object = ((ComponentActivity)object).getViewModelStore();
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStore)object, viewModelProvider$Factory);
        return viewModelProvider;
    }
}

