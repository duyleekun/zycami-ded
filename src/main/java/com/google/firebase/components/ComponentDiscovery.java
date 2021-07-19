/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.google.firebase.components;

import android.content.Context;
import android.util.Log;
import com.google.firebase.components.ComponentDiscovery$$Lambda$1;
import com.google.firebase.components.ComponentDiscovery$MetadataRegistrarNameRetriever;
import com.google.firebase.components.ComponentDiscovery$RegistrarNameRetriever;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class ComponentDiscovery {
    private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
    private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
    public static final String TAG = "ComponentDiscovery";
    private final Object context;
    private final ComponentDiscovery$RegistrarNameRetriever retriever;

    public ComponentDiscovery(Object object, ComponentDiscovery$RegistrarNameRetriever componentDiscovery$RegistrarNameRetriever) {
        this.context = object;
        this.retriever = componentDiscovery$RegistrarNameRetriever;
    }

    public static ComponentDiscovery forContext(Context context, Class clazz) {
        ComponentDiscovery$MetadataRegistrarNameRetriever componentDiscovery$MetadataRegistrarNameRetriever = new ComponentDiscovery$MetadataRegistrarNameRetriever(clazz, null);
        ComponentDiscovery componentDiscovery = new ComponentDiscovery(context, componentDiscovery$MetadataRegistrarNameRetriever);
        return componentDiscovery;
    }

    private static ComponentRegistrar instantiate(String string2) {
        Object object;
        Object object2;
        int n10;
        String string3;
        Object[] objectArray;
        block17: {
            objectArray = "Could not instantiate %s";
            string3 = "Could not instantiate %s.";
            n10 = 1;
            object2 = Class.forName(string2);
            object = ComponentRegistrar.class;
            boolean bl2 = object.isAssignableFrom((Class<?>)object2);
            if (!bl2) break block17;
            object = new Class[]{};
            object2 = ((Class)object2).getDeclaredConstructor((Class<?>)object);
            object = new Object[]{};
            object2 = ((Constructor)object2).newInstance(object);
            return (ComponentRegistrar)object2;
        }
        object = "Class %s is not an instance of %s";
        int n11 = 2;
        Object[] objectArray2 = new Object[n11];
        objectArray2[0] = string2;
        String string4 = COMPONENT_SENTINEL_VALUE;
        objectArray2[n10] = string4;
        object = String.format((String)object, objectArray2);
        try {
            object2 = new InvalidRegistrarException((String)object);
            throw object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            Object[] objectArray3 = new Object[n10];
            objectArray3[0] = string2;
            string2 = String.format((String)objectArray, objectArray3);
            object2 = new InvalidRegistrarException(string2, invocationTargetException);
            throw object2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Object[] objectArray4 = new Object[n10];
            objectArray4[0] = string2;
            string2 = String.format((String)objectArray, objectArray4);
            object2 = new InvalidRegistrarException(string2, noSuchMethodException);
            throw object2;
        }
        catch (InstantiationException instantiationException) {
            Object[] objectArray5 = new Object[n10];
            objectArray5[0] = string2;
            string2 = String.format(string3, objectArray5);
            object2 = new InvalidRegistrarException(string2, instantiationException);
            throw object2;
        }
        catch (IllegalAccessException illegalAccessException) {
            Object[] objectArray6 = new Object[n10];
            objectArray6[0] = string2;
            string2 = String.format(string3, objectArray6);
            object2 = new InvalidRegistrarException(string2, illegalAccessException);
            throw object2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            objectArray = new Object[n10];
            objectArray[0] = string2;
            string2 = String.format("Class %s is not an found.", objectArray);
            Log.w((String)TAG, (String)string2);
            return null;
        }
    }

    public static /* synthetic */ ComponentRegistrar lambda$discoverLazy$0(String string2) {
        return ComponentDiscovery.instantiate(string2);
    }

    public List discover() {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.retriever;
        Object object2 = this.context;
        object = object.retrieve(object2).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            if ((object2 = ComponentDiscovery.instantiate((String)object2)) == null) continue;
            try {
                arrayList.add(object2);
            }
            catch (InvalidRegistrarException invalidRegistrarException) {
                String string2 = TAG;
                String string3 = "Invalid component registrar.";
                Log.w((String)string2, (String)string3, (Throwable)invalidRegistrarException);
            }
        }
        return arrayList;
    }

    public List discoverLazy() {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.retriever;
        Object object2 = this.context;
        object = object.retrieve(object2).iterator();
        while (bl2 = object.hasNext()) {
            object2 = ComponentDiscovery$$Lambda$1.lambdaFactory$((String)object.next());
            arrayList.add(object2);
        }
        return arrayList;
    }
}

