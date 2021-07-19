/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MetadataBackendRegistry$BackendFactoryProvider {
    private final Context applicationContext;
    private Map backendProviders = null;

    public MetadataBackendRegistry$BackendFactoryProvider(Context context) {
        this.applicationContext = context;
    }

    private Map discover(Context context) {
        boolean bl2;
        if ((context = MetadataBackendRegistry$BackendFactoryProvider.getMetadata(context)) == null) {
            Log.w((String)"BackendRegistry", (String)"Could not retrieve metadata, returning empty list of transport backends.");
            return Collections.emptyMap();
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator iterator2 = context.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2;
            String string3 = (String)iterator2.next();
            String[] stringArray = context.get(string3);
            int n10 = stringArray instanceof String;
            if (n10 == 0 || (n10 = string3.startsWith(string2 = "backend:")) == 0) continue;
            stringArray = ((String)stringArray).split(",", -1);
            n10 = stringArray.length;
            for (int i10 = 0; i10 < n10; ++i10) {
                String string4 = stringArray[i10].trim();
                int n11 = string4.isEmpty();
                if (n11 != 0) continue;
                n11 = 8;
                String string5 = string3.substring(n11);
                hashMap.put(string4, string5);
            }
        }
        return hashMap;
    }

    private Map getBackendProviders() {
        Map map = this.backendProviders;
        if (map == null) {
            map = this.applicationContext;
            this.backendProviders = map = this.discover((Context)map);
        }
        return this.backendProviders;
    }

    private static Bundle getMetadata(Context object) {
        block9: {
            PackageManager packageManager;
            String string2;
            block8: {
                string2 = "BackendRegistry";
                try {
                    packageManager = object.getPackageManager();
                    if (packageManager != null) break block8;
                    object = "Context has no PackageManager.";
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    Log.w((String)string2, (String)"Application info not found.");
                    return null;
                }
                Log.w((String)string2, (String)object);
                return null;
            }
            Class<TransportBackendDiscovery> clazz = TransportBackendDiscovery.class;
            ComponentName componentName = new ComponentName(object, clazz);
            int n10 = 128;
            object = packageManager.getServiceInfo(componentName, n10);
            if (object != null) break block9;
            object = "TransportBackendDiscovery has no service info.";
            Log.w((String)string2, (String)object);
            return null;
        }
        return object.metaData;
    }

    public BackendFactory get(String string2) {
        String string3 = "Could not instantiate %s";
        Object[] objectArray = "Could not instantiate %s.";
        String string4 = "BackendRegistry";
        string2 = (String)this.getBackendProviders().get(string2);
        if (string2 == null) {
            return null;
        }
        int n10 = 1;
        GenericDeclaration genericDeclaration = Class.forName(string2);
        Object[] objectArray2 = BackendFactory.class;
        genericDeclaration = genericDeclaration.asSubclass(objectArray2);
        objectArray2 = new Class[]{};
        genericDeclaration = genericDeclaration.getDeclaredConstructor((Class<?>[])objectArray2);
        objectArray2 = new Object[]{};
        genericDeclaration = ((Constructor)genericDeclaration).newInstance(objectArray2);
        try {
            return (BackendFactory)((Object)genericDeclaration);
        }
        catch (InvocationTargetException invocationTargetException) {
            Object[] objectArray3 = new Object[n10];
            objectArray3[0] = string2;
            string2 = String.format(string3, objectArray3);
            Log.w((String)string4, (String)string2, (Throwable)invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Object[] objectArray4 = new Object[n10];
            objectArray4[0] = string2;
            string2 = String.format(string3, objectArray4);
            Log.w((String)string4, (String)string2, (Throwable)noSuchMethodException);
        }
        catch (InstantiationException instantiationException) {
            Object[] objectArray5 = new Object[n10];
            objectArray5[0] = string2;
            string2 = String.format((String)objectArray, objectArray5);
            Log.w((String)string4, (String)string2, (Throwable)instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Object[] objectArray6 = new Object[n10];
            objectArray6[0] = string2;
            string2 = String.format((String)objectArray, objectArray6);
            Log.w((String)string4, (String)string2, (Throwable)illegalAccessException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            objectArray = new Object[n10];
            objectArray[0] = string2;
            string2 = String.format("Class %s is not found.", objectArray);
            Log.w((String)string4, (String)string2, (Throwable)classNotFoundException);
        }
        return null;
    }
}

