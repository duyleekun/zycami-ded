/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.savedstate.Recreator$SavedStateProvider;
import androidx.savedstate.SavedStateRegistry$1;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import java.util.Map;

public final class SavedStateRegistry {
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    public boolean mAllowingSavingState;
    private SafeIterableMap mComponents;
    private Recreator$SavedStateProvider mRecreatorProvider;
    private boolean mRestored;
    private Bundle mRestoredState;

    public SavedStateRegistry() {
        SafeIterableMap safeIterableMap;
        this.mComponents = safeIterableMap = new SafeIterableMap();
        this.mAllowingSavingState = true;
    }

    public Bundle consumeRestoredStateForKey(String object) {
        boolean bl2 = this.mRestored;
        if (bl2) {
            Bundle bundle = this.mRestoredState;
            if (bundle != null) {
                bundle = bundle.getBundle((String)object);
                Bundle bundle2 = this.mRestoredState;
                bundle2.remove((String)object);
                object = this.mRestoredState;
                boolean bl3 = object.isEmpty();
                if (bl3) {
                    this.mRestoredState = null;
                }
                return bundle;
            }
            return null;
        }
        object = new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        throw object;
    }

    public boolean isRestored() {
        return this.mRestored;
    }

    public void performRestore(Lifecycle object, Bundle object2) {
        boolean bl2 = this.mRestored;
        if (!bl2) {
            if (object2 != null) {
                String string2 = SAVED_COMPONENTS_KEY;
                this.mRestoredState = object2 = object2.getBundle(string2);
            }
            object2 = new SavedStateRegistry$1(this);
            ((Lifecycle)object).addObserver((LifecycleObserver)object2);
            this.mRestored = true;
            return;
        }
        object = new IllegalStateException("SavedStateRegistry was already restored.");
        throw object;
    }

    public void performSave(Bundle bundle) {
        boolean bl2;
        Bundle bundle2 = new Bundle();
        Object object = this.mRestoredState;
        if (object != null) {
            bundle2.putAll((Bundle)object);
        }
        object = this.mComponents.iteratorWithAdditions();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            String string2 = (String)entry.getKey();
            entry = ((SavedStateRegistry$SavedStateProvider)entry.getValue()).saveState();
            bundle2.putBundle(string2, (Bundle)entry);
        }
        bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
    }

    public void registerSavedStateProvider(String object, SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider) {
        SafeIterableMap safeIterableMap = this.mComponents;
        if ((object = (SavedStateRegistry$SavedStateProvider)safeIterableMap.putIfAbsent(object, savedStateRegistry$SavedStateProvider)) == null) {
            return;
        }
        object = new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        throw object;
    }

    public void runOnNextRecreation(Class object) {
        boolean bl2 = this.mAllowingSavingState;
        if (bl2) {
            Object object2 = this.mRecreatorProvider;
            if (object2 == null) {
                object2 = new Recreator$SavedStateProvider(this);
                this.mRecreatorProvider = object2;
            }
            bl2 = false;
            object2 = null;
            try {
                object2 = new Class[]{};
            }
            catch (NoSuchMethodException noSuchMethodException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Class");
                object = ((Class)object).getSimpleName();
                stringBuilder.append((String)object);
                stringBuilder.append(" must have default constructor in order to be automatically recreated");
                object = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object, noSuchMethodException);
                throw illegalArgumentException;
            }
            ((Class)object).getDeclaredConstructor((Class<?>)object2);
            object2 = this.mRecreatorProvider;
            object = ((Class)object).getName();
            ((Recreator$SavedStateProvider)object2).add((String)object);
            return;
        }
        object = new IllegalStateException("Can not perform this action after onSaveInstanceState");
        throw object;
    }

    public void unregisterSavedStateProvider(String string2) {
        this.mComponents.remove(string2);
    }
}

