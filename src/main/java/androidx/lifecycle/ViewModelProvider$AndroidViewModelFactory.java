/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$NewInstanceFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider$AndroidViewModelFactory
extends ViewModelProvider$NewInstanceFactory {
    private static ViewModelProvider$AndroidViewModelFactory sInstance;
    private Application mApplication;

    public ViewModelProvider$AndroidViewModelFactory(Application application) {
        this.mApplication = application;
    }

    public static ViewModelProvider$AndroidViewModelFactory getInstance(Application application) {
        ViewModelProvider$AndroidViewModelFactory viewModelProvider$AndroidViewModelFactory = sInstance;
        if (viewModelProvider$AndroidViewModelFactory == null) {
            sInstance = viewModelProvider$AndroidViewModelFactory = new ViewModelProvider$AndroidViewModelFactory(application);
        }
        return sInstance;
    }

    public ViewModel create(Class object) {
        String string2 = "Cannot create an instance of ";
        Object object2 = AndroidViewModel.class;
        int n10 = (int)(object2.isAssignableFrom((Class<?>)object) ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            Object object3 = new Class[n10];
            Object object4 = Application.class;
            object3[0] = object4;
            object3 = ((Class)object).getConstructor((Class<?>)object3);
            object2 = new Object[n10];
            object4 = this.mApplication;
            object2[0] = object4;
            object2 = ((Constructor)object3).newInstance(object2);
            try {
                return (ViewModel)object2;
            }
            catch (InvocationTargetException invocationTargetException) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append(object);
                object = ((StringBuilder)object4).toString();
                object3 = new RuntimeException((String)object, invocationTargetException);
                throw object3;
            }
            catch (InstantiationException instantiationException) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append(object);
                object = ((StringBuilder)object4).toString();
                object3 = new RuntimeException((String)object, instantiationException);
                throw object3;
            }
            catch (IllegalAccessException illegalAccessException) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append(object);
                object = ((StringBuilder)object4).toString();
                object3 = new RuntimeException((String)object, illegalAccessException);
                throw object3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append(object);
                object = ((StringBuilder)object4).toString();
                object3 = new RuntimeException((String)object, noSuchMethodException);
                throw object3;
            }
        }
        return super.create((Class)object);
    }
}

