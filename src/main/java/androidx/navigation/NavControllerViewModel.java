/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavControllerViewModel$1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class NavControllerViewModel
extends ViewModel {
    private static final ViewModelProvider$Factory FACTORY;
    private final HashMap mViewModelStores;

    static {
        NavControllerViewModel$1 navControllerViewModel$1 = new NavControllerViewModel$1();
        FACTORY = navControllerViewModel$1;
    }

    public NavControllerViewModel() {
        HashMap hashMap;
        this.mViewModelStores = hashMap = new HashMap();
    }

    public static NavControllerViewModel getInstance(ViewModelStore viewModelStore) {
        ViewModelProvider$Factory viewModelProvider$Factory = FACTORY;
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStore, viewModelProvider$Factory);
        return (NavControllerViewModel)viewModelProvider.get(NavControllerViewModel.class);
    }

    public void clear(UUID object) {
        HashMap hashMap = this.mViewModelStores;
        if ((object = (ViewModelStore)hashMap.remove(object)) != null) {
            ((ViewModelStore)object).clear();
        }
    }

    public ViewModelStore getViewModelStore(UUID uUID) {
        ViewModelStore viewModelStore = (ViewModelStore)this.mViewModelStores.get(uUID);
        if (viewModelStore == null) {
            viewModelStore = new ViewModelStore();
            HashMap hashMap = this.mViewModelStores;
            hashMap.put(uUID, viewModelStore);
        }
        return viewModelStore;
    }

    public void onCleared() {
        boolean bl2;
        Iterator iterator2 = this.mViewModelStores.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            ViewModelStore viewModelStore = (ViewModelStore)iterator2.next();
            viewModelStore.clear();
        }
        this.mViewModelStores.clear();
    }

    public String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder("NavControllerViewModel{");
        int n10 = System.identityHashCode(this);
        Object object = Integer.toHexString(n10);
        stringBuilder.append((String)object);
        stringBuilder.append("} ViewModelStores (");
        object = this.mViewModelStores.keySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            stringBuilder.append(object2);
            bl2 = object.hasNext();
            if (!bl2) continue;
            object2 = ", ";
            stringBuilder.append((String)object2);
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

