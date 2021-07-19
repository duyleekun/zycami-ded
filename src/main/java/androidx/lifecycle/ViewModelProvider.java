/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider$KeyedFactory;
import androidx.lifecycle.ViewModelProvider$NewInstanceFactory;
import androidx.lifecycle.ViewModelProvider$OnRequeryFactory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class ViewModelProvider {
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private final ViewModelProvider$Factory mFactory;
    private final ViewModelStore mViewModelStore;

    public ViewModelProvider(ViewModelStore viewModelStore, ViewModelProvider$Factory viewModelProvider$Factory) {
        this.mFactory = viewModelProvider$Factory;
        this.mViewModelStore = viewModelStore;
    }

    public ViewModelProvider(ViewModelStoreOwner object) {
        ViewModelStore viewModelStore = object.getViewModelStore();
        boolean bl2 = object instanceof HasDefaultViewModelProviderFactory;
        object = bl2 ? ((HasDefaultViewModelProviderFactory)object).getDefaultViewModelProviderFactory() : ViewModelProvider$NewInstanceFactory.getInstance();
        this(viewModelStore, (ViewModelProvider$Factory)object);
    }

    public ViewModelProvider(ViewModelStoreOwner object, ViewModelProvider$Factory viewModelProvider$Factory) {
        object = object.getViewModelStore();
        this((ViewModelStore)object, viewModelProvider$Factory);
    }

    public ViewModel get(Class serializable) {
        String string2 = serializable.getCanonicalName();
        if (string2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            return this.get(string2, (Class)serializable);
        }
        serializable = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        throw serializable;
    }

    public ViewModel get(String object, Class object2) {
        Object object3 = this.mViewModelStore.get((String)object);
        boolean bl2 = ((Class)object2).isInstance(object3);
        if (bl2) {
            object = this.mFactory;
            boolean bl3 = object instanceof ViewModelProvider$OnRequeryFactory;
            if (bl3) {
                object = (ViewModelProvider$OnRequeryFactory)object;
                ((ViewModelProvider$OnRequeryFactory)object).onRequery((ViewModel)object3);
            }
            return object3;
        }
        object3 = this.mFactory;
        bl2 = object3 instanceof ViewModelProvider$KeyedFactory;
        if (bl2) {
            object3 = (ViewModelProvider$KeyedFactory)object3;
            object2 = ((ViewModelProvider$KeyedFactory)object3).create((String)object, (Class)object2);
        } else {
            object2 = object3.create((Class)object2);
        }
        this.mViewModelStore.put((String)object, (ViewModel)object2);
        return object2;
    }
}

