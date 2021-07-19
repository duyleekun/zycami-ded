/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider$KeyedFactory;
import androidx.lifecycle.ViewModelProvider$NewInstanceFactory;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class SavedStateViewModelFactory
extends ViewModelProvider$KeyedFactory {
    private static final Class[] ANDROID_VIEWMODEL_SIGNATURE;
    private static final Class[] VIEWMODEL_SIGNATURE;
    private final Application mApplication;
    private final Bundle mDefaultArgs;
    private final ViewModelProvider$Factory mFactory;
    private final Lifecycle mLifecycle;
    private final SavedStateRegistry mSavedStateRegistry;

    static {
        Class<SavedStateHandle> clazz = SavedStateHandle.class;
        Class[] classArray = new Class[2];
        classArray[0] = Application.class;
        int n10 = 1;
        classArray[n10] = clazz;
        ANDROID_VIEWMODEL_SIGNATURE = classArray;
        classArray = new Class[n10];
        classArray[0] = clazz;
        VIEWMODEL_SIGNATURE = classArray;
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
    }

    public SavedStateViewModelFactory(Application object, SavedStateRegistryOwner object2, Bundle bundle) {
        SavedStateRegistry savedStateRegistry;
        this.mSavedStateRegistry = savedStateRegistry = object2.getSavedStateRegistry();
        this.mLifecycle = object2 = object2.getLifecycle();
        this.mDefaultArgs = bundle;
        this.mApplication = object;
        object = object != null ? ViewModelProvider$AndroidViewModelFactory.getInstance(object) : ViewModelProvider$NewInstanceFactory.getInstance();
        this.mFactory = object;
    }

    private static Constructor findMatchingConstructor(Class constructorArray, Class[] classArray) {
        for (Constructor<?> constructor : constructorArray.getConstructors()) {
            Object[] objectArray = constructor.getParameterTypes();
            boolean bl2 = Arrays.equals(classArray, objectArray);
            if (!bl2) continue;
            return constructor;
        }
        return null;
    }

    public ViewModel create(Class serializable) {
        String string2 = serializable.getCanonicalName();
        if (string2 != null) {
            return this.create(string2, (Class)serializable);
        }
        serializable = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        throw serializable;
    }

    public ViewModel create(String object, Class object2) {
        Object object3;
        Object object4;
        block20: {
            int n10;
            Object object5;
            block19: {
                object4 = AndroidViewModel.class;
                boolean bl2 = object4.isAssignableFrom((Class<?>)object2);
                if (bl2 && (object3 = this.mApplication) != null) {
                    object3 = ANDROID_VIEWMODEL_SIGNATURE;
                    object3 = SavedStateViewModelFactory.findMatchingConstructor((Class)object2, (Class[])object3);
                } else {
                    object3 = VIEWMODEL_SIGNATURE;
                    object3 = SavedStateViewModelFactory.findMatchingConstructor((Class)object2, (Class[])object3);
                }
                if (object3 == null) {
                    return this.mFactory.create((Class)object2);
                }
                SavedStateRegistry savedStateRegistry = this.mSavedStateRegistry;
                object5 = this.mLifecycle;
                Object[] objectArray = this.mDefaultArgs;
                object = SavedStateHandleController.create(savedStateRegistry, (Lifecycle)object5, (String)object, (Bundle)objectArray);
                savedStateRegistry = null;
                n10 = 1;
                if (bl2) {
                    object4 = this.mApplication;
                    if (object4 == null) break block19;
                    int n11 = 2;
                    objectArray = new Object[n11];
                    objectArray[0] = object4;
                    object4 = ((SavedStateHandleController)object).getHandle();
                    objectArray[n10] = object4;
                    object4 = ((Constructor)object3).newInstance(objectArray);
                    object4 = (ViewModel)object4;
                    break block20;
                }
            }
            object4 = new Object[n10];
            object5 = ((SavedStateHandleController)object).getHandle();
            object4[0] = object5;
            object4 = ((Constructor)object3).newInstance(object4);
            object4 = (ViewModel)object4;
        }
        object3 = "androidx.lifecycle.savedstate.vm.tag";
        try {
            object4.setTagIfAbsent((String)object3, object);
            return object4;
        }
        catch (InvocationTargetException invocationTargetException) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("An exception happened in constructor of ");
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            Throwable throwable = invocationTargetException.getCause();
            object4 = new RuntimeException((String)object2, throwable);
            throw object4;
        }
        catch (InstantiationException instantiationException) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("A ");
            ((StringBuilder)object3).append(object2);
            ((StringBuilder)object3).append(" cannot be instantiated.");
            object2 = ((StringBuilder)object3).toString();
            object4 = new RuntimeException((String)object2, instantiationException);
            throw object4;
        }
        catch (IllegalAccessException illegalAccessException) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Failed to access ");
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object4 = new RuntimeException((String)object2, illegalAccessException);
            throw object4;
        }
    }

    public void onRequery(ViewModel viewModel) {
        SavedStateRegistry savedStateRegistry = this.mSavedStateRegistry;
        Lifecycle lifecycle = this.mLifecycle;
        SavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
    }
}

