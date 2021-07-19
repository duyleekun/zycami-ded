/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AppComponentFactory
 *  android.app.Application
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentProvider
 *  android.content.Intent
 */
package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.core.app.CoreComponentFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppComponentFactory
extends android.app.AppComponentFactory {
    public final Activity instantiateActivity(ClassLoader classLoader, String string2, Intent intent) {
        return (Activity)CoreComponentFactory.checkCompatWrapper(this.instantiateActivityCompat(classLoader, string2, intent));
    }

    /*
     * WARNING - void declaration
     */
    public Activity instantiateActivityCompat(ClassLoader genericDeclaration, String objectArray, Intent intent) {
        void var1_4;
        genericDeclaration = Class.forName((String)objectArray, false, (ClassLoader)((Object)genericDeclaration));
        objectArray = Activity.class;
        genericDeclaration = genericDeclaration.asSubclass(objectArray);
        objectArray = new Class[]{};
        genericDeclaration = genericDeclaration.getDeclaredConstructor((Class<?>[])objectArray);
        objectArray = new Object[]{};
        genericDeclaration = ((Constructor)genericDeclaration).newInstance(objectArray);
        try {
            return (Activity)genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        objectArray = new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
        throw objectArray;
    }

    public final Application instantiateApplication(ClassLoader classLoader, String string2) {
        return (Application)CoreComponentFactory.checkCompatWrapper(this.instantiateApplicationCompat(classLoader, string2));
    }

    /*
     * WARNING - void declaration
     */
    public Application instantiateApplicationCompat(ClassLoader genericDeclaration, String objectArray) {
        void var1_4;
        genericDeclaration = Class.forName((String)objectArray, false, (ClassLoader)((Object)genericDeclaration));
        objectArray = Application.class;
        genericDeclaration = genericDeclaration.asSubclass(objectArray);
        objectArray = new Class[]{};
        genericDeclaration = genericDeclaration.getDeclaredConstructor((Class<?>[])objectArray);
        objectArray = new Object[]{};
        genericDeclaration = ((Constructor)genericDeclaration).newInstance(objectArray);
        try {
            return (Application)genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        objectArray = new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
        throw objectArray;
    }

    public final ContentProvider instantiateProvider(ClassLoader classLoader, String string2) {
        return (ContentProvider)CoreComponentFactory.checkCompatWrapper(this.instantiateProviderCompat(classLoader, string2));
    }

    /*
     * WARNING - void declaration
     */
    public ContentProvider instantiateProviderCompat(ClassLoader genericDeclaration, String objectArray) {
        void var1_4;
        genericDeclaration = Class.forName((String)objectArray, false, (ClassLoader)((Object)genericDeclaration));
        objectArray = ContentProvider.class;
        genericDeclaration = genericDeclaration.asSubclass(objectArray);
        objectArray = new Class[]{};
        genericDeclaration = genericDeclaration.getDeclaredConstructor((Class<?>[])objectArray);
        objectArray = new Object[]{};
        genericDeclaration = ((Constructor)genericDeclaration).newInstance(objectArray);
        try {
            return (ContentProvider)genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        objectArray = new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
        throw objectArray;
    }

    public final BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String string2, Intent intent) {
        return (BroadcastReceiver)CoreComponentFactory.checkCompatWrapper(this.instantiateReceiverCompat(classLoader, string2, intent));
    }

    /*
     * WARNING - void declaration
     */
    public BroadcastReceiver instantiateReceiverCompat(ClassLoader genericDeclaration, String objectArray, Intent intent) {
        void var1_4;
        genericDeclaration = Class.forName((String)objectArray, false, (ClassLoader)((Object)genericDeclaration));
        objectArray = BroadcastReceiver.class;
        genericDeclaration = genericDeclaration.asSubclass(objectArray);
        objectArray = new Class[]{};
        genericDeclaration = genericDeclaration.getDeclaredConstructor((Class<?>[])objectArray);
        objectArray = new Object[]{};
        genericDeclaration = ((Constructor)genericDeclaration).newInstance(objectArray);
        try {
            return (BroadcastReceiver)genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        objectArray = new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
        throw objectArray;
    }

    public final Service instantiateService(ClassLoader classLoader, String string2, Intent intent) {
        return (Service)CoreComponentFactory.checkCompatWrapper(this.instantiateServiceCompat(classLoader, string2, intent));
    }

    /*
     * WARNING - void declaration
     */
    public Service instantiateServiceCompat(ClassLoader genericDeclaration, String objectArray, Intent intent) {
        void var1_4;
        genericDeclaration = Class.forName((String)objectArray, false, (ClassLoader)((Object)genericDeclaration));
        objectArray = Service.class;
        genericDeclaration = genericDeclaration.asSubclass(objectArray);
        objectArray = new Class[]{};
        genericDeclaration = genericDeclaration.getDeclaredConstructor((Class<?>[])objectArray);
        objectArray = new Object[]{};
        genericDeclaration = ((Constructor)genericDeclaration).newInstance(objectArray);
        try {
            return (Service)genericDeclaration;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
            // empty catch block
        }
        objectArray = new RuntimeException("Couldn't call constructor", (Throwable)var1_4);
        throw objectArray;
    }
}

