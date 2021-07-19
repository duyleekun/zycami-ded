/*
 * Decompiled with CFR 0.151.
 */
package androidx.savedstate;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry$AutoRecreated;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class Recreator
implements GenericLifecycleObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    private final SavedStateRegistryOwner mOwner;

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void reflectiveNew(String object) {
        Object object2;
        Object[] objectArray;
        Object object22 = Recreator.class;
        try {
            object22 = ((Class)object22).getClassLoader();
            objectArray = null;
            object22 = Class.forName((String)object, false, (ClassLoader)object22);
            object2 = SavedStateRegistry$AutoRecreated.class;
            object22 = ((Class)object22).asSubclass(object2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class ");
            stringBuilder.append((String)object);
            stringBuilder.append(" wasn't found");
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object, classNotFoundException);
            throw runtimeException;
        }
        try {
            object2 = new Class[]{};
            object22 = ((Class)object22).getDeclaredConstructor((Class<?>)object2);
            boolean bl2 = true;
            ((Constructor)object22).setAccessible(bl2);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Class");
            object22 = ((Class)object22).getSimpleName();
            ((StringBuilder)object2).append((String)object22);
            ((StringBuilder)object2).append(" must have default constructor in order to be automatically recreated");
            object22 = ((StringBuilder)object2).toString();
            objectArray = new IllegalStateException((String)object22, noSuchMethodException);
            throw objectArray;
        }
        try {
            objectArray = new Object[]{};
            object22 = ((Constructor)object22).newInstance(objectArray);
            object22 = (SavedStateRegistry$AutoRecreated)object22;
            object = this.mOwner;
            object22.onRecreated((SavedStateRegistryOwner)object);
            return;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to instantiate ");
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            objectArray = new RuntimeException((String)object, exception);
            throw objectArray;
        }
    }

    public void onStateChanged(LifecycleOwner iterator2, Lifecycle$Event object) {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_CREATE;
        if (object == lifecycle$Event) {
            iterator2.getLifecycle().removeObserver(this);
            iterator2 = this.mOwner.getSavedStateRegistry();
            object = COMPONENT_KEY;
            iterator2 = ((SavedStateRegistry)((Object)iterator2)).consumeRestoredStateForKey((String)object);
            if (iterator2 == null) {
                return;
            }
            object = CLASSES_KEY;
            if ((iterator2 = iterator2.getStringArrayList((String)object)) != null) {
                boolean bl2;
                iterator2 = ((ArrayList)((Object)iterator2)).iterator();
                while (bl2 = iterator2.hasNext()) {
                    object = (String)iterator2.next();
                    this.reflectiveNew((String)object);
                }
                return;
            }
            iterator2 = new Iterator("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            throw iterator2;
        }
        iterator2 = new Iterator((Object)"Next event must be ON_CREATE");
        throw iterator2;
    }
}

