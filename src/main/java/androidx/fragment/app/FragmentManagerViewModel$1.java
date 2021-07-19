/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;

public class FragmentManagerViewModel$1
implements ViewModelProvider$Factory {
    public ViewModel create(Class object) {
        object = new FragmentManagerViewModel(true);
        return object;
    }
}

