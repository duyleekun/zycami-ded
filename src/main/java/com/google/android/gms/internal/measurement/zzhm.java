/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzhe;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzhm {
    private static final Logger zza = Logger.getLogger(zzgz.class.getName());
    private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzhe zzb(Class object) {
        Object object2;
        Object[] objectArray = zzhm.class;
        ArrayList<Object> arrayList = objectArray.getClassLoader();
        Object object3 = zzhe.class;
        int n10 = object.equals(object3);
        int n11 = 1;
        if (n10 != 0) {
            object3 = zzb;
        } else {
            object3 = ((Class)object).getPackage();
            n10 = object3.equals(object2 = objectArray.getPackage());
            if (n10 == 0) {
                object = ((Class)object).getName();
                objectArray = new IllegalArgumentException((String)object);
                throw objectArray;
            }
            n10 = 2;
            object3 = new Object[n10];
            object2 = ((Class)object).getPackage().getName();
            object3[0] = object2;
            object2 = ((Class)object).getSimpleName();
            object3[n11] = object2;
            object2 = "%s.BlazeGenerated%sLoader";
            object3 = String.format((String)object2, (Object[])object3);
        }
        try {
            object3 = Class.forName((String)object3, n11 != 0, (ClassLoader)((Object)arrayList));
            try {
                object2 = new Class[]{};
                object3 = ((Class)object3).getConstructor((Class<?>)object2);
                object2 = new Object[]{};
                object3 = ((Constructor)object3).newInstance((Object[])object2);
                object3 = (zzhm)object3;
                object3 = ((zzhm)object3).zza();
                object3 = ((Class)object).cast(object3);
                return (zzhe)object3;
            }
            catch (InvocationTargetException invocationTargetException) {
                object2 = new IllegalStateException(invocationTargetException);
                throw object2;
            }
            catch (IllegalAccessException illegalAccessException) {
                object2 = new IllegalStateException(illegalAccessException);
                throw object2;
            }
            catch (InstantiationException instantiationException) {
                object2 = new IllegalStateException(instantiationException);
                throw object2;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object2 = new IllegalStateException(noSuchMethodException);
                throw object2;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {}
        objectArray = ServiceLoader.load(objectArray, (ClassLoader)((Object)arrayList)).iterator();
        arrayList = new ArrayList<Object>();
        while ((n10 = (int)(objectArray.hasNext() ? 1 : 0)) != 0) {
            try {
                object3 = objectArray.next();
                object3 = (zzhm)object3;
                object3 = ((zzhm)object3).zza();
                object3 = ((Class)object).cast(object3);
                arrayList.add(object3);
            }
            catch (ServiceConfigurationError serviceConfigurationError) {
                object2 = zza;
                Level level = Level.SEVERE;
                object3 = String.valueOf(((Class)object).getSimpleName());
                String string2 = "Unable to load ";
                int n12 = ((String)object3).length();
                object3 = n12 != 0 ? string2.concat((String)object3) : new String(string2);
                string2 = "com.google.protobuf.GeneratedExtensionRegistryLoader";
                String string3 = "load";
                ((Logger)object2).logp(level, string2, string3, (String)object3, serviceConfigurationError);
            }
        }
        int n13 = arrayList.size();
        if (n13 == n11) {
            return (zzhe)arrayList.get(0);
        }
        n13 = arrayList.size();
        n10 = 0;
        object3 = null;
        if (n13 == 0) {
            return null;
        }
        try {
            objectArray = new Class[n11];
            object2 = Collection.class;
            objectArray[0] = object2;
            object2 = "combine";
            object = ((Class)object).getMethod((String)object2, (Class<?>[])objectArray);
            objectArray = new Object[n11];
            objectArray[0] = arrayList;
            object = ((Method)object).invoke(null, objectArray);
            return (zzhe)object;
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

    public abstract zzhe zza();
}

