/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package d.v.c.x1;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$NewInstanceFactory;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class m
extends ViewModelProvider$NewInstanceFactory {
    private static m b;
    private static WeakReference c;
    private Application a;

    private m(Application object, Object ... objectArray) {
        this.a = object;
        super(objectArray);
        c = object;
    }

    public static m a(Application object, Object ... objectArray) {
        m m10 = b;
        if (m10 == null) {
            b = m10 = new m((Application)object, objectArray);
        } else {
            m10.a = object;
            object = new WeakReference(objectArray);
            c = object;
        }
        return b;
    }

    public static m b(Object ... objectArray) {
        Object object = b;
        if (object == null) {
            object = new Object(null, objectArray);
            b = object;
        } else {
            c = object = new Object(objectArray);
        }
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ViewModel create(Class object) {
        Class<Object[]> clazz = Object[].class;
        Object[] objectArray = (Object[])c.get();
        Object object2 = AndroidViewModel.class;
        int n10 = ((Class)object2).isAssignableFrom((Class<?>)object);
        int n11 = 1;
        String string2 = "Cannot create an instance of ";
        if (n10 != 0) {
            n10 = 2;
            try {
                Class<Application> clazz2;
                Application application = new Class[n10];
                application[0] = clazz2 = Application.class;
                application[n11] = clazz;
                Constructor constructor = ((Class)object).getConstructor((Class<?>)application);
                object2 = new Object[n10];
                application = this.a;
                object2[0] = application;
                object2[n11] = objectArray;
                Object t10 = constructor.newInstance((Object[])object2);
                return (ViewModel)t10;
            }
            catch (InvocationTargetException invocationTargetException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                objectArray = new RuntimeException((String)object, invocationTargetException);
                throw objectArray;
            }
            catch (InstantiationException instantiationException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                objectArray = new RuntimeException((String)object, instantiationException);
                throw objectArray;
            }
            catch (IllegalAccessException illegalAccessException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                objectArray = new RuntimeException((String)object, illegalAccessException);
                throw objectArray;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                objectArray = new RuntimeException((String)object, noSuchMethodException);
                throw objectArray;
            }
        }
        try {
            n10 = objectArray.length;
            if (n10 == n11) {
                Class[] classArray = new Class[n11];
                classArray[0] = object2 = Object.class;
                Constructor constructor = ((Class)object).getConstructor(classArray);
                Object t11 = constructor.newInstance(objectArray);
                return (ViewModel)t11;
            }
            object2 = new Class[n11];
            object2[0] = clazz;
            Constructor constructor = ((Class)object).getConstructor((Class<?>)object2);
            Object t12 = constructor.newInstance(objectArray);
            return (ViewModel)t12;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            objectArray = new RuntimeException((String)object, invocationTargetException);
            throw objectArray;
        }
        catch (InstantiationException instantiationException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            objectArray = new RuntimeException((String)object, instantiationException);
            throw objectArray;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            objectArray = new RuntimeException((String)object, illegalAccessException);
            throw objectArray;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            objectArray = new RuntimeException((String)object, noSuchMethodException);
            throw objectArray;
        }
    }
}

