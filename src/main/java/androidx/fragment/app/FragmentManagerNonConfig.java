/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import java.util.Collection;
import java.util.Map;

public class FragmentManagerNonConfig {
    private final Map mChildNonConfigs;
    private final Collection mFragments;
    private final Map mViewModelStores;

    public FragmentManagerNonConfig(Collection collection, Map map, Map map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    public Map getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    public Collection getFragments() {
        return this.mFragments;
    }

    public Map getViewModelStores() {
        return this.mViewModelStores;
    }

    public boolean isRetaining(Fragment fragment) {
        Collection collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}

