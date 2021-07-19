/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzho;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzic {
    private static final Logger logger = Logger.getLogger(zzhl.class.getName());
    private static String zzxv = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzho zzc(Class object) {
        Object object2;
        Object object3;
        Object[] objectArray = zzic.class;
        ArrayList<Object> arrayList = objectArray.getClassLoader();
        Object object4 = zzho.class;
        int n10 = object.equals(object4);
        int n11 = 1;
        if (n10 != 0) {
            object4 = zzxv;
        } else {
            object4 = ((Class)object).getPackage();
            n10 = object4.equals(object3 = objectArray.getPackage());
            if (n10 == 0) {
                object = ((Class)object).getName();
                objectArray = new IllegalArgumentException((String)object);
                throw objectArray;
            }
            n10 = 2;
            object4 = new Object[n10];
            object3 = ((Class)object).getPackage().getName();
            object4[0] = object3;
            object3 = ((Class)object).getSimpleName();
            object4[n11] = object3;
            object3 = "%s.BlazeGenerated%sLoader";
            object4 = String.format((String)object3, (Object[])object4);
        }
        try {
            object4 = Class.forName((String)object4, n11 != 0, (ClassLoader)((Object)arrayList));
            try {
                object3 = new Class[]{};
                object4 = ((Class)object4).getConstructor((Class<?>)object3);
                object3 = new Object[]{};
                object4 = ((Constructor)object4).newInstance((Object[])object3);
                object4 = (zzic)object4;
                object4 = ((zzic)object4).zzgr();
                object4 = ((Class)object).cast(object4);
                return (zzho)object4;
            }
            catch (InvocationTargetException invocationTargetException) {
                object3 = new IllegalStateException(invocationTargetException);
                throw object3;
            }
            catch (IllegalAccessException illegalAccessException) {
                object3 = new IllegalStateException(illegalAccessException);
                throw object3;
            }
            catch (InstantiationException instantiationException) {
                object3 = new IllegalStateException(instantiationException);
                throw object3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object3 = new IllegalStateException(noSuchMethodException);
                throw object3;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {}
        objectArray = ServiceLoader.load(objectArray, (ClassLoader)((Object)arrayList)).iterator();
        arrayList = new ArrayList<Object>();
        while ((n10 = (int)(objectArray.hasNext() ? 1 : 0)) != 0) {
            try {
                object4 = objectArray.next();
                object4 = (zzic)object4;
                object4 = ((zzic)object4).zzgr();
                object4 = ((Class)object).cast(object4);
                arrayList.add(object4);
            }
            catch (ServiceConfigurationError serviceConfigurationError) {
                Object object5;
                object3 = logger;
                object2 = Level.SEVERE;
                object4 = "Unable to load ";
                String string2 = String.valueOf(((Class)object).getSimpleName());
                int n12 = string2.length();
                if (n12 != 0) {
                    object5 = object4 = ((String)object4).concat(string2);
                } else {
                    string2 = new String((String)object4);
                    object5 = string2;
                }
                string2 = "com.google.protobuf.GeneratedExtensionRegistryLoader";
                String string3 = "load";
                ((Logger)object3).logp((Level)object2, string2, string3, (String)object5, serviceConfigurationError);
            }
        }
        int n13 = arrayList.size();
        if (n13 == n11) {
            return (zzho)arrayList.get(0);
        }
        n13 = arrayList.size();
        n10 = 0;
        object4 = null;
        if (n13 == 0) {
            return null;
        }
        objectArray = "combine";
        try {
            object3 = new Class[n11];
            object3[0] = object2 = Collection.class;
            object = ((Class)object).getMethod((String)objectArray, (Class<?>)object3);
            objectArray = new Object[n11];
            objectArray[0] = arrayList;
            object = ((Method)object).invoke(null, objectArray);
            return (zzho)object;
        }
        catch (InvocationTargetException invocationTargetException) {
            objectArray = new IllegalStateException(invocationTargetException);
            throw objectArray;
        }
        catch (IllegalAccessException illegalAccessException) {
            objectArray = new IllegalStateException(illegalAccessException);
            throw objectArray;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            objectArray = new IllegalStateException(noSuchMethodException);
            throw objectArray;
        }
    }

    public abstract zzho zzgr();
}

