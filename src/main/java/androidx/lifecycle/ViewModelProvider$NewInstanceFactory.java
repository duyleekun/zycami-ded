/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;

public class ViewModelProvider$NewInstanceFactory
implements ViewModelProvider$Factory {
    private static ViewModelProvider$NewInstanceFactory sInstance;

    public static ViewModelProvider$NewInstanceFactory getInstance() {
        ViewModelProvider$NewInstanceFactory viewModelProvider$NewInstanceFactory = sInstance;
        if (viewModelProvider$NewInstanceFactory == null) {
            sInstance = viewModelProvider$NewInstanceFactory = new ViewModelProvider$NewInstanceFactory();
        }
        return sInstance;
    }

    public ViewModel create(Class object) {
        String string2 = "Cannot create an instance of ";
        Object t10 = ((Class)object).newInstance();
        try {
            return (ViewModel)t10;
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object, illegalAccessException);
            throw runtimeException;
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object, instantiationException);
            throw runtimeException;
        }
    }
}

