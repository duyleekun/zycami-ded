/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ViewModelStore {
    private final HashMap mMap;

    public ViewModelStore() {
        HashMap hashMap;
        this.mMap = hashMap = new HashMap();
    }

    public final void clear() {
        boolean bl2;
        Iterator iterator2 = this.mMap.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            ViewModel viewModel = (ViewModel)iterator2.next();
            viewModel.clear();
        }
        this.mMap.clear();
    }

    public final ViewModel get(String string2) {
        return (ViewModel)this.mMap.get(string2);
    }

    public Set keys() {
        Set set = this.mMap.keySet();
        HashSet hashSet = new HashSet(set);
        return hashSet;
    }

    public final void put(String object, ViewModel viewModel) {
        HashMap hashMap = this.mMap;
        if ((object = hashMap.put(object, viewModel)) != null) {
            ((ViewModel)object).onCleared();
        }
    }
}

