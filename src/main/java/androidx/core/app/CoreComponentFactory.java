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
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.core.app.CoreComponentFactory$CompatWrapped;

public class CoreComponentFactory
extends AppComponentFactory {
    public static Object checkCompatWrapper(Object object) {
        boolean bl2 = object instanceof CoreComponentFactory$CompatWrapped;
        if (bl2) {
            Object object2 = object;
            object2 = ((CoreComponentFactory$CompatWrapped)object).getWrapper();
            if (object2 != null) {
                return object2;
            }
        }
        return object;
    }

    public Activity instantiateActivity(ClassLoader classLoader, String string2, Intent intent) {
        return (Activity)CoreComponentFactory.checkCompatWrapper(super.instantiateActivity(classLoader, string2, intent));
    }

    public Application instantiateApplication(ClassLoader classLoader, String string2) {
        return (Application)CoreComponentFactory.checkCompatWrapper(super.instantiateApplication(classLoader, string2));
    }

    public ContentProvider instantiateProvider(ClassLoader classLoader, String string2) {
        return (ContentProvider)CoreComponentFactory.checkCompatWrapper(super.instantiateProvider(classLoader, string2));
    }

    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String string2, Intent intent) {
        return (BroadcastReceiver)CoreComponentFactory.checkCompatWrapper(super.instantiateReceiver(classLoader, string2, intent));
    }

    public Service instantiateService(ClassLoader classLoader, String string2, Intent intent) {
        return (Service)CoreComponentFactory.checkCompatWrapper(super.instantiateService(classLoader, string2, intent));
    }
}

