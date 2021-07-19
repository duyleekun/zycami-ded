/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.savedstate;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class Recreator$SavedStateProvider
implements SavedStateRegistry$SavedStateProvider {
    public final Set mClasses;

    public Recreator$SavedStateProvider(SavedStateRegistry savedStateRegistry) {
        HashSet hashSet;
        this.mClasses = hashSet = new HashSet();
        savedStateRegistry.registerSavedStateProvider("androidx.savedstate.Restarter", this);
    }

    public void add(String string2) {
        this.mClasses.add(string2);
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Set set = this.mClasses;
        ArrayList arrayList = new ArrayList(set);
        bundle.putStringArrayList("classes_to_restore", arrayList);
        return bundle;
    }
}

